package ca.uwo.csd.cs2212.team04;

import java.io.*;
// import java.io.Serializable;

public class App implements Serializable {

	public static void main(String [] args) throws Exception {
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
	        System.err.println(e + ": loadSettings failed");

	        // create a blank settings file
	        settings = new Settings();
	        settings.saveSettings();
	    }

		// open the interface (GUI)





		// request data from fitbit sever

		// 



	}

}