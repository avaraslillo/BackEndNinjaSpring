package com.udemy.backendninja.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="country")
public class Country {
    @Id
    @Column(name="Code")
    private String Code;
    @Column(name="Name")
    private String Name;
    @Column(name="Continent")
    private String Continent;
    @Column(name="Region")
    private String Region;
    @Column(name="SurfaceArea")
    private float SurfaceArea;
    @Column(name="IndepYear")
    private int IndepYear;
    @Column(name="Population")
    private int Population;
    @Column(name="LifeExpectancy")
    private float LifeExpectancy;
    @Column(name="GNP")
    private float GNP;
    @Column(name="GNPOld")
    private float GNPOld;
    @Column(name="LocalName")
    private String LocalName;
    @Column(name="GovernmentForm")
    private String GovernmentForm;
    @Column(name="HeadOfState")
    private String HeadOfState;
    @Column(name="Capital")
    private int Capital;
    @Column(name="Code2")
    private String Code2;
    
    public String getCode() {
        return Code;
    }
    public void setCode(String code) {
        Code = code;
    }
    public String getName() {
        return Name;
    }
    public void setName(String name) {
        Name = name;
    }
    public String getContinent() {
        return Continent;
    }
    public void setContinent(String continent) {
        Continent = continent;
    }
    public String getRegion() {
        return Region;
    }
    public void setRegion(String region) {
        Region = region;
    }
    public float getSurfaceArea() {
        return SurfaceArea;
    }
    public void setSurfaceArea(float surfaceArea) {
        SurfaceArea = surfaceArea;
    }
    public int getIndepYear() {
        return IndepYear;
    }
    public void setIndepYear(int indepYear) {
        IndepYear = indepYear;
    }
    public int getPopulation() {
        return Population;
    }
    public void setPopulation(int population) {
        Population = population;
    }
    public float getLifeExpectancy() {
        return LifeExpectancy;
    }
    public void setLifeExpectancy(float lifeExpectancy) {
        LifeExpectancy = lifeExpectancy;
    }
    public float getGNP() {
        return GNP;
    }
    public void setGNP(float gNP) {
        GNP = gNP;
    }
    public float getGNPOld() {
        return GNPOld;
    }
    public void setGNPOld(float gNPOld) {
        GNPOld = gNPOld;
    }
    public String getLocalName() {
        return LocalName;
    }
    public void setLocalName(String localName) {
        LocalName = localName;
    }
    public String getGovernmentForm() {
        return GovernmentForm;
    }
    public void setGovernmentForm(String governmentForm) {
        GovernmentForm = governmentForm;
    }
    public String getHeadOfState() {
        return HeadOfState;
    }
    public void setHeadOfState(String headOfState) {
        HeadOfState = headOfState;
    }
    public int getCapital() {
        return Capital;
    }
    public void setCapital(int capital) {
        Capital = capital;
    }
    public String getCode2() {
        return Code2;
    }
    public void setCode2(String code2) {
        Code2 = code2;
    }

    public Country(){

    }

    public Country(String code, String name, String continent, String region, float surfaceArea, int indepYear,
            int population, float lifeExpectancy, float gNP, float gNPOld, String localName, String governmentForm,
            String headOfState, int capital, String code2) {
        Code = code;
        Name = name;
        Continent = continent;
        Region = region;
        SurfaceArea = surfaceArea;
        IndepYear = indepYear;
        Population = population;
        LifeExpectancy = lifeExpectancy;
        GNP = gNP;
        GNPOld = gNPOld;
        LocalName = localName;
        GovernmentForm = governmentForm;
        HeadOfState = headOfState;
        Capital = capital;
        Code2 = code2;
    }


}
