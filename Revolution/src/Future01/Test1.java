package Future01;

import java.util.Arrays;
import java.util.Scanner;

public class Test1
{	
	public void sort(int[] arr, int digit) {
		int n = arr.length;
		int[] out = new int[n];
		int[] temp = new int[10];
		Arrays.fill(temp, 0);
		for(int i = 0 ; i < n; i++)
			temp[(arr[i]/digit)%10]++;
		for(int i = 1; i < 10; i ++)
			temp[i] += temp[i-1];
		for(int i = n-1; i >=0; i--) {
			out[temp[(arr[i]/digit)%10]-1]= arr[i];
			--temp[(arr[i]/digit)%10];
			
		}
		for(int i = 0;i<n;i++)
			arr[i] = out[i];
	}
	public void radix(int[] arr, int n) {
		int max = Arrays.stream(arr).max().getAsInt();
		for(int digit = 1; max/digit >0; digit*=10) {
			sort(arr,digit);
		}
	}
    public static void main(String[] args) {
    	Test1 te= new Test1();
    	int[] in = {1234,234,1,111,4444};
    	int[] out = new int[in.length];
    	te.radix(in, in.length);
    	System.out.println(Arrays.toString(in));
    }
}

