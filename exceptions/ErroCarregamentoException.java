/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.uefs.ecomp.RoadTrips.exceptions;

/**
 *
 * @author Natália Rosa e Adriel Brito
 */
public class ErroCarregamentoException extends Exception{
    private String mensagem;
    
    public ErroCarregamentoException(){
        this.mensagem = "OCORREU UM ERRO NO CARREGAMENTO DOS ARQUIVOS!";
    }

    public String getMensagem() {
        return mensagem;
    }
}
