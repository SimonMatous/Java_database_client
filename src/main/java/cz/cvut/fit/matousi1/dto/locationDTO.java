package cz.cvut.fit.matousi1.dto;




public class locationDTO {

    private final int id;
    private final String state;
    private final String town;
    private final String address;

    public locationDTO(int id, String state, String town, String address) {
        this.id = id;
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

    public String getTown() {
        return town;
    }

    public String getAddress() {
        return address;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        locationDTO that = (locationDTO) obj;
        return id == that.id;
    }
}
