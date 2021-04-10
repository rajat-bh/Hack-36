/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package hack_36_project;

/**
 *
 * @author asus
 */
public class Item {
    
    private int key;
    private String title;

    public Item(int key, String title) {
        this.key = key;
        this.title = title;
    }

    
    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    
    
    
}
