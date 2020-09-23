package Future01;

import java.util.Arrays;

public class Test2 {
	public static void main(String[] args) {
		Test2  test  = new Test2();
		int[] arr = {10,9,9,9,9,9,9,9,9};
		int range = 20;
		int[] out = new int [arr.length];
		test.count(arr, out, range);
		System.out.println(Arrays.toString(out));
	}
	public void count(int[] in, int[] out, int range) {
		int[] temp = new int[range];
		int n = in.length;
		Arrays.fill(temp, 0);
		for(int i = 0; i < n ; i ++)
			temp[in[i]]++;
		for(int i = 1 ; i < range; i++) {
			temp[i] +=temp[i-1];
		}
		for(int i = n-1; i>=0;i--) {
			out[temp[in[i]]-1] = in[i];
			--temp[in[i]];
			n--;
		}
	}
}
