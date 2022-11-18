package InvertedIndex;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class Indexer {
    String texto;
    Map<String, TreeSet<Integer>> inverted;

    public Indexer(String texto) {
        this.texto = texto;
        this.inverted = new HashMap<>();
    }

    public Map<String, TreeSet<Integer>> to_index() throws IOException {
        String text = texto.replaceAll("\\p{Punct}", " ");
        String text2 = text.replaceAll("\\p{Digit}", " ");
        List<String> stopwords = Files.readAllLines(Paths.get("C:\\Users\\andre\\Desktop\\Andre Uni\\Tercero\\BD\\english_stopwords.txt"));
        Integer line = 1;
        for (String linea : text2.split("\n")) {
            for (String word : linea.split(" ")) {
                if (!stopwords.contains(word.toLowerCase())) {
                    if(!inverted.containsKey(word.toLowerCase())) {
                        inverted.put(word.toLowerCase(), new TreeSet<>());
                    }
                    inverted.get(word.toLowerCase()).add(line);
                }
            }
            line += 1;
        }
        inverted.remove("");
        return inverted;
    }

    @Override
    public String toString() {
        try {
            return String.valueOf(to_index());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";

    }
}
