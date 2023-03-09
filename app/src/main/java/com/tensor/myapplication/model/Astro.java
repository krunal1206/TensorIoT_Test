package com.tensor.myapplication.model;

import com.google.gson.annotations.SerializedName;

public class Astro{

	@SerializedName("moonset")
	private String moonset;

	@SerializedName("moon_illumination")
	private String moonIllumination;

	@SerializedName("sunrise")
	private String sunrise;

	@SerializedName("moon_phase")
	private String moonPhase;

	@SerializedName("sunset")
	private String sunset;

	@SerializedName("is_moon_up")
	private int isMoonUp;

	@SerializedName("is_sun_up")
	private int isSunUp;

	@SerializedName("moonrise")
	private String moonrise;

	public String getMoonset(){
		return moonset;
	}

	public String getMoonIllumination(){
		return moonIllumination;
	}

	public String getSunrise(){
		return sunrise;
	}

	public String getMoonPhase(){
		return moonPhase;
	}

	public String getSunset(){
		return sunset;
	}

	public int getIsMoonUp(){
		return isMoonUp;
	}

	public int getIsSunUp(){
		return isSunUp;
	}

	public String getMoonrise(){
		return moonrise;
	}
}