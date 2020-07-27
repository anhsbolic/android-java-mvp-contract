package com.harscode.javamvpexample.api;

import com.harscode.javamvpexample.BuildConfig;

public class ApiServices {

    public static SportApiServices getSportApiServices() {
        String baseUrl = BuildConfig.TSDB_BASE_URL + BuildConfig.TSDB_API_KEY + "/";
        return RetrofitClient.getClient(baseUrl).create(SportApiServices.class);
    }
}
