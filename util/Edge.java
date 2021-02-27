/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.uefs.ecomp.RoadTrips.util;

/**
 *
 * @author adrie
 */
public class Edge implements Comparable{
    private Object source;
    private Object destiny;
    private double weight;
    
    public Edge(Object u, Object v, double data){
        this.source = u;
        this.destiny = v;
        this.weight = data;
    }

    public Object getSource() {
        return source;
    }

    public void setSource(Object source) {
        this.source = source;
    }

    public Object getDestiny() {
        return destiny;
    }

    public void setDestiny(Object destiny) {
        this.destiny = destiny;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }
    
    @Override
    public boolean equals(Object o){
        Edge e = (Edge)o;
        return this.destiny.equals(e.getDestiny()) && this.source.equals(e.getSource()) && this.weight == e.getWeight();
    }
    
    @Override
    public int compareTo(Object o){
        Edge e = (Edge)o;
        if(this.weight > e.getWeight()){
            return 1;
        }
        else if(this.weight < e.getWeight()){
            return -1;
        }
        else{
            return 0;
        }
    }
}
