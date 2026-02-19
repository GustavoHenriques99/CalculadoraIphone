import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import javax.swing.*;

public class Calculadora {
    //Criando janela principal
    int largura = 360; //width
    int altura = 540; //height
    
    //Defininao cores usadas na calculadora
    Color corCizaClaro = new Color(212, 212, 200); //Cinza claro
    Color corCinzaEscuro = new Color(80, 80, 80); //Cinza escuro
    Color corPreta = new Color(28, 28, 28); //Preto
    Color corLaranja = new Color(255, 149, 0); //Laranja


    String[] buttonValues = {
                            "AC", "+/-", "%", "÷", 
                            "7", "8", "9", "×", 
                            "4", "5", "6", "-",
                            "1", "2", "3", "+",
                            "0", ".", "√", "="
    };

    //Separando os símbolos em categorias para facilitar a aplicação de estilos
    String[] rightSymbols = {"÷", "×", "-", "+", "="};
    
    //O topSymbols são os símbolos que ficam no topo da calculadora, e tem um estilo diferente dos outros
    String[] topSymbols = {"AC", "+/-", "%"}; 

    
    //Texto no topo da janela
    JFrame janela = new JFrame("Calculadora");
    //Elementos do display
    JLabel displayJLabel = new JLabel();
    //Visor/ painel do display
    JPanel displayJPanel = new JPanel();
    //Painel dos botões
    JPanel buttonsPanel = new JPanel();

  Calculadora() {
    janela.setVisible(true);
    janela.setSize(largura, altura);
    janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    janela.setResizable(false);
    janela.setLocationRelativeTo(null); 

    // ===== DISPLAY =====
    displayJLabel.setBackground(corPreta);
    displayJLabel.setForeground(Color.WHITE);
    displayJLabel.setFont(new Font("Arial", Font.PLAIN, 60));
    displayJLabel.setHorizontalAlignment(JLabel.RIGHT);
    displayJLabel.setText("0");
    displayJLabel.setOpaque(true);

    // ===== PAINEL =====
    displayJPanel.setLayout(new BorderLayout());
    
    //displayJPanel.setBackground(corPreta); // 🔥 COR DO PAINEL
    //displayJPanel.setOpaque(true);
    //displayJPanel.setBounds(0, 0, largura, 120); // 🔥 posição e tamanho

    displayJPanel.add(displayJLabel); // Adiciona o JLabel ao JPanel
    janela.add(displayJPanel, BorderLayout.NORTH);
  
    


    }
}
