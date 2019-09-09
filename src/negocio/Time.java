/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import java.util.ArrayList;

/**
 *
 * @author marcus.vasconcelos
 */
public class Time {
    private static int codigo;
    private int idTime;
    private String nomeTime;
    private String tecnico;
    public ArrayList<Jogador> jogadoresNoTime = new ArrayList<>();
    
    public Time(String n, String t){
        this.idTime = codigo;
        this.nomeTime = n;
        this.tecnico = t;
        codigo++;
    }
    
    public void setNomeTime(String n){
        this.nomeTime = n;
    }
    public String getNomeTime(){
        return nomeTime;
    }
    
    public void setTecnico(String n){
        this.tecnico = n;
    }
    public String getTecnico(){
        return tecnico;
    }
    
    public void setJogadores(Jogador j){
        this.jogadoresNoTime.add(j);
    }
    
    public void editaJogadores(Jogador j, int id){
        this.jogadoresNoTime.set(id, j);
    }
    
    public ArrayList getJogadores(){
        return jogadoresNoTime;
    }
    
    public int getIdTime(){
        return idTime;
    }
}
