package classical;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ONPTransformTheExpression {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int t = Integer.parseInt(br.readLine());
		String[] linie = new String[t];
		String[] RPNlinie = new String[t];
		
		for(int i=0; i<t; i++) {
			linie[i] = br.readLine();
			RPNlinie[i] = RPN(linie[i]);
		}
		
		for(int i=0; i<t; i++)
			System.out.println(RPNlinie[i]);
	}
	
	public static String RPN(String linia) {
		String result = "";
		char operator = ' ';
		int liczbaOp = 0;
		
		for (int x = 0; x<linia.length(); x++) {
			if (linia.charAt(x) == '+' || linia.charAt(x) == '-' || linia.charAt(x) == '*' || linia.charAt(x) == '/' || linia.charAt(x) == '^' ) {
				liczbaOp++;		
			}
		}
		char[] operatory = new char[liczbaOp];
		
		for (int x=0,y=0; x<linia.length(); x++) {
			
			if (linia.charAt(x) == '+' || linia.charAt(x) == '-' || linia.charAt(x) == '*' || linia.charAt(x) == '/' || linia.charAt(x) == '^' )
				operatory[y++] = linia.charAt(x);
				
			if (linia.charAt(x) == ')' ) {
				result = result + Character.toString(operatory[y-1]);
				y--;
				liczbaOp--;
			}
				
			if (Character.isLetter(linia.charAt(x))) {
				result = result + (Character.toString(linia.charAt(x)));
			}
		}
		return result;
	}
}
