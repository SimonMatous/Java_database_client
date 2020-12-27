package cz.cvut.fit.matousi1.entities;


import com.sun.istack.NotNull;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.sql.Timestamp;
import java.util.List;
import javax.persistence.*;

@Entity

public class game {

    @Id
    @SequenceGenerator(name="SequenceFive",initialValue = 1, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SequenceFive")
    private int id;

    @NotNull
    private String name;

    @NotNull
    private String hardware;

    @NotNull
    private Timestamp release_date;


    @ManyToOne
    @JoinColumn( name = "studio_id")
    private studio Studio;

    @ManyToMany
    @JoinTable(
            name = "game_software",
            joinColumns = @JoinColumn(name = "game_id"),
            inverseJoinColumns = @JoinColumn ( name = "software_id")
    )
    private List<software> softwares;

    public game() {
    }

    public game(String name, String hardware, Timestamp release_date, studio studio, List<software> softwares) {
        this.name = name;
        this.hardware = hardware;
        this.release_date = release_date;
        this.Studio = studio;
        this.softwares = softwares;
    }

    public Timestamp getRelease_date() {
        return release_date;
    }

    public void setRelease_date(Timestamp release_date) {
        this.release_date = release_date;
    }

    public String getName() {
        return name;
    }

    public String getHardware() {
        return hardware;
    }

    public List<software> getSoftwares() {
        return softwares;
    }

    public void setSoftwares(List<software> softwares) {
        this.softwares = softwares;
    }

    public void setHardware(String hardware) {
        this.hardware = hardware;
    }

    public void setName(String nazev) {
        this.name = nazev;
    }

    public int getId() {
        return id;
    }

    public studio getStudio() {
        return Studio;
    }

    public void setStudio(studio studio) {
        Studio = studio;
    }
}
