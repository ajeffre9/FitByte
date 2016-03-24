package ca.uwo.csd.cs2212.team04;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JOptionPane;

/**
 * User Data class that uses the API to get data from the server
 * 
 * @author cs2212_w2016_team04
 */
public class Userdata extends Api implements Serializable {

    private JSONObject temp;
    private double dailyCalories, dailyCaloriesBMR, distance, Bdistance,
            totalDistance;
    private int steps, floors, minutesSedentary, minutesLightlyActive,
            minutesFairlyActive, minutesVeryActive, elevation;
    private int Bstep, Bfloor, totalStep, totalFloor;
    private int peakZone, cardioZone, fatburnZone, outofZone, restingRate;
    private String date;
    private boolean fakeData;
    private int[] HeartRatevalue;
    private int[] Distancevalue;
    private int[] Stepvalue;
    private int[] Caloriesvalue;

    /**
     * Constructor: Initialize variables using test data or requests data. If
     * fakeData is true then pass test data.
     * 
     * @param fakeData
     */
    public Userdata(boolean fakeD) {
        fakeData = fakeD;

        if (fakeData) {

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
            peakZone = 20;
            cardioZone = 10;
            fatburnZone = 30;
            outofZone = 1;
            restingRate = 110;
            HeartRatevalue = new int[1440];
            for (int i = 0; i < 1440; i ++){
                HeartRatevalue [i] = 10;
            }

        } else {
            HeartRatevalue = new int[1440];
            Date dNow = new Date();
            setMinGraph();
            this.setDate(dNow);
            this.refreshData();
        }

    }

    /**
     * Set the current date for teh day the data is collected
     */
    public void setDate(Date dNow) {
        SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd");
        date = ft.format(dNow);
    }

    public void setMinGraph() {
        if (!fakeData) {
            temp = getInfo("activities/heart/date/today/1d/1min.json");
            JSONArray array = temp.getJSONObject("activities-heart-intraday")
                    .getJSONArray("dataset");
            for (int i = 0; i < 5; i++) {
                HeartRatevalue[i] = array.getJSONObject(i*15).getInt("value");
            }
        }
    }
    
    public int[] getMinGraph(){
        return HeartRatevalue;
    }

    /**
     * Get the date for the day
     * 
     * @return date
     */
    public String getDate() {
        return date;
    }

    /**
     * Request DailyCalories data at this point in time from API and set the
     * value
     */
    public void setDailyCalories() {
        if (!fakeData) {
            temp = getInfo("activities/tracker/calories/date/" + getDate()
                    + "/1d.json");
            JSONArray array = temp.getJSONArray("activities-tracker-calories");
            dailyCalories += (array.getJSONObject(0).getDouble("value"));
            System.out.println(dailyCalories);
        }
    }

    /**
     * Get the Users current Calorie value
     * 
     * @return dailyCalories
     */
    public double getDailyCalories() {
        return dailyCalories;
    }

    /**
     * Get the Users current steps value
     * 
     * @return steps
     */
    public int getSteps() {
        return steps;
    }

    /**
     * Request steps data at this point in time from API and set the value
     */
    public void setSteps() {
        if (!fakeData) {
            temp = getInfo("activities/tracker/steps/date/" + getDate()
                    + "/1d.json");
            JSONArray array = temp.getJSONArray("activities-tracker-steps");
            steps += (array.getJSONObject(0).getInt("value"));
            System.out.println(steps);
        }
    }

    /**
     * Get the Users current dailyCaloriesBMR value
     * 
     * @return dailyCaloriesBMR
     */
    public double getDailyCaloriesBMR() {
        return dailyCaloriesBMR;
    }

    /**
     * Request DailyCaloriesBMR data at this point in time from API and set the
     * value
     */
    public void setDailyCaloriesBMR() {
        if (fakeData) {
            temp = getInfo("activities/caloriesBMR/date/" + getDate()
                    + "/1d.json");
            JSONArray array = temp.getJSONArray("activities-caloriesBMR");
            dailyCaloriesBMR += (array.getJSONObject(0).getDouble("value"));
            System.out.println(dailyCaloriesBMR);
        }
    }

    /**
     * Get the Users current elevation value
     * 
     * @return elevation
     */
    public int getElevation() {
        return elevation;
    }

    /**
     * Request Elevation data at this point in time from API and set the value
     */
    public void setElevation() {
        if (fakeData) {
            temp = getInfo("activities/tracker/elevation/date/" + getDate()
                    + "/1d.json");
            JSONArray array = temp.getJSONArray("activities-tracker-elevation");
            elevation += (array.getJSONObject(0).getInt("value"));
            System.out.println(elevation);
        }
    }

    /**
     * Get the Users current floors value
     * 
     * @return floors
     */
    public int getFloors() {
        return floors;
    }

    /**
     * Request Floors data at this point in time from API and set the value
     */
    public void setFloors() {
        if (!fakeData) {
            temp = getInfo("activities/tracker/floors/date/" + getDate()
                    + "/1d.json");
            JSONArray array = temp.getJSONArray("activities-tracker-floors");
            floors += (int) (array.getJSONObject(0).getInt("value"));
            System.out.println(floors);
        }
    }

    /**
     * Get the Users current minutesSedentary value
     * 
     * @return minutesSedentary
     */
    public int getMinutesSedentary() {
        return minutesSedentary;
    }

    /**
     * Request minutesSedentary data at this point in time from API and set the
     * value
     */
    public void setMinutesSedentary() {
        if (!fakeData) {
            temp = getInfo("activities/tracker/minutesSedentary/date/"
                    + getDate() + "/1d.json");
            JSONArray array = temp
                    .getJSONArray("activities-tracker-minutesSedentary");
            minutesSedentary += (array.getJSONObject(0).getInt("value"));
            System.out.println(minutesSedentary);
        }
    }

    /**
     * Get the Users current minutesLightlyActive value
     * 
     * @return minutesLightlyActive
     */
    public int getMinutesLightlyActive() {
        return minutesLightlyActive;
    }

    /**
     * Request minutesLightlyActive data at this point in time from API and set
     * the value
     */
    public void setMinutesLightlyActive() {
        if (!fakeData) {
            temp = getInfo("activities/tracker/minutesLightlyActive/date/"
                    + getDate() + "/1d.json");
            JSONArray array = temp
                    .getJSONArray("activities-tracker-minutesLightlyActive");
            minutesLightlyActive += array.getJSONObject(0).getInt("value");
            System.out.println(minutesLightlyActive);
        }
    }

    /**
     * Get the users minutesFairlyActive value
     * 
     * @return
     */
    public int getMinutesFairlyActive() {
        return minutesFairlyActive;
    }

    /**
     * Request MinutesActive data at this point in time from API and set the
     * value
     */
    public void setMinutesFairlyActive() {
        if (!fakeData) {
            temp = getInfo("activities/tracker/minutesFairlyActive/date/"
                    + getDate() + "/1d.json");
            JSONArray array = temp
                    .getJSONArray("activities-tracker-minutesFairlyActive");
            minutesFairlyActive += array.getJSONObject(0).getInt("value");
            System.out.println(minutesFairlyActive);
        }
    }

    /**
     * Get the minutesVeryActive for the day
     * 
     * @return minutesVeryActive
     */
    public int getMinutesVeryActive() {
        return minutesVeryActive;
    }

    /**
     * Request MinutesVeryActive data at this point in time from API and set the
     * value
     */
    public void setMinutesVeryActive() {
        if (!fakeData) {
            temp = getInfo("activities/tracker/minutesVeryActive/date/"
                    + getDate() + "/1d.json");
            JSONArray array = temp
                    .getJSONArray("activities-tracker-minutesVeryActive");
            minutesVeryActive += array.getJSONObject(0).getInt("value");
            System.out.println(minutesVeryActive);
        }
    }

    public double getDistance() {
        return distance;
    }

    /**
     * Request MinutesVeryActive data at this point in time from API and set the
     * value
     */
    public void setDistance() {
        if (!fakeData) {
            temp = getInfo("activities/tracker/distance/date/" + getDate()
                    + "/1d.json");
            JSONArray array = temp.getJSONArray("activities-tracker-distance");
            distance += array.getJSONObject(0).getDouble("value");
            System.out.println(distance);
        }
    }

    public double getBdistance() {
        return Bdistance;
    }

    // Request best distance data at this point in time from API and set the
    // value

    public void setBdistance() {
        if (!fakeData) {
            temp = getInfo("activities.json");
            Bdistance = temp.getJSONObject("best").getJSONObject("tracker")
                    .getJSONObject("distance").getDouble("value");
            System.out.println(Bdistance);
        }
    }

    public double gettotalDistance() {
        return totalDistance;
    }

    // Request total distance data at this point in time from API and set the
    // value
    public void settotalDistance() {
        if (!fakeData) {
            temp = getInfo("activities.json");
            totalDistance = temp.getJSONObject("lifetime")
                    .getJSONObject("total").getDouble("floors");
            System.out.println(totalDistance);
        }
    }

    public double getBstep() {
        return Bstep;
    }

    // Request best step data at this point in time from API and set the value

    public void setBstep() {
        if (!fakeData) {
            temp = getInfo("activities.json");
            Bstep = temp.getJSONObject("best").getJSONObject("tracker")
                    .getJSONObject("steps").getInt("value");
            System.out.println(Bstep);
        }
    }

    public double gettotalStep() {
        return totalStep;
    }

    // * Request total step data at this point in time from API and set the
    // value

    public void settotalStep() {
        if (!fakeData) {
            temp = getInfo("activities.json");
            totalStep = temp.getJSONObject("lifetime").getJSONObject("total")
                    .getInt("steps");
            System.out.println(totalStep);
        }
    }

    public double getBfloor() {
        return Bfloor;
    }

    // * Request best floor data at this point in time from API and set the
    // value

    public void setBfloor() {
        if (!fakeData) {
            temp = getInfo("activities.json");
            Bfloor = temp.getJSONObject("best").getJSONObject("tracker")
                    .getJSONObject("floors").getInt("value");
            System.out.println(Bfloor);
        }
    }

    public double gettotalFloor() {
        return totalFloor;
    }

    public void settotalFloor() {
        if (!fakeData) {
            temp = getInfo("activities.json");
            totalFloor = temp.getJSONObject("lifetime").getJSONObject("total")
                    .getInt("floors");
            System.out.println(totalFloor);
        }
    }

    public int getRestingRate() {
        return restingRate;
    }

    public void setRestingRate() {
        if (!fakeData) {
            temp = getInfo("activities/heart/date/" + getDate() + "/1d.json");
            restingRate = temp.getJSONObject("activities-heart")
                    .getJSONObject("value").getInt("restingHeartRate");
        }
    }

    public int getOutofZone() {
        return outofZone;
    }

    public void setOutofZone() {
        if (!fakeData) {
            temp = getInfo("activities/heart/date/" + getDate() + "/1d.json");
            outofZone = temp.getJSONObject("activities-heart")
                    .getJSONObject("value").getJSONArray("heartRateZones")
                    .getJSONObject(0).getInt("minutes");
        }
    }

    public int getFatburnZone() {
        return fatburnZone;
    }

    public void setFatburnZone() {
        if (!fakeData) {
            temp = getInfo("activities/heart/date/" + getDate() + "/1d.json");
            fatburnZone = temp.getJSONObject("activities-heart")
                    .getJSONObject("value").getJSONArray("heartRateZones")
                    .getJSONObject(1).getInt("minutes");
        }
    }

    public int getCardioZone() {
        return cardioZone;
    }

    public void setCardioZone() {
        if (!fakeData) {
            temp = getInfo("activities/heart/date/" + getDate() + "/1d.json");
            cardioZone = temp.getJSONObject("activities-heart")
                    .getJSONObject("value").getJSONArray("heartRateZones")
                    .getJSONObject(2).getInt("minutes");
        }
    }

    public int getPeakZone() {
        return peakZone;
    }

    public void setPeakZone() {
        if (!fakeData) {
            temp = getInfo("activities/heart/date/" + getDate() + "/1d.json");
            peakZone = temp.getJSONObject("activities-heart")
                    .getJSONObject("value").getJSONArray("heartRateZones")
                    .getJSONObject(3).getInt("minutes");
        }
    }

    /**
     * Refreshes User data
     */
    public void refreshData() {

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
        this.setBdistance();
        this.settotalDistance();
        this.setBfloor();
        this.settotalFloor();
        this.setBstep();
        this.settotalStep();
        this.setOutofZone();
        this.setRestingRate();
        this.setFatburnZone();
        this.setPeakZone();
        this.setCardioZone();
    }

    /**
     * Main class that is used to chek whether the code works
     * 
     * @param args
     */
    public static void main(String args[]) {

        Userdata temp1 = new Userdata(false);
        System.out.println(temp1.getSteps());

    }

    public int[] getDistancevalue() {
        return Distancevalue;
    }

    public void setDistancevalue(int[] distancevalue) {
        Distancevalue = distancevalue;
    }

    public int[] getStepvalue() {
        return Stepvalue;
    }

    public void setStepvalue(int[] stepvalue) {
        Stepvalue = stepvalue;
    }

    public int[] getCalories() {
        return Caloriesvalue;
    }

    public void setCalories(int[] calories) {
        Caloriesvalue = calories;
    }

}
