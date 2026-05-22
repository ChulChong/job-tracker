package com.ChulChong.jobTracker.api;

import lombok.Getter;
import lombok.Setter;

import java.util.List;


@Getter
@Setter
public class JobDto {
    private String title;
    private String companyName;
    private Integer minSalary;
    private Integer maxSalary;
    private String currency;
    private List<String> locationRestrictions;
    private List<String> categories;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public Integer getMinSalary() {
        return minSalary;
    }

    public void setMinSalary(Integer minSalary) {
        this.minSalary = minSalary;
    }

    public Integer getMaxSalary() {
        return maxSalary;
    }

    public void setMaxSalary(Integer maxSalary) {
        this.maxSalary = maxSalary;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public List<String> getLocationRestrictions() {
        return locationRestrictions;
    }

    public void setLocationRestrictions(List<String> locationRestrictions) {
        this.locationRestrictions = locationRestrictions;
    }

    public List<String> getCategories() {
        return categories;
    }

    public void setCategories(List<String> categories) {
        this.categories = categories;
    }
}
