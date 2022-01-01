package id.umma.prayertimes.fatahillah.models;

import com.google.gson.annotations.SerializedName;

public class DatetimeItem{

	@SerializedName("date")
	private Date date;

	@SerializedName("times")
	private Times times;

	public Date getDate(){
		return date;
	}

	public Times getTimes(){
		return times;
	}
}