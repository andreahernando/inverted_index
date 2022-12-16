package org.bigdata.saxodb.indexer;

import org.bigdata.saxodb.Document;

import java.io.File;
import java.io.FileNotFoundException;

public class DocumentBuilder extends Document {
    private FileReader filereader;

    public DocumentBuilder() {
        this.filereader = new FileReader();
    }

    public Document build(String path) throws FileNotFoundException {
        //String [] filesDocument = new File(path).list();
        Document doc = new Document().setText(filereader.read(new File(path)));

        return doc;
    }
}
