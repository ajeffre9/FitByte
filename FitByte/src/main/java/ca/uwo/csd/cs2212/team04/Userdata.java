package ca.uwo.csd.cs2212.team04;

import org.json.JSONArray;
import org.json.JSONException;
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
	private double dailyCalories, distance, totalDistance;
	private int steps, floors, minutesSedentary, minutesLightlyActive,
			minutesFairlyActive, minutesVeryActive, totalStep, totalFloor;
	private String Bdistance, Bstep, Bfloor;
	private int peakZone, cardioZone, fatburnZone, outofZone, restingRate;
	private String date, firstTime;

	private boolean fakeData;

	private int[] HeartRatevalue;
	private double[] Distancevalue;
	private int[] Stepvalue;
	private int[] Caloriesvalue;

	/**
	 * Constructor: Initialize variables using test data or requests data. If
	 * fakeData is true then pass test data.
	 * 
	 * @param fakeD
	 *            fakedata
	 */
	public Userdata(boolean fakeD) {
		fakeData = fakeD;

		if (fakeData) {

			temp = null;
			date = null;

			Bstep = "2012-01-07";
			Bfloor = "2012-01-07";
			Bdistance = "2012-01-07";

			totalStep = 100;
			totalFloor = 100;
			totalDistance = 100;

			dailyCalories = 1027;

			steps = 1500;
			floors = 30;
			distance = 60.0;

			minutesSedentary = 1000;
			minutesLightlyActive = 90;
			minutesFairlyActive = 5;
			minutesVeryActive = 50;

			peakZone = 20;
			cardioZone = 10;
			fatburnZone = 30;
			outofZone = 1;
			restingRate = 110;

			HeartRatevalue = new int[50];
			Distancevalue = new double[50];
			Stepvalue = new int[50];
			Caloriesvalue = new int[50];
			firstTime = "00:00";

			for (int i = 0; i < 50; i++) {
				HeartRatevalue[i] = (int) (30 + i * Math.random());
				Distancevalue[i] = (int) (20 + i * Math.random());
				Stepvalue[i] = (int) (10 + i * Math.random());
				Caloriesvalue[i] = (int) (40 + i * Math.random());
			}

		} else {
			Date dNow = new Date();
			setHeartRateHourGraph();
			this.setDate(dNow);
			this.setDistanceHourGraph();
			this.setCaloriesHourGraph();
			this.setHeartRateHourGraph();
			this.setStepHourGraph();
			this.refreshData();
		}

	}

	/**
	 * setDate method Set the current date for the day the data is collected
	 * 
	 * @param dNow
	 *            the date of current time
	 */
	public void setDate(Date dNow) {
		SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd");
		date = ft.format(dNow);
	}

	/**
	 * setDistanceHourGraph method access the JSON object and use the data to
	 * set distance hourly graph
	 */
	public void setDistanceHourGraph() {
		if (!fakeData) {
			try {
				temp = getInfo("activities/distance/date/today/1d/1min.json");
				JSONArray array = temp.getJSONObject(
						"activities-distance-intraday").getJSONArray("dataset");
				Distancevalue = new double[array.length()];
				for (int i = 0; i < array.length(); i++) {
					Distancevalue[i] = array.getJSONObject(i).getDouble("value");
				}
			} catch (NullPointerException e) {
				JOptionPane.showMessageDialog(null,
						"No Distance Data for time series.");
				Distancevalue = new Userdata(true).getDistanceHourGraph();
			}
		}
	}

	/**
	 * seyCaloriesHourGraph method access the JSON object and use the data to
	 * set calories hourly graph
	 */
	public void setCaloriesHourGraph() {
		if (!fakeData) {
			try {
				temp = getInfo("activities/calories/date/today/1d/1min.json");
				JSONArray array = temp.getJSONObject(
						"activities-calories-intraday").getJSONArray("dataset");
				Caloriesvalue = new int[array.length()];
				for (int i = 0; i < array.length(); i++) {
					Caloriesvalue[i] = array.getJSONObject(i).getInt("value");
				}
			} catch (NullPointerException e) {
				JOptionPane.showMessageDialog(null,
						"No Calories Data for time series.");
			}
		}
	}

	/**
	 * setStepHourGraph method access the JSON object and use the data to set
	 * step hourly graph
	 */
	public void setStepHourGraph() {
		if (!fakeData) {
			try {
				temp = getInfo("activities/steps/date/today/1d/1min.json");
				JSONArray array = temp.getJSONObject(
						"activities-steps-intraday").getJSONArray("dataset");
				Stepvalue = new int[array.length()];
				for (int i = 0; i < array.length(); i++) {
					Stepvalue[i] = array.getJSONObject(i).getInt("value");
				}
			} catch (NullPointerException e) {
				JOptionPane.showMessageDialog(null,
						"No Step Data for time series.");
			}
		}
	}

	/**
	 * setHeartRateHourGraph method access the JSON object and use the data to
	 * set heart hourly graph
	 */
	public void setHeartRateHourGraph() {
		if (!fakeData) {
			try {
				temp = getInfo("activities/heart/date/today/1d/1min.json");
				JSONArray array = temp.getJSONObject(
						"activities-heart-intraday").getJSONArray("dataset");
				firstTime = array.getJSONObject(0).getString("time");
				int length = array.length();
				HeartRatevalue = new int[length];
				for (int i = 0; i < length; i++) {
					HeartRatevalue[i] = array.getJSONObject(i).getInt("value");
				}
			} catch (NullPointerException e) {
				JOptionPane.showMessageDialog(null,
						"No Heart Rate Data or Not Enough Data.");
			}
		}
	}

	/**
	 * setDailyCalories method Request DailyCalories data at this point in time
	 * from API and set the value
	 */
	public void setDailyCalories() {
		if (!fakeData) {
			try {
				temp = getInfo("activities/tracker/calories/date/" + getDate()
						+ "/1d.json");
				JSONArray array = temp
						.getJSONArray("activities-tracker-calories");
				dailyCalories = (array.getJSONObject(0).getDouble("value"));
				System.out.println(dailyCalories);
			} catch (NullPointerException e) {
				JOptionPane.showMessageDialog(null,
						"No daily calories data or Not Enough Data.");
			}
		}
	}

	/**
	 * setSteps class Request steps data at this point in time from API and set
	 * the value
	 */
	public void setSteps() {
		if (!fakeData) {
			try {
				temp = getInfo("activities/tracker/steps/date/" + getDate()
						+ "/1d.json");
				JSONArray array = temp.getJSONArray("activities-tracker-steps");
				steps = (array.getJSONObject(0).getInt("value"));
				System.out.println(steps);
			} catch (JSONException e) {
				JOptionPane.showMessageDialog(null, "step Missing");
			} catch (NullPointerException e1) {
				JOptionPane.showMessageDialog(null, "step Missing");
			}
		}
	}

	/**
	 * setFloors method Request Floors data at this point in time from API and
	 * set the value
	 */
	public void setFloors() {
		try {
			if (!fakeData) {
				temp = getInfo("activities/tracker/floors/date/" + getDate()
						+ "/1d.json");
				JSONArray array = temp
						.getJSONArray("activities-tracker-floors");
				floors = (int) (array.getJSONObject(0).getInt("value"));
				System.out.println(floors);
			}
		} catch (JSONException e) {
			JOptionPane.showMessageDialog(null, "Floor Missing");
		} catch (NullPointerException e1) {
			JOptionPane.showMessageDialog(null, "Floor Missing");
		}
	}

	/**
	 * setMinutesSedentary method Request minutesSedentary data at this point in
	 * time from API and set the value
	 */
	public void setMinutesSedentary() {
		try {
			if (!fakeData) {
				temp = getInfo("activities/tracker/minutesSedentary/date/"
						+ getDate() + "/1d.json");
				JSONArray array = temp
						.getJSONArray("activities-tracker-minutesSedentary");
				minutesSedentary = (array.getJSONObject(0).getInt("value"));
				System.out.println(minutesSedentary);
			}
		} catch (JSONException e) {
			JOptionPane.showMessageDialog(null, "SMinute Missing");
		} catch (NullPointerException e1) {
			JOptionPane.showMessageDialog(null, "SMinute Missing");
		}
	}

	/**
	 * setMinutesLightlyActive method Request minutesLightlyActive data at this
	 * point in time from API and set the value
	 */
	public void setMinutesLightlyActive() {
		try {
			if (!fakeData) {
				temp = getInfo("activities/tracker/minutesLightlyActive/date/"
						+ getDate() + "/1d.json");
				JSONArray array = temp
						.getJSONArray("activities-tracker-minutesLightlyActive");
				minutesLightlyActive = array.getJSONObject(0).getInt("value");
				System.out.println(minutesLightlyActive);
			}
		} catch (JSONException e) {
			JOptionPane.showMessageDialog(null, "Lightly Activity Missing");
		} catch (NullPointerException e1) {
			JOptionPane.showMessageDialog(null, "Lightly Activity Missing");
		}
	}

	/**
	 * setMinutesFairlyActive method Request MinutesActive data at this point in
	 * time from API and set the value
	 */
	public void setMinutesFairlyActive() {
		try {
			if (!fakeData) {
				temp = getInfo("activities/tracker/minutesFairlyActive/date/"
						+ getDate() + "/1d.json");
				JSONArray array = temp
						.getJSONArray("activities-tracker-minutesFairlyActive");
				minutesFairlyActive = array.getJSONObject(0).getInt("value");
				System.out.println(minutesFairlyActive);
			}
		} catch (JSONException e) {
			JOptionPane.showMessageDialog(null, "Fairly Active Missing");
		} catch (NullPointerException e1) {
			JOptionPane.showMessageDialog(null, "Farily Active Missing");
		}
	}

	/**
	 * setMinutesVeryActive method Request MinutesVeryActive data at this point
	 * in time from API and set the value
	 */
	public void setMinutesVeryActive() {
		try {
			if (!fakeData) {
				temp = getInfo("activities/tracker/minutesVeryActive/date/"
						+ getDate() + "/1d.json");
				JSONArray array = temp
						.getJSONArray("activities-tracker-minutesVeryActive");
				minutesVeryActive = array.getJSONObject(0).getInt("value");
				System.out.println(minutesVeryActive);
			}
		} catch (JSONException e) {
			JOptionPane.showMessageDialog(null, "Active Minute Missing");
		} catch (NullPointerException e1) {
			JOptionPane.showMessageDialog(null, "Active Minute Missing");
		}
	}

	/**
	 * setDistance method Request distance data at this point in time from API
	 * and set the value
	 */
	public void setDistance() {
		try {
			if (!fakeData) {
				temp = getInfo("activities/tracker/distance/date/" + getDate()
						+ "/1d.json");
				JSONArray array = temp
						.getJSONArray("activities-tracker-distance");
				distance = array.getJSONObject(0).getDouble("value");
				System.out.println(distance);
			}
		} catch (JSONException e) {
			JOptionPane.showMessageDialog(null, "Distance Missing");
		} catch (NullPointerException e1) {
			JOptionPane.showMessageDialog(null, "Distance Missing");
		}

	}

	/**
	 * setBdistance method Request best distance data at this point in time from
	 * API and set the value
	 */

	public void setBdistance() {
		try {
			if (!fakeData) {
				temp = getInfo("activities.json");
				Bdistance = temp.getJSONObject("best").getJSONObject("tracker")
						.getJSONObject("distance").getString("date");
				System.out.println(Bdistance);
			}
		} catch (JSONException e) {
			JOptionPane.showMessageDialog(null, "Best Distance Missing");
		} catch (NullPointerException e1) {
			JOptionPane.showMessageDialog(null, "Best Distance Missing");
		}
	}

	/**
	 * settotalDistance method Request total distance data at this point in time
	 * from API and set the value
	 */
	public void settotalDistance() {
		try {
			if (!fakeData) {
				temp = getInfo("activities.json");
				totalDistance = temp.getJSONObject("lifetime")
						.getJSONObject("total").getDouble("floors");
				System.out.println(totalDistance);
			}
		} catch (JSONException e) {
			JOptionPane.showMessageDialog(null, "Total Distance Missing");
		} catch (NullPointerException e1) {
			JOptionPane.showMessageDialog(null, "Total Distance Missing");
		}
	}

	/**
	 * setBstep method Request best step data at this point in time from API and
	 * set the value
	 */
	public void setBstep() {
		try {
			if (!fakeData) {
				temp = getInfo("activities.json");
				Bstep = temp.getJSONObject("best").getJSONObject("tracker")
						.getJSONObject("steps").getString("date");
				System.out.println(Bstep);
			}
		} catch (JSONException e) {
			JOptionPane.showMessageDialog(null, "Best Step Missing");
		} catch (NullPointerException e1) {
			JOptionPane.showMessageDialog(null, "Best Step Missing");
		}
	}

	/**
	 * settotalStep method Request total step data at this point in time from
	 * API and set the
	 */
	public void settotalStep() {
		try {
			if (!fakeData) {
				temp = getInfo("activities.json");
				totalStep = temp.getJSONObject("lifetime")
						.getJSONObject("total").getInt("steps");
				System.out.println(totalStep);
			}
		} catch (JSONException e) {
			JOptionPane.showMessageDialog(null, "Total Step Missing");
		} catch (NullPointerException e1) {
			JOptionPane.showMessageDialog(null, "Total Step Missing");
		}
	}

	/**
	 * setBfloor method Request best floor data at this point in time from API
	 * and set the value
	 */
	public void setBfloor() {
		try {
			if (!fakeData) {
				temp = getInfo("activities.json");
				Bfloor = temp.getJSONObject("best").getJSONObject("tracker")
						.getJSONObject("floors").getString("date");
				System.out.println(Bfloor);
			}
		} catch (JSONException e) {
			JOptionPane.showMessageDialog(null, "Best Floor Missing");
		} catch (NullPointerException e1) {
			JOptionPane.showMessageDialog(null, "Best Floor Missing");
		}
	}

	/**
	 * settotalFloor method Request total floor data at this point in time from
	 * API and set the value
	 */
	public void settotalFloor() {
		try {
			if (!fakeData) {
				temp = getInfo("activities.json");
				totalFloor = temp.getJSONObject("lifetime")
						.getJSONObject("total").getInt("floors");
				System.out.println(totalFloor);
			}
		} catch (JSONException e) {
			JOptionPane.showMessageDialog(null, "Total Floor Missing");
		} catch (NullPointerException e1) {
			JOptionPane.showMessageDialog(null, "Total Floor Missing");
		}
	}

	/**
	 * setHeartRateZone method Request heart rate zone data at this point in
	 * time from API and set the value
	 */
	public void setHeartRateZone() {
		try {
			if (!fakeData) {
				temp = getInfo("activities/heart/date/" + getDate()
						+ "/1d.json");
				outofZone = temp.getJSONArray("activities-heart")
						.getJSONObject(0).getJSONObject("value")
						.getJSONArray("heartRateZones").getJSONObject(0)
						.getInt("minutes");
				fatburnZone = temp.getJSONArray("activities-heart")
						.getJSONObject(0).getJSONObject("value")
						.getJSONArray("heartRateZones").getJSONObject(1)
						.getInt("minutes");
				cardioZone = temp.getJSONArray("activities-heart")
						.getJSONObject(0).getJSONObject("value")
						.getJSONArray("heartRateZones").getJSONObject(2)
						.getInt("minutes");
				peakZone = temp.getJSONArray("activities-heart")
						.getJSONObject(0).getJSONObject("value")
						.getJSONArray("heartRateZones").getJSONObject(3)
						.getInt("minutes");
				restingRate = temp.getJSONArray("activities-heart")
						.getJSONObject(0).getJSONObject("value")
						.getInt("restingHeartRate");
			}
		} catch (JSONException e) {
			JOptionPane.showMessageDialog(null,
					"Heart Rate Zone Information Missing");
		} catch (NullPointerException e1) {
			JOptionPane.showMessageDialog(null,
					"Heart Rate Zone Information Missing");
		}
	}

	/**
	 * gettotalFloor method to get total floor data
	 * 
	 * @return totalFloor
	 */
	public double gettotalFloor() {
		return totalFloor;
	}

	/**
	 * getFirstTime method to get the first time
	 * 
	 * @return firstTime
	 */
	public String getFirstTime() {
		return firstTime;
	}

	/**
	 * getBdistance method to get Best distance
	 * 
	 * @return Bdistance
	 */
	public String getBdistance() {
		return Bdistance;
	}

	/**
	 * getBstep method to get Best step data
	 * 
	 * @return Bstep
	 */
	public String getBstep() {
		return Bstep;
	}

	/**
	 * getRestingRate method to get resting Rate value
	 * 
	 * @return restingRate
	 */
	public int getRestingRate() {
		return restingRate;
	}

	/**
	 * getBfloor method to get best floor data
	 * 
	 * @return Bfloor
	 */
	public String getBfloor() {
		return Bfloor;
	}

	/**
	 * getOutofZone method to get out of Zone value
	 * 
	 * @return toutofZone
	 */
	public int getOutofZone() {
		return outofZone;
	}

	/**
	 * getDistanceHourGraph method to get Distance value
	 * 
	 * @return Distancevalue
	 */
	public double[] getDistanceHourGraph() {
		return Distancevalue;
	}

	/**
	 * getCaloriesHourGraph method to get Calories value
	 * 
	 * @return Caloriesvalue
	 */
	public int[] getCaloriesHourGraph() {
		return Caloriesvalue;
	}

	/**
	 * getStepHourGraoh method to get Step value
	 * 
	 * @return Stepvalue
	 */
	public int[] getStepHourGraph() {
		return Stepvalue;
	}

	/**
	 * getHeartRateHourGraph method to get Heart Rate value
	 * 
	 * @return HeartRatevalue
	 */
	public int[] getHeartRateHourGraph() {
		return HeartRatevalue;
	}

	/**
	 * getDate method Get the date for the day
	 * 
	 * @return date
	 */
	public String getDate() {
		return date;
	}

	/**
	 * dailyCalories method Get the Users current Calorie value
	 * 
	 * @return dailyCalories
	 */
	public double getDailyCalories() {
		return dailyCalories;
	}

	/**
	 * getSteps method Get the Users current steps value
	 * 
	 * @return steps
	 */
	public int getSteps() {
		return steps;
	}

	/**
	 * gettotalStep method Get the Users total Step value
	 * 
	 * @return totalStep
	 */
	public double gettotalStep() {
		return totalStep;
	}

	/**
	 * gettotalDistance method Get the Users current total Distance value
	 * 
	 * @return totalDistance
	 */
	public double gettotalDistance() {
		return totalDistance;
	}

	/**
	 * getFatburnZone method Get the Users current fat burn Zone data
	 * 
	 * @return fatburnZone
	 */
	public int getFatburnZone() {
		return fatburnZone;
	}

	/**
	 * getCardioZone method Get the Users Cardio Zone data
	 * 
	 * @return cardioZone
	 */
	public int getCardioZone() {
		return cardioZone;
	}

	/**
	 * getPeakZone method Get the Users current peak Zone data
	 * 
	 * @return peakZone
	 */
	public int getPeakZone() {
		return peakZone;
	}

	/**
	 * getDistancevalue method Get the Users current Distance value
	 * 
	 * @return Distancevalue
	 */
	public double[] getDistancevalue() {
		return Distancevalue;
	}

	/**
	 * getFloors method Get the Users current floors value
	 * 
	 * @return floors
	 */
	public int getFloors() {
		return floors;
	}

	/**
	 * getMinutesSedentary method Get the Users current get Minutes Sedentary
	 * value
	 * 
	 * @return minutesSedentary
	 */
	public int getMinutesSedentary() {
		return minutesSedentary;
	}

	/**
	 * getMinutesLightlyActive method get the Users current minutes Lightly
	 * Active value
	 * 
	 * @return minutesLightlyActive
	 */
	public int getMinutesLightlyActive() {
		return minutesLightlyActive;
	}

	/**
	 * getMinutesFairlyActive method Get the users minutes Fairly Active value
	 * 
	 * @return minutesFairlyActive
	 */
	public int getMinutesFairlyActive() {
		return minutesFairlyActive;
	}

	/**
	 * getMinutesVeryActive method Get the minutes Very Active for the day
	 * 
	 * @return minutesVeryActive
	 */
	public int getMinutesVeryActive() {
		return minutesVeryActive;
	}

	/**
	 * getDistance method get Distance for the day
	 * 
	 * @return distance
	 */
	public double getDistance() {
		return distance;
	}

	/**
	 * getStepvalue method get step value for the day
	 * 
	 * @return Stepvalue
	 */
	public int[] getStepvalue() {
		return Stepvalue;
	}

	/**
	 * getCalories method get Calories value for the day
	 * 
	 * @return Caloriesvalue
	 */
	public int[] getCalories() {
		return Caloriesvalue;
	}

	/**
	 * Refreshes User data
	 */
	public void refreshData() {
		this.setDailyCalories();
		this.setFloors();
		this.setSteps();
		this.setDistance();
		this.setMinutesFairlyActive();
		this.setMinutesSedentary();
		this.setMinutesVeryActive();
		this.setMinutesLightlyActive();

		this.setBdistance();
		this.setBfloor();
		this.setBstep();

		this.settotalDistance();
		this.settotalFloor();
		this.settotalStep();

		this.setHeartRateZone();
	}

}
