package Future01;
import java.util.Scanner;

import java.io.*; 
import java.util.*; 
  
class Test3
{ 	
	public void count(int[] in, int[] out, int range) {
		int[] temp = new int[range];
		int n = in.length;
		Arrays.fill(temp, 0);
		for(int i = 0; i < n ; i++)
			temp[in[i]]++;
		for(int i = 1 ; i < range;i++)
			temp[i]+=temp[i-1];
		for(int i = n -1; i >= 0 ;i--) {
			out[temp[in[i]]-1]=in[i];
			--temp[in[i]];
			n--;
		}
		
	}
	 public static void main(String[] args) {
		 Test3 test= new Test3();
		 int[] arr= {1,2,3,13,2,3,43,4,23,4,321};
		 int range = 400;
		 int[] arr1 = new int[arr.length];
		 test.count(arr, arr1, range);
		 System.out.println(Arrays.toString(arr1));
	 }
}