public class ArrayQueue<T> implements Queue<T>{

	T [] array;
	int back = 0;
	int front = 0;
	int capacity = 0;

	public ArrayQueue(){
		array = (T[]) new Object[10];
	}

	public T dequeue() throws Exception{
		if(empty())
			throw new IndexOutOfBoundsException();
		T dataRemoved = array[front];
		front++;
		capacity--;
		return dataRemoved;
	}

	public void growArray(){
		T [] tempArray = (T[]) new Object[array.length*2];
		for (int i = 0; i <= capacity; i++) {
            tempArray[i] = array[(front + i) % array.length];
        }
		front = 0;
		back = capacity;
		array = tempArray;
	}

	public void enqueue(T item){
		if(capacity == array.length)
			growArray();
		array[(back%array.length)] = item;
		back++;
		capacity++;
	}

	public boolean empty(){
		if(capacity == 0)
			return true;
		return false;
	}
}