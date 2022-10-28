
import api.ApiException;
import api.GutenbergApi;

import java.util.Timer;
import java.util.TimerTask;


public class Main {

    public static final int DOCUMENT_STORE_PATH = 0;

    public static void main(String[] args) throws ApiException {
        GutenbergApi.init();
        Timer timer = new Timer();
        TimerTask task = new TimerTask() {
            public int i = 25000;
            @Override
            public void run() {
                try {
                    StoreDocs.store_docs(args[DOCUMENT_STORE_PATH], i++);
                } catch (ApiException e) {
                    e.printStackTrace();
                }

            }
        };
        timer.schedule(task, 2000, 60000);


    }
}
