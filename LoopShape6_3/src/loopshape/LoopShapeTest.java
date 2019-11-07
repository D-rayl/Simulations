/*
Daryl Crosbie
ID: P453055
*/
package loopshape;

import java.util.Scanner;

public class LoopShapeTest {
    public static void main(String[] args) {
       //Use Scanner for user input and store each of the values
       Scanner input = new Scanner(System.in);
       System.out.print("Enter the height: ");
       int height = input.nextInt();
       System.out.print("Enter the width: ");
       int width = input.nextInt();
       System.out.print("Enter the leg: ");
       int leg = input.nextInt();
       
       System.out.println();
       
       //calling the methods from the loopshape class
        LoopShape.createRectangle(width, height);
        System.out.println("");
        LoopShape.createTriangle(leg);
    }     
}
