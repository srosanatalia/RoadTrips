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
public class CidadeNaoEncontradaException extends Exception{
    private String mensagem;
    
    public CidadeNaoEncontradaException(){
        this.mensagem = "CIDADE NÃO ENCONTRADA!";
    }

    public String getMensagem() {
        return mensagem;
    }
}
