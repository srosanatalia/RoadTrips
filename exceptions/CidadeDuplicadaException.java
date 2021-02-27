/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.uefs.ecomp.RoadTrips.exceptions;

/**
 *
 * @author Natalia Rosa & Adriel Brito.
 */
public class CidadeDuplicadaException extends Exception{
    private String mensagem;
    
    public CidadeDuplicadaException(){
        this.mensagem = "CIDADE JÁ CADASTRADA!";
    }

    public String getMensagem() {
        return mensagem;
    }
    
    public CidadeDuplicadaException(Throwable t){
        super(t);
    }
}
