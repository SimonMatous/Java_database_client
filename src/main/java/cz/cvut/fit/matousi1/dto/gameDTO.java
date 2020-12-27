package cz.cvut.fit.matousi1.dto;



import java.sql.Timestamp;
import java.util.List;

public class gameDTO {

    private final int id;
    private final String name;
    private final String hardware;
    private final Timestamp release_date;
    private final List<Integer> software_ids;
    private int studio_id;

    public gameDTO(int id, String name, String hardware, Timestamp release_date, List<Integer> software_ids, int studio_id) {
        this.id = id;
        this.name = name;
        this.hardware = hardware;
        this.release_date = release_date;
        this.software_ids = software_ids;
        this.studio_id = studio_id;
    }

    public Timestamp getRelease_date() {
        return release_date;
    }

    public String getName() {
        return name;
    }

    public String getHardware() {
        return hardware;
    }

    public List<Integer> getSoftware_ids() { return software_ids; }

    public int getId() {
        return id;
    }

    public int getStudio_id() { return studio_id; }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        gameDTO that = (gameDTO) obj;
        return id == that.id;
    }
}
