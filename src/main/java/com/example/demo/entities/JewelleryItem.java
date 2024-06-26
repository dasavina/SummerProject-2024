package com.example.demo.entities;

import jakarta.persistence.*;

@Entity
@Table(name= "jewelleryItems")
public class JewelleryItem {

    @Id
    @GeneratedValue(strategy = GenerationType. IDENTITY)
    private int id;
    @Column(name = "name", nullable = false)
    private String name;
    @Column(name = "type")
    private String type;
    @Column(name = "material", nullable = false)
    private String material;
    @Column(name = "cost", nullable = false)
    private double cost;

    public JewelleryItem(int id, String name, String type, String material, double cost) {
        super();
        this.id = id;
        this.name = name;
        this.type = type;
        this.material = material;
        this.cost = cost;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getmaterial() {
        return material;
    }

    public void setmaterial(String material) {
        material = material;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }
}