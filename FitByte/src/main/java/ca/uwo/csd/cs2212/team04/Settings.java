package ca.uwo.csd.cs2212.team04;

/**
 * Created by owner on 2016-02-24.
 */
import java.io.*;
//import java.io.Serializable;

public class Settings implements Serializable {

    private String date, dashboard;
    private String colorTheme, dailyGoals, customGoals;

    // default constructor
    public Settings() {

		// set defaults here
    	date = "null";
		dashboard = null;
		colorTheme = null;
		dailyGoals = null;
		customGoals  = null;
		dashboard = null;

  	}

	public void saveSettings() throws Exception {

		try {
	      	ObjectOutputStream out = new ObjectOutputStream(
	                                     new FileOutputStream("settings.config"));
	      	out.writeObject(this);
	      	out.close();

		} catch (Exception e) {
			System.err.println(e + ": failed to save settings");
		}

	}

	// Getters
  	public String getDate() {
  		return date;
  	}

  	public String getDashboard() {
  		return dashboard;
  	}

  	public String getColorTheme() {
  		return colorTheme;
  	}

  	public String getDailyGoals() {
  		return dailyGoals;
  	}

  	public String getCustomGoals() {
  		return customGoals;
  	}

  	// Setters
  	public void setDate(String date) {
  		this.date = date;
 	}

  	public void setDashboard(String dashboard) {
  		this.dashboard = dashboard;
  	}

  	public void setColorTheme(String colorTheme) {
  		this.colorTheme = colorTheme;
  	}

  	public void setDailyGoals(String dailyGoals) {
   		this.dailyGoals = dailyGoals;
  	}

  	public void setCustomGoals(String customGoals) {
  		this.customGoals = customGoals;
  	}

}
