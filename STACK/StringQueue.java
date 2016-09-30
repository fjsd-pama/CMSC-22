import java.util.*;

/**
* by Miguel Carlo Fernandez, Jose Arniel Pama, & Frank Okiya @9/27/2016
*/

public class StringQueue{
	private String[] elements;		
	private int size;
	private int count = 0;
	private static final int DEFAULT_SIZE = 10;

	private void checkOutOfBounds(){
		if (count < 0 || count >= size){
			throw new ArrayIndexOutOfBoundsException("Oops, out of bounds");
		}
	}

	private void shiftElementsleft(){
		for(int i = 0; i < count; i++){

		}
	}
	public StringQueue(){
		this(DEFAULT_SIZE);
	}

	public StringQueue(int size){
		this.size = size;
		elements = new String[size];
		checkOutOfBounds();
	}

	public int size(){
		return count;
	}

	public void enqueue(String s){
		resizeArray();
		String[] elCopy = elements;
		count++;
		elements = new String[count];
		for (int i = 0; i < (count - 1); i++){
			elements[i + 1] = elCopy[i];
		}
		elements[0] = s;
	}

	public String dequeue(){
		checkOutOfBounds();
		return elements[--count];
	}

	public String dequeue(int n){
		if (count < 0 || n > count){	
			throw new ArrayIndexOutOfBoundsException("Oops, out of bounds");
		}
		count -= n;
		return elements[--count];
	}

	public String peek(){
		checkOutOfBounds();
		return elements[0];
	}

	public String toString(){
		String result = "";

		for (int i = count - 1; i > 0; i--){
			result += (elements[i] + ", ");
		}
		result += elements[0];
		return result;
	}

	private void resizeArray(){
		if (count + 2 >= elements.length){
			size += 5;
			elements = Arrays.copyOf(elements, size);
		}
	}

	// public void singit(int index, String item){
	// 	resizeArray();
	// 	String[] elCopy = elements;
	// 	count++;
	// 	elements = new String[count];
	// 	for (int i = 0; i < index; i++){
	// 		elements[i] = elCopy[i];
	// 	}

	// 	//shifts item to the right
	// 	for (int j = (index - 1); j < (count - 1); j++){
	// 		elements[j+1] = elCopy[j];
	// 	}

	// 	elements[index - 1] = item;

	// }

	public void singit(int position, String item){
		resizeArray();

		String[] elCopy = elements;
		count++;
		elements = new String[count];

		for (int i = count - 1; i > (count - position); i--){
			elements[i] = elCopy[i - 1];
		}

		//shifts item
		for (int j = (count - position); j >= 0; j--){
			elements[j] = elCopy[j];
		}

		elements[count - position] = item;

	}
}
