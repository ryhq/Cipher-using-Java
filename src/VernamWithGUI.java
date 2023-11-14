import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VernamWithGUI extends JFrame {

    // The CSS_BUTTONS was created to improve visualization to fields
    public void CSS_BUTTONS(JButton myButton){
        myButton.setFont(new Font("Georgia", Font.PLAIN, 21));
        myButton.setForeground(Color.decode("#5A1E03"));
        myButton.setBorder(BorderFactory.createBevelBorder(1, Color.decode("#5A1E03"), Color.decode("#FAE5C4")));
        myButton.setMargin(new Insets(50, 50, 50, 50));
    }

    // Constructor
    public VernamWithGUI(){

        // Creating navigation's Buttons;

        JButton homeButton = new JButton("HOME"); CSS_BUTTONS(homeButton);
        JButton vernamButton = new JButton("VERNAM"); CSS_BUTTONS(vernamButton);
        JButton vigenèreButton = new JButton("VIGENERE"); CSS_BUTTONS(vigenèreButton);
        JButton aboutButton = new JButton("ABOUT"); CSS_BUTTONS(aboutButton);

        // Initial Details for the dialogue

        setTitle("CRYPTOLOGY Version 2023.06.020");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(700, 70);
        setBounds(300, 50, 900, 10);
        setLayout(new GridLayout(1, 4)); // GridLayout(int rows, int columns, int h-gaps, int v-gap)creates a grid layout with the given rows and columns along with given horizontal and vertical gaps
        setMinimumSize(new Dimension(500, 70));
        getContentPane().setBackground(Color.decode("#FAE5C4"));

        // Adding Navigation Buttons to Display
        add(homeButton);
        add(vernamButton);
        add(vigenèreButton);
        add(aboutButton);

        //Making the app visible
        setVisible(true);

        //Adding action to vernamButton
        vernamButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

                // After clicking the hotelButton the following occurs

                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run(){new VRN();
                    }
                });
            }
        });

        //Adding action to vigenèreButton

        vigenèreButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

                // After clicking the hotelButton the following occurs

                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run(){new VGN();
                    }
                });
            }
        });
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run(){new VernamWithGUI();
            }
        });
    }
}