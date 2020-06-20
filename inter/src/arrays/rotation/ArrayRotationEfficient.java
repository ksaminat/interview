package arrays.rotation;

public class ArrayRotationEfficient {

	/*	Merge a1[] + a1[]
	 *	Check whether a2[] is subarray of a1[] + a1[]
	 *	Not using extra space - like creating new array a1 + a1 (using the same) array
	 */ 
	private static boolean isRotated(int [] a1, int [] a2) {
		if(a1.length!=a2.length)
			return false;

		int length = a1.length;
		int combinedLength = a1.length * 2;
		
		int i=0; //pointer a1
		int j=0; //pointer a2
		int counter=0; // run till the end of array a1[] + a1[] (both arrays are of equal size)
		
		while(counter<combinedLength) {
			if(a1[i] == a2[j]) {
				i++; // incrementing index of both the arrays
				j++;
				if(j==length)
					return true;
			}else {
				i = i - j + 1;
				j = 0;
			}
			
			if(i==length || i<0) // resetting the length of a1[] - to simulate a1 + a1
				i=0;
			
			counter++;
		}
		
		return false;
	}

	public static void main(String[] args) {
		 int [] a1 = {2, 3, 2, 4};
	     int [] a2 = {3, 2, 4, 2}; 
	     
	     System.out.println(isRotated(a1, a2));
	     
	     int [] a4 = {2, 3, 1, 2};
	     int [] a3 = {2, 2, 3, 1};
	     
	     System.out.println(isRotated(a4, a3));
	     
	     int [] a5 = {1, 2, 3};
	     int [] a6 = {2, 3, 1};
	     
	     System.out.println(isRotated(a5, a6));
	     
	     int [] a7 = {1, 2, 2, 3};
	     int [] a8 = {2, 3, 1, 2};
	     
	     System.out.println(isRotated(a7, a8));
	     
	     int [] a9 = {1, 2, 2, 3};
	     int [] a10 = {2, 3, 1, 3};
	     
	     System.out.println(isRotated(a9, a10));
	     
	}
}
