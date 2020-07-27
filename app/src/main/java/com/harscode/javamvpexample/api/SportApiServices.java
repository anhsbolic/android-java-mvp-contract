package com.harscode.javamvpexample.api;

import androidx.annotation.NonNull;

import com.harscode.javamvpexample.api.response.TeamDetailResponse;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface SportApiServices {

    @GET("lookupteam.php")
    Observable<TeamDetailResponse> getTeamDetails(@Query("id") @NonNull String idTeam);
}
