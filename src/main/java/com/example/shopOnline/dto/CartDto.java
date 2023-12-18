package com.example.shopOnline.dto;

import java.io.Serializable;
import java.util.Objects;

/**
 * DTO for {@link com.example.shopOnline.entities.Cart}
 */
public class CartDto implements Serializable {
    private final Integer id;
    private final Integer idUserId;
    private final Integer idProductId;
    private final Integer qts;
    private final Byte payed;
    private final Byte confirmed;

    public CartDto(Integer id, Integer idUserId, Integer idProductId, Integer qts, Byte payed, Byte confirmed) {
        this.id = id;
        this.idUserId = idUserId;
        this.idProductId = idProductId;
        this.qts = qts;
        this.payed = payed;
        this.confirmed = confirmed;
    }

    public Integer getId() {
        return id;
    }

    public Integer getIdUserId() {
        return idUserId;
    }

    public Integer getIdProductId() {
        return idProductId;
    }

    public Integer getQts() {
        return qts;
    }

    public Byte getPayed() {
        return payed;
    }

    public Byte getConfirmed() {
        return confirmed;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CartDto entity = (CartDto) o;
        return Objects.equals(this.id, entity.id) &&
                Objects.equals(this.idUserId, entity.idUserId) &&
                Objects.equals(this.idProductId, entity.idProductId) &&
                Objects.equals(this.qts, entity.qts) &&
                Objects.equals(this.payed, entity.payed) &&
                Objects.equals(this.confirmed, entity.confirmed);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, idUserId, idProductId, qts, payed, confirmed);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "idUserId = " + idUserId + ", " +
                "idProductId = " + idProductId + ", " +
                "qts = " + qts + ", " +
                "payed = " + payed + ", " +
                "confirmed = " + confirmed + ")";
    }
}