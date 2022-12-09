package org.bigdata.saxodb.engine;

import spark.Request;
import spark.Response;
import spark.Route;

public class GetHistory implements Route {
    @Override
    public Object handle(Request request, Response response) throws Exception {
        try {
            String nameContent = request.params("nameContent");

            return Html.begin()
                    + Html.tag("h1", nameContent)
                    + Html.end();


        }  catch (Exception e){
            return Html.begin()
                    + Html.tag("h1", e.getMessage())
                    + Html.end();
        }
    }
}
