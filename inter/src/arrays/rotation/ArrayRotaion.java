package arrays.rotation;

import java.util.Map;

public class ArrayRotaion {

	public static void main(String[] args) {
		 int [] a1 = {2, 3, 2, 4};
	     int [] a2 = {3, 2, 4, 2}; 
	     
	     boolean isEquals = isRotated(a1, a2);
	     System.out.println(isEquals);
	}
	
	/*
	 * This solution will not work for Duplicates
	 * But if there is duplicates, then we can check the duplicate count and run it in the loop
	 * eg> if in above array, element 2 is present 2 times in the array
	 * 		we can find both the index - and run isRotated for both the index - until the isRotated returns True
	 * Currently isRotated in implemented considering the index-0 of a[1] - which can be modified.
	 */
	private static boolean isRotated(int [] a1, int [] a2) {
		if(a1.length!=a2.length)
			return false;
		
		int pos = findPosition(a2, a1[0]);
		return isRotated(a1, a2, pos);
	}
	
	private static boolean isRotated(int [] a1, int [] a2, int pos) {
		
		if(pos<0)
			return false;
	
		int i = 1;	// pointer for a1
		int j;		// pointer for a2
		
		if(pos==a2.length-1)
			j=0;
		else
			j = pos+1;

		while(j!=pos && i<a1.length) {
			if(a1[i++] != a2[j])
				return false;
			else if(j++ ==a2.length-1)
				j=0;
		}
		
		return true;
	}

	private static int findPosition(int [] a, int e){
		for(int i=0; i<a.length; i++)
			if(a[i] == e)
				return i;
		
		return -1;
	}
}
