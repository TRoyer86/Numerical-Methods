/*
Tatyana Royer
CSCI 3321 Numerical Methods
October 29, 2016
Assignment 3: Runge Kutta
Windows 10
Included files: RungeKutta.java

PURPOSE: The purpose of this assignment is to create a program that uses the
Runge-Kutta Method to find the solution to a third order ordinary differential
equation at a given point.

INPUT: The data used as input are two initial values of t and x, as well as 
seven different values of h, the step size for the method.

OUTPUT: The output of the program shows the method run for seven different
step sizes and the values of x and t at each step along the way.

ALGORITHM: Take two intial x values (xn and tn) and an h value.
From the value t = 0.0 until t = 2.0 {
Find the value of k1 using the appropriate equation and the inputs xn and tn.
Update the x and t values in order to find k2.
Find the value of k2 using the appropriate equation and the updated x and t inputs.
Update the x and t values in order to find k3.
Find the value of k3 using the appropriate equation and the updated x and t input.
Find the value of phi using k1, k2, and k3.
Find the value of xn+1 using phi, xn, and h.
Set the value of xn as xnp1.
Increment tn by the given step size, h. }

This process is repeated for seven different values of h and prints the
results in a table.



 */
package rungekutta;

import java.lang.Math;

public class RungeKutta {

    public static void main(String[] args) {
        // declare the variables used in the functions, in this case
        // double is used for 64-bit precision
        double h = 0.1;         // set h initially to the largest step size
        double xn = 1.0;        // initial x value
        double tn = 0.0;        // initial t value
        
        // performs the Runge-Kutta evaluation for each required step size
        while (h >= 0.0015625) {
            rungeKutta(h, xn, tn);
            h = h/2;
        }
    }
    
    // METHODS USED FOR THE PROGRAM
    //
    // method for starting the Runge-Kutta evaluation
    public static void rungeKutta(double h, double xn, double tn) {
        
        System.out.printf("Using a stepsize of h = %9.7f", h);
        System.out.println();
        System.out.println();
        System.out.printf("T\t\t\tX\n");
            System.out.printf("--------------------\t"
                + "--------------------\n");
            
        double i = 0.0;
        
        while (i <= 1.0){
            // establish the k variables for the first pass
            // use the initial values of xn and tn to find k1
            double k1 = dxofDt(tn, xn); 
            double x = (xn + (.5*h*k1));   // update x for the next call
            double t = (tn + (.5*h));      // update t for the next call
            double k2 = dxofDt(t, x);   
            t = (tn + h);               // update t for the next call
            x = (xn - (k1*h) + (2*k2*h)); // update x for the next call
            double k3 = dxofDt(t, x);
            
            // use the found k values in our phi equation
            double phi = findPhi(k1, k2, k3); 
            
            // use the values of phi, xn, and h to determine xn+1
            double xnp1 = findXnp1(xn, phi, h);
            xn = xnp1;
            tn = tn + h;
            i = i + h;
            
            System.out.printf("%20.15f\t%20.15f\n", tn, xnp1); 
        }
        System.out.println();
    }
    
    // method for finding dx/dt
    public static double dxofDt(double t, double x) {
        return (x + (0.09 * (Math.pow(x, 2))) + Math.cos((10*t)));
    }

    // method for finding phi
    public static double findPhi(double k1, double k2, double k3) {
        return ((k1 + (4*k2) + k3)/6); 
    }
    
    // method for finding Xn+1
    public static double findXnp1(double x, double phi, double h) {
        return (x+(phi*h));
    }
    
}
