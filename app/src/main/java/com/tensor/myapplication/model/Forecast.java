package com.tensor.myapplication.model;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class Forecast{

	@SerializedName("forecastday")
	private List<Forecastday> forecastday;

	public List<Forecastday> getForecastday(){
		return forecastday;
	}
}