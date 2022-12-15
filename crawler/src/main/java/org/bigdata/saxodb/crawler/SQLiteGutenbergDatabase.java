package org.bigdata.saxodb.crawler;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class SQLiteGutenbergDatabase {
    private Connection conn;
    public Statement init() throws SQLException {
        String dbPath = "C:/Users/cynth/IdeaProjects/inverted_index/crawler/src/main/java/org/bigdata/saxodb/crawler/table.db";
        conn = connect(dbPath);
        Statement statement = conn.createStatement();
        createTable(statement);
        return statement;
    }

    private Connection connect(String dbPath) {
        Connection conn = null;
        try {
            String url = "jdbc:sqlite:" + dbPath;
            conn = DriverManager.getConnection(url);
            System.out.println("Connection to SQLite has been established.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }

    public void insertMetadata(Metadata metadata) throws  SQLException{
        Statement statement = conn.createStatement();
        statement.execute(DMLtranslate.insertMetadata(metadata));
    }


    private void createTable(Statement statement) throws SQLException {
        statement.execute("CREATE TABLE IF NOT EXISTS Metadata (" +
                "title TEXT," +
                "author TEXT," +
                "language TEXT," +
                "releaseDate TEXT," +
                "postingDate TEXT" +
                ");");
    }
}
