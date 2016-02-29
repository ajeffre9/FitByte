package ca.uwo.csd.cs2212.team04;

import com.sun.java.swing.plaf.windows.WindowsBorders;

import java.util.Date;

/**
 * Created by owner on 2016-02-17.
 */
public class User {

    private String name, gender, hobby;
    private double weight, height;
    private int age;
    private Object dailyGoals, lifeGoals, address;

    public void User(){
        name = null;
        gender =null;
        hobby = null;
        weight = 0;
        height  = 0;
        age = 0;
        dailyGoals = null;
        lifeGoals = null;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Object getDailyGoals() {
        return dailyGoals;
    }

    public void setDailyGoals(Object dailyGoals) {
        this.dailyGoals = dailyGoals;
    }

    public Object getLifeGoals() {
        return lifeGoals;
    }

    public void setLifeGoals(Object lifeGoals) {
        this.lifeGoals = lifeGoals;
    }

    public Object getAddress() {
        return address;
    }

    public void setAddress(Object address) {
        this.address = address;
    }
}
