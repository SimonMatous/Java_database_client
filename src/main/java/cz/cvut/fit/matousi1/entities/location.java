package cz.cvut.fit.matousi1.entities;


import com.sun.istack.NotNull;

import javax.persistence.*;

@Entity
public class location {
    @Id
    @SequenceGenerator(name="SequenceFour",initialValue = 1, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SequenceFour")
    private int id;

    @NotNull
    private String state;

    
    private String town;


    private String address;

    public location() {}

    public location(String state, String town, String address) {
        this.state = state;
        this.town = town;
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
