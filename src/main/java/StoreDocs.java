import org.bigdata.saxodb.model.Metadata;
import org.bigdata.saxodb.model.SplitText;
import org.bigdata.saxodb.api.ApiException;
import org.bigdata.saxodb.api.GutenbergApi;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class StoreDocs {

    public void store_docs(String folderPath, Integer id) throws ApiException {
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
            URL furl = new URL(url_download);
            BufferedReader in  = new BufferedReader(new InputStreamReader(furl.openStream()));
            String content = "";
            String linea;
            while ((linea = in.readLine()) != null) {
                content += linea + "\n";
            }
            in.close();
            SplitText.spliText(content);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
