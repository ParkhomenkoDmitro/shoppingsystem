/**
 * This file was generated by the Jeddict
 */
package com.parkhomenko.common;

import javax.persistence.Basic;
import javax.persistence.Embeddable;

/**
 * @author dmytro
 */
@Embeddable
public class GeoCoordinate {

    @Basic
    private long lat;

    @Basic
    private long lng;

    public long getLat() {
        return this.lat;
    }

    public void setLat(long lat) {
        this.lat = lat;
    }

    public long getLng() {
        return this.lng;
    }

    public void setLng(long lng) {
        this.lng = lng;
    }

}