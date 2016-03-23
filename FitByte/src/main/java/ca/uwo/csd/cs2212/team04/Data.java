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
	public String colorTheme;
	public Date date;

	// from David
	public int DG_Step, DG_Distance, DG_SMinute;
	public int DG_AMinute, DG_Floor, DG_Calories;
	public String update;


	/*
	 * Default constructor for the data class. Only called if no previous
	 * settings exist. Settings from a current session are stored in a custom
	 * serialized file labelled 'settings.config'. Sets all to default.
	 *
	 */
	public Data() {

		windowHeight 	= 400;			// Default window height
		windowWidth 	= 400;			// Default window width
		colorTheme 		= "default";	// Default windows color theme

		DG_Step 		= 100;
		DG_Distance 	= 100;
		DG_SMinute 		= 100;
		DG_AMinute 		= 100;
		DG_Floor 		= 100;
		DG_Calories 	= 100;
	
		date 	= new Date();
		update 	= date.toString();
	}

}
////////////////////////////////////////////////////////////////////////////////
//                                   End                                      //
////////////////////////////////////////////////////////////////////////////////