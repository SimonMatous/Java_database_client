package cz.cvut.fit.matousi1.entities;

import com.sun.istack.NotNull;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
public class studio {
    @Id
    @SequenceGenerator(name="SequenceOne",initialValue = 1, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SequenceOne")
    private int id;

    @NotNull
    private String name;

    private Timestamp founding_date;

    @ManyToOne
    @JoinColumn( name = "location_id")
    private location Location;

    public studio() {}

    public studio(String name, Timestamp founding_date, location location) {
        this.name = name;
        this.founding_date = founding_date;
        Location = location;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Timestamp getFounding_date() {
        return founding_date;
    }

    public void setFounding_date(Timestamp founding_date) { this.founding_date = founding_date; }

    public location getLocation() {
        return Location;
    }

    public void setLocation(location location) {
        Location = location;
    }
}
