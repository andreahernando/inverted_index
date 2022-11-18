package org.bigdata.saxodb.indexer;

import java.util.ArrayList;
import java.util.List;

public class DocumentTokenizer implements Tokenizer{
    public List<String> tokenize(String text) {
        return new ArrayList<String>(List.of(text.replaceAll("\\p{Digit}|\\p{Punct}", "").split("\\s")));
    }
}
