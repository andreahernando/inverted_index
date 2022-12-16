package org.bigdata.saxodb.crawler;

import org.bigdata.saxodb.Document;

import java.io.IOException;

public interface Datalake {
    void store(Document document) throws IOException;
}
