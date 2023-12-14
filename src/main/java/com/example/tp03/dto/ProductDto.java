package com.example.tp03.dto;

import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;

/**
 * DTO for {@link com.example.tp03.entities.Product}
 */
public class ProductDto implements Serializable {
    private final Integer id;
    private final String productName;
    private final String productDescription;
    private final String dossier;
    private final Integer category;
    private final Integer inStock;
    private final Double price;
    private final String brand;
    private final Integer nbrImage;
    private final Instant dateAdded;

    public ProductDto(Integer id, String productName, String productDescription, String dossier, Integer category, Integer inStock, Double price, String brand, Integer nbrImage, Instant dateAdded) {
        this.id = id;
        this.productName = productName;
        this.productDescription = productDescription;
        this.dossier = dossier;
        this.category = category;
        this.inStock = inStock;
        this.price = price;
        this.brand = brand;
        this.nbrImage = nbrImage;
        this.dateAdded = dateAdded;
    }

    public Integer getId() {
        return id;
    }

    public String getProductName() {
        return productName;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public String getDossier() {
        return dossier;
    }

    public Integer getCategory() {
        return category;
    }

    public Integer getInStock() {
        return inStock;
    }

    public Double getPrice() {
        return price;
    }

    public String getBrand() {
        return brand;
    }

    public Integer getNbrImage() {
        return nbrImage;
    }

    public Instant getDateAdded() {
        return dateAdded;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductDto entity = (ProductDto) o;
        return Objects.equals(this.id, entity.id) &&
                Objects.equals(this.productName, entity.productName) &&
                Objects.equals(this.productDescription, entity.productDescription) &&
                Objects.equals(this.dossier, entity.dossier) &&
                Objects.equals(this.category, entity.category) &&
                Objects.equals(this.inStock, entity.inStock) &&
                Objects.equals(this.price, entity.price) &&
                Objects.equals(this.brand, entity.brand) &&
                Objects.equals(this.nbrImage, entity.nbrImage) &&
                Objects.equals(this.dateAdded, entity.dateAdded);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, productName, productDescription, dossier, category, inStock, price, brand, nbrImage, dateAdded);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "productName = " + productName + ", " +
                "productDescription = " + productDescription + ", " +
                "dossier = " + dossier + ", " +
                "category = " + category + ", " +
                "inStock = " + inStock + ", " +
                "price = " + price + ", " +
                "brand = " + brand + ", " +
                "nbrImage = " + nbrImage + ", " +
                "dateAdded = " + dateAdded + ")";
    }
}