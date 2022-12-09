package org.bigdata.saxodb.engine;

import org.bigdata.saxodb.engine.GetHistory;
import spark.Spark;

public class Server {
    public static void init() {
        Spark.port(8080);

        Spark.get("/name/:nameContent", new GetHistory());
    }
}
