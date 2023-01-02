package org.bigdata.saxodb.engine;

import spark.Request;
import spark.Response;
import spark.Route;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Objects;

public class GetStats implements Route {
    @Override
    public Object handle(Request request, Response response) throws Exception {
        String stats = request.params(":type");
        String dbName = "../SaxoDB/src/main/java/org/bigdata/saxodb/table.db";
        String connectionURL = "jdbc:sqlite:" + dbName;

        if (Objects.equals(stats, "metadata")) {
            return metadataStats(connectionURL);
        } else if (Objects.equals(stats, "documents")) {
            return documentStats(request);
        }
        return Html.begin()
                + Html.tag("h1", "404 not found")
                + Html.end();
    }

    public String documentStats(Request request) throws Exception {
        String result = null;
        try {
            String type = request.params("documents");
            result = Html.begin()
                    + Html.tag("h1", "Entró por aquí")
                    + Html.end();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    private Object metadataStats (String connectionURL) {
        try (Connection conn = DriverManager.getConnection(connectionURL)) {
            Statement stmt = conn.createStatement();

            String author = "author";
            String query = "SELECT author COUNT(author) FROM Metadata GROUP BY author HAVING COUNT(author) > 1";

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
