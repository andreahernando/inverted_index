package org.bigdata.saxodb.engine;

import spark.Spark;

public class Server {

    // http://localhost:8080

    public static void init() {
        Spark.port(8080);
        //Spark.get("/documents/:word?from=:date1&to=:date2&author=:author", new GetParam());
        Spark.get("/documents/:word", new GetDocuments());
        Spark.get("/stats/:type", new GetStats());
    }
}
