import java.awt.Color;
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
    
    //Texto no topo da janela
    JFrame janela = new JFrame("Calculadora");

    //>>Criando o display da calculadora

    JLabel displayJLabel = new JLabel(); //Texto do display, alinhado à direita
    JPanel displayJPanel = new JPanel(); //Painel do display, para organizar o layout do display

    public void Calculadora() {
        //Configurações da janela
        janela.setVisible(true); //Tornando a janela visível
        janela.setSize(largura, altura); //Definindo o tamanho da janela
        janela.setLayout(null); //Definindo o layout como null para posicionamento absoluto dos componentes
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Fechar a aplicação quando a janela for fechada
        janela.setResizable(false); // Para que o usuario não arraste a janela
        janela.setLocationRelativeTo(null); // localização da janela no centro da tela, definindo com null, para que a janela seja centralizada na tela do usuário e não considere a posição relativa. Isso é útil para garantir que a janela apareça no centro da tela, independentemente de onde o usuário tenha movido a janela anteriormente.

    
    }
}
