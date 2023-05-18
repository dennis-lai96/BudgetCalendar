import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI extends JFrame {
    private JTextField transactionTextField;

    public GUI(Client client) {
        LoginPage loginPage = new LoginPage();
        if (loginPage.authenticate()) {
            // Proceed with the main application
            initializeComponents();
        } else {
            JOptionPane.showMessageDialog(null, "Invalid username or password. Exiting the application.");
            System.exit(0);
        }
    }

    private void initializeComponents() {
        // Initialize the GUI 
        transactionTextField = new JTextField();
    }

    private class LoginPage extends JFrame {
        private JTextField usernameField;
        private JPasswordField passwordField;

        public LoginPage() {
            setTitle("Login");
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setSize(300, 200);
            setLocationRelativeTo(null);

            JPanel panel = new JPanel(new GridLayout(3, 2, 10, 10));
            panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

            JLabel usernameLabel = new JLabel("Username:");
            JLabel passwordLabel = new JLabel("Password:");

            usernameField = new JTextField();
            passwordField = new JPasswordField();

            JButton loginButton = new JButton("Login");
            loginButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String username = usernameField.getText();
                    String password = new String(passwordField.getPassword());

                    // Check credentials
                    if (username.equals("admin") && password.equals("password")) {
                        JOptionPane.showMessageDialog(null, "Login Successful");
                        setVisible(false);
                    } else {
                        JOptionPane.showMessageDialog(null, "Invalid username or password");
                    }
                }
            });

            panel.add(usernameLabel);
            panel.add(usernameField);
            panel.add(passwordLabel);
            panel.add(passwordField);
            panel.add(loginButton);

            add(panel);
            setVisible(true);
        }

        public boolean authenticate() {
            return true; 
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new GUI(new Client("John Doe", 0));
            }
        });
    }
}
