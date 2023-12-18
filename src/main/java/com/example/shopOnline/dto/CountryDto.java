package com.example.shopOnline.dto;

import java.io.Serializable;
import java.util.Objects;

/**
 * DTO for {@link com.example.shopOnline.entities.Country}
 */
public class CountryDto implements Serializable {
    private final String id;
    private final String name;
    private final String continent;
    private final String region;
    private final String localName;
    private final String capital;
    private final String code2;

    public CountryDto(String id, String name, String continent, String region, String localName, String capital, String code2) {
        this.id = id;
        this.name = name;
        this.continent = continent;
        this.region = region;
        this.localName = localName;
        this.capital = capital;
        this.code2 = code2;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getContinent() {
        return continent;
    }

    public String getRegion() {
        return region;
    }

    public String getLocalName() {
        return localName;
    }

    public String getCapital() {
        return capital;
    }

    public String getCode2() {
        return code2;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CountryDto)) return false;
        CountryDto that = (CountryDto) o;
        return Objects.equals(getId(), that.getId()) && Objects.equals(getName(), that.getName()) && Objects.equals(getContinent(), that.getContinent()) && Objects.equals(getRegion(), that.getRegion()) && Objects.equals(getLocalName(), that.getLocalName()) && Objects.equals(getCapital(), that.getCapital()) && Objects.equals(getCode2(), that.getCode2());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getContinent(), getRegion(), getLocalName(), getCapital(), getCode2());
    }

    @Override
    public String toString() {
        return "CountryDto{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", continent='" + continent + '\'' +
                ", region='" + region + '\'' +
                ", localName='" + localName + '\'' +
                ", capital='" + capital + '\'' +
                ", code2='" + code2 + '\'' +
                '}';
    }
}