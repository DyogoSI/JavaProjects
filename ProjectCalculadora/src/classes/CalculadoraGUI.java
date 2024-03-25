/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package classes;

/**
 *
 * @author dyogo
 */
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class CalculadoraGUI extends javax.swing.JFrame {
    private JTextField display;
    private JButton[] numericButtons;
    private JButton[] operatorButtons;
    private JButton equalsButton;
    private JButton clearButton;


    /**
     * Creates new form CalculadoraGUI
     */
    public CalculadoraGUI() {
        setTitle("Calculadora");
        setSize(300, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        display = new JTextField();
        display.setEditable(false);
        display.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);

        numericButtons = new JButton[10];
        for (int i = 0; i < 10; i++) {
          
            numericButtons[i] = new JButton(String.valueOf(i));
              numericButtons[i].setBackground(Color.BLUE);
            numericButtons[i].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    display.setText(display.getText() + ((JButton) e.getSource()).getText());
                }
            });
        }

        operatorButtons = new JButton[4];
        operatorButtons[0] = new JButton("+");
        operatorButtons[1] = new JButton("-");
        operatorButtons[2] = new JButton("*");
        operatorButtons[3] = new JButton("/");

        ActionListener operatorListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                display.setText(display.getText() + " " + ((JButton) e.getSource()).getText() + " ");
            }
        };

        for (JButton button : operatorButtons) {
            button.setBackground(Color.GREEN);
            button.addActionListener(operatorListener);
        }

        equalsButton = new JButton("=");
        equalsButton.setBackground(Color.YELLOW);
        equalsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String expression = display.getText();
                String[] parts = expression.split(" ");
                double result = Double.parseDouble(parts[0]);

                for (int i = 1; i < parts.length; i += 2) {
                    String operator = parts[i];
                    double operand = Double.parseDouble(parts[i + 1]);

                    switch (operator) {
                        case "+":
                            result += operand;
                            break;
                        case "-":
                            result -= operand;
                            break;
                        case "*":
                            result *= operand;
                            break;
                        case "/":
                            result /= operand;
                            break;
                    }
                }

                display.setText(String.valueOf(result));
            }
        });

        clearButton = new JButton("C");
        clearButton.setBackground(Color.RED);
        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                display.setText("");
            }
        });

        JPanel buttonPanel = new JPanel(new GridLayout(4, 4));
        buttonPanel.setBackground(Color.BLACK);
        buttonPanel.add(numericButtons[7]);
        buttonPanel.add(numericButtons[8]);
        buttonPanel.add(numericButtons[9]);
        buttonPanel.add(operatorButtons[0]);
        buttonPanel.add(numericButtons[4]);
        buttonPanel.add(numericButtons[5]);
        buttonPanel.add(numericButtons[6]);
        buttonPanel.add(operatorButtons[1]);
        buttonPanel.add(numericButtons[1]);
        buttonPanel.add(numericButtons[2]);
        buttonPanel.add(numericButtons[3]);
        buttonPanel.add(operatorButtons[2]);
        buttonPanel.add(numericButtons[0]);
        buttonPanel.add(clearButton);
        buttonPanel.add(equalsButton);
        buttonPanel.add(operatorButtons[3]);
        
      


        setLayout(new GridLayout(2, 1));
        add(display);
        add(buttonPanel);
       
    }
 
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
          try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(CalculadoraGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CalculadoraGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CalculadoraGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CalculadoraGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CalculadoraGUI().setVisible(true);
            }
        });
    
    }

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
