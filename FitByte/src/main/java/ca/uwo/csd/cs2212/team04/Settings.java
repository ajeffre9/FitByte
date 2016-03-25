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
	 *@throws Exception when error
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
	 *@throws Exception error
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
	 * getDate method Returns the date from the settings class.
	 *
	 * @return date		Date the settings were saved
	 */
	public Date getDate() {
		return data.date;
	}

	/**
	 * getColorTheme method Returns the color theme for the GUI from the settings class.
	 *
	 * @return colorTheme	Color theme for the custom dashboard on the GUI
	 */
	public String getColorTheme() {
		return data.colorTheme;
	}

	/**
	 * getWindowHeight method Returns the window height from the settings class.
	 *
	 * @return windowHeight		Window height specified by user
	 */
	public int getWindowHeight() {
		return data.windowHeight;
	}

	/**
	 * getWindowWidth method Returns the window width from the settings class.
	 *
	 * @return windowWidth		Window width specified by user
	 */
	public int getWindowWidth() {
		return data.windowWidth;
	}


	/**
	 * getDG_Step method returns the DG_Step from the settings class.
	 *
	 * @return DG_Step		
	 */
	public int getDG_Step() {
		return data.DG_Step;
	}

	/**
	 * getDG_Distance method returns the DG_Distance from the settings class.
	 *
	 * @return DG_Distance	
	 */
	public int getDG_Distance() {
		return data.DG_Distance;
	}

	/**
	 * getDG_SMinute method returns the  DG_SMinute from the settings class.
	 *
	 * @return DG_SMinute
	 */
	public int getDG_SMinute() {
		return data.DG_SMinute;
	}

	/**
	 * getDG_AMinute method returns the DG_AMinute from the settings class.
	 *
	 * @return DG_AMinute	
	 */
	public int getDG_AMinute() {
		return data.DG_AMinute;
	}

	/**
	 * getDG_Floor method returns the DG_Floor from the settings class.
	 *
	 * @return DG_Floor
	 */
	public int getDG_Floor() {
		return data.DG_Floor;
	}

	/**
	 * getDG_Calories method returns the DG_Calories from the settings class.
	 *
	 * @return DG_Calories
	 */
	public int getDG_Calories() {
		return data.DG_Calories;
	}

	/**
	 * getUpdate method returns the update from the settings class.
	 *
	 * @return update
	 */
	public String getUpdate() {
		return data.update;
	}




	/**
	 * setDate method Sets the Date.
	 * @param date  the current date
	 */
	public void setDate(Date date) {
		data.date = date;
	}

	/**
	 * setColorTheme method Sets ColorTheme.
	 * 
	 * @param colorTheme the color theme  
	 */
	public void setColorTheme(String colorTheme) {
		data.colorTheme = colorTheme;
	}


	/**
	 * setDG_Step method Sets the DG_Step.
	 * @param dG_Step  daily goal of step
	 */
	public void setDG_Step(int dG_Step) {
		data.DG_Step = dG_Step;
	}

	/**
	 * setDG_Distance method Sets the DG_Distance.
	 * @param dG_Distance  daily goal of distance
	 */
	public void setDG_Distance(int dG_Distance) {
		data.DG_Distance = dG_Distance;
	}

	/**
	 * setDG_SMinute method Sets the DG_SMinute.
	 * @param dG_SMinute  daily goal of SMinute
	 */
	public void setDG_SMinute(int dG_SMinute) {
		data.DG_SMinute = dG_SMinute;
	}

	/**
	 * setDG_AMinute method Sets the DG_AMinute.
	 * 
	 * @param dG_AMinute  daily goal of AMinute
	 */
	public void setDG_AMinute(int dG_AMinute) {
		data.DG_AMinute = dG_AMinute;
	}

	/**
	 * setDG_Floor method Sets the DG_Floor.
	 * @param dG_Floor  daily goal of floor
	 */
	public void setDG_Floor(int dG_Floor) {
		data.DG_Floor = dG_Floor;
	}

	/**
	 * setDG_Calories method Sets the DG_Calories.
	 * @param dG_Calories  daily goal of calories
	 */
	public void setDG_Calories(int dG_Calories) {
		data.DG_Calories = dG_Calories;
	}


	/**
	 * setUpdate method Sets the update.
	 */
	public void setUpdate() {
		Date update = new Date();
		data.update = update.toString();
	}


}
////////////////////////////////////////////////////////////////////////////////
//                                   End                                      //
////////////////////////////////////////////////////////////////////////////////