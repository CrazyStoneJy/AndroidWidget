package com.example.test;

import android.app.Activity;
import android.os.Bundle;

import java.util.Map;

/**
 * Created by e on 2016/4/26.
 */
public class MapBuilderTest extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       Map<String,Object> map= new ParamsBuilder().
                put("dawei", "shaib").
                put("nima", "woca").
                put("haha", "heheda").build();
    }
}
