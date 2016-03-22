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

import java.awt.EventQueue;


////////////////////////////////////////////////////////////////////////////////
//                              App Class                                     //
////////////////////////////////////////////////////////////////////////////////
public class App {

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

	private static boolean fakeData;

	public static void main(String[] args) throws Exception {

		Settings settings;		// settings required for loading GUI
		User user;				// user specific data
		Api api;				// access to Fitbit API
		//Test test;			// mock Fitbit API for testing

		fakeData = false;

		// Read whether input arguments are present for test case
		if (args.length >= 1) {
			if (args[0].equals("test")) {
				System.err.println("Application is in test mode: " +
						"access to Fitbit API has been " +
						"restricted for this session.");
				fakeData = true;
			}
		}

		// // Load settings from previous settings		
		// settings = new Settings();

		// Initialize the graphical user interface
		EventQueue.invokeLater(new Runnable() {
			/**
			 * run the main frame and set the window to be visible
			 */
			public void run() {
				try {
					MainFrame window = new MainFrame(fakeData);
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