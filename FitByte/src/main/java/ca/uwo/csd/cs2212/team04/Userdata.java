package ca.uwo.csd.cs2212.team04;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.Serializable;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutionException;

/**
 * User Data class that uses the API to get data from the server
 * @author cs2212_w2016_team04
 */
public class Userdata extends Api implements Serializable {

    private JSONObject temp;
    private String date;
    //Fitbit API variables
    private double dailyCalories, dailyCaloriesBMR, distance;
    private int steps, floors, minutesSedentary, minutesLightlyActive, minutesFairlyActive, minutesVeryActive, elevation;

    /**
     * Constructor: Initialize variables using test data or requests data.
     * If fakeData is true then pass test data.
     * @param fakeData
     */
    public Userdata(boolean fakeData){

        if(fakeData){

            temp = null;
            date = null;
            dailyCalories = 1027;
            dailyCaloriesBMR = 60;
            elevation = 50;
            steps = 1500;
            floors = 30;
            minutesSedentary = 1000;
            minutesLightlyActive = 90;
            minutesFairlyActive = 5;
            minutesVeryActive = 50;
            distance = 60.0;

        }else {

            temp = null;
            date = null;
            dailyCalories = 0;
            dailyCaloriesBMR = 0;
            elevation = 0;
            steps = 0;
            floors = 0;
            minutesSedentary = 0;
            minutesLightlyActive = 0;
            minutesFairlyActive = 0;
            minutesVeryActive = 0;
            distance = 0;
            this.setDate();
            this.refreshData();
        }

    }

    /**
     *  Set the current date for teh day the data is collected
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

    /**
     *  Request DailyCalories data at this point in time from API and set the value
     */
    public void setDailyCalories(){
        temp =  getInfo("activities/tracker/calories/date/" +getDate() +"/1d.json");
        JSONArray array = temp.getJSONArray("activities-tracker-calories");
        dailyCalories += (array.getJSONObject(0).getDouble("value"));
        System.out.println(dailyCalories);

    }

    /**
     * Get the Users current Calorie value
     * @return dailyCalories
     */
    public double getDailyCalories(){
        return dailyCalories;
    }

    /**
     * Get the Users current steps value
     * @return steps
     */
    public int getSteps() {
        return steps;
    }

    /**
     *  Request steps data at this point in time from API and set the value
     */
    public void setSteps() {
        temp =  getInfo("activities/tracker/steps/date/" +getDate() +"/1d.json");
        JSONArray array = temp.getJSONArray("activities-tracker-steps");
        steps += (array.getJSONObject(0).getInt("value"));
        System.out.println(steps);
    }

    /**
     * Get the Users current dailyCaloriesBMR value
     * @return dailyCaloriesBMR
     */
    public double getDailyCaloriesBMR() {
        return dailyCaloriesBMR;
    }

    /**
     *  Request DailyCaloriesBMR data at this point in time from API and set the value
     */
    public void setDailyCaloriesBMR() {

        temp =  getInfo("activities/caloriesBMR/date/" +getDate() +"/1d.json");
        JSONArray array = temp.getJSONArray("activities-caloriesBMR");
        dailyCaloriesBMR += (array.getJSONObject(0).getDouble("value"));
        System.out.println(dailyCaloriesBMR);
    }

    /**
     * Get the Users current elevation value
     * @return elevation
     */
    public int getElevation() {
        return elevation;
    }

    /**
     *  Request Elevation data at this point in time from API and set the value
     */
    public void setElevation() {

        temp =  getInfo("activities/tracker/elevation/date/" +getDate() +"/1d.json");
        JSONArray array = temp.getJSONArray("activities-tracker-elevation");
        elevation += (array.getJSONObject(0).getInt("value"));
        System.out.println(elevation);

    }

    /**
     * Get the Users current floors value
     * @return floors
     */
    public int getFloors() {
        return floors;
    }

    /**
     *  Request Floors data at this point in time from API and set the value
     */
    public void setFloors() {

        temp =  getInfo("activities/tracker/floors/date/" +getDate() +"/1d.json");
        JSONArray array = temp.getJSONArray("activities-tracker-floors");
        floors += (int) (array.getJSONObject(0).getInt("value"));
        System.out.println(floors);

    }

    /**
     * Get the Users current minutesSedentary value
     * @return minutesSedentary
     */
    public int getMinutesSedentary() {
        return minutesSedentary;
    }

    /**
     *  Request minutesSedentary data at this point in time from API and set the value
     */
    public void setMinutesSedentary() {

        temp =  getInfo("activities/tracker/minutesSedentary/date/" +getDate() +"/1d.json");
        JSONArray array = temp.getJSONArray("activities-tracker-minutesSedentary");
        minutesSedentary += (array.getJSONObject(0).getInt("value"));
        System.out.println(minutesSedentary);

    }

    /**
     * Get the Users current minutesLightlyActive value
     * @return minutesLightlyActive
     */
    public int getMinutesLightlyActive() {
        return minutesLightlyActive;
    }

    /**
     *  Request minutesLightlyActive data at this point in time from API and set the value
     */
    public void setMinutesLightlyActive() {

        temp =  getInfo("activities/tracker/minutesLightlyActive/date/" +getDate() +"/1d.json");
        JSONArray array = temp.getJSONArray("activities-tracker-minutesLightlyActive");
        minutesLightlyActive += array.getJSONObject(0).getInt("value");
        System.out.println(minutesLightlyActive);

    }

    /**
     * Get the users minutesFairlyActive value
     * @return
     */
    public int getMinutesFairlyActive() {
        return minutesFairlyActive;
    }

    /**
     *  Request MinutesActive data at this point in time from API and set the value
     */
    public void setMinutesFairlyActive() {

        temp =  getInfo("activities/tracker/minutesFairlyActive/date/" +getDate() +"/1d.json");
        JSONArray array = temp.getJSONArray("activities-tracker-minutesFairlyActive");
        minutesFairlyActive += array.getJSONObject(0).getInt("value");
        System.out.println(minutesFairlyActive);

    }

    /**
     * Get the minutesVeryActive for the day
     * @return minutesVeryActive
     */
    public int getMinutesVeryActive() {
        return minutesVeryActive;
    }

    /**
     *  Request MinutesVeryActive data at this point in time from API and set the value
     */
    public void setMinutesVeryActive() {

        temp =  getInfo("activities/tracker/minutesVeryActive/date/" +getDate() +"/1d.json");
        JSONArray array = temp.getJSONArray("activities-tracker-minutesVeryActive");
        minutesVeryActive += array.getJSONObject(0).getInt("value");
        System.out.println(minutesVeryActive);

    }
    /**
     * Get the distance for the day
     * @return distance
     */
    public double getDistance() {
        return distance;
    }

    /**
     *  Request MinutesVeryActive data at this point in time from API and set the value
     */
    public void setDistance() {

        temp =  getInfo("activities/tracker/distance/date/" +getDate() +"/1d.json");
        JSONArray array = temp.getJSONArray("activities-tracker-distance");
        distance += array.getJSONObject(0).getDouble("value");
        System.out.println(distance);

    }

    /**
     *  Refreshes User data
     */
    public void refreshData(){

        try {
            this.setDailyCalories();
            this.setDailyCaloriesBMR();
            this.setElevation();
            this.setMinutesFairlyActive();
            this.setFloors();
            this.setMinutesSedentary();
            this.setMinutesVeryActive();
            this.setMinutesLightlyActive();
            this.setSteps();
            this.setDistance();

        } catch (Exception ex) {
            System.out.println("Sorry we are currently experiencing an API error: " + ex.getMessage());
        } finally {

        }
    }

    /**
     * Main class that is used to check whether the code works
     * @param args
     */
    public static void main (String args[]){

        Userdata temp1 = new Userdata(false);
        System.out.println(temp1.getSteps());

    }

}
