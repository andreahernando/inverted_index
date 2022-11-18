package org.bigdata.saxodb.indexer;

import java.util.List;
import java.util.Map;
import java.util.TreeSet;

public interface InvertedIndex {
    Map<String, TreeSet<String>> inverted(List<String> words, String docid, Map<String, TreeSet<String>> inverted);
}
