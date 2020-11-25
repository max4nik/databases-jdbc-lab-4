package ua.lviv.iot.passive.model.entity;

public class Pilot {
    private Integer id;
    private String surName;
    private String name;
    private String position;

    public Pilot(Integer id, String surName, String name, String position) {
        this.id = id;
        this.name = name;
        this.surName = surName;
        this.position = position;
    }

    public Pilot(String surName, String name, String position) {
        this(null, name, surName, position);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }


    @Override
    public String toString() {
        return "Pilot{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surName='" + surName + '\'' +
                ", positionId=" + position +
                '}';
    }


}
