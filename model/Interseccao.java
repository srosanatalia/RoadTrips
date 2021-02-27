/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.uefs.ecomp.RoadTrips.model;

import java.io.Serializable;

/**
 *
 * @author Natalia Rosa & Adriel Brito.
 */
public class Interseccao extends Ponto implements Serializable { 
    private String nome;

    public Interseccao(int latitude, int longitude, String tipo ) {
        super(latitude, longitude);
        this.nome = tipo;
    }

    public String getNome() {
        return nome;
    }
}
