package org.bigdata.saxodb.indexer;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileReader {
    public String read (File file) throws FileNotFoundException {
        List<String> text = new ArrayList<>();

        Scanner scanner = new Scanner(file);
        while (scanner.hasNextLine()){
            text.add(scanner.nextLine());
        }

        return text.toString();
    }
}
