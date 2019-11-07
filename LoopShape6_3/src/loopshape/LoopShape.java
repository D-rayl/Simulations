/*
Daryl Crosbie
ID: P453055
*/
package loopshape;

public class LoopShape {

    static void createRectangle(int width, int height) {
        //Check input is greater than 1, if so, run the code inside the block
        if ((width > 2) && (height > 2)) {
            //Use a for loop, for the height, start from zero and stop
            //one less than height
            for (int h = 0; h < height; h++) {
                //print one hash for the left vertical side of the rectangle on
                //every iteration of the for loop
                System.out.print("#");
                //Use another for loop for the hoizontal lines making up the
                //rest of the loop, but not the right vertical wall
                //Set the loop to start at 1, allowing for the first hash 
                //already printed
                //stop the loop 2 less than width, allow for 1 hash to be added
                for (int w = 1; w <= width-2; w++) {
                    //If h in the height loop is equal to zero or height-1,
                    //then it must be the roof or the floor of the rectangle,
                    //so print as hash
                    if ((h == 0) || (h == height - 1)) {
                        System.out.print("#");
                    } //If false then it must be the inner part of the rectangle
                    //so print spaces
                    else {
                        System.out.print(" ");
                    }
                }
                //And print one more hash for the right side wall
                //with a next line, to move down 
                System.out.println("#");
            }
        } //If user provides a 1 or less, print this message
        else {
            System.out.print("Width and hieght must be greater than 1.");
        }
    }
    static void createTriangle(int leg){
        //Leg is greater than 1, run the code inside the block
        if(leg>1){
            //Print a hash for the top of the triangle
            System.out.println("#");
            //Use a for loop, starting from zero, up to leg-3,
            //to allow for the bottom line to be printed at the end
            for(int h = 0; h <= leg-3; h++){
               System.out.print("#");
                //Use another for loop, starting from zero, up to h
                //for the inside of the triangle
                  for(int w = 0; w < h; w++){ 
                    System.out.print(" ");
                }
                //Print 1 hash for the right side of the triangle
                //and move on to the next line
                System.out.println("#");
            }
            //One more loop for the bottom of the triangle
            //start at zero, going up to leg-1, for 5 iterations
            /*for(int a = 0; a <= leg-1; a++){
                //print the hashes
                System.out.print("#");
            }*/
            System.out.println("");
        }
        //If user input is less than 1, print this message
        else{
            System.out.print("The leg must be greater than 1");
        }
    }
}
