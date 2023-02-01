package model;

import io.cucumber.core.internal.com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class Alerts {
    @JsonProperty("sender_name")
    private String senderName;

    private  String event;
    private long start;
    private long end;
    private String description;
    private List<Tags> tags;
}
