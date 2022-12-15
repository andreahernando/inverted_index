package org.bigdata.saxodb.crawler;

import java.util.List;

public class DMLtranslate {
    private static final String INSERT_METADATA =
            "INSERT INTO Metadata( title, author, language, releaseDate,postingDate) VALUES('%s', '%s','%s', '%s', '%s');";

    public static String insertMetadata(Metadata metadata) {
        return String.format(INSERT_METADATA,
                metadata.title,
                metadata.author,
                metadata.language,
                metadata.releaseDate,
                metadata.postingDate);
    }
}