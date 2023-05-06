package CarnavalFolder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class FactGeneratorGUI {
    private JLabel label;
    private FactGenerator factGenerator;

    public FactGeneratorGUI(FactGenerator generator) {
        factGenerator = generator;
    }

    public void createAndShowGUI() {
        JFrame frame = new JFrame("Random Fact Generator");
        frame.setSize(400, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();

        label = new JLabel(factGenerator.getRandomFact());
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setVerticalAlignment(JLabel.CENTER);
        panel.add(label);

        JButton button = new JButton("Generate New Fact");
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                label.setText(factGenerator.getRandomFact());
            }
        });
        panel.add(button);

        frame.getContentPane().add(panel);

        frame.setVisible(true);
    }

    public static void main(String[] args) {
        FactGenerator generator = new ComputerHardwareFactGenerator();
        FactGeneratorGUI program = new FactGeneratorGUI(generator);
        program.createAndShowGUI();
    }

    public JLabel getLabel() {
        return label;
    }

    public void setLabel(JLabel label) {
        this.label = label;
    }

    public FactGenerator getFactGenerator() {
        return factGenerator;
    }

    public void setFactGenerator(FactGenerator factGenerator) {
        this.factGenerator = factGenerator;
    }
}