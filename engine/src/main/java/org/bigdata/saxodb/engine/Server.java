package org.bigdata.saxodb.engine;

import spark.Spark;

public class Server {
    public static void init() {
        Spark.port(8080);

        Spark.get("/param1/:param", new GetParam());
    }
}
