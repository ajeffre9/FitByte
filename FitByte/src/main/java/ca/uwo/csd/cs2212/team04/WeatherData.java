package ca.uwo.csd.cs2212.team04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.JOptionPane;

import org.json.JSONObject;
import org.json.JSONException;

public class WeatherData {
	
	private JSONObject temp;
	private String local = "http://api.openweathermap.org/data/2.5/weather?q=London,ca&appid=294acf279d201c5ad1156a0bb079e054";
	private String weather;
	private String weatherType;
	private double temperature;
	
	/**
	 * Constructor: Initialize variables.
	 */
	public WeatherData(){
			getWeather();
			try{
			weatherType = temp.getJSONArray("weather").getJSONObject(0).getString("icon");
			temperature = temp.getJSONObject("main").getDouble("temp") - 273;
			} catch (NullPointerException e){
				JOptionPane.showMessageDialog(null, "No Weather Data, sorry. \nTry again please.");
			}
	}
	
	/**
	 * getWeather method used to get weather
	 */
	private void getWeather(){
		try {
			URL url = new URL(local);
			try {
				BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream()));
				weather = br.readLine();
				this.temp = new JSONObject(weather);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				System.out.println("IOException");
			}catch(JSONException e){
				System.out.println("Not a good Json String");
			}
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			System.out.println("Cannot open the weather website");
		} catch (NullPointerException e){
			JOptionPane.showMessageDialog(null, "No Weather Data Found");
		}
	}
	
	/**
	 * getWeatherType method used to get weather type
	 * @return weatherType
	 */
	public String getWeatherType(){
		return this.weatherType;
	}
	
	/**
	 * getTemperature method used to get weather
	 * @return temperature
	 */
	public int getTemperature(){
		return new Double(this.temperature).intValue();
	}
	
}
