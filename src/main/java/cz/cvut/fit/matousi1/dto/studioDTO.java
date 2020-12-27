package cz.cvut.fit.matousi1.dto;

import cz.cvut.fit.matousi1.entities.location;
import java.sql.Timestamp;

public class studioDTO {

    private final int id;
    private final String name;
    private final Timestamp founding_date;
    private final int Location_id;

    public studioDTO(int id, String name, Timestamp founding_date, int location_id) {
        this.id = id;
        this.name = name;
        this.founding_date = founding_date;
        Location_id = location_id;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Timestamp getFounding_date() {
        return founding_date;
    }

    public int getLocation_id() { return Location_id; }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        studioDTO that = (studioDTO) obj;
        return id == that.id;
    }
}
