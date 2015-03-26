package mandelbrotdrawer;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Christopher
 */
public class ComplexNumber {
    
    private double A, B;
    
    public ComplexNumber(double a, double b){
        A = a;
        B = b;
    }
    
    public void add(double a, double b){
        A += a;
        B += b;
    }
    
    public void add(ComplexNumber c){
        add(c.A, c.B);
    }
    
    public void multiply(double a, double b){
        A = A*a - B*b;
        B = A*b + B*a;
    }
    
    public void multiply(ComplexNumber c){
        multiply(c.A, c.B);
    }
    
    public void square(){
        A = A*A - B*B;
        B = 2*A*B;
    }
    
    public static ComplexNumber squareOf(ComplexNumber c){
        return new ComplexNumber(c.A*c.A-c.B*c.B, 2*c.A*c.B);
    }
    
    public double A(){return A;}
    public double B(){return B;}
    
    public String toString(){
        return A + " + " + B + "i";
    }
    
}
