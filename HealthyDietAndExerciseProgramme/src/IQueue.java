//This interface created for Queue implementation.
public interface IQueue 
{ 
	//Enqueue method declared.
	public void enqueue(Object item);
	//Peek method declared with Exception.
	public Object peek() throws QueueEmpty;
	//Dequeue method declared with Exception.
	public Object dequeue() throws QueueEmpty;
	//Is empty method declared.
	public boolean isEmpty();

}
