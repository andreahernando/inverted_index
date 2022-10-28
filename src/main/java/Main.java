
import api.ApiException;
import api.GutenbergApi;

import java.util.Timer;
import java.util.TimerTask;


public class Main {
    public static void main(String[] args) throws ApiException {
        GutenbergApi.init();
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {

            }
        });

        StoreDocs.store_docs(27841);


    }
}
