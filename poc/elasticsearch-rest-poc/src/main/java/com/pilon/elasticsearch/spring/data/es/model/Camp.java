package com.pilon.elasticsearch.spring.data.es.model;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.*;

@Document(indexName = "camp", type = "camp")
public class Camp {

    @Id
    private String _id;

    @Field(type = FieldType.Text)
    private String activity;

    @Field(type = FieldType.Text)
    private String description;

    @Field(type = FieldType.Text)
    private String location;

    @Field(type = FieldType.Text)
    private String radius;

    @Field
    private String[] amenities;

    @Field
    private int minAge;

    @Field
    private int maxAge;

    @Field(type = FieldType.Text)
    private String category;

    @Field
    private int cost;

    @Field(type = FieldType.Text)
    private String provider;

    @Field(type = FieldType.Text)
    private String type;

    @Field(type = FieldType.Date, format = DateFormat.custom, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
    public Date activityStartDate;

    @Field(type = FieldType.Date, format = DateFormat.custom, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
    private Date activityEndDate;

    @Field(type = FieldType.Text)
    private String registrationURL;

    @Field(type = FieldType.Date, format = DateFormat.custom, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
    private Date registrationStartDate;

    @Field(type = FieldType.Text)
    private String img;

    public Camp() {
    }

    public String getId() {
        return _id;
    }

    public void setId(String id) {
        this._id = id;
    }

    public String getActivity() {
        return activity;
    }

    public void setActivity(String activity) {
        this.activity = activity;
    }

    public Date getActivityStartDate() {
        return activityStartDate;
    }

    public void setActivityStartDate(Date activityStartDate) {
        this.activityStartDate = activityStartDate;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return the location
     */
    public String getLocation() {
        return location;
    }

    /**
     * @param location the location to set
     */
    public void setLocation(String location) {
        this.location = location;
    }

    /**
     * @return the radius
     */
    public String getRadius() {
        return radius;
    }

    /**
     * @param radius the radius to set
     */
    public void setRadius(String radius) {
        this.radius = radius;
    }

    /**
     * @return the minAge
     */
    public int getMinAge() {
        return minAge;
    }

    /**
     * @param minAge the minAge to set
     */
    public void setMinAge(int minAge) {
        this.minAge = minAge;
    }

    /**
     * @return the maxAge
     */
    public int getMaxAge() {
        return maxAge;
    }

    /**
     * @param maxAge the maxAge to set
     */
    public void setMaxAge(int maxAge) {
        this.maxAge = maxAge;
    }

    /**
     * @return the category
     */
    public String getCategory() {
        return category;
    }

    /**
     * @param category the category to set
     */
    public void setCategory(String category) {
        this.category = category;
    }

    /**
     * @return the cost
     */
    public int getCost() {
        return cost;
    }

    /**
     * @param cost the cost to set
     */
    public void setCost(int cost) {
        this.cost = cost;
    }

    /**
     * @return the provider
     */
    public String getProvider() {
        return provider;
    }

    /**
     * @param provider the provider to set
     */
    public void setProvider(String provider) {
        this.provider = provider;
    }

    /**
     * @return the type
     */
    public String getType() {
        return type;
    }

    /**
     * @param type the type to set
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * @return the activityEndDate
     */
    public Date getActivityEndDate() {
        return activityEndDate;
    }

    /**
     * @param activityEndDate the activityEndDate to set
     */
    public void setActivityEndDate(Date activityEndDate) {
        this.activityEndDate = activityEndDate;
    }

    /**
     * @return the registrationURL
     */
    public String getRegistrationURL() {
        return registrationURL;
    }

    /**
     * @param registrationURL the registrationURL to set
     */
    public void setRegistrationURL(String registrationURL) {
        this.registrationURL = registrationURL;
    }

    /**
     * @return the registrationStartDate
     */
    public Date getRegistrationStartDate() {
        return registrationStartDate;
    }

    /**
     * @param registrationStartDate the registrationStartDate to set
     */
    public void setRegistrationStartDate(Date registrationStartDate) {
        this.registrationStartDate = registrationStartDate;
    }

    /**
     * @return the img
     */
    public String getImg() {
        return img;
    }

    /**
     * @param img the img to set
     */
    public void setImg(String img) {
        this.img = img;
    }

    /**
     * @return the _id
     */
    public String get_id() {
        return _id;
    }

    /**
     * @param _id the _id to set
     */
    public void set_id(String _id) {
        this._id = _id;
    }

    /**
     * @return the amenities
     */
    public String[] getAmenities() {
        return amenities;
    }

    /**
     * @param amenities the amenities to set
     */
    public void setAmenities(String[] amenities) {
        this.amenities = amenities;
    }

}
