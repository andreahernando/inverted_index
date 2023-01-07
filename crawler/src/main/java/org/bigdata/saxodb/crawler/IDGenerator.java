package org.bigdata.saxodb.crawler;

import java.util.concurrent.atomic.AtomicInteger;

public class IDGenerator {
    private static AtomicInteger id = new AtomicInteger(22);

    public IDGenerator() {
    }

    public Integer generateID() {
        return id.incrementAndGet();
    }
}