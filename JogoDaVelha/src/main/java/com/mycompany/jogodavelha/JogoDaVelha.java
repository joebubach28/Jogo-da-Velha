package com.mycompany.jogodavelha;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public final class JogoDaVelha extends JFrame{
    
    ImageIcon iconCirculo = new ImageIcon(getClass().getResource("circulo.png"));
     ImageIcon iconX = new ImageIcon(getClass().getResource("x2.png"));
   
     JPanel pTela = new JPanel(new GridLayout(3, 3, 10, 10));
    
    Bloco[] blocos = new Bloco[9];
    
    int rodadas = 0;
    
    final int Jogador_1 = 1;
    final int Jogador_2 = 2;
    
    int JogadorVez = Jogador_1;
    
        JLabel lInformacao = new JLabel("Jogador "+Jogador_1);

    public JogoDaVelha(){
        configurarJanela();
        configurarTela();
    }
    
    public void configurarTela() {
        add(BorderLayout.CENTER,pTela);
        add(BorderLayout.NORTH,lInformacao);
        pTela.setBackground(Color.BLACK);
        lInformacao.setFont(new Font("Arial",Font.BOLD,35));
        lInformacao.setForeground(new Color(50,200,50));
        lInformacao.setHorizontalAlignment(SwingConstants.CENTER);
        
        
        for(int i=0;i<9;i++){
          Bloco bloco = new Bloco();
         blocos[i] = bloco;
         pTela.add(bloco);
        }
    }
    public void mudarVez(){
        if(JogadorVez==1){
            JogadorVez=2;
            lInformacao.setText("Jogador 2");
            lInformacao.setBackground(Color.RED);
        } else {
            JogadorVez=1;
            lInformacao.setText("Jogador 1");
            lInformacao.setBackground(new Color(50,200,50));
        }
    } 
    
    public boolean testarVitoria(int jog){
        if(blocos[0].quem==jog && blocos[1].quem==jog && blocos[2].quem==jog){
          return true;  
        }
           if(blocos[3].quem==jog && blocos[4].quem==jog && blocos[5].quem==jog){
          return true; 
        }
           if(blocos[6].quem==jog && blocos[7].quem==jog && blocos[8].quem==jog){
          return true; 
        }
           if(blocos[0].quem==jog && blocos[1].quem==jog && blocos[2].quem==jog){
          return true; 
        }
           if(blocos[0].quem==jog && blocos[3].quem==jog && blocos[6].quem==jog){
          return true; 
        }
           if(blocos[1].quem==jog && blocos[4].quem==jog && blocos[7].quem==jog){
          return true; 
        }
           if(blocos[2].quem==jog && blocos[5].quem==jog && blocos[8].quem==jog){
          return true; 
        }
           if(blocos[0].quem==jog && blocos[4].quem==jog && blocos[8].quem==jog){
          return true; 
        }   
        return blocos[6].quem==jog && blocos[4].quem==jog && blocos[2].quem==jog;
        
    }
    
    public void configurarJanela() {
    setTitle("Jogo da Velha");
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    setSize(600,600);
    setLocationRelativeTo(null);
    setVisible(true);
    
    
    
}
    public static void main(String[] args) {
        new JogoDaVelha();
    }
    
    public class Bloco extends JButton{
        
    int quem = 0;
        public Bloco(){
            setBackground(Color.WHITE);
            addActionListener(e->{
             if(quem==0){
                   if(JogadorVez==Jogador_1){
                      setIcon(iconCirculo);
                      quem = Jogador_1;
                   } else {
                     setIcon(iconX); 
                     quem = Jogador_2;
                   }
                   if(testarVitoria(quem)){
                      JOptionPane.showMessageDialog(null,"Jogador"+quem+"Venceu!!!");
                      System.exit(0);
                   }
                   rodadas++;
                   if(rodadas==9){
                       JOptionPane.showMessageDialog(null,"Deu Velha!!!");
                       System.exit(0);
                   }
                   mudarVez();
               } 

            });           
        }  
    }    
}