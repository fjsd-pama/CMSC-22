/*import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;*/
import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import java.lang.*;

/**
 * Created by Arniel, Frank, Daniel on 10/14/2016.
 */
public class SISHandling extends StudentInformation {
	List<StudentInformation> myList = new ArrayList<StudentInformation>();
	StudentInformation stud = new StudentInformation();

	public static int toInteger( String given ){
		int result = 0;
		for ( int i = 0; i < given.length(); i++ ){
			if ( given.charAt(i) >= '0' && given.charAt(i) <= '9'){
				result = (result * 10) + (given.charAt(i) - 48);
			} else{
				throw new IllegalArgumentException("Invalid number. Contains non-integers!!");
			}
		}

		return result;
	}

	//stores all StudentInformation from a file to myList
	public SISHandling(){

		int counter = 1;
		String sCurrentLine;
        String studentNumber = "";
	    String firstName = "";
	    char middleInitial = ' ';
	    String lastName = "";
	    String course = "";
		int yearLevel = 0;

		BufferedReader br = null;

        try {
            br = new BufferedReader(new FileReader("db.txt"));

            while ((sCurrentLine = br.readLine()) != null) {
            	if ( counter == 1 ){
            		studentNumber = sCurrentLine;

            	} else if ( counter == 2 ){
            		firstName = sCurrentLine;
            	} else if ( counter == 3 ){
            		if ( sCurrentLine.length() != 0 ){
            			middleInitial = (sCurrentLine).charAt(0);
            		}
            	} else if ( counter == 4 ){
            		lastName = sCurrentLine;
            	} else if ( counter == 5 ){
            		course = sCurrentLine;
            	} else{
        			yearLevel = toInteger(sCurrentLine);

            		stud = new StudentInformation(studentNumber, firstName, middleInitial, lastName, course, yearLevel);
            		myList.add(stud);

            		counter = 0;
            		studentNumber = "";
				    firstName = "";
				    middleInitial = ' ';
				    lastName = "";
				    course = "";
					yearLevel = 0;
            	}

            	counter++;

            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (br != null) br.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }

        }
	}

	public boolean isStudentNumExisting( String studentNumber ){
		int x = 0;
		StudentInformation current = new StudentInformation();
		while ( x < myList.size() ){
			if ( ( (current = myList.get(x)).getStudentNumber() ).equals(studentNumber) ){
				return true;
			}
			x++;
		}

		return false;

	}

	public void RegisterStudent( String studentNumber ){
		int x = 1;
		StudentInformation student = new StudentInformation();
		Scanner sc = new Scanner(System.in);
		String scanned = "";
	    
		System.out.print("First name: ");
		scanned = sc.nextLine();
		String firstName = scanned;
		System.out.print("Middle Initial: ");
		scanned = sc.nextLine();
		char middleInitial = scanned.charAt(0);
		System.out.print("Last Name: ");
		scanned = sc.nextLine();
		String lastName = scanned;
		System.out.print("Course: ");
		scanned = sc.nextLine();
		String course = scanned;
		System.out.print("Year Level: ");
		scanned = sc.nextLine();
		int yearLevel = toInteger(scanned);

		student = new StudentInformation(studentNumber, firstName, middleInitial, lastName, course, yearLevel);
		myList.add(student);
		System.out.println();
		System.out.println("Student added!");

	}

	public void RetrieveInformation( String studentNumber ){
		int x = 0;
		StudentInformation current = new StudentInformation();
		while ( x < myList.size() ){
			current = myList.get(x);
			if ( ( current.getStudentNumber() ).equals(studentNumber) ){
				System.out.println(current);
				break;
			}

			x++;
		}

	}

	public void DeleteStudent( String studentNumber ){
		int x = 0;
		StudentInformation current = new StudentInformation();
		while ( x < myList.size() ){
			if ( ( (current = myList.get(x)).getStudentNumber() ).equals(studentNumber) ){
				myList.remove(x);
				System.out.println("Student " + studentNumber + " deleted!");
				break;
				}

			x++;
		}

	}

	public void save( ){
		//diri niya iwrite ang tanan info sa myList to "db.txt"
		BufferedWriter bw = null;

		try {

            File file = new File("db.txt");
            // if file doesnt exists, then create it
            if (!file.exists()) {
                file.createNewFile();
            }

            bw = new BufferedWriter(new FileWriter(file));
            int x = 0;
    		StudentInformation current = new StudentInformation();
    		while ( x < myList.size() ){
    			current = myList.get(x);

				bw.write( current.getStudentNumber() );
				bw.newLine();
				bw.write( current.getFirstName() );
				bw.newLine();
				bw.write( current.getMiddleInitial() );
				bw.newLine();
				bw.write( current.getLastName() );
				bw.newLine();
				bw.write( current.getCourse() );
				bw.newLine();
				bw.write( String.valueOf(current.getYearLevel()) );
				bw.newLine();
    			x++;
    		}

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (bw != null) bw.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }

        }
	}
}
