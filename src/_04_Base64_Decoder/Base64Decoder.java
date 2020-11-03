package _04_Base64_Decoder;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
public class Base64Decoder {
	/*
	 * Base 64 is a way of encoding binary data using text.
	 * Each number 0-63 is mapped to a character. 
	 * NOTE: THIS IS NOT THE SAME AS ASCII OR UNICODE ENCODING!
	 * Since the numbers 0 through 63 can be represented using 6 bits, 
	 * every four (4) characters will represent twenty four (24) bits of data.
	 * 4 * 6 = 24
	 * 
	 * For this exercise, we won't worry about what happens if the total bits being converted
	 * do not divide evenly by 24.
	 * 
	 * If one char is 8 bits, is this an efficient way of storing binary data?
	 * (hint: no)
	 * 
	 * It is, however, useful for things such as storing media data inside an HTML file (for web development),
	 * so that way a web site does not have to look for an image, sound, library, or whatever in a separate location.
	 * 
	 * View this link for a full description of Base64 encoding
	 * https://en.wikipedia.org/wiki/Base64
	 */
	
	
	final static char[] base64Chars = {
		'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 
		'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z',
		'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 
		'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z',
		'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '+', '/'
	};
    final static int[] base64Nums = {
    	000000,010000,100000,110000,000001,010001,100001,110001,000010,010010,100010,
    	110010,000011,010011,100011,110011,000100,010100,100100,110100,000101,
    	010101,100101,110101, 000110, 010110,100110,110110,000111,010111,100111,110111,
    	001000,011000,101000,111000,001001,011001,101001,111001,001010,011010,111010,
    	001011,011011,101011,111011,001100,011100,101100,111100,001101,011101,101101,111101,
    	001110,011110,101110,111110,001111,011111,101111,111111
    };
    HashMap<String, Integer> theKey = new HashMap<String, Integer>();

	//1. Complete this method so that it returns the the element in
	//   the base64Chars array that corresponds to the passed in char.
	public static byte convertBase64Char(char c){
		
char letter = ' ';




for(int i = 0; i< base64Chars.length; i++) {
	String match = ""+c;
	String base = ""+base64Chars[i];
	if(match.equals(base)) {
		letter = base64Chars[i];
	}
}
		return (byte) letter;
	}
	
	//2. Complete this method so that it will take in a string that is 4 
	//   characters long and return an array of 3 bytes (24 bits). The byte 
	//   array should be the binary value of the encoded characters.
	public static String[] convert4CharsTo24Bits(String s){
		String[] split = new String[3];
		for(int i = 0; i<3;i++) {int length = s.length()/3; for(int j = 0; j<length;j++) {
		String letter = ""+s.charAt(j+i); split[i]+=convertStringToBinary(letter);}
		}
		return split;
	}
	
	//3. Complete this method so that it takes in a string of any length
	//   and returns the full byte array of the decoded base64 characters.
	public static int[] base64StringToByteArray(String file) {
		HashMap<String, Integer> theKey = new HashMap<String, Integer>();
		for (int i = 0; i < base64Chars.length; i++) {
			String base= base64Chars[i]+"";
			theKey.put(base, base64Nums[i]);
		}
		int[] code = new int[file.length()];
		for(int i =0; i<code.length;i++) {
			String letter = ""+file.charAt(i);
			code[i] = theKey.get(letter);
		}
		return code;
	}
	 public static String convertStringToBinary(String input) {

	        StringBuilder result = new StringBuilder();
	        char[] chars = input.toCharArray();
	        for (char aChar : chars) {
	            result.append(
	                    String.format("%8s", Integer.toBinaryString(aChar))  
	                            .replaceAll(" ", "0")                       
	            );
	        }
	        return result.toString();

	    }

	    public static String prettyBinary(String binary, int blockSize, String separator) {

	        List<String> result = new ArrayList<>();
	        int index = 0;
	        while (index < binary.length()) {
	            result.add(binary.substring(index, Math.min(index + blockSize, binary.length())));
	            index += blockSize;
	        }

	        return result.stream().collect(Collectors.joining(separator));
	    }
}
