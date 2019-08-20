import javax.swing.JOptionPane;
import java.text.DecimalFormat;

/* Asks for whether you would like to find the distance between two points, 
 * find the volume and surface area of a sphere, or the area of a triangle,
 * then takes the inputs needed to be able to calculate what the user requested.
 * (Ex. X-coordinates and Y-oordinates to find the distance between the two points.)
 *   
 *  
 *  Carter Watts, Edgar Morfin
 */

public class Options{
    //asks for whether the user would like to find the distance between two points, 
    //volume and surface area of a sphere, or the area of a triangle
    
    static DecimalFormat df2 = new DecimalFormat( "#,###,###,###,##0.00" );
        
    public static void main(String[] args) throws Exception{
        
        String[] buttons = { "Distance Formula", "Volume/Surface Area", "Area of Triangle"};
    
        int rc = JOptionPane.showOptionDialog(null, "What would you like to do? Values rounded to two decimal places.", "Hello",
        JOptionPane.PLAIN_MESSAGE, JOptionPane.QUESTION_MESSAGE, null, buttons, buttons[2]);
   
        System.out.println(rc);
        if(rc == 0){
            distance();
        }else if(rc == 1){
            sphere();
        }else if(rc == 2){
            triangle();
        }
    }
    
    private static void distance(){
        
        String xOne, xTwo, yOne, yTwo;
 
        xOne= JOptionPane.showInputDialog("xOne?");
        double a = Double.parseDouble(xOne);
      
        xTwo= JOptionPane.showInputDialog("xTwo?");
        double b = Double.parseDouble(xTwo);
      
        yOne= JOptionPane.showInputDialog("yOne?");
        double c = Double.parseDouble(yOne);
      
        yTwo= JOptionPane.showInputDialog("yTwo?");
        Double d = Double.parseDouble(yTwo);
      
        double result = Math.sqrt((b-a)*(b-a) + (d-c)*(d-c)); 
        result = new Double(df2.format(result)).doubleValue(); //Format down to 2 decimal places
        
        String message = "The distance between " + xOne + ", " + yOne + " and " + xTwo + ", " + yTwo + " is " + result;
        JOptionPane.showMessageDialog(null, message, "Result", JOptionPane.INFORMATION_MESSAGE); 
    } 
    
    private static void sphere(){
               
        System.out.println("What's the radius of the sphere in meters?");  
        
        String radius = JOptionPane.showInputDialog("Radius?");
        double r = Double.parseDouble(radius); //Stores input radius
        
        double vol = (4.0/3.0)*3.1415*r*r*r; //volume of shpere with radius r
        vol = new Double(df2.format(vol)).doubleValue(); //Format to 2 decimals
        double sA = 4.0*3.1415*r*r;// surface area of ^
        sA = new Double(df2.format(sA)).doubleValue(); //Format to 2 decimals
        
        String message = "The volume is "+vol+
        " m^3 and the surface area is "+sA+" m^2"; //What is said to user
        
        JOptionPane.showMessageDialog(null, message, "Result", JOptionPane.INFORMATION_MESSAGE);
        //Tell user the values of volume and surface area
    }
    
    private static void triangle(){
        
        String sideA,sideB,sideC;
     
         //Asks for the lengths of all three sides of the triangle.
         sideA = JOptionPane.showInputDialog("SideA?");
         double a = Double.parseDouble(sideA);
         
         sideB = JOptionPane.showInputDialog("SideB?");
         double b = Double.parseDouble(sideB);
         
         sideC = JOptionPane.showInputDialog("SideC?");
         double c = Double.parseDouble(sideC);
         
         
         double s = (a+b+c)/2; //half the perimeter
         double area = Math.sqrt(s*(s-a)*(s-b)*(s-c)); //Heron's formula
         area = new Double(df2.format(area)).doubleValue();//Format to 2 decimal places
         
         String message = "The area of this triangle is: " + area;
         JOptionPane.showMessageDialog(null, message, "Result", JOptionPane.INFORMATION_MESSAGE);
         //Show to user
        
    }
}    