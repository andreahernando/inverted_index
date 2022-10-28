
import api.ApiException;
import api.GutenbergApi;

import java.util.Timer;
import java.util.TimerTask;


public class Main {

    public static final int DOCUMENT_STORE_PATH = 0;

    public static void main(String[] args) throws ApiException {
        GutenbergApi.init();
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {

            }
        });

        System.out.println(args[DOCUMENT_STORE_PATH]);

        StoreDocs.store_docs(args[DOCUMENT_STORE_PATH], 27841);


    }
}
