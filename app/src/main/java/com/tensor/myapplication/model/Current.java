package com.tensor.myapplication.model;

import com.google.gson.annotations.SerializedName;

public class Current{

	@SerializedName("feelslike_c")
	private Object feelslikeC;

	@SerializedName("uv")
	private Object uv;

	@SerializedName("last_updated")
	private String lastUpdated;

	@SerializedName("feelslike_f")
	private Object feelslikeF;

	@SerializedName("wind_degree")
	private int windDegree;

	@SerializedName("last_updated_epoch")
	private int lastUpdatedEpoch;

	@SerializedName("is_day")
	private int isDay;

	@SerializedName("precip_in")
	private Object precipIn;

	@SerializedName("wind_dir")
	private String windDir;

	@SerializedName("gust_mph")
	private Object gustMph;

	@SerializedName("temp_c")
	private Object tempC;

	@SerializedName("pressure_in")
	private Object pressureIn;

	@SerializedName("gust_kph")
	private Object gustKph;

	@SerializedName("temp_f")
	private Object tempF;

	@SerializedName("precip_mm")
	private Object precipMm;

	@SerializedName("cloud")
	private int cloud;

	@SerializedName("wind_kph")
	private Object windKph;

	@SerializedName("condition")
	private Condition condition;

	@SerializedName("wind_mph")
	private Object windMph;

	@SerializedName("vis_km")
	private Object visKm;

	@SerializedName("humidity")
	private int humidity;

	@SerializedName("pressure_mb")
	private Object pressureMb;

	@SerializedName("vis_miles")
	private Object visMiles;

	public Object getFeelslikeC(){
		return feelslikeC;
	}

	public Object getUv(){
		return uv;
	}

	public String getLastUpdated(){
		return lastUpdated;
	}

	public Object getFeelslikeF(){
		return feelslikeF;
	}

	public int getWindDegree(){
		return windDegree;
	}

	public int getLastUpdatedEpoch(){
		return lastUpdatedEpoch;
	}

	public int getIsDay(){
		return isDay;
	}

	public Object getPrecipIn(){
		return precipIn;
	}

	public String getWindDir(){
		return windDir;
	}

	public Object getGustMph(){
		return gustMph;
	}

	public Object getTempC(){
		return tempC;
	}

	public Object getPressureIn(){
		return pressureIn;
	}

	public Object getGustKph(){
		return gustKph;
	}

	public Object getTempF(){
		return tempF;
	}

	public Object getPrecipMm(){
		return precipMm;
	}

	public int getCloud(){
		return cloud;
	}

	public Object getWindKph(){
		return windKph;
	}

	public Condition getCondition(){
		return condition;
	}

	public Object getWindMph(){
		return windMph;
	}

	public Object getVisKm(){
		return visKm;
	}

	public int getHumidity(){
		return humidity;
	}

	public Object getPressureMb(){
		return pressureMb;
	}

	public Object getVisMiles(){
		return visMiles;
	}
}