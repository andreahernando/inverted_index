package org.bigdata.saxodb.deserializer;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;


public class Json {
    private static final Gson GsonInstance = createGsonInstance();


    public static <T> T fromJson(String json, Class<T> type) {
        return GsonInstance.fromJson(json, type);
    }

    private static Gson createGsonInstance() {
        GsonBuilder builder = new GsonBuilder();
        builder.setPrettyPrinting();
        builder.setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES);
        return builder.create();
    }


}
