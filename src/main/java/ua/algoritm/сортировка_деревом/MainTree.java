package ua.algoritm.сортировка_деревом;

/**
 *
 *O(n log n) Данный подход основан на создании root и ветвтлении в зависимости от > <
 *
 * */
public class MainTree {

    public static void main(String[] args) {
        int[] testData = {76,1,1, 523, 21, 1};
        Tree tree = new Tree();
        tree.insertElementOfArray(testData);
        tree.orderedNode(tree.root);
    }
}

class Tree {
    Node root;
    public Tree() {
        this.root = null;
    }

    class Node {
        int value;
        Node left, right;

        public Node(int value) {
            this.value = value;
            this.left = this.right = null;
        }
    }

    void insertElementOfArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            insert(arr[i]);
        }
    }

    private void insert(int i) {
        root = insertNode(root, i);
    }

     Node insertNode(Node root, int value) {
        if (root == null) {
            return new Node(value);
        }
        if (root.value > value) {
            root.left = insertNode(root.left, value);
        } else if (root.value < value) {
            root.right = insertNode(root.right, value);
        }
        return root;
    }

     void orderedNode(Node root) {
        if (root != null) {
            orderedNode(root.left);
            System.out.print(root.value + " ");
            orderedNode(root.right);
        }
    }
}

/*class GFG {
    // Класс, содержащий left и
    // правый потомок текущего
    // узел и значение ключа

    class Node {
        int key;
        Node left, right;
        public Node(int item) {
            key = item;
            left = right = null;
        }
    }
    // Корень BST
    Node root;
    // Конструктор
    GFG() {
        root = null;
    }
    // Этот метод в основном // вызывает insertRec ()
    void insert(int key) {
        root = insertRec(root, key);
    }
    *//*
    Рекурсивная функция для вставить новый ключ в BST *//*

    Node insertRec(Node root, int key) {
        *//* Если дерево пусто, вернуть новый узел *//*
        if (root == null) {
            root = new Node(key);
            return root;
        }
        *//*В противном случае повторить вниз по дереву *//*

        if (key < root.key)
            root.left = insertRec(root.left, key);
        else if (key > root.key)
            root.right = insertRec(root.right, key);
        *//*вернуть рут *//*
        return root;
    }
    // Функция для выполнения
    // обход порядка BST
    void inorderRec(Node root) {
        if (root != null) {
            inorderRec(root.left);
            System.out.print(root.key + " ");
            inorderRec(root.right);
        }
    }

    void treeins(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            insert(arr[i]);
        }
    }
}*/
