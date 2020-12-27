package cz.cvut.fit.matousi1.dto;

import java.sql.Timestamp;


public class softwareDTO {

    private final int id;
    private final String software_name;
    private final Timestamp founded_in;

    public softwareDTO(int id, String software_name, Timestamp founded_in) {
        this.id = id;
        this.software_name = software_name;
        this.founded_in = founded_in;
    }

    public Timestamp getFounded_in() {
        return founded_in;
    }

    public String getSoftware_name() {
        return software_name;
    }

    public int getId() {
        return id;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        softwareDTO that = (softwareDTO) obj;
        return id == that.id;
    }
}
