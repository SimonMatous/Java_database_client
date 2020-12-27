package cz.cvut.fit.matousi1.dto;


import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.sql.Timestamp;

public class savefileCreateDTO {

    @JsonProperty("name")
    private final String name;
    @JsonProperty("saved_at")
    private final Timestamp saved_at;
    @JsonProperty("percOfGameFinished")
    private final int percOfGameFinished;
    @JsonProperty("game_id")
    private final int game_id;

    @JsonCreator
    public savefileCreateDTO(String name, Timestamp saved_at, int percOfGameFinished, int game_id) {
        this.name = name;
        this.saved_at = saved_at;
        this.percOfGameFinished = percOfGameFinished;
        this.game_id = game_id;
    }

    public String getName() {
        return name;
    }

    public Timestamp getSaved_at() {
        return saved_at;
    }

    public int getPercOfGameFinished() {
        return percOfGameFinished;
    }

    public int getGame_id() { return game_id; }
}
