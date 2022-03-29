import java.awt.Font;
import java.awt.SystemColor;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.file.Files;
import java.nio.file.Paths;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
/*
 * This class created for sorting users depending or their progress score and program selection.
 * And displays leader board.
*/
@SuppressWarnings("serial")
public class LeaderBoard extends JFrame {

	// Attribute
	private JPanel contentPane;

	// Displays leader board screen.
	public void showLeaderBoard(int selection) throws UnsupportedEncodingException, FileNotFoundException  {
		contentPane = new JPanel();
		contentPane.setLayout(null);
		setBounds(100, 100, 520, 250);
		this.setVisible(true);
		JTextArea textArea = new JTextArea();
		textArea.setBackground(SystemColor.inactiveCaptionBorder);
		textArea.setFont(new Font("Monospaced", Font.PLAIN, 17));
		textArea.setEditable(false);
		textArea.setBounds(44, 61, 450 , 115);
		contentPane.add(textArea);
		
		JTextArea txtrLeaderBoard = new JTextArea();
		txtrLeaderBoard.setBackground(SystemColor.inactiveCaptionBorder);
		txtrLeaderBoard.setEditable(false);
		txtrLeaderBoard.setFont(new Font("Cooper Std Black", Font.PLAIN, 14));
		txtrLeaderBoard.setText("LEADER BOARD");
		txtrLeaderBoard.setBounds(152, 32, 128, 16);
		contentPane.add(txtrLeaderBoard);
		
		Queue leaderQ = new Queue(new LeaderComparator());
		try (BufferedReader readerDelimiter = Files.newBufferedReader(Paths.get("TextFiles/userDataRepository.txt"))) {
            String str;
            int temp=0;
            while ((str = readerDelimiter.readLine()) != null) {
            	if(temp!=0) {
	            	String[] arr=str.split(";");
	            	if (Integer.parseInt(arr[2])==selection) {	
	            		
		            	if(selection==2) {
		            		
							String[] date = arr[3].split("-");
							String[] beginDay = date[0].split("\\.");
							String[] endDay = date[1].split("\\.");
							
							Date beginDate = new Date(Integer.parseInt(beginDay[0]), Integer.parseInt(beginDay[1]),Integer.parseInt(beginDay[2]));
							Date endDate = new Date(Integer.parseInt(endDay[0]), Integer.parseInt(endDay[1]),Integer.parseInt(endDay[2]));
							
							User user  = new User(arr[0], arr[1],Integer.parseInt(arr[2]), beginDate, endDate,Double.parseDouble(arr[4]), Integer.parseInt(arr[5]),
									Integer.parseInt(arr[6]), arr[7],Integer.parseInt(arr[8]), Integer.parseInt(arr[9]));

							leaderQ.enqueue(user);
							
						} else {
							String[] date = arr[3].split("-");
							String[] beginDay2 = date[0].split("\\.");
							String[] endDay2 = date[1].split("\\.");
							
							Date bgnDate = new Date(Integer.parseInt(beginDay2[0]), Integer.parseInt(beginDay2[1]),Integer.parseInt(beginDay2[2]));
							Date endDate = new Date(Integer.parseInt(endDay2[0]), Integer.parseInt(endDay2[1]),Integer.parseInt(endDay2[2]));
							
							String[] weight = arr[4].split("-");
							User user = new User(arr[0], arr[1],Integer.parseInt(arr[2]), bgnDate, endDate,Double.parseDouble(weight[0]),Double.parseDouble( weight[1]),
									Integer.parseInt(arr[5]), Integer.parseInt(arr[6]),arr[7], Integer.parseInt(arr[8]),Integer.parseInt(arr[9]));
							
							leaderQ.enqueue(user);
		        		}
	            	}
            	}
            	temp++;
            }
            textArea.setText(leaderQ.toString());
          }
		catch (IOException e) {
	        System.err.format("IOException: %s%n", e);
	    }
		setContentPane(contentPane);
	}
}
