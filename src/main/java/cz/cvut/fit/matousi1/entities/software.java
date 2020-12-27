package cz.cvut.fit.matousi1.entities;

import com.sun.istack.NotNull;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
public class software {



    @Id
    @SequenceGenerator(name="SequenceTwo",initialValue = 1, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SequenceTwo")
    private int id;

    @NotNull
    private String software_name;

    @NotNull
    private Timestamp founded_in;

    public software() {
    }

    public software(String software_name, Timestamp founded_in) {
        this.software_name = software_name;
        this.founded_in = founded_in;
    }

    public Timestamp getFounded_in() {
        return founded_in;
    }

    public void setFounded_in(Timestamp founded_in) {
        this.founded_in = founded_in;
    }

    public String getSoftware_name() {
        return software_name;
    }

    public int getId() {
        return id;
    }
    public void setSoftware_name(String software_name) {
        this.software_name = software_name;
    }
}
