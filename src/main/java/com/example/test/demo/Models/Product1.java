package com.example.test.demo.Models;

import jakarta.persistence.*;

import java.util.Calendar;
import java.util.Objects;

@Entity
@Table(name="tblproduct3  ")
public class Product1 {
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
    //--------------------------------------------
    private Long productID ;
    @Column(nullable = false,unique = true,length=300)
    private String name ;
    private  String    status;
    private int quantity ;
    private Long CateID ;
    private Long SupplierID ;


    //---------------------------------------------

    public Product1() {
        // Khởi tạo một sản phẩm mặc định
    }






    //----------------------------------------------


    public Product1(Long productID, String name, String status, int quantity, Long cateID, Long supplierID) {
        this.productID = productID;
        this.name = name;
        this.status = status;
        this.quantity = quantity;
        CateID = cateID;
        SupplierID = supplierID;
    }

    public Long getProductID() {
        return productID;
    }

    public void setProductID(Long productID) {
        this.productID = productID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Long getCateID() {
        return CateID;
    }

    public void setCateID(Long cateID) {
        CateID = cateID;
    }

    public Long getSupplierID() {
        return SupplierID;
    }

    public void setSupplierID(Long supplierID) {
        SupplierID = supplierID;
    }

    //-----------------------------------------------


    @Override
    public String toString() {
        return "Product1{" +
                "productID=" + productID +
                ", name='" + name + '\'' +
                ", status='" + status + '\'' +
                ", quantity=" + quantity +
                ", CateID=" + CateID +
                ", SupplierID=" + SupplierID +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product1 product1 = (Product1) o;
        return quantity == product1.quantity && Objects.equals(productID, product1.productID) && Objects.equals(name, product1.name) && Objects.equals(status, product1.status) && Objects.equals(CateID, product1.CateID) && Objects.equals(SupplierID, product1.SupplierID);
    }


}
