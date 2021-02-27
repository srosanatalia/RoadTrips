package br.uefs.ecomp.RoadTrips.controller;

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
import br.uefs.ecomp.RoadTrips.util.Edge;
import br.uefs.ecomp.RoadTrips.util.Graph;
import br.uefs.ecomp.RoadTrips.util.HashTable;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.UnsupportedEncodingException;
import java.util.Iterator;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.LinkedList;
import java.util.Stack;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author Natalia Rosa & Adriel Brito.
 */
public class RoadTripsController {
    
    private final Graph graph; 
    private HashTable logins;
    
    
    
    public RoadTripsController (){ //Construtor
        this.graph = new Graph ();
        logins = new HashTable(31);
    }        
    
    public Cidade inserirCidade(int latitude, int longitude, double area, double populacao, String descricao, String nome, int codigo) throws CidadeDuplicadaException {
        Cidade cidade = new Cidade (latitude, longitude, codigo, nome, area, populacao, descricao);
        try {
            graph.removeVertex(cidade);
            graph.addVertex(cidade);
            throw new CidadeDuplicadaException();
        } catch (DadoNaoEncontradoException ex) {
            graph.addVertex(cidade);
            return cidade;
        }
    }

    public Estrada inserirEstrada(Ponto pontoA, Ponto pontoB, double distancia, String nome) throws EstradaDuplicadaException, CidadeNaoEncontradaException  {
        Estrada estrada = new Estrada (pontoA, pontoB, distancia, nome);
        try {
            this.buscarEstrada(nome);
            throw new EstradaDuplicadaException();
        } catch (EstradaNaoEncontradaException ex) {
            try {
                graph.addEdge(estrada);
                return estrada;
            } catch (DadoNaoEncontradoException ex1) {
                throw new CidadeNaoEncontradaException();
            }
        }
    }

    public Interseccao inserirInterseccao(int latitude, int longitude, String tipoInterseccao) throws InterseccaoDuplicadaException {
        Interseccao interseccao = new Interseccao(latitude, longitude, tipoInterseccao);
        try { 
            this.buscarPonto(tipoInterseccao);
            throw new InterseccaoDuplicadaException();
        } catch (InterseccaoNaoEncontradaException ex) {
            graph.addVertex(interseccao);
            return interseccao;
        }
    }
    
    public Usuario inserirUsuario(String nome, String login, String senha) throws NoSuchAlgorithmException, UnsupportedEncodingException, UsuarioDuplicadoException{
        Usuario usuario = new Usuario(nome, login);
        try {
            this.buscarUsuario(login);
            throw new UsuarioDuplicadoException();
        } catch (UsuarioNaoEncontradoException ex) {
            String senhaCriptografada = criptografia(senha);
            logins.add(usuario, senhaCriptografada);
            return usuario;
        }
    }
    
    public void removerUsuario(String login) throws UsuarioNaoEncontradoException{
        Iterator itr = logins.iterador();
        while(itr.hasNext()){
            Usuario u = (Usuario) itr.next();
            if(u.getLogin().equals(login)){
                try {
                    logins.removeKey(u);
                } catch (DadoNaoEncontradoException ex) {
                    throw new UsuarioNaoEncontradoException();
                }
            }
        }
    }
    
    public int numeroVertices(){
        return graph.numVertices();
    }
        
    public void removerCidade(int codigo) throws CidadeNaoEncontradaException{
        Iterator itr = graph.vertices();
        while(itr.hasNext()){
            Object o = itr.next();
            if(o instanceof Cidade){
                Cidade cidade = (Cidade)o;
                if(cidade.getCodigo() == codigo){
                    try {
                        graph.removeVertex(cidade);
                    } catch (DadoNaoEncontradoException ex) {
                        throw new CidadeNaoEncontradaException();
                    }
                }
            }
            
        }
    }
    
    public void removerInterseccao (String nome) throws InterseccaoNaoEncontradaException{
        Iterator itr = graph.vertices();
         while(itr.hasNext()){
            Object o = itr.next();
            if(o instanceof Interseccao){
                Interseccao interseccao = (Interseccao)o;
                if(interseccao.getNome() == nome){
                    try {
                        graph.removeVertex(interseccao);
                    } catch (DadoNaoEncontradoException ex) {
                        throw new InterseccaoNaoEncontradaException();
                    }
                }
            }
        }
    }

    public void removerEstrada(String nome) throws EstradaNaoEncontradaException{
        Iterator itr = graph.edges();
        while(itr.hasNext()){
            Estrada e = (Estrada)itr.next();
            if(e.getNome().equals(nome)){
                try {
                    graph.removeEdge(e);
                } catch (DadoNaoEncontradoException ex) {
                    throw new EstradaNaoEncontradaException();
                }
            } 
        } 
    }
    
    public LocaisParaComer inserirLocalComer(String nome, String endereco, int codigo) throws CidadeNaoEncontradaException {
        Iterator itr = graph.vertices();
        while(itr.hasNext()){
            Cidade cidade = (Cidade)itr.next();
            if(cidade.getCodigo() == codigo){
                LocaisParaComer local = new LocaisParaComer(nome, endereco);
                cidade.inserirLocalComer(local);
                return local;
            }
        }
        throw new CidadeNaoEncontradaException();
    }

    public Usuario buscarUsuario(String login) throws UsuarioNaoEncontradoException{
        Iterator itr = logins.iterador();
        while(itr.hasNext()){
            Usuario u = (Usuario) itr.next();
            if(u.getLogin().equals(login)){
                return u;
            }
        }
        throw new UsuarioNaoEncontradoException();
    }
        
    public Cidade buscarPonto(int codigo) throws CidadeNaoEncontradaException{
        Iterator itr = graph.vertices();
        while(itr.hasNext()){
            Object o = itr.next();
            if(o instanceof Cidade){
                Cidade c = (Cidade)o;
                if(c.getCodigo() == codigo){
                    return c;
                }
            }
        }
        throw new CidadeNaoEncontradaException();
    }
    
    public Interseccao buscarPonto(String nome) throws InterseccaoNaoEncontradaException {
        Iterator itr = graph.vertices();
        while(itr.hasNext()){
            Object o = itr.next();
            if(o instanceof Interseccao){
                Interseccao c = (Interseccao)o;
                if(c.getNome().equals(nome)){
                    return c;
                }
            }
        }
        throw new InterseccaoNaoEncontradaException();
    }
    
    public boolean verificaUsuario(String login, String senha) throws UnsupportedEncodingException, NoSuchAlgorithmException, UsuarioNaoEncontradoException{
        try {
            return ((String)logins.search(buscarUsuario(login))).equals(criptografia(senha));
        } catch (DadoNaoEncontradoException ex) {
            throw new UsuarioNaoEncontradoException();
        }
    }
    
    public boolean verificaAdm(String login){
        return login.equals("JamylleS");
    }
    
    public String criptografia(String str) throws UnsupportedEncodingException, NoSuchAlgorithmException{
        MessageDigest algoritmo = MessageDigest.getInstance("SHA-256");
        byte criptografia[] = algoritmo.digest(str.getBytes("UTF-8"));
        return new String(criptografia, "UTF-8");
    }
    
    public LinkedList realizaViagem(Ponto origem, Ponto destino) throws EstradaNaoEncontradaException{
        Stack pilha;
        try {
            pilha = graph.caminho(origem, destino, graph.menorCaminho(origem));
        } catch (DadoNaoEncontradoException ex) {
            throw new EstradaNaoEncontradaException();
        }
        LinkedList lista = new LinkedList();
        Edge anterior = (Edge) pilha.pop();
        while(!pilha.isEmpty()){
            Edge atual = (Edge)pilha.pop();
            lista.add(buscarEstrada(atual.getWeight() - anterior.getWeight()));
            anterior = atual;
        }
        return lista;
    }
    
    public Estrada buscarEstrada(String nome) throws EstradaNaoEncontradaException{
        Iterator itr = graph.edges();
        while(itr.hasNext()){
            Estrada e = (Estrada)itr.next();
            if(e.getNome().equals(nome)){
                return e;
            } 
        } 
        throw new EstradaNaoEncontradaException();
    }

   public Estrada buscarEstrada(double distancia) throws EstradaNaoEncontradaException{
       Iterator itr = graph.edges();
        while(itr.hasNext()){
            Estrada e = (Estrada)itr.next();
            if(e.getWeight() == distancia){
                return e;
            } 
        } 
        throw new EstradaNaoEncontradaException();
    }
    
    public Iterator iteratorTodasCidades() {
        return graph.vertices();
    }
    
    public Iterator iteratorTodasArestas(){
        return graph.edges();
    }

    public Iterator arestasDeUmVertice(Cidade v) throws CidadeNaoEncontradaException {
        try {
            return graph.outgoingEdges(v);
        } catch (DadoNaoEncontradoException ex) {
            throw new CidadeNaoEncontradaException();
        }
    }

    public Ponto listarPontos(){
        Iterator itr = iteratorTodasCidades();
        while(itr.hasNext()){
            Ponto p = (Ponto) itr.next();
            return p;
        }
        return null;
    }
    
    public void LerArquivoCidades() throws FileNotFoundException, IOException{
       File arquivo = new File("Cidades.txt");

       FileReader lerArquivo = new FileReader(arquivo);
       BufferedReader buffer = new BufferedReader(lerArquivo);

       String linha = buffer.readLine();
       while(linha != null){
           String[] palavra = linha.split("; ");
           Cidade cidade = new Cidade ((Integer.parseInt(palavra[0])), (Integer.parseInt(palavra[1])), (Integer.parseInt(palavra[2])));
           cidade.setNome(palavra[3]);
           cidade.setArea(Double.parseDouble(palavra[4]));
           cidade.setPopulacao(Double.parseDouble(palavra[5]));
           cidade.setDescricao(palavra[6]);
           for (int i = 7; palavra[i] != null; i++){
               LocaisParaComer local = new LocaisParaComer(palavra[i], palavra[i++]);
               cidade.inserirLocalComer(local);
               i++;
            }
           graph.addVertex(cidade);
           linha = buffer.readLine();
        }
    }
    
    public void LerArquivoArestas() throws FileNotFoundException, IOException, CidadeNaoEncontradaException{
        File arquivo = new File("Arestas.txt");

       FileReader lerArquivo = new FileReader(arquivo);
       BufferedReader buffer = new BufferedReader(lerArquivo);

       String linha = buffer.readLine();
       while(linha != null){
            Cidade cidade1 = null, cidade2 = null;
            String[] palavra = linha.split("; ");
            
            Iterator itr1 = graph.vertices();
            while(itr1.hasNext()){
                Cidade cidade = (Cidade)itr1.next();
                if(cidade.getCodigo() == (Integer.parseInt(palavra[0]))){
                    cidade1= cidade;
                }
            }
            
            Iterator itr2 = graph.vertices();
            while(itr2.hasNext()){
                Cidade cidade = (Cidade)itr2.next();
                if(cidade.getCodigo() == (Integer.parseInt(palavra[1]))){
                    cidade2= cidade;
                }
            }
            
            Estrada estrada = new Estrada (cidade1, cidade2, Double.parseDouble(palavra[2]), palavra[3]);
            try{graph.addEdge(estrada);}catch(DadoNaoEncontradoException ex ){throw new CidadeNaoEncontradaException();}
            linha = buffer.readLine();
        }
    }
}
