package ca.uwo.csd.cs2212.team04;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by owner on 2016-03-24.
 */
public class Historicaldata extends Weather implements Serializable {

    private JSONObject apiResult;
    private JSONArray apiArray;
    private String date;

    public Historicaldata(){

        setApiResult(sendGet("London,Ontario,Canada&tp=24&date=2016-03-01&enddate=2016-03-23&format=json"));
        setApiArray();

        for(int i = 0; i < getApiArray().length(); i++){

            Weather current = new Weather();
            String date = apiResult.getJSONObject("data").getJSONArray("weather").getJSONObject(i).getString("date");
            System.out.println(date);
            current.setArrayHourly(apiResult.getJSONObject("data").getJSONArray("weather").getJSONObject(i).getJSONArray("hourly"));
            current.setData();

            try
            {
                FileOutputStream fileOut =
                        new FileOutputStream("FitByte/src/main/resources/Weather/" +date +".data");
                ObjectOutputStream out = new ObjectOutputStream(fileOut);
                out.writeObject(current);
                out.close();
                fileOut.close();
                System.out.printf("Serialized data is saved in");
            }catch(IOException ex)
            {
                ex.printStackTrace();
            }

        }

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

    public static void main(String [] args){

        Historicaldata curr = new Historicaldata();

    }

    public JSONArray getApiArray(){
        return apiArray;
    }

    public void setApiArray(){
        apiArray = getApiResult().getJSONObject("data").getJSONArray("weather");
    }

}
