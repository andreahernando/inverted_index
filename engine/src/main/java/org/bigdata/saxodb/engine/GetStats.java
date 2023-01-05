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
    public Object handle(Request request, Response response) {
        try {
            String stats = request.params(":type");
            String dbName = "..\\SaxoDB\\src\\main\\java\\org\\bigdata\\saxodb\\table.db";
            String connectionURL = "jdbc:sqlite:" + dbName;

            if (Objects.equals(stats, "author")) {
                return authorStats(connectionURL);
            } else if (Objects.equals(stats, "word")) {
                return wordStats();
            }
        } catch (Exception e) {
            return Html.begin()
                    + Html.tag("h1", e.getMessage())
                    + Html.end();
        }
        return null;
    }

    private Object authorStats (String connectionURL) {
        try (Connection conn = DriverManager.getConnection(connectionURL)) {
            Statement stmt = conn.createStatement();

            String query = "SELECT author, COUNT(author) as count FROM Metadata GROUP BY author HAVING COUNT(author) > 1";

            ResultSet rs = stmt.executeQuery(query);
            String author_request = rs.getString("author");
            String count_request = rs.getString("count");

            return "{\"authors\": \"" + author_request + "\" ,\"occurrences\": " + count_request + "}";

        } catch (Exception e){
            return Html.begin()
                    + Html.tag("h1", e.getMessage())
                    + Html.end();
        }
    }

    public String wordStats() {
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
                    palabras.add("\"" + entrada.getKey() + "\"");
                } else if (entrada.getValue().size() == longestList.get(0).size()) {
                    longestList.add(entrada.getValue());
                    palabras.add("\"" + entrada.getKey() + "\"");
                }
            }
            return "{\"words\": " + palabras + " ,\"appearances\": " + longestList.get(longestList.size() - 1).size() + "}";

        } catch (Exception e){
            return Html.begin()
                    + Html.tag("h1", e.getMessage())
                    + Html.end();
        }
    }
}
