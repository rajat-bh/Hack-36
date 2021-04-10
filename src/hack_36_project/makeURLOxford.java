/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hack_36_project;

/**
 *
 * @author RJ
 */
public class makeURLOxford {
    final String word = "Hermes";
    private String restUrl="";
    public makeURLOxford(String word) {
        String s = "";
        final String language = "en-gb";
        final String fields = "definitions";
        final String strictMatch = "false";
        final String word_id = word.toLowerCase();
        restUrl = "https://od-api.oxforddictionaries.com:443/api/v2/entries/" + language + "/" + word_id + "?" + "fields=" + fields + "&strictMatch=" + strictMatch;
    }
    public String getURLOxford(){return this.restUrl;}
}
