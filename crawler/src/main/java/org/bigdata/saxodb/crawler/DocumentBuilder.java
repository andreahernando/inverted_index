package org.bigdata.saxodb.crawler;
public class DocumentBuilder implements Builder{
    private String[] textParts;

    public DocumentBuilder(String text) {
        textParts = text.split("\\*\\*\\*");

    }

    @Override
    public Document build() {
        Document doc = new Document();
        doc.setText(textParts[2]);
        return doc;
    }

}
