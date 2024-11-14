package edu.grinnell.csc207.experiments;

import java.io.PrintWriter;

import edu.grinnell.csc207.util.BinaryTree;

/**
 * A place to experiment with binary trees.
 */
public class BinaryTreeExperiments {
  // +------+--------------------------------------------------------
  // | Main |
  // +------+

  /**
   * Run our experiments.
   *
   * @param args
   *   Command-line arguments (currently ignored).
   */
  public static void main(String[] args) {
    PrintWriter pen = new PrintWriter(System.out, true);

    String[] strings = {"aardvark", "billygoat", "chinchilla", "dingo", "emu",
        "frog", "gnu", "hippo", "iguana", "jackalope", "koala", "llama", "mongoose", "narwhal"};
    BinaryTree<String> tree = new BinaryTree<>(strings);

    pen.println("Tree Structure (Dump):");
    tree.dump(pen);

    pen.println("\nNon-Recursive Depth-First Preorder Traversal:");
    tree.print(pen);

    pen.close();
  } // main
} // class BinaryTreeExperiments