package ca.uwo.csd.cs2212.team04;

import org.json.JSONObject;

/**
 * Created by owner on 2016-02-28.
 */
public class Userdata extends Api {

    private JSONObject activities;

    public Userdata(){
        activities = null;
    }

    public void setActivities(){
        activities =  getInfo("activities/date/today.json");
    }

    public static void main (String args[]){

        Userdata temp = new Userdata();
        temp.setActivities();

    }

}
