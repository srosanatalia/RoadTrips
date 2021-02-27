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
class Entry{
    private Object value;
    private Object key;

    public Entry(Object key, Object value){
        this.key = key;
        this.value = value;
    }
    
    public Object getValue() {
        return value;
    }

    public Object getKey() {
        return key;
    }

    @Override
    public boolean equals(Object o){
        if(o instanceof Entry){
            Entry e  = (Entry) o;
            return key == null && e.getKey() == null || key != null && key.equals(e.getKey()); 
        }
        return false;
    }
}
