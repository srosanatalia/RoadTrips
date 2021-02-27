/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.uefs.ecomp.RoadTrips.facade;

import br.uefs.ecomp.RoadTrips.controller.RoadTripsController;
import br.uefs.ecomp.RoadTrips.exceptions.CidadeDuplicadaException;
import br.uefs.ecomp.RoadTrips.exceptions.CidadeNaoEncontradaException;
import br.uefs.ecomp.RoadTrips.exceptions.DadoNaoEncontradoException;
import br.uefs.ecomp.RoadTrips.exceptions.EstradaDuplicadaException;
import br.uefs.ecomp.RoadTrips.exceptions.EstradaNaoEncontradaException;
import br.uefs.ecomp.RoadTrips.exceptions.InterseccaoDuplicadaException;
import br.uefs.ecomp.RoadTrips.exceptions.InterseccaoNaoEncontradaException;
import br.uefs.ecomp.RoadTrips.exceptions.UsuarioDuplicadoException;
import br.uefs.ecomp.RoadTrips.exceptions.UsuarioNaoEncontradoException;
import br.uefs.ecomp.RoadTrips.model.Cidade;
import br.uefs.ecomp.RoadTrips.model.Estrada;
import br.uefs.ecomp.RoadTrips.model.Interseccao;
import br.uefs.ecomp.RoadTrips.model.LocaisParaComer;
import br.uefs.ecomp.RoadTrips.model.Ponto;
import br.uefs.ecomp.RoadTrips.model.Usuario;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.Iterator;
import java.util.LinkedList;

/**
 *
 * @author Natalia Rosa & Adriel Brito.
 */
public class RoadTripsFacade {
    private final RoadTripsController controller;
    
    public RoadTripsFacade (){
        controller = new RoadTripsController ();
    }
    
    public Cidade inserirCidade (int latitude, int longitude, double area, double populacao, String descricao, String nome, int codigo)throws CidadeDuplicadaException{
        return controller.inserirCidade (latitude, longitude, area, populacao, descricao, nome, codigo);
    }
    
    public Estrada inserirEstrada (Ponto pontoA, Ponto pontoB, double distancia, String nome) throws CidadeNaoEncontradaException, EstradaDuplicadaException {
        return controller.inserirEstrada (pontoA, pontoB, distancia, nome);
    }
    
    public Interseccao inserirInterseccao (int latitude, int longitude, String tipoInterseccao)throws InterseccaoDuplicadaException{
        return controller.inserirInterseccao (latitude, longitude, tipoInterseccao);
    }
    
    public LocaisParaComer inserirLocalComer(String nome, String endereco, int codigo) throws CidadeNaoEncontradaException{
        return controller.inserirLocalComer( nome, endereco, codigo);
    }
    
    public Usuario inserirUsuario(String nome, String login, String senha) throws NoSuchAlgorithmException, UnsupportedEncodingException, UsuarioDuplicadoException{
        return controller.inserirUsuario(nome, login, senha);
    }
    
    public void removerUsuario(String login) throws UsuarioNaoEncontradoException{
        controller.removerUsuario(login);
    }
    
    public void removerCidade(int codigo) throws CidadeNaoEncontradaException{
        controller.removerCidade(codigo);
    }
    
    public void removerEstrada(String nome) throws EstradaNaoEncontradaException{
        controller.removerEstrada(nome);
    }
    
    public Usuario buscarUsuario(String login) throws UsuarioNaoEncontradoException{
        return controller.buscarUsuario(login);
    }
        
    public Cidade buscarPonto(int codigo) throws CidadeNaoEncontradaException{
        return controller.buscarPonto(codigo);
    }
    
    public Estrada buscarEstrada(String nome) throws EstradaNaoEncontradaException{
        return controller.buscarEstrada(nome);
    }

    public Estrada buscarEstrada(double distancia) throws EstradaNaoEncontradaException{
        return controller.buscarEstrada(distancia);
    }
   
    public LinkedList realizaViagem(Ponto origem, Ponto destino) throws EstradaNaoEncontradaException{
        return controller.realizaViagem(origem, destino);
    }
    
    public boolean verificaUsuario(String login, String senha) throws UnsupportedEncodingException, NoSuchAlgorithmException, UsuarioNaoEncontradoException{
        return controller.verificaUsuario(login, senha);
    }
    
    public Iterator iteratorTodasCidade(){
        return controller.iteratorTodasCidades();
    }
    
    public Iterator iteratorTodasArestas(){
        return controller.iteratorTodasArestas();
    }
    
    public Iterator arestasDeUmVertice(Cidade v) throws CidadeNaoEncontradaException{
        return controller.arestasDeUmVertice(v);
    }
    
    public void LerArquivoCidades() throws FileNotFoundException, IOException{
        controller.LerArquivoCidades();
    }
    
    public void LerArquivoArestas() throws FileNotFoundException, IOException, CidadeNaoEncontradaException{
        controller.LerArquivoArestas();
    }

    public int numeroVertices(){
        return controller.numeroVertices();
    }
    
    public void removerInterseccao (String nome) throws InterseccaoNaoEncontradaException{
        controller.removerInterseccao (nome);
    }
}
