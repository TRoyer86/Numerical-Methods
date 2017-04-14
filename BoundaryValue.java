/*
Tatyana Royer
CSCI 3321 Numerical Methods
November 19, 2016
Assignment 4: Two Point Boundary Value
Windows 10
Included files: BoundaryValue.java, Secant.java, RungeKutta.java

PURPOSE: The purpose of this assignment is to create a program that solves a 
given first order ordinary differential equation two point boundary value
problem.

INPUT: The data used as input consist of two functions 1) the differential equation
x' = f(t,x) = x + 0.09 x 2 + cos(10 t) and 2) the boundary condition 
x(0) + x(1) - 3.0 = 0, the step size of h = 0.025, the initial time t0 = 0.0,
the final time t1 = 1.0, and two initial guesses for x(0) that are 0.7 and 1.0.

OUTPUT: The output of the program shows the iterations of the secant method used
on the boundary condition equation, the x(0) value, the x(1) value, and the error
in satisfying the boundary condition. It also prints out the final graph as a 
table of t and x values in the range of t = 0.0 to t = 1.0 through the use of
the Runge Kutta integration.

ALGORITHM: Call the secant method and pass in the two initial guesses for x(0)
    as well as the initial time t = 0.0.
The secant method uses this information to find f(xn) and f(xn-1).
The findFofXn() and findFofXnm1() methods must call the Runge Kutta integrator to
    find the value of x(1) for the boundary condition the secant method is trying
    to solve.
The rungeKutta() method uses the given x(0) value to integrate over a step size
    of h to find and return the x(1) value to the calling method.
The secant method is repeated until its xn+1 value is within our error bounds, 
    and is returned to the main program as the best approximate x(0) value.
Once the value has been returned, the printRungeKutta() method is called with
    the final x(0) value passed in, and the t and x values of the differential
    equation are then displayed as a table.

 */

package boundaryvalue;

/**
 *
 * @author Tatyana Royer
 */
import static boundaryvalue.Secant.callSecant;

public class BoundaryValue {
   
    public static final double h = 0.025; // step size
    public static final double t0 = 0.0; // initial time
    public static final double t1 = 1.0; // final time

    
    public static void main(String[] args) {
        
        double x0guess1 = 0.7; // first guess for x(0)
        double x0guess2 = 1.0; // second guess for x(0)
        
        // x1 is derived from the secant method that have the values
        // x0guess1, x0guess2, and t0 passed into it
        double x1 = callSecant(x0guess1, x0guess2, t0);
        
        // method to print the differential equation's values as a table
        RungeKutta.printRK(h, x1, t0);
    }
   
}

