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
	Date date;
	String name;

	/**
	 * Default constructor for the data class.
	 *
	 */
	public Data(String name) {
		date = new Date();			// Enter todays date
		this.name = name; 		// Test purposes only
	}


	/**
	 * Write data to file through serialization
	 *
	 * @param filename		Filename for the data file to write
	 */
	public void write(String filename) {

		try {
	      	ObjectOutputStream out = new ObjectOutputStream(
                                     new FileOutputStream(filename + ".data"));
	      	out.writeObject(this);
	      	out.close();

		} catch (Exception e) {
			System.err.println(e + ": failed to save settings");
		}
	}

	/**
	 * Print number for test purposes
	 *
	 */
	public void print() {

		System.err.println(name);
	}

}
////////////////////////////////////////////////////////////////////////////////
//                                   End                                      //
////////////////////////////////////////////////////////////////////////////////