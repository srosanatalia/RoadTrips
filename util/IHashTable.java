/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.uefs.ecomp.RoadTrips.util;

import br.uefs.ecomp.RoadTrips.exceptions.DadoNaoEncontradoException;

/**
 *
 * @author adrie
 */
public interface IHashTable {
    
    public void add(Object key, Object value);
    
    public Object search(Object key) throws DadoNaoEncontradoException;
    
    public void removeKey(Object key)  throws DadoNaoEncontradoException;
    
    public void removeValue(Object value) throws DadoNaoEncontradoException;
    
    public boolean isEmpty();
    
    public int size();
}
