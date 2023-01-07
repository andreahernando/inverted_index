package org.bigdata.saxodb.indexer;

import java.io.IOException;
import java.util.Map;
import java.util.TreeSet;

public class IndexerTask {
    private final Tokenizer tokenizer;
    private final Analyser analyser;
    private final InvertedBuilder invertedIndex;
    private final Datamart datamart;

    public IndexerTask(Tokenizer tokenizer, Analyser analyser, InvertedBuilder invertedIndex, Datamart datamart) {
        this.tokenizer = tokenizer;
        this.analyser = analyser;
        this.invertedIndex = invertedIndex;
        this.datamart = datamart;
    }


    public void index(String text, String docid, Map<String, TreeSet<String>> inverted) throws IOException {
        datamart.store(invertedIndex.inverted(analyser.analyse(tokenizer.tokenize(text)),docid, inverted));
    }

}
