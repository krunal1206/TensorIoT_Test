package com.tensor.myapplication.model;

import com.google.gson.annotations.SerializedName;

public class Day{

	@SerializedName("avgvis_km")
	private Object avgvisKm;

	@SerializedName("uv")
	private Object uv;

	@SerializedName("avgtemp_f")
	private Object avgtempF;

	@SerializedName("avgtemp_c")
	private Object avgtempC;

	@SerializedName("daily_chance_of_snow")
	private int dailyChanceOfSnow;

	@SerializedName("maxtemp_c")
	private Object maxtempC;

	@SerializedName("maxtemp_f")
	private Object maxtempF;

	@SerializedName("mintemp_c")
	private Object mintempC;

	@SerializedName("avgvis_miles")
	private Object avgvisMiles;

	@SerializedName("daily_will_it_rain")
	private int dailyWillItRain;

	@SerializedName("mintemp_f")
	private Object mintempF;

	@SerializedName("totalprecip_in")
	private Object totalprecipIn;

	@SerializedName("totalsnow_cm")
	private Object totalsnowCm;

	@SerializedName("avghumidity")
	private Object avghumidity;

	@SerializedName("condition")
	private Condition condition;

	@SerializedName("maxwind_kph")
	private Object maxwindKph;

	@SerializedName("maxwind_mph")
	private Object maxwindMph;

	@SerializedName("daily_chance_of_rain")
	private int dailyChanceOfRain;

	@SerializedName("totalprecip_mm")
	private Object totalprecipMm;

	@SerializedName("daily_will_it_snow")
	private int dailyWillItSnow;

	public Object getAvgvisKm(){
		return avgvisKm;
	}

	public Object getUv(){
		return uv;
	}

	public Object getAvgtempF(){
		return avgtempF;
	}

	public Object getAvgtempC(){
		return avgtempC;
	}

	public int getDailyChanceOfSnow(){
		return dailyChanceOfSnow;
	}

	public Object getMaxtempC(){
		return maxtempC;
	}

	public Object getMaxtempF(){
		return maxtempF;
	}

	public Object getMintempC(){
		return mintempC;
	}

	public Object getAvgvisMiles(){
		return avgvisMiles;
	}

	public int getDailyWillItRain(){
		return dailyWillItRain;
	}

	public Object getMintempF(){
		return mintempF;
	}

	public Object getTotalprecipIn(){
		return totalprecipIn;
	}

	public Object getTotalsnowCm(){
		return totalsnowCm;
	}

	public Object getAvghumidity(){
		return avghumidity;
	}

	public Condition getCondition(){
		return condition;
	}

	public Object getMaxwindKph(){
		return maxwindKph;
	}

	public Object getMaxwindMph(){
		return maxwindMph;
	}

	public int getDailyChanceOfRain(){
		return dailyChanceOfRain;
	}

	public Object getTotalprecipMm(){
		return totalprecipMm;
	}

	public int getDailyWillItSnow(){
		return dailyWillItSnow;
	}
}