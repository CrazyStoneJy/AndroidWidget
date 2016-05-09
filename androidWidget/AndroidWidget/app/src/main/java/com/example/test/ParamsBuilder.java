package com.example.test;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by e on 2016/4/26.
 */
public class ParamsBuilder {

    private Map<String, Object> mMap = null;

    public ParamsBuilder() {
        mMap = new HashMap<String, Object>();
    }

    public ParamsBuilder put(String key, Object value) {
        mMap.put(key, value);
        return this;
    }

    public Map<String, Object> build() {
        return mMap;
    }

}
