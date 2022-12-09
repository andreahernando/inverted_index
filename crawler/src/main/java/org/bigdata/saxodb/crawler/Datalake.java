package org.bigdata.saxodb.crawler;

import java.io.FileNotFoundException;
import java.io.IOException;

public interface Datalake {
    void store(Document document) throws IOException;
}
