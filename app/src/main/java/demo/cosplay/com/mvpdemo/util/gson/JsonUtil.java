package demo.cosplay.com.mvpdemo.util.gson;

import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.List;

/**
 * Created by Hasee on 2017/9/10.
 */

public class JsonUtil {
    // 将Json数据解析成相应的映射对象
    public static <T> T parseJsonWithGson(String jsonData, Class<T> type) {
        Gson gson = new Gson();
        T result = gson.fromJson(jsonData, type);
        return result;
    }
    public static <T> List<T> parseJsonArrayWithGson(String jsonData, Class<T> type) {
        Gson gson = new Gson();
        Log.e("jsonData",jsonData);
        List<T> results = gson.fromJson(jsonData, new TypeToken<List<T>>(){}.getType());
        return results;
    }
}
