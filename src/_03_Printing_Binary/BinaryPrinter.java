package _03_Printing_Binary;

public class BinaryPrinter {
	//Complete the methods below so they print the passed in parameter in binary.
	//Use bit shifting and bit masking to print the binary numbers.
	//Do not use the Integer.toBinaryString method!
	//Don't be afraid to use the methods that are already complete to finish the others.
	//Create a main method to test your methods.
	public static void main(String[] args) {
		int num = 56;
		byte num1= (byte) num;
		short num2= (short) num;
		long num4= (long) num;
		System.out.println("Number : "+num);
		System.out.println("Binary: "+convertDecimalToBinary(num));
		printByteBinary(num1);
		printShortBinary(num2);
		printLongBinary(num4);
		printIntBinary(num);
	}
	public static void printByteBinary(byte b) {
		String op = convertDecimalToBinary((int)b);
	for(int i = op.length(); i>4;i++ ) {
		if(op.length()<5) {}
		else {
		op = op.substring(0, op.length());
		}
	}
	System.out.println("BYTE: "+ op);
	}
	
	public static void printShortBinary(short s) {
		String op = convertDecimalToBinary((int)s);
	for(int i = op.length(); i>5;i++ ) {
		op = op.substring(0, op.length()-2);
	}
	System.out.println("SHORT: "+op);
	}
	
	public static void printIntBinary(int i) {
		String op = convertDecimalToBinary((int)i);
		for(int j = op.length(); j>2;j++ ) {
			op = op.substring(0, op.length()-2);
		}
		System.out.println("INT: "+op);
	}
	
	public static void printLongBinary(long l) {
		String op = convertDecimalToBinary((int)l);
		for(int j = op.length(); j>6;j++ ) {
			op = op.substring(0, op.length()-2);
		}
		System.out.println("LONG: "+op);
	}
	 public static String convertDecimalToBinary(int decimalNum) {
	        String binaryStr = "";
	    
	        do {
	            // 1. Logical right shift by 1
	            int quotient = decimalNum >>> 1;
	        
	            // 2. Check remainder and add '1' or '0'
	            if( decimalNum % 2 != 0 ){
	                binaryStr = '1' + binaryStr;
	            } else {
	                binaryStr = '0' + binaryStr;
	            }
	            
	            decimalNum = quotient;
	            
	        // 3. Repeat until number is 0
	        } while( decimalNum != 0 );
	        
	        return binaryStr;
	    }
}
