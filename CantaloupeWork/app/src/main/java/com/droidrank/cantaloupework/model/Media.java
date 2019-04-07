package com.droidrank.cantaloupework.model;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import com.google.gson.reflect.TypeToken;

import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

class Media {
    /**
     * type : image
     * subtype : photo
     * caption : Attorney General William P. Barr has shown hints of frustration with how the rollout of the special counsel’s chief findings has unfolded.<br /><br />
     * copyright : Sarah Silbiger/The New York Times
     * approved_for_syndication : 1
     * media-metadata : [{"url":"https://static01.nyt.com/images/2019/05/03/us/03dc-mueller-promo/merlin_152946042_2d0da3b4-7ed5-47a4-bc93-0b1234b85a54-square320.jpg","format":"square320","height":320,"width":320},{"url":"https://static01.nyt.com/images/2019/05/03/us/03dc-mueller-promo/merlin_152946042_2d0da3b4-7ed5-47a4-bc93-0b1234b85a54-thumbStandard.jpg","format":"Standard Thumbnail","height":75,"width":75},{"url":"https://static01.nyt.com/images/2019/05/03/us/03dc-mueller-promo/merlin_152946042_2d0da3b4-7ed5-47a4-bc93-0b1234b85a54-articleInline.jpg","format":"Normal","height":127,"width":190},{"url":"https://static01.nyt.com/images/2019/05/03/us/03dc-mueller-promo/merlin_152946042_2d0da3b4-7ed5-47a4-bc93-0b1234b85a54-sfSpan.jpg","format":"Large","height":263,"width":395},{"url":"https://static01.nyt.com/images/2019/05/03/us/03dc-mueller-promo/merlin_152946042_2d0da3b4-7ed5-47a4-bc93-0b1234b85a54-jumbo.jpg","format":"Jumbo","height":683,"width":1024},{"url":"https://static01.nyt.com/images/2019/05/03/us/03dc-mueller-promo/merlin_152946042_2d0da3b4-7ed5-47a4-bc93-0b1234b85a54-superJumbo.jpg","format":"superJumbo","height":1365,"width":2048},{"url":"https://static01.nyt.com/images/2019/05/03/us/03dc-mueller-promo/merlin_152946042_2d0da3b4-7ed5-47a4-bc93-0b1234b85a54-square640.jpg","format":"square640","height":640,"width":640},{"url":"https://static01.nyt.com/images/2019/05/03/us/03dc-mueller-promo/merlin_152946042_2d0da3b4-7ed5-47a4-bc93-0b1234b85a54-thumbLarge.jpg","format":"Large Thumbnail","height":150,"width":150},{"url":"https://static01.nyt.com/images/2019/05/03/us/03dc-mueller-promo/merlin_152946042_2d0da3b4-7ed5-47a4-bc93-0b1234b85a54-mediumThreeByTwo210.jpg","format":"mediumThreeByTwo210","height":140,"width":210},{"url":"https://static01.nyt.com/images/2019/05/03/us/03dc-mueller-promo/merlin_152946042_2d0da3b4-7ed5-47a4-bc93-0b1234b85a54-mediumThreeByTwo440.jpg","format":"mediumThreeByTwo440","height":293,"width":440}]
     */

    private String type;
    private String subtype;
    private String caption;
    private String copyright;
    private int approved_for_syndication;
    @SerializedName("media-metadata")
    private List<Mediametadata> mediametadata;

    public static Media objectFromData(String str) {

        return new Gson().fromJson(str, Media.class);
    }

    public static Media objectFromData(String str, String key) {

        try {
            JSONObject jsonObject = new JSONObject(str);

            return new Gson().fromJson(jsonObject.getString(str), Media.class);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return null;
    }

    public static List<Media> arrayMediaFromData(String str) {

        Type listType = new TypeToken<ArrayList<Media>>() {
        }.getType();

        return new Gson().fromJson(str, listType);
    }

    public static List<Media> arrayMediaFromData(String str, String key) {

        try {
            JSONObject jsonObject = new JSONObject(str);
            Type listType = new TypeToken<ArrayList<Media>>() {
            }.getType();

            return new Gson().fromJson(jsonObject.getString(str), listType);

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return new ArrayList();


    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSubtype() {
        return subtype;
    }

    public void setSubtype(String subtype) {
        this.subtype = subtype;
    }

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    public String getCopyright() {
        return copyright;
    }

    public void setCopyright(String copyright) {
        this.copyright = copyright;
    }

    public int getApproved_for_syndication() {
        return approved_for_syndication;
    }

    public void setApproved_for_syndication(int approved_for_syndication) {
        this.approved_for_syndication = approved_for_syndication;
    }

    public List<Mediametadata> getMediametadata() {
        return mediametadata;
    }

    public void setMediametadata(List<Mediametadata> mediametadata) {
        this.mediametadata = mediametadata;
    }
}
