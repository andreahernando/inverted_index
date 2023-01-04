package org.bigdata.saxodb.crawler;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.Timer;
import java.util.TimerTask;

public class Main {

    public static void main(String[] args) throws IOException {
        Downloader downloader = new GutenbergDownloader();
        Parser parser = new GutenbergParser();
        Datalake datalake = new FileSystemDatalake();
        CrawlerTask task = new CrawlerTask(downloader, parser, datalake);
        //String[] ids = new String[] { "1112"  };
        Timer timer = new Timer();
        TimerTask timertask = new TimerTask() {
            int num = 8500;
            int cont = 0;
            @Override
            public void run() {
                try {
                    task.download(String.valueOf(num++));
                    System.out.println("Hecho");
                } catch (IOException | SQLException e) {
                    System.out.println(e);
                    cont++;
                    if(cont == 5) {
                        System.exit(0);
                    }

                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }
        };
        timer.schedule(timertask,2000,60000);
    }


}

