/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.company;

import java.util.ArrayList;
import java.util.Scanner;

class Node{

  Node prev,next;
  String cusno;
  String name;
  String pass;
  String crented; 

  public Node (String cusno,String name,String pass,String crented)
  {
    this.cusno=cusno;
    this.name=name;
    this.pass=pass;
    this.crented=crented;
    this.next = null;
    this.prev = null;
  }

  void setNext (Node n)
  {
    this.next = n;
  }

  Node getNext ()
  {
    return this.next;
  }

  void setPrev (Node n)
  {
    this.prev = n;
  }

  Node getPrev ()
  {
    return this.prev;
  }    
}



public class DoubleLL
{
   Node head;
  Node tail;
   int size;

  DoubleLL()
  {
    this.head = new Node ("0",null,null,null);
    this.tail = new Node ("0",null,null,null);
    this.size = 0;
  }
   

  
  void insertLast(String a,String b,String c,String d)
  {
    Node n = new Node (a,b,c,d);
    Node x = this.tail.getPrev ();
    if (x != null)
      {
	x.setNext (n);
	n.setPrev (x);
      }
    else
      {
	this.head.setNext(n);
      }
    this.tail.setPrev (n);
    this.size++;
  }
 
   // Split a doubly linked list (DLL) into 2 DLLs of   
    // half sizes   
    Node split(Node head) {   
        Node fast = head, slow = head;   
        while (fast.next != null && fast.next.next != null) {   
            fast = fast.next.next;   
            slow = slow.next;   
        }   
        Node temp = slow.next;   
        slow.next = null;   
        return temp;   
    }   
    
    Node mergeSort(Node node) {   
        if (node == null || node.next == null) {   
            return node;   
        }   
        Node second = split(node);   
    
        // Recur for left and right halves   
        node = mergeSort(node);   
        second = mergeSort(second);   
    
        // Merge the two sorted halves   
        return merge(node, second);   
    }   
    
    // Function to merge two linked lists   
    Node merge(Node first, Node second) {   
        // If first linked list is empty   
        if (first == null) {   
            return second;   
        }   
    
        // If second linked list is empty   
        if (second == null) {   
            return first;   
        }   
        
        int n1=Integer.parseInt(first.cusno);
        int n2=Integer.parseInt(second.cusno);
        
    
        // Pick the smaller value   
        if (n1 < n2) {   
            first.next = merge(first.next, second);   
            first.next.prev = first;   
            first.prev = null;   
            return first;   
        } else {   
            second.next = merge(first, second.next);   
            second.next.prev = second;   
            second.prev = null;   
            return second;   
        }   
    }     
  
   ArrayList<String> display ()
  {
    ArrayList<String> tempArray1 = new ArrayList<String>();  
        //System.out.println ();    
        head=mergeSort(head);
	Node x = this.head.getNext ();
        
	while (x != null)
	  {
              
	    System.out.print (x.cusno + " " + x.name + " " + x.pass + " " + x.crented + "\n");
            String s=x.cusno + "," + x.name + "," + x.pass + "," + x.crented;
            tempArray1.add(s);
	    x = x.getNext ();
	  }   

    //System.out.println ();
    
    return tempArray1;
  }          
}