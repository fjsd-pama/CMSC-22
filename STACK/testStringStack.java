public class testStringStack{
	public static void main(String args[]){
		StringStack stack = new StringStack(3);
		stack.push("NBK");
		stack.push("GeT_RiGhT");
		stack.push("KennyS");
		stack.push("ScreaM");

		System.out.println(stack);
		System.out.println(stack.size());
		String item1 = stack.pop();
		String item2 = stack.pop();
		String item3 = stack.pop();
		System.out.println(item1);
		System.out.println(item2);
		System.out.println(item3);
		System.out.println(stack.size());
		System.out.println(stack);
	}
		
}