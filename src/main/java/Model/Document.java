package Model;

public class Document {
    public Metadata metadata;
    public String content;

    public Metadata getMetadata() {
        return metadata;
    }

    public Document setMetadata(Metadata metadata) {
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
