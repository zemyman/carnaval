import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class HorseRacers {
    public static String[] horses = { "Ben", "tom", "fred" };

    public static void main(String[] args) {
        new HorseRacers();
    }

    HorseRacers() {
    
        JFrame bettingFeild = new JFrame();
        bettingFeild.setSize(500, 500);
        bettingFeild.setVisible(true);
        bettingFeild.setLayout(null);
        bettingFeild.setVisible(false);
        bettingFeild.setVisible(true);
        bettingFeild.add(bettingButtons());
        
    }

    public static JPanel bettingButtons() {
       
        JPanel bettingButtons = new JPanel();
        bettingButtons.setBounds(125, 250, 245, 50);
        bettingButtons.setBackground(Color.orange);
        bettingButtons.setLayout(new BorderLayout(2,0));
        bettingButtons.add(benButton(), BorderLayout.LINE_START);
        bettingButtons.add(tomButton(), BorderLayout.CENTER);
        bettingButtons.add(fredButton(), BorderLayout.LINE_END);
        return bettingButtons;
    }

    public static JButton benButton(){
        
            JButton ben = new JButton();
            ben.setText(horses[0]);
           // ben.setBounds(0, 50, 20, 50);
            ben.setFont(new Font("Comic Sans", Font.BOLD, 12));
            ben.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent evt) {
                    
                }
            });
    
            return ben;
        }
        public static JButton tomButton(){
        
            JButton tom = new JButton();
            tom.setText(horses[1]);
            //tom.setBounds(0, 50, 20, 50);
            tom.setFont(new Font("Comic Sans", Font.BOLD, 12));
            tom.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent evt) {
                    
                }
            });
    
            return tom;
        }
        public static JButton fredButton(){
        
            JButton fred = new JButton();
            fred.setText(horses[2]);
            //fred.setBounds(0, 50, 20, 50);
            fred.setFont(new Font("Comic Sans", Font.BOLD, 12));
            fred.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent evt) {
                    
                }
            });
    
            return fred;
        }
    
    }
