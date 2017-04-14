/*
Tatyana Royer
CSCI 3321 Numerical Methods
September 7, 2016
Assignment 2: Secant Method
Windows 10
Included files: Secant.java

PURPOSE: The purpose of this assignment is to create a program that finds the
zero of a given equation using the secant method.

INPUT: The data used as input are two initial guesses from which all subsequent 
inputs are generated.

OUTPUT: The output of the program includes the iteration number (n), 
the approximate value of x on the nth iteration (xn), and the value of f(xn).

ALGORITHM: Take two intial x values (xnm1 and xn).
Use these values to find f(xn-1) and f(xn).
Using these four values, we compute an approximation to xnp1.
If xnp1 is small enough to form a good approximation to the zero, we return the result.
Else, we increment our values and begin again.


 */
package secant;

import java.lang.Math;

public class Secant {

    public static void main(String[] args) {
        // declare the variables used in the functions, in this case
        // double is used for 64-bit precision
        double fOfXn = 1.0;
        double fOfXnm1; // f(xm+1)
        double fOfXnp1;
        // two initial guesses
        double xn = -1;
        double xnm1 = 2; // xn+1
        double xnp1;

        /* testing to make sure the function calculates correctly;
         f(x)  =  tanh(x) -  0.5   =  0
        for (xn = 0; xn < 20; xn++) {
            fOfX = ((Math.tanh(xn)) - 0.5);
            System.out.printf("f(x) = %f\n", fOfX);
        }
         */
        System.out.println("This program uses the secant method to find the zero "
                + "of the function f(x) = tanh(x) - 0.5\n");
        
        System.out.printf("Iteration\t\tX\t\t\tF(X)\n");
        System.out.printf("----------------\t--------------------\t"
                + "--------------------\n");

        int i = 0;
        while (i < 30 && fOfXn > 1.0e-16) {
            xnp1 = xn - (((findfOfXn(xn)) * (xn - xnm1)) / ((findfOfXn(xn) - findfOfXnm1(xnm1))));
            fOfXnp1 = ((Math.tanh(xnp1)) - 0.5);
            // breaks if xnp1 and fOfXp1 are Not a Number
            if (Double.isNaN(xnp1) && Double.isNaN(fOfXnp1)) {
                break;
            }
            System.out.printf("%d\t\t\t%20.15f\t%20.15f\n", i, xnp1, fOfXnp1);
            xnm1 = xn;
            xn = xnp1;
            i++;
        }

    }
    // method for finding f(xn)
    public static double findfOfXn(double xn) {
        double fOfXn = ((Math.tanh(xn)) - 0.5);
        return fOfXn;
    }

    // method for finding f(xn-1)
    public static double findfOfXnm1(double xnm1) {
        double fOfXnm1 = ((Math.tanh(xnm1)) - 0.5);
        return fOfXnm1;
    }

}
