package id.umma.prayertimes.fatahillah.models;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class Results{

	@SerializedName("settings")
	private Settings settings;

	@SerializedName("datetime")
	private List<DatetimeItem> datetime;

	@SerializedName("location")
	private Location location;

	public Settings getSettings(){
		return settings;
	}

	public List<DatetimeItem> getDatetime(){
		return datetime;
	}

	public Location getLocation(){
		return location;
	}
}