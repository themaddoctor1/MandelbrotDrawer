/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mandelbrotdrawer;

import java.applet.Applet;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

/**
 *
 * @author WHS-D4B1W8
 */
public class GUI extends Applet implements KeyListener, MouseListener, MouseMotionListener{
    //////////////////////////
    
    
    private static GUI gui = new GUI(1920,1080);
    
    
    //Pixels per radian
    private double PPR;
    
    //Applet stuff
    private Graphics graphics;
    private JFrame frame;
    
    ////////////////////////////////////////////////////
    
    private int x = 0, y = 0;
    private double zoomFactor = 0.5;
    
    private GUI(){
        this(800,600);
    }
    
    private GUI(int width, int height){
        addKeyListener(this);
        addMouseListener(this);
        addMouseMotionListener(this);
        
        
        
        /*
        
        Key/Mouse Combinations
        ======================
        Ctrl+A ..... Select all friendly units
        Left Click ..... Select a unit
        Right Click ..... Move selected units to selected position or unit
        Right Click+A ..... Attack selected position or unit
        Shift+Ctrl+A ..... Select all units
        Shift+Left Click ..... Select units without deselecting units
        
        */
        
        //Creates a JFrame with a title
        frame = new JFrame("Mandelbrot Drawer");
        //Puts the Tester object into thhe JFrame
	frame.add(this);
        //Sets the size of the applet to be 800 pixels wide  by 600 pixels high
	frame.setSize(width, height);
        //Makes the applet visible
	frame.setVisible(true);
        //Sets the applet so that it can't be resized
        frame.setResizable(false);
        //This will make the program close when the red X in the top right is
        //clicked on
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        
        
        /////////////////////////
        /////////////////////////
        
    }
    
    public void redraw(){
        repaint();
    }

    public void update(Graphics g){
        Image image = null;
        if (image == null) {
            image = createImage(this.getWidth(), this.getHeight());
            graphics = image.getGraphics();
        }
        graphics.setColor(Color.WHITE);
        graphics.fillRect(0,  0,  this.getWidth(),  this.getHeight());
        graphics.setColor(getForeground());
        paint(graphics);
        g.drawImage(image, 0, 0, this);
        
        
    }
    
    public void paint(Graphics g){
        Graphics2D g2 = (Graphics2D) g;
        g2.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        
        double mult = 1;
        
        double pixelSize = mult * (2.0/zoomFactor)/Math.max(getWidth(), getHeight());
        
        for(int i = 0; i < getWidth(); i+= mult) for(int j = 0; j < getWidth(); j+= mult){
            double X = x - (getCenterX() - i)*pixelSize/mult;
            double Y = y + (getCenterY() - j)*pixelSize/mult;
            
            double convergencyValue = Main.vergenceOfMultibrot(new ComplexNumber(X,Y), 2);
            
            //System.out.println(X + "," + Y + ": " + convergencyValue);
            if(convergencyValue > 0)
                g2.setColor(new Color(
                (int)(255 / Math.pow(100, 30) * Math.pow(convergencyValue,30))
                , (int)(255 - 255 / Math.pow(100, 30) * Math.pow(convergencyValue,30))
                , 0
                ));
            else g2.setColor(Color.BLACK);
            
            g2.fillRect(i, j, (int) mult, (int) mult);
        }
        
        
        
        
    }
    
    public void setPixelsPerRadian(double ppr){ PPR = ppr; }
    
    public void setDegreesPerRadian(double dpr){
        setPixelsPerRadian(dpr*180.0/Math.PI);
    }
    
    public double getPixelsPerDegree(){
        return PPR * Math.PI/180.0;
    }
    
    public double getPixelsPerRadian() { return PPR; }
    public static GUI getGUI(){ return gui; }
    
    public static void initialize(){
        gui = new GUI(800,600);
    }
    
    public static void initialize(int width, int height){
        gui = new GUI(width, height);
    }
    
    
    //-----------------------
    //Keyboard and Mouse
    //-----------------------
    
    

    public int getCenterX() {
        return frame.getWidth()/2;
    }

    public int getCenterY() {
        return frame.getHeight()/2;
    }

    @Override
    public void keyTyped(KeyEvent ke) {
        
    }

    @Override
    public void keyPressed(KeyEvent ke) {
        
    }

    @Override
    public void keyReleased(KeyEvent ke) {
        
    }

    @Override
    public void mouseClicked(MouseEvent me) {
        
    }

    @Override
    public void mousePressed(MouseEvent me) {
        
    }

    @Override
    public void mouseReleased(MouseEvent me) {
        
    }

    @Override
    public void mouseEntered(MouseEvent me) {
        
    }

    @Override
    public void mouseExited(MouseEvent me) {
        
    }

    @Override
    public void mouseDragged(MouseEvent me) {
        
    }

    @Override
    public void mouseMoved(MouseEvent me) {
        
    }

    
    
}
