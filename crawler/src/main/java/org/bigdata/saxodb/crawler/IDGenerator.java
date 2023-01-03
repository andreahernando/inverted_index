package org.bigdata.saxodb.crawler;

import java.util.concurrent.atomic.AtomicInteger;

public class IDGenerator {
    private static AtomicInteger id = new AtomicInteger(0);

    public IDGenerator() {
    }

    public Integer generateID() {
        return id.incrementAndGet();
    }
}