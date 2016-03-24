////////////////////////////////////////////////////////////////////////////////
//                               Fight Byte                                   //
////////////////////////////////////////////////////////////////////////////////
package ca.uwo.csd.cs2212.team04;

/**
 * Application parameters that determine the general layout of the GUI and 
 * hold information pretaining to specific user. Previous sessions are stored
 * in a settings.config file to allow data to live beyond a single session.
 * @author cs2212_w2016_team04
 */

import java.io.ObjectOutputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.FileInputStream;
import java.io.Serializable;
import java.util.Date;

// from David
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Formatter;
import java.util.Properties;
import javax.swing.JOptionPane;

////////////////////////////////////////////////////////////////////////////////
//                           Settings Class                                   //
////////////////////////////////////////////////////////////////////////////////
public class Settings implements Serializable {

	/**
	 * Application parameters
	 *
	 */
	private Data data;

	/**
	 * Default constructor for the settings class. 
	 *
	 */
	public Settings() throws Exception {

		// Check for existing settings.config file
		try {
			ObjectInputStream in = new ObjectInputStream(
				new FileInputStream("settings.config"));
		
			data = (Data) in.readObject();
			in.close();
		} catch (Exception e) {
			// File not present, create a blank settings file
			data = new Data();
			saveSettings();
			System.err.println("New settings file created");
		}

	}

	/**
	 * Saves all the current parameters into 'settings.config' for future
	 * reference.
	 *
	 */
	public void saveSettings() throws Exception {

		try {
			ObjectOutputStream out = new ObjectOutputStream(
					new FileOutputStream("settings.config"));
			out.writeObject(data);
			out.close();

		} catch (Exception e) {
			System.err.println(e + ": failed to save settings");
		}

	}

	/**
	 * Returns the date from the settings class.
	 *
	 * @return date		Date the settings were saved
	 */
	public Date getDate() {
		return data.date;
	}

	/**
	 * Returns the color theme for the GUI from the settings class.
	 *
	 * @return colorTheme	Color theme for the custom dashboard on the GUI
	 */
	public String getColorTheme() {
		return data.colorTheme;
	}

	/**
	 * Returns the window height from the settings class.
	 *
	 * @return windowHeight		Window height specified by user
	 */
	public int getWindowHeight() {
		return data.windowHeight;
	}

	/**
	 * Returns the window width from the settings class.
	 *
	 * @return windowWidth		Window width specified by user
	 */
	public int getWindowWidth() {
		return data.windowWidth;
	}

	/**
	 * Gets the daily goal for steps
	 *
	 * @return DG_Step			Daily step goal
	 */
	public int getDG_Step() {
		return data.DG_Step;
	}

	/**
	 * Gets the daily goal for distance
	 *
	 * @return DG_Distance			Daily distance goal
	 */
	public int getDG_Distance() {
		return data.DG_Distance;
	}

	/**
	 * Gets the daily sedimentary minutes
	 *
	 * @return DG_SMinutes			Daily lazy minutes
	 */
	public int getDG_SMinute() {
		return data.DG_SMinute;
	}

	/**
	 * Gets the daily active minutes 
	 *
	 * @return DG_AMinutes			Daily squirrelly moments
	 */
	public int getDG_AMinute() {
		return data.DG_AMinute;
	}

	/**
	 * Gets the daily floors climbed goal
	 *
	 * @return DG_DFloor			Daily floor goal
	 */
	public int getDG_Floor() {
		return data.DG_Floor;
	}

	/**
	 * Gets the daily calories goal
	 *
	 * @return DG_Calories			Daily calorie goal
	 */
	public int getDG_Calories() {
		return data.DG_Calories;
	}

	/**
	 * Gets the last updated time as a string
	 *
	 * @return update			Last time updated
	 */
	public String getUpdate() {
		return data.update;
	}




	/**
	 * Sets the date.
	 *
	 * @param date			Date passed into by user
	 */
	public void setDate(Date date) {
		data.date = date;
	}

	/**
	 * Sets the color theme of the GUI dashboard.
	 *
	 * @param colorTheme	String passed into by user
	 */
	public void setColorTheme(String colorTheme) {
		data.colorTheme = colorTheme;
	}


	/**
	 * Sets daily step goals.
	 *
	 * @param dG_Step			Daily step goals
	 */
	public void setDG_Step(int dG_Step) {
		data.DG_Step = dG_Step;
	}

	/**
	 * Sets daily distance goals.
	 *
	 * @param dG_Distance			Daily distance goals
	 */
	public void setDG_Distance(int dG_Distance) {
		data.DG_Distance = dG_Distance;
	}

	/**
	 * Sets daily lazy minute goals.
	 *
	 * @param dG_SMinutes			Daily lazy time goals
	 */
	public void setDG_SMinute(int dG_SMinute) {
		data.DG_SMinute = dG_SMinute;
	}

	/**
	 * Sets daily active minute goals.
	 *
	 * @param dG_AMinutes			Daily squirelly goals
	 */
	public void setDG_AMinute(int dG_AMinute) {
		data.DG_AMinute = dG_AMinute;
	}

	/**
	 * Sets daily floor climbing goals.
	 *
	 * @param dG_Floor			Daily floor goals
	 */
	public void setDG_Floor(int dG_Floor) {
		data.DG_Floor = dG_Floor;
	}

	/**
	 * Sets daily calorie goals.
	 *
	 * @param dG_Calories			Daily calorie goals
	 */
	public void setDG_Calories(int dG_Calories) {
		data.DG_Calories = dG_Calories;
	}


	/**
	 * Sets update to current time.
	 *
	 */
	public void setUpdate() {
		Date update = new Date();
		data.update = update.toString();
	}


}
////////////////////////////////////////////////////////////////////////////////
//                                   End                                      //
////////////////////////////////////////////////////////////////////////////////