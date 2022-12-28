package org.bigdata.saxodb.indexer;

import java.io.*;
import java.util.Map;
import java.util.TreeSet;

public class InvertedIndexDatamart implements Datamart{
    @Override
    public void store(Map<String, TreeSet<String>> invertedindex) {
        byte[] data;
        try (ByteArrayOutputStream bos = new ByteArrayOutputStream();
             ObjectOutputStream oos = new ObjectOutputStream(bos)) {
            oos.writeObject(invertedindex);
            data = bos.toByteArray();
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }

        // Save the byte array to a file
        try (FileOutputStream fos = new FileOutputStream("C:/Users/andre/IdeaProjects/SaxoDB/src/main/java/org/bigdata/saxodb/inverted.data");
             BufferedOutputStream bos = new BufferedOutputStream(fos)) {
            bos.write(data);
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }

        System.out.println("Map persisted to file.");

    }
}
