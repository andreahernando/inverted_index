package org.bigdata.saxodb.engine;

import spark.Request;
import spark.Response;
import spark.Route;

import java.util.Map;
import java.util.TreeSet;

public class GetDocuments implements Route {
    @Override
    public Object handle(Request request, Response response) throws Exception {
        String word = request.params("word");
        MapDeserialization mapDeserialization = new MapDeserialization();
        Map<String, TreeSet<String>> inverted = mapDeserialization.GetMap("../SaxoDB/src/main/java/org/bigdata/saxodb/inverted.data");




        try {
            String result = String.valueOf(inverted.get(word));
            if (result == null) {
                result = "Esa palabra no está en nuestra base de datos";
                return Html.begin()
                        + Html.tag("h1", result)
                        + Html.end();
            }
            return Html.begin()
                    + Html.tag("h1", result)
                    + Html.end();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;


    }
}
