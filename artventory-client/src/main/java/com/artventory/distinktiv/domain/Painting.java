package com.artventory.distinktiv.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.File;
import java.math.BigDecimal;

/**
 * Created by distinktiv on 2016-12-29.
 */

public class Painting {

    private Long id;
    private Long artistId;
    private String title;
    private String Description;
    private String category;
    private String medium;
    private String technique;
    private String dimension;
    private Boolean availability;
    private BigDecimal price;
    private int year;
    private long productNumber;

    @JsonIgnore
    private File paintingFile;
    //productNumber: get last product Number of the year than increment from 1


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

    public String getDimension() {
        return dimension;
    }

    public void setDimension(String dimension) {
        this.dimension = dimension;
    }

    public Boolean getAvailability() {
        return availability;
    }

    public void setAvailability(Boolean availability) {
        this.availability = availability;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public long getProductNumber() {
        return productNumber;
    }

    public void setProductNumber(long productNumber) {
        this.productNumber = productNumber;
    }

    public File getPaintingFile() {
        return paintingFile;
    }

    public void setPaintingFile(File paintingFile) {
        this.paintingFile = paintingFile;
    }
}
