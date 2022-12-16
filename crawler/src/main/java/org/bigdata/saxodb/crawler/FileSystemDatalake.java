package org.bigdata.saxodb.crawler;

import org.bigdata.saxodb.Document;

import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class FileSystemDatalake implements Datalake {
    @Override
    public void store(Document document) throws IOException {
        String formatdate = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd HHmm"));
        FileWriter myWriter = new FileWriter("C:\\Users\\andre\\IdeaProjects\\SaxoDB\\crawler\\datalake\\" + String.valueOf(formatdate) +".txt");
        myWriter.write(document.getText());
        myWriter.close();

    }
}
