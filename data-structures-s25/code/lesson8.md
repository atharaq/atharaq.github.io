# Lesson 8 Code

Instead of sharing this via GHC, you can simply copy/paste this into your existing workspace (IntelliJ or VSCode) for now.

```java
public class BinaryTree<T extends Comparable<? super T>> {

    private static class TreeNode<T> {
        T data;
        TreeNode<T> left;
        TreeNode<T> right;
        int height = 0;

        TreeNode(T d, TreeNode<T> l, TreeNode<T> r) {
            data = d;
            left = l;
            right = r;
        }
    }

    private TreeNode<T> root;

    public void printTree() {
        if (isEmpty()) {
            System.out.println("Empty tree");
        }

        printTree(root);
    }

    private void printTree(TreeNode<T> tree) {
        if (tree != null) {
            printTree(tree.left);
            System.out.println(tree.data);
            printTree(tree.right);
        }
    }

    public void insert(T item) {
        root = insert(root, item);
    }

    private TreeNode<T> insert(TreeNode<T> subtree, T item) {
        if (subtree == null) {
            return new TreeNode<>(item, null, null);
        }

        int comparison = item.compareTo(subtree.data);
        if (comparison < 0) {
            // what we are inserting is smaller than the subtree root
            // so we should insert on the left subtree
            subtree.left = insert(subtree.left, item);
        } else if (comparison > 0) {
            subtree.right = insert(subtree.right, item);
        } // if comparison == 0: for simplicity's sake, we'll assume no duplicates
        // or we think of a binary tree as representing a set of unique elements in order

        return balance(subtree);
    }

    public boolean contains(T item) {
        // TODO: implement
        return contains(root, item);
    }

    private boolean contains(TreeNode<T> subtree, T item) {
        // first thing to check:
        // what happens if subtree is null?
        // if you forget this you might hit NPE's
        // this is your base case anyway

        if (subtree == null) {
            return false;
        }

        int comparison = item.compareTo(subtree.data);
        if (comparison == 0) {
            return true;
        } else if (comparison < 0) {
            return contains(subtree.left, item);
        } else return contains(subtree.right, item);
    }

    public void remove(T item) {
        root = remove(root, item);
    }

    private TreeNode<T> remove(TreeNode<T> subtree, T item) {
        if (subtree == null) {
            return null;
        }
        int comparison = item.compareTo(subtree.data);
        if (comparison < 0) {
            // update left subtree, delete item from subtree.left?
            subtree.left = remove(subtree.left, item);
        } else if (comparison > 0) {
            // update right subtree, delete item from subtree.right?
            subtree.right = remove(subtree.right, item);
        } else {
            // remove this node!
            if (subtree.left == null && subtree.right == null) {
                return null;
            } else if (subtree.left == null) {
                subtree = subtree.right;
            } else if (subtree.right == null) {
                subtree = subtree.left;
            } else {
                T successor = findMin(subtree.right);
                subtree.data = successor;
                subtree.right = remove(subtree.right, successor);
            }
        }
        return balance(subtree);
    }

    private T findMin(TreeNode<T> subtree) {
        if (subtree == null) {
            return null;
        }

        while (subtree.left != null) {
            subtree = subtree.left;
        }
        return subtree.data;
    }

    public boolean isEmpty() {
        return root == null;
    }

    private int height(TreeNode<T> subtree) {
      if (subtree == null) {
        return -1;
      } else return subtree.height;
    }

    private TreeNode<T> balance(TreeNode<T> subtree) {
      // figure out the height of the left vs height of the right.

      // if it differs by more than +/- 1, then figure out which rotation(s) are needed

      // update height and return the new subtree
      subtree.height = 1 + Math.max(height(subtree.left), height(subtree.right));
      return subtree;  
    }

    private TreeNode<T> rotateLeft(TreeNode<T> subtree) {
      // make subtree's right child the new root of this subtree
      // update all the relevant pointers (subtree.right, root.left)
      return subtree;
    }

    private TreeNode<T> rotateRight(TreeNode<T> subtree) {
      return subtree;
    }

    public static void main(String[] args) {
        BinaryTree<Integer> tree = new BinaryTree<>();
        for (int i = 0; i < 30; i++) {
          tree.insert(i);
        }

        tree.printTree();
        System.out.println();
        System.out.println("Tree height: " + height(tree.root));
    }
}
```