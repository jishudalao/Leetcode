package leetcodemianshi35;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Leetcodemianshi35 {
	public static Node copyRandomList(Node head) {
		/*
        Node pre = head;
        List<Node> list1 = new ArrayList<>();
        List<Node> list2 = new ArrayList<>();
        while(pre!=null) {
        	list1.add(pre);
        	pre = pre.next;
        }
        Node pre2 = head;
        while(pre2!=null) {
        	list2.add(pre2.random);
        	pre2 = pre2.next;
        }
        Node node = new Node(-1);
        Node res = node;
        for(int i=0;i<list1.size();i++) {
        	node.next = list1.get(i);
        	node.random = list2.get(i);
        	node = node.next;
        }
        node.next = res;
        return res.next;*/
		if(head == null)  return null;
        Node node = head;
        Map<Node,Node> map = new HashMap<Node,Node>();
        //1.loop copy all node in map
        while(node!=null){
            map.put(node,new Node(node.val));
            node = node.next;
        }

        node = head;
        //2.loop assign next and random pointer
        while(node!=null){
            map.get(node).next = map.get(node.next);//next 
            map.get(node).random = map.get(node.random);
            node = node.next;
        }
        return map.get(head);
    }
	public static void main(String[] args) {
		
	}
}
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}