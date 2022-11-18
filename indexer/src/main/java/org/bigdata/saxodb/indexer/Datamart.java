package org.bigdata.saxodb.indexer;

import java.util.Map;
import java.util.TreeSet;

public interface Datamart {
    void store(Map<String, TreeSet<String>> invertedindex);
}
