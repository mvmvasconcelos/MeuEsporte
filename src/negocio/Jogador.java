/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

/**
 * Cria um novo jogador
 * 
 * @author marcus.vasconcelos
 */
public class Jogador {
    private static int id = 0;
    private int idJogador;
    private String nomeJogador;
    private String posicao;
    
    public Jogador(String n, String p){
        this.idJogador = id;
        this.nomeJogador = n;
        this.posicao = p;
        id++;        
    }
    
    public void setNomeJogador(String n){
        this.nomeJogador = n;
    }
    public String getNomeJogador(){
        return nomeJogador;
    }
    
    public void setPosicao(String p){
        this.posicao = p;
    }
    public String getPosicao(){
        return posicao;
    }
    
    public int getIdJogador(){
        return idJogador;
    }
    
    
    
}
