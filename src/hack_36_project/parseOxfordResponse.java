/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hack_36_project;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/**
 *
 * @author RJ
 */

public class parseOxfordResponse {
    private String meaning="";
    parseOxfordResponse(String response){
        try {
            JSONObject total = new JSONObject(response);
            JSONArray results = total.getJSONArray("results");
            JSONObject single_result = results.getJSONObject(0);
            JSONArray lexicalEntries = single_result.getJSONArray("lexicalEntries");
            JSONObject single_lexicalEntry = lexicalEntries.getJSONObject(0);
            JSONArray entries = single_lexicalEntry.getJSONArray("entries");
            JSONObject single_entry = entries.getJSONObject(0);
            JSONArray senses = single_entry.getJSONArray("senses");
            JSONObject single_sense = senses.getJSONObject(0);
            JSONArray definitions = single_sense.getJSONArray("definitions");
            meaning = definitions.getString(0);
            System.out.println(meaning);
        }catch (JSONException e){
            meaning = "No meaning Found! Please enter a valid word.";
        }
    }
    String getMeaning(){
        return this.meaning;
    }
}

