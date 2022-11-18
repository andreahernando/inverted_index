package org.bigdata.saxodb.indexer;

import java.util.List;
import java.util.Map;
import java.util.TreeSet;

public class TextInvertedIndex implements InvertedIndex{
    public Map<String, TreeSet<String>> inverted(List<String> words, String docid, Map<String, TreeSet<String>> inverted) {
        words.forEach(w->{
            if (!inverted.containsKey(w)) {
                inverted.put(w.toLowerCase(), new TreeSet<>());
            }
            inverted.get(w.toLowerCase()).add(docid);
        });
        inverted.remove("");
        return inverted;
    }
}
