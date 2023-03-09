package com.tensor.myapplication.model;

import com.google.gson.annotations.SerializedName;

public class HourItem{

	@SerializedName("feelslike_c")
	private Object feelslikeC;

	@SerializedName("feelslike_f")
	private Object feelslikeF;

	@SerializedName("wind_degree")
	private int windDegree;

	@SerializedName("windchill_f")
	private Object windchillF;

	@SerializedName("windchill_c")
	private Object windchillC;

	@SerializedName("temp_c")
	private Object tempC;

	@SerializedName("temp_f")
	private Object tempF;

	@SerializedName("cloud")
	private int cloud;

	@SerializedName("wind_kph")
	private Object windKph;

	@SerializedName("wind_mph")
	private Object windMph;

	@SerializedName("humidity")
	private int humidity;

	@SerializedName("dewpoint_f")
	private Object dewpointF;

	@SerializedName("will_it_rain")
	private int willItRain;

	@SerializedName("uv")
	private Object uv;

	@SerializedName("heatindex_f")
	private Object heatindexF;

	@SerializedName("dewpoint_c")
	private Object dewpointC;

	@SerializedName("is_day")
	private int isDay;

	@SerializedName("precip_in")
	private Object precipIn;

	@SerializedName("heatindex_c")
	private Object heatindexC;

	@SerializedName("wind_dir")
	private String windDir;

	@SerializedName("gust_mph")
	private Object gustMph;

	@SerializedName("pressure_in")
	private Object pressureIn;

	@SerializedName("chance_of_rain")
	private int chanceOfRain;

	@SerializedName("gust_kph")
	private Object gustKph;

	@SerializedName("precip_mm")
	private Object precipMm;

	@SerializedName("condition")
	private Condition condition;

	@SerializedName("will_it_snow")
	private int willItSnow;

	@SerializedName("vis_km")
	private Object visKm;

	@SerializedName("time_epoch")
	private int timeEpoch;

	@SerializedName("time")
	private String time;

	@SerializedName("chance_of_snow")
	private int chanceOfSnow;

	@SerializedName("pressure_mb")
	private Object pressureMb;

	@SerializedName("vis_miles")
	private Object visMiles;

	public Object getFeelslikeC(){
		return feelslikeC;
	}

	public Object getFeelslikeF(){
		return feelslikeF;
	}

	public int getWindDegree(){
		return windDegree;
	}

	public Object getWindchillF(){
		return windchillF;
	}

	public Object getWindchillC(){
		return windchillC;
	}

	public Object getTempC(){
		return tempC;
	}

	public Object getTempF(){
		return tempF;
	}

	public int getCloud(){
		return cloud;
	}

	public Object getWindKph(){
		return windKph;
	}

	public Object getWindMph(){
		return windMph;
	}

	public int getHumidity(){
		return humidity;
	}

	public Object getDewpointF(){
		return dewpointF;
	}

	public int getWillItRain(){
		return willItRain;
	}

	public Object getUv(){
		return uv;
	}

	public Object getHeatindexF(){
		return heatindexF;
	}

	public Object getDewpointC(){
		return dewpointC;
	}

	public int getIsDay(){
		return isDay;
	}

	public Object getPrecipIn(){
		return precipIn;
	}

	public Object getHeatindexC(){
		return heatindexC;
	}

	public String getWindDir(){
		return windDir;
	}

	public Object getGustMph(){
		return gustMph;
	}

	public Object getPressureIn(){
		return pressureIn;
	}

	public int getChanceOfRain(){
		return chanceOfRain;
	}

	public Object getGustKph(){
		return gustKph;
	}

	public Object getPrecipMm(){
		return precipMm;
	}

	public Condition getCondition(){
		return condition;
	}

	public int getWillItSnow(){
		return willItSnow;
	}

	public Object getVisKm(){
		return visKm;
	}

	public int getTimeEpoch(){
		return timeEpoch;
	}

	public String getTime(){
		return time;
	}

	public int getChanceOfSnow(){
		return chanceOfSnow;
	}

	public Object getPressureMb(){
		return pressureMb;
	}

	public Object getVisMiles(){
		return visMiles;
	}
}