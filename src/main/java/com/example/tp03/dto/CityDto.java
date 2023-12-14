package com.example.tp03.dto;

import java.io.Serializable;
import java.util.Objects;

/**
 * DTO for {@link com.example.tp03.entities.City}
 */
public class CityDto implements Serializable {
    private final Integer id;
    private final String name;
    private final String countryCodeCode;
    private final String district;

    public CityDto(Integer id, String name, String countryCodeCode, String district) {
        this.id = id;
        this.name = name;
        this.countryCodeCode = countryCodeCode;
        this.district = district;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCountryCodeCode() {
        return countryCodeCode;
    }

    public String getDistrict() {
        return district;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CityDto entity = (CityDto) o;
        return Objects.equals(this.id, entity.id) &&
                Objects.equals(this.name, entity.name) &&
                Objects.equals(this.countryCodeCode, entity.countryCodeCode) &&
                Objects.equals(this.district, entity.district);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, countryCodeCode, district);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "name = " + name + ", " +
                "countryCodeCode = " + countryCodeCode + ", " +
                "district = " + district + ")";
    }
}