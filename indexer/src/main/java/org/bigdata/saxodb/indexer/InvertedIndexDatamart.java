package org.bigdata.saxodb.indexer;

import java.util.Map;
import java.util.TreeSet;

public class InvertedIndexDatamart implements Datamart{
    @Override
    public void store(Map<String, TreeSet<String>> invertedindex) {

        System.out.println(invertedindex);
    }
}
