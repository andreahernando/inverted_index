package org.bigdata.saxodb.engine;

import java.io.*;
import java.util.Map;
import java.util.TreeSet;

public class MapDeserialization {

    public Map<String, TreeSet<String>> GetMap(String url) throws IOException, ClassNotFoundException {
        byte[] data;
        FileInputStream fis = new FileInputStream(url);
        BufferedInputStream bis = new BufferedInputStream(fis);
        data = bis.readAllBytes();

        Map<String, TreeSet<String>> map;
        ByteArrayInputStream bis2 = new ByteArrayInputStream(data);
        ObjectInputStream ois = new ObjectInputStream(bis2);
        map = (Map<String, TreeSet<String>>) ois.readObject();


        return map;
    }

}