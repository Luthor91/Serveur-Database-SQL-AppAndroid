package com.example.shopOnline.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

@Entity
@Table(name = "products")

public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id", nullable = false)
    private Long id; // Changer le type de la clé primaire en Long

    @Column(name = "product_name", nullable = false, length = 200)
    private String productName;

    @Lob
    @Column(name = "product_description", nullable = false)
    private String productDescription;

    @Column(name = "dossier", nullable = false, length = 200)
    private String dossier;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "category_id", nullable = false)
    @JsonIgnoreProperties(ignoreUnknown = true,
            value = {"id"})
    private Category category;

    @Column(name = "in_stock", nullable = false)
    private Integer inStock;

    @Column(name = "price", nullable = false)
    private Double price;

    @Column(name = "brand", nullable = false, length = 200)
    private String brand;

    @Column(name = "nbr_image")
    private Integer nbrImage;

    @Column(name = "date_added")
    private String dateAdded;

    public Product() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {  this.id = id;  }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public String getDossier() {
        return dossier;
    }

    public void setDossier(String dossier) {
        this.dossier = dossier;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Integer getInStock() {
        return inStock;
    }

    public void setInStock(Integer inStock) {
        this.inStock = inStock;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Integer getNbrImage() {
        return nbrImage;
    }

    public void setNbrImage(Integer nbrImage) {
        this.nbrImage = nbrImage;
    }

    public String getDateAdded() {
        return dateAdded;
    }

    public void setDateAdded(String dateAdded) {
        this.dateAdded = dateAdded;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productName='" + productName + '\'' +
                ", inStock=" + inStock +
                ", price=" + price +
                ", Category="+category.getTitle()+
                '}';
    }
}