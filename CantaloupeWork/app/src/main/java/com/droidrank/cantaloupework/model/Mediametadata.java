package com.droidrank.cantaloupework.model;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

class Mediametadata {
    /**
     * url : https://static01.nyt.com/images/2019/05/03/us/03dc-mueller-promo/merlin_152946042_2d0da3b4-7ed5-47a4-bc93-0b1234b85a54-square320.jpg
     * format : square320
     * height : 320
     * width : 320
     */

    private String url;
    private String format;
    private int height;
    private int width;

    public static Mediametadata objectFromData(String str) {

        return new Gson().fromJson(str, Mediametadata.class);
    }

    public static Mediametadata objectFromData(String str, String key) {

        try {
            JSONObject jsonObject = new JSONObject(str);

            return new Gson().fromJson(jsonObject.getString(str), Mediametadata.class);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return null;
    }

    public static List<Mediametadata> arrayMediametadataFromData(String str) {

        Type listType = new TypeToken<ArrayList<Mediametadata>>() {
        }.getType();

        return new Gson().fromJson(str, listType);
    }

    public static List<Mediametadata> arrayMediametadataFromData(String str, String key) {

        try {
            JSONObject jsonObject = new JSONObject(str);
            Type listType = new TypeToken<ArrayList<Mediametadata>>() {
            }.getType();

            return new Gson().fromJson(jsonObject.getString(str), listType);

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return new ArrayList();


    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }
}
