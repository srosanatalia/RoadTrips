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
public class EstradaDuplicadaException extends Exception{

    private final String mensagem;
    
    public EstradaDuplicadaException(){
        this.mensagem = "ESTRADA J� CADASTRADA!";
    }

    public String getMensagem() {
        return mensagem;
    }
}
