
import java.util.Comparator;

public class LeaderComparator implements Comparator<User> {
	@Override
	public int compare(User o1, User o2){
			//Weight comparisons defined here  		
		return Double.compare(o2.getProgressScore(),o1.getProgressScore() );	
	
	}
}