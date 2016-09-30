import java.util.*;

public class StringStack{
	private String[] elements;		
	private int size;
	private int count = 0;
	private static final int DEFAULT_SIZE = 10;

	private void checkOutOfBounds(){
		if (count < 0 || count >= size){
			throw new ArrayIndexOutOfBoundsException("Oops, out of bounds");
		}
	}

	public StringStack(){
		this(DEFAULT_SIZE);
	}

	public StringStack(int size){
		this.size = size;
		elements = new String[size];
		checkOutOfBounds();
	}

	public int size(){
		return count;
	}

	public void push(String s){
		resizeArray();
		elements[count++] = s;
	}

	public String pop(){
		resizeArray();
		checkOutOfBounds();
		return elements[--count];
	}

	public String pop(int n){
		if (count < 0 || n > count){
			throw new ArrayIndexOutOfBoundsException("Oops, out of bounds");
		}
		count -= n;
		return elements[--count];
	}

	public String peek(){
		return elements[count - 1];
	}

	public String toString(){
		String result = "";

		for (int i = 0; i < count - 1; i++){
			result += (elements[i] + ", ");
		}
		result += elements[count - 1];
		return result;
	}

	private void resizeArray(){
		if (count + 2 >= elements.length){
			size += 5;
			elements = Arrays.copyOf(elements, size);
		}
	}
}