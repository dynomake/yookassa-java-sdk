package me.dynomake.yookassa.utility;

import com.google.gson.Gson;
import lombok.Getter;
import lombok.experimental.UtilityClass;

@UtilityClass
public class JsonUtil {

    @Getter
    private final Gson gson = new Gson();


    /**
     * Java Object to json
     *
     * @param object - objest
     */
    public String toJson(Object object) {
        return gson.toJson(object);
    }

    /**
     * JSON back to java Object
     *
     * @param json  - JSON
     * @param clazz - object class
     */
    public <T> T fromJson(String json, Class<T> clazz) {
        return gson.fromJson(json, clazz);
    }

}
