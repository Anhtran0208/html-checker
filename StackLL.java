public class StackLL<E> implements Stack<E> {
	private LinkedList<E> stackData;

	public StackLL() {
		stackData = new LinkedList<>();
	}

  @Override
  public void push(E item) {
    stackData.add(0, item);
  }

  @Override
  public E pop() {
    return stackData.delete(0);
  }

  @Override
  public E peek() {
    return stackData.get(0);
  }

  @Override
  public boolean isEmpty(){
    return stackData.isEmpty();
  }

  @Override
  public String toString(){
    return stackData.toString();
  }
}