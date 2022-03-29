import java.text.DecimalFormat;
import java.util.Comparator;
import java.util.PriorityQueue;
//This class for implementation of priority queue.
public class Queue implements IQueue 
{	
	//Here the queue object.
	private java.util.Queue contents;
	//Here the comparator
	public Queue(Comparator comp){
		contents = new PriorityQueue(comp);
	}
	//Enqueue operation
	@Override
	public void enqueue(Object item) {
		contents.add(item);
	}
	//Peek method
	@Override
	public Object peek() throws QueueEmpty {
		if (isEmpty())
			throw new QueueEmpty();

		return contents.peek();
	}
	//Dequeue method
	@Override
	public Object dequeue() throws QueueEmpty {
		if (isEmpty())
			throw new QueueEmpty();

		return contents.poll();
	}
	//Checks is empty or not
	@Override
	public boolean isEmpty() {
		return contents.size() == 0;
	}
	//Convert queue to string
	@Override
	public String toString(){
		int size = contents.size();
        String retString ="";
        
        if(contents.getClass().getName().equals("java.util.LinkedList")){
        	Object[] tempArr = contents.toArray();
     
        	for(int i=0; i<size; i++){
    			retString += tempArr[i] + "\n";
    		}
        }
        else{
        	int currOrder = 0;
        	PriorityQueue<User> temp_pq= new PriorityQueue<User>(contents);
        	retString+="Order\tUsername       Progress Score \n";
        	while(!temp_pq.isEmpty() && currOrder<3){
        		User  currUser=  temp_pq.poll();
        		String spaceVal ="";
        	   for (int i = 0 ; i < 20-currUser.getUsername().length(); i++) {
        			
        			spaceVal+=" ";
				}
        		retString += ++currOrder + ")" +"\t"+currUser.getUsername() +spaceVal+new DecimalFormat("#0.000").format(currUser.getProgressScore())+"\n";
        	}
        }        
		return retString;
	}
}