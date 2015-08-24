package com.job5156.vo.api;

import java.util.List;

public class ResumeSearchFilter {
    private List<SearchFilterDetail> workYearFilter;
    private List<SearchFilterDetail> degreeFilter;
    private List<SearchFilterDetail> genderFilter;
    private List<SearchFilterDetail> salaryFilter;

    public List<SearchFilterDetail> getWorkYearFilter() {
        return workYearFilter;
    }
    public void setWorkYearFilter(List<SearchFilterDetail> workYearFilter) {
        this.workYearFilter = workYearFilter;
    }
    public List<SearchFilterDetail> getDegreeFilter() {
        return degreeFilter;
    }
    public void setDegreeFilter(List<SearchFilterDetail> degreeFilter) {
        this.degreeFilter = degreeFilter;
    }
    public List<SearchFilterDetail> getGenderFilter() {
        return genderFilter;
    }
    public void setGenderFilter(List<SearchFilterDetail> genderFilter) {
        this.genderFilter = genderFilter;
    }

    public List<SearchFilterDetail> getSalaryFilter() {
        return salaryFilter;
    }

    public void setSalaryFilter(List<SearchFilterDetail> salaryFilter) {
        this.salaryFilter = salaryFilter;
    }
}
