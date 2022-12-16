package org.bigdata.saxodb.crawler;

import java.util.ArrayList;
import java.util.List;

public class DocumentBuilder implements Builder{
    private String[] textParts;
    private String[] metadata_list;
    private String metadata = "Title: El libro de la selva\nAuthor: Andrea Hernando\nLanguage: español";

    public DocumentBuilder(String text) {
        textParts = text.split("\\*\\*\\*");

    }

    @Override
    public Document build() {
        Document doc = new Document();
        doc.setMetadata(MetadataBuilder(textParts[0]));
        doc.setText(textParts[2]);
        return doc;
    }

    public Metadata MetadataBuilder(String metadata) {
        List<String> finalMetadata = new ArrayList<>();
        metadata_list = metadata.split("\n");
        for (int i = 0; i < metadata_list.length; i++) {
            String[] temporal = metadata_list[i].split(": ");
            if (temporal.length ==2) {
                finalMetadata.add(temporal[1]);
            }
        }
        finalMetadata.forEach(System.out::println);
        return new Metadata(finalMetadata.get(0), finalMetadata.get(1),finalMetadata.get(2)
        ,finalMetadata.get(3),finalMetadata.get(4));


    }


}
