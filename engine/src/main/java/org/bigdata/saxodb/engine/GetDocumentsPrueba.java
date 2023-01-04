package org.bigdata.saxodb.engine;

import spark.Request;
import spark.Response;
import spark.Route;
import java.sql.*;
import java.util.*;

public class GetDocumentsPrueba implements Route {
    @Override
    public Object handle(Request request, Response response) throws Exception {
        String word = request.params(":word");
        String author1 = request.params("author");
        MapDeserialization mapDeserialization = new MapDeserialization();
        Map inverted = mapDeserialization.GetMap("..\\SaxoDB\\src\\main\\java\\org\\bigdata\\saxodb\\inverted.data");

        try {
            TreeSet<String> result = (TreeSet)inverted.get(word);
            String url = "jdbc:sqlite:..\\SaxoDB\\src\\main\\java\\org\\bigdata\\saxodb\\table.db";
            String sql = "SELECT * FROM Metadata WHERE id = ? AND author = ?";

            Iterator<String> iterator = result.iterator();
            List<String> results = new ArrayList<>();

            while(iterator.hasNext()) {
                String element = iterator.next();
                Connection conn = DriverManager.getConnection(url);
                PreparedStatement stmt = conn.prepareStatement(sql);
                stmt.setString(1,element);
                stmt.setString(2, "August Strindberg");
                ResultSet rs = stmt.executeQuery();
                results.add(rs.getString("title"));

            }


            return Html.begin()
                    + Html.tag("h1", String.valueOf(results))
                    + Html.tag("h2", author1)
                    + Html.end();

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
