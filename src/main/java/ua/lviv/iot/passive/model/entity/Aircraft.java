package ua.lviv.iot.passive.model.entity;


public class Aircraft {
    private Integer id;
    private String modelName;
    private String type;
    private Integer yearsInUse;
    private Integer maxSeats;
    private Integer aviacompanyId;


    public Aircraft(Integer id, String modelName, String type, Integer yearsInUse, Integer maxSeats, Integer aviacompanyId) {
        this.id = id;
        this.modelName = modelName;
        this.type = type;
        this.yearsInUse = yearsInUse;
        this.maxSeats = maxSeats;
        this.aviacompanyId = aviacompanyId;
    }

    public Aircraft(String modelName, String type, Integer yearsInUse, Integer maxSeats, Integer aviacompanyId) {
        this(null, modelName, type, yearsInUse, maxSeats, aviacompanyId);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getYearsInUse() {
        return yearsInUse;
    }

    public void setYearsInUse(Integer yearsInUse) {
        this.yearsInUse = yearsInUse;
    }

    public Integer getMaxSeats() {
        return maxSeats;
    }

    public void setMaxSeats(Integer maxSeats) {
        this.maxSeats = maxSeats;
    }

    public Integer getAviacompanyId() {
        return aviacompanyId;
    }

    public void setAviacompanyId(Integer aviacompanyId) {
        this.aviacompanyId = aviacompanyId;
    }

    @Override
    public String toString() {
        return "Aircraft{" +
                "id=" + id +
                ", modelName='" + modelName + '\'' +
                ", type='" + type + '\'' +
                ", yearsInUse=" + yearsInUse +
                ", maxSeats=" + maxSeats +
                ", aviacompanyId=" + aviacompanyId +
                '}';
    }
}
