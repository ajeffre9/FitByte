package ca.uwo.csd.cs2212.team04;

/**
 * This is the User class
 * @author cs2212_w2016_team04
 */
public class User {

    private String name, gender, hobby;
    private double weight, height;
    private int age;
    private Object dailyGoals, lifeGoals, address;

    public User(){
        name = null;
        gender =null;
        hobby = null;
        weight = 0;
        height  = 0;
        age = 0;
        dailyGoals = null;
        lifeGoals = null;
    }

    /**
     * return the users name
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     * Setting the Users name using the name that has been passed
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Getting the Users Gender
     * @return gender
     */
    public String getGender() {
        return gender;
    }

    /**
     * Setting the Users gender
     * @param gender
     */
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
