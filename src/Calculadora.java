import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import javax.swing.*;
import javax.swing.border.LineBorder;

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
    
    //A+B, A-B, A*B, A/B
    String A = "0";
    String operador = null;
    String B = null;

    Calculadora() {
        //janela.setVisible(true);
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
        
        //displayJPanel.setBackground(corPreta); 
        //displayJPanel.setOpaque(true);
        //displayJPanel.setBounds(0, 0, largura, 120); 

        displayJPanel.add(displayJLabel); // Adiciona o JLabel ao JPanel
        janela.add(displayJPanel, BorderLayout.NORTH);
    

        buttonsPanel.setLayout(new GridLayout(5,4));
        buttonsPanel.setBackground(corPreta); //Cor de fundo do painel dos botões
        janela.add(buttonsPanel);

        for (int i = 0; i < buttonValues.length; i++) {

        String buttonValue = buttonValues[i];
        JButton button = new JButton(buttonValue);

        button.setFont(new Font("Arial", Font.PLAIN, 30));
        button.setForeground(Color.WHITE);
        button.setFocusPainted(false);
        button.setBorder(new LineBorder(corPreta)); // Borda preta para os botões

        // Aplicando estilos
        if (contains(rightSymbols, buttonValue)) {
            button.setBackground(corLaranja);
        } 
        else if (contains(topSymbols, buttonValue)) {
            button.setBackground(corCizaClaro);
            button.setForeground(corPreta);
        } 
        else {
            button.setBackground(corCinzaEscuro);
        }

        buttonsPanel.add(button); //ESSENCIAL

        button.addActionListener(new ActionListener() {
            
            public void actionPerformed(ActionEvent e) {
                JButton button = (JButton) e.getSource();
                String buttonValue = button.getText();

                if(Arrays.asList(rightSymbols).contains(buttonValue)) {
                    // Lógica para os símbolos de operação
                    if (buttonValue.equals("=")){
                        if(A != null){
                            B = displayJLabel.getText();
                            double numA = Double.parseDouble(A);
                            double numB = Double.parseDouble(B);

                            if(operador.equals("+")){
                                displayJLabel.setText(removeZeroDecimal(numA+numB));
                            } 
                            else if (operador.equals("-")){
                                displayJLabel.setText(removeZeroDecimal(numA-numB));
                            } 
                            else if (operador.equals("×")){
                                displayJLabel.setText(removeZeroDecimal(numA*numB));
                            } 
                            else if (operador.equals("÷")){
                                displayJLabel.setText(removeZeroDecimal(numA/numB));
                            }
                            limpar();
                        }

                    }
                    else if ("+-×÷".contains(buttonValue)){
                        if(operador == null){
                            A = displayJLabel.getText();                          
                            displayJLabel.setText("0");
                            B = "0";
                        } 
                        operador = buttonValue;
                    }

                    System.out.println("Operação: " + buttonValue);
                } else if (Arrays.asList(topSymbols).contains(buttonValue)) {
                    // Lógica para os símbolos do topo
                    if(buttonValue.equals("AC")){
                        limpar();
                        displayJLabel.setText("0");
                    }
                    
                    else if (buttonValue.equals("+/-")){
                        double numeroTela = Double.parseDouble(displayJLabel.getText());
                        numeroTela *= -1;
                        displayJLabel.setText(removeZeroDecimal(numeroTela));
                    }


                    else if (buttonValue.equals("%")){
                        double numeroTela = Double.parseDouble(displayJLabel.getText());
                        numeroTela /= 100;
                        displayJLabel.setText(removeZeroDecimal(numeroTela));
                    }


                } else {
                    if(buttonValue.equals(".")){

                        if(!displayJLabel.getText().contains(buttonValue)){
                            displayJLabel.setText(displayJLabel.getText() + buttonValue);
                        }
                        
                    } // Lógica para o ponto decimal
                    else if("0123456789".contains(buttonValue)){
                        if(displayJLabel.getText().equals("0")){
                            displayJLabel.setText(buttonValue);
                        } else {
                            displayJLabel.setText(displayJLabel.getText() + buttonValue);
                        }

                    } else {
                        
                    }
                    // Lógica para os números e outros símbolos
                    System.out.println("Número ou outro símbolo: " + buttonValue);
                }
                
            }
            
        
        });
        janela.setVisible(true);
    }

    }
     // MÉTODO VEM AQUI
    private boolean contains(String[] array, String value) {
        for (String item : array) {
            if (item.equals(value)) {
                return true;
            }
        }
        return false;
    }

    void limpar() {
        A = "0";
        operador = null;
        B = null;
    }

    String removeZeroDecimal(double numeroTela) {
        if(numeroTela % 1 == 0){
            return Integer.toString((int) numeroTela);
        }
        return Double.toString(numeroTela);
    }
}     

