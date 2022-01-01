package id.umma.prayertimes.fatahillah.models;

import com.google.gson.annotations.SerializedName;

public class Location{

	@SerializedName("elevation")
	private double elevation;

	@SerializedName("country")
	private String country;

	@SerializedName("country_code")
	private String countryCode;

	@SerializedName("local_offset")
	private double localOffset;

	@SerializedName("city")
	private String city;

	@SerializedName("timezone")
	private String timezone;

	@SerializedName("latitude")
	private double latitude;

	@SerializedName("longitude")
	private double longitude;

	public double getElevation(){
		return elevation;
	}

	public String getCountry(){
		return country;
	}

	public String getCountryCode(){
		return countryCode;
	}

	public double getLocalOffset(){
		return localOffset;
	}

	public String getCity(){
		return city;
	}

	public String getTimezone(){
		return timezone;
	}

	public double getLatitude(){
		return latitude;
	}

	public double getLongitude(){
		return longitude;
	}
}