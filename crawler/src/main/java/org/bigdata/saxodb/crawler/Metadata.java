package org.bigdata.saxodb.crawler;

public class Metadata {
    private String title;
    private String author;
    private String language;
    private String releaseDate;
    private String postingDate;

    public Metadata(String title, String author,String language, String releaseDate, String postingDate) {
        this.title = title;
        this.author = author;
        this.language = language;
        this.releaseDate = releaseDate;
        this.postingDate = postingDate;
    }
}
