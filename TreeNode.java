/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package aau_freeflow;

/**
 *
 * @author home
 */
public class TreeNode<E extends Comparable<E>>
   {
      public E value; 
      public int height;
      public TreeNode parent;
      public TreeNode left, right;
   
       public TreeNode(E initValue)
      { 
         value = initValue; 
         left = null; 
         right = null; 
         parent = null;
      }
   
       public TreeNode(E initValue, TreeNode<E> initLeft, TreeNode<E> initRight, TreeNode<E> parent)
      { 
         value = initValue; 
         left = initLeft; 
         right = initRight; 
      }
   
       public E getValue()
      { 
         return value; 
      }
   
       public TreeNode<E> getLeft() 
      { 
         return left; 
      }
   
       public TreeNode<E> getRight() 
      { 
         return right; 
      }
   
       public void setValue(E theNewValue) 
      { 
         value = theNewValue; 
      }
   
       public void setLeft(TreeNode<E> theNewLeft) 
      { 
         left = theNewLeft;
      }
   
       public void setRight(TreeNode<E> theNewRight)
      { 
         right = theNewRight;
      }

    public TreeNode<E> getParent() {
        return parent;
    }

    public void setParent(TreeNode<E> parent) {
        this.parent = parent;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }       
       
    public String toString() {
        return value.toString();
    }
   }
