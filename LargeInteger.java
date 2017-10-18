import java.util.Scanner;

public class LargeInteger {
    String number;
    boolean isNegative;

    public LargeInteger(){
        this.number = "0";
        isNegative = false;
    }

    // TODO add the rest of your implementation here!!!
    public LargeInteger(String str) {
        for ( int i = 0; i < str.length(); i++ ){
            if (!((str.charAt(i) >= '0' && str.charAt(i) <= '9') || (str.charAt(i) == '-'))){
                throw new IllegalArgumentException( "Must be an integer!!" );
            }
        }

        this.number = str;
    }

    public LargeInteger(long l) {
        this.number = String.valueOf(l);
    }

    public LargeInteger(LargeInteger li) {
        this.number = li.number;
    }

    public boolean equals(LargeInteger li){
        String liCopy = li.number;

        if ( liCopy.length() != this.number.length() ){
            return false;
        } else{
            for ( int i = 0; i < liCopy.length(); i++ ){
                if ( liCopy.charAt(i) != (this.number).charAt(i) ){
                    return false;
                }
            }
        }

        return true;
    }

    public int[] toIntArray( String given, int len ){
        int[] result = new int[len];
        int start = 0;
        isNegative = false;

        if ( given.charAt(0) == '-'){
            start = 1;
            isNegative = true;
            result[0] = 0;
        }

        for ( int i = start; i < len; i++ ){
            result[i] = Integer.parseInt(String.valueOf(given.charAt(i)));
        }
        
        return result;
    }

    public LargeInteger add(LargeInteger li) {
        int result = 0;
        int carry = 0; 
        int len1 = this.number.length();
        int len2 = (li.number).length();
        int smallLen, bigLen;
        int num1, num2;
        int diffLen = 0;
        int[] finalAnswer;
        int[] oneCopy = toIntArray( this.number, len1);
        int[] twoCopy = toIntArray( li.number, len2 );
        String resultStr = "";
        LargeInteger a = new LargeInteger();
        LargeInteger b = new LargeInteger();

        //handles negative numbers
        if ( this.isNegative && !li.isNegative ){
            a = new LargeInteger(li.number);
            b = new LargeInteger(this.number);
            a.isNegative = false;
            return a.subtract(b);
        } else if ( !this.isNegative && li.isNegative){
            a = new LargeInteger(this.number);
            b = new LargeInteger(li.number);
            b.isNegative = false;
            return a.subtract(b);
        } else {
            //checks whether to put negative sign or not
            if ( this.isNegative && li.isNegative ){
                resultStr += "-";
            }

            //this is where the actual calculations begin
            if ( ( len1 > len2 ) ){
                diffLen = len1 - len2;
                finalAnswer = new int[len1];
                
                for ( int i = len1 - 1; i >= 0; i-- ){
                    num1 = oneCopy[i];
                    
                    if ( (i - diffLen) < 0 ){
                        num2 = 0;
                    } else{
                        num2 = twoCopy[i - diffLen];
                    }
                    
                    
                    result = num1 + num2 + carry;
                    finalAnswer[i] = result % 10; //places the result to this index
                    carry = result / 10;
                }
                
                finalAnswer[0] += (carry * 10);
                
            } else{
                //when len2 > len1
                diffLen = len2 - len1;
                finalAnswer = new int[len2];
                
                for ( int i = len2 - 1; i >= 0; i-- ){
                    num2 = twoCopy[i];
                    
                    if ( (i - diffLen) < 0 ){
                        num1 = 0;
                    } else{
                        num1 = oneCopy[i - diffLen];
                    }
                    
                    result = num1 + num2 + carry;
                    finalAnswer[i] = result % 10; //places the result to this index
                    carry = result / 10;
                }
                
                finalAnswer[0] += (carry * 10);
            } //end inner if-else condition
            
            //the int elements in the finalAnswer array are stored in a string
            for ( int j = 0; j < finalAnswer.length; j++ ){
                resultStr += String.valueOf(finalAnswer[j]);
            }
        } //end outer if-else

        return new LargeInteger(resultStr);
    }

    public LargeInteger subtract(LargeInteger li) {
        int result = 0;
        int len1 = (this.number).length();
        int len2 = (li.number).length();
        int diffLen = 0;
        int minuNum = 0;
        int subtraNum = 0;
        int[] minuendCopy = toIntArray( this.number, len1);
        int[] subtrahendCopy = toIntArray( li.number, len2 );
        String resultStr = "";
        int[] finalAnswer;

        LargeInteger a = new LargeInteger();
        LargeInteger b = new LargeInteger();

        //handles negatie numbers
        if ( this.isNegative && !li.isNegative ){
            a = new LargeInteger(this.number);
            b = new LargeInteger(li.number);
            b.isNegative = true;
            return a.add(b);
        } else if ( !this.isNegative && li.isNegative){
            a = new LargeInteger(this.number);
            b = new LargeInteger(li.number);
            b.isNegative = false;
            return a.add(b);
        } else {
            //checks whether to put negative sign or not
            if ( this.isNegative && li.isNegative ){
                resultStr += "-";
            }

            //this is where the operations begin
            if ( ( len1 > len2 ) ){
                diffLen = len1 - len2;
                finalAnswer = new int[len1];
                
                for ( int i = len1 - 1; i >= 0; i-- ){
                    minuNum = minuendCopy[i];
                    
                    if ( (i - diffLen) < 0 ){
                        subtraNum = 0;
                    } else{
                        subtraNum = subtrahendCopy[i - diffLen];
                    } //end first if-else
                    
                    //when this happens, we need to borrow
                    if ( subtraNum > minuNum ){
                        minuNum = 10 + minuNum;
                        
                        if ( (i - 1) > 0 ){
                            borrow( minuendCopy, i - 1);  
                        }    
                    } //end second if-else
                    
                    result = minuNum - subtraNum;
                    finalAnswer[i] = result; //places the result to this index
                } //end inner for   
            } else{
                //when len2 > len1
                diffLen = len2 - len1;
                finalAnswer = new int[len2];
                
                //this time ang subtraNum - minuNum
                //but finalRes is negative
                for ( int i = len2 - 1; i >= 0; i-- ){
                    subtraNum = subtrahendCopy[i];
                    
                    if ( (i - diffLen) < 0 ){
                        minuNum = 0;
                    } else{
                        minuNum = minuendCopy[i - diffLen];
                    }
                    
                    //when this happens, we need to borrow
                    if ( minuNum > subtraNum ){
                        subtraNum = 10 + subtraNum;

                        if ( (i - 1) > 0 ){
                            borrow( subtrahendCopy, i - 1);
                        }
                    }
                    
                    result = subtraNum - minuNum;
                    finalAnswer[i] = result; //places the result to this index
                }
            } //end outer if-else
        } //end outermost if-else
        
        //to eliminate leading zeros
        int k = 0;
        
        for (int i = 0; i < finalAnswer.length; i++){
            if ( finalAnswer[i] > 0 ){
                k = i;
                break;
            } else{
                k = i;
            }
        }
        
        //store the finalAnswer to return as String
        for ( int j = k; j < finalAnswer.length; j++ ){
            resultStr += String.valueOf(finalAnswer[j]);
        } 

        return new LargeInteger(resultStr);
    }

    public void borrow( int[] arr, int index ){
        if ( (arr[index] != 0) ){
            arr[index]--;
        } else if ( index <= 0 ){
            //do nothing
        } else{
            arr[index] = 9;
            borrow(arr, index - 1);
        }
    }



    public LargeInteger multiply(LargeInteger li) {
        int len1 = (this.number).length();
        int len2 = (li.number).length();
        int smallLen = 0;
        int bigLen = 0;
        String biggerNum;
        LargeInteger finalResult = new LargeInteger();
        int[] smallerArr;

        if ( this.isNegative != li.isNegative ){
            finalResult.number = "-" + finalResult.number;
        }

        if ( this.number.charAt(0) == '1' || li.number.charAt(0) == '1'){
            if ( this.number.charAt(0) == '1' ){
                return new LargeInteger(li.number);
            }

            return new LargeInteger(this.number);
        } else if ( this.number.charAt(0) == '0' || li.number.charAt(0) == '0'){
            return new LargeInteger("0");
        } else{
            if ( len1 > len2 ){
                smallLen = len2;
                bigLen =  len1;
                biggerNum = this.number;
                smallerArr = toIntArray( li.number, smallLen );
            } else{
                smallLen = len1;
                bigLen = len2;
                biggerNum = li.number;
                smallerArr = toIntArray( this.number, smallLen );
            }

            String[] resultArr = new String[bigLen];
            LargeInteger result = new LargeInteger("0");

            //Multiplies each element of the smallerArr to the whole biggerArr value,
            //then stores each result to the the resultArr array
            for ( int i = (smallLen - 1), k = 0; i >= 0; i--, k++ ){
                result = LargeInteger("0");
                for ( int j = 1; j <= smallerArr[i]; j++ ){
                    result = result.add(new LargeInteger(biggerNum));
                }

                finalResult = finalResult.add( new LargeInteger(addZerosToEnd(result, k)) );
            }
        }

        return finalResult;
    }

    public String addZerosToEnd( LargeInteger liToBeAddedWith, int numOfZerosToAdd ){
        String result = liToBeAddedWith.number;

        for ( int i = 1; i <= numOfZerosToAdd; i++ ){
            result += "0";
        }

        return result;
    }

    public LargeInteger divide(LargeInteger li) {
        


        return li;
    }

    public String toString(){
        return this.number;
    }

    // NOTE: no need to change this method!
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // Simply read input from console and perform operations using the LargeInteger class
        String operand1 = sc.next();
        String operator = sc.next();
        String operand2 = sc.next();

        // To test String constructor
        LargeInteger myInt1 = new LargeInteger(operand1);
        // To test LargeInteger constructor
        LargeInteger myInt2 = new LargeInteger(new LargeInteger(operand2));
        // To test long constructor
        LargeInteger result = new LargeInteger(0L);

        switch(operator) {
            case "+":
                result = myInt1.add(myInt2);
                break;
            case "-":
                result = myInt1.subtract(myInt2);
                break;
            case "*":
                result = myInt1.multiply(myInt2);
                break;
            case "/":
                result = myInt1.divide(myInt2);
                break;
            default:
                // do nothing...

        }

        // print out result:
        System.out.println(result); // this line invokes LargeInteger.toString()

    }

}
