/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.uefs.ecomp.RoadTrips.util;

import br.uefs.ecomp.RoadTrips.exceptions.DadoNaoEncontradoException;
import java.io.Serializable;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Stack;

/**
 *
 * @author Nat?lia Rosa & Adriel Brito
 */
public class Graph implements IGraph, Serializable{
    private HashTable table;
    private LinkedList<Edge> edges;
    
    public Graph(){
        table = new HashTable(31);
        edges = new LinkedList<>();
    }
    
    @Override
    public void addVertex(Object key) {
        table.add(key, new LinkedList());
    }
 
    @Override
    public Iterator vertices() {
        return table.iterador();
    }

    @Override
    public int numVertices() {
        return table.size();
    }

    @Override
    public void removeVertex(Object key) throws DadoNaoEncontradoException {
        table.search(key);
        if(this.outDegree(key) > 0 ){
            Iterator itr = this.outgoingEdges(key);
            while(itr.hasNext()){
                this.removeEdge((Edge)itr.next());
            }
        }
        table.removeKey(key);
    }
    
    @Override
    public Iterator outgoingEdges(Object v) throws DadoNaoEncontradoException{
        return ((LinkedList)table.search(v)).iterator();
    }

    @Override
    public int outDegree(Object v) throws DadoNaoEncontradoException{
        return ((LinkedList)table.search(v)).size();
    }

    @Override
    public void addEdge(Edge e) throws DadoNaoEncontradoException{
        ((LinkedList)table.search(e.getSource())).add(e);
        ((LinkedList)table.search(e.getDestiny())).add(e);
        edges.add(e);
    }

    @Override
    public Edge getEdge(Object u, Object v) throws DadoNaoEncontradoException {
        for(Edge e: edges){
            if(e.getSource().equals(u) && e.getDestiny().equals(v) || e.getSource().equals(v) && e.getDestiny().equals(u)) {
                return e;
            }
        }
        throw new DadoNaoEncontradoException();
    }

    @Override
    public Iterator edges() {
        return edges.iterator();
    }

    @Override
    public int numEdges() {
        return edges.size();
    }

    @Override
    public void removeEdge(Edge e) throws DadoNaoEncontradoException{
        ((LinkedList)table.search(e.getDestiny())).remove(e);
        ((LinkedList)table.search(e.getSource())).remove(e);
        edges.remove(e);
    }
    
    public HashTable menorCaminho(Object origem) throws DadoNaoEncontradoException{
        HashTable menorcaminho = new HashTable(31);
        PriorityQueue<Edge> fila = new PriorityQueue<>();
        fila.offer(new Edge(origem, null, 0));
        while(!fila.isEmpty()){
            Edge e = fila.poll();
            Object v = e.getSource();
            if(!menorcaminho.cointaisKey(v)){
                menorcaminho.add(v, e);
                Iterator itr = outgoingEdges(v);
                while(itr.hasNext()){
                    Object u = adjecente(((Edge)itr.next()), v);
                    double distancia = getEdge(v,u).getWeight();
                    distancia = distancia + e.getWeight();  
                    
                    try{
                        Edge t = (Edge) menorcaminho.search(u);
                        if(distancia < t.getWeight()){
                            fila.offer(new Edge(u, v, distancia));
                        }
                    }catch(DadoNaoEncontradoException ex){
                        fila.offer(new Edge(u, v, distancia));
                    }
                }
            }
        }
        return menorcaminho;    
    }
    
    public Stack<Edge> caminho(Object origem, Object destino, HashTable hash) throws DadoNaoEncontradoException{
        Stack<Edge> pilha = new Stack<>();
        while(!origem.equals(destino)){
            pilha.push((Edge) hash.search(destino));
            destino = pilha.peek().getDestiny();
        }
        pilha.push((Edge) hash.search(destino));
        return pilha;
    }
    
    private Object adjecente(Edge e, Object v){
        if(e.getSource().equals(v)){
            return e.getDestiny();
        }
        else{
            return e.getSource();
        }
    }
}