package org.bigdata.saxodb.crawler;

public class CrawlerTask {
    private final Downloader downloader;
    private final Parser parser;
    private final Datalake datalake;

    public CrawlerTask(Downloader downloader, Parser parser, Datalake datalake) {
        this.downloader = downloader;
        this.parser = parser;
        this.datalake = datalake;
    }

    public void download(String id) {
        datalake.store(parser.parse(downloader.download(id)));

    }

}
