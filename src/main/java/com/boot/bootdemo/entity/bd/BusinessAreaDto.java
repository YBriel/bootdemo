package com.boot.bootdemo.entity.bd;

import lombok.Data;

/**
 * author: yuzq
 * create: 2021-03-22 11:22
 **/
@Data
public class BusinessAreaDto {
    private String name;
    private String address;
    private Location location;
    private String province;
    private String city;
    private String area;
    private String street_id;
    private String telephone;

    public static class Location{
        private Double lat;
        private Double lng;

        public Location() {
        }

        public Location(Double lat, Double lng) {
            this.lat = lat;
            this.lng = lng;
        }

        public Double getLat() {
            return lat;
        }

        public void setLat(Double lat) {
            this.lat = lat;
        }

        public Double getLng() {
            return lng;
        }

        public void setLng(Double lng) {
            this.lng = lng;
        }
    }
}
