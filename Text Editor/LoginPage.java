import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class LoginPage implements ActionListener {

    JFrame frame = new JFrame();
    JButton loginButton = new JButton("Login");
    JButton addUserButton = new JButton("New User");
    JButton resetButton = new JButton("Reset");
    JTextField userIDField = new JTextField();
    JPasswordField userPasswordField = new JPasswordField();
    JLabel userIDLabel = new JLabel("User ID :");
    JLabel userPasswordLabel = new JLabel("Password :");
    JLabel messgaLabel = new JLabel();

    HashMap<String, String> loginInfo = new HashMap<String, String>();

    LoginPage(HashMap<String, String> loginInfoOriginal) {
        loginInfo = loginInfoOriginal;

        // Creating the frames for userid, pass and message
        userIDLabel.setBounds(50, 100, 75, 25);
        userPasswordLabel.setBounds(50, 150, 75, 25);
        messgaLabel.setBounds(125, 250, 250, 35);
        messgaLabel.setFont(new Font(null, Font.ITALIC, 25));
        userIDField.setBounds(125, 100, 200, 25);
        userPasswordField.setBounds(125, 150, 200, 25);

        // Creating login, reset and new user button and adding action listner to the
        // buttons
        loginButton.setBounds(55, 200, 100, 25);
        loginButton.addActionListener(this);
        loginButton.setFocusable(false);
        resetButton.setBounds(155, 200, 100, 25);
        resetButton.addActionListener(this);
        resetButton.setFocusable(false);
        addUserButton.setBounds(255, 200, 100, 25);
        addUserButton.addActionListener(this);
        addUserButton.setFocusable(false);

        // Adding the elements to the frame
        frame.add(userIDLabel);
        frame.add(userPasswordLabel);
        frame.add(messgaLabel);
        frame.add(userIDField);
        frame.add(userPasswordField);
        frame.add(loginButton);
        frame.add(resetButton);
        frame.add(addUserButton);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420, 420);
        frame.setLocationRelativeTo(null);
        frame.setLayout(null);
        frame.setVisible(true);
    }

    // Addding functionality to the buttons
    @Override
    public void actionPerformed(ActionEvent e) {

        // Reset button
        if (e.getSource() == resetButton) {
            userIDField.setText("");
            userPasswordField.setText("");
        }

        // Login button
        if (e.getSource() == loginButton) {
            String userID = userIDField.getText();
            String password = String.valueOf(userPasswordField.getPassword());

            if (loginInfo.containsKey(userID)) {
                if (loginInfo.get(userID).equals(password)) {
                    messgaLabel.setForeground(Color.green);
                    messgaLabel.setText("Login successful !!!");
                    frame.dispose();
                    new TextEditor();

                } else {
                    messgaLabel.setForeground(Color.red);
                    messgaLabel.setText("Wrong password !!!");
                }
            } else {
                messgaLabel.setForeground(Color.red);
                messgaLabel.setText("Username not found !!!");
            }
        }

        // Add a new user button
        if(e.getSource()==addUserButton){
            frame.dispose();
            new AddNewUser();
        }
    }
}
