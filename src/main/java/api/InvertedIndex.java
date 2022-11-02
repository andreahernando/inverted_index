package api;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class InvertedIndex {
    public static void invertedIndex(String str) throws IOException {
        Map<String, HashSet<Integer>> wordDocMap = new HashMap<String, HashSet<Integer>>();
        String str2 = str.replaceAll("\\p{Punct}", ""); //remove punctuation from String
        List<String> stopwords = Files.readAllLines(Paths.get("C:\\Users\\andre\\Desktop\\Andre Uni\\Tercero\\BD\\english_stopwords.txt")); //remove stopwords
        String[] lines = str2.split("\n");

        Integer line = 1;
        for (String linea : lines) {
            for (String word : linea.split(" ")) {
                if (!stopwords.contains(word.toLowerCase(Locale.ROOT))) {
                    if (!wordDocMap.containsKey(word.toLowerCase())) {
                        wordDocMap.put(word.toLowerCase(), new HashSet<Integer>() );
                    }
                    wordDocMap.get(word.toLowerCase()).add(line);
                }
            }
            line += 1;
        }
        wordDocMap.remove("");
        System.out.println(wordDocMap);

        //Map<String, List<Integer>> inverted = new HashMap<String, List<Integer>>();
        //for (Map.Entry me: inverted.entrySet()) {
        //}

    }
}

