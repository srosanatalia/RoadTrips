/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.uefs.ecomp.RoadTrips.model;

import br.uefs.ecomp.RoadTrips.model.Ponto;
import br.uefs.ecomp.RoadTrips.util.Edge;
import java.io.Serializable;

/**
 *
 * @author Natalia Rosa & Adriel Brito.
 */
public class Estrada extends Edge implements Serializable { 

    private String nome;
    
    public Estrada(Ponto pontoA, Ponto pontoB, double distancia, String nome) {
        super(pontoA, pontoB, distancia);
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    @Override
    public boolean equals(Object o){
        return super.equals(o);
    }
}
