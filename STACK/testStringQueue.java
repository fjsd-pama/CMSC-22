public class testStringQueue{
	public static void main(String args[]){
		StringQueue stack = new StringQueue(3);
		stack.enqueue("Fifflaren");
		stack.enqueue("Friberg");
		stack.enqueue("TaZ");
		stack.enqueue("Shox");
		stack.singit(2, "Pasza");
		stack.singit(7, "PapHer"); //FIX THIS PROBLEM

		System.out.println(stack);
		System.out.println(stack.size());
		String item1 = stack.dequeue();
		String item2 = stack.dequeue();
		String item3 = stack.dequeue();
		System.out.println(item1);
		System.out.println(item2);
		System.out.println(item3);
		System.out.println(stack.size());
		System.out.println(stack);
	}	
}