package org.bigdata.saxodb.indexer;

import java.io.IOException;
import java.util.List;

public interface Analyser {
    List<String> analyse(List<String> text) throws IOException;
}
