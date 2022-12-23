package org.bigdata.saxodb.engine;

import spark.Request;
import spark.Response;
import spark.Route;

import java.sql.*;

public class GetParam implements Route {
    @Override
    public Object handle(Request request, Response response) throws Exception {

        String nameContent = request.params("param");

        String dbName = "C:/Users/andre/IdeaProjects/SaxoDB/src/main/java/org/bigdata/saxodb/table.db";


        // URL de conexión a la base de datos
        String connectionURL = "jdbc:sqlite:" + dbName;


        // Establecemos la conexión con la base de datos
        try (Connection conn = DriverManager.getConnection(connectionURL)) {

            // Creamos un objeto Statement
            Statement stmt = conn.createStatement();

            // Definimos la consulta SQL
            String query = "SELECT * FROM " + "Metadata";

            // Ejecutamos la consulta y obtenemos el resultado en un objeto ResultSet
            ResultSet rs = stmt.executeQuery(query);
            String campo1 = rs.getString(nameContent);



            return Html.begin()
                    + Html.tag("h1", campo1)
                    + Html.end();


        }  catch (Exception e){
            return Html.begin()
                    + Html.tag("h1", e.getMessage())
                    + Html.end();
        }
    }
}
