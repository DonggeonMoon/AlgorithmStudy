package search;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import search.binary.BinarySearch;
import search.sequential.SequentialSearch;
import sort.bubble.BubbleSort;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SearchTest {
    @ParameterizedTest
    @CsvSource({
            "1, 0",
            "3, 1",
            "5, 2",
            "7, 3",
            "9, 4",
            "11, 5",
            "13, 6",
            "15, 7"
    })
    void testSequentialSearch(int target, int index) {
        int[] input = {1, 3, 5, 7, 9, 11, 13, 15};

        SequentialSearch sequentialSearch = SequentialSearch.create();
        int result = sequentialSearch.search(input, target);

        System.out.println("The target index: " + result);

        assertEquals(index, result);
    }

    @ParameterizedTest
    @CsvSource({
            "1, 0",
            "3, 1",
            "5, 2",
            "7, 3",
            "9, 4",
            "11, 5",
            "13, 6",
            "15, 7"
    })
    void testBinarySearch(int target, int index) {
        int[] input = {1, 3, 5, 7, 9, 11, 13, 15};

        BinarySearch binarySearch = BinarySearch.from(BubbleSort.create());
        int result = binarySearch.search(input, target);

        System.out.println("The target index: " + result);

        assertEquals(index, result);
    }

    @Test
    void testInterpolationSearch() {
        int[] input = {1, 3, 5, 7, 9, 11, 13, 15};

        for (int i = 0; i < input.length; i++) {
            int result = interpolationSearch(input, input[i]);
            System.out.println("The target index: " + result);
            assertEquals(i, result);
        }
    }

    private int interpolationSearch(int[] input, int target) {
        int left = 0;
        int right = input.length - 1;

        while (left <= right && input[left] <= target && input[right] >= target) {
            int position = left + (target - input[left]) / (input[right] - input[left]) * (right - left);

            if (input[position] == target) {
                return position;
            }

            if (input[position] < target) {
                left = position + 1;
            } else {
                right = position - 1;
            }
        }
        throw new NotFoundException();
    }

    @Test
    void testHashSearch() {
        String[] inputKeys = {"사과", "바나나", "오렌지", "포도"};
        int[] inputValues = {50, 30, 20, 40};

        for (int i = 0; i < inputKeys.length; i++) {
            int result = hashSearch(inputKeys, inputValues, inputKeys[i]);
            System.out.println("The target index: " + result);
            assertEquals(inputValues[i], result);
        }
    }

    private int hashSearch(String[] inputKeys, int[] inputValues, String target) {
        HashTable hashTable = new HashTable(inputKeys, inputValues);

        return hashTable.get(target);
    }

    static class HashTable {
        final int DEFAULT_ARRAY_SIZE = 100;
        String[] keys;
        int[] values;

        HashTable(String[] inputKeys, int[] inputValues) {
            keys = new String[DEFAULT_ARRAY_SIZE];
            values = new int[DEFAULT_ARRAY_SIZE];
            for (int i = 0; i < inputKeys.length; i++) {
                put(inputKeys[i], inputValues[i]);
            }
        }

        private int hash(String key) {
            return Math.abs(key.hashCode() % DEFAULT_ARRAY_SIZE);
        }

        public void put(String key, int value) {
            keys[hash(key)] = key;
            values[hash(key)] = value;
        }

        public int get(String key) {
            if (key != null && keys[hash(key)].equals(key)) {
                return values[hash(key)];
            } else {
                throw new NotFoundException();
            }
        }
    }

    @Test
    void testBinaryTreeSearch() {
        BinaryTree binaryTree = new BinaryTree();

        binaryTree.insert(50);
        binaryTree.insert(30);
        binaryTree.insert(20);
        binaryTree.insert(40);
        binaryTree.insert(70);
        binaryTree.insert(60);
        binaryTree.insert(80);

        assertTrue(binaryTree.search(40));
    }

    static class BinaryTree {
        Node root;

        public BinaryTree() {
            root = null;
        }

        public void insert(int data) {
            root = insertRecursive(root, data);
        }

        private Node insertRecursive(Node root, int data) {
            if (root == null) {
                root = new Node(data);
                return root;
            }

            if (data < root.data) {
                root.left = insertRecursive(root.left, data);
            } else if (data > root.data)
                root.right = insertRecursive(root.right, data);

            return root;
        }

        public void delete(int data) {
            root = deleteRecursive(root, data);
        }

        private Node deleteRecursive(Node root, int data) {
            if (root == null) {
                return root;
            }
            if (data < root.data) {
                root.left = deleteRecursive(root.left, data);
            } else if (data > root.data) {
                root.right = deleteRecursive(root.right, data);
            } else {
                if (root.left == null) {
                    return root.right;
                } else if (root.right == null) {
                    return root.left;
                }

                root.data = minValue(root.right);
                root.right = deleteRecursive(root.right, root.data);
            }

            return root;
        }

        private int minValue(Node root) {
            int minValue = root.data;
            while (root.left != null) {
                minValue = root.left.data;
                root = root.left;
            }
            return minValue;
        }

        public boolean search(int data) {
            if (!searchRecursive(root, data)) {
                throw new NotFoundException();
            }
            return true;
        }

        private boolean searchRecursive(Node root, int data) {
            if (root == null) {
                return false;
            }

            if (data == root.data) {
                return true;
            }

            if (data < root.data) {
                return searchRecursive(root.left, data);
            }

            return searchRecursive(root.right, data);
        }


    }

    static class Node {
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    @Test
    void testAvlTreeSearch() {
        AvlTree avlTree = new AvlTree();
        avlTree.insert(10);
        avlTree.insert(20);
        avlTree.insert(30);
        avlTree.insert(40);
        avlTree.insert(50);
        avlTree.insert(25);

        avlTree.inorderTraversal(avlTree.root);
    }

    static class AvlTree {
        private Node root;

        private int height(Node node) {
            if (node == null) {
                return 0;
            }
            return node.height;
        }

        private void updateHeight(Node node) {
            node.height = Math.max(height(node.left), height(node.right));
        }

        private int balanceFactor(Node node) {
            if (node == null) {
                return 0;
            }
            return height(node.left) - height(node.right);
        }

        private Node rightRotate(Node y) {
            Node x = y.left;
            Node N2 = x.right;

            x.right = y;
            y.left = N2;

            updateHeight(y);
            updateHeight(x);

            return x;
        }

        private Node leftRotate(Node x) {
            Node y = x.right;
            Node N2 = y.left;

            y.left = x;
            x.right = N2;

            updateHeight(x);
            updateHeight(y);

            return y;
        }

        public Node insert(Node node, int data) {
            if (node == null) {
                return new Node(data);
            }

            if (data < node.data) {
                node.left = insert(node.left, data);
            } else if (data > node.data) {
                node.right = insert(node.right, data);
            } else {
                return node;
            }

            updateHeight(node);

            int balance = balanceFactor(node);

            if (balance > 1 && data < node.left.data) {
                return rightRotate(node);
            }

            if (balance < -1 && data > node.right.data) {
                return leftRotate(node);
            }

            if (balance > 1 && data > node.left.data) {
                node.left = leftRotate(node.left);
                return rightRotate(node);
            }

            if (balance < -1 && data < node.right.data) {
                node.right = rightRotate(node.right);
                return leftRotate(node);
            }

            return node;
        }

        public void inorderTraversal(Node node) {
            if (node != null) {
                inorderTraversal(node.left);
                System.out.println(node.data + " ");
                inorderTraversal(node.right);
            }
        }

        public void insert(int data) {
            root = insert(root, data);
        }

        static class Node {
            int data;
            Node left;
            Node right;
            int height;

            public Node(int data) {
                this.data = data;
                left = null;
                right = null;
                height = 1;
            }
        }
    }

    static class NotFoundException extends RuntimeException {
        public NotFoundException() {
            super("The target value does not exist!");
        }

    }
}
