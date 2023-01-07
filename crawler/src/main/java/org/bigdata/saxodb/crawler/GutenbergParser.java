package org.bigdata.saxodb.crawler;

import org.bigdata.saxodb.Document;

public class GutenbergParser implements Parser {
    private String[] textParts;


    @Override
    public Document parse(String text) {
        Document doc = new Document();
        doc.setText(text);
        return doc;
    }
}
