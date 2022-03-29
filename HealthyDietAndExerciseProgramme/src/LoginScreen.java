import java.awt.EventQueue;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.awt.Font;
/*
 * This class created for login screen which allows to user sign up, sign in, show and hide password selection.
 * This is very very first screen for user. When program runs, this main works and depending on the user selection navigates sign in or sign up screen.
 * When user correctly input data user name and password, the user is navigated to main screen by this class 
 * and at the other hand user is warned by error messages.
 * Otherwise, if user selects sign up, this class navigates sign up screen.
 * Thanks to hide and show password button users are able to hide their password for security.
*/

public class LoginScreen {

	// Attributes
	private JFrame loginScreen;
	private JTextField username;
	private JPasswordField passwordUnvisible;
	private JTextField passwordVisible;
	private static LoginScreen loginWindow;
	private JTextArea usernameErrorMessage;
	private JTextArea passwordErrorMessage;
	
	// This is our program's main
	public static void main(String[] args) throws FileNotFoundException {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					loginWindow = new LoginScreen();
					loginWindow.loginScreen.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	// Constructor
	public LoginScreen() {
		initialize();
		passwordVisible.setVisible(false);
		passwordUnvisible.setVisible(true);
	}	
	// Here initialized login screen with creating objects from related classes and visualization library called as JSwing.
	private void initialize() {
		//Here the Frame defined 
		loginScreen = new JFrame();
		loginScreen.setTitle("HEALTHY DIET AND EXERCISE");
		loginScreen.setBounds(700, 350, 452, 316);
		loginScreen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		loginScreen.getContentPane().setLayout(null);
		
		
		//Here the programs centerly displayed tag defined as Textarea.
		JTextArea programName = new JTextArea();
		programName.setEditable(false);
		programName.setFont(new Font("MV Boli", Font.PLAIN, 10));
		programName.setBackground(new Color(221,40,40));
		programName.setForeground(new Color (255,255,255));
		programName.setText("    HEALTHY DIET & \r\nEXERCISE PROGRAMME ");
		programName.setBounds(169, 35, 127, 38);
		loginScreen.getContentPane().add(programName);
		//Here the programs username textarea defined.
		username = new JTextField();
		username.setBounds(210, 125, 116, 22);
		loginScreen.getContentPane().add(username);
		username.setColumns(10);
		
		//Here the username panel defined.
		JTextArea usernamePanel = new JTextArea();
		usernamePanel.setFont(new Font("MV Boli", Font.PLAIN, 14));
		usernamePanel.setBackground(new Color(230,230,230));
		usernamePanel.setText(" UserName");
		usernamePanel.setBounds(110, 123, 88, 25);
		loginScreen.getContentPane().add(usernamePanel);
		//Here the password panel  defined. 
		JTextArea passwordPanel = new JTextArea();
		passwordPanel.setFont(new Font("MV Boli", Font.PLAIN, 14));
		passwordPanel.setBackground(new Color(230,230,230));
		passwordPanel.setText(" Password");
		passwordPanel.setBounds(110, 161, 88, 25);
		loginScreen.getContentPane().add(passwordPanel);
		//Here the sign in button defined.
		JButton signInButton = new JButton("Sign In");
		signInButton.setBounds(110, 204, 97, 25);
		loginScreen.getContentPane().add(signInButton);
		//Here the action listener includes controls by the order.Then if all requirements provided given data send through
		//methods for Sign In Operations.
		signInButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				SignInToMain sgn = null;
				SignInToMain sgnVis = null;
				try {
					//First condition where user enters password in visible form. 
					if (passwordVisible.isVisible()) {
						sgn = new SignInToMain(username.getText(), passwordVisible.getText());
						//Here the sign in checks completed with returned boolean value.
						if (sgn.fromSignInToMainGaneralChecker(username.getText(), passwordVisible.getText())) {
							try {
								ReadFile rdf = new ReadFile();

								if (rdf.readFileForExistUser(username.getText(), passwordVisible.getText())) {
									MainScreen masn = new MainScreen(rdf.getCurrentOnlineUser());
									loginWindow.loginScreen.dispose();
								}

							} catch (Exception e) {
								e.printStackTrace();
							}
							//Here the sign in checks error messages displayed in text areas.
						} else {
							usernameErrorMessage.setText(sgn.getUserWarning());
							passwordErrorMessage.setText(sgn.getPasswordWarning());
						}
						//Second condition where user enters password in invisible form.
					} else {
						sgnVis = new SignInToMain(username.getText(), String.valueOf(passwordUnvisible.getPassword()));
						//Here the sign in checks completed with returned boolean value.
						if (sgnVis.fromSignInToMainGaneralChecker(username.getText(),String.valueOf(passwordUnvisible.getPassword()))) {
							ReadFile rdfUnvis = new ReadFile();
							if (rdfUnvis.readFileForExistUser(username.getText(),String.valueOf(passwordUnvisible.getPassword()))) {
								MainScreen masn = new MainScreen(rdfUnvis.getCurrentOnlineUser());
								loginWindow.loginScreen.dispose();
							}

						}
						//Here the sign in checks error messages displayed in text areas.
						 else {
								usernameErrorMessage.setText(sgnVis.getUserWarning());
								passwordErrorMessage.setText(sgnVis.getPasswordWarning());
						}
					}

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		//Here the sign up button defined.
		JButton signUpButton = new JButton("Sign Up ");
		signUpButton.setBounds(226, 204, 97, 25);
		loginScreen.getContentPane().add(signUpButton);
		//Here the unvisible password field defined.
		passwordUnvisible = new JPasswordField();
		passwordUnvisible.setBounds(210, 163, 116, 22);
		loginScreen.getContentPane().add(passwordUnvisible);
		
		//Here the visible password field defined.
		passwordVisible = new JTextField();
		passwordVisible.setBounds(210, 163, 116, 22);
		loginScreen.getContentPane().add(passwordVisible);
		passwordVisible.setColumns(10);
		//Here the Show/Hide password button defined.
		Icon iconEye = new ImageIcon("Images/SystemImages/smallEyeIco.png");
		JButton showPassword = new JButton(iconEye);
		showPassword.setFont(new Font("Tahoma", Font.PLAIN, 6));
		showPassword.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//This statements are for two conditions in password field visible to unvisible , unvisible to visible.
				//So when one of those operation occured the data with in the text field must be carried to another.So
				//this method helps to provide that.
				if(passwordUnvisible.isVisible()) {
					passwordVisible.setText(String.valueOf(passwordUnvisible.getPassword()));
					passwordVisible.setVisible(true);
					passwordUnvisible.setVisible(false);
				}
				else {	
					
					passwordUnvisible.setText(passwordVisible.getText());
					passwordVisible.setVisible(false);
					passwordUnvisible.setVisible(true);
				}
			}
		});
		showPassword.setBounds(338, 164, 39, 22);
		loginScreen.getContentPane().add(showPassword);
		//Here the background image defined that settled into login screen.
		ImageIcon imageIconBack = new ImageIcon("Images/SystemImages/loginScreenBackImage.png");
	    JLabel labelLoginBack = new JLabel(imageIconBack);
	    labelLoginBack.setBounds(0, 0, 432, 269);
		loginScreen.getContentPane().add(labelLoginBack);
		//Username related error messages text ares defined here.
		usernameErrorMessage = new JTextArea();
		usernameErrorMessage.setEditable(false);
		usernameErrorMessage.setBackground(SystemColor.control);
		usernameErrorMessage.setBounds(110, 148, 238, 15);
		loginScreen.getContentPane().add(usernameErrorMessage);
		//Password related error messages text ares defined here.
		passwordErrorMessage = new JTextArea();
		passwordErrorMessage.setEditable(false);
		passwordErrorMessage.setBackground(SystemColor.control);
		passwordErrorMessage.setBounds(110, 188, 228, 16);
		loginScreen.getContentPane().add(passwordErrorMessage);
		//When user selects sign up , following action listener becomes active then navigates through register screen.
		signUpButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					RegisterScreen rgstscrn = new RegisterScreen();
					loginWindow.loginScreen.setVisible(false);
					
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		});
		
	}
}