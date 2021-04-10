/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hack_36_project;
import javax.net.ssl.HttpsURLConnection;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Lenovo
 */
public class APIHandler{
    private String query;
    private String meaning_query;
    public APIHandler(String query,String meaning_query){
        this.query = query;
        this.meaning_query = meaning_query;
    }
    public String HandleYT(){
        String responseBodyYT;

        String apiType="";
        ArrayList<String> types = new ArrayList<>();
        types.add("YOUTUBE_API");
        types.add("OXFORD_API");
//        System.out.println("Enter the query: ");
//        Scanner sc = new Scanner(System.in);           //Use of scanner here for testing purposes
//        query = sc.nextLine();
        String urlYT = new makeURLYT(query).getURLYT();   //gets the api https for youtube
        handleAPI objYT = new handleAPI(urlYT,"YOUTUBE_API");
        responseBodyYT = objYT.getResponse();
                return (responseBodyYT);
    }
 //       String  ="hermes";
//        System.out.println("Enter the word query: ");
//        meaning_query = sc.nextLine();
        public String HandleOxford(){
            String responseBodyOxford;
            String urlOxford = new makeURLOxford(meaning_query).getURLOxford();
            handleAPI objOxford = new handleAPI(urlOxford,"OXFORD_API");
            responseBodyOxford = objOxford.getResponse();
            //This block Checks and Parse
            //System.out.println(responseBodyOxford);
                return (responseBodyOxford);
        }
}
