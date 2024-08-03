package Main;


import java.io.*;

interface userProfile {
    public String getName();

    public String getBloodType();

    public String getHealthHistory();
}

public class Profile implements Serializable, userProfile {
    private String name;
    private String bloodType;
    private String healthHistory;

    Profile(String name, String bloodType, String healthHistory) {
        this.name = name;
        this.bloodType = bloodType;
        this.healthHistory = healthHistory;
    }

    public String getName() {
        return name;
    }

    public String getBloodType() {
        return bloodType;
    }

    public String getHealthHistory() {
        return healthHistory;
    }

}
