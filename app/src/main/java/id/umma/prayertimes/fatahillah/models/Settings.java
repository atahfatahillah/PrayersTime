package id.umma.prayertimes.fatahillah.models;

import com.google.gson.annotations.SerializedName;

public class Settings{

	@SerializedName("school")
	private String school;

	@SerializedName("juristic")
	private String juristic;

	@SerializedName("timeformat")
	private String timeformat;

	@SerializedName("highlat")
	private String highlat;

	@SerializedName("fajr_angle")
	private double fajrAngle;

	@SerializedName("isha_angle")
	private double ishaAngle;

	public String getSchool(){
		return school;
	}

	public String getJuristic(){
		return juristic;
	}

	public String getTimeformat(){
		return timeformat;
	}

	public String getHighlat(){
		return highlat;
	}

	public double getFajrAngle(){
		return fajrAngle;
	}

	public double getIshaAngle(){
		return ishaAngle;
	}
}