package com.scottkvitberg.weatherapp;
// Created on 11/11/2016 by kitsco12.


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class CurrentWeatherFromForecastIo {
    private String mIcon;
    private Long mTime;
    private double mTemp;
    private double mhumidity;
    private double mPercipChance;
    private String mSummary;
    private String mTimeZone;

    public String getIcon() {
        return mIcon;
    }

    public void setIcon(String icon) {
        mIcon = icon;
    }
    public int getIconID(){
        // TODO: Make factory pattern
        return 0;
    }

    public String getTimeZone() {
        return mTimeZone;
    }

    public void setTimeZone(String timeZone) {
        mTimeZone = timeZone;
    }

    public Long getTime() {

        return mTime;
    }

    public void setTime(Long time) {
        mTime = time;
    }
    public String getFormatedTime(){
        SimpleDateFormat format = new SimpleDateFormat("H:mm");
        format.setTimeZone(TimeZone.getTimeZone(getTimeZone()));

        //Since getTime returns milliseconds and not seconds
        Date date = new Date(getTime() * 1000);
        String timeString = format.format(date);
        return timeString;
    }

    public double getTemp() {
        return mTemp;
    }

    public void setTemp(double temp) {
        mTemp = temp;
    }

    public double getHumidity() {
        return mhumidity;
    }

    public void setHumidity(double mhumidity) {
        this.mhumidity = mhumidity;
    }

    public double getPercipChance() {
        return mPercipChance;
    }

    public void setPercipChance(double percipChance) {
        mPercipChance = percipChance;
    }

    public String getSummary() {
        return mSummary;
    }

    public void setSummary(String summary) {
        mSummary = summary;
    }
}
