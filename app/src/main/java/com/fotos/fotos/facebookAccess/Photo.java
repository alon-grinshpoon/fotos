package com.fotos.fotos.facebookAccess;

/**
 * Created by t-yoadat on 9/3/2015.
 */
public class Photo {
    private String url;
    private String location;
    private String id;
    private String name;

    public Photo(String id, String name, String url, String location) {
        this.id = id;
        this.url = url;
        this.name = name;
        this.location = location;
    }

    public String getUrl() { return this.url; }

    public String getLocation() { return this.location; }

    public String getId() { return this.id; }

    public String getName() { return this.name; }
}
