import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class AddNewUser implements ActionListener {

    JFrame frame = new JFrame();
    JButton saveButton = new JButton("Save");
    JButton goToLoginButton = new JButton("Go to Login");
    JTextField userIDField = new JTextField();
    JPasswordField userPasswordField = new JPasswordField();
    JLabel userIDLabel = new JLabel("Craete UserID:");
    JLabel userPasswordLabel = new JLabel("Set Password:");
    JLabel messgaLabel = new JLabel();

    AddNewUser() {

        // Creating the frames for userid, pass and message
        userIDLabel.setBounds(50, 100, 75, 25);
        userPasswordLabel.setBounds(50, 150, 75, 25);
        userIDField.setBounds(125, 100, 200, 25);
        userPasswordField.setBounds(125, 150, 200, 25);

        // Creating save and go to Login button and adding action listner to the
        saveButton.setBounds(125, 200, 100, 25);
        saveButton.addActionListener(this);
        saveButton.setFocusable(false);
        goToLoginButton.setBounds(225, 200, 100, 25);
        goToLoginButton.addActionListener(this);
        goToLoginButton.setFocusable(false);

        // Adding the elements to the frame
        frame.add(saveButton);
        frame.add(goToLoginButton);
        frame.add(userIDLabel);
        frame.add(userPasswordLabel);
        frame.add(userIDField);
        frame.add(userPasswordField);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420, 420);
        frame.setLocationRelativeTo(null);
        frame.setLayout(null);
        frame.setVisible(true);
    }

    // Addding functionality to the buttons
    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == saveButton) {
            frame.dispose();
            IDandPasswords IdPass = new IDandPasswords();
            IdPass.loginInfo.put(userIDField.getText(), String.valueOf(userPasswordField.getPassword()));
            LoginPage loginpage = new LoginPage(IdPass.getLoginInfo());
        }
        if (e.getSource() == goToLoginButton) {
            frame.dispose();
            IDandPasswords IdPass = new IDandPasswords();
            LoginPage loginpage = new LoginPage(IdPass.getLoginInfo());
        }
    }
}
