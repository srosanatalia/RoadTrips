package br.uefs.ecomp.RoadTrips.util;

import br.uefs.ecomp.RoadTrips.exceptions.DadoNaoEncontradoException;
import java.util.Iterator;
import java.util.LinkedList;
/**
 *
@author adrie
 */
public class HashTable implements IHashTable{
    private Object[] entries; 
    private int size;
    
    public HashTable (int size){
        this.entries = new Object[size];
    }

    @Override
    public void add(Object key, Object value) {
        if(size/entries.length > 0.75){
            Object[] newEntries = new Object[entries.length*2];
            for(int i = 0; i < size; i++){
                if(entries[i] instanceof LinkedList){
                    Iterator itr = ((LinkedList)entries[i]).iterator();
                    while(itr.hasNext()){
                        newEntries[hashFunction(((Entry)itr.next()).getKey())] = itr.next();
                        i++;
                    }
                }
                else{
                    newEntries[hashFunction(((Entry)entries[i]).getKey())] = entries[i];
                }
            }
            entries = newEntries;
        }
        
        Entry entry = new Entry(key, value);
        if(entries[hashFunction(key)] instanceof Entry){
            LinkedList list = new LinkedList();
            list.add(entries[hashFunction(key)]);
            list.add(entry);
            entries[hashFunction(key)] = list;
        }
        else if(entries[hashFunction(key)] instanceof LinkedList){
            ((LinkedList)entries[hashFunction(key)]).add(entry);
        }
        else{
            entries[hashFunction(key)] = entry;
        }
        size++;
    }

    @Override 
    public Object search(Object key) throws DadoNaoEncontradoException{
        if(entries[hashFunction(key)] != null){
            if(entries[hashFunction(key)] instanceof LinkedList){
                Iterator itr = ((LinkedList)entries[hashFunction(key)]).iterator();
                while(itr.hasNext()){
                   Entry e = (Entry) itr.next();
                   if(e.getKey().equals(key)){
                       return e.getValue();
                   }
                }
            }
            return ((Entry)entries[hashFunction(key)]).getValue();
        }
        throw new DadoNaoEncontradoException();
    }
    
    @Override
    public void removeKey(Object key) throws DadoNaoEncontradoException{
        if(entries[hashFunction(key)] != null){
            if(entries[hashFunction(key)] instanceof LinkedList){
                Iterator itr = ((LinkedList)entries[hashFunction(key)]).iterator();
                while(itr.hasNext()){
                    Entry e = (Entry) itr.next();
                    if(e.getKey().equals(key)){
                        ((LinkedList)entries[hashFunction(key)]).remove(e);
                        size--;
                        if(((LinkedList)entries[hashFunction(key)]).isEmpty()){
                            entries[hashFunction(key)] = null;
                        }
                        return;
                    }
                }
            }
            else{
                entries[hashFunction(key)] = null;
                size--;
                return;
            }
        }
        throw new DadoNaoEncontradoException();
    }

    @Override
    public void removeValue(Object value)  throws DadoNaoEncontradoException {
        for(int i = 0; i < size; i++){
            if(entries[i] instanceof LinkedList){
                Iterator itr = ((LinkedList)entries[i]).iterator();
                while(itr.hasNext()){
                    Entry e  = (Entry)itr.next();
                    if(e.getValue().equals(value)){
                        ((LinkedList)entries[i]).remove(e);
                        size--;
                        if(((LinkedList)entries[i]).isEmpty()){
                            entries[i] = null;
                        }
                        return; 
                    }
                    i++;
                }
            }
            else if(entries[i] != null){
                if(((Entry)entries[i]).getValue().equals(value)){
                    entries[i] = null;
                    size--;
                    return; 
                }
            }
        }
        throw new DadoNaoEncontradoException();
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }
    
    public boolean cointaisKey(Object o){
        for(Object e: entries){
            if(e!= null){
                if(((Entry)e).getKey().equals(o));
                return true;
            }
        }
        return false;
    }

    private int hashFunction(Object key){
        return Math.abs(key.hashCode() % entries.length);
    }
    
    public Iterator iterador(){
        return new IteratorHash();
    }
        
    
    private class IteratorHash implements Iterator{
        private int prox;
        private int count;
        private int list;
                
        @Override
        public boolean hasNext() {
            return prox < size;
        }

        @Override
        public Object next() {
            for(int i = count; i < entries.length; i++){
                if(entries[count] == null){
                    count++;
                }
                else{
                    break;
                }
            }
            if(entries[count] instanceof LinkedList){
                if(list <((LinkedList)entries[count]).size()){
                    prox++;
                    return ((Entry)((LinkedList)entries[count]).get(list++)).getKey();
                }
                else{
                    list = 0;
                    count++;
                }
            }
            prox++;
            return ((Entry)entries[count++]).getKey();
        }
    }
}
