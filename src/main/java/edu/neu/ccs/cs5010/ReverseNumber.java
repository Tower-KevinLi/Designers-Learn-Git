package edu.neu.ccs.cs5010;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * ReverseNumber returns the reversed number of the input from user.
 * @author  Zhenyan Lin
 */
public class ReverseNumber {
    /**
     * Return the reversed number of input n.
     * @param n an integer number
     * @return  the reverse of n
     */
    public int Reverse(int n){
        int num = n;
        int tailDigit = 0;
        int reverse = 0;
        int newreverse = 0;
        int newnum= Math.abs(num);
        while(newnum!=0)
        {
            tailDigit = newnum%10;
            newreverse = reverse*10 + tailDigit;
            if((newreverse-tailDigit)/10 != reverse)
                throw new IllegalArgumentException("the reverse number exceeds the int maximum");
            reverse = newreverse;
            newnum = newnum/10;
        }
        return num>0 ? reverse:-reverse;
    }

    /**
     * Uses scanner object to receive input from user and put it as the input for Reverse(int n) method.
     * Return the reversed number of the user input
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        ReverseNumber rev = new ReverseNumber();
        System.out.println(rev.Reverse(num));
    }

}
