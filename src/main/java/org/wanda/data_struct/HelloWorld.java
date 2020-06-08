package org.wanda.data_struct;


import java.util.LinkedList;

public class HelloWorld {
    public static void main(String[] args){
        BinaryTree bt = new BinaryTree();
        bt.addNode(6);
        bt.addNode(4);
        bt.addNode(5);
        bt.addNode(8);
        bt.addNode(3);
        bt.addNode(9);
        bt.addNode(7);

        bt.addNode(1);
        preOrderTraverse1(bt.root);
        System.out.println();
        midOrderTraverse1(bt.root);
        System.out.println();
        postOrderTraverse1(bt.root);
        System.out.println();
        levelTraverse(bt.root);
    }
    //先序遍历二叉树 根-->左-->右
    public static void preOrderTraverse1(Node root){
        if(root != null){
            System.out.print(root.data + " ");
            preOrderTraverse1(root.left);
            preOrderTraverse1(root.right);
        }
    }
    //中序遍历二叉树 左-->根-->右
    public static void midOrderTraverse1(Node root){
        if(root != null){
            midOrderTraverse1(root.left);
            System.out.print(root.data + " ");
            midOrderTraverse1(root.right);
        }
    }
    //后序遍历二叉树 左-->右-->根
    public static void postOrderTraverse1(Node root){
        if(root != null){
            postOrderTraverse1(root.left);
            postOrderTraverse1(root.right);
            System.out.print(root.data + " ");
        }
    }

    //层次遍历
    public static void levelTraverse(Node root){
        if(root == null){
            return;
        }
        String list = "";
        LinkedList<Node> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            Node node = queue.remove();
            list = list + node.data + " ";
            if(node.left != null){
                queue.add(node.left);
            }
            if(node.right != null){
                queue.add(node.right);
            }
        }
        System.out.println(list);
    }
}
