/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.uefs.ecomp.RoadTrips.exceptions;

/**
 *
 * @author adrie
 */
public class InterseccaoNaoEncontradaException extends Exception{

    private final String mensagem;
    
    public InterseccaoNaoEncontradaException(){
        this.mensagem = "PONTO NÃO ENCONTRADO";
    }

    public String getMensagem() {
        return mensagem;
    }
}
