package com.example.shopOnline.entities;

import com.fasterxml.jackson.annotation.*;
import jakarta.persistence.*;

@Entity
@Table(name = "categories")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "title", nullable = false, length = 200)
    private String title;
    @JsonIgnore
    @Column(name = "web_title", nullable = false, length = 200)
    private String webTitle;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "parent")
    @JsonIgnoreProperties(ignoreUnknown = true,
            value = {"id"})
    private Category parent;

    @Column(name = "leval", nullable = false)
    private Integer leval;

    public Category() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getWebTitle() {
        return webTitle;
    }

    public void setWebTitle(String webTitle) {
        this.webTitle = webTitle;
    }
    @JsonIgnore
    public Category getParent() {
        return parent;
    }

    public void setParent(Category parent) {
        this.parent = parent;
    }


    public Integer getLeval() {
        return leval;
    }

    public void setLeval(Integer leval) {
        this.leval = leval;
    }




    @Override
    public String toString() {
        return "Category{" +
                "title='" + title + '\'' +
                ", leval=" + leval +
                '}';
    }
}