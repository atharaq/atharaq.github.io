# Data Structures Lesson 5: Circular Queues and Trees
{:.no_toc}

1. Table of Contents
{:toc}

# Circular Queues

Last time we described circular queues, but ran out of time before we could try to come up with a strategy for implementing one. I encourage you to think through this on your own, before you watching the next video. How would you implement a circular queue using an array of a fixed size? Remember that in a queue, you "enter" from the back, and "leave" from the front, so you need to keep track of those two. Dequeueing is just looking at the item in the "front" position, and moving the front up one (cycling around if you have to). (So we don't actually "delete" anything from memory, we just move the pointers around.)

How can you tell if the queue is full? How can you tell if the queue is empty? Try to draw out the picture, and see what happens when you insert and remove a few items. Think this through, then watch the videos:

<div class="youtube-container">

</div>

This next video goes through an actual implementation of a circular queue, using a test driven format. I show how to create unit tests in IntelliJ so that you can try that out on your own as well.

<div class="youtube-container">

</div>

# Trees

One of the most important abstract data types we will encounter this semester is the tree. A **tree** is a set of nodes with the following relationships:

* Every node has an edge (or link) with one parent node
* There is one, unique **root** node.

We will usually look at **binary** trees, and, more specifically, **binary search trees**. These provide a data structure abstraction of the idea of the binary search algorithm. The idea is that if a tree is "balanced", if there are $N$ nodes, roughly half of them will be on the "left" subtree and half on the "right".

![Binary tree](https://upload.wikimedia.org/wikipedia/commons/f/f7/Binary_tree.svg)

## Definitions

* **arity**: the maximum number of children a node in a tree has. (This might not be defined on an infinite tree). A tree of arity 2 is called a **binary tree**.
* **leaf**: a node which has no children.
* **path**: a path in a tree is a set of nodes $n_1, n_2, \ldots, n_k$ such that each $n_i$ is the parent of $n_{i+1}$. This path has **length** $k −1$, because there are $k − 1$ steps to go from $n_1$ to $n_k$.
* **height**: the height of a tree is the length of the longest path starting at the root and ending at a leaf.

## Binary Search Trees

A **binary search tree** is a binary tree with the property that for each node, every data item in that node's left subtree is smaller than the data item in that node, and every data item in that node's right subtree is greater than the data item in that node.

![Binary search tree](https://upload.wikimedia.org/wikipedia/commons/d/da/Binary_search_tree.svg)

## Traversals

For a List structure, there is only one logical way to visit the elements in the structure. For a tree, though, there are multiple. The following recursive code snippet outputs the nodes of the tree using an **in-order traversal**

```java
private void printTree(TreeNode<T> tree) {
    if (tree != null) {
        printTree(tree.left);
        System.out.println(tree.data);
        printTree(tree.right);
    }
}
```

What does this output if the tree contains the following:

![Binary search tree](https://upload.wikimedia.org/wikipedia/commons/d/da/Binary_search_tree.svg)

What about if we modified the code to use a **pre-order** traversal:

```java
private void printTree(TreeNode<T> tree) {
    if (tree != null) {
        System.out.println(tree.data);      
        printTree(tree.left);
        printTree(tree.right);
    }
}
```

What would happen if we used a **post-order** traversal:

```java
private void printTree(TreeNode<T> tree) {
    if (tree != null) {     
        printTree(tree.left);
        printTree(tree.right);
        System.out.println(tree.data);
    }
}
```

<details>
<summary>Check your answers</summary>
<ul>
<li>In-order: 1, 3, 4, 6, 7, 8, 10, 13, 14</li>
<li>Pre-order: 8, 3, 1, 6, 4, 7, 10, 14, 13</li>
<li>Post-order: 1, 4, 7, 6, 3, 13, 14, 10, 8</li>
</ul>
</details>

## Insertion

To implement the basic insert, contains, and "remove" methods, we similarly use recursion. The idea behind insert is to recursively binary search the tree to find the correct place to add a new node:

* If the root of the tree is null, create a new node with this data item, and make that the new root.
* If the item we wish to insert is less than the element in the root node, recursively insert this item into the root node's left subtree.
* Otherwise, recursively insert the item into the root node's right subtree.

```java
public void insert(T item) {
    root = insert(root, item);
}

private TreeNode<T> insert(TreeNode<T> subtree, T item) {
    if (subtree == null) {
        return new TreeNode<T>(item, null, null);
    }

    int comparison = item.compareTo(subtree.data);

    if (comparison < 0) {
        subtree.left = insert(subtree.left, item);
    } else if (comparison > 0) {
        subtree.right = insert(subtree.right, item);
    } // if comparison == 0, then it's a duplicate, we ignore it.
      // some tree implementations allow duplicates, then we'd have a decision to make.

    return subtree;
}
```

We use this paradigm of having a public method which calls a private method to handle the recursion. Moreover, we need to make the recursive method return the "updated" tree, so that we can modify the underlying tree. In particular, this makes sure that if the tree is empty (so root is null initially), root will be updated.

## CodingRooms Exercise

On CodingRooms, you are to implement the **contains** method. Use a similar paradigm: recursively binary search for the item. How do you know to return false? (Hint: what's your base case for your recursion?)

## Removal

You don't need to submit this, but think about how you might implement the **remove** method. It's a bit more involved, so we can talk about it more on Monday, but try to think it through yourself. Think about the following questions:

* How do you remove a node if it has no children?
* How do you remove a node if it has one child?
* How do you remove a node if it has two children? We have a choice to make, but the idea we will use is to replace the node by its successor (the next largest element in the tree).

# Theory (10)

From the implementation, we can see that the running times of the basic operations (insert, remove, contains) of a tree are all roughly proportional to the height of the tree. Let's do some simple asymptotic analysis for now to determine these running times.

## Complete Trees

Informally, if the tree is balanced, then each node will have roughly half of its descendants in its left subtree, and half in its right. Therefore, going from a root to a leaf roughly involves discarding half of the nodes left at any given point. If a tree has $N$ nodes, then, the question becomes: how many times can you cut $N$ in half before getting to 1? The answer is $\log_2(N)$, and so, in the ideal case, the running times of all the operations of a tree are $O(\log(N))$.

Let's make this more formal with some definitions.

* The **level** of a node in a tree is the length of the path from the root to that node. Example: the root is at level 0, its children are at level 1, etc. The height of the tree is equal to the highest level of the tree.
* A **full** binary tree is a tree for which every non-leaf node has exactly 2 children.
* A **complete** binary tree is a binary tree in which every level (possibly except the last) is completely filled, and all nodes are as fall left as possible.

**Exercise** (Might be homework at some point): Suppose $T$ is a complete binary tree of height $h$ and the last level is completely filled. Then $T$ has exactly $2^{h+1} - 1$ nodes.

This exercise means that a complete binary tree of height $h$ has between $2^h$ and $2^{h+1} - 1$ nodes. That is:

* a tree of height 0 will have 1 node
* a tree of height 1 will have between 2 and 3 nodes
* a tree of height 2 will have between 4 and 7 nodes
* a tree of height 3 will have between 8 and 15 nodes

etc.

In general, then, if $T$ is a complete tree with $N$ nodes, then its height is $\lfloor \log_2(N) \rfloor$; that is, the height of the tree is $O(\log(N))$.

Insert is fairly clearly going to take $O(\log(N))$ steps in this case then. This is because you need to travel down entirely through one path of a tree from the root to a leaf, and then insert below that leaf. That is, insertion doesn't happen until the "subtree" is null. That takes $h$ steps, where $h$ is the height of the tree.

What about contains? On average, how many steps will it take to find a node in the tree? For each node at level $l$, it takes $l$ steps to find that node. There are $2^l$ nodes on each level (you can prove this by induction), and $2^{h+1} - 1$ nodes in total. That means, the average level of a node is:

$$\frac{1}{2^{h+1} - 1} \sum_{l=1}^{h} l \times 2^l$$

We won't try to come up with a solution for this finite series, we just need to look for an upper bound. Since $l \leq h$, we have that the above term is bounded by

$$\frac{h}{2^{h+1} - 1} \sum_{l=1}^h 2^l$$

Since the sum of $2^l$ from $l = 1$ to $h$ is $2^{h+1} - 2$ (you can prove this by induction), this term is roughly $h$, or $O(\log(N))$.

## Worst Case

Now I'd like you to think about the worst case. Remember, the running times are all based on the height of the tree. Given a tree with $N$ nodes, what's the worst possible height of such a tree? What insertion order gives that height?

Next week (hopefully), we'll start talking about trees that are **self-balancing**, which will prevent the tree from getting too unbalanced. There are several methods to do this, but we will look at one particular implementation.
