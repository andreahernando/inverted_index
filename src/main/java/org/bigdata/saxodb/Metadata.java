package org.bigdata.saxodb;

import java.util.Date;

public class Metadata {
    public String id;
    public String title;
    public String author;
    public String language;
    public String releaseDate;

    public Metadata(String id,String title, String author, String releaseDate, String language) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.language = language;
        this.releaseDate = releaseDate;
    }
}
