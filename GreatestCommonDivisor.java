/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package greatestcommondivisor;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author HiAS
 */
public class GreatestCommonDivisor {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println(gcdEuclidean(24,18));
        System.out.println(gcdEuclidean(49,777));
        System.out.println(gcdEuclidean(204,456));
        
        System.out.println(gcdPrimeFactors(24,18));
        System.out.println(gcdPrimeFactors(49,777));
        System.out.println(gcdPrimeFactors(204, 456));
    }
    
    public ArrayList<Integer> list = new ArrayList<Integer>();
    
    public static int gcdEuclidean(int a, int b){
        if(b == 0){
            return a;
        }
        return gcdEuclidean(b, a % b);
    }
    
    public static int gcdPrimeFactors(int a, int b){
        int product = 1;
        ArrayList<Integer> listA = getPrimeFactors(a);
        ArrayList<Integer> listB = getPrimeFactors(b);
        for (int i = 0; i < listA.size(); i++) {
            if(listB.contains(listA.get(i))){
                product *= listA.get(i);
                listB.remove(listA.get(i));
            }
        }
        return product;
    }
    
    public static ArrayList<Integer> getPrimeFactors(int a){
        ArrayList<Integer> list = new ArrayList<Integer>();
        for (int i = 2; i <= a; i++) {
            while(i <= a && a % i == 0) {
                list.add(i);
                a /= i;
            }
        }
        return list;
    }
    
}
