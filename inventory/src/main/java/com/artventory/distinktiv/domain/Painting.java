package com.artventory.distinktiv.domain;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * Created by distinktiv on 2016-12-29.
 */

@Entity
public class Painting {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private Long artistId;

    //productNumber: get last product Number of the year than increment from 1

    //year
    @Column
    private String title;

    @Column
    private String Description;

    @Column
    private String category;

    @Column
    private String medium;

    @Column
    private String technique;

    @Column
    private String dimensionInch;

    @Column
    private String dimensionCm;

    @Column
    private String availability;

    @Column
    private BigDecimal price;

    @Column
    private String file;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getArtistId() {
        return artistId;
    }

    public void setArtistId(Long artistId) {
        this.artistId = artistId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getMedium() {
        return medium;
    }

    public void setMedium(String medium) {
        this.medium = medium;
    }

    public String getTechnique() {
        return technique;
    }

    public void setTechnique(String technique) {
        this.technique = technique;
    }

    public String getDimensionInch() {
        return dimensionInch;
    }

    public void setDimensionInch(String dimensionInch) {
        this.dimensionInch = dimensionInch;
    }

    public String getDimensionCm() {
        return dimensionCm;
    }

    public void setDimensionCm(String dimensionCm) {
        this.dimensionCm = dimensionCm;
    }

    public String getAvailability() {
        return availability;
    }

    public void setAvailability(String availability) {
        this.availability = availability;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file;
    }
}
