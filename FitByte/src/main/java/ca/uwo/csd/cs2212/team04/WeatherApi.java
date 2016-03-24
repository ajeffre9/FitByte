package ca.uwo.csd.cs2212.team04;

import org.json.JSONObject;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by owner on 2016-03-21.
 */
public class WeatherApi {

    private static final String USER_AGENT = "Mozilla/5.0";

    // Getting the weather for a particular place using HTTP GET request
    public static JSONObject sendGet(String requestedURL){

        //read credentials from a file
        BufferedReader bufferedReader=null;

        // This will reference one line at a time
        String line = null;

        //Need to save service credentials for Weather
        String apiKey = null;

        //Response String that is returned from the GET request
        StringBuffer response = null;

        //
        int responseCode = 0;

        try {
            // File with service credentials.

            FileReader fileReader =
                    new FileReader("FitByte/src/main/resources/weatherKey.txt");
            bufferedReader = new BufferedReader(fileReader);
            apiKey= bufferedReader.readLine();
            bufferedReader.close();

        }
        catch(FileNotFoundException ex) {
            System.out.println(
                    "Unable to open file\n"+ex.getMessage());
            System.exit(1);
        }
        catch(IOException ex) {
            System.out.println(
                    "Error reading/write file\n"+ex.getMessage());
            System.exit(1);
        }
        finally{
            try{
                if (bufferedReader!=null)
                    // Always close files.
                    bufferedReader.close();
            }
            catch(Exception e){
                System.out.println(
                        "Error closing file\n"+e.getMessage());
            }
        }

        String requestUrlPrefix = "http://api.worldweatheronline.com/premium/v1/past-weather.ashx?" +apiKey;
        String requestUrl;

        //The URL from this point is how you ask for different information
        requestUrl = requestUrlPrefix + requestedURL;

        try {
            URL obj = new URL(requestUrl);
            HttpURLConnection con = (HttpURLConnection) obj.openConnection();

            // optional default is GET
            con.setRequestMethod("GET");

            //add request header
            con.setRequestProperty("User-Agent", USER_AGENT);

            responseCode = con.getResponseCode();
            System.out.println("\nSending 'GET' request to URL : " + requestUrl);
            System.out.println("Response Code : " + responseCode);

            BufferedReader in = new BufferedReader(
                    new InputStreamReader(con.getInputStream()));
            String inputLine;
            response = new StringBuffer();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }

            in.close();

        }catch(MalformedURLException ex){
            System.out.println(
                    "There is something wrong with your request URL\n"
                            +ex.getMessage());

        }catch(IOException ex){
            System.out.println(
                    "Error reading/write file\n"+ex.getMessage());
        }
        //initialize
        JSONObject jsonObj = null;

        switch(responseCode){
            case 200:
                System.out.println("Success!");
                System.out.println("HTTP response body:\n"+response.toString());
                jsonObj = new JSONObject(response.toString());

                break;
            case 400:
                System.out.println("Bad Request - may have to talk to Beth");
                System.out.println("HTTP response body:\n"+response.toString());
                break;
            case 429:
                System.out.println("Rate limit exceeded");
                System.out.println("HTTP response body:\n"+response.toString());
                break;
            default:
                System.out.println("HTTP response code: "+responseCode);
                System.out.println("HTTP response body:\n"+response.toString());
        }

        //print result
        //System.out.println(response.toString());

        return jsonObj;

    }

    public static void main(String[] args) throws Exception {

        WeatherApi http = new WeatherApi();

        System.out.println("Testing 1 - Send Http GET request");
        http.sendGet("London,Ontario,Canada&date=today&format=json");

    }
}
