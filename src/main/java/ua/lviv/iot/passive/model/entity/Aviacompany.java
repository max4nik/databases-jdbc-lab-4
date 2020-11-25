package ua.lviv.iot.passive.model.entity;

public class Aviacompany {
    private Integer id;
    private String name;
    private String creationDate;

    public Aviacompany(Integer id, String name, String creationDate) {
        this.id = id;
        this.name = name;
        this.creationDate = creationDate;
    }


    public Aviacompany(String name, String creationDate) {
        this(null, name, creationDate);
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

    public String getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(String creationDate) {
        this.creationDate = creationDate;
    }

    @Override
    public String toString() {
        return "Aviacompany{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", creationDate='" + creationDate + '\'' +
                '}';
    }
}
