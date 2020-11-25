package ua.lviv.iot.passive.model.entity;

public class Airport {
    private Integer id;
    private String name;
    private Integer amountOfWorkers;
    private String city;

    public Airport(Integer id, String name, Integer amountOfWorkers, String city) {
        this.id = id;
        this.name = name;
        this.amountOfWorkers = amountOfWorkers;
        this.city = city;
    }

    public Airport(String name, Integer amountOfWorkers, String city) {
        this(null, name, amountOfWorkers, city);
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

    public Integer getAmountOfWorkers() {
        return amountOfWorkers;
    }

    public void setAmountOfWorkers(Integer amountOfWorkers) {
        this.amountOfWorkers = amountOfWorkers;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "Airport{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", amountOfWorkers=" + amountOfWorkers +
                ", city='" + city + '\'' +
                '}';
    }
}
