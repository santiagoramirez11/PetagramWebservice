package com.coursera.santiago.petagram.restApi;

public class ConstantesRestApi {

//    https://api.instagram.com/v1/users/self/media/recent/?access_token=5996215172.07a3141.0084224ce6f14ce8b6b8ef7530810ea2
    public static final String VERSION = "/v1/";
    public static final String ROOT_URL = "https://api.instagram.com"+VERSION;
    public static final String KEY_ACCESS_TOKEN = "?access_token=";
    public static final String ACCESS_TOKEN = "5996215172.07a3141.0084224ce6f14ce8b6b8ef7530810ea2";
    public static final String KEY_GET_RECENT_USER = "users/self/media/recent";
    public static final String URL_GET_RECENT_MEDIA_USER = KEY_GET_RECENT_USER+KEY_ACCESS_TOKEN+ACCESS_TOKEN;


}
