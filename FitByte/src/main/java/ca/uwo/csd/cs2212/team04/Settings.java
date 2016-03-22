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
	 * Returns the dashboard from the settings class.
	 *
	 * @return dashboard	Dashboard arrangement for the GUI
	 */
	public String getDashboard() {
		return data.dashboard;
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
	 * Returns the user from the settings class.
	 *
	 * @return user		User from current session
	 */
	public User getUser() {
		return data.user;
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
	 * Returns the window x position from the settings class.
	 *
	 * @return windowPositionX		Window's x position on desktop
	 */
	public int getWindowPositionX() {
		return data.windowPositionX;
	}

	/**
	 * Returns the window y position from the settings class.
	 *
	 * @return windowPositionY		Window's y position on desktop
	 */
	public int getWindowPositionY() {
		return data.windowPositionY;
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
	 * Sets the dashboard configuration.
	 *
	 * @param dashboard String passed in by user
	 */
	public void setDashboard(String dashboard) {
		data.dashboard = dashboard;
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
	 * Sets the user from the settings class.
	 *
	 * @param user		User from current session
	 */
	public void setUser(User user) {
		data.user = user;
	}

	/**
	 * Sets the window height from the settings class.
	 *
	 * @param windowHeight		Window height specified by user
	 */
	public void getWindowHeight(int windowHeight) {
		data.windowHeight = windowHeight;
	}

	/**
	 * Sets the window width from the settings class.
	 *
	 * @param windowWidth		Window width specified by user
	 */
	public void getWindowWidth(int windowWidth) {
		data.windowWidth = windowWidth;
	}

	/**
	 * Sets the window x position from the settings class.
	 *
	 * @param windowPositionX		Window's x position on desktop
	 */
	public void getWindowPositionX(int windowPositionX) {
		data.windowPositionX = windowPositionX;
	}

	/**
	 * Sets the window y position from the settings class.
	 *
	 * @param windowPositionY		Window's y position on desktop
	 */
	public void getWindowPositionY(int windowPositionY) {
		data.windowPositionY = windowPositionY;
	}


}
////////////////////////////////////////////////////////////////////////////////
//                                   End                                      //
////////////////////////////////////////////////////////////////////////////////