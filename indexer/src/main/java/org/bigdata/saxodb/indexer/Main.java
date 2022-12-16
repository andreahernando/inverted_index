package org.bigdata.saxodb.indexer;

import java.io.IOException;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Map<String, TreeSet<String>> finalinverted = new HashMap<>();
        String path = "C:\\Users\\andre\\IdeaProjects\\SaxoDB\\crawler\\datalake\\20221212 1617.txt";
        String path2 = "C:\\Users\\andre\\IdeaProjects\\SaxoDB\\crawler\\datalake\\20221212 1618.txt";
        String path3 = "C:\\Users\\andre\\IdeaProjects\\SaxoDB\\crawler\\datalake\\20221212 1619.txt";
        String path4 = "C:\\Users\\andre\\IdeaProjects\\SaxoDB\\crawler\\datalake\\20221212 1620.txt";
        List<Document> documentList = new DocumentDeserialize().getDocument();

        Document doc = new DocumentBuilder().build(path);
        Document doc2 = new DocumentBuilder().build(path2);
        Document doc3 = new DocumentBuilder().build(path3);
        Document doc4 = new DocumentBuilder().build(path4);
        String text = doc.getText();
        String text2 = doc2.getText();
        String text3 = doc3.getText();
        String text4 = doc4.getText();
        String docid = "doc1";
        String docid2 = "doc2";
        String docid3 = "doc3";
        String docid4 = "doc4";
        Tokenizer tokenizer = new DocumentTokenizer();
        Analyser analyser = new TextAnalyser();
        InvertedBuilder invertedIndex = new TextInvertedIndex();
        Datamart datamart = new InvertedIndexDatamart();

        IndexerTask task = new IndexerTask(tokenizer, analyser, invertedIndex, datamart);
        task.index(text, docid, finalinverted);

        IndexerTask task2 = new IndexerTask(tokenizer, analyser, invertedIndex, datamart);
        task2.index(text2, docid2, finalinverted);

        IndexerTask task3 = new IndexerTask(tokenizer, analyser, invertedIndex, datamart);
        task3.index(text3, docid3, finalinverted);

        IndexerTask task4 = new IndexerTask(tokenizer, analyser, invertedIndex, datamart);
        task4.index(text4, docid4, finalinverted);
        System.out.println(finalinverted);


    }
}
