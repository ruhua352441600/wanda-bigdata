package org.wanda.data_struct;

public class BinaryTree {
    Node root;

    private Node addNode(Node current, int value){
        if(current == null){
            //System.out.println(value + " is root.");
            return new Node(value);
        }else {
            System.out.println("current data is " + current.data);
            if (value< current.data){
                current.left = addNode(current.left, value);
                System.out.println(value + " is left.");
            }else if (value > current.data){
                current.right = addNode(current.right, value);
                System.out.println(value + " is right.");
            }else{
                return current;
            }
        }
        return current;
    }

    public void addNode(int value){
        root = addNode(root, value);
        // System.out.println(root.data);
    }
}
