package com.example.tpenca;



//Entity
//Table(name = "prod")
public class Product {
    //Id
    //GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    //Column(name = "name")
    private String name;
    //Column(name = "description")
    private String desc;
    //Column(name = "price")
    private double price;
    //Column(name = "quantity")
    private int quantity;
    //Column(name = "state")
    private String state;
    ////Column(name = "date")
    //private date date;




    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }




    public Product(int id, String name, String desc, double price, int quantity,String state) {
        this.id = id;
        this.name = name;
        this.desc = desc;
        this.price = price;
        this.quantity = quantity;
        this.state = state;

    }

    public Product() {
    }

    public String getDesc() {
        return desc;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }


}