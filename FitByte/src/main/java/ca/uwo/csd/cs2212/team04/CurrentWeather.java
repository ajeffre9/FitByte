package ca.uwo.csd.cs2212.team04;
/**
 * CurrentWeather class that uses the API to get data of current weather
 * 
 * @author cs2212_w2016_team04
 */
public class CurrentWeather {
	private String localWeather;
	private static String weatherType;
	private static String weatherDescription;
	private int temperature;
	
	/**
	 * Constructor: Initialize variables.
	 */
	public CurrentWeather(){
		WeatherData d = new WeatherData();
		this.localWeather = d.getWeatherType();
		this.temperature = d.getTemperature();
		//this.weatherType = weatherType;
		//this.weatherDescription = weatherDescription;
	}
	
	/**
	 * getLocalWeather method get the local weather
	 * 
	 * @return locakWeather string
	 */
	public String getLocalWeather(){
		return this.localWeather;
	}
	
	/**
	 * setWeather method set the current weather
	 */
	public void setWeather(){
		CurrentWeather weatherLondon = new CurrentWeather();
		String weather = weatherLondon.getLocalWeather().substring(0, 2);
		temperature = weatherLondon.getTemperature();

		
		//sun
		if(weather.equals("01")){
			weatherType = "sun";
			weatherDescription = "It's a sunny day!\nLet's open the door and get moved!";
		}
		//rain
		else if(weather.equals("09")||weather.equals("10")||weather.equals("11")){
			weatherType = "rain";
			weatherDescription = "A romantic day if you \nwanna dance in the rain.";
		}
		//snow
		else if(weather.equals("13")){
			weatherType = "snow";
			weatherDescription = "Olaf wanna play with you!";
		}
		//cloud
		else{
			weatherType = "cloud";
			if(weather.equals("02"))
				weatherDescription = "What is the difference between \nfew clouds with a clear sky?";
			else
				weatherDescription = "I can't see the sun.";
		}
	
	}
	
	/**
	 * getWeather method to get the weather
	 * @return weatherType
	 */
	public String getWeather(){
		return weatherType;
	}
	
	/**
	 * getweatherDescription method to get the weather Description
	 * @return weatherDescription
	 */
	public String getWeatherDescription(){
		return weatherDescription;
	}
	
	/**
	 * getTemperature method to get the temperature
	 * @return temperature
	 */
	public int getTemperature(){
		return temperature;
	}
	
}

