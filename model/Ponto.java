/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.uefs.ecomp.RoadTrips.model;

/**
 *
 * @author Natalia Rosa & Adriel Brito.
 */
public abstract class Ponto { 
    private final int latitude;
    private final int longitude;

    public Ponto(int latitude, int longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public int getLatitude() {
        return latitude;
    }

    public int getLongitude() {
        return longitude;
    }
    
}