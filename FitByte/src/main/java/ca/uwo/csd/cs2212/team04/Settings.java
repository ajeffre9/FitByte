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



	/**
	 * Returns an Image object that can then be painted on the screen. 
	 * The url argument must specify an absolute {@link URL}. The name
	 * argument is a specifier that is relative to the url argument. 
	 * <p>
	 * This method always returns immediately, whether or not the 
	 * image exists. When this applet attempts to draw the image on
	 * the screen, the data will be loaded. The graphics primitives 
	 * that draw the image will incrementally paint on the screen. 
	 *
	 * @param  url  an absolute URL giving the base location of the image
	 * @param  name the location of the image, relative to the url argument
	 * @return      the image at the specified URL
	 * @see         Image
	 */

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
