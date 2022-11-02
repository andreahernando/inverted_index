package InvertedIndex;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class InvertedIndex {
    public static Map<String, HashSet<Integer>> invertedIndex(String str) throws IOException {

        String str2 = str.replaceAll("\\p{Punct}", ""); //remove punctuation from String
        List<String> stopwords = Files.readAllLines(Paths.get("C:\\Users\\andre\\Desktop\\Andre Uni\\Tercero\\BD\\english_stopwords.txt")); //remove stopwords
        String[] lines = str2.split("\n");

        Integer line = 1;
        for (String linea : lines) {
            for (String word : linea.split(" ")) {
                if (!stopwords.contains(word.toLowerCase(Locale.ROOT))) {
                    if (!StoreIndex.inverted.containsKey(word.toLowerCase())) {
                        StoreIndex.inverted.put(word.toLowerCase(), new HashSet<Integer>() );
                    }
                    StoreIndex.inverted.get(word.toLowerCase()).add(line);
                }
            }
            line += 1;
        }
        StoreIndex.inverted.remove("");
        System.out.println(StoreIndex.inverted);
        return StoreIndex.inverted;


    }
}

