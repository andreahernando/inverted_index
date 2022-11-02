package Model;

import java.util.List;

public class GutenbergDocumentBuilder implements DocumentBuilder {

    private List<String> arrayText;

    public GutenbergDocumentBuilder(List<String> arrayText) {
        this.arrayText = arrayText;
    }

    public Document build() throws Exception {
        Document document = new Document();
        //Metadata metadata = new GutenbergMetadataBuilder(this.arrayText.get(0));
        document.setMetadata(this.arrayText.get(0))
                .setContent(this.arrayText.get(2));
        return document;
    }
}
