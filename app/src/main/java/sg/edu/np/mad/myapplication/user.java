package sg.edu.np.mad.myapplication;

import java.io.Serializable;

public class user implements Serializable {
    public String name;
    public String description;
    public int id;
    public boolean followed;

    public user(){}

    public user(String name, String description, int id, boolean followed){
        this.name = name;
        this.description = description;
        this.id = id;
        this.followed = followed;
    }
}


