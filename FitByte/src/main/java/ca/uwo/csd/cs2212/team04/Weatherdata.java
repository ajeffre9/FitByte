package ca.uwo.csd.cs2212.team04;

import org.json.JSONArray;
import org.json.JSONObject;
import java.io.Serializable;

/**
 * still need to figure out the problem with parsing the time
 *
 */

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by owner on 2016-03-23.
 */
public class WeatherData extends WeatherApi implements Serializable {

    private final String DEGREE  = "\u00b0";
    private transient JSONObject temp;
    private transient JSONArray array, arrayHourly;
    private String date;

    //World weather online API
    private int mintempF, mintempC, maxtempF, maxtempC, tempC, tempF, feelsLikeC, feelsLikeF, windChillC, windChillF, windSpeedMiles, windSpeedKmph, humidity;
    private double precipMM;
    private String city , state, country, location, windDir, weatherDesc;

    public WeatherData(){

        this.temp = null;
        this.array = null;
        this.arrayHourly = null;
        this.date = null;
        this.city = null;
        this.state = null;
        this.country = null;
        this.location = null;
        this.mintempF = 0;
        this.mintempC = 0;
        this.maxtempF = 0;
        this.maxtempC = 0;
        this.tempC = 0;
        this.tempF = 0;
        this.feelsLikeC = 0;
        this.feelsLikeF = 0;
        this.windChillC = 0;
        this.windChillF = 0;
        this.windSpeedMiles = 0;
        this.windSpeedKmph = 0;
        this.humidity = 0;
        this.precipMM = 0;
        this.windDir = null;
        this.weatherDesc = null;

    }

    public WeatherData(Boolean check) {
        try {

            if (!check || check) {

                this.temp = null;
                this.array = null;
                this.arrayHourly = null;
                this.date = null;
                this.city = null;
                this.state = null;
                this.country = null;
                this.location = null;
                this.mintempF = 0;
                this.mintempC = 0;
                this.maxtempF = 0;
                this.maxtempC = 0;
                this.tempC = 0;
                this.tempF = 0;
                this.feelsLikeC = 0;
                this.feelsLikeF = 0;
                this.windChillC = 0;
                this.windChillF = 0;
                this.windSpeedMiles = 0;
                this.windSpeedKmph = 0;
                this.humidity = 0;
                this.precipMM = 0;
                this.windDir = null;
                this.weatherDesc = null;
                setDate();
                refreshData();

            }

        }catch (Exception ex){
            System.out.println("Sorry the Weather API is currently experiencing a problem");
        }finally {

        }
    }

    /**
     *  Set the current date for the day the data is collected
     */
    public void setDate(){

        Date dNow = new Date();
        SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd");
        date = ft.format(dNow);

    }

    /**
     * Get the date for the day
     * @return date
     */
    public String getDate(){

        return date;

    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation() {
        this.location = getCity() +"," +getState() +"," +getCountry() +"&" ;
    }

    public void setTemp(JSONObject temp) {
        this.temp = temp;
        System.out.println(temp);
    }

    public JSONObject getTemp() {
        return temp;
    }

    public void setArray(){
        array = getTemp().getJSONObject("data").getJSONArray("weather");
    }

    public JSONArray getArray(){
        return array;
    }

    public void setArrayHourly(){
        arrayHourly = getTemp().getJSONObject("data").getJSONArray("weather").getJSONObject(0).getJSONArray("hourly");
    }

    public void setArrayHourly(JSONArray jsarray){
        this.arrayHourly = jsarray;
    }

    public JSONArray getArrayHourly(){
        return arrayHourly;
    }

    public int getTempC() {
        return tempC;
    }

    public void setTempC() {

        tempC = getArrayHourly().getJSONObject(0).getInt("tempC");
        System.out.println(tempC +DEGREE +"C");
    }

    public int getTempF() { return tempF; }

    public void setTempF() {
        tempF = getArrayHourly().getJSONObject(0).getInt("tempF");
        System.out.println(tempF +DEGREE+"F");
    }

    public int getMintempF() {
        return mintempF;
    }

    public void setMintempF() {
        mintempF = getArray().getJSONObject(0).getInt("mintempF");
        System.out.println(mintempF +DEGREE +"F");
    }

    public int getMintempC() { return mintempC; }

    public void setMintempC() {
        mintempC = getArray().getJSONObject(0).getInt("mintempC");
        System.out.println(mintempC +DEGREE +"C");
    }

    public int getMaxtempF() { return maxtempF; }


    public void setMaxtempF() {
        maxtempF = getArray().getJSONObject(0).getInt("maxtempF");
        System.out.println(maxtempF +DEGREE +"F");
    }

    public int getMaxtempC() { return maxtempC; }

    public void setMaxtempC() {
        maxtempC = getArray().getJSONObject(0).getInt("maxtempC");
        System.out.println(maxtempC +DEGREE +"C");
    }

    public int getFeelsLikeC() { return feelsLikeC; }

    public void setFeelsLikeC() {
        feelsLikeC = getArrayHourly().getJSONObject(0).getInt("FeelsLikeC");
        System.out.println(feelsLikeC +DEGREE +"C");
    }

    public int getFeelsLikeF() {
        return feelsLikeF;
    }

    public void setFeelsLikeF() {
        feelsLikeF = getArrayHourly().getJSONObject(0).getInt("FeelsLikeF");
        System.out.println(feelsLikeF +DEGREE +"F");
    }

    public int getWindChillC() {
        return windChillC;
    }

    public void setWindChillC() {
        windChillC = getArrayHourly().getJSONObject(0).getInt("WindChillC");
        System.out.println(windChillC +DEGREE +"C");
    }

    public int getWindChillF() {
        return windChillF;
    }

    public void setWindChillF() {
        windChillF = getArrayHourly().getJSONObject(0).getInt("WindChillF");
        System.out.println(windChillF +DEGREE +"F");
    }

    public int getWindSpeedMiles() {
        return windSpeedMiles;
    }

    public void setWindSpeedMiles() {
        windSpeedMiles = getArrayHourly().getJSONObject(0).getInt("windspeedMiles");
        System.out.println(windSpeedMiles +" MPH");
    }

    public int getWindSpeedKmph() {
        return windSpeedKmph;
    }

    public void setWindSpeedKmph() {
        windSpeedKmph = getArrayHourly().getJSONObject(0).getInt("windspeedKmph");
        System.out.println(windSpeedKmph +" Kmph");
    }

    public int getHumidity() {
        return humidity;
    }

    public void setHumidity() {
        humidity = getArrayHourly().getJSONObject(0).getInt("humidity");
        System.out.println(humidity +"%");
    }

    public double getPrecipMM() {
        return precipMM;
    }

    public void setPrecipMM() {
        precipMM = getArrayHourly().getJSONObject(0).getDouble("precipMM");
        System.out.println(precipMM +"mm");
    }

    public String getWindDir() {
        return windDir;
    }

    public void setWindDir() {

        double info = getArrayHourly().getJSONObject(0).getInt("winddirDegree");
        if (info >= 0 && info < 22.5) {
            windDir = "North";
        } else if (info >= 22.5 && info < 67.5) {
            windDir = "Northeast";
        } else if (info >= 67.5 && info < 112.5) {
            windDir = "East";
        } else if (info >= 112.5 && info < 157.5) {
            windDir = "Southeast";
        } else if (info >= 157.5 && info < 202.5) {
            windDir = "South";
        } else if (info >= 202.5 && info < 247.5) {
            windDir = "Southwest";
        } else if (info >= 247.5 && info < 292.5) {
            windDir = "West";
        } else if (info >= 292.5 && info < 337.5) {
            windDir = "Northwest";
        } else if (info >= 337.5 && info <= 360) {
            windDir = "North";
        } else {
            windDir = "Up";
        }
        System.out.println(windDir);
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setMintempF(int mintempF) {
        this.mintempF = mintempF;
    }

    public void setMintempC(int mintempC) {
        this.mintempC = mintempC;
    }

    public void setMaxtempF(int maxtempF) {
        this.maxtempF = maxtempF;
    }

    public void setMaxtempC(int maxtempC) {
        this.maxtempC = maxtempC;
    }

    public void setTempC(int tempC) {
        this.tempC = tempC;
    }

    public void setTempF(int tempF) {
        this.tempF = tempF;
    }

    public void setFeelsLikeC(int feelsLikeC) {
        this.feelsLikeC = feelsLikeC;
    }

    public void setFeelsLikeF(int feelsLikeF) {
        this.feelsLikeF = feelsLikeF;
    }

    public void setWindChillC(int windChillC) {
        this.windChillC = windChillC;
    }

    public void setWindChillF(int windChillF) {
        this.windChillF = windChillF;
    }

    public void setWindSpeedMiles(int windSpeedMiles) {
        this.windSpeedMiles = windSpeedMiles;
    }

    public void setWindSpeedKmph(int windSpeedKmph) {
        this.windSpeedKmph = windSpeedKmph;
    }

    public void setHumidity(int humidity) {
        this.humidity = humidity;
    }

    public void setPrecipMM(double precipMM) {
        this.precipMM = precipMM;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setWindDir(String windDir) {
        this.windDir = windDir;
    }

    public void setWeatherDesc(String weatherDesc) {
        this.weatherDesc = weatherDesc;
    }

    public String getWeatherDesc() {
        return weatherDesc;
    }

    public void setWeatherDesc() {

        weatherDesc = getArrayHourly().getJSONObject(0).getJSONArray("weatherDesc").getJSONObject(0).getString("value");
        System.out.println(weatherDesc);
    }

    public void refreshData() {
        setDate();
        setTemp(sendGet("London,Ontario,Canada&tp=24&date=" +getDate() +"&format=json"));
        setArray();
        setArrayHourly();
        setTempC();setMintempC();setMaxtempC();setWindChillC();setFeelsLikeC();
        setTempF();setMintempF();setMaxtempF();setWindChillF();setFeelsLikeF();
        setWindDir();setWindSpeedKmph();setWindSpeedMiles();setWeatherDesc();setPrecipMM();
    }

    public void setData(){

        setTempC();setWindChillC();setFeelsLikeC();
        setTempF();setWindChillF();setFeelsLikeF();
        setWindDir();setWindSpeedKmph();setWindSpeedMiles();setWeatherDesc();setPrecipMM();

    }

    public static void main(String[] args){

        WeatherData temp1 = new WeatherData(false);
    }

}
