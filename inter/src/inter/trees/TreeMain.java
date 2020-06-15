package inter.trees;

public class TreeMain {

	/*
	 * 		a
	 *    b   c  
	 *   d e
	 * 
	 */
	public static void main(String [] args) {
		Node root1 = new Node("a");
		Node b = new Node("b");
		Node c = new Node("c");
		root1.setLeft(b);
		root1.setRight(c);
		
		Node d = new Node("d");
		Node e = new Node("e");
		b.setLeft(d);
		b.setRight(e);
		
		
		Node root2 = new Node("a");
		b = new Node("b");
		c = new Node("c");
		root2.setLeft(b);
		root2.setRight(c);
		
		d = new Node("d");
		e = new Node("e");
		b.setLeft(d);
		b.setRight(e);
		
		Node f = new Node("f");
		//c.setLeft(f);
		
		System.out.println(BinaryTreeOps.isMirror(root1, root2));
	}
}
