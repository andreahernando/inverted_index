package Model;

import java.util.List;

public class GutenbergDocumentBuilder implements DocumentBuilder {

    private List<String> arrayText;

    public GutenbergDocumentBuilder(List<String> arrayText) {
        this.arrayText = arrayText;
    }

    public Document build() {
        Document document = new Document();
        Metadata metadata = new Metadata(this.arrayText.get(0)) {
            @Override
            public Metadata extractMetadata() {
                return null;
            }
        };
        document.setMetadata(metadata)
                .setContent(this.extractContent());
        return document;
    }

    private String extractContent() {
        String content = this.arrayText.get(2);
        return content;
    }
}
