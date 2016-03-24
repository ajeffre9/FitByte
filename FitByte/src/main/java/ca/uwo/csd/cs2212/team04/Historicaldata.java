package ca.uwo.csd.cs2212.team04;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by owner on 2016-03-24.
 */
public class Historicaldata extends WeatherData implements Serializable {

    private JSONObject apiResult;
    private String date;

    public Historicaldata(){

        setApiResult(sendGet("London,Ontario,Canada&tp=24&date=2016-03-01&enddate=" +getDate() +"&format=json"));


    }

    /**
     *  Set the current date for the day the data is collected
     */
    public void setDate(){

        Date dNow = new Date();
        SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd");
        date = ft.format(dNow);

    }

    /**
     * Get the date for the day
     * @return date
     */
    public String getDate(){

        return date;

    }

    public void setApiResult(JSONObject temp) {
        this.apiResult = temp;
        System.out.println(temp);
    }

    public JSONObject getApiResult() {
        return apiResult;
    }

}
