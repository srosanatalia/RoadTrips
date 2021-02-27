/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.uefs.ecomp.RoadTrips.model;

import java.io.Serializable;
import java.util.Iterator;
import java.util.LinkedList;

/**
 *
 * @author Natalia Rosa & Adriel Brito.
 */
public class Cidade extends Ponto implements Serializable { 
    private String nome;
    private final int codigo;
    private double area;
    private double populacao;
    private String descricao;
    private LinkedList locaisComer;

    public Cidade(int latitude, int longitude, int codigo, String nome, double area, double populacao, String descricao) {
        super(latitude, longitude);
        this.codigo = codigo;
        this.nome = nome;
        this.area = area;
        this.populacao = populacao;
        this.descricao = descricao;
        locaisComer = new LinkedList();
    }

    public Cidade (int codigo, int latitude, int longitude){
        super(latitude, longitude);
        this.codigo = codigo;
    }
    
    public int getCodigo() {
        return codigo;
    }
    
    public void inserirLocalComer(LocaisParaComer local){
        locaisComer.add(local);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public double getPopulacao() {
        return populacao;
    }

    public void setPopulacao(double populacao) {
        this.populacao = populacao;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
    public Iterator locaisParaComer(){
        return locaisComer.iterator();
    }
    
    @Override
    public boolean equals(Object o){
        if(o instanceof Cidade){
            Cidade c = (Cidade)o;
            return c.codigo == this.codigo;
        }
        return false;
    }
}
