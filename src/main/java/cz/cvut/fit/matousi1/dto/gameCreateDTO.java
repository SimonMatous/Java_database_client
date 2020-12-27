package cz.cvut.fit.matousi1.dto;


import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.sql.Timestamp;
import java.util.List;

public class gameCreateDTO {
    @JsonProperty("name")
    private final String name;
    @JsonProperty("hardware")
    private final String hardware;
    @JsonProperty("release_date")
    private final Timestamp release_date;
    @JsonProperty("software_ids")
    private final List<Integer> software_ids;
    @JsonProperty("studio_id")
    private int studio_id;


    @JsonCreator
    public gameCreateDTO(String name, String hardware, Timestamp release_date, List<Integer> software_ids, int studio_id) {
        this.name = name;
        this.hardware = hardware;
        this.release_date = release_date;
        this.software_ids = software_ids;
        this.studio_id = studio_id;
    }

    public Timestamp getRelease_date() {
        return release_date;
    }

    public String getName() {
        return name;
    }

    public String getHardware() {
        return hardware;
    }

    public List<Integer> getSoftware_ids() { return software_ids; }

    public int getStudio_id() { return studio_id; }
}
