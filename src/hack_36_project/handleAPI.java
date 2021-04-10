package hack_36_project;

import javax.net.ssl.HttpsURLConnection;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

public class handleAPI {
    private static HttpsURLConnection connection;
    private String response="";
    private Boolean normalStatus = true;
    public handleAPI(String s,String apiType) {
        BufferedReader reader;
        String line;
        StringBuffer responseContent = new StringBuffer();
        try {
            try {
                URL url = new URL(s);
                connection = (HttpsURLConnection) url.openConnection();
                if(apiType.equals("OXFORD_API")){
                    connection.setRequestProperty("Accept", "application/json");
                    final String app_id = "3be76e36";
                    final String app_key = "4db61a1cadb7a7634b63d78474e2bc01";
                    connection.setRequestProperty("app_id", app_id);
                    connection.setRequestProperty("app_key", app_key);
                }
                if(apiType.equals("YOUTUBE_API"))   connection.setRequestMethod("GET");

                connection.setConnectTimeout(5000);
                connection.setReadTimeout(5000);

                int status = connection.getResponseCode();
                //System.out.println(status);

                if(status >= 300) {
                    reader = new BufferedReader(new InputStreamReader(connection.getErrorStream()));
                } else {
                    reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                }
                while ((line = reader.readLine()) != null) {
                    responseContent.append(line);
                }
                reader.close();
                //System.out.println(responseContent.toString());
                response = responseContent.toString();
            } catch (FileNotFoundException e){
                response = "No definition Found";
                //System.out.println("hello debugger1");
                normalStatus = false;// if definition is not found then response returned will be this
            }
        } catch (MalformedURLException e) {
            response = e.getStackTrace().toString();
            //System.out.println("hello debugger2");
            normalStatus = false;
        } catch (IOException e) {
            response = e.getStackTrace().toString();
            //System.out.println("hello debugger3");
            normalStatus = false;
        } finally {
            connection.disconnect();
        }
    }
    public String getResponse(){
        return this.response;
    }
    public Boolean getStatus(){
        return this.normalStatus;
    }

}

