package org.bigdata.saxodb.crawler;

import java.util.List;

public class Document {
    private String[] metadata;
    private String text;


    public String[] getMetadata() {
        return metadata;
    }

    public void setMetadata(List<String> metadata) {
        this.metadata = metadata.toArray(new String[0]);
    }

    public String getText() {
        return text;
    }


    public void setText(String text) {
        this.text = text;
    }

}
