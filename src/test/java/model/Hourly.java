package model;

import io.cucumber.core.internal.com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class Hourly {
    private long dt;
    private int temp;
    @JsonProperty("feels_like")
    private int feelsLike;

    private short pressure;
    private short humidity;
    @JsonProperty("dew_point")
    private int dewPoint;

    private int uvi;
    private int clouds;
    private int visibility;
    @JsonProperty("wind_speed")
    private short windSpeed;

    @JsonProperty("wind_deg")
    private int windDeg;

    @JsonProperty("wind_gust")
    private int windGust;

    @JsonProperty("weather")
    private List<Weather> weathers;

    private double pop;

    public long getDt() {
        return dt;
    }

    public void setDt(long dt) {
        this.dt = dt;
    }

    public int getTemp() {
        return temp;
    }

    public void setTemp(int temp) {
        this.temp = temp;
    }

    public int getFeelsLike() {
        return feelsLike;
    }

    public void setFeelsLike(int feelsLike) {
        this.feelsLike = feelsLike;
    }

    public short getPressure() {
        return pressure;
    }

    public void setPressure(short pressure) {
        this.pressure = pressure;
    }

    public short getHumidity() {
        return humidity;
    }

    public void setHumidity(short humidity) {
        this.humidity = humidity;
    }

    public int getDewPoint() {
        return dewPoint;
    }

    public void setDewPoint(int dewPoint) {
        this.dewPoint = dewPoint;
    }

    public int getUvi() {
        return uvi;
    }

    public void setUvi(int uvi) {
        this.uvi = uvi;
    }

    public int getClouds() {
        return clouds;
    }

    public void setClouds(int clouds) {
        this.clouds = clouds;
    }

    public int getVisibility() {
        return visibility;
    }

    public void setVisibility(int visibility) {
        this.visibility = visibility;
    }

    public short getWindSpeed() {
        return windSpeed;
    }

    public void setWindSpeed(short windSpeed) {
        this.windSpeed = windSpeed;
    }

    public int getWindDeg() {
        return windDeg;
    }

    public void setWindDeg(int windDeg) {
        this.windDeg = windDeg;
    }

    public int getWindGust() {
        return windGust;
    }

    public void setWindGust(int windGust) {
        this.windGust = windGust;
    }

    public List<Weather> getWeathers() {
        return weathers;
    }

    public void setWeathers(List<Weather> weathers) {
        this.weathers = weathers;
    }

    public double getPop() {
        return pop;
    }

    public void setPop(double pop) {
        this.pop = pop;
    }
}
