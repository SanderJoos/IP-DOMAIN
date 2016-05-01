/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.List;

/**
 *
 * @author Sander_2
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Elevation {
    private List<ResultElevation> results;

    public List<ResultElevation> getResult() {
        return results;
    }

    public void setResults(List<ResultElevation> results) {
        this.results = results;
    }   
}
