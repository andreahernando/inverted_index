package org.bigdata.saxodb.crawler;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CreateTable {
    public static void main(String[] args) throws SQLException {
        SQLiteGutenbergDatabase sqLiteGutenbergDatabase = new SQLiteGutenbergDatabase();
        sqLiteGutenbergDatabase.init();

        Metadata metadata = new Metadata("Los diez negritos","Cyn","English","14-09-98","14-09-95");


        sqLiteGutenbergDatabase.insertMetadata(metadata);







    }
}
