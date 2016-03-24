package ca.uwo.csd.cs2212.team04;

import java.awt.Color;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.border.LineBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.*;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.*;

import org.jdatepicker.impl.DateComponentFormatter;
import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.XYPlot;
import org.jfree.data.time.Day;
import org.jfree.data.time.Hour;
import org.jfree.data.time.Minute;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;

/**
 * This class generates GUI of FightByte application
 * 
 * @author cs2212_w2016_team04
 */
public class MainFrame {

	/**
	 * Attribute declarations
	 */
	public JFrame frame;

	private JPanel Login;
	private JTextField user_name;
	private JLabel lblSignUp;
	private JTextField pass_word;
	private JLabel lblPrivacyPolicy;
	private JButton btnLogin;
	private JLabel lblFightbyte;
	private JLabel lblPassword;
	private JLabel lblUsername;
	private JLabel lblClock;
	private Font loginFont = new Font("Times New Roman", Font.BOLD, 18);

	private JPanel Timeseries;
	private JEditorPane txtHeartRateZone, weatherDescription;
	private JTable HeartRate;
	public JFreeChart graph;
	public ChartPanel chart_panel;
	private Font graph_title = new Font("Times New Roman", Font.BOLD, 18);
	private Font graph_axis = new Font("Times New Roman", Font.PLAIN, 12);
	private Color txtColor = Color.BLACK;
	private JScrollPane hrzScroll;

	private JPanel Preference;
	private JLabel DG_setup, Step_setup, Floor_setup, Distance_setup,
			Calories_setup, SMinute_setup, AMinute_setup;
	private JTextField DG_Step_setup, DG_Floor_setup, DG_Distance_setup,
			DG_Calories_setup, DG_SMinute_setup, DG_AMinute_setup;
	private JButton dg_button;

	private JPanel Dashboard;
	private int FCX = 20; // first column x-coordinate
	private int CD = 140; // distance between columns
	private int FRY = 65; // first row y-coordinate
	private int txtDist = 60; // distance between text and the picture
	private int SRY = 220; // second row y-coordinate
	private JLabel txtYearMonthDay, lblStep, lblDistance, lblSMinute, lblFloor,
			lblCalories, lblAMinute, lastUpdate;
	private JLabel StepCount, Distance, SMinute, Floor, Calories, AMinute;
	private JTable bestPerf;
	private JTable lifeTotal;
	private Font generalFont = new Font("Times New Roman", Font.BOLD, 13);
	private Font tableFont = new Font("Times New Roman", Font.BOLD, 15);
	private int frameWidth = 678;
	private int frameHeight = 382;
	private JDatePanelImpl date_Panel;
	private JDatePickerImpl datePicker;
	private JProgressBar bar_Step, bar_Distance, bar_SMinute, bar_Floor,
			bar_Calories, bar_AMinute;
	private int DG_Step = 100;
	private int DG_Distance, DG_SMinute, DG_AMinute, DG_Floor, DG_Calories;
	private String[][] lifetotal, bestday;
	private String[] title;

	private Color gridColor, labelColor, btnColor, barColor, backgroundColor;
	final Color setPink = new Color(250, 180, 180);
	final Color darkRed = new Color(204, 0, 0);
	final Color setBlue = new Color(135, 230, 232);
	final Color darkBlue = new Color(0, 0, 102);
	final Color setGreen = new Color(153, 212, 114);
	final Color darkGreen = new Color(0, 102, 0);
	final Color setPurple = new Color(179, 132, 227);
	final Color setYellow = new Color(255, 255, 102);
	final Color darkYellow = new Color(153, 76, 0);

	static Settings setting;
	private String colorTheme;

	private Userdata newSession;
	private CurrentWeather newWeather;

	/**
	 * Launch the application.
	 */
	/*
	 * public static void main(String[] args) {
	 * 
	 * EventQueue.invokeLater(new Runnable() { public void run() { try { setting
	 * = new Settings(); MainFrame window = new MainFrame(true);
	 * window.frame.setVisible(true); } catch (Exception e) {
	 * e.printStackTrace(); } } }); }
	 */
	/**
	 * Constructor creates MainFrame object
	 * 
	 * @param fakeData  if fakeData is true, then use fake data to test the program
	 * @throws Exception if error, throw exception
	 */
	public MainFrame(boolean fakeData) throws Exception {
		setting = new Settings();

		newWeather = new CurrentWeather();
		newWeather.setWeather();
		// initialize the contents of the frame
		newSession = new Userdata(fakeData);
		colorTheme = setting.getColorTheme();

		if (colorTheme.equals("western")) {
			backgroundColor = setPurple;
			labelColor = Color.white;
			gridColor = Color.white;
			txtColor = Color.white;
			barColor = Color.gray;
		} else if (colorTheme.equals("spring")) {
			backgroundColor = setGreen;
			labelColor = darkGreen;
			gridColor = darkGreen;
			txtColor = darkGreen;
			barColor = darkGreen;
		} else if (colorTheme.equals("summer")) {
			backgroundColor = setPink;
			labelColor = darkRed;
			gridColor = darkRed;
			txtColor = darkRed;
			barColor = darkRed;
		} else if (colorTheme.equals("fall")) {
			backgroundColor = setYellow;
			labelColor = darkYellow;
			gridColor = darkYellow;
			txtColor = darkYellow;
			barColor = darkYellow;
		} else if (colorTheme.equals("winter")) {
			backgroundColor = setBlue;
			labelColor = darkBlue;
			gridColor = darkBlue;
			txtColor = darkBlue;
			barColor = darkBlue;
		} else {
			backgroundColor = null;
			labelColor = Color.black;
			gridColor = Color.black;
			txtColor = Color.black;
			barColor = null;
		}

		initialize();
		clock();
	}

	/**
	 * clock method adds a clock on the panel
	 */
	public void clock() {
		Thread clock = new Thread() {
			/**
			 * If this thread was constructed using a separate Runnable run
			 * object, then that Runnable object's run method is called
			 */
			public void run() {
				try {
					while (true) {
						// Gets a calendar using the default time zone and
						// locale.
						Calendar time = Calendar.getInstance();
						// Returns a Date object representing this Calendar's
						// time value
						String msg = new String(time.getTime().toString());
						lblClock.setText(msg);
						// Causes the currently executing thread to sleep
						sleep(1000);
					}
				} catch (InterruptedException ee) {
					ee.printStackTrace();
				}
			}
		};
		// Causes the clock thread to begin execution
		clock.start();
	}

	/**
	 * initialize method initializes the contents of the frame.
	 */
	private void initialize() {

		// get the size of user's screen
		Toolkit kit = Toolkit.getDefaultToolkit();
		Dimension screenSize = kit.getScreenSize();
		int screenWidth = (int) screenSize.getWidth();
		int screenHeight = (int) screenSize.getHeight();

		// set the midpoint of app
		int midWidth = screenWidth / 2 - frameWidth / 2;
		int midHeight = screenHeight / 2 - frameHeight / 2;

		frame = new JFrame();
		frame.setBounds(100, 100, 694, 442);
		frame.setTitle("FightByte");
		frame.setBounds(midWidth, midHeight, frameWidth + 18, frameHeight + 70);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		Image appIcon = kit.getImage("src/main/resources/appIcon.png");
		frame.setIconImage(appIcon);

		Dashboard = new JPanel();
		Dashboard.setBounds(0, 0, frameWidth, frameHeight);
		frame.getContentPane().add(Dashboard);
		Dashboard.setLayout(null);
		Dashboard.setVisible(false);

		JButton btnTimeSeries = new JButton("Time Series");
		btnTimeSeries.setForeground(btnColor);
		btnTimeSeries.addActionListener(new ActionListener() {
			/**
			 * When shows "Time Series" panel, set dashboard to be invisible
			 * 
			 * @param e
			 *            The action event of btnTimeSeries
			 */
			public void actionPerformed(ActionEvent e) {
				Dashboard.setVisible(false);
				Timeseries.setVisible(true);
			}
		});
		btnTimeSeries.setBounds(10, 10, 125, 23);
		Dashboard.add(btnTimeSeries);

		JButton btnPreference = new JButton("Preference");
		btnPreference.setForeground(btnColor);
		btnPreference.addActionListener(new ActionListener() {
			/**
			 * When shows "Preference" panel, set dashboard to be invisible
			 * 
			 * @param e
			 *            The action event of btnPreference
			 */
			public void actionPerformed(ActionEvent e) {
				Dashboard.setVisible(false);
				Preference.setVisible(true);
			}
		});
		btnPreference.setBounds(145, 10, 125, 23);
		Dashboard.add(btnPreference);

		Image imgA = new ImageIcon("src/main/resources/active.png").getImage();
		Image imgS = new ImageIcon("src/main/resources/sed.png").getImage();
		Image imgStep = new ImageIcon("src/main/resources/step.png").getImage();
		Image imgF = new ImageIcon("src/main/resources/floor.png").getImage();
		Image imgD = new ImageIcon("src/main/resources/distance.png")
				.getImage();
		Image imgC = new ImageIcon("src/main/resources/cal.png").getImage();

		lblStep = new JLabel("");
		lblStep.setIcon(new ImageIcon(imgStep));
		lblStep.setBounds(FCX + 5, FRY, 100, 100);
		Dashboard.add(lblStep);
		StepCount = new JLabel();
		StepCount.setForeground(labelColor);
		StepCount.setFont(generalFont);
		StepCount.setBounds(FCX, FRY + txtDist, 100, 100);
		Dashboard.add(StepCount);
		bar_Step = new JProgressBar();
		bar_Step.setStringPainted(true);
		bar_Step.setForeground(barColor);
		bar_Step.setBounds(FCX, FRY + 2 * txtDist, 100, 14);
		Dashboard.add(bar_Step);

		lblDistance = new JLabel("");
		lblDistance.setIcon(new ImageIcon(imgD));
		lblDistance.setBounds(FCX + CD, FRY, 100, 100);
		Dashboard.add(lblDistance);
		Distance = new JLabel();
		Distance.setForeground(labelColor);
		Distance.setFont(generalFont);
		Distance.setBounds(FCX + CD, FRY + txtDist, 100, 100);
		Dashboard.add(Distance);
		bar_Distance = new JProgressBar();
		bar_Distance.setStringPainted(true);
		bar_Distance.setForeground(barColor);
		bar_Distance.setBounds(FCX + CD, FRY + 2 * txtDist, 100, 14);
		Dashboard.add(bar_Distance);

		lblSMinute = new JLabel("");
		lblSMinute.setIcon(new ImageIcon(imgS));
		lblSMinute.setBounds(FCX + 2 * CD - 15, FRY, 100, 100);
		Dashboard.add(lblSMinute);
		SMinute = new JLabel();
		SMinute.setForeground(labelColor);
		SMinute.setFont(generalFont);
		SMinute.setBounds(FCX + 2 * CD, FRY + txtDist, 200, 100);
		Dashboard.add(SMinute);
		bar_SMinute = new JProgressBar();
		bar_SMinute.setForeground(barColor);
		bar_SMinute.setStringPainted(true);
		bar_SMinute.setBounds(FCX + 2 * CD, FRY + 2 * txtDist, 100, 14);
		Dashboard.add(bar_SMinute);

		lblFloor = new JLabel("");
		lblFloor.setIcon(new ImageIcon(imgF));
		lblFloor.setBounds(FCX, SRY, 100, 100);
		Dashboard.add(lblFloor);
		Floor = new JLabel();
		Floor.setForeground(labelColor);
		Floor.setFont(generalFont);
		Floor.setBounds(FCX, SRY + txtDist, 100, 100);
		Dashboard.add(Floor);
		bar_Floor = new JProgressBar();
		bar_Floor.setForeground(barColor);
		bar_Floor.setStringPainted(true);
		bar_Floor.setBounds(FCX, SRY + 2 * txtDist, 100, 14);
		Dashboard.add(bar_Floor);

		lblCalories = new JLabel("");
		lblCalories.setIcon(new ImageIcon(imgC));
		lblCalories.setBounds(FCX + CD + 10, SRY, 100, 100);
		Dashboard.add(lblCalories);
		Calories = new JLabel();
		Calories.setForeground(labelColor);
		Calories.setFont(generalFont);
		Calories.setBounds(FCX + CD - 15, SRY + txtDist, 150, 100);
		Dashboard.add(Calories);
		bar_Calories = new JProgressBar();
		bar_Calories.setStringPainted(true);
		bar_Calories.setForeground(barColor);
		bar_Calories.setBounds(FCX + CD, SRY + 2 * txtDist, 100, 14);
		Dashboard.add(bar_Calories);

		lblAMinute = new JLabel("");
		lblAMinute.setIcon(new ImageIcon(imgA));
		lblAMinute.setBounds(FCX + 2 * CD + 5, SRY, 100, 100);
		Dashboard.add(lblAMinute);
		AMinute = new JLabel();
		AMinute.setForeground(labelColor);
		AMinute.setFont(generalFont);
		AMinute.setBounds(FCX + 2 * CD, SRY + txtDist, 200, 100);
		Dashboard.add(AMinute);
		bar_AMinute = new JProgressBar();
		bar_AMinute.setStringPainted(true);
		bar_AMinute.setForeground(barColor);
		bar_AMinute.setBounds(FCX + 2 * CD, SRY + 2 * txtDist, 100, 14);
		Dashboard.add(bar_AMinute);

		title = new String[] { "", "" };
		bestday = new String[][] { { "Best Day", " " }, { "Step", "" },
				{ "Floor", "" }, { "Distance", "" } };
		bestPerf = new JTable(bestday, title);
		bestPerf.setRowSelectionAllowed(false);
		bestPerf.setEnabled(false);
		bestPerf.setFont(tableFont);
		bestPerf.setToolTipText("Best Performance");
		bestPerf.setOpaque(false);
		bestPerf.setDefaultRenderer(Object.class,
				new DefaultTableCellRenderer() {
					{
						setOpaque(false);
					}
				});
		bestPerf.setBounds(420, 70, 235, 63);
		Dashboard.add(bestPerf);

		lifetotal = new String[][] { { "Lifetime Total", " " },
				{ "Step", "" + newSession.gettotalStep() },
				{ "Floor", "" + newSession.gettotalFloor() },
				{ "Distance", "" + newSession.gettotalDistance() } };
		lifeTotal = new JTable(lifetotal, title);
		lifeTotal.setEnabled(false);
		lifeTotal.setRowSelectionAllowed(false);
		lifeTotal.setOpaque(false);
		lifeTotal.setDefaultRenderer(Object.class,
				new DefaultTableCellRenderer() {
					{
						setOpaque(false);
					}
				});
		lifeTotal.setFont(tableFont);
		lifeTotal.setToolTipText("Life Total");
		lifeTotal.setGridColor(gridColor);
		lifeTotal.setBorder(new LineBorder(gridColor));
		lifeTotal.setBounds(420, 155, 235, 63);
		Dashboard.add(lifeTotal);

		String[] empty = { "", "" };
		String[][] heartRate = { { "Heart Rate", " " }, { "Peak", "" },
				{ "Cardio", "" }, { "Fat Burn", "" }, { "Out of", "" },
				{ "Resting Rate", "" } };
		HeartRate = new JTable(heartRate, empty);
		HeartRate.setRowSelectionAllowed(false);
		HeartRate.setEnabled(false);
		HeartRate.setFont(tableFont);
		HeartRate.setOpaque(false);
		HeartRate.setDefaultRenderer(Object.class,
				new DefaultTableCellRenderer() {
					{
						setOpaque(false);
					}
				});
		HeartRate.setToolTipText("More information on the 'Timseries' Page");
		HeartRate.setBounds(420, 240, 235, 95);
		Dashboard.add(HeartRate);

		lastUpdate = new JLabel();
		lastUpdate.setBounds(418, 350, 235, 20);
		Dashboard.add(lastUpdate);

		txtYearMonthDay = new JLabel();
		txtYearMonthDay.setText("Pick Date");
		txtYearMonthDay.setBounds(300, 12, 100, 23);
		txtYearMonthDay.setForeground(labelColor);
		Dashboard.add(txtYearMonthDay);
		UtilDateModel dateModel = new UtilDateModel();
		Calendar time = Calendar.getInstance();
		dateModel.setDate(time.get(Calendar.YEAR), time.get(Calendar.MONTH),
				time.get(Calendar.DATE));
		dateModel.setSelected(true);
		Properties prop = new Properties();
		prop.put("text.today", "Today");
		prop.put("text.month", "Month");
		prop.put("text.year", "Year");
		date_Panel = new JDatePanelImpl(dateModel, prop);
		datePicker = new JDatePickerImpl(date_Panel,
				new DateComponentFormatter());
		datePicker.setBorder(new CompoundBorder());
		datePicker.setBounds(403, 10, 150, 30);
		datePicker.setButtonFocusable(true);
		Dashboard.add(datePicker);

		JButton btnRefresh = new JButton("Refresh");
		btnRefresh.setForeground(btnColor);
		btnRefresh.addActionListener(new ActionListener() {
			/**
			 * actionPerformed method used to set texts
			 * 
			 * @param e
			 *            A semantic event which indicates that a
			 *            component-defined action occurred
			 */
			public void actionPerformed(ActionEvent e) {
				Date chosen_date = (Date) datePicker.getModel().getValue();
				setting.setUpdate();
				newSession.setDate(chosen_date);
				newSession.refreshData();
				updateData();
			}
		});
		btnRefresh.setBounds(570, 12, 100, 23);
		Dashboard.add(btnRefresh);

		Preference = new JPanel();
		Preference.setBounds(0, 0, frameWidth, frameHeight);
		frame.getContentPane().add(Preference);
		Preference.setLayout(null);
		Preference.setVisible(false);

		JButton btnDashboard_1 = new JButton("Dashboard");
		btnDashboard_1.setForeground(btnColor);
		btnDashboard_1.addActionListener(new ActionListener() {
			/**
			 * When shows "Dashboard" panel, set "Preference" to be invisible
			 * and "Dashboard" to be visible"
			 * 
			 * @param e
			 *            The action event of btnTimeSeries
			 */
			public void actionPerformed(ActionEvent e) {
				Preference.setVisible(false);
				Dashboard.setVisible(true);
			}
		});
		btnDashboard_1.setBounds(10, 10, 123, 23);
		Preference.add(btnDashboard_1);

		JButton btnTimeseries = new JButton("Timeseries");
		btnTimeseries.setForeground(btnColor);
		btnTimeseries.addActionListener(new ActionListener() {
			/**
			 * When shows "Timeseries" panel, set "Preference" to be invisible
			 * and "Timeseries" to be visible"
			 * 
			 * @param e
			 *            The action event of btnTimeSeries
			 */
			public void actionPerformed(ActionEvent e) {
				Preference.setVisible(false);
				Timeseries.setVisible(true);
			}
		});
		btnTimeseries.setBounds(143, 10, 125, 23);
		Preference.add(btnTimeseries);

		DG_setup = new JLabel();
		DG_setup.setText("Edit Daily Goals");
		DG_setup.setFont(graph_title);
		DG_setup.setBounds(265, 50, 250, 50);
		Preference.add(DG_setup);

		Step_setup = new JLabel();
		Step_setup.setText("Step:");
		Step_setup.setBounds(240, 100, 100, 30);
		Preference.add(Step_setup);
		DG_Step_setup = new JTextField();
		DG_Step_setup.setEditable(true);
		DG_Step_setup.setBounds(300, 100, 100, 30);
		Preference.add(DG_Step_setup);

		Floor_setup = new JLabel();
		Floor_setup.setText("Floor:");
		Floor_setup.setBounds(240, 140, 100, 30);
		Preference.add(Floor_setup);
		DG_Floor_setup = new JTextField();
		DG_Floor_setup.setEditable(true);
		DG_Floor_setup.setBounds(300, 140, 100, 30);
		Preference.add(DG_Floor_setup);

		Distance_setup = new JLabel();
		Distance_setup.setText("Distance:");
		Distance_setup.setBounds(225, 180, 100, 30);
		Preference.add(Distance_setup);
		DG_Distance_setup = new JTextField();
		DG_Distance_setup.setEditable(true);
		DG_Distance_setup.setBounds(300, 180, 100, 30);
		Preference.add(DG_Distance_setup);

		Calories_setup = new JLabel();
		Calories_setup.setText("Calories:");
		Calories_setup.setBounds(225, 220, 100, 30);
		Preference.add(Calories_setup);
		DG_Calories_setup = new JTextField();
		DG_Calories_setup.setEditable(true);
		DG_Calories_setup.setBounds(300, 220, 100, 30);
		Preference.add(DG_Calories_setup);

		SMinute_setup = new JLabel();
		SMinute_setup.setText("Sedentary Minute:");
		SMinute_setup.setBounds(170, 260, 150, 30);
		Preference.add(SMinute_setup);
		DG_SMinute_setup = new JTextField();
		DG_SMinute_setup.setEditable(true);
		DG_SMinute_setup.setBounds(300, 260, 100, 30);
		Preference.add(DG_SMinute_setup);

		AMinute_setup = new JLabel();
		AMinute_setup.setText("Active Minute:");
		AMinute_setup.setBounds(190, 300, 100, 30);
		Preference.add(AMinute_setup);
		DG_AMinute_setup = new JTextField();
		DG_AMinute_setup.setEditable(true);
		DG_AMinute_setup.setBounds(300, 300, 100, 30);
		Preference.add(DG_AMinute_setup);

		dg_button = new JButton("Update Daily Goal");
		dg_button.addActionListener(new ActionListener() {
			/**
			 * actionPerformed method used to set texts
			 * 
			 * @param e
			 *            A semantic event which indicates that a
			 *            component-defined action occurred
			 */
			public void actionPerformed(ActionEvent e) {
				try {
					int step = Integer.parseInt(DG_Step_setup.getText());
					int distance = Integer.parseInt(DG_Distance_setup.getText());
					int calories = Integer.parseInt(DG_Calories_setup.getText());
					int sminute = Integer.parseInt(DG_SMinute_setup.getText());
					int aminute = Integer.parseInt(DG_AMinute_setup.getText());
					int floor = Integer.parseInt(DG_Floor_setup.getText());
					if (step < 0 || distance < 0 || calories < 0 || sminute < 0
							|| aminute < 0 || floor < 0) {
						JOptionPane.showMessageDialog(frame,
								"Please insert a positive integer. Thank you!",
								"Friendly Reminder",
								JOptionPane.WARNING_MESSAGE);
					} else {
						setting.setDG_Step(step);
						setting.setDG_Distance(distance);
						setting.setDG_Calories(calories);
						setting.setDG_AMinute(aminute);
						setting.setDG_SMinute(sminute);
						setting.setDG_Floor(floor);
						setting.setUpdate();
						try {
							setting.saveSettings();
						} catch (Exception e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						updateData();
					}
				} catch (NumberFormatException e3) {
					JOptionPane.showMessageDialog(frame,
							"Please insert a valid integer input. Thank you!",
							"Friendly Reminder", JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		dg_button.setBounds(420, 300, 200, 30);
		Preference.add(dg_button);

		Timeseries = new JPanel();
		Timeseries.setBounds(0, 0, frameWidth, frameHeight);
		frame.getContentPane().add(Timeseries);
		Timeseries.setLayout(null);
		Timeseries.setVisible(false);

		JButton btnDashboard = new JButton("Dashboard");
		btnDashboard.setForeground(btnColor);
		btnDashboard.addActionListener(new ActionListener() {
			/**
			 * actionPerformed method used to set texts
			 * 
			 * @param e
			 *            A semantic event which indicates that a
			 *            component-defined action occurred
			 */
			public void actionPerformed(ActionEvent e) {
				Timeseries.setVisible(false);
				Dashboard.setVisible(true);
			}
		});
		btnDashboard.setBounds(10, 10, 125, 23);
		Timeseries.add(btnDashboard);

		JButton btnPreference_1 = new JButton("Preference");
		btnPreference_1.setForeground(btnColor);
		btnPreference_1.addActionListener(new ActionListener() {
			/**
			 * When shows "Preference" panel, set Preference to be visible and
			 * "Time series" to be invisible"
			 * 
			 * @param e
			 *            The action event of btnTimeSeries
			 */
			public void actionPerformed(ActionEvent e) {
				Timeseries.setVisible(false);
				Preference.setVisible(true);
			}
		});
		btnPreference_1.setBounds(145, 10, 125, 23);
		Timeseries.add(btnPreference_1);

		TimeSeriesCollection dataset = new TimeSeriesCollection();
		TimeSeries distance_series = new TimeSeries("Distance", Minute.class);
		TimeSeries step_series = new TimeSeries("Step", Minute.class);
		TimeSeries calories_series = new TimeSeries("Calories", Minute.class);
		TimeSeries heartRate_series = new TimeSeries("Heart Rate", Minute.class);

		double[] Distancevalue = newSession.getDistanceHourGraph();
		int[] Stepvalue = newSession.getStepHourGraph();
		int[] Caloriesvalue = newSession.getCaloriesHourGraph();
		int[] heartRatevalue = newSession.getHeartRateHourGraph();

		int hl = Distancevalue.length;
		int track = 0;
		int minute_track = 0;
		Day today = new Day();
		int hour = 0;
		Minute min;

		Hour h = new Hour(hour, today);
		while (track < hl) {
			min = new Minute(minute_track, h);
			distance_series.add(min, Distancevalue[track]);
			step_series.add(min, Stepvalue[track]);
			calories_series.add(min, Caloriesvalue[track]);
			if (minute_track >= 60) {
				minute_track = minute_track - 60;
				hour++;
				h = new Hour(hour, today);
			}
			minute_track++;
			track++;
		}
		
		hl = heartRatevalue.length;
		track = 0;
		String startTime = newSession.getFirstTime();
		hour = Integer.parseInt(startTime.substring(0, 2));
		h = new Hour(hour, today);
		minute_track = Integer.parseInt(startTime.substring(3, 5));
		while (track < hl) {
			min = new Minute(minute_track, h);
			heartRate_series.add(min, heartRatevalue[track]);
			if (minute_track >= 60) {
				minute_track = minute_track - 60;
				hour++;
				h = new Hour(hour, today);
			}
			minute_track++;
			track++;
		}

		dataset.addSeries(distance_series);
		dataset.addSeries(step_series);
		dataset.addSeries(calories_series);
		dataset.addSeries(heartRate_series);

		JFreeChart chart = ChartFactory.createTimeSeriesChart("", "Time",
				"Distance", dataset, true, true, false);

		// get the plot, both axis and the renderer
		XYPlot plot = (XYPlot) chart.getPlot();
		// DateAxis xAxis = (DateAxis) plot.getDomainAxis();
		// NumberAxis yAxis = (NumberAxis) plot.getRangeAxis();
		// XYItemRenderer renderer = plot.getRenderer();

		NumberAxis axis_step = new NumberAxis("Step");
		axis_step.setTickLabelFont(graph_axis);
		axis_step.setAutoRangeIncludesZero(false);
		plot.setRangeAxis(1, axis_step);
		plot.mapDatasetToRangeAxis(1, 1);

		NumberAxis axis_calories = new NumberAxis("Calories");
		axis_calories.setTickLabelFont(graph_axis);
		axis_calories.setAutoRangeIncludesZero(false);
		plot.setRangeAxis(2, axis_calories);
		plot.mapDatasetToRangeAxis(2, 2);

		NumberAxis axis_heartRate = new NumberAxis("Heart Rate");
		axis_heartRate.setTickLabelFont(graph_axis);
		axis_heartRate.setAutoRangeIncludesZero(false);
		plot.setRangeAxis(2, axis_heartRate);
		plot.mapDatasetToRangeAxis(3, 3);

		chart_panel = new ChartPanel(chart);
		chart_panel.setBounds(10, 50, 435, 320);
		chart_panel.setMouseWheelEnabled(true);
		Timeseries.add(chart_panel);

		txtHeartRateZone = new JEditorPane("text/html", "");
		txtHeartRateZone.setOpaque(false);
		txtHeartRateZone.setEditable(false);
		txtHeartRateZone
				.setText("<u><b>What Are Heart Rate Zones?</u></b><br>"
						+ "Heart rate zones can help you optimize your workout by targeting different training intensities. The default zones are calculated using your estimated maximum heart rate. Fitbit calculates your maximum heart rate with the common formula of 220 minus your age. The illustrations below provide examples for each zone.<br>"
						+ "<u><b>Peak Zone</u></b><br>"
						+ "Your heart rate is greater than 85% of maximum, is the high-intensity exercise zone. The peak zone is for short intense sessions that improve performance and speed.<br>"
						+ "<u><b>Cardio Zone</u></b><br>"
						+ "Your heart rate is 70 to 84% of maximum, is the medium-to-high intensity exercise zone. In this zone, you're pushing yourself but not straining. For most people, this is the exercise zone to target.<br>"
						+ "<u><b>Fat Burned Zone</u></b><br>"
						+ "Your heart rate is 70 to 84% of maximum, is the medium-to-high intensity exercise zone. In this zone, you're pushing yourself but not straining. For most people, this is the exercise zone to target.<br>"
						+ "<u><b>Out of Zone</u></b><br>"
						+ "Your heart rate is below 50% of maximum, your heart rate may still be elevated but not enough to be considered exercise.");
		hrzScroll = new JScrollPane(txtHeartRateZone,
				JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		hrzScroll.getViewport().setOpaque(false);
		hrzScroll.setForeground(txtColor);
		txtHeartRateZone.setForeground(txtColor);
		hrzScroll.setBounds(455, 50, 215, 320);
		Timeseries.add(hrzScroll);

		Login = new JPanel();
		Login.setBounds(0, 0, frameWidth, frameHeight);
		frame.getContentPane().add(Login);
		Login.setLayout(null);

		lblClock = new JLabel("Clock");
		lblClock.setBounds(10, 10, 412, 22);
		Login.add(lblClock);
		lblClock.setFont(loginFont);

		lblSignUp = new JLabel("Sign Up");
		lblSignUp.setBounds(250, 308, 95, 15);
		Login.add(lblSignUp);

		lblPrivacyPolicy = new JLabel("Privacy Policy");
		lblPrivacyPolicy.setBounds(80, 308, 137, 15);
		Login.add(lblPrivacyPolicy);

		btnLogin = new JButton("Login");
		btnLogin.setBounds(330, 247, 95, 47);
		Login.add(btnLogin);

		pass_word = new JTextField("password");
		pass_word.setBounds(135, 272, 189, 21);
		Login.add(pass_word);
		pass_word.setColumns(10);

		user_name = new JTextField("username");
		user_name.setBounds(135, 247, 189, 21);
		Login.add(user_name);
		user_name.setColumns(10);

		// create a JLabel object lblFightbyte to show the title "FightByte"
		lblFightbyte = new JLabel("FightByte");
		lblFightbyte.setBounds(85, 107, 450, 87);
		Login.add(lblFightbyte);
		lblFightbyte.setFont(new Font("Times New Roman", Font.PLAIN, 75));
		lblFightbyte.setForeground(labelColor);

		// create a JLabel object lblPassword to display "Password"
		lblPassword = new JLabel("Password");
		lblPassword.setBounds(10, 272, 122, 22);
		Login.add(lblPassword);
		lblPassword.setFont(loginFont);

		// create a JLabel object lblUsername to display "Username"
		lblUsername = new JLabel("Username");
		lblUsername.setBounds(10, 244, 115, 22);
		Login.add(lblUsername);
		lblUsername.setFont(loginFont);
		btnLogin.addActionListener(new ActionListener() {
			/**
			 * actionPerformed method useded to set texts
			 * 
			 * @param e
			 *            A semantic event which indicates that a
			 *            component-defined action occurred
			 */
			public void actionPerformed(ActionEvent e) {
				Login.setVisible(false);
				Dashboard.setVisible(true);
			}
		});
		lblPrivacyPolicy.addMouseListener(new MouseAdapter() {
			/**
			 * mouseClicked method when click on the "Forgot password", link to
			 * the Fitbit forgot passwaord website page
			 *
			 * @param e
			 *            An event which indicates that a mouse action occurred
			 *            in a component
			 */
			public void mouseClicked(MouseEvent e) {
				Desktop desktop = Desktop.getDesktop();
				try {
					URI uri = new URI("https://www.fitbit.com/ca/privacy");
					desktop.browse(uri);
				} catch (URISyntaxException e1) {
					JOptionPane.showMessageDialog(null,
							"The URL is no Longer Valid");
					e1.printStackTrace();
				} catch (IOException ex) {
				}

			}
		});
		lblSignUp.addMouseListener(new MouseAdapter() {
			/**
			 * mouseClicked method when click on the "Sign up", link to the
			 * Fitbit sign up website page
			 *
			 * @param e
			 *            An event which indicates that a mouse action occurred
			 *            in a component
			 */
			public void mouseClicked(MouseEvent e) {
				Desktop desktop = Desktop.getDesktop();
				try {
					URI uri = new URI("https://www.fitbit.com/login");
					desktop.browse(uri);
				} catch (URISyntaxException e1) {
					JOptionPane.showMessageDialog(null,
							"The URL is no Longer Valid");
					e1.printStackTrace();
				} catch (IOException ex) {
					JOptionPane.showMessageDialog(null,
							"The URL is no Longer Valid");
				}

			}
		});

		/** Add weather */
		JLabel weatherLabel = new JLabel("");
		weatherLabel.setBounds(470, 80, 300, 150);
		if ((newWeather.getWeather()).equals("sun")) {
			Image imgSun = new ImageIcon("src/main/resources/sun.png")
					.getImage();
			weatherLabel.setIcon(new ImageIcon(imgSun));
		} else if ((newWeather.getWeather()).equals("cloud")) {
			Image imgCloud = new ImageIcon("src/main/resources/cloud.png")
					.getImage();
			weatherLabel.setIcon(new ImageIcon(imgCloud));
		} else if ((newWeather.getWeather()).equals("rain")) {
			Image imgRain = new ImageIcon("src/main/resources/rain.png")
					.getImage();
			weatherLabel.setIcon(new ImageIcon(imgRain));
		} else if ((newWeather.getWeather()).equals("snow")) {
			Image imgSnow = new ImageIcon("src/main/resources/snow.png")
					.getImage();
			weatherLabel.setIcon(new ImageIcon(imgSnow));
		} else {
			JLabel weatherError = new JLabel("");
			Login.add(weatherError);
			System.out.println("Wow you find a new weather!");
		}

		Login.add(weatherLabel);
		// JEditorPane
		weatherDescription = new JEditorPane();
		weatherDescription.setOpaque(false);
		weatherDescription.setEditable(false);
		weatherDescription.setText("" + newWeather.getTemperature()
				+ (char) 0x00B0 + "C\n" + newWeather.getWeatherDescription());
		weatherDescription.setBounds(470, 250, 300, 150);
		Login.add(weatherDescription);

		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);

		JMenu mnFile = new JMenu("File");
		menuBar.add(mnFile);

		JMenuItem mntmExit = new JMenuItem("Exit");
		mntmExit.addActionListener(new ActionListener() {
			/**
			 * actionPerformed method useded to exit the application
			 * 
			 * @param e
			 *            A semantic event which indicates that a
			 *            component-defined action occurred
			 */
			// @Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		mnFile.add(mntmExit);

		// create color change menu
		JMenu mnColor = new JMenu("Theme");
		menuBar.add(mnColor);
		JMenuItem western = new JMenuItem("Western");
		JMenuItem spring = new JMenuItem("Spring");
		JMenuItem summer = new JMenuItem("Summer");
		JMenuItem fall = new JMenuItem("Fall");
		JMenuItem winter = new JMenuItem("Winter");
		JMenuItem default_theme = new JMenuItem("Default");
		mnColor.add(western);
		mnColor.add(spring);
		mnColor.add(summer);
		mnColor.add(fall);
		mnColor.add(winter);
		mnColor.add(default_theme);
		western.addActionListener(new ActionListener() {
			/**
			 * actionPerformed method useded to set texts
			 * 
			 * @param e
			 *            A semantic event which indicates that a
			 *            component-defined action occurred
			 */
			public void actionPerformed(ActionEvent e) {
				backgroundColor = setPurple;
				labelColor = Color.white;
				gridColor = Color.white;
				txtColor = Color.white;
				barColor = Color.gray;

				refreshColor();
				setting.setColorTheme("western");
				try {
					setting.saveSettings();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		spring.addActionListener(new ActionListener() {
			// @Override
			/**
			 * actionPerformed method used to set texts
			 * 
			 * @param e
			 *            A semantic event which indicates that a
			 *            component-defined action occurred
			 */
			public void actionPerformed(ActionEvent e) {
				backgroundColor = setGreen;
				labelColor = darkGreen;
				gridColor = darkGreen;
				txtColor = darkGreen;
				barColor = darkGreen;

				refreshColor();
				setting.setColorTheme("spring");
				try {
					setting.saveSettings();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		summer.addActionListener(new ActionListener() {
			// @Override
			/**
			 * actionPerformed method used to set texts
			 * 
			 * @param e
			 *            A semantic event which indicates that a
			 *            component-defined action occurred
			 */
			public void actionPerformed(ActionEvent e) {
				backgroundColor = setPink;
				labelColor = darkRed;
				gridColor = darkRed;
				txtColor = darkRed;
				barColor = darkRed;

				refreshColor();
				setting.setColorTheme("summer");
				try {
					setting.saveSettings();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		fall.addActionListener(new ActionListener() {
			// @Override
			/**
			 * actionPerformed method used to set texts
			 * 
			 * @param e
			 *            A semantic event which indicates that a
			 *            component-defined action occurred
			 */
			public void actionPerformed(ActionEvent e) {
				backgroundColor = setYellow;
				labelColor = darkYellow;
				gridColor = darkYellow;
				txtColor = darkYellow;
				barColor = darkYellow;
				refreshColor();
				setting.setColorTheme("fall");
				try {
					setting.saveSettings();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		winter.addActionListener(new ActionListener() {
			// @Override
			/**
			 * actionPerformed method used to set texts
			 * 
			 * @param e
			 *            A semantic event which indicates that a
			 *            component-defined action occurred
			 */
			public void actionPerformed(ActionEvent e) {
				backgroundColor = setBlue;
				labelColor = darkBlue;
				gridColor = darkBlue;
				txtColor = darkBlue;
				barColor = darkBlue;

				refreshColor();
				setting.setColorTheme("winter");
				try {
					setting.saveSettings();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});
		default_theme.addActionListener(new ActionListener() {
			// @Override
			/**
			 * actionPerformed method used to set texts
			 * 
			 * @param e
			 *            A semantic event which indicates that a
			 *            component-defined action occurred
			 */
			public void actionPerformed(ActionEvent e) {
				backgroundColor = null;
				labelColor = Color.black;
				gridColor = Color.black;
				txtColor = Color.black;
				barColor = null;

				refreshColor();
				setting.setColorTheme("default");
				try {
					setting.saveSettings();
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});

		setting.setUpdate();
		refreshColor();
		updateData();

	}

	/**
	 * updateData method used to update data
	 * 
	 */
	public void updateData() {
		DG_Step = setting.getDG_Step();
		DG_Floor = setting.getDG_Floor();
		DG_SMinute = setting.getDG_SMinute();
		DG_AMinute = setting.getDG_AMinute();
		DG_Distance = setting.getDG_Distance();
		DG_Calories = setting.getDG_Calories();

		lastUpdate.setText("Update: " + setting.getUpdate());

		bar_Step.setValue((int) (100 * newSession.getSteps() / DG_Step));
		bar_Distance
				.setValue((int) (100 * newSession.getDistance() / DG_Distance));
		bar_AMinute.setValue((int) (100 * (newSession.getMinutesFairlyActive()
				+ newSession.getMinutesLightlyActive() + newSession
				.getMinutesVeryActive()) / DG_AMinute));
		bar_Calories
				.setValue((int) (100 * newSession.getDailyCalories() / DG_Calories));
		bar_Floor.setValue((int) (100 * newSession.getFloors() / DG_Floor));
		bar_SMinute
				.setValue((int) (100 * newSession.getMinutesSedentary() / DG_SMinute));

		bar_Step.setToolTipText(newSession.getSteps() + " / " + DG_Step);
		bar_Distance.setToolTipText(newSession.getDistance() + " / "
				+ DG_Distance);
		bar_AMinute.setToolTipText((newSession.getMinutesFairlyActive()
				+ newSession.getMinutesLightlyActive() + newSession
					.getMinutesVeryActive()) + " / " + DG_AMinute);
		bar_SMinute.setToolTipText(newSession.getMinutesSedentary() + " / "
				+ DG_SMinute);
		bar_Calories.setToolTipText(newSession.getDailyCalories() + " / "
				+ DG_Calories);
		bar_Floor.setToolTipText(newSession.getFloors() + " / " + DG_Floor);

		StepCount.setText("Step: " + newSession.getSteps());
		Distance.setText("Distance: " + newSession.getDistance());
		SMinute.setText("SMinute: " + newSession.getMinutesSedentary());
		Floor.setText("Floor: " + newSession.getFloors());
		Calories.setText("Calories: " + newSession.getDailyCalories());
		AMinute.setText("AMinute: "
				+ (newSession.getMinutesFairlyActive()
						+ newSession.getMinutesLightlyActive() + newSession
							.getMinutesVeryActive()));

		DG_Step_setup.setText("" + DG_Step);
		DG_Floor_setup.setText("" + DG_Floor);
		DG_Distance_setup.setText("" + DG_Distance);
		DG_Calories_setup.setText("" + DG_Calories);
		DG_SMinute_setup.setText("" + DG_SMinute);
		DG_AMinute_setup.setText("" + DG_AMinute);

		// step - floor - distance
		bestPerf.setValueAt("" + newSession.getBstep(), 1, 1);
		bestPerf.setValueAt("" + newSession.getBfloor(), 2, 1);
		bestPerf.setValueAt("" + newSession.getBdistance(), 3, 1);
		lifeTotal.setValueAt("" + newSession.gettotalStep(), 1, 1);
		lifeTotal.setValueAt("" + newSession.gettotalFloor(), 2, 1);
		lifeTotal.setValueAt("" + newSession.gettotalDistance(), 3, 1);
		HeartRate.setValueAt("" + newSession.getPeakZone(), 1, 1);
		HeartRate.setValueAt("" + newSession.getCardioZone(), 2, 1);
		HeartRate.setValueAt("" + newSession.getFatburnZone(), 3, 1);
		HeartRate.setValueAt("" + newSession.getOutofZone(), 4, 1);
		HeartRate.setValueAt("" + newSession.getRestingRate(), 5, 1);
	}

	/**
	 * refreshColor method used to refresh color settings
	 * 
	 */
	public void refreshColor() {
		Login.setBackground(backgroundColor);
		Timeseries.setBackground(backgroundColor);
		Preference.setBackground(backgroundColor);
		Dashboard.setBackground(backgroundColor);

		user_name.setForeground(txtColor);
		pass_word.setForeground(txtColor);
		lblClock.setForeground(txtColor);
		txtHeartRateZone.setForeground(txtColor);
		txtHeartRateZone.setBorder(new LineBorder(gridColor));
		txtYearMonthDay.setForeground(txtColor);
		weatherDescription.setForeground(txtColor);

		lblPrivacyPolicy.setForeground(labelColor);
		lblSignUp.setForeground(labelColor);
		lblFightbyte.setForeground(labelColor);
		lblPassword.setForeground(labelColor);
		lblUsername.setForeground(labelColor);
		lastUpdate.setForeground(labelColor);
		StepCount.setForeground(labelColor);
		Distance.setForeground(labelColor);
		SMinute.setForeground(labelColor);
		Floor.setForeground(labelColor);
		Calories.setForeground(labelColor);
		AMinute.setForeground(labelColor);
		bar_Step.setForeground(barColor);
		bar_Distance.setForeground(barColor);
		bar_SMinute.setForeground(barColor);
		bar_Floor.setForeground(barColor);
		bar_Calories.setForeground(barColor);
		bar_AMinute.setForeground(barColor);

		DG_setup.setForeground(labelColor);
		Step_setup.setForeground(labelColor);
		Floor_setup.setForeground(labelColor);
		Distance_setup.setForeground(labelColor);
		Calories_setup.setForeground(labelColor);
		SMinute_setup.setForeground(labelColor);
		AMinute_setup.setForeground(labelColor);

		HeartRate.setGridColor(gridColor);
		bestPerf.setGridColor(gridColor);
		lifeTotal.setGridColor(gridColor);
		HeartRate.setBorder(new LineBorder(gridColor));
		bestPerf.setBorder(new LineBorder(gridColor));
		lifeTotal.setBorder(new LineBorder(gridColor));
		HeartRate.setForeground(txtColor);
		bestPerf.setForeground(txtColor);
		lifeTotal.setForeground(txtColor);
	}
}
