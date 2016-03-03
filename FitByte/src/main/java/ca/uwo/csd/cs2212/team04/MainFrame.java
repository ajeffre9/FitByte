package ca.uwo.csd.cs2212.team04;

import java.awt.Desktop;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.*;
import java.awt.Font;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.*;

/**
 * This class generates GUI of FightByte application 
 * @author cs2212_w2016_team04
 */
public class MainFrame {

	/**
	 * Attribute declarations 
	 */
	public JFrame frame;
	private JTextField user_name;
	private JTextField pass_word;
	public JLabel lblClock;
	private JPanel Login;
	private JPanel Dashboard;
	private JPanel Timeseries;
	private JPanel Preference;
	private JTable BestPerf;
	private JTable LifeTotal;
	private JTextField txtThisWillBe;
	private JTextField txtHeartRateZone;
	private JTextField txtDashboardPreference;
	private JTextField txtSelfDefineGoal;
	private JTextField txtDailyGoal;
	private JTextField txtEditTheLook;
	private JTextField txtYearMonthDay;
	private Userdata newSession;

	/**
	 * Launch the application.
	 */
	// public static void main(String[] args) {
	// 	EventQueue.invokeLater(new Runnable() {
 //            /**
 //             * run the main frame and set the window to be visible
 //             */
	// 		public void run() {
	// 			try {
	// 				MainFrame window = new MainFrame();
	// 				window.frame.setVisible(true);
	// 			}
	// 			//catch the exception, and 
	// 			//prints this throwable and its backtrace to the standard error stream.
	// 			catch (Exception e) {
	// 				e.printStackTrace();
	// 			}
	// 		}
	// 	});
	// }

	/**
	 * Constructor creates MainFrame object
	 */
	public MainFrame(boolean fakeData) {
		// initialize the contents of the frame
		newSession = new Userdata(fakeData);
		initialize();
		// add a clock on the panel
		clock();


	}

	/**
	 * clock method adds a clock on the panel
	 */
	public void clock(){
		//create an new thread object clock
		Thread clock = new Thread(){
			/**
			 * If this thread was constructed using a separate Runnable run object, 
			 * then that Runnable object's run method is called
			 */
			public void run(){
				try{
					while(true){
						//Gets a calendar using the default time zone and locale.
						Calendar time = Calendar.getInstance();
						//Returns a Date object representing this Calendar's time value 
						String msg = new String (time.getTime().toString());
						lblClock.setText(msg);
					    //Causes the currently executing thread to sleep 
						sleep(1000);
					}
				} 
				 //catch the exception when the clock thread is waiting, sleeping, 
				//or otherwise occupied, and the thread is interrupted, either before or during the activity.
				 catch (InterruptedException ee){
					ee.printStackTrace();
				}
			}
		};
		//Causes the clock thread to begin execution
		clock.start();
	}
	
	/**
	 * initialize method initializes the contents of the frame.
	 */
	private void initialize() {
		//Constructs a new frame with default bound data and be able to exit
		frame = new JFrame();
		frame.setBounds(100, 100, 694, 442);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		//Creates a new JPanel as the dashboard and registers the text to display in a tool tip
		Dashboard = new JPanel();
		Dashboard.setToolTipText("Best_Performance");
		Dashboard.setBounds(0, 0, 678, 382);
		//add dashboard to the main frame
		frame.getContentPane().add(Dashboard);
		Dashboard.setLayout(null);
		Dashboard.setVisible(false);
		
		//Create a JButton object shows "Time Series", 
		//add it on the dashboard and make it able to receive action
		JButton btnTimeSeries = new JButton("Time Series");
		btnTimeSeries.addActionListener(new ActionListener() {
			/**
			 * When shows "Time Series" panel, set dashboard to be invisible
			 * @param e The action event of btnTimeSeries
			 */
			public void actionPerformed(ActionEvent e) {
				Dashboard.setVisible(false);
				Timeseries.setVisible(true);
			}
		});
		btnTimeSeries.setBounds(10, 10, 125, 23);
		Dashboard.add(btnTimeSeries);
		
		//Create a JButton object shows "Preference", 
		//add it on the dashboard and make it able to receive action
		JButton btnPreference = new JButton("Preference");
		btnPreference.addActionListener(new ActionListener() {
			/**
			 * When shows "Preference" panel, set dashboard to be invisible
			 * @param e The action event of btnPreference
			 */
			public void actionPerformed(ActionEvent e) {
				Dashboard.setVisible(false);
				Preference.setVisible(true);
			}
		});
		btnPreference.setBounds(145, 10, 125, 23);
		Dashboard.add(btnPreference);
		
		//Creates a JLabel object Stepcount with the specified text:"Step"
		//Add 07icon image to the label, add it to the panel and set at proper position
		JLabel Stepcount = new JLabel("");
		// Image img = new ImageIcon(this.getClass().getResource("/07icon.jpg")).getImage();
		// Stepcount.setIcon(new ImageIcon(img));
		Stepcount.setBounds(51, 79, 100, 100);
		Dashboard.add(Stepcount);
		
		//Creates a JLabel object SMinute
		//Add 07icon image to the label, add it to the panel and set at proper position
		JLabel SMinute = new JLabel("");

		// SMinute.setIcon(new ImageIcon(img));
		SMinute.setBounds(171, 53, 100, 100);
		Dashboard.add(SMinute);
		//SMinute.set
		//Creates a JLabel object Distance
		//Add 07icon image to the label, add it to the panel and set at proper position
		JLabel Distance = new JLabel("");
		// Distance.setIcon(new ImageIcon(img));
		Distance.setBounds(295, 79, 100, 100);
		Dashboard.add(Distance);
		
		//Creates a JLabel object AMinute
		//Add 07icon image to the label, add it to the panel and set at proper position
		JLabel AMinute = new JLabel("");
		// AMinute.setIcon(new ImageIcon(img));
		AMinute.setBounds(295, 221, 100, 100);
		Dashboard.add(AMinute);
		
		//Creates a JLabel object Calories
		//Add 07icon image to the label, add it to the panel and set at proper position
		JLabel Calories = new JLabel("");
		// Calories.setIcon(new ImageIcon(img));
		Calories.setBounds(171, 240, 100, 100);
		Dashboard.add(Calories);
		
		//Creates a JLabel object Floor
		//Add 07icon image to the label, add it to the panel and set at proper position
		JLabel Floor = new JLabel("");
		// Floor.setIcon(new ImageIcon(img));
		Floor.setBounds(51, 221, 100, 100);
		Dashboard.add(Floor);
		
		//Creates a JLabel object lblStep with context "Step"
		//add it to the panel and set at proper position
		JLabel lblStep = new JLabel("Steps: " +newSession.getSteps());
		lblStep.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblStep.setBounds(51, 155, 100, 100);
		Dashboard.add(lblStep);
		
		//Creates a JLabel object lblSMinute with context "SMinute"
		//add it to the panel and set at proper position
		JLabel lblSMinute = new JLabel("SMinute: " +newSession.getMinutesSedentary());
		lblSMinute.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblSMinute.setBounds(171, 155, 100, 100);
		Dashboard.add(lblSMinute);
		
		//Creates a JLabel object lblDistance with context "Distance"
		//add it to the panel and set at proper position
		JLabel lblDistance = new JLabel("Distance: " +newSession.getDistance());
		lblDistance.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblDistance.setBounds(295, 180, 200,200);
		Dashboard.add(lblDistance);
		
		//Creates a JLabel object lblAMinute with context "AMinute"
		//add it to the panel and set at proper position
		JLabel lblAMinute = new JLabel("AMinute: " +newSession.getMinutesFairlyActive());
		lblAMinute.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblAMinute.setBounds(295, 320, 100,100);
		Dashboard.add(lblAMinute);
		
		//Creates a JLabel object lblCalories with context "Calories"
		//add it to the panel and set at proper position
		JLabel lblCalories = new JLabel("Calories: " +newSession.getDailyCalories());
		lblCalories.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblCalories.setBounds(150, 320, 100,100);
		Dashboard.add(lblCalories);
		
		//Creates a JLabel object lblFloor with context "Floor"
		//add it to the panel and set at proper position
		JLabel lblFloor = new JLabel("Floor: " +newSession.getFloors());
		lblFloor.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblFloor.setBounds(51, 320, 100,100);
		Dashboard.add(lblFloor);
		
		//Creates a JLabel object lblStep with context "Step"
		//add it to the panel and set at proper position
		BestPerf = new JTable();
		BestPerf.setToolTipText("Best Performance");
		BestPerf.setBounds(440, 67, 205, 133);
		Dashboard.add(BestPerf);
		
		//Creates a JLabel object lblStep with context "Step"
		//add it to the panel and set at proper position
		LifeTotal = new JTable();
		LifeTotal.setToolTipText("Best Performance");
		LifeTotal.setBounds(440, 216, 205, 133);
		Dashboard.add(LifeTotal);
		
		JSpinner spinner = new JSpinner();
		spinner.setBounds(422, 35, 69, 22);
		Dashboard.add(spinner);
		
		JSpinner spinner_1 = new JSpinner();
		spinner_1.setBounds(507, 35, 69, 22);
		Dashboard.add(spinner_1);
		
		JSpinner spinner_2 = new JSpinner();
		spinner_2.setBounds(586, 35, 69, 22);
		Dashboard.add(spinner_2);
		
		//Create a new JTextField object txtYearMonthDay which can change dates
		txtYearMonthDay = new JTextField();
		txtYearMonthDay.setHorizontalAlignment(SwingConstants.CENTER);
		txtYearMonthDay.setText("     Year           Month               Day");
		txtYearMonthDay.setBounds(412, 10, 242, 23);
		Dashboard.add(txtYearMonthDay);
		txtYearMonthDay.setColumns(10);
		
		Dashboard.setVisible(false);
		
		Timeseries = new JPanel();
		Timeseries.setBounds(0, 0, 678, 382);
		frame.getContentPane().add(Timeseries);
		Timeseries.setLayout(null);
		Timeseries.setVisible(false);
		
		JButton btnDashboard = new JButton("Dashboard");
		btnDashboard.addActionListener(new ActionListener() {
			/**
			 * When shows "Dashboard" panel, set dashboard to be visible and "Time series" to be invisible"
			 * @param e The action event of btnTimeSeries
			 */
			public void actionPerformed(ActionEvent e) {
				Timeseries.setVisible(false);
				Dashboard.setVisible(true);
			}
		});
		btnDashboard.setBounds(10, 10, 125, 23);
		Timeseries.add(btnDashboard);
		
		JButton btnPreference_1 = new JButton("Preference");
		btnPreference_1.addActionListener(new ActionListener() {
			/**
			 * When shows "Preference" panel, set Preference to be visible and "Time series" to be invisible"
			 * @param e The action event of btnTimeSeries
			 */
			public void actionPerformed(ActionEvent e) {
				Timeseries.setVisible(false);
				Preference.setVisible(true);
			}
		});
		btnPreference_1.setBounds(145, 10, 125, 23);
		Timeseries.add(btnPreference_1);
		
		txtThisWillBe = new JTextField();
		txtThisWillBe.setText("This will be the graphing area");
		txtThisWillBe.setBounds(10, 95, 477, 277);
		Timeseries.add(txtThisWillBe);
		txtThisWillBe.setColumns(10);
		
		txtHeartRateZone = new JTextField();
		txtHeartRateZone.setText("Heart rate zone information");
		txtHeartRateZone.setBounds(502, 36, 166, 336);
		Timeseries.add(txtHeartRateZone);
		txtHeartRateZone.setColumns(10);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("Step");
		rdbtnNewRadioButton.setBounds(31, 55, 76, 23);
		Timeseries.add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnCalories = new JRadioButton("Calories");
		rdbtnCalories.setBounds(109, 55, 76, 23);
		Timeseries.add(rdbtnCalories);
		
		JRadioButton rdbtnHeartRatelong = new JRadioButton("Heart Rate (Long)");
		rdbtnHeartRatelong.setBounds(187, 55, 139, 23);
		Timeseries.add(rdbtnHeartRatelong);
		
		JRadioButton rdbtnHeartRateshort = new JRadioButton("Heart Rate (Short)");
		rdbtnHeartRateshort.setBounds(327, 55, 139, 23);
		Timeseries.add(rdbtnHeartRateshort);
		Timeseries.setVisible(false);
		
		Preference =new JPanel();
		Preference.setBounds(0, 0, 678, 382);
		frame.getContentPane().add(Preference);
		Preference.setLayout(null);
		Preference.setVisible(false);
		
		JButton btnDashboard_1 = new JButton("Dashboard");
		btnDashboard_1.addActionListener(new ActionListener() {
			/**
			 * When shows "Dashboard" panel, set "Preference" to be invisible and "Dashboard" to be visible"
			 * @param e The action event of btnTimeSeries
			 */
			public void actionPerformed(ActionEvent e) {
				Preference.setVisible(false);
				Dashboard.setVisible(true);
			}
		});
		btnDashboard_1.setBounds(10, 10, 123, 23);
		Preference.add(btnDashboard_1);
		
		JButton btnTimeseries = new JButton("Timeseries");
		btnTimeseries.addActionListener(new ActionListener() {
			/**
			 * When shows "Timeseries" panel, set "Preference" to be invisible and "Timeseries" to be visible"
			 * @param e The action event of btnTimeSeries
			 */
			public void actionPerformed(ActionEvent e) {
				Preference.setVisible(false);
				Timeseries.setVisible(true);
			}
		});
		btnTimeseries.setBounds(143, 10, 125, 23);
		Preference.add(btnTimeseries);
		
		txtDashboardPreference = new JTextField();
		txtDashboardPreference.setText("Dashboard Preference");
		txtDashboardPreference.setBounds(10, 43, 328, 157);
		Preference.add(txtDashboardPreference);
		txtDashboardPreference.setColumns(10);
		
		txtSelfDefineGoal = new JTextField();
		txtSelfDefineGoal.setText("Self Define Goal");
		txtSelfDefineGoal.setColumns(10);
		txtSelfDefineGoal.setBounds(348, 43, 320, 157);
		Preference.add(txtSelfDefineGoal);
		
		txtDailyGoal = new JTextField();
		txtDailyGoal.setText("Daily Goal");
		txtDailyGoal.setColumns(10);
		txtDailyGoal.setBounds(10, 215, 328, 157);
		Preference.add(txtDailyGoal);
		
		txtEditTheLook = new JTextField();
		txtEditTheLook.setText("Edit The Look");
		txtEditTheLook.setColumns(10);
		txtEditTheLook.setBounds(348, 215, 320, 157);
		Preference.add(txtEditTheLook);
		
        /**
         * Create an new JPanel object Login which shows the login page		
         */
		Login = new JPanel();
		Login.setBounds(0, 0, 678, 382);
		frame.getContentPane().add(Login);
		Login.setLayout(null);
		
		//Display the clock on the login page
		lblClock = new JLabel("Clock");
		lblClock.setBounds(10, 10, 412, 22);
		Login.add(lblClock);
		lblClock.setFont(new Font("Times New Roman", Font.BOLD, 18));
		
		//Create a JLabel object lblSignUp with contect "Sign Up" which can connect to the next page
		JLabel lblSignUp = new JLabel("Sign Up");
		lblSignUp.setBounds(359, 308, 95, 15);
		Login.add(lblSignUp);
		
		//create a JLabel object lblForgotPassword with contect "Forgot Password?"
		JLabel lblForgotPassword = new JLabel("Forgot Password?");
		lblForgotPassword.setBounds(168, 308, 137, 15);
		Login.add(lblForgotPassword);
		
		//the login button
		JButton btnLogin = new JButton("Login");
		btnLogin.setBounds(471, 247, 95, 47);
		Login.add(btnLogin);
		
		//Creates a place to enter password 
		pass_word = new JTextField();
		pass_word.setBounds(272, 272, 189, 21);
		Login.add(pass_word);
		pass_word.setColumns(10);
		
		//Creates a place to enter username 
		user_name = new JTextField();
		user_name.setBounds(272, 247, 189, 21);
		Login.add(user_name);
		user_name.setColumns(10);
		
		//create a JLabel object lblFightbyte to show the title "FightByte"
		JLabel lblFightbyte = new JLabel("FightByte");
		lblFightbyte.setBounds(189, 107, 299, 87);
		Login.add(lblFightbyte);
		lblFightbyte.setFont(new Font("Times New Roman", Font.PLAIN, 75));
		
		//create a JLabel object lblPassword to display "Password"
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(168, 272, 73, 22);
		Login.add(lblPassword);
		lblPassword.setFont(new Font("Times New Roman", Font.BOLD, 18));
		
		//create a JLabel object lblUsername to display "Username"
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setBounds(168, 244, 77, 22);
		Login.add(lblUsername);
		lblUsername.setFont(new Font("Times New Roman", Font.BOLD, 18));
		btnLogin.addActionListener(new ActionListener() {
			/**
			 * actionPerformed method useded to set texts
			 * @param e A semantic event which indicates that a component-defined action occurred
			 */
			public void actionPerformed(ActionEvent e) {
				String username = user_name.getText();
				String password = pass_word.getText();
				/*
				try{
					//something for the authentication
				} catch (IOException wrongInfo){ 
					JOptionPane.showMessageDialog(null, "Please re-enter your login information. Thank you!");
				}
				*/
				Login.setVisible(false);
				Dashboard.setVisible(true);
			}
		});
		lblForgotPassword.addMouseListener(new MouseAdapter(){
			/**
			 *mouseClicked method when click on the "Forgot password", link to the Fitbit forgot passwaord website page
			 *@param e An event which indicates that a mouse action occurred in a component
			 */
			public void mouseClicked(MouseEvent e){
				Desktop desktop = Desktop.getDesktop();
				try {
					URI uri = new URI("https://www.fitbit.com/login/forgotPassword");
					desktop.browse(uri);
				} catch (URISyntaxException e1) {
					e1.printStackTrace();
				} catch (IOException ex){
					//do nothing
				}

			}
		});
		lblSignUp.addMouseListener(new MouseAdapter(){
			/**
			 *mouseClicked method when click on the "Sign up", link to the Fitbit sign up website page
			 *@param e An event which indicates that a mouse action occurred in a component
			 */
			public void mouseClicked(MouseEvent e){
				Desktop desktop = Desktop.getDesktop();
				try {
					URI uri = new URI("https://www.fitbit.com/login");
					desktop.browse(uri);
				} catch (URISyntaxException e1) {
					e1.printStackTrace();
				} catch (IOException ex){
					//do nothing
				}

			}
		});
		
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		JMenu mnFile = new JMenu("File");
		menuBar.add(mnFile);
		
		JMenuItem mntmExit = new JMenuItem("Exit");
		mntmExit.addActionListener(new ActionListener() {
			/**
			 * actionPerformed method useded to exit the application
			 * @param e A semantic event which indicates that a component-defined action occurred
			 */
			//@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		mnFile.add(mntmExit);
	}
}
