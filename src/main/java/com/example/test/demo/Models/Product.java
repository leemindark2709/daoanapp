package com.example.test.demo.Models;

import jakarta.persistence.*;

import java.util.Calendar;
import java.util.Objects;

@Entity
@Table(name="tblproduct2")
public class Product {
    //this is "primary key"
    @Id
    //@GeneratedValue(strategy = GenerationType.AUTO)//Auto_increment
    @SequenceGenerator(
            name="product_sequence",
            sequenceName="product_sequence",
            allocationSize =1
    )
    @GeneratedValue(
            strategy =  GenerationType.SEQUENCE,
            generator = "product_sequence"
    )
    private  Long id ;
    @Column(nullable = false,unique = true,length=300)
    private   String productName ;
     private int nam;
     private Double price;
     private String url;
    public Product() {
        // Khởi tạo một sản phẩm mặc định
    }
    @Transient
    private int age;
    public int getAge(){
        return Calendar.getInstance().get(Calendar.YEAR)-nam;
    }

    public  Product( String productName,Double price , String url, int year){

         this.productName = productName;
         this.url =url ;
         this.price = price;
         this.nam =year ;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getNam() {
        return nam;
    }

    public void setNam(int nam) {
        this.nam = nam;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", productName='" + productName + '\'' +
                ", year=" + nam +
                ", price=" + price +
                ", url='" + url + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return nam == product.nam && age == product.age && Objects.equals(id, product.id) && Objects.equals(productName, product.productName) && Objects.equals(price, product.price) && Objects.equals(url, product.url);
    }


}
