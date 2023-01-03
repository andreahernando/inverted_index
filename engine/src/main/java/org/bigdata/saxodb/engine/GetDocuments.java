package org.bigdata.saxodb.engine;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeSet;
import spark.Request;
import spark.Response;
import spark.Route;

public class GetDocuments implements Route {
    @Override
    public Object handle(Request request, Response response) throws Exception {
        String word = request.params(":word");
        String author1 = request.queryParams("author");
        MapDeserialization mapDeserialization = new MapDeserialization();
        Map inverted = mapDeserialization.GetMap("..\\SaxoDB\\src\\main\\java\\org\\bigdata\\saxodb\\inverted.data");

        try {
            TreeSet<String> result = (TreeSet)inverted.get(word);
            String url = "jdbc:sqlite:..\\SaxoDB\\src\\main\\java\\org\\bigdata\\saxodb\\table.db";
            String sql = "SELECT * FROM Metadata WHERE id = ?";
            Iterator<String> iterator = result.iterator();

            ArrayList resultados;
            ArrayList parcial;
            for(resultados = new ArrayList(); iterator.hasNext(); resultados.add(parcial)) {
                String element = (String)iterator.next();
                Connection conn = DriverManager.getConnection(url);
                PreparedStatement stmt = conn.prepareStatement(sql);
                stmt.setString(1, element);
                //stmt.setString(2, author1);
                ResultSet rs = stmt.executeQuery();
                parcial = new ArrayList();
                if (rs.next()) {
                    parcial.add("Title: " + rs.getString("title"));
                    parcial.add(rs.getString("author"));
                    parcial.add(rs.getString("language"));
                    parcial.add(rs.getString("releaseDate"));
                    parcial.add(rs.getString("postingDate"));
                }
            }

            return resultados;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
