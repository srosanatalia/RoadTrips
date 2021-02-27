/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.uefs.ecomp.RoadTrips.model;

/**
 *
 * @author adrie
 */
public class Usuario {
    private String nome;
    private String login;
    
    public Usuario(String nome, String login){
        this.nome = nome;
        this.login = login;
    }

    public String getNome() {
        return nome;
    }

    public String getLogin() {
        return login;
    }
}
