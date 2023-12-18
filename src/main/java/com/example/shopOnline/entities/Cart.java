package com.example.shopOnline.entities;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name = "cart")
public class Cart {
    @Id
    @Column(name = "id_cart", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "id_user", nullable = false)
    @JsonIdentityInfo(
            generator = ObjectIdGenerators.PropertyGenerator.class,
            property = "user_id")
    private User idUser;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "id_product", nullable = false)
    @JsonIdentityInfo(
            generator = ObjectIdGenerators.PropertyGenerator.class,
            property = "id")
    private Product idProduct;

    @Column(name = "qts", nullable = false)
    private Integer qts;

    @Column(name = "payed", nullable = false)
    private Byte payed;

    @Column(name = "confirmed", nullable = false)
    private Byte confirmed;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public User getIdUser() {
        return idUser;
    }

    public void setIdUser(User idUser) {
        this.idUser = idUser;
    }

    public Product getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(Product idProduct) {
        this.idProduct = idProduct;
    }

    public Integer getQts() {
        return qts;
    }

    public void setQts(Integer qts) {
        this.qts = qts;
    }

    public Byte getPayed() {
        return payed;
    }

    public void setPayed(Byte payed) {
        this.payed = payed;
    }

    public Byte getConfirmed() {
        return confirmed;
    }

    public void setConfirmed(Byte confirmed) {
        this.confirmed = confirmed;
    }

}