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
public class UsuarioNaoEncontradoException extends Exception{
    private String mensagem;
    
    public UsuarioNaoEncontradoException(){
        this.mensagem = "NOME DE USUARIO E SENHA NÃO CONDIZEM!";
    }

    public String getMensagem() {
        return mensagem;
    }
}
