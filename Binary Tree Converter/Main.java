class Main 
{
  public static void main(String[] args) 
  {
    BinTree TreeOfInt = new BinTree();
    int iNumbers[] = {47, 23, 31, 72, 38, 78, 81, 50, 42, 12};
  
  
    for (int i = 0; i < 10; i++)
    {
      TreeOfInt.InsertItem(iNumbers[i]);
    }
    
    System.out.println("InOrder");
    TreeOfInt.InOrder();
  
  
    System.out.println("\nPreOrder");
    TreeOfInt.PreOrder();
  
  
    System.out.println("\nPostOrder");
    TreeOfInt.PostOrder();
  }
}