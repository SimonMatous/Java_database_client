package cz.cvut.fit.matousi1.dto;


import cz.cvut.fit.matousi1.entities.game;
import java.sql.Timestamp;

public class savefileDTO {

    private final int id;
    private final String name;
    private final Timestamp saved_at;
    private final int percOfGameFinished;
    private final int game_id;

    public savefileDTO(int id, String name, Timestamp saved_at, int percOfGameFinished, int game_id) {
        this.id = id;
        this.name = name;
        this.saved_at = saved_at;
        this.percOfGameFinished = percOfGameFinished;
        this.game_id = game_id;
    }

    public int getId() {
        return id;
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
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        savefileDTO that = (savefileDTO) obj;
        return id == that.id;
    }
}
