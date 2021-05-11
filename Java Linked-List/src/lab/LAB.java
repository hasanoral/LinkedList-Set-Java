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
public class LAB {
    public static void main(String[] args) {
        Set A=new Set<Integer>();
        
        Set B=new Set<Integer>();
        
        A.add(5);
        A.add(8);
        A.add(9);
        A.add(13);
        
        B.add(8);
        B.add(4);
        B.add(5);
        
        A.fark(B).output();
        
        
        
        
        
    }
    
}

