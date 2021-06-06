package com.example.coursework.forms;

public class FreightCarForm {
    private String id;
    private String name;
    private String bodyType;
    private double weight;
    private String liftingCapacity;
    private int maximumSpeed;

    public FreightCarForm() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBodyType() {
        return bodyType;
    }

    public void setBodyType(String bodyType) {
        this.bodyType = bodyType;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public String getLiftingCapacity() {
        return liftingCapacity;
    }

    public void setLiftingCapacity(String liftingCapacity) {
        this.liftingCapacity = liftingCapacity;
    }

    public int getMaximumSpeed() {
        return maximumSpeed;
    }

    public void setMaximumSpeed(int maximumSpeed) {
        this.maximumSpeed = maximumSpeed;
    }

    @Override
    public String toString() {
        return "FreightCarForm{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", bodyType='" + bodyType + '\'' +
                ", weight=" + weight +
                ", liftingCapacity='" + liftingCapacity + '\'' +
                ", maximumSpeed=" + maximumSpeed +
                '}';
    }
}
