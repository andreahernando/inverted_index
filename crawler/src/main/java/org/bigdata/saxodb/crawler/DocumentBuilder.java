package org.bigdata.saxodb.crawler;


import org.bigdata.saxodb.Document;
import org.bigdata.saxodb.Metadata;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class DocumentBuilder implements Builder {
    private String[] textParts;
    private String[] metadata_list;
    public IDGenerator id = new IDGenerator();


    public DocumentBuilder(String text) {
        textParts = text.split("\\*\\*\\*");

    }

    @Override
    public Document build() {
        Document doc = new Document();
        try {
            doc.setMetadata(MetadataBuilder(textParts[0]));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        doc.setText(textParts[2]);
        return doc;
    }

    public Metadata MetadataBuilder(String metadata) throws ParseException {
        List<String> finalMetadata = new ArrayList<>();
        metadata_list = metadata.split("\n");
        for (int i = 0; i < metadata_list.length; i++) {
            String[] temporal = metadata_list[i].split(": ");
            if (temporal.length == 2) {
                finalMetadata.add(temporal[1]);
            }
        }
        StringBuilder finalFecha = new StringBuilder();
        Pattern pattern = Pattern.compile("(Jan(uary)?|Feb(ruary)?|Mar(ch)?|Apr(il)?|May|Jun(e)?|Jul(y)?|Aug(ust)?|Sep(tember)?|Oct(ober)?|Nov(ember)?|Dec(ember)?),\\s*");
        Pattern pattern1 = Pattern.compile("(.*),\\s*\\d{4}");
        SimpleDateFormat formatoSalida = new SimpleDateFormat("MM yyyy", Locale.US);

        if (pattern.matcher(finalMetadata.get(2)).find()) {


            SimpleDateFormat formato = new SimpleDateFormat("MMM, yyyy", Locale.US);
            if (pattern1.matcher(finalMetadata.get(2)).find()) {
                Date date2 = formato.parse(finalMetadata.get(2));
                String fecha4 = formatoSalida.format(date2);
                finalFecha.append(fecha4);
            }


        } else  {
            Matcher matcher = pattern1.matcher(finalMetadata.get(2));

            if (matcher.find()){
                Date date1 = new Date(matcher.group(0));
                String fecha3 = formatoSalida.format(date1);
                finalFecha.append(fecha3);
            }

        }
        String string = finalFecha.toString();


        finalMetadata.forEach(System.out::println);
        return new Metadata(String.valueOf(id.generateID()), finalMetadata.get(0).trim(), finalMetadata.get(1).trim(), string
                , finalMetadata.get(3).trim(), finalMetadata.get(finalMetadata.size() - 1).trim());


        }


}
