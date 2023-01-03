package org.bigdata.saxodb.engine;

import spark.Request;
import spark.Response;
import spark.Route;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.*;

public class GetStats implements Route {
    @Override
    public Object handle(Request request, Response response) throws Exception {
        String stats = request.params(":type");
        String dbName = "..\\SaxoDB\\src\\main\\java\\org\\bigdata\\saxodb\\table.db";
        String connectionURL = "jdbc:sqlite:" + dbName;

        if (Objects.equals(stats, "author")) {
            return authorStats(connectionURL);
        } else if (Objects.equals(stats, "word")) {
            return wordStats();
        }
        return Html.begin()
                + Html.tag("h1", "404 not found")
                + Html.end();
    }

    public String wordStats() throws Exception {
        try {
            MapDeserialization mapDeserialization = new MapDeserialization();
            Map<String, TreeSet<String>> inverted = mapDeserialization.GetMap("..\\SaxoDB\\src\\main\\java\\org\\bigdata\\saxodb\\inverted.data");
            List<TreeSet<String>> longestList = new ArrayList<>();
            longestList.add(new TreeSet<>());
            List<String> palabras = new ArrayList<>();
            for (Iterator<Map.Entry<String, TreeSet<String>>> entradas = inverted.entrySet().iterator();entradas.hasNext();) {
                Map.Entry<String, TreeSet<String>> entrada = entradas.next();
                if(entrada.getValue().size() > longestList.get(0).size()) {
                    longestList.clear();
                    palabras.clear();
                    longestList.add(entrada.getValue());
                    palabras.add(entrada.getKey());
                } else if (entrada.getValue().size() == longestList.get(0).size()) {
                    longestList.add(entrada.getValue());
                    palabras.add(entrada.getKey());
                }
            }
            return Html.begin()
                    + Html.tag("h1", String.valueOf(palabras))
                    + Html.end();

        } catch (Exception e){
            return Html.begin()
                    + Html.tag("h1", e.getMessage())
                    + Html.end();
        }
    }

    private Object authorStats (String connectionURL) {
        try (Connection conn = DriverManager.getConnection(connectionURL)) {
            Statement stmt = conn.createStatement();

            String author = "author";
            String query = "SELECT author, COUNT(author) FROM Metadata GROUP BY author HAVING COUNT(author) > 1";

            ResultSet rs = stmt.executeQuery(query);
            String request = rs.getString(author);

            return Html.begin()
                    + Html.tag("h1", request)
                    + Html.end();

        }  catch (Exception e){
            return Html.begin()
                    + Html.tag("h1", e.getMessage())
                    + Html.end();
        }
    }
}
