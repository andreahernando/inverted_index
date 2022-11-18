package InvertedIndex;

import Model.SplitText;

import java.io.IOException;

public class BuildIndexer {
    String content;

    public BuildIndexer(String content) {
        this.content = content;
    }

    public Indexer build() throws IOException {
        Indexer indexer = new Indexer(SplitText.spliText(content).get(2));
        return indexer;
    }


}
