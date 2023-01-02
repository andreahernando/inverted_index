package org.bigdata.saxodb.engine;

import spark.Request;
import spark.Response;
import spark.Route;

import java.util.Objects;

public class GetStats implements Route {
    @Override
    public Object handle(Request request, Response response) throws Exception {
        if (Objects.equals(request.params(":type"), "metadata")) {
            return metadataStats(request);
        } else if (Objects.equals(request.params(":type"), "documents")) {
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

    private Object metadataStats (Request request) {
        String result = null;
        try {
            String type = request.params("metadata");
            result = Html.begin()
                    + Html.tag("h1", "Se vino por este de aquí")
                    + Html.end();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}
