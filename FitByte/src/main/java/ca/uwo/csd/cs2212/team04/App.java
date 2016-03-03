////////////////////////////////////////////////////////////////////////////////
//                               Fight Byte                                   //
////////////////////////////////////////////////////////////////////////////////
package ca.uwo.csd.cs2212.team04;

/**
 * This is the desktop application for CS 2212 at University of Western Ontario
 * which allows a user to display their FitBit data in a window on their 
 * computer in a customizable way that they prefer. On start up, the class 
 * performs the following:
 * <ul>
 * <li> Checks for an exisiting settings.config file, creates one is none
 * <li> Populates the user information from the previous session
 * <li> Calls new information for the day from API
 * <li> Opens the graphical user interface
 * </ul>
 * <p>
 * Working in a group of 8-10 people, we have come up with the FightByte 
 * applation that allows the user to track their daily and monthly goals as 
 * well as load their previous sessions data into memory.
 *
 * @author      Team 04
 * @version     %I%, %G%
 * @since       1.0
 */

import java.io.ObjectInputStream;
import java.io.FileInputStream;
import java.io.Serializable;
import java.awt.EventQueue;


////////////////////////////////////////////////////////////////////////////////
//                              App Class                                     //
////////////////////////////////////////////////////////////////////////////////
public class App implements Serializable {

	/**
	 * Main class function that calls and creates the necessary objects required
	 * to run the graphical user interface. A 'settings.config' file is read in 
	 * from memory or created if not present with default parameters. This can
	 * be run as either a test case that is restricted to reading data in from 
	 * memory, or as the actual case which enables the user to read data in 
	 * from the FitBit API provided.
	 *
	 * @param  args array of input strings provided by the user at run time
	 */
	public static void main(String[] args) throws Exception {

		Settings settings;		// settings required for loading GUI
		User user;				// user specific data
		Api api;				// access to Fitbit API
		//Test test;			// mock Fitbit API for testing

		// Read whether input arguments are present for test case
		if (args.length >= 1) {
			if (args[0].equals("test")) {
				System.err.println("Application is in test mode: " +
						"access to Fitbit API has been " +
						"restricted for this session.");
			}
		}

		// Load settings from previous settings
		try {

			ObjectInputStream in = new ObjectInputStream(
					new FileInputStream("settings.config"));
			settings = (Settings) in.readObject();
			in.close();

		} catch (Exception e) {
			// File not present, create a blank settings file
			settings = new Settings();
			settings.saveSettings();
			System.err.println("New settings file created");
		}


		// Test the data writing files
		Data data_01 = new Data("test");		// create new data file
		data_01.write("data_01");				// write to file
		data_01 = null;							// eliminate data file

		// Load data file
		try {
			ObjectInputStream in = new ObjectInputStream(
					new FileInputStream("data_01.data"));
			data_01 = (Data) in.readObject();
			in.close();
		} catch (Exception e) {
			System.err.println("Data file not found");
		}

		// data_01.print();						// print value loaded


		// Initialize the graphical user interface
		EventQueue.invokeLater(new Runnable() {
			/**
			 * run the main frame and set the window to be visible
			 */
			public void run() {
				try {
					MainFrame window = new MainFrame();
					window.frame.setVisible(true);
				}
				// catch the exception, and prints this throwable and 
				// its backtrace to the standard error stream.
				catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

	}


}
////////////////////////////////////////////////////////////////////////////////
//                                   End                                      //
////////////////////////////////////////////////////////////////////////////////