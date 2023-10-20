/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package UTS;

import java.util.ArrayList;
import java.util.Date;


/**
 *
 * @author abil
 */
public class Reel extends Post {

    private int duration;
    private int pkayedCount;

    public Reel(int duration, int pkayedCount, String postId, ContentState status, Date timeUpload, ContentType postType, ArrayList<Comment> comments) {
        super(postId, status, timeUpload, postType, comments);
        this.duration = duration;
        this.pkayedCount = pkayedCount;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public int getPlayedCount() {
        return pkayedCount;
    }

    public void setPkayedCount(int pkayedCount) {
        this.pkayedCount = pkayedCount;
    }

    

    
}
