/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.uefs.ecomp.RoadTrips.util;

import br.uefs.ecomp.RoadTrips.exceptions.DadoNaoEncontradoException;
import java.util.Iterator;

/**
 *
 * @author Nat�lia Rosa & Adriel Brito
 */
public interface IGraph {
    public void addVertex(Object key);
    public Iterator vertices();
    public int numVertices();
    public void removeVertex(Object key) throws DadoNaoEncontradoException;

    public void addEdge(Edge e) throws DadoNaoEncontradoException;
    public Edge getEdge(Object u, Object v) throws DadoNaoEncontradoException;
    public Iterator edges();
    public int numEdges();
    public void removeEdge(Edge e) throws DadoNaoEncontradoException;

    public Iterator outgoingEdges(Object v) throws DadoNaoEncontradoException;
    public int outDegree(Object v) throws DadoNaoEncontradoException;
}