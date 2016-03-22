////////////////////////////////////////////////////////////////////////////////
//                               Fight Byte                                   //
////////////////////////////////////////////////////////////////////////////////
package ca.uwo.csd.cs2212.team04;

/**
 * This class is used to store Fitbit data to a file to be read in at a later 
 * time without having to request it through the Fitbit API. This is a generaic
 * template used to store a variety of types of data to limit the number of 
 * specific classes requried. Files are stored per day and are labelled via
 * the date. e.g. "2016_02_29.data"
 *
 */

import java.io.ObjectOutputStream;
import java.io.FileOutputStream;
import java.io.Serializable;
import java.util.Date;

////////////////////////////////////////////////////////////////////////////////
//                               Data Class                                   //
////////////////////////////////////////////////////////////////////////////////
public class Data implements Serializable {

	/**
	 * Application parameters
	 *
	 */

	public int windowHeight, windowWidth;
	public int windowPositionX, windowPositionY;
	public String colorTheme, dashboard;
	public User user;
	public Date date;


	/*
	 * Default constructor for the data class. Only called if no previous
	 * settings exist. Settings from a current session are stored in a custom
	 * serialized file labelled 'settings.config'. Sets all to default.
	 *
	 */
	public Data() {

		windowHeight 	= 400;			// Default window height
		windowWidth 	= 400;			// Default window width
		windowPositionX = 400;			// Default window x position
		windowPositionY = 400;			// Default window y position
		colorTheme 		= "default";	// Default windows color theme
		dashboard  		= "default";	// Default dashboard configuration

		//user = new User();			// Create a new user
		date = new Date();				// Select today as default date

	}


	// /**
	//  * Write data to file through serialization
	//  *
	//  * @param filename		Filename for the data file to write
	//  */
	// public void write(String filename) {

	// 	try {
	//       	ObjectOutputStream out = new ObjectOutputStream(
 //                                     new FileOutputStream(filename + ".data"));
	//       	out.writeObject(this);
	//       	out.close();

	// 	} catch (Exception e) {
	// 		System.err.println(e + ": failed to save settings");
	// 	}
	// }


}
////////////////////////////////////////////////////////////////////////////////
//                                   End                                      //
////////////////////////////////////////////////////////////////////////////////