package org.bigdata.saxodb.crawler;


import org.bigdata.saxodb.Document;

public interface Parser {
    Document parse(String text);
}
