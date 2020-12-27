package cz.cvut.fit.matousi1.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.sql.Timestamp;


public class softwareCreateDTO {

    @JsonProperty("software_name")
    private final String software_name;
    @JsonProperty("founded_in")
    private final Timestamp founded_in;

    @JsonCreator
    public softwareCreateDTO( String software_name, Timestamp founded_in) {

        this.software_name = software_name;
        this.founded_in = founded_in;
    }

    public Timestamp getFounded_in() {
        return founded_in;
    }

    public String getSoftware_name() {
        return software_name;
    }

}
