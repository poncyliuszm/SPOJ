package basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class HalfOfTheHalf {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int linie = Integer.parseInt(br.readLine());
		String[] linia = new String[linie];
		
		for(int x=0; x<linie; x++) {
			linia[x] = br.readLine();
		}
		
		for(int x=0; x<linie; x++) {
			int dlugoscSlowa = linia[x].length();
			for (int y=0; y<dlugoscSlowa/2; y=y+2) {
				System.out.print(linia[x].charAt(y));
			}
			System.out.println();
		}
	}
}
