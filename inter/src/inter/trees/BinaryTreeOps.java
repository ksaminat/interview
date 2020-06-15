package inter.trees;

public class BinaryTreeOps {

	public static boolean isMirror(Node n1, Node n2) {
	
		if(n1==null && n2==null)
			return true;
		
		if(!compare(n1, n2))
			return false;
					
		boolean isEqual = isMirror(n1.getLeft(), n2.getLeft());
		if(!isEqual)
			return false;
		isEqual = isMirror(n1.getRight(), n2.getRight());
		if(!isEqual)
			return false;
		
		return true;
	}
	
	private static boolean compare(Node n1, Node n2) {
		if(n1==null)
			return false;
		if(n2==null)
			return false;
		
		return n1.equals(n2);
	}
}
