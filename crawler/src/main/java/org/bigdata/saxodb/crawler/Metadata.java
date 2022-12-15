package org.bigdata.saxodb.crawler;

public class Metadata {
    public String title;
    public String author;
    public String language;
    public String releaseDate;
    public String postingDate;

    public Metadata(String title, String author,String language, String releaseDate, String postingDate) {
        this.title = title;
        this.author = author;
        this.language = language;
        this.releaseDate = releaseDate;
        this.postingDate = postingDate;
    }
}
