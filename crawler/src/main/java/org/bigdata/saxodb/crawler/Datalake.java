package org.bigdata.saxodb.crawler;

import java.io.IOException;

public interface Datalake {
    void store(Document document) throws IOException;
}
