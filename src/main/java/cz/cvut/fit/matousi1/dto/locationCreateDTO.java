package cz.cvut.fit.matousi1.dto;


import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class locationCreateDTO {
    @JsonProperty("state")
    private final String state;
    @JsonProperty("town")
    private final String town;
    @JsonProperty("address")
    private final String address;


    @JsonCreator
    public locationCreateDTO(String state, String town, String address) {
        this.state = state;
        this.town = town;
        this.address = address;
    }

    public String getState() {
        return state;
    }

    public String getTown() {
        return town;
    }

    public String getAddress() {
        return address;
    }
}
