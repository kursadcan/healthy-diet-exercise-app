import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
//This class displays personalised exerciese as gif 
@SuppressWarnings("serial")
public class PersonalisedExercises extends JFrame {
	//Here the attributes
	public int counter =1;
	public JFrame myFramef = new JFrame("EXERCISES");
	//Program selection related gif displayer
	public void programmeSelection(int selection) {	
		if(selection==0)
			showExercises("lose_weight.gif");
		else if(selection==1)
			showExercises("gain_weight.gif");
		else if(selection==2)
			showExercises("keep_fit.gif");
 	}
	//Calls gifs from file
 	public void showExercises(String gif) {
        ImageIcon imageIcon = new ImageIcon("Gifs/"+gif);
        JLabel label = new JLabel(imageIcon);
        myFramef.getContentPane().add(label);
        myFramef.pack();
        myFramef.setLocationRelativeTo(null);
        myFramef.setVisible(true);
 	}
}
