package com.droidrank.cantaloupework.model;


import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import com.google.gson.reflect.TypeToken;

import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import androidx.databinding.BaseObservable;

public class Results extends BaseObservable {
    /**
     * url : https://www.nytimes.com/2019/04/03/us/politics/william-barr-mueller-report.html
     * adx_keywords : Trump, Donald J;Mueller, Robert S III;Barr, William P;Russian Interference in 2016 US Elections and Ties to Trump Associates;Special Prosecutors (Independent Counsel);Justice Department;Attorneys General;United States Politics and Government
     * column : null
     * section : U.S.
     * byline : By NICHOLAS FANDOS, MICHAEL S. SCHMIDT and MARK MAZZETTI
     * type : Article
     * title : Some on Mueller’s Team Say Report Was More Damaging Than Barr Revealed
     * abstract : Members of the special counsel’s team have told associates that their findings are more troubling for President Trump than the attorney general indicated.
     * published_date : 2019-04-03
     * source : The New York Times
     * id : 100000006441465
     * asset_id : 100000006441465
     * views : 1
     * des_facet : ["RUSSIAN INTERFERENCE IN 2016 US ELECTIONS AND TIES TO TRUMP ASSOCIATES","UNITED STATES POLITICS AND GOVERNMENT"]
     * org_facet : ["SPECIAL PROSECUTORS (INDEPENDENT COUNSEL)","JUSTICE DEPARTMENT","ATTORNEYS GENERAL"]
     * per_facet : ["TRUMP, DONALD J","MUELLER, ROBERT S III","BARR, WILLIAM P"]
     * geo_facet :
     * media : [{"type":"image","subtype":"photo","caption":"Attorney General William P. Barr has shown hints of frustration with how the rollout of the special counsel\u2019s chief findings has unfolded.<br /><br />","copyright":"Sarah Silbiger/The New York Times","approved_for_syndication":1,"media-metadata":[{"url":"https://static01.nyt.com/images/2019/05/03/us/03dc-mueller-promo/merlin_152946042_2d0da3b4-7ed5-47a4-bc93-0b1234b85a54-square320.jpg","format":"square320","height":320,"width":320},{"url":"https://static01.nyt.com/images/2019/05/03/us/03dc-mueller-promo/merlin_152946042_2d0da3b4-7ed5-47a4-bc93-0b1234b85a54-thumbStandard.jpg","format":"Standard Thumbnail","height":75,"width":75},{"url":"https://static01.nyt.com/images/2019/05/03/us/03dc-mueller-promo/merlin_152946042_2d0da3b4-7ed5-47a4-bc93-0b1234b85a54-articleInline.jpg","format":"Normal","height":127,"width":190},{"url":"https://static01.nyt.com/images/2019/05/03/us/03dc-mueller-promo/merlin_152946042_2d0da3b4-7ed5-47a4-bc93-0b1234b85a54-sfSpan.jpg","format":"Large","height":263,"width":395},{"url":"https://static01.nyt.com/images/2019/05/03/us/03dc-mueller-promo/merlin_152946042_2d0da3b4-7ed5-47a4-bc93-0b1234b85a54-jumbo.jpg","format":"Jumbo","height":683,"width":1024},{"url":"https://static01.nyt.com/images/2019/05/03/us/03dc-mueller-promo/merlin_152946042_2d0da3b4-7ed5-47a4-bc93-0b1234b85a54-superJumbo.jpg","format":"superJumbo","height":1365,"width":2048},{"url":"https://static01.nyt.com/images/2019/05/03/us/03dc-mueller-promo/merlin_152946042_2d0da3b4-7ed5-47a4-bc93-0b1234b85a54-square640.jpg","format":"square640","height":640,"width":640},{"url":"https://static01.nyt.com/images/2019/05/03/us/03dc-mueller-promo/merlin_152946042_2d0da3b4-7ed5-47a4-bc93-0b1234b85a54-thumbLarge.jpg","format":"Large Thumbnail","height":150,"width":150},{"url":"https://static01.nyt.com/images/2019/05/03/us/03dc-mueller-promo/merlin_152946042_2d0da3b4-7ed5-47a4-bc93-0b1234b85a54-mediumThreeByTwo210.jpg","format":"mediumThreeByTwo210","height":140,"width":210},{"url":"https://static01.nyt.com/images/2019/05/03/us/03dc-mueller-promo/merlin_152946042_2d0da3b4-7ed5-47a4-bc93-0b1234b85a54-mediumThreeByTwo440.jpg","format":"mediumThreeByTwo440","height":293,"width":440}]}]
     */

    private String url;
    private String adx_keywords;
    private Object column;
    private String section;
    private String byline;
    private String type;
    private String title;
    @SerializedName("abstract")
    private String abstractX;
    private String published_date;
    private String source;
    private long id;
    private long asset_id;
    private int views;
    private List<Media> media;

    private String thumbnailUrl;

    public String getThumbnailUrl() {
        String url = "";
        if (media != null && media.get(0) != null && media.get(0).getMediametadata() != null && media.get(0).getMediametadata().get(0) != null)
            url = media.get(0).getMediametadata().get(0).getUrl();
        return url;
    }

    public void setThumbnailUrl(String thumbnailUrl) {
        this.thumbnailUrl = thumbnailUrl;
    }

    public static Results objectFromData(String str) {

        return new Gson().fromJson(str, Results.class);
    }

    public static Results objectFromData(String str, String key) {

        try {
            JSONObject jsonObject = new JSONObject(str);

            return new Gson().fromJson(jsonObject.getString(str), Results.class);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return null;
    }

    public static List<Results> arrayResultsFromData(String str) {

        Type listType = new TypeToken<ArrayList<Results>>() {
        }.getType();

        return new Gson().fromJson(str, listType);
    }

    public static List<Results> arrayResultsFromData(String str, String key) {

        try {
            JSONObject jsonObject = new JSONObject(str);
            Type listType = new TypeToken<ArrayList<Results>>() {
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

    public String getAdx_keywords() {
        return adx_keywords;
    }

    public void setAdx_keywords(String adx_keywords) {
        this.adx_keywords = adx_keywords;
    }

    public Object getColumn() {
        return column;
    }

    public void setColumn(Object column) {
        this.column = column;
    }

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }

    public String getByline() {
        return byline;
    }

    public void setByline(String byline) {
        this.byline = byline;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAbstractX() {
        return abstractX;
    }

    public void setAbstractX(String abstractX) {
        this.abstractX = abstractX;
    }

    public String getPublished_date() {
        return published_date;
    }

    public void setPublished_date(String published_date) {
        this.published_date = published_date;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getAsset_id() {
        return asset_id;
    }

    public void setAsset_id(long asset_id) {
        this.asset_id = asset_id;
    }

    public int getViews() {
        return views;
    }

    public void setViews(int views) {
        this.views = views;
    }


    public List<Media> getMedia() {
        return media;
    }

    public void setMedia(List<Media> media) {
        this.media = media;
    }
}
