import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import java.io.IOException;
import java.text.DecimalFormat;
import javax.swing.JScrollPane;
/*
 * This class created for displaying user' data which are:
 * profile photo,user name,gender,age,height,current weight,begin weight,target weight,BMI,daily calory need,
 * daily sleep need,daily water need,nutritional disease,diet selection,progress score,saved menu.
 */
public class PersonalProfile extends JFrame {
	
	// Attribute
	private JPanel contentPane;
	
	// This method displays personal profile data
	public void initPersonalProfile(User currUser) throws IOException {
		//Here the panel defined.
		setBounds(100, 100, 527, 646);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		//Here the personal profile photo icon called and defined.
		Icon personalProfilePhotoIco = new ImageIcon("Images/UserProfileImages/"+currUser.getUsername()+".jpg");
		JButton userProfilePhoto= new JButton(personalProfilePhotoIco);
		userProfilePhoto.setBounds(29, 32, 186, 200);
		contentPane.add(userProfilePhoto);
		//Here the personal username text area defined to display description what is showing at the left.
		JTextArea txtrUsername = new JTextArea();
		txtrUsername.setEditable(false);
		txtrUsername.setFont(new Font("Monospaced", Font.PLAIN, 12));
		txtrUsername.setText("Username :");
		txtrUsername.setBounds(241, 92, 81, 21);
		contentPane.add(txtrUsername);
		//Here the personal username area defined.
		JTextArea textUserNameS = new JTextArea();
		textUserNameS.setText(currUser.getUsername());
		textUserNameS.setEditable(false);
		textUserNameS.setBounds(334, 92, 112, 21);
		contentPane.add(textUserNameS);
		//Here the Personal Profile header added.
		JTextArea txtrPersonalProfile = new JTextArea();
		txtrPersonalProfile.setFont(new Font("Monospaced", Font.BOLD, 16));
		txtrPersonalProfile.setText("Personal Profile");
		txtrPersonalProfile.setBounds(270, 32, 177, 26);
		contentPane.add(txtrPersonalProfile);
		//Here the gender explanation added.
		JTextArea txtrGender = new JTextArea();
		txtrGender.setEditable(false);
		txtrGender.setText("Gender :");
		txtrGender.setFont(new Font("Monospaced", Font.PLAIN, 12));
		txtrGender.setBounds(241, 134, 81, 21);
		contentPane.add(txtrGender);
		//Here the users age added.
		JTextArea txtrAge = new JTextArea();
		txtrAge.setEditable(false);
		txtrAge.setText("Age :");
		txtrAge.setFont(new Font("Monospaced", Font.PLAIN, 12));
		txtrAge.setBounds(241, 168, 81, 21);
		contentPane.add(txtrAge);
		//Here the Height explanation added.
		JTextArea txtrHeight = new JTextArea();
		txtrHeight.setEditable(false);
		txtrHeight.setText("Height :");
		txtrHeight.setFont(new Font("Monospaced", Font.PLAIN, 12));
		txtrHeight.setBounds(241, 211, 81, 21);
		contentPane.add(txtrHeight);
		//Here the users gender added.
		JTextArea textGenderS = new JTextArea();
		textGenderS.setText(currUser.getGender());
		textGenderS.setEditable(false);
		textGenderS.setBounds(334, 134, 112, 21);
		contentPane.add(textGenderS);
		//Here the users age added.
		JTextArea textAgeS = new JTextArea();
		textAgeS.setText(Integer.toString(currUser.getAge()));
		textAgeS.setEditable(false);
		textAgeS.setBounds(334, 168, 112, 21);
		contentPane.add(textAgeS);
		//Here the users Height added.
		JTextArea textHeightS = new JTextArea();
		textHeightS.setText(Integer.toString(currUser.getHeight()));
		textHeightS.setEditable(false);
		textHeightS.setBounds(334, 211, 112, 21);
		contentPane.add(textHeightS);
		//Here the users sleep need added.
		JTextArea textSleepNeedS = new JTextArea();
		textSleepNeedS.setText(Double.toString(currUser.getSleepingTime()));
		textSleepNeedS.setEditable(false);
		textSleepNeedS.setBounds(160, 376, 112, 21);
		contentPane.add(textSleepNeedS);
		//Here the users BMI added.
		JTextArea textBMIS = new JTextArea();
		textBMIS.setText(Double.toString(currUser.getBmi()));
		textBMIS.setEditable(false);
		textBMIS.setBounds(160, 342, 112, 21);
		contentPane.add(textBMIS);
		
		//Here the users Current Weight added.
		JTextArea textCurrentWeightS = new JTextArea();
		textCurrentWeightS.setText(Double.toString(currUser.getCurrentWeight()));
		textCurrentWeightS.setEditable(false);
		textCurrentWeightS.setBounds(150, 279, 112, 21);
		contentPane.add(textCurrentWeightS);
		
		//Here the users Begin Weight added.
		JTextArea textBeginWeightS = new JTextArea();
		textBeginWeightS.setText(Double.toString(currUser.getBeginWeight()));
		textBeginWeightS.setEditable(false);
		textBeginWeightS.setBounds(150, 245, 112, 21);
		contentPane.add(textBeginWeightS);
		
		//Here the users Begin Weight explanation added.
		JTextArea txtrBeginWeight = new JTextArea();
		txtrBeginWeight.setEditable(false);
		txtrBeginWeight.setText("Begin Weight :");
		txtrBeginWeight.setFont(new Font("Monospaced", Font.PLAIN, 12));
		txtrBeginWeight.setBounds(29, 245, 102, 21);
		contentPane.add(txtrBeginWeight);
		
		//Here the users Current Weight explanation added.
		JTextArea txtrCurrenWeight = new JTextArea();
		txtrCurrenWeight.setEditable(false);
		txtrCurrenWeight.setText("Current Weight : ");
		txtrCurrenWeight.setFont(new Font("Monospaced", Font.PLAIN, 12));
		txtrCurrenWeight.setBounds(29, 276, 112, 21);
		contentPane.add(txtrCurrenWeight);
		
		//Here the users BMI added.
		JTextArea txtrBodyMassIndex = new JTextArea();
		txtrBodyMassIndex.setEditable(false);
		txtrBodyMassIndex.setText("Body Mass Index :");
		txtrBodyMassIndex.setFont(new Font("Monospaced", Font.PLAIN, 12));
		txtrBodyMassIndex.setBounds(29, 342, 124, 21);
		contentPane.add(txtrBodyMassIndex);
		
		//Here the users Daily Sleep Need added.
		JTextArea txtrSleepNeed = new JTextArea();
		txtrSleepNeed.setEditable(false);
		txtrSleepNeed.setText("Sleep Need :");
		txtrSleepNeed.setFont(new Font("Monospaced", Font.PLAIN, 12));
		txtrSleepNeed.setBounds(29, 376, 88, 21);
		contentPane.add(txtrSleepNeed);
		//Here the users Daily Calory Need explanation added.
		JTextArea txtrDailyCaloriNeed = new JTextArea();
		txtrDailyCaloriNeed.setEditable(false);
		txtrDailyCaloriNeed.setText("Daily Calori Need :");
		txtrDailyCaloriNeed.setFont(new Font("Monospaced", Font.PLAIN, 12));
		txtrDailyCaloriNeed.setBounds(29, 410, 137, 21);
		contentPane.add(txtrDailyCaloriNeed);
		//Here the users Daily Water Need explanation added.
		JTextArea txtrDailyWaterNeed = new JTextArea();
		txtrDailyWaterNeed.setEditable(false);
		txtrDailyWaterNeed.setText("Daily Water Need :");
		txtrDailyWaterNeed.setFont(new Font("Monospaced", Font.PLAIN, 12));
		txtrDailyWaterNeed.setBounds(29, 452, 130, 21);
		contentPane.add(txtrDailyWaterNeed);
		//Here the users Nutritional Disease explanation added.
		JTextArea txtrNutritionalDisase = new JTextArea();
		txtrNutritionalDisase.setEditable(false);
		txtrNutritionalDisase.setText("Nutritional Disase :");
		txtrNutritionalDisase.setFont(new Font("Monospaced", Font.PLAIN, 12));
		txtrNutritionalDisase.setBounds(29, 486, 144, 21);
		contentPane.add(txtrNutritionalDisase);
		//Here the users Diet Selection explanation added.
		JTextArea txtrDietSelection = new JTextArea();
		txtrDietSelection.setEditable(false);
		txtrDietSelection.setText("Diet Selection :");
		txtrDietSelection.setFont(new Font("Monospaced", Font.PLAIN, 12));
		txtrDietSelection.setBounds(29, 529, 117, 21);
		contentPane.add(txtrDietSelection);
		
		//Here the users daily calory need added.
		JTextArea textCaloriNeedS = new JTextArea();
		textCaloriNeedS.setText(Integer.toString(currUser.getDailyCaloryNeed()));
		textCaloriNeedS.setEditable(false);
		textCaloriNeedS.setBounds(177, 410, 112, 21);
		contentPane.add(textCaloriNeedS);
		
		//Here the users daily water need added.
		JTextArea textWaterNeedS = new JTextArea();
		textWaterNeedS.setText(Double.toString(currUser.getDailyWaterNeed()));
		textWaterNeedS.setEditable(false);
		textWaterNeedS.setBounds(177, 456, 112, 21);
		contentPane.add(textWaterNeedS);

		//Here the users nutritional disease added.
		JTextArea textNutritionalDisS = new JTextArea();
		textNutritionalDisS.setText(nutriDiseInterp(currUser.getNutritionDisese()));
		textNutritionalDisS.setEditable(false);
		textNutritionalDisS.setBounds(177, 486, 124, 21);
		contentPane.add(textNutritionalDisS);
		
		//Here the users diet selection added.
		JTextArea textDietSelectionS = new JTextArea();
		textDietSelectionS.setText(dietSelecInterpret(currUser.getDietSelection()));
		textDietSelectionS.setEditable(false);
		textDietSelectionS.setBounds(150, 529, 112, 21);
		contentPane.add(textDietSelectionS);
		//Here the users saved menu added.
		JTextArea txtrSavedMenu = new JTextArea();
		txtrSavedMenu.setFont(new Font("MV Boli", Font.PLAIN, 12));
		txtrSavedMenu.setText("   Saved Menu");
		txtrSavedMenu.setEditable(false);
		txtrSavedMenu.setBounds(334, 246, 112, 21);
		contentPane.add(txtrSavedMenu);
	    
		//Here the users saved menu header.
		JTextArea textSavedMenuS = new JTextArea();
		textSavedMenuS.setEditable(false);
		textSavedMenuS.setText(getSavedMenuById(currUser.getMenuID()));
	
		//Here the users progress score explanation added.
		JTextArea txtrProgressScore = new JTextArea();
		txtrProgressScore.setText("   Progress Score");
		txtrProgressScore.setFont(new Font("MV Boli", Font.PLAIN, 12));
		txtrProgressScore.setEditable(false);
		txtrProgressScore.setBounds(352, 497, 112, 21);
		contentPane.add(txtrProgressScore);
		
		//Here the users progress score added.
		JTextArea textProgressScoreS = new JTextArea();
		textProgressScoreS.setText(new DecimalFormat("#0.000").format(currUser.getProgressScore()));
		textProgressScoreS.setEditable(false);
		textProgressScoreS.setBounds(320, 518, 177, 32);
		contentPane.add(textProgressScoreS);
		
		//Here the users target weight explanation added.
		JTextArea txtrTargetWeight = new JTextArea();
		txtrTargetWeight.setText("Target Weight :");
		txtrTargetWeight.setFont(new Font("Monospaced", Font.PLAIN, 12));
		txtrTargetWeight.setEditable(false);
		txtrTargetWeight.setBounds(29, 310, 124, 21);
		contentPane.add(txtrTargetWeight);
		
		//Here the users target weight added.
		JTextArea textTargetWeightS = new JTextArea();
		textTargetWeightS.setText(Double.toString(currUser.getTargetWeight()));
		textTargetWeightS.setEditable(false);
		textTargetWeightS.setBounds(160, 310, 112, 21);
		contentPane.add(textTargetWeightS);
		//Here the scrool look added.
		JScrollPane scrollPaneOfSavedMenu = new JScrollPane(textSavedMenuS);
		scrollPaneOfSavedMenu.setBounds(320, 279, 177, 164);
		contentPane.add(scrollPaneOfSavedMenu);
		
		
	}
	
	// This method for interpreting user' nutritional disease from numeric values to string values from text file
	private String nutriDiseInterp(int diseaseIndex) {
		if(diseaseIndex==0) {
			return "No Disease";
		}
		else if (diseaseIndex == 1) {
			return "Diabetes";
		}
		else if(diseaseIndex == 2) {
			return "Celiac";
		}
		else {
			return "Reflux";
		}
	}
	
	// This method for interpreting user' diet selection from numeric values to string values from text file
	private String dietSelecInterpret(int dietIndex) {
		if(dietIndex==0) {
			return "Normal";
		}
		else if(dietIndex ==1) {
			return "Vegeterian";
		}
		else {
			return "Vegan";
		}
	}
	
	// This method for interpreting user' saved menu from numeric values to string values from text file
	private String getSavedMenuById(int menuID) throws IOException {
		ReadFile rdf = new ReadFile();
		return rdf.userSavedMenuReaded(menuID);
	}
}
