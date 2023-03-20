public class QueueLL<E> implements Queue<E>{
	private LinkedList<E> queueData;

	public QueueLL(){
		queueData = new LinkedList<E>();
	}
	public void enqueue(E obj){
		queueData.add(queueData.size(), obj);
	}
	public E peek(){
		return queueData.get(0);
	}
	public E dequeue(){
		return queueData.delete(0);
	}
	public boolean isEmpty(){
    	return queueData.isEmpty();
	}
	public String toString(){
    	return queueData.toString();
	}
}
