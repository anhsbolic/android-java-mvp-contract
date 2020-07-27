package com.harscode.javamvpexample.api.response;

import androidx.annotation.Keep;

import com.google.gson.annotations.SerializedName;
import com.harscode.javamvpexample.model.Team;

import java.util.List;

@Keep
public class TeamDetailResponse {

    @SerializedName("teams") private List<Team> teams;

    public List<Team> getTeams() {
        return teams;
    }

    public void setTeams(List<Team> teams) {
        this.teams = teams;
    }
}
