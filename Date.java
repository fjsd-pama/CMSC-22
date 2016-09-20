import java.lang.*;

/**
* Created by Arniel Pama, 09/13/16;
*/

//use @author para mocolor!:D 

public class Date{

	private int day; // [1, 31]
	private int month; // [1, 12]
	private int year; // [1000, 9999]
	private static final String[] monthArr = new String[]{ "", "January", "February", "March", "April", "May",
			"June", "July", "August", "September", "October", "November", "December"};

	public Date( int year, int month, int day ){
		setDate(year, month, day);
	}

	public Date( ){
		this.day = 1; // no need na ang this :p
		this.month = 1;
		this.year = 1000;
	}

	public int getYear( ){
		return this.year;
	}

	public int getMonth( ){
		return this.month;
	}

	public int getDay( ){
		return this.day;
	}

	public void setYear( int year ){
		//check if within [1000, 9999]
		if ( (year < 1000) || (year > 9999) ){
			throw new IllegalArgumentException("Year must be within [1000, 9999]");
		}

		this.year = year;
	}

	public void setMonth( int month ){
		if ( (month < 1) || (month > 12) ){
			throw new IllegalArgumentException("Month must be within [1, 12]");
		}

		this.month = month;
	}

	public boolean isLeapYear( int year ){ // nice! :D
		if ( year % 4 == 0 ){
			if ( year % 10 == 0 ){
				if ( year % 400 != 0 ){
					return false;
				}
			} else{
				return true;
			}
		}

		return false;
	}

	public void setDay( int day ){
		//check if within [1, 31]
		if ( (day < 1) || (day > 31) ){
			//check for months Jan., March, May, August, Nov., Dec.
			if ( month == 1 || month == 3 || month == 5 || month == 8 || month == 10 || month == 12 ){
				if ( day > 31 ){
					// if ( month == 1 ){
					// 	throw new IllegalArgumentException("January has 31 days!!");
					// } else if ( month == 3 ){
					// 	throw new IllegalArgumentException("March has 31 days!!");
					// } else if ( month == 5 ){
					// 	throw new IllegalArgumentException("May has 31 days!!");
					// } else if ( month == 8 ){
					// 	throw new IllegalArgumentException("August has 31 days!!");
					// } else if ( month == 10 ){
					// 	throw new IllegalArgumentException("November has 31 days!!");
					// } else{
					// 	throw new IllegalArgumentException("December has 31 days!!");
					// }
					throw new IllegalArgumentException( String.format( monthArr[month] + " has 31 days!!" ) );
				}
			} else{
				throw new IllegalArgumentException("Day must be within [1, 31]");
			}
		} else{
			//check for February
			if ( (month == 2) ){
				//if leap year
				if ( isLeapYear(year) ){
					if ( (day > 29) ){
						throw new IllegalArgumentException("February on a leap year only has 29 days");
					}
				} else{
					if ( (day > 28) ){
						throw new IllegalArgumentException("February on a nonleap year has 28 days only");
					}
				}
			//check for Sept., April, June, Nov.
			} else {
				if ( (month == 9) || (month == 4) || (month == 6) || (month == 11)){
					if ( day > 30 ){
						// if ( (month == 9) ){
						// 	throw new IllegalArgumentException("September has 30 days!!");
						// } else if ( (month == 4) ){
						// 	throw new IllegalArgumentException("April has 30 days!!");
						// } else if ( month == 6 ){
						// 	throw new IllegalArgumentException("June has 30 days!!");
						// } else{
						// 	//if November
						// 	throw new IllegalArgumentException("November has 30 days!!");
						// }
						throw new IllegalArgumentException( String.format( monthArr[month] + " has 30 days!!" ) );
					}
				}	
			}
		}
		
		this.day = day;
	}

	public String toString( ){
		return String.format("%02d/%02d/%d", month, day, year); // pwede %d nalang kay nag set namn ka daan!
	}

	public void setDate( int year, int month, int day ){
		setYear(year);
		setMonth(month);
		setDay(day);
	}
}
