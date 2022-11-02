package Model;

public class Document {
    public String metadata;
    public String content;

    public String getMetadata() {
        return metadata;
    }

    public Document setMetadata(String metadata) {
        this.metadata = metadata;
        return this;
    }

    public String getContent() {
        return content;
    }

    public Document setContent(String content) {
        this.content = content;
        return this;
    }
}
