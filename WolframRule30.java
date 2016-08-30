import java.util.Scanner;

public class WolframRule30{
	//x is the dimension (i.e. x times x array)
	public static int rule30( int [][] arr, int rowIndex, int colIndex, int x){
		int y = rowIndex - 1; //to represent row index
		int first, second, third, toComp;

		second = arr[y][colIndex];

		//changing some values acc. to cases
		if ( (colIndex != 0) && (colIndex != (x - 1)) ){
			first = arr[y][colIndex-1];
			third = arr[y][colIndex+1];
 		} else{
 			if ( colIndex == 0 ){
 				first = 0;
 				third = arr[y][colIndex+1];
 			}
 			//colIndex == (x - 1)
 			else{
 				third = 0;
 				first = arr[y][colIndex-1];
 			}
 		} //end if-else

 		toComp = (first * 100) + (second * 10) + third;

 		//check toComp and return either 1 or 0 acc. to rule 30
 		if ( toComp == 111 ) return 0;
		else if ( toComp == 110 ) return 0;
		else if ( toComp == 101 ) return 0;
		else if ( toComp == 000 ) return 0;
		else if ( toComp == 100 ) return 1;
		else if ( toComp == 011 ) return 1;
		else if ( toComp == 010 ) return 1;
		
		return 1; //if 001
	} //end rule30

	public static void modify( int [][] arr, int x ){
		arr[0][x / 2] = 1;

		for ( int i = 1; i < x ; i++ ){
			for ( int j = 0; j < x ; j++ ){
				arr[i][j] = rule30(arr, i, j, x);
			} // end inner for
		} //end outer for

	} //end printArray

	public static void printArray( int [][] arr, int x ){
		for ( int i = 0; i < x ; i++ ){
			for ( int j = 0; j < x ; j++ ){
				System.out.print( arr[i][j] );
			} // end inner for
			System.out.println();
		} //end outer for

	} //end printArray

	public static void main( String[] args ){
		//System.out.println("Enter a num (from 1 to 30): ");
		Scanner sc = new Scanner(System.in);
		int x = sc.nextInt();
		int[][] hey = new int[x][x];

		modify( hey, x );
		printArray( hey, x );

	}
}