import java.util.Scanner;

public class Rule30Thread extends Thread{
	int[][] arr;
	int x; //the row dimension
	int y; //the col dimension
	int startrow;
	int endrow;

	Rule30Thread(int[][] arr, int dimension, int startrow, int endrow){
		this.arr = arr;
		this.x = dimension;
		this.y = dimension;
		setRowsToProcess(startrow, endrow);
		arr[0][x / 2] = 1;
	}

	Rule30Thread(int[][] arr, int dimension){
		this(arr, dimension, 1, dimension);
		/* DEFAULT:
		this.startrow = 1;
		this.endrow = rowdim;*/
	}

	public void setRowsToProcess(int startrow, int endrow){
		this.startrow = startrow;
		this.endrow = endrow;

		if(endrow==x){
			this.endrow = x - 1;
		}
	}

	public int rule30(int rowIndex, int colIndex){
		int row = rowIndex - 1; //to represent row index
		int first, second, third, toComp;

		second = arr[row][colIndex];

		//changing some values acc. to cases
		if ( (colIndex != 0) && (colIndex != (y - 1)) ){
			first = arr[row][colIndex-1];
			third = arr[row][colIndex+1];
 		} else{
 			if ( colIndex == 0 ){
 				first = 0;
 				third = arr[row][colIndex+1];
 			}
 			//colIndex == (x - 1)
 			else{
 				third = 0;
 				first = arr[row][colIndex-1];
 			}
 		} //end if-else

 		toComp = (first * 100) + (second * 10) + third;

 		//check "toComp" and return either 1 or 0 acc. to rule 30
 		if ( toComp == 111 ) return 0;
		else if ( toComp == 110 ) return 0;
		else if ( toComp == 101 ) return 0;
		else if ( toComp == 000 ) return 0;
		else if ( toComp == 100 ) return 1;
		else if ( toComp == 011 ) return 1;
		else if ( toComp == 010 ) return 1;
		
		return 1; //if 001
	} //end rule30

	//this modifies the array within the specified range of rows [startrow, endrow]
	public void run(){
		
		for ( int i = startrow; i <= endrow; i++ ){
			for ( int j = 0; j < y ; j++ ){
				arr[i][j] = rule30(i, j);
			} // end inner for
		} //end outer for
	}

	public void printArray(){
		if(startrow==1){
			startrow = 0;
		}

		for ( int i = startrow; i <= endrow; i++ ){
			for ( int j = 0; j < y; j++ ){
				System.out.print( arr[i][j] );
			} // end inner for
			System.out.println();
		} //end outer for

	} //end printArray

	public static void main( String[] args ) throws Exception{
		int THREAD_COUNT = 10;
		
		System.out.print("Enter a number: ");
		Scanner sc = new Scanner(System.in);
		int x = sc.nextInt();
		int[][] hey = new int[x][x];
		

		long startTime = System.currentTimeMillis();

		//if dimension of array does not exceed THREAD_COUNT, just process it with one thread
		if((x - 1) <= THREAD_COUNT){
			Rule30Thread rt = new Rule30Thread(hey, x);
			rt.start();

			while(rt.isAlive()){
				//wait until this thread dies
				//before printing the resulting array
			}

			rt.printArray();
			
		}else{
			Rule30Thread[] worker = new Rule30Thread[THREAD_COUNT];

			int rowsToProcess = (x - 1) / THREAD_COUNT;
			System.out.println("rowsToProcess/thread: " + rowsToProcess + "\n");
			int start = 1;
			int end = start + rowsToProcess - 1;

			for(int i = 0; i < THREAD_COUNT; i++){
				if(i == THREAD_COUNT - 1){
					end = x;
				}
				// System.out.println("start: " + start);
				// System.out.println("end: " + end);
				worker[i] = new Rule30Thread(hey, x, start, end);

				start = end + 1;
				end = start + rowsToProcess - 1;
			}

			for(int i = 0; i < THREAD_COUNT; i++){
				worker[i].start();
			    while (worker[i].isAlive()) {
			    	//wait until this thread dies
					//before printing the resulting array
					//and proceeding to the next thread
			    }

			    worker[i].printArray();
			}

			/*for (int i = 0; i < THREAD_COUNT; i++) {
	            while (worker[i].isAlive()) {
	                try {
	                    worker[i].join();
	                } catch (InterruptedException e) {
	                    System.err.println("thread interrupted: " + e.getMessage());
	                }
	            }
	        }*/

		}

        System.out.println("--> Time consumed in ms: " + (System.currentTimeMillis() - startTime));
		
	}
}