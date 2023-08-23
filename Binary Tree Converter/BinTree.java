/* Creates a basic class for a Binary Search Tree*/


public class BinTree {
  private TreeNode root;


 public BinTree() { root = null; }


 public BinTree(int initValue)
 {
   root = new TreeNode(initValue);
 }


/* Subclass for Nodes */


 public class TreeNode{
   private int value;
   private TreeNode left;
   private TreeNode right;


   public TreeNode(int initValue)
   {
     value = initValue;
     left = null;
     right = null;
   }


   public TreeNode(int initValue, TreeNode initLeft, TreeNode initRight)
   {
     value = initValue;
     left = initLeft;
     right = initRight;
   }


   public int getValue() { return value; }


   public TreeNode getLeft() { return left; }


   public TreeNode getRight() { return right; }


   public void setValue (int newVal) { value = newVal; }


   public void setLeft (TreeNode newLeft) { left = newLeft; }


   public void setRight (TreeNode newRight) { right = newRight; }
 }


 private void recInsertItem (TreeNode current, TreeNode toInsert)
 {
   if (current.value == toInsert.value)
     return;
   if (current.value > toInsert.value) {
     if (current.left == null) {
       current.left = toInsert;
       return;
     }
     else recInsertItem (current.left, toInsert);
   }
   else {
     if (current.right == null) {
       current.right = toInsert;
       return;
     }
     else recInsertItem(current.right, toInsert);
   }
 }


 public void InsertItem(int item)
 {
   // TreeNode temp = new TreeNode (item);
   if (root == null) {
     root = new TreeNode(item);
     return;
   }
   else recInsertItem (root, new TreeNode(item));
 }


 public void InOrder () 
 {
   InOrder(root);
 }


 private void InOrder (TreeNode toStart)
 {
   //Base case
   if (toStart == null) {
        return;
    }
   else
   {
     //Displays left root right in a recursive way

     //Goes all the way to left
      InOrder(toStart.getLeft());
     //Prints root
      System.out.print(toStart.getValue() + " ");
     //All the way to the right
      InOrder(toStart.getRight());
   }
    
 }

 public void PreOrder() 
 {
    PreOrder(root);
 }


 private void PreOrder(TreeNode toStart)
 {
   //Base case
    if(toStart == null)
    {
      return;
    }
      //Displays root left right in a recursive way
    else
    {
      //Prints root
      System.out.print(toStart.getValue() + " ");
      //goes all the way to left
      PreOrder(toStart.getLeft());
      //Goes all the way to right
      PreOrder(toStart.getRight());
    }
 } 

  
 public void PostOrder() 
 {
    PostOrder(root);
 }


 private void PostOrder(TreeNode toStart)
 {
   //Base case
    if(toStart == null)
    {
      return;
    }
   //Displays left right root in a recursive way

   else
    {
      //Goes all the way to the left
      PostOrder(toStart.getLeft());
      //All the way to the right
      PostOrder(toStart.getRight());
      //Prints root
      System.out.print(toStart.getValue() + " ");

    }
 }


 // public boolean isThere (int toFind)
 // {
    
 // }


 public void deleteNode(int toRemove)
 { root = deleteNode (root, toRemove); }


 private TreeNode deleteNode(TreeNode tempRoot, int toRemove)
 {
   // Base case - tree empty
   if (tempRoot == null)
     return tempRoot;
  
   // Follow tree


   if (toRemove < tempRoot.value) 
     tempRoot.left = deleteNode(tempRoot.left, toRemove);
   else if (toRemove > tempRoot.value)
     tempRoot.right = deleteNode(tempRoot.right, toRemove);
  
   // If toRemove is the same as tempRoot.value,
   // then it must be deleted.


   else {
     // leaf or one child
     if (tempRoot.left == null)
       return tempRoot.right;
     else if (tempRoot.right == null)
       return tempRoot.left;
    
     // 2 children - find left-most node in right subtree
     tempRoot.value = minValue(tempRoot.right);


     // delete InOrder successor
     tempRoot.right = deleteNode(tempRoot.right, tempRoot.value);
   }
   return tempRoot;
 }


 private int minValue(TreeNode tempRoot)
 {
   int iMin = tempRoot.value;
   while (tempRoot.left != null)
   {
     iMin = tempRoot.left.value;
     tempRoot = tempRoot.left;
   }
   return iMin;
 }
}
