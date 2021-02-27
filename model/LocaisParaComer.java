/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.uefs.ecomp.RoadTrips.model;

import java.io.Serializable;

/**
 *
 * @author Natalia Rosa & Adriel Brito
 */
public class LocaisParaComer  implements Serializable {
    private final String nome;
    private final String endereco;
    
    public LocaisParaComer (String nome, String endereco){
        this.nome = nome;
        this.endereco = endereco;
    }
}
