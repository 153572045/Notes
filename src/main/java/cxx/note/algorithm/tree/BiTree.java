package cxx.note.algorithm.tree;

public class BiTree {

    private Node root;

    public boolean addNode(Node node, int data) {
        if(node == null) {
            node = new Node(data, null, null);
            return true;
        }
        if(node.data == data) {
            System.out.println("there is a same data");
            return false;
        }
        else if(node.data > data) {
            return addNode(node.left, data);
        }
        return addNode(node.right, data);
    }

    public void initBiTree(int[] arr) {
        if(arr == null || arr.length == 0) {
            return ;
        }
        for(int i = 0; i < arr.length; ++i) {
            addNode(root, arr[i]);
        }
    }

    public Node search(Node node, int data) {
        if(node == null) {
            return null;
        }
        if(node.data == data) {
            return node;
        }
        else if(node.data < data) {
            return search(node.right, data);
        }
        return search(node.left, data);
    }

    public Node deleNode(Node node, int data) {
        return null;
    }

    public Node getRoot() {
        return root;
    }

    public void setRoot(Node root) {
        this.root = root;
    }


    public class Node {
        int data;
        Node left;
        Node right;

        public Node(int data, Node left, Node right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }

        public Node(Node node) {
            this.data = node.data;
            this.left = node.left;
            this.right = node.right;
        }
    }
}
