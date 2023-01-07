package org.bigdata.saxodb.indexer;

import org.bigdata.saxodb.Document;

import java.io.IOException;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Map<String, TreeSet<String>> finalinverted = new HashMap<>();

        List<Document> documentList = new DocumentDeserialize().getDocument();

        Tokenizer tokenizer = new DocumentTokenizer();
        Analyser analyser = new TextAnalyser();
        InvertedBuilder invertedIndex = new TextInvertedIndex();
        Datamart datamart = new InvertedIndexDatamart();
        int i = 1;
        for (Document doc:documentList) {
            String text = doc.getText();
            IndexerTask task = new IndexerTask(tokenizer,analyser, invertedIndex,datamart);
            task.index(text, String.valueOf(i++),finalinverted);

        }

        System.out.println(finalinverted);


    }
}
