package com.example.msrit.ratethefarm;

public class UserData {


     private int UserID;
     private String Name;
     private String Age;
     private String Village;
     private String Crop;
     private String Land;
     private String Animals;
     private String Rating;


    public UserData() {
    }

    public int getUserID() {
        return UserID;
    }

    public String getName() {
        return Name;
    }

    public String getAge() {
        return Age;
    }

    public String getVillage() {
        return Village;
    }

    public String getCrop() {
        return Crop;
    }

    public String getLand() {
        return Land;
    }

    public String getAnimals() {
        return Animals;
    }

    public String getRating() {
        return Rating;
    }

    public void setUserID(int userID) {
        UserID = userID;
    }

    public void setName(String name) {
        Name = name;
    }

    public void setAge(String age) {
        Age = age;
    }

    public void setVillage(String village) {
        Village = village;
    }

    public void setCrop(String crop) {
        Crop = crop;
    }

    public void setLand(String land) {
        Land = land;
    }

    public void setAnimals(String animals) {
        Animals = animals;
    }

    public void setRating(String rating) {
        Rating = rating;
    }
}
