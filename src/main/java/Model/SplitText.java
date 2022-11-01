package Model;
//import Serialize.StoreDocs;

//import java.io.FileOutputStream;
//import java.io.ObjectOutputStream;

import java.util.List;

public class SplitText {

    public static void spliText(String str) {
        List<String> parts = List.of(str.split("\\*\\*\\*"));
        System.out.println(parts.get(2));
        //try {
            //String[] parts = string.split("-");
            //FileOutputStream fos = new FileOutputStream(fileOS);
            //ObjectOutputStream oos = new ObjectOutputStream(fos);
            //oos.writeObject(namesList);
            //oos.close();
            //fos.close();
        //} catch (IOException ioe) {
            //ioe.printStackTrace();
        //}


    }
}
