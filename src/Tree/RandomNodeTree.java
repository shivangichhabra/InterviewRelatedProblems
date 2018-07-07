package Tree;

import java.util.Random;

public class RandomNodeTree {

    Node root;
    public int size(){
        return root != null ? root.size() : 0;
    }

    /*
    balanced tree - Time O(logN)
     */
    public Node getRandomNode(){
        if(root == null)
            return null;

        Random rand = new Random();
        int i = rand.nextInt(size());
        return root.getIthNode(i);
    }

    public void insertInOrder(int value) {
        if(root == null)
            root = new Node(value);
        else
            root.insert(value);
    }

    class Node {
        int data;
        int size;
        Node left,right;

        public Node(int data){
            this.data = data;
            this.size = 1;
        }

        public Node getIthNode(int i){
            int leftSize = left == null ? 0 : left.size();
            if( i ==  leftSize)
                return this;
            else if (i < leftSize)
                return left.getIthNode(i);
            else
                return right.getIthNode(i - (leftSize+1));
        }

        public void insert(int d){
            if(d <= data){
                if( left == null)
                    left = new Node(d);
                else
                    left.insert(d);
            } else {
                if( right == null)
                    right = new Node(d);
                else
                    right.insert(d);
            }
            size++;

        }

        public Node find(int d){
            if(d == data)
                return this;
            else if ( d < data)
                return  left != null ? left.find(d) : null;
            else if ( d >  data)
                return right != null ? right.find(d) : null;
            else
                return null;
        }

        public int size(){
            return size;
        }

        public int data(){
            return data;
        }
    }

}
