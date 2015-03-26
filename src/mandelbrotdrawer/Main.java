/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mandelbrotdrawer;

/**
 *
 * @author Christopher
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        

        GUI.getGUI().redraw();

        while(true){
            //GUI.getGUI().redraw();
        }
    }
    
    public static ComplexNumber MandelbrotResult(ComplexNumber in, ComplexNumber c){
        ComplexNumber result = ComplexNumber.squareOf(in);
        result.add(c);
        return result;
    }
    
    public static ComplexNumber MultibrotResult(ComplexNumber in, ComplexNumber c, int power){
        ComplexNumber result = new ComplexNumber(1,0);
        for(int p = 0; p < power; p++){
            result.multiply(in);
        }
        result.add(c);
        return result;
    }

    public static double vergenceOfMandelbrot(ComplexNumber complexNumber) {
        return vergenceOfMultibrot(complexNumber, 2);
    }
    
    public static double vergenceOfMultibrot(ComplexNumber complexNumber, int power) {
        ComplexNumber c = MultibrotResult(new ComplexNumber(0,0),complexNumber, power);
        for(int i = 1; i < 200; i++){
            c = MandelbrotResult(c,complexNumber);
            if(c.toString().contains("Infinity"))
                return 100-i/40.0;
            else if(c.toString().contains("NaN"))
                return 100-i/40.0;
            else if(c.A() == 0 && c.B() == 0)
                return 0;
        }
        return 0;
    }
    
}
