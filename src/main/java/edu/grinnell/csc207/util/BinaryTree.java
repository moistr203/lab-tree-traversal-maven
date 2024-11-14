package edu.grinnell.csc207.util;

import java.io.PrintWriter;
import java.util.Iterator;
import java.util.Stack;

/**
 * Simple binary trees.
 *
 * @param <T>
 *   The type of value stored in the tree.
 */
public class BinaryTree<T> implements Iterable<T> {

  // +--------+------------------------------------------------------
  // | Fields |
  // +--------+

  /**
   * The root of the tree.
   */
  BinaryTreeNode<T> root;

  /**
   * The number of values in the tree.
   */
  int size;

  // +--------------+------------------------------------------------
  // | Constructors |
  // +--------------+

  /**
   * Create a new, empty, tree.
   */
  public BinaryTree() {
    this.size = 0;
    this.root = null;
  } // BinaryTree

  /**
   * Create a new, somewhat balanced, tree.
   *
   * @param values
   *   The values to put in the tree.
   */
  public BinaryTree(T[] values) {
    this.size = values.length;
    this.root = makeTree(values, 0, values.length);
  } // BinaryTree(T[])

  // +---------+-----------------------------------------------------
  // | Methods |
  // +---------+

  /**
   * Dump the tree to some output location.
   *
   * @param pen
   *   The output location.
   */
  public void dump(PrintWriter pen) {
    dump(pen, root, "");
  } // dump(PrintWriter)

  /**
   * Print elements of the tree in a single line, in in-order traversal (left-to-right).
   *
   * @param pen The output location.
   */
  public void elements01(PrintWriter pen) {
    elements01Helper(pen, root);
    pen.println();
  }

  private void elements01Helper(PrintWriter pen, BinaryTreeNode<T> node) {
    if (node == null) return;
    elements01Helper(pen, node.left);
    pen.print(node.value + " ");
    elements01Helper(pen, node.right);
  }

  /**
   * Print elements of the tree in a single line, in pre-order traversal (left-to-right).
   *
   * @param pen The output location.
   */
  public void elements02(PrintWriter pen) {
    elements02Helper(pen, root);
    pen.println();
  }

  private void elements02Helper(PrintWriter pen, BinaryTreeNode<T> node) {
    if (node == null) return;
    pen.print(node.value + " ");
    elements02Helper(pen, node.left);
    elements02Helper(pen, node.right);
  }

  /**
   * Non-recursive pre-order traversal using a stack.
   *
   * @param pen The output location.
   */
  public void nonRecursivePreOrderTraversal(PrintWriter pen) {
    if (root == null) return;

    Stack<BinaryTreeNode<T>> stack = new Stack<>();
    stack.push(root);

    while (!stack.isEmpty()) {
      BinaryTreeNode<T> node = stack.pop();
      pen.print(node.value + " ");

      // Push right child first so that the left child is processed first
      if (node.right != null) {
        stack.push(node.right);
      }
      if (node.left != null) {
        stack.push(node.left);
      }
    }
    pen.println();
  }

  /**
   * Get an iterator for the tree.
   *
   * @return the iterator.
   */
  public Iterator<T> iterator() {
    return new Iterator<T>() {
      public boolean hasNext() {
        // STUB
        return false;
      } // hasNext()

      public T next() {
        // STUB
        return null;
      } // next()
    }; // new Iterator()
  } // iterator()

  // +---------+-----------------------------------------------------
  // | Helpers |
  // +---------+

  /**
   * Dump a portion of the tree to some output location.
   *
   * @param pen
   *   Where to dump the output.
   * @param node
   *   The node to dump.
   * @param indent
   *   How far to indent the dumped values.
   */
  void dump(PrintWriter pen, BinaryTreeNode<T> node, String indent) {
    if (node == null) {
      pen.println(indent + "<>");
    } else {
      pen.println(indent + node.value);
      if ((node.left != null) || (node.right != null)) {
        dump(pen, node.left, indent + "  ");
        dump(pen, node.right, indent + "  ");
      } // if has children
    } // else
  } // dump

  /**
   * Build a tree from a subarray from lb (inclusive) to ub (exclusive).
   *
   * @param values
   *   The array from which to draw values.
   * @param lb
   *   The lower bound of the subarray (inclusive).
   * @param ub
   *   The upper bound of the subarray (exclusive).
   *
   * @return
   *   The root of the newly made tree.
   */
  BinaryTreeNode<T> makeTree(T[] values, int lb, int ub) {
    if (ub <= lb) {
      return null;
    } else if (ub - lb == 1) {
      return new BinaryTreeNode<T>(values[lb]);
    } else {
      int mid = lb + (ub - lb) / 2;
      return new BinaryTreeNode<T>(values[mid], makeTree(values, lb, mid),
          makeTree(values, mid + 1, ub));
    } // if/else
  } // makeTree(T[], int, int)
  /**
 * Print all of the elements in the tree in depth-first, preorder, left-to-right order.
 *
 * @param pen The output location.
 */
public void print(PrintWriter pen) {
  if (root == null) return;

  Stack<BinaryTreeNode<T>> stack = new Stack<>();
  stack.push(root);

  while (!stack.isEmpty()) {
      BinaryTreeNode<T> node = stack.pop();
      pen.print(node.value + " ");

      // Push right child first so that the left child is processed first
      if (node.right != null) {
          stack.push(node.right);
      }
      if (node.left != null) {
          stack.push(node.left);
      }
  }
  pen.println();
}

} // class BinaryTree