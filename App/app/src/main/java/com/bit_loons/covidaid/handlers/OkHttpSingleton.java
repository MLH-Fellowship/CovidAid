package com.bit_loons.covidaid.handlers;

import java.net.CookieManager;
import java.net.CookiePolicy;

import okhttp3.JavaNetCookieJar;
import okhttp3.OkHttpClient;

public class OkHttpSingleton {
    private static OkHttpSingleton singletonInstance;

    // No need to be static; OkHttpSingleton is unique so is this.
    private OkHttpClient client;

    // Private so that this cannot be instantiated.
    private OkHttpSingleton() {
        CookieManager cookieManager = new CookieManager();
        cookieManager.setCookiePolicy(CookiePolicy.ACCEPT_ALL);
        client = new OkHttpClient.Builder()
                .cookieJar(new JavaNetCookieJar(cookieManager))
                .retryOnConnectionFailure(true)
                .build();
    }

    public static OkHttpSingleton getInstance() {
        if (singletonInstance == null) {
            singletonInstance = new OkHttpSingleton();
        }
        return singletonInstance;
    }

    // In case you just need the unique OkHttpClient instance.
    public OkHttpClient getClient() {
        return client;
    }

    public void closeConnections() {
        client.dispatcher().cancelAll();
    }
}
