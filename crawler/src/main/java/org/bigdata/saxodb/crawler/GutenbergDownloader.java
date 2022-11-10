package org.bigdata.saxodb.crawler;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.net.URL;

public class GutenbergDownloader implements Downloader {

    private static final String BasePath = "https://www.gutenberg.org/ebooks/[ID].txt.utf-8";
    @Override
    public String download(String id) {
        try {
            return download(new URL(BasePath.replace("[ID]",id)));
        } catch (IOException e) {
            return "";
        }
    }

    private String download(URL url) throws IOException {
        try (BufferedInputStream inputStream = new BufferedInputStream(url.openStream())) {
            return new String(inputStream.readAllBytes());
        }
    }
}
