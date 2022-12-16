package org.bigdata.saxodb.crawler;


import org.bigdata.saxodb.Document;
import org.bigdata.saxodb.SQLiteGutenbergDatabase;

import java.io.IOException;
import java.sql.SQLException;

public class CrawlerTask {
    private final Downloader downloader;
    private final Parser parser;
    private final Datalake datalake;

    public CrawlerTask(Downloader downloader, Parser parser, Datalake datalake) {
        this.downloader = downloader;
        this.parser = parser;
        this.datalake = datalake;
    }

    public void download(String id) throws IOException, SQLException {
        SQLiteGutenbergDatabase sqLiteGutenbergDatabase = new SQLiteGutenbergDatabase();
        sqLiteGutenbergDatabase.init();
        String text = downloader.download(id);
        Document doc = new DocumentBuilder(text).build();
        sqLiteGutenbergDatabase.insertMetadata(doc.getMetadata());
        datalake.store(doc);


    }

}
