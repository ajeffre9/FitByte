package ca.uwo.csd.cs2212.team04;

import java.io.*;
// import java.io.Serializable;

public class App implements Serializable {

	public static void main(String [] args) throws Exception {
		

		// read in whether this is a test mode
		if (args.length >= 1) {
			if (args[0].equals("test")) {
				System.err.println("This is a test");
			} 
		} else {
			System.err.println("This is not a test");
		}



		// begin the system
		Settings settings;
		User user;

		// load previous settings
    	try {
	     	// //Load settings from memory
	      	ObjectInputStream in = new ObjectInputStream(
	                                  new FileInputStream("settings.config"));

	      	settings = (Settings) in.readObject();
	      	in.close();

	      	System.err.println("Settings successfully read");

	    } catch (Exception e) {
	        //System.err.println(e + ": loadSettings failed");
			System.err.println("New  settings file created");
	        // create a blank settings file
	        settings = new Settings();
	        settings.saveSettings();
	    }

		
		// request data from fitbit sever



		// open the interface (GUI)
	    //GUI gui = new GUI(settings, user);

	    




		//

		// 



	}

}