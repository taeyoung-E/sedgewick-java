package tree;

public class BST {
    Node root;
    BST(Node root){
        this.root = root;
    }

    public Node find(int value){ //Using iterative ways
        Node temp = root;
        while(temp != null){
            if(value == temp.value){
                return temp;
            }
            else if(value < temp.value){
                temp = temp.left;
            }
            else{
                temp = temp.right;
            }
        }
        return null;
    }

    public Node findR(int value){ //R stands for recursive
        return findHelper(root,value);
    }

    private Node findHelper(Node node, int value){ //Using recursion
        if(node == null)
            return null;
        if(node.value == value)
            return node;
        if(value < node.value)
            return findHelper(node.left,value);
        return findHelper(node.right,value);
    }

    public boolean insert(Node node){ //Assume no duplicate values
        if(root == null){
            root = node;
            return true;
        }
        return insertHelper(root,node);
    }

    private boolean insertHelper(Node current, Node insert){
        if(insert.value == current.value) return false;
        if(insert.value < current.value){
            if(current.left == null){
                current.left = insert;
                return true;
            }
            return insertHelper(current.left,insert);
        }
        if(current.right == null){
            current.right = insert;
            return true;
        }
        return insertHelper(current.right,insert);
    }

    public void delete(int value){

    }

    public Node max(){
        if(root == null)
            return null;
        return maxHelper(root);
    }

    private Node maxHelper(Node node){ //Iterative is straightforward so recursive method only
        if(node.right == null)
            return node;
        return maxHelper(node.right);
    }
    public Node min(){ //Same as above
        if(root == null)
            return null;
        return minHelper(root);
    }

    private Node minHelper(Node node){
        if(node.left == null)
            return node;
        return minHelper(node.left);
    }



    public static class Node{
        Node left;
        Node right;
        int value;

        public Node(int value){
            this.value = value;
        }
    }
}
