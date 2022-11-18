package org.bigdata.saxodb.crawler;

import java.io.FileNotFoundException;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        Downloader downloader = new GutenbergDownloader();
        Parser parser = new GutenbergParser();
        Datalake datalake = new FileSystemDatalake();
        CrawlerTask task = new CrawlerTask(downloader, parser, datalake);
        String[] ids = new String[] { "1112"  };
        for (String id : ids) {
            task.download(id);
        }


    }
}
