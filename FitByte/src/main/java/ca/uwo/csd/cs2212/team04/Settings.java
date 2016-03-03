////////////////////////////////////////////////////////////////////////////////
//                               Fight Byte                                   //
////////////////////////////////////////////////////////////////////////////////
package ca.uwo.csd.cs2212.team04;

/**
 * Application parameters that determine the general layout of the GUI and 
 * hold information pretaining to specific user. Previous sessions are stored
 * in a settings.config file to allow data to live beyond a single session.
 */

import java.io.ObjectOutputStream;
import java.io.FileOutputStream;
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
    private int windowHeight, windowWidth;
    private int windowPositionX, windowPositionY;
    private String colorTheme, dashboard;
    private User user;
	private Date date;
    

    /**
	 * Default constructor for the settings class. Only called if no previous
	 * settings exist. Settings from a current session are stored in a custom
	 * serialized file labelled 'settings.config'. Sets all to default.
	 *
	 */
    public Settings() {
	
    	windowHeight 	= 400;			// Default window height
    	windowWidth 	= 400;			// Default window width
    	windowPositionX = 400;			// Default window x position
    	windowPositionY = 400;			// Default window y position
       	colorTheme = "default";			// Default windows color theme
       	dashboard  = "default";			// Default dashboard configuration

    	//user = new User();			// Create a new user
		date = new Date();				// Select today as default date
	
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
	      	out.writeObject(this);
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
  		return this.date;
  	}

	 /**
	 * Returns the dashboard from the settings class.
	 * 
	 * @return dashboard	Dashboard arrangement for the GUI
	 */
  	public String getDashboard() {
  		return this.dashboard;
  	}

	 /**
	 * Returns the color theme for the GUI from the settings class.
	 * 
	 * @return colorTheme	Color theme for the custom dashboard on the GUI
	 */
  	public String getColorTheme() {
  		return this.colorTheme;
  	}

	 /**
	 * Returns the user from the settings class.
	 * 
	 * @return user		User from current session
	 */
  	public User getUser() {
  		return this.user;
  	}

  	 /**
	 * Returns the window height from the settings class.
	 * 
	 * @return windowHeight		Window height specified by user
	 */
  	public int getWindowHeight() {
  		return this.windowHeight;
  	}

  	 /**
	 * Returns the window width from the settings class.
	 * 
	 * @return windowWidth		Window width specified by user
	 */
  	public int getWindowWidth() {
  		return this.windowWidth;
  	}

  	 /**
	 * Returns the window x position from the settings class.
	 * 
	 * @return windowPositionX		Window's x position on desktop
	 */
  	public int getWindowPositionX() {
  		return this.windowPositionX;
  	}

  	 /**
	 * Returns the window y position from the settings class.
	 * 
	 * @return windowPositionY		Window's y position on desktop
	 */
  	public int getWindowPositionY() {
  		return this.windowPositionY;
  	}

	 /**
	 * Sets the date.
	 * 
 	 * @param date			Date passed into by user
	 */
  	public void setDate(Date date) {
  		this.date = date;
 	}

	 /**
	 * Sets the dashboard configuration.
	 * 
	 * @param dashbaord		String passed in by user
	 */
  	public void setDashboard(String dashboard) {
  		this.dashboard = dashboard;
  	}

	 /**
	 * Sets the color theme of the GUI dashboard.
	 * 
	 * @param colorTheme	String passed into by user
	 */
  	public void setColorTheme(String colorTheme) {
  		this.colorTheme = colorTheme;
  	}

	 /**
	 * Sets the user from the settings class.
	 * 
	 * @param user		User from current session
	 */
  	public void setUser(User user) {
  		this.user = user;
  	}

  	 /**
	 * Sets the window height from the settings class.
	 * 
	 * @param windowHeight		Window height specified by user
	 */
  	public void getWindowHeight(int windowHeight) {
  		this.windowHeight = windowHeight;
  	}

  	 /**
	 * Sets the window width from the settings class.
	 * 
	 * @param windowWidth		Window width specified by user
	 */
  	public void getWindowWidth(int windowWidth) {
  		this.windowWidth = windowWidth;
  	}

  	 /**
	 * Sets the window x position from the settings class.
	 * 
	 * @param windowPositionX		Window's x position on desktop
	 */
  	public void getWindowPositionX(int windowPositionX) {
  		this.windowPositionX = windowPositionX;
  	}

  	 /**
	 * Sets the window y position from the settings class.
	 * 
	 * @param windowPositionY		Window's y position on desktop
	 */
  	public void getWindowPositionY(int windowPositionY) {
  		this.windowPositionY = windowPositionY;
  	}


}
////////////////////////////////////////////////////////////////////////////////
//                                   End                                      //
////////////////////////////////////////////////////////////////////////////////