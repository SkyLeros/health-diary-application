package Main;

import java.io.*;
import java.util.*;

interface healthData {
    public int getIndex();

    public String getDate();

    public double getWeight();

    public double getHeight();

    public double getBodyTemperature();

    public double getBMI();

    public String toString();
}

public class Record implements Serializable, healthData {
    
    public static final long serialVersionUID = -4240373044966597802L;
    
    private int index;
    private String date;
    private double weight;
    private double height;
    private double bodyTemperature;
    private double BMI;

    Record(int index, String date, double weight, double height, double bodyTemperature, double BMI) {
        this.index = index;
        this.date = date;
        this.weight = weight;
        this.height = height;
        this.bodyTemperature = bodyTemperature;
        this.BMI = BMI;
    }

    public int getIndex() {
        return index;
    }

    public String getDate() {
        return date;
    }

    public double getWeight() {
        return weight;
    }

    public double getHeight() {
        return height;
    }

    public double getBodyTemperature() {
        return bodyTemperature;
    }

    public double getBMI() {
        return BMI;
    }

    public String toString() {
        return index + " " + date + " " + weight + " " + height + " " + bodyTemperature + " " + BMI;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public void setBodyTemperature(double bodyTemperature) {
        this.bodyTemperature = bodyTemperature;
    }

    public void setBMI(double BMI) {
        this.BMI = BMI;
    }
    
    // Ascending 
    public static Comparator<Record> weightCompAsc = new Comparator<Record>(){
        @Override
        public int compare(Record w1, Record w2){
            if(w1.getWeight() > w2.getWeight())
                   return 1;
            if(w1.getWeight() < w2.getWeight())
                return -1;
            return 0;
        }
    };
    
    public static Comparator<Record> bmiCompAsc = new Comparator<Record>(){
        @Override
        public int compare(Record bmi1, Record bmi2){
            if(bmi1.getBMI() > bmi2.getBMI())
                return 1;
            if(bmi1.getBMI() < bmi2.getBMI())
                return -1;
            return 0;
        }
    };
    
    public static Comparator<Record> dateCompAsc = new Comparator<Record>(){
        @Override
        public int compare(Record d1, Record d2){
            if(d1.getDate().compareTo(d2.getDate()) > 0)
                return 1;
            if(d1.getDate().compareTo(d2.getDate()) < 0)
                return -1;
            return 0;
        }
    };
    
    // Descending
    public static Comparator<Record> weightCompDesc = new Comparator<Record>(){
        @Override
        public int compare(Record w1, Record w2){
            if(w1.getWeight() > w2.getWeight())
                   return -1;
            if(w1.getWeight() < w2.getWeight())
                return 1;
            return 0;
        }
    };
    
    public static Comparator<Record> bmiCompDesc = new Comparator<Record>(){
        @Override
        public int compare(Record bmi1, Record bmi2){
            if(bmi1.getBMI() > bmi2.getBMI())
                return -1;
            if(bmi1.getBMI() < bmi2.getBMI())
                return 1;
            return 0;
        }
    };
    
    public static Comparator<Record> dateCompDesc = new Comparator<Record>(){
        @Override
        public int compare(Record d1, Record d2){
            if(d1.getDate().compareTo(d2.getDate()) > 0)
                return -1;
            if(d1.getDate().compareTo(d2.getDate()) < 0)
                return 1;
            return 0;
        }
    };
}
