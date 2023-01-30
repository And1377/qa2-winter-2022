package model;

import io.cucumber.core.internal.com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class WeatherResponse {
    private double lat;
    private double lon;
    private String timezone;

    @JsonProperty("timezone_offset")
    private int timezoneOffset;

    private Current current;

    private List<Minute> minutely;     //https://youtu.be/8iBv7sE83yw?list=PL29imBtAdLy_BbG2n-9mD0ZfZGCACflBB&t=6462
    private List<Hourly> hourly;
    private List<Daily> daily;
}
