package org.bigdata.saxodb.crawler;

import java.util.List;

public class DocumentBuilder implements Builder{
    private String[] textParts;
    private String[] metadata_list;

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

    public String[] MetadataBuilder(String metadata) {
        String[] finalMetadata = new String[0];
        metadata_list = metadata.split("\n");
        for (int i = 0; i < metadata_list.length; i++) {
            finalMetadata = metadata_list[i].split(": ");
            System.out.println(finalMetadata);
        }

        return finalMetadata;

    }

}
