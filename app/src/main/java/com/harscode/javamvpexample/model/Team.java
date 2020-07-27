package com.harscode.javamvpexample.model;

import androidx.annotation.Keep;

import com.google.gson.annotations.SerializedName;

@Keep
public class Team {

	@SerializedName("strTeam")
	private String strTeam;

	@SerializedName("strLeague")
	private String strLeague;

	@SerializedName("idTeam")
	private String idTeam;

	@SerializedName("strDescriptionEN")
	private String strDescriptionEN;

	@SerializedName("strStadium")
	private String strStadium;

	@SerializedName("strTeamBadge")
	private String strTeamBadge;

	public void setStrTeam(String strTeam){
		this.strTeam = strTeam;
	}

	public String getStrTeam(){
		return strTeam;
	}

	public void setStrLeague(String strLeague){
		this.strLeague = strLeague;
	}

	public String getStrLeague(){
		return strLeague;
	}

	public void setIdTeam(String idTeam){
		this.idTeam = idTeam;
	}

	public String getIdTeam(){
		return idTeam;
	}

	public void setStrDescriptionEN(String strDescriptionEN){
		this.strDescriptionEN = strDescriptionEN;
	}

	public String getStrDescriptionEN(){
		return strDescriptionEN;
	}

	public void setStrStadium(String strStadium){
		this.strStadium = strStadium;
	}

	public String getStrStadium(){
		return strStadium;
	}

	public void setStrTeamBadge(String strTeamBadge){
		this.strTeamBadge = strTeamBadge;
	}

	public String getStrTeamBadge(){
		return strTeamBadge;
	}
}