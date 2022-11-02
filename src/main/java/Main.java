
import api.ApiException;
import api.GutenbergApi;

import java.net.MalformedURLException;
import java.util.Timer;
import java.util.TimerTask;


public class Main {

    public static final int DOCUMENT_STORE_PATH = 0;

    public static void main(String[] args) throws ApiException {
        GutenbergApi.init();
        Timer timer = new Timer();
        TimerTask task = new TimerTask() {
            public int i = 18000;
            public int num = 0;
            @Override
            public void run() {
                try {
                    StoreDocs doc = new StoreDocs();
                    doc.store_docs(args[DOCUMENT_STORE_PATH], i++);

                } catch (ApiException e) {
                    num++;
                    System.out.println(num);
                    if (num == 5) {
                        System.exit(0);
                    }
                }

            }
        };
        timer.schedule(task, 2000, 60000);


    }
}
