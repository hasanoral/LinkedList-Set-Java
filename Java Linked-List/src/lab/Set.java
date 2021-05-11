/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab;

/**
 *
 * @author Dell
 */
public class Set<T> {

    private LinkedList[] hashArray;
    private int size = 10;		

    public Set() {
        hashArray = new LinkedList[size];
        for (int i = 0; i < size; i++) {
            hashArray[i] = new LinkedList<T>();
        }
    }

    public Set(int initialSize) {
        size = initialSize;
        hashArray = new LinkedList[size];
        for (int i = 0; i < size; i++) {
            hashArray[i] = new LinkedList<T>();
        }
    }
    public boolean add(T newItem) {
        int hash = computeHash(newItem.toString());	
        LinkedList list = hashArray[hash];
        if (!list.contains(newItem)) {
            hashArray[hash].addToStart(newItem);
            return true;
        }
        return false;
    }
    public boolean contains(T item) {
        int hash = computeHash(item.toString());
        LinkedList list = hashArray[hash];
        if (list.findData(item) == null) {
            return false;
        }
        return true;
    }
    public void output() {
        for (int i = 0; i < size; i++) {
            LinkedList list = hashArray[i];
            if (list != null) {
                list.outputList();
            }
        }
    }
    public Set<T> union(Set<T> otherSet) {
        Set<T> unionSet = new Set<T>();
        for (int i = 0; i < size; i++) {
            LinkedList list = hashArray[i];
            LinkedList<T>.Node<T> iter = list.getHead();
            while (iter != null) {
                unionSet.add(iter.getData());
                iter = iter.getLink();
            }
        }
        for (int i = 0; i < size; i++) {
            LinkedList list = otherSet.hashArray[i];
            LinkedList<T>.Node<T> iter = list.getHead();
            while (iter != null) {
                unionSet.add(iter.getData());
                iter = iter.getLink();
            }
        }
        return unionSet;
    }
    public Set<T> fark(Set<T> otherSet) {
        Set<T> interSet = new Set<T>();
        for (int i = 0; i < size; i++) {
            LinkedList list = hashArray[i];
            LinkedList<T>.Node<T> iter = list.getHead();
            while (iter != null) {
                if (!otherSet.contains(iter.getData())) {
                    interSet.add(iter.getData());
                }
                iter = iter.getLink();
            }
        }
        return interSet;
    }
    private int computeHash(String s) {
        int hash = 0;
        for (int i = 0; i < s.length(); i++) {
            hash += s.charAt(i);
        }
        return hash % size;
    }
} 