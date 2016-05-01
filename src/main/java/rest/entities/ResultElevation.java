/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 *
 * @author Sander_2
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ResultElevation {
    private double elevation;

    public double getElevation() {
        return elevation;
    }

    public void setElevation(double elevation) {
        this.elevation = elevation;
    }
}
