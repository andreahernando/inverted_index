package org.bigdata.saxodb.indexer;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) throws IOException {
        Map<String, TreeSet<String>> finalinverted = new HashMap<>();
        String text = "";
        String docid = "doc1";
        Tokenizer tokenizer = new DocumentTokenizer();
        Analyser analyser = new TextAnalyser();
        InvertedIndex invertedIndex = new TextInvertedIndex();
        Datamart datamart = new InvertedIndexDatamart();

        IndexerTask task = new IndexerTask(tokenizer, analyser, invertedIndex, datamart);
        task.index(text, docid, finalinverted);


    }
}
