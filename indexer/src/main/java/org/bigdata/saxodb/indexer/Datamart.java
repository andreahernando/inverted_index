package org.bigdata.saxodb.indexer;

public interface Datamart {
    void store(InvertedIndex invertedindex);
    void store(Metadata metadata);
}
