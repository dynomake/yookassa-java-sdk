package space.yakonay.yookassa.utility;

import com.google.gson.Gson;
import lombok.Getter;
import lombok.experimental.UtilityClass;

@UtilityClass
public class JsonUtil {

    @Getter
    private final Gson gson = new Gson();


    /**
     * Преобразовать объект в JSON
     *
     * @param object - объект
     */
    public String toJson(Object object) {
        return gson.toJson(object);
    }

    /**
     * Преобразовать JSON обратно в объект
     *
     * @param json - JSON
     * @param clazz - класс объекта
     */
    public <T> T fromJson(String json, Class<T> clazz) {
        return gson.fromJson(json, clazz);
    }

}
