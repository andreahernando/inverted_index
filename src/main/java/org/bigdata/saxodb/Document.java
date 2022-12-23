package org.bigdata.saxodb;

public class Document {
    private Metadata metadata;
    private String text;


    public Metadata getMetadata() {
        return metadata;
    }

    public void setMetadata(Metadata metadata) {
        this.metadata = metadata;
    }

    public String getText() {
        return text;
    }


    public void setText(String text) {
        this.text = text;
    }

}
