
import java.io.IOException;
import java.util.Scanner;

/**
 * Created by Arniel, Frank, Daniel on 10/14/2016.
 */
public class StudentInfoSystem {
	public static boolean SIS( SISHandling toHandle ){
		Scanner sc = new Scanner(System.in);
        int x = 0;
        String studNum = "";

        while ( x < 1 || x > 4 ){
        	
	        System.out.println("\nWhat do you want to do??");
	        System.out.println("1. Register a student");
	        System.out.println("2. Retrieve student information");
	        System.out.println("3. Delete a student");
	        System.out.println("4. Exit");
	        System.out.print("\tChoose a number: ");
	        x = sc.nextInt();
	        

	        if ( x < 1 || x > 4){
	        	System.out.println("Invalid input!! Try again.");
	        }

	    }

	    //accepts student number
	    if ( x == 1 ){
	    	System.out.print("\nStudent Number: ");
	    	studNum = sc.next();

	    	while ( toHandle.isStudentNumExisting(studNum) ){
	    		System.out.println("THAT STUDENT NUMBER EXISTS!!");
	    		System.out.print("Enter again: ");
	    		studNum = sc.next();
	    	}

	    	toHandle.RegisterStudent(studNum);
	    } else if ( x == 2 ){
	    	System.out.print("\nSearch Student: ");
	    	studNum = sc.next();

	    	while ( !(toHandle.isStudentNumExisting(studNum)) ){
	    		System.out.println("THAT STUDENT NUMBER DOESN'T EXIST!!");
	    		System.out.print("Enter again: ");
	    		studNum = sc.next();
	    	}

	    	toHandle.RetrieveInformation(studNum);
	    } else if ( x == 3) {
	    	//when x == 3
	    	System.out.print("\nDelete Student: ");
	    	studNum = sc.next();

	    	while ( !(toHandle.isStudentNumExisting(studNum)) ){
	    		System.out.println("THAT STUDENT NUMBER DOESN'T EXIST!!");
	    		System.out.print("Enter again: ");
	    		studNum = sc.next();
	    	}

	    	toHandle.DeleteStudent(studNum);
	    } else{
	    	//if x == 4; this is the EXIT function
	    	int y = 0;

	    	while ( y < 1 || y > 2 ){
	    		System.out.print("\nDo you wish to save your work (1=yes, 2=no)? ");
	    		y = sc.nextInt();

	    		if ( y < 1 || y > 2){
	    			System.out.println("Invalid input!! Try again.");
	    		}
	    	}

	    	if ( y == 1 ){
	    		toHandle.save();
	    	}

	    	return false;
	    }

	    return true;
	} //end SIS

    public static void main(String[] args) {
    	SISHandling toHandle = new SISHandling();

    	System.out.println("=== Student Information System ===");
	    System.out.println("Creators: Arniel, Daniel, Frank");

	    while ( SIS( toHandle ) ){
	    	//do those stuff
	    }

    }
}