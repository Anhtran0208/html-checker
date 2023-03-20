public interface Queue<E> {
	public void enqueue(E obj); 
	public E peek();
	public E dequeue();
	public boolean isEmpty();
	public String toString();
}
