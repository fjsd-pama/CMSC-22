import java.util.Scanner;

// Input Format

// First line contains the number of testcases T. T lines follow. 
// Each line contains 3 space separated integers a, b and c . a and b indicate the capacity of the two jugs respectively, and c denotes the exact capacity with which one of the jugs should be filled.

// Output Format

// For each test case, print "YES" (in a new line) if one of the jugs can be filled with exactly c gallons of water and "NO" (in a new line) if they cannot be filled. ( quotes are for clarity )

// Constraints

// 1 ≤ a, b, c ≤ 103 
// 1 ≤ T ≤ 100

// Sample Input

// 2
// 5 3 4
// 3 6 4
// Sample Output

// YES
// NO

/*The more general problem is finding integer solutions for the equation ax + by = c.
Solutions (x,y) exist when the greatest common divisor of a and b is a factor of c. This is an ancient problem.
For more, read this article: http://mathforum.org/library/drmath/view/51595.html*/
//(c) http://mindyourdecisions.com/blog/2013/02/04/the-water-jug-riddle/

public class WaterjugDieHard3{

	public static int min_of_2(int num1, int num2){
		if (num1 < num2){
			return num1;
		}

		return num2;
	}

	public static int GCD(int num1, int num2){
		int gcd = 0;
		int num = min_of_2(num1, num2);
		for (int i = 1; i <= num; i++){
			if ((num1 % i == 0) && (num2 % i == 0)){
				if (i > gcd){
					gcd = i;
				}
			}
		}

		return gcd;
	}


	public static void canBeFilledWithCGals( int a, int b, int c ){
		if ( ( c % GCD(a, b) ) == 0 ){
			System.out.println("YES");
		} else{
			System.out.println("NO");
		}
	}


	public static void main( String args[] ){
		Scanner keyboard = new Scanner(System.in);
		int T = keyboard.nextInt();
		int a, b, c;

		for ( int i = 1; i <= T; i++ ){
			a = keyboard.nextInt();
			b = keyboard.nextInt();
			c = keyboard.nextInt();

			canBeFilledWithCGals( a, b, c );
		}

		//*Some examples*
		// canBeFilledWithCGals(5, 3, 4); //YES
		// canBeFilledWithCGals(3, 6, 4); //NO
	}
}