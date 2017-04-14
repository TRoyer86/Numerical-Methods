/*
Tatyana Royer
CSCI 3321 Numerical Methods
August 28, 2016
Assignment 1: Rounding
Windows 10
Included files: Rounding.java

PURPOSE: The purpose of this assignment is to demonstrate the effects of rounding
and truncation errors on accuracy.

INPUT: The data used as input to demonstrate error is an h value (see code) that
starts at a value of 1 and ends once it becomes less than 2.0e-12.

OUTPUT: The output of the program includes the present value of h, the
approximation of the derivative, and the amount of error between the true 
value of the derivative and the approximation.

ALGORITHM: To find the approximate derivative, begin with an initial value of h.
Plug that value of h into the difference equation.
The output of that difference equation is the approximation of the derivative
    for that particular value of h.
Find the error by subtracting the approximation from the real value of the 
    derivative.
Divide h in half.
Repeat until h is sufficiently small.
 */
package rounding;

import java.lang.Math;
public class Rounding {

    
    public static void main(String[] args) {
        
        // declare the variables used in the functions, in this case
        // double is used for 64-bit precision
        double x = 2;
        double h = 1;
        double fOfX;
        double fOfXPlusH;
        double derOfX;
        double realVal = 2.2539995942966376896;
        double error;
        /*
        // this was test code to make sure the original function computed 
        // correctly
        for (x = 0; x < 10; x++) {
            // f(x) = sin(x^3) + x^2;
            fOfX = ((Math.sin(Math.pow(x, 3))) + Math.pow(x, 2));
            System.out.printf("f(x) = %f\n", fOfX);
        }
        */
        
        System.out.println("This program is designed to show the effects of"
                + " rounding and truncation errors on accuracy.");
        System.out.println("We are given the function f(x) = sin(x^3) + x^2.");
        System.out.println("We wish to determine an approximation to its"
                + " derivative at the point x=2.");
        System.out.println("We approximate the value using the following formula:"
                + " f'(x) ≃ (f(x+h) - f(x)) / h.");
        System.out.println("The first column represents the variable h, which"
                + " is getting closer and closer to 0.");
        System.out.println("The second column is our approximation using the"
                + " chosen approximation formula. It has been rounded to "
                + "16 decimal places.");
        System.out.println("The final column is the absolute error of our "
                + "approximation to the actual value at the point x=2.\n");
        System.out.println("The larger errors in the first iterations are due"
                + "to rounding, while the errors in the latter iterations are"
                + "due to truncation.");
        
        
        // f(x) = sin(x^3) + x^2;
        fOfX = ((Math.sin(Math.pow(x, 3))) + Math.pow(x, 2));
        //fOfXPlusH = ((Math.sin(Math.pow(x+h, 3))) + Math.pow(x+h, 2));
        
        
        System.out.printf("H\t\t\tApproximation\t\tError\n");
        System.out.printf("---------------------\t--------------------\t"
                + "--------------------\n");
        // loop to find the approximated derivative
        for (h = 1; h > 2.0e-12; h/= 2) {
            derOfX = ((((Math.sin(Math.pow(x+h, 3))) + Math.pow(x+h, 2)) - fOfX) / h);
            error = realVal - derOfX;
            System.out.printf("%20.15f\t%20.15f\t%20.15f\n", h, derOfX, error);
        }
        
        
    }
    
}
