package com.cuke.util;

import com.google.gson.Gson;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by cuke on 2017/5/25.
 */
public class StringUtil {

    public static Map<String, Double> getDoubleMapFromJsonObjStr(String jsonObjStr) {
        Gson gson = new Gson();
        Map<String, Double> map = new HashMap<String, Double>();
        map = gson.fromJson(jsonObjStr, map.getClass());
        return map;
    }
}
