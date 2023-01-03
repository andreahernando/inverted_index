package org.bigdata.saxodb;

public class DMLtranslate {
    private static final String INSERT_METADATA =
            "INSERT INTO Metadata( id, title, author, releaseDate,postingDate, language) VALUES('%s', '%s','%s', '%s', '%s', '%s');";

    public static String insertMetadata(Metadata metadata) {
        return String.format(INSERT_METADATA,
                metadata.id,
                metadata.title,
                metadata.author,
                metadata.releaseDate,
                metadata.postingDate,
                metadata.language);
    }
}