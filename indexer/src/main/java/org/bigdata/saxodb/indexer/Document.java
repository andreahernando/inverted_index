package org.bigdata.saxodb.indexer;

import java.io.File;

public class Document {
    private String text;




    public String getText() {
        return text;
    }


    public Document setText(String text) {
        this.text = text;
        return this;
    }
}