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
interface BSTinterface<E>
{
   public E add( E element );     //returns the object
   public E addBalanced(E element);
   public boolean contains( E element ); // breadth first or depth first search
   public boolean isEmpty();
   public E delete( E element );  //returns the object, not a Node<E>.  
   public int size();
   public E min();
   public E max();
   public String display();
   public String toString();
   public boolean edit(E oldElement, E newElement);
   public List<E> toList();//returns an in-order list of E
   public boolean isBalanced();
}

