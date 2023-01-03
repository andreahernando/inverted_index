package org.bigdata.saxodb;

public class Metadata {
    public String id;
    public String title;
    public String author;
    public String language;
    public String releaseDate;
    public String postingDate;

    public Metadata(String id,String title, String author, String releaseDate, String postingDate, String language) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.language = language;
        this.releaseDate = releaseDate;
        this.postingDate = postingDate;
    }
}
