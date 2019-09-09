/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import negocio.Jogador;
import negocio.Time;

/**
 *
 * @author marcus.vasconcelos
 */
public class Controle {
    
    DefaultTableModel tabelaAtual; //Cria um modelo de tabela que será exibido na tela
    public static ArrayList<Jogador> listaJogadores = new ArrayList<>();//Cria array dos jogadores
    public static ArrayList<Time> listaTimes = new ArrayList<>();//Cria array dos times
    
    public static boolean exibeJogador = true;

    
    public void p(String p){System.out.println(p);}
    public void p(int p){System.out.println(p);}
    
    public void criarJogadores(JTable t){
        Jogador n1 = new Jogador("Jogador 1", "Posicao 1");
        Jogador n2 = new Jogador("Jogador 2", "Posicao 2");
        Jogador n3 = new Jogador("Jogador 3", "Posicao 3");
        Jogador n4 = new Jogador("Jogador 4", "Posicao 4");
        listaJogadores.add(n1);
        listaJogadores.add(n2);
        listaJogadores.add(n3);
        listaJogadores.add(n4);
        
        listarJogadores(t);
    }
    
    public void criarTimes(JTable t){
        Time t1 = new Time("Time 1", "Técnico 1");
        Time t2 = new Time("Time 2", "Técnico 2");
        listaTimes.add(t1);
        listaTimes.add(t2);
        
        listarTimes(t);
    }
    
    public void limparTabelaAtual(JTable t){
        //Se houver linhas na tabela
        if (t != null && t.getRowCount()>0) {
            //Apaga a linha
            for (int i = t.getRowCount() - 1; i > -1; i--) {
                tabelaAtual.removeRow(i);
            }
        }
    }
    
    public void listarTimeCompleto(JTable t, int idTime){
        exibeJogador = true;
        //Se a lista não estiver vazia
        limparTabelaAtual(t); //Limpa exibição da tabela atual           

        //Cria o modelo da tabela que será exibido
        t.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {},
            new String [] {
                "ID", "Nome", "Posição"
        }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return false;
            }
        });
        //define o modelo da tabelaAtual como o modelo da tabela da interface
        tabelaAtual = (DefaultTableModel) t.getModel();

        //Cria um objeto dadosLinha, onde cada posição é será coluna da tabela
        Object dadosLinha[] = new Object[3];

        //percorre o lista e popula as colunas de acordo com a posição            
        for (int i = 0; i < listaTimes.get(idTime).getJogadores().size(); i++) {
            dadosLinha[0] = listaJogadores.get(i).getIdJogador();
            dadosLinha[1] = listaJogadores.get(i).getNomeJogador();
            dadosLinha[2] = listaJogadores.get(i).getPosicao();
            tabelaAtual.addRow(dadosLinha); //Adiciona os dados à uma nova linha na tabela
        }  
        
    }
    
    public void listarJogadores(JTable t){
        exibeJogador = true;
        //Se a lista não estiver vazia
        if (listaJogadores.size() > 0) {
            limparTabelaAtual(t); //Limpa exibição da tabela atual           
                        
            //Cria o modelo da tabela que será exibido
            t.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {},
                new String [] {
                    "ID", "Nome", "Posição", "Time"
            }
            ) {
                boolean[] canEdit = new boolean [] {
                    false, false, false, false
                };

                public boolean isCellEditable(int rowIndex, int columnIndex) {
                    return false;
                }
            });
            //define o modelo da tabelaAtual como o modelo da tabela da interface
            tabelaAtual = (DefaultTableModel) t.getModel();

            //Cria um objeto dadosLinha, onde cada posição é será coluna da tabela
            Object dadosLinha[] = new Object[4];
            
            //percorre o lista e popula as colunas de acordo com a posição            
            for (int i = 0; i < listaJogadores.size(); i++) {
                dadosLinha[0] = listaJogadores.get(i).getIdJogador();
                dadosLinha[1] = listaJogadores.get(i).getNomeJogador();
                dadosLinha[2] = listaJogadores.get(i).getPosicao();
                dadosLinha[3] = qualTime(i);
                tabelaAtual.addRow(dadosLinha); //Adiciona os dados à uma nova linha na tabela
            }  
        } else { //Se a lista estiver vazia, avisa o usuário
            JOptionPane.showMessageDialog(t, "Nenhum jogador cadastrado");
        }
    }
    
    public String qualTime(int id){
        if (listaTimes.isEmpty()) {
            return "Sem time";            
        } else {
            for (int i = 0; i < listaTimes.size(); i++) {
                if (!listaTimes.get(i).getJogadores().isEmpty()) {
                    for (int j = 0; j < listaTimes.get(i).getJogadores().size(); j++) {
                        if (listaTimes.get(i).jogadoresNoTime.get(j).getIdJogador() == id) {
                            return listaTimes.get(i).getNomeTime();
                        }
                    }
                }               
            }
            return "Sem Time";
        }
    }
    public int idTime(int id){
        if (listaTimes.isEmpty()) {
            return -1;            
        } else {
            for (int i = 0; i < listaTimes.size(); i++) {
                if (!listaTimes.get(i).getJogadores().isEmpty()) {
                    for (int j = 0; j < listaTimes.get(i).getJogadores().size(); j++) {
                        if (listaTimes.get(i).jogadoresNoTime.get(j).getIdJogador() == id) {
                            return listaTimes.get(i).getIdTime();
                        }
                    }
                }               
            }
            return -1;
        }
    }
    
    public void listarTimes(JTable t){
        exibeJogador = false;
        //Se a lista não estiver vazia
        if (listaTimes.size() > 0) {
            limparTabelaAtual(t); //Limpa exibição da tabela atual           
                        
            //Cria o modelo da tabela que será exibido
            t.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {},
                
                new String [] {
                    "ID", "Nome do Time", "Técnico", "Nº de Jogadores"
            }
            ) {
                boolean[] canEdit = new boolean [] {
                    false, false, false, false
                };

                public boolean isCellEditable(int rowIndex, int columnIndex) {
                    return false;
                }
            });
            //define o modelo da tabelaAtual como o modelo da tabela da interface
            tabelaAtual = (DefaultTableModel) t.getModel();

            //Cria um objeto dadosLinha, onde cada posição é será coluna da tabela
            Object dadosLinha[] = new Object[4];
            
            //percorre o lista e popula as colunas de acordo com a posição            
            for (int i = 0; i < listaTimes.size(); i++) {
                dadosLinha[0] = listaTimes.get(i).getIdTime();
                dadosLinha[1] = listaTimes.get(i).getNomeTime();
                dadosLinha[2] = listaTimes.get(i).getTecnico();
                dadosLinha[3] = numJogadores(listaTimes, i);
                tabelaAtual.addRow(dadosLinha); //Adiciona os dados à uma nova linha na tabela
            }  
        } else { //Se a lista estiver vazia, avisa o usuário
            JOptionPane.showMessageDialog(t, "Nenhum time cadastrado");
        }
    }
    private String numJogadores(ArrayList<Time> l, int i){
        if (l.get(i).getJogadores().isEmpty()) {
            return "Não há jogadores";
        } else  {
            return String.valueOf(l.get(i).getJogadores().size());
        }
    }
    
    public ArrayList getListaTimes(){
        return listaTimes;
    }
    
    public void cadastrarTime(String time, String tecnico, JTable t){
        Time novoTime = new Time(time, tecnico);
        listaTimes.add(novoTime);
        
        listarTimes(t);
    }
    
    public void cadastrarJogador(String nome, String posicao, int time, JTable t){
        Jogador novoJogador = new Jogador(nome, posicao);
        listaJogadores.add(novoJogador);
        listaTimes.get(time).setJogadores(novoJogador);
        listarJogadores(t);
    }
    public void cadastrarJogador(String nome, String posicao,  JTable t){
        Jogador novoJogador = new Jogador(nome, posicao);
        listaJogadores.add(novoJogador);
        listarJogadores(t);
    }
    
    public void editarJogador(String nome, String posicao, int time, int idJogador, int timeAntigo, JTable t){
        listaJogadores.get(idJogador).setNomeJogador(nome);
        listaJogadores.get(idJogador).setPosicao(posicao);
        
        if (time != timeAntigo) {            
            listaTimes.get(time).setJogadores(listaJogadores.get(idJogador));
            listaTimes.get(timeAntigo).getJogadores().remove(listaJogadores.get(idJogador));
        } 
        listarJogadores(t);
    }
    
    
    
}
