package org.bigdata.saxodb.indexer;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class TextAnalyser implements Analyser{
    public List<String> analyse(List<String> words) {
        List<String> finaltxt = new ArrayList<String>();
        words.forEach(w -> {
            try {
                if (clean(w.toLowerCase()) != "") {
                    finaltxt.add(w.toLowerCase());
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        return finaltxt;
    }

    public String clean(String word) throws IOException {
        List<String> stopwords = Files.readAllLines(Paths.get("C:\\Users\\andre\\Desktop\\Andre Uni\\Tercero\\BD\\english_stopwords.txt"));
        if (stopwords.contains(word)) {
            return "";
        }
        return word;
    }
}
