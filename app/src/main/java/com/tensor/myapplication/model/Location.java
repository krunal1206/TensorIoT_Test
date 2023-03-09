package com.tensor.myapplication.model;

import com.google.gson.annotations.SerializedName;

public class Location{

	@SerializedName("localtime")
	private String localtime;

	@SerializedName("country")
	private String country;

	@SerializedName("localtime_epoch")
	private int localtimeEpoch;

	@SerializedName("name")
	private String name;

	@SerializedName("lon")
	private Object lon;

	@SerializedName("region")
	private String region;

	@SerializedName("lat")
	private Object lat;

	@SerializedName("tz_id")
	private String tzId;

	public String getLocaltime(){
		return localtime;
	}

	public String getCountry(){
		return country;
	}

	public int getLocaltimeEpoch(){
		return localtimeEpoch;
	}

	public String getName(){
		return name;
	}

	public Object getLon(){
		return lon;
	}

	public String getRegion(){
		return region;
	}

	public Object getLat(){
		return lat;
	}

	public String getTzId(){
		return tzId;
	}
}