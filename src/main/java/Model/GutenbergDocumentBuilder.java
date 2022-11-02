package Model;

import java.util.List;

public class GutenbergDocumentBuilder implements DocumentBuilder {

    private List<String> arrayText;

    public GutenbergDocumentBuilder(List<String> arrayText) {
        this.arrayText = arrayText;
    }

    /*public Document build() {
        Document document = new Document();
        //Metadata metadata = new GutenbergMetadataBuilder(this.arrayText.get(0));
        //document.setMetadata(metadata)
        //        .setContent(this.extractContent());
        //return document;
    }

    private String extractContent() {
        String content = this.arrayText[2];
        return content;
    }*/
}
