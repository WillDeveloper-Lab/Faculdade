/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package castrareventos;

/**
 *
 * @author games
 */
public class Application {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        JFrameEvento app = new JFrameEvento(); //Cria o objeto Janela
        app.setTitle("Cadastro de Alunos"); //Define o título na Janela
        app.setLocationRelativeTo(null); //Coloca a janela no centro da tela
        app.setVisible(true); //Mostra a janela
    }
    
}
