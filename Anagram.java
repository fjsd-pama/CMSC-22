import java.lang.String;
import java.util.Scanner;

public class Anagram{

	public static void numOfCharsToChangeToBeAnagram( String arg ){
		int middle = arg.length() / 2;
		char[] tempArg = arg.toCharArray();
		int result = 0;

		for ( int i = 0; i < middle; i++ ){
			for ( int j = middle; j < arg.length(); j++ ){
				if ( tempArg[i] == tempArg[j] ){
					tempArg[i] = '0';
					tempArg[j] = '0';
					break;
				}
			}
		}

		for ( int k = middle; k < arg.length(); k++ ){
			if ( tempArg[k] != '0' ){
				result++;
			}
		}

		System.out.println( result );
	} //end numOfCharsToChangeToBeAnagram

	public static void main( String args[] ){
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		String input;

		for ( int i = 1; i <= T; i++ ){
			input = sc.next();
			numOfCharsToChangeToBeAnagram( input );
		}
		
		//some examples
		// numOfCharsToChangeToBeAnagram( "aaabbb" ); //3
		// numOfCharsToChangeToBeAnagram( "abc" ); //2
		// numOfCharsToChangeToBeAnagram( "xyyx" ); //0	
	} //end main

} //end Solution