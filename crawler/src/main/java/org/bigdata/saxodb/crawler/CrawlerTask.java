package org.bigdata.saxodb.crawler;

import java.io.IOException;

public class CrawlerTask {
    private final Downloader downloader;
    private final Parser parser;
    private final Datalake datalake;

    public CrawlerTask(Downloader downloader, Parser parser, Datalake datalake) {
        this.downloader = downloader;
        this.parser = parser;
        this.datalake = datalake;
    }

    public void download(String id) throws IOException {
        String text = downloader.download(id);
        Document doc = new DocumentBuilder(text).build();
        datalake.store(doc);


    }

}
