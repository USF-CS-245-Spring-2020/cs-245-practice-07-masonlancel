public class ArrayStack<T> implements Stack<T>{

	T [] array = (T[]) new Object[10];;
	int top = 0;

	private void growArray(){
		T [] tempArray = (T[]) new Object[array.length*2];
		for(int i = 0; i < array.length; i++)
			tempArray[i] = array[i];
		array = tempArray;
	}

	public void push(T item){
		if(top == array.length)
			growArray();
		array[top] = item;
		top++;
		
	}
	public T pop() throws Exception{
		if(top <= 0)
			throw new IndexOutOfBoundsException();
		T itemRemoved = array[top-1];
		top--;
		return itemRemoved;
	}
	public T peek() throws Exception{
		if(empty())
			throw new IndexOutOfBoundsException();
		return array[top];
	}
	public boolean empty(){
		return top == 0;
	}
}