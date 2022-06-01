/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package aau_freeflow;
import java.util.*;

/**
 *
 * @author home
 */
public class BSTobject<E extends Comparable<E>> implements BSTinterface<E> {
    
    private TreeNode<E> root;
    private int size;
    //private TreeNode<E> deleted = new TreeNode<E>(null);
    
    public BSTobject() {
        root = null;
        size = 0;
    }
    
    public E add(E element) {
        if (contains(element)) return element;
        root = add(root, null, element);
        return element;
    }
    
    private TreeNode<E> add(TreeNode<E> t, TreeNode<E> p, E element) {
        if (t == null) {
            size+=1; 
            if (size!= 1) System.out.println("height = " + root.height);
            TreeNode<E> temp = new TreeNode<E>(element, null, null, p);
            temp.height = 0;
            return temp;
        }
        //t.height = 1 + Math.max(height(t.left), height(t.right));
        if (element.compareTo(t.value) < 0) 
        {
            //System.out.println("Less than");
            t.left = add(t.left, t, element);
        }
        else if (element.compareTo(t.value) > 0){
            //System.out.println("More than");
            t.right = add(t.right, t, element);
        }
       
        else return t;
        
        t.height = 1 + Math.max(height(t.left), height(t.right));
        
        return t;
       
    }
    
    public E addBalanced(E item) {
	this.root = addBalanced(this.root, item);
        return item;
    }

    private TreeNode<E> addBalanced(TreeNode<E> node, E item) {

        if (node == null) {
            TreeNode<E> nn = new TreeNode<E>(item);
            //System.out.println("node added");
            size += 1;
            return nn;
        }
        
        if (item.compareTo( node.value)>0) {
            node.right = addBalanced(node.right, item);
	} else if (item.compareTo(node.value)<0) {
            node.left = addBalanced(node.left, item);
	}

	node.height = Math.max(height(node.left), height(node.right)) + 1;

	int bf = getBalance(node);

	// LL Case
	if (bf > 1 && item.compareTo(node.getLeft().value)<0) {
            return rightRotate(node);
	}

        // RR Case
	if (bf < -1 && item.compareTo(node.getRight().value)>0) {
            return leftRotate(node);
	}

	// LR Case
        if (bf > 1 && item.compareTo(node.getLeft().value)>0) {
            node.left = leftRotate(node.left);
            return rightRotate(node);
	}

		// RL Case
	if (bf < -1 && item.compareTo(node.getRight().value)<0) {
            node.right = rightRotate(node.right);
            return leftRotate(node);
	}
	return node;

	}
    
    
    
    private int height(TreeNode<E> w) {
        if (w == null)
            return 0;
 
        return w.height;
    }
    
    private int getBalance(TreeNode<E> w) {
        if (w == null)
            return 0;
        
        /*System.out.println(w);
        System.out.println("left = " + height( w.left));
        System.out.println("right = " + height(w.right));*/
 
        return height(w.left) - height(w.right);
    }
    
    private TreeNode<E> leftRotate(TreeNode<E> root) {
        TreeNode<E> y = root.right;
        TreeNode<E> T2 = y.left;
 
        // Perform rotation
        y.left = root;
        root.right = T2;
 
        //  Update heights
        root.height = Math.max(height(root.left), height(root.right)) + 1;
        y.height = Math.max(height(y.left), height(y.right)) + 1;
 
        // Return new root
        return y;
    }
    
    private TreeNode<E> rightRotate(TreeNode<E> root) {
        TreeNode<E> x = root.left;
        //System.out.println(x);
        TreeNode<E> T2 = x.right;
        //System.out.println(T2);
 
        // Perform rotation
        x.right = root;
        root.left = T2;
        //System.out.println("root: " + x);
        //System.out.println(x.left + " " + x.right);
 
        // Update heights
        root.height = Math.max(height(root.left), height(root.right)) + 1;
        x.height = Math.max(height(x.left), height(x.right)) + 1;
 
        // Return new root
        return x;
    }
    
    public boolean contains(E element) {
        //System.out.println("got here");
        return contains(root, element);
    }
    
    private boolean contains(TreeNode<E> t, E element) {
        //System.out.println("got here 2");
        if (t == null) return false;
        //System.out.println(t.value.getClass());
        //System.out.println(element.getClass());
        if (t.value.equals(element)) {
            //System.out.println("got here 3");
            return true;
        } else return (contains(t.left, element) || contains(t.right, element));
    }
    
    public boolean isEmpty() {
        return size == 0;
    }
    
    @Override
    public E delete (E element) {
        root = delete(root, element);
        return element;
    }
    
    private TreeNode<E> delete(TreeNode<E> root, E element) {
        if (root == null) return null;
       if (element.compareTo(root.value) > 0) {
           root.right = delete(root.right, element);    
       }
       else if (element.compareTo(root.value) < 0) {
           root.left = delete(root.left, element);
           
       } else {
           System.out.println(root);
           if (root.value.equals(element)){
                //deleted = new TreeNode(root.value);
                if (root.left == null && root.right == null) {
                    root = null;
                }
                else if (root.right != null) {
                    TreeNode<E> pred = root.right;
                    while (pred.left != null) {
                        pred = pred.left;
                    }
                    root.value = pred.value;
                    root.right = delete(root.right, pred.value);
                } else {
                     TreeNode<E> pred = root.left;
                     while (pred.right != null) {
                         pred = pred.right;
                     }
                     root.value = pred.value;
                     root.left = delete(root.left, pred.value);
                } 
            }    
       }
       return root;
    }
    
    public int size() {return size;}
    
    public E max() {
        return max(root);
    }
    
    private E max(TreeNode<E> t) {
        if (t == null) return null;
        if (t.right == null) return t.value;
        return max(t.getRight());
    }
    
    public E min() {
        return min(root);
    }
    
    private E min(TreeNode<E> t) {
        if (t == null) return null;
        if (t.left == null) return t.value;
        return min(t.getLeft());
    }
    
    public String display() {
        return display(root, 0);
    }
        
    private String display(TreeNode<E> t, int level) //recursive helper method
   {
       // turn your head towards left shoulder visualize tree
      String toRet = "";
      if(t == null)
         return "";
      toRet += display(t.right, level + 1); //recurse right
      for(int k = 0; k < level; k++)
         toRet += "\t";
      toRet += t.value + "\n";
      toRet += display(t.left, level + 1); //recurse left
      return toRet;
   }
    
    public String toString() {
        return toStringHelper(root);
    }
    
    public String toStringHelper(TreeNode<E> t) {
        if (t == null) return "";
        String returnS = "";
        returnS += toStringHelper(t.left) + " ";
        returnS += t.value;
        returnS += toStringHelper(t.right) + " ";
        return returnS;
    }
    
    public boolean edit(E oldElement, E newElement) {
        if (contains(oldElement)) {
            delete(oldElement);
            addBalanced(newElement);
            return true;
        }
        return false;
    }
    
    public List<E> toList() { // modified to be right to left for a ranking situation
        List<E> returnL = new ArrayList<E>();
        return toList(root, returnL);
    }
    
    public List<E> toList(TreeNode<E> t, List<E> list) {
        if (t != null) {
            toList(t.right, list);
            list.add(t.value);
            toList(t.left, list);
        }
        return list;
    }
    
    public boolean isBalanced() {
        int balance = getBalance(root);
        return (Math.abs(balance) < 2);
    }
    
    public List<E> limited_maxorder(int max) {
        List<E> returnL = new ArrayList<E>();
        return limited_maxorder(root, returnL, max);
    }
    
    private List<E> limited_maxorder(TreeNode<E> t, List<E> list, int max) {
        if (t != null) {
            list = limited_maxorder(t.right, list, max);
            if (list.size() < max) list.add(t.value);
            list = limited_maxorder(t.left, list, max);
        }
        return list;
    }
    
    public List<E> limited_minorder(int max) {
        List<E> returnL = new ArrayList<E>();
        return limited_minorder(root, returnL, max);
    }
    
    private List<E> limited_minorder(TreeNode<E> t, List<E> list, int max) {
        if (t != null) {
            list = limited_minorder(t.left, list, max);
            if (list.size() < max) list.add(t.value);
            list = limited_minorder(t.right, list, max);
        }
        return list;
    }
}
