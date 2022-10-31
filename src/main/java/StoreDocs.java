import Model.Metadata;
import api.ApiException;
import api.GutenbergApi;

import java.io.BufferedInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class StoreDocs {

    public static void store_docs(String folderPath, Integer id) throws ApiException {
        Metadata doc = GutenbergApi.document(id);
        String url_download = "";
        LocalDateTime date = LocalDateTime.now();
        DateTimeFormatter mydate = DateTimeFormatter.ofPattern("yyyyMMdd HHmm");
        String formatdate = date.format(mydate);
        for (int j = 0; j< doc.resources.size(); j++){
            if (doc.resources.get(j).uri.endsWith(".txt")) {
                url_download = doc.resources.get(j).uri;
            }
        }
        try (BufferedInputStream inputStream = new BufferedInputStream(new URL(url_download).openStream());
             FileOutputStream fileOS = new FileOutputStream(folderPath+formatdate+".txt")) {
            byte data[] = new byte[1024];
            int byteContent;
            while ((byteContent = inputStream.read(data, 0, 1024)) != -1) {
                fileOS.write(data, 0,byteContent);
            }
            System.out.println("Hecho");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
