import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class VRN extends JFrame{

    // Method to remove whitespaces
    public static String noWhiteSpaces(String myString){
        String userTextCapital = myString.toUpperCase();
        StringBuilder noWhiteSpaces = new StringBuilder(" ");
        for (int x = 0 ; x < userTextCapital.length() ; x++ ){
            if ( userTextCapital.charAt(x) != ' ') {
                noWhiteSpaces.append(userTextCapital.charAt(x));
            }
        }
        noWhiteSpaces = new StringBuilder(noWhiteSpaces.toString().trim());
        return noWhiteSpaces.toString();
    }


    // Method to remove special characters

    public static String removeSpecialCharacters(String myString){
        String noWhiteSpaces = noWhiteSpaces(myString);
        StringBuilder upperCaseOnly = new StringBuilder(" ");
        for ( int x = 0 ; x < noWhiteSpaces.length() ; x++ ){
            if ( (int)noWhiteSpaces.charAt(x) >= 65 && (int)noWhiteSpaces.charAt(x) <= 90 ){
                upperCaseOnly.append(noWhiteSpaces.charAt(x));
            }
        }
        upperCaseOnly = new StringBuilder(upperCaseOnly.toString().trim());
        return upperCaseOnly.toString();
    }


    // Encryption Method
    public static String encryption( String myString, String myKey){
        final char[] alphabetCapital = {' ', 'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
        int myStringLength = myString.length(); // Store the total characters of the plaintext
        int myKeyLength = myKey.length(); // Store the total characters of the encryption key
        int times, counter = 0;
        int[] myStringToNumbers = new int[myStringLength]; // Array to store integer position of every character of plain text with reference to alphabetical array
        int[] myKeyToNumber = new int[myKeyLength]; // Array to store integer position of every character of encryption key with reference to alphabetical array
        StringBuilder cipher = new StringBuilder(" "); // For storing the cipher text now
        // Determining the position of each character in myString and storing it in an int array;
        for ( int x = 0 ; x < myStringLength ; x++ ){
            for ( int y = 1 ; y <= 26 ; y++ ){
                if( myString.charAt(x) == alphabetCapital[y] ){
                    myStringToNumbers[x] = y;
                }
            }
        }
        // Determining the position of each character in myKey and storing it in an int array;
        for ( int x = 0 ; x < myKeyLength ; x++ ){
            for ( int y = 1 ; y <= 26 ; y++ ){
                if( myKey.charAt(x) == alphabetCapital[y] ){
                    myKeyToNumber[x] = y;
                }
            }
        }
        // Encrypting
        times = myStringLength / myKeyLength;
        for ( int a = 1 ; a <= times ; a++ ){
            for ( int b = 0 ; b < myKeyLength ; b++ ){
                if ( (myStringToNumbers[b + counter] + myKeyToNumber[b]) % 26 == 0 ){
                    myStringToNumbers[b + counter] = 26;
                }else{
                    myStringToNumbers[b + counter] = (myStringToNumbers[b + counter] + myKeyToNumber[b]) % 26;
                }
            }
            counter = counter + myKeyLength;
        }
        // Outputing
        for ( int r = 0 ; r < myStringLength ; r++ ){
            cipher.append(alphabetCapital[myStringToNumbers[r]]);
        }

        return cipher.toString();
    }

    // The CSS_TEXT was created to improve visualization to Label texts
    public void CSS_TEXT(JLabel mylabel){
        mylabel.setFont(new Font("Times New Roman", Font.PLAIN, 21));
        mylabel.setForeground(Color.decode("#5A1E03"));
    }

    // The CSS_INPUT_FEILDS was created to improve visualization to feilds
    public void CSS_INPUT_FEILDS(JTextField myFeild){
        myFeild.setFont(new Font("Georgia", Font.PLAIN, 28));
        myFeild.setForeground(Color.decode("#5A1E03"));
        myFeild.setHorizontalAlignment(JTextField.RIGHT);
    }

    // The CSS_BUTTONS was created to improve visualization to feilds
    public void CSS_BUTTONS(JButton myButton){
        myButton.setFont(new Font("Georgia", Font.PLAIN, 21));
        myButton.setForeground(Color.decode("#5A1E03"));
        myButton.setBorder(BorderFactory.createBevelBorder(1, Color.decode("#5A1E03"), Color.decode("#FAE5C4")));
        myButton.setMargin(new Insets(50, 50, 50, 50));
    }

    // Declaring Instance variables of the class
    final private JTextField plainTextField, encryptionKeyField, encryptedTextField;
    final private JTextField plainTextToCapitalField, plainTextNoSpecialCharactersField;

    // Constructor
    public VRN(){

        // Initial Details for the dialogue

        setTitle("VERNAM Version 2023.06.020");
        // setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); This line was commented to prevent end of the program when the DRS buttons is closed
        setSize(700, 70);
        setBounds(300, 120, 900, 10);
        setLayout(new GridLayout(12, 1, 0, 0)); // GridLayout(int rows, int columns, int hgaps, int vgap)creates a grid layout with the given rows and columns along with given horizontal and vertical gaps
        setMinimumSize(new Dimension(500, 500));
        getContentPane().setBackground(Color.decode("#FAE5C4"));

        // Declaring Input's Labels

        JLabel plainText = new JLabel("Plain Text");CSS_TEXT(plainText);
        JLabel plainTextToCapital = new JLabel("Plain Text To Capital Letters");CSS_TEXT(plainTextToCapital);
        JLabel plainTextNoSpecialCharacters = new JLabel("Plain Text Without Whitespaces and Special Characters");CSS_TEXT(plainTextNoSpecialCharacters);
        JLabel encryptionKey = new JLabel("Encryption Key"); CSS_TEXT(encryptionKey);
        JLabel encryptedText = new JLabel("Cipher Text"); CSS_TEXT(encryptedText);

        // Declaring Input's variables

        plainTextField = new JTextField(); CSS_INPUT_FEILDS(plainTextField);
        plainTextToCapitalField = new JTextField(); CSS_INPUT_FEILDS(plainTextToCapitalField);
        plainTextNoSpecialCharactersField = new JTextField(); CSS_INPUT_FEILDS(plainTextNoSpecialCharactersField);
        encryptionKeyField = new JTextField(); CSS_INPUT_FEILDS(encryptionKeyField);
        encryptedTextField = new JTextField(13); CSS_INPUT_FEILDS(encryptedTextField);
        encryptedTextField.setEditable(false); // Disabling user input there
        plainTextToCapitalField.setEnabled(false);
        plainTextNoSpecialCharactersField.setEnabled(false);

        // Creating Functionality Buttons

        JButton encryptButton = new JButton("Encrypt"); CSS_BUTTONS(encryptButton);
        JButton clearButton = new JButton("Clear"); CSS_BUTTONS(clearButton);

        // Adding visibilibility
        add(plainText);
        add(plainTextField);
        add(plainTextToCapital);
        add(plainTextToCapitalField);
        add(plainTextNoSpecialCharacters);
        add(plainTextNoSpecialCharactersField);
        add(encryptionKey);
        add(encryptionKeyField);
        add(encryptedText);
        add(encryptedTextField);
        add(encryptButton);
        add(clearButton);

        //Making the app visible
        setVisible(true);

        // Defining Buttons Functionality

        // Encrypt Button
        encryptButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                int totalCharacters = 0;
                String plainText = plainTextField.getText();
                String newPlainText;
                String encryptionKey = encryptionKeyField.getText();
                if ( plainText.isEmpty() ){
                    JOptionPane.showMessageDialog(VRN.this, "Please type in your Plain text");
                }else if ( encryptionKey.isEmpty() ){
                    JOptionPane.showMessageDialog(VRN.this, "Please type in the Encryption Key");
                }
//                else if ( plainText.length() != 0){
//                    plainText = plainText.toUpperCase(); // Convert the plain Text to uppercase
//                    newPlainText = removeSpecialCharacters(plainText); // Removing special characters
//                    totalCharacters = newPlainText.length();
//                }else if ( encryptionKey.length() != 0){
//                    if ( totalCharacters % encryptionKey.length() != 0 ){
//                        JOptionPane.showMessageDialog(VRN.this, "Encryption key must be of the length that divides " + totalCharacters + " completely");
//                    }else {
//                        encryptionKey = encryptionKey.toUpperCase();
//                        encryptionKey = encryptionKey.trim();
//                        String message = encryption(removeSpecialCharacters(plainText), encryptionKey);
//                        JOptionPane.showMessageDialog(VRN.this, message);
//                    }
//                }
                plainText = plainText.toUpperCase(); // Convert the plain Text to uppercase
                newPlainText = removeSpecialCharacters(plainText); // Removing special characters
                totalCharacters = newPlainText.length();
                if ( totalCharacters % encryptionKey.length() != 0 ){
                    JOptionPane.showMessageDialog(VRN.this, "Encryption key must be of the length that divides " + totalCharacters + " completely");
                }else {
                    encryptionKey = encryptionKey.toUpperCase();
                    encryptionKey = encryptionKey.trim();
                    String message = encryption(removeSpecialCharacters(plainText), encryptionKey);
                    plainTextToCapitalField.setText(plainText);
                    plainTextNoSpecialCharactersField.setText(newPlainText);
                    encryptedTextField.setText(message);
                }
            }
        });

        // Clear Button
        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                plainTextField.setText("");
                plainTextToCapitalField.setText("");
                plainTextNoSpecialCharactersField.setText("");
                encryptedTextField.setText("");
                encryptionKeyField.setText("");
            }
        });
    }

}
