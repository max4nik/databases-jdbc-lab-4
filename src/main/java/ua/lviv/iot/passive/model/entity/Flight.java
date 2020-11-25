package ua.lviv.iot.passive.model.entity;

public class Flight {
    private Integer id;
    private Integer fromAirport;
    private Integer toAirport;
    private String departureTime;
    private String arrivalTime;
    private Integer pilotId;
    private Integer aircraftId;
    private Boolean isAvailable;
    private Integer aviacompanyId;
    private Integer availableSeats;

    public Flight(Integer id, Integer fromAirport, Integer toAirport, String departureTime, String arrivalTime, Integer pilotId, Integer aircraftId, Boolean isAvailable, Integer aviacompanyId, Integer availableSeats) {
        this.id = id;
        this.fromAirport = fromAirport;
        this.toAirport = toAirport;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
        this.pilotId = pilotId;
        this.aircraftId = aircraftId;
        this.isAvailable = isAvailable;
        this.aviacompanyId = aviacompanyId;
        this.availableSeats = availableSeats;
    }

    public Flight(Integer fromAirport, Integer toAirport, String departureTime, String arrivalTime, Integer pilotId, Integer aircraftId, Boolean isAvailable, Integer aviacompanyId, Integer availableSeats) {
        this(null, fromAirport, toAirport, departureTime, arrivalTime, pilotId, aircraftId, isAvailable, aviacompanyId, availableSeats);
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getFromAirport() {
        return fromAirport;
    }

    public void setFromAirport(Integer fromAirport) {
        this.fromAirport = fromAirport;
    }

    public Integer getToAirport() {
        return toAirport;
    }

    public void setToAirport(Integer toAirport) {
        this.toAirport = toAirport;
    }

    public String getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(String departureTime) {
        this.departureTime = departureTime;
    }

    public String getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(String arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public Integer getPilotId() {
        return pilotId;
    }

    public void setPilotId(Integer pilotId) {
        this.pilotId = pilotId;
    }

    public Integer getAircraftId() {
        return aircraftId;
    }

    public void setAircraftId(Integer aircraftId) {
        this.aircraftId = aircraftId;
    }

    public Boolean getAvailable() {
        return isAvailable;
    }

    public void setAvailable(Boolean available) {
        isAvailable = available;
    }

    public Integer getAviacompanyId() {
        return aviacompanyId;
    }

    public void setAviacompanyId(Integer aviacompanyId) {
        this.aviacompanyId = aviacompanyId;
    }

    public Integer getAvailableSeats() {
        return availableSeats;
    }

    public void setAvailableSeats(Integer availableSeats) {
        this.availableSeats = availableSeats;
    }


    @Override
    public String toString() {
        return "Flight{" +
                "id=" + id +
                ", fromAirport=" + fromAirport +
                ", toAirport=" + toAirport +
                ", departureTime='" + departureTime + '\'' +
                ", arrivalTime='" + arrivalTime + '\'' +
                ", pilotId=" + pilotId +
                ", aircraftId=" + aircraftId +
                ", isAvailable=" + isAvailable +
                ", aviacompanyId=" + aviacompanyId +
                ", availableSeats=" + availableSeats +
                '}';
    }


}
