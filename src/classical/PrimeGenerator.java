package classical;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


// Program will return prime numbers in range [n1-n2]
// Used algorithm: segmented sieve of Eratosthenes
public class PrimeGenerator {
	static int primes[];			// array of prime numbers
	static int array[];			// array of values true(1) / false(0)
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tests = Integer.parseInt(br.readLine());
		String linie[] = new String[tests];
		
		for(int test=0; test<tests; test++) {
			linie[test] = br.readLine();
		}
		
		for(int test=0; test<tests; test++) {
			String[] parts = linie[test].split(" ");
			int n1 = Integer.parseInt(parts[0]);
			int n2 = Integer.parseInt(parts[1]);
			
			int sqrt = (int) Math.sqrt(n2);
			primes = new int[sqrt + 1];
			array = new int[sqrt + 1];
			init(sqrt+1);
			
			int liczbaLiczbPierwszych = sieve(n1, n2, sqrt);
			segmentedSieve(n1, n2, liczbaLiczbPierwszych, sqrt);
			System.out.println();
			
		}
	}
	
	public static void segmentedSieve(int n1, int n2, int liczbaLiczbPierwszych, int sqrt) {
		int diff = n2 - n1 + 1;
		array = new int[diff];
		init(diff);
		
		for (int j=0; j<liczbaLiczbPierwszych; j++) {
			int div = n1 / primes[j];
			div *= primes[j];
			while (div <= n2) {
				if (div >= n1 && primes[j] != div)
					array[div - n1] = 0;
				div += primes[j];
			}
		}
		
		for (int i=0; i<diff; i++) {
			if(array[i] == 1 && (i+n1) != 1)
				System.out.println(i+n1);
		}
	}


	public static int sieve(int n1, int n2, int sqrt) {
		int liczbaLiczbPierwszych=0;
		for (int i=2; i<=sqrt; i++) {
			if(array[i] == 1) {
				primes[liczbaLiczbPierwszych] = i;
				liczbaLiczbPierwszych++;
				for (int k=i*i; k<=sqrt; k += i) {
					array[k] = 0;
				}
			}
		}
		return liczbaLiczbPierwszych;
	}
	
	public static void init(int range) {
		for (int i=0; i<range; i++)
			array[i] = 1;
	}

}
