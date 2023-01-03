package org.bigdata.saxodb.indexer;

import org.bigdata.saxodb.Document;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class DocumentDeserialize {

    public static final File DOCUMENT_DIRECTORY = new File("..\\SaxoDB\\crawler\\datalake");

    public List<Document> getDocument() throws FileNotFoundException {
        List<Document> documents = new ArrayList<>();
        for (String docDirectory:DOCUMENT_DIRECTORY.list()) {
            Document doc = new DocumentBuilder()
                    .build(DOCUMENT_DIRECTORY + "/" + docDirectory);
            documents.add(doc);
        }
        return documents;
    }
}
