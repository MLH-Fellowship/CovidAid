package com.bit_loons.covidaid.handlers;

import okhttp3.MediaType;

public class DataHandler {

    public static String COOKIE = "";

    public static final MediaType JSON = MediaType.parse("application/json; charset=utf-8");

    public static String BASE_URL = "http://api.awalvie.me/";

    public static String SIGNUP = BASE_URL + "signup";

    public static String LOGIN = BASE_URL + "login";

    public static String LOGOUT = BASE_URL + "logout";

    public static String NEW_REQUEST = BASE_URL + "new_request";

    public static String ALL_REQUESTS = BASE_URL + "all_requests";

    public static String ACCEPT_REQUEST = BASE_URL + "accept_request";

    public static String REJECT_REQUEST = BASE_URL + "reject_request";

    public static String COMPLETE_REQUEST = BASE_URL + "complete_request";

    public static String REQUEST_HISTORY = BASE_URL + "request_history";

    public static String LEADERBOARD = BASE_URL + "leaderboard";

}
