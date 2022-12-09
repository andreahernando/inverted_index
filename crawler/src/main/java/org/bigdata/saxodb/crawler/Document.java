package org.bigdata.saxodb.crawler;

public class Document {
    private String[] metadata;
    private String text;


    public String[] getMetadata() {
        return metadata;
    }

    public void setMetadata(String[] metadata) {
        this.metadata = metadata;
    }

    public String getText() {
        return text;
    }


    public void setText(String text) {
        this.text = text;
    }

}
