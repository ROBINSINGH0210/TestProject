package algoQuestions;

import java.util.LinkedList;
import java.util.Queue;

public class ConnectNodesAtSameLevel {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static void printNodeAtSameLevel(CustomeNode node) {
		Queue<CustomeNode> queue = new LinkedList<>();

		queue.add(node);
		queue.add(null);
		while (!queue.isEmpty()) {
			CustomeNode n = queue.poll();
			if (n != null) {
				n.nextRight = queue.peek();
				if (n.left != null)
					queue.add(n.left);
				if (n.right != null)
					queue.add(n.right);
			} else if (!queue.isEmpty()) {
				queue.add(null);
			}

		}

	}
	
	public static void connectAtSameLevel(CustomeNode node) {
		CustomeNode root = node;
		
		while(root !=null) {
			CustomeNode curr = root;
			while(curr !=null) {
				if(curr.left !=null) {
					curr.left.nextRight = curr.right;
				}
				if(curr.right !=null && curr.nextRight !=null) {
					curr.right.nextRight = curr.nextRight.left; 
				}
				
				curr = curr.nextRight;
			}
			root = root.left;
		}
		
	}
}

class CustomeNode {
	int data;
	CustomeNode left, right;
	CustomeNode nextRight;

	CustomeNode(int data) {
		this.data = data;
		left = null;
		right = null;
		nextRight = null;
	}
};
