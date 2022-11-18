package org.bigdata.saxodb.crawler;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class FileSystemDatalake implements Datalake {
    @Override
    public void store(Document document) {
        LocalDateTime date = LocalDateTime.now();
        DateTimeFormatter mydate = DateTimeFormatter.ofPattern("yyyyMMdd HHmm");
        String formatdate = date.format(mydate);


    }
}
