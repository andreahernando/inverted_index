package org.bigdata.saxodb.crawler;


import org.bigdata.saxodb.Document;
import org.bigdata.saxodb.Metadata;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class DocumentBuilder implements Builder {
    private String metadata;
    private String texto;
    private String[] metadata_list;
    private StringBuilder sb = new StringBuilder();
    public IDGenerator id = new IDGenerator();


    public DocumentBuilder(String text) {
        metadata = text.substring(0, text.indexOf("*** START"));
        texto = text.substring(text.indexOf("*** START")+"*** START".length(), text.indexOf("*** END"));

    }

    @Override
    public Document build() {
        Document doc = new Document();
        try {
            doc.setMetadata(MetadataBuilder(metadata));
        } catch (ParseException e) {
            e.printStackTrace();
        }

        doc.setText(texto);
        return doc;
    }

    public Metadata MetadataBuilder(String metadata) throws ParseException {
        String[] finalMetadata = new String[4];
        Scanner scanner= new Scanner(metadata);
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            if (line.startsWith("Title:")) {
                finalMetadata[0] = line.substring(7);
            }else if(line.startsWith("Author:")) {
                finalMetadata[1] = line.substring(8);
            } else if (line.startsWith("Release Date:")) {
                finalMetadata[2] = line.substring(14);
            } else if (line.startsWith("Language: ")) {
                finalMetadata[3] = line.substring(10);
            }
        }

        StringBuilder finalFecha = new StringBuilder();
        Pattern pattern = Pattern.compile("(Jan(uary)?|Feb(ruary)?|Mar(ch)?|Apr(il)?|May|Jun(e)?|Jul(y)?|Aug(ust)?|Sep(tember)?|Oct(ober)?|Nov(ember)?|Dec(ember)?),\\s*");
        Pattern pattern1 = Pattern.compile("(.*),\\s*\\d{4}");
        SimpleDateFormat formatoSalida = new SimpleDateFormat("MM yyyy", Locale.US);

        if (pattern.matcher(finalMetadata[2]).find()) {


            SimpleDateFormat formato = new SimpleDateFormat("MMM, yyyy", Locale.US);
            if (pattern1.matcher(finalMetadata[2]).find()) {
                Date date2 = formato.parse(finalMetadata[2]);
                String fecha4 = formatoSalida.format(date2);
                finalFecha.append(fecha4);
            }


        } else  {
            Matcher matcher = pattern1.matcher(finalMetadata[2]);

            if (matcher.find()){
                Date date1 = new Date(matcher.group(0));
                String fecha3 = formatoSalida.format(date1);
                finalFecha.append(fecha3);
            }

        }
        String string = finalFecha.toString();


        return new Metadata(String.valueOf(id.generateID()), finalMetadata[0].trim(), finalMetadata[1].trim(), string, finalMetadata[3].trim());


        }


}
