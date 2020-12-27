package cz.cvut.fit.matousi1.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;


import java.sql.Timestamp;

public class studioCreateDTO {

    @JsonProperty("name")
    private final String name;
    @JsonProperty("founding_date")
    private final Timestamp founding_date;
    @JsonProperty("Location_id")
    private final int Location_id;

    @JsonCreator
    public studioCreateDTO(String name, Timestamp founding_date, int location_id) {
        this.name = name;
        this.founding_date = founding_date;
        this.Location_id = location_id;
    }

    public String getName() {
        return name;
    }

    public Timestamp getFounding_date() {
        return founding_date;
    }

    public int getLocation_id() { return Location_id; }
}
