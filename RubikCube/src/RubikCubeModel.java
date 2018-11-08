import java.awt.Color;
import java.util.ArrayList;

/* RubikCubeModel:
 * 	Central component of the MVC pattern; is the application's dynamic data structure, independent of
 *  the UI. Directly manages the data, logic and rules of the application. Receives user input from the
 *  controller.
 */


public class RubikCubeModel {
	
	//constants for each cube of each face (THE CENTER PIECE IS NOT MOVED IN ANY EVENT SO THIS CONSTANT IS OMITTED)
	private int CUBE1 = 0, CUBE2 = 1, CUBE3 = 2, CUBE4 = 3, CUBE6 = 5, CUBE7 = 6, CUBE8 = 7, CUBE9 = 8,
				FRONT = 0, TOP = 1, BOTTOM = 2, LEFT = 3, RIGHT = 4, BACK = 5,
				SHIFT_ROW = 3;
    
	/*Event for handling a 90 degree, clockwise front face turn. This event involves the following movements:
	 * The bottom row of the top face becomes the left column of the right face
	 * The left column of the right face becomes the top row of the bottom face
	 * The top row of the bottom face becomes the right column of the left face
	 * The right column of the left face becomes the bottom row of the top face
	 * 
	 * On the front face, the following positions are shifted:
	 * 		CUBE1 -> CUBE3
	 * 		CUBE2 -> CUBE6
	 * 		CUBE3 -> CUBE9
	 * 		CUBE4 -> CUBE2
	 * 		CUBE6 -> CUBE8
	 * 		CUBE7 -> CUBE1
	 * 		CUBE8 -> CUBE4
	 * 		CUBE9 -> CUBE7
	 */
    public void FEvent(ArrayList<ArrayList<Shape>> faces) {
    	int u1 = CUBE7, l1 = CUBE9, r1 = CUBE1, b1 = CUBE3;
    	for(int i = 0; i < 3; i++) {
    		Color color = faces.get(TOP).get(u1).getColor();
        	faces.get(TOP).get(u1).changeColor(faces.get(LEFT).get(l1).getColor());
        	faces.get(LEFT).get(l1).changeColor(faces.get(BOTTOM).get(b1).getColor());
        	faces.get(BOTTOM).get(b1).changeColor(faces.get(RIGHT).get(r1).getColor());
        	faces.get(RIGHT).get(r1).changeColor(color);
        	u1++;
        	l1 -= SHIFT_ROW;
        	b1--;
        	r1 += SHIFT_ROW;
    	} 
    
    	Color color = faces.get(FRONT).get(CUBE1).getColor();
    	faces.get(FRONT).get(CUBE1).changeColor(faces.get(FRONT).get(CUBE7).getColor());
    	faces.get(FRONT).get(CUBE7).changeColor(faces.get(FRONT).get(CUBE9).getColor());
    	faces.get(FRONT).get(CUBE9).changeColor(faces.get(FRONT).get(CUBE3).getColor());
    	faces.get(FRONT).get(CUBE3).changeColor(color);
    	color = faces.get(FRONT).get(CUBE2).getColor();
    	faces.get(FRONT).get(CUBE2).changeColor(faces.get(FRONT).get(CUBE4).getColor());
    	faces.get(FRONT).get(CUBE4).changeColor(faces.get(FRONT).get(CUBE8).getColor());
    	faces.get(FRONT).get(CUBE8).changeColor(faces.get(FRONT).get(CUBE6).getColor());
    	faces.get(FRONT).get(CUBE6).changeColor(color);
    }
    
    
    /*Event for handling a 90 degree, counterclockwise front face turn. This event involves the following movements:
	 * The bottom row of the top face becomes the right column of the left face
	 * The right column of the left face becomes the top row of the bottom face
	 * The top row of the bottom face becomes the left column of the right face
	 * The left column of the right face becomes the bottom row of the top face
	 * 
	 * On the front face, the following positions are shifted:
	 * 		CUBE1 -> CUBE7
	 * 		CUBE2 -> CUBE4
	 * 		CUBE3 -> CUBE1
	 * 		CUBE4 -> CUBE8
	 * 		CUBE6 -> CUBE2
	 * 		CUBE7 -> CUBE9
	 * 		CUBE8 -> CUBE6
	 * 		CUBE9 -> CUBE3
	 */
    public void FPrimeEvent(ArrayList<ArrayList<Shape>> faces) {
    	int u1 = CUBE7, l1 = CUBE9, r1 = CUBE1, b1 = CUBE3;
    	for(int i = 0; i < 3; i++) {
    		Color color = faces.get(TOP).get(u1).getColor();
        	faces.get(TOP).get(u1).changeColor(faces.get(RIGHT).get(r1).getColor());
        	faces.get(RIGHT).get(r1).changeColor(faces.get(BOTTOM).get(b1).getColor());
        	faces.get(BOTTOM).get(b1).changeColor(faces.get(LEFT).get(l1).getColor());
        	faces.get(LEFT).get(l1).changeColor(color);
        	u1++;
        	l1 -= SHIFT_ROW;
        	b1--;
        	r1 += SHIFT_ROW;
    	} 
    
    	Color color = faces.get(FRONT).get(CUBE1).getColor();
    	faces.get(FRONT).get(CUBE1).changeColor(faces.get(FRONT).get(CUBE3).getColor());
    	faces.get(FRONT).get(CUBE3).changeColor(faces.get(FRONT).get(CUBE9).getColor());
    	faces.get(FRONT).get(CUBE9).changeColor(faces.get(FRONT).get(CUBE7).getColor());
    	faces.get(FRONT).get(CUBE7).changeColor(color);
    	color = faces.get(FRONT).get(CUBE2).getColor();
    	faces.get(FRONT).get(CUBE2).changeColor(faces.get(FRONT).get(CUBE6).getColor());
    	faces.get(FRONT).get(CUBE6).changeColor(faces.get(FRONT).get(CUBE8).getColor());
    	faces.get(FRONT).get(CUBE8).changeColor(faces.get(FRONT).get(CUBE4).getColor());
    	faces.get(FRONT).get(CUBE4).changeColor(color);
    }
    
    
    /*Event for handling a 90 degree, clockwise right face turn. This event involves the following movements:
	 * The right column of the front face becomes the right column of the top face
	 * The right column of the top face becomes the left column of the back face
	 * The left column of the back face becomes the right column of the bottom face
	 * The right column of the bottom face becomes the right column of the front face
	 * 
	 * On the right face, the following positions are shifted:
	 * 		CUBE1 -> CUBE3
	 * 		CUBE2 -> CUBE6
	 * 		CUBE3 -> CUBE9
	 * 		CUBE4 -> CUBE2
	 * 		CUBE6 -> CUBE8
	 * 		CUBE7 -> CUBE1
	 * 		CUBE8 -> CUBE4
	 * 		CUBE9 -> CUBE7
	 */
    public void REvent(ArrayList<ArrayList<Shape>> faces) {
    	int cube = CUBE3, backCube = CUBE7;
    	for(int i = 0; i < 3; i++) {
    		Color color = faces.get(FRONT).get(cube).getColor();
        	faces.get(FRONT).get(cube).changeColor(faces.get(BOTTOM).get(cube).getColor());
        	faces.get(BOTTOM).get(cube).changeColor(faces.get(BACK).get(backCube).getColor());
        	faces.get(BACK).get(backCube).changeColor(faces.get(TOP).get(cube).getColor());
        	faces.get(TOP).get(cube).changeColor(color);
        	cube += SHIFT_ROW;
        	backCube -= SHIFT_ROW;
        	
    	} 
    
    	Color color = faces.get(RIGHT).get(CUBE1).getColor();
    	faces.get(RIGHT).get(CUBE1).changeColor(faces.get(RIGHT).get(CUBE7).getColor());
    	faces.get(RIGHT).get(CUBE7).changeColor(faces.get(RIGHT).get(CUBE9).getColor());
    	faces.get(RIGHT).get(CUBE9).changeColor(faces.get(RIGHT).get(CUBE3).getColor());
    	faces.get(RIGHT).get(CUBE3).changeColor(color);
    	color = faces.get(RIGHT).get(CUBE2).getColor();
    	faces.get(RIGHT).get(CUBE2).changeColor(faces.get(RIGHT).get(CUBE4).getColor());
    	faces.get(RIGHT).get(CUBE4).changeColor(faces.get(RIGHT).get(CUBE8).getColor());
    	faces.get(RIGHT).get(CUBE8).changeColor(faces.get(RIGHT).get(CUBE6).getColor());
    	faces.get(RIGHT).get(CUBE6).changeColor(color);
    }
    
    /*Event for handling a 90 degree, counterclockwise right face turn. This event involves the following movements:
	 * The right column of the front face becomes the right column of the bottom face
	 * The right column of the bottom face becomes the left column of the back face
	 * The left column of the back face becomes the right column of the top face
	 * The right column of the top face becomes the right column of the front face
	 * 
	 *  On the right face, the following positions are shifted:
	 * 		CUBE1 -> CUBE7
	 * 		CUBE2 -> CUBE4
	 * 		CUBE3 -> CUBE1
	 * 		CUBE4 -> CUBE8
	 * 		CUBE6 -> CUBE2
	 * 		CUBE7 -> CUBE9
	 * 		CUBE8 -> CUBE6
	 * 		CUBE9 -> CUBE3
	 */
	
    public void RPrimeEvent(ArrayList<ArrayList<Shape>> faces) {
    	int cube = CUBE3, backCube = CUBE7;
    	for(int i = 0; i < 3; i++) {
    		Color color = faces.get(FRONT).get(cube).getColor();
        	faces.get(FRONT).get(cube).changeColor(faces.get(TOP).get(cube).getColor());
        	faces.get(TOP).get(cube).changeColor(faces.get(BACK).get(backCube).getColor());
        	faces.get(BACK).get(backCube).changeColor(faces.get(BOTTOM).get(cube).getColor());
        	faces.get(BOTTOM).get(cube).changeColor(color);
        	cube += SHIFT_ROW;
        	backCube -= SHIFT_ROW;
        	
    	} 
    
    	Color color = faces.get(RIGHT).get(CUBE1).getColor();
    	faces.get(RIGHT).get(CUBE1).changeColor(faces.get(RIGHT).get(CUBE3).getColor());
    	faces.get(RIGHT).get(CUBE3).changeColor(faces.get(RIGHT).get(CUBE9).getColor());
    	faces.get(RIGHT).get(CUBE9).changeColor(faces.get(RIGHT).get(CUBE7).getColor());
    	faces.get(RIGHT).get(CUBE7).changeColor(color);
    	color = faces.get(RIGHT).get(CUBE2).getColor();
    	faces.get(RIGHT).get(CUBE2).changeColor(faces.get(RIGHT).get(CUBE6).getColor());
    	faces.get(RIGHT).get(CUBE6).changeColor(faces.get(RIGHT).get(CUBE8).getColor());
    	faces.get(RIGHT).get(CUBE8).changeColor(faces.get(RIGHT).get(CUBE4).getColor());
    	faces.get(RIGHT).get(CUBE4).changeColor(color);
    }
    

    /*Event for handling a 90 degree, clockwise left face turn. This event involves the following movements:
	 * The left column of the front face becomes the left column of the bottom face
	 * The left column of the bottom face becomes the right column of the back face
	 * The right column of the back face becomes the left column of the top face
	 * The left column of the top face becomes the left column of the front face
	 * 
	 * On the left face, the following positions are shifted:
	 * 		CUBE1 -> CUBE3
	 * 		CUBE2 -> CUBE6
	 * 		CUBE3 -> CUBE9
	 * 		CUBE4 -> CUBE2
	 * 		CUBE6 -> CUBE8
	 * 		CUBE7 -> CUBE1
	 * 		CUBE8 -> CUBE4
	 * 		CUBE9 -> CUBE7
	 */
    public void LEvent(ArrayList<ArrayList<Shape>> faces) {
    	int cube = CUBE1, backCube = CUBE9;
    	for(int i = 0; i < 3; i++) {
    		Color color = faces.get(FRONT).get(cube).getColor();
        	faces.get(FRONT).get(cube).changeColor(faces.get(TOP).get(cube).getColor());
        	faces.get(TOP).get(cube).changeColor(faces.get(BACK).get(backCube).getColor());
        	faces.get(BACK).get(backCube).changeColor(faces.get(BOTTOM).get(cube).getColor());
        	faces.get(BOTTOM).get(cube).changeColor(color);
        	cube += SHIFT_ROW;
        	backCube -= SHIFT_ROW;
        	
    	} 
    
    	Color color = faces.get(LEFT).get(CUBE1).getColor();
    	faces.get(LEFT).get(CUBE1).changeColor(faces.get(LEFT).get(CUBE7).getColor());
    	faces.get(LEFT).get(CUBE7).changeColor(faces.get(LEFT).get(CUBE9).getColor());
    	faces.get(LEFT).get(CUBE9).changeColor(faces.get(LEFT).get(CUBE3).getColor());
    	faces.get(LEFT).get(CUBE3).changeColor(color);
    	color = faces.get(LEFT).get(CUBE2).getColor();
    	faces.get(LEFT).get(CUBE2).changeColor(faces.get(LEFT).get(CUBE4).getColor());
    	faces.get(LEFT).get(CUBE4).changeColor(faces.get(LEFT).get(CUBE8).getColor());
    	faces.get(LEFT).get(CUBE8).changeColor(faces.get(LEFT).get(CUBE6).getColor());
    	faces.get(LEFT).get(CUBE6).changeColor(color);
    }
    
    /*Event for handling a 90 degree, counterclockwise left face turn. This event involves the following movements:
	 * The left column of the front face becomes the left column of the top face
	 * The left column of the top face becomes the right column of the back face
	 * The right column of the back face becomes the left column of the bottom face
	 * The left column of the bottom face becomes the left column of the front face
	 * 
	 * On the left face, the following positions are shifted:
	 * 		CUBE1 -> CUBE7
	 * 		CUBE2 -> CUBE4
	 * 		CUBE3 -> CUBE1
	 * 		CUBE4 -> CUBE8
	 * 		CUBE6 -> CUBE2
	 * 		CUBE7 -> CUBE9
	 * 		CUBE8 -> CUBE6
	 * 		CUBE9 -> CUBE3
	 */
    public void LPrimeEvent(ArrayList<ArrayList<Shape>> faces) {
    	int cube = CUBE1, backCube = CUBE9;
    	for(int i = 0; i < 3; i++) {
    		Color color = faces.get(FRONT).get(cube).getColor();
        	faces.get(FRONT).get(cube).changeColor(faces.get(BOTTOM).get(cube).getColor());
        	faces.get(BOTTOM).get(cube).changeColor(faces.get(BACK).get(backCube).getColor());
        	faces.get(BACK).get(backCube).changeColor(faces.get(TOP).get(cube).getColor());
        	faces.get(TOP).get(cube).changeColor(color);
        	cube += SHIFT_ROW;
        	backCube -= SHIFT_ROW;
        	
    	} 
    
    	Color color = faces.get(LEFT).get(CUBE1).getColor();
    	faces.get(LEFT).get(CUBE1).changeColor(faces.get(LEFT).get(CUBE3).getColor());
    	faces.get(LEFT).get(CUBE3).changeColor(faces.get(LEFT).get(CUBE9).getColor());
    	faces.get(LEFT).get(CUBE9).changeColor(faces.get(LEFT).get(CUBE7).getColor());
    	faces.get(LEFT).get(CUBE7).changeColor(color);
    	color = faces.get(LEFT).get(CUBE2).getColor();
    	faces.get(LEFT).get(CUBE2).changeColor(faces.get(LEFT).get(CUBE6).getColor());
    	faces.get(LEFT).get(CUBE6).changeColor(faces.get(LEFT).get(CUBE8).getColor());
    	faces.get(LEFT).get(CUBE8).changeColor(faces.get(LEFT).get(CUBE4).getColor());
    	faces.get(LEFT).get(CUBE4).changeColor(color);
    }
    
    /*Event for handling a 90 degree, clockwise top face turn. This event involves the following movements:
	 * The top row of the front face becomes the top row of the left face
	 * The top row of the left face becomes the top row of the back face
	 * The top row of the back face becomes the top row of the right face
	 * The top row of the right face becomes the top row of the front face
	 * 
	 * On the top face, the following positions are shifted:
	 * 		CUBE1 -> CUBE3
	 * 		CUBE2 -> CUBE6
	 * 		CUBE3 -> CUBE9
	 * 		CUBE4 -> CUBE2
	 * 		CUBE6 -> CUBE8
	 * 		CUBE7 -> CUBE1
	 * 		CUBE8 -> CUBE4
	 * 		CUBE9 -> CUBE7
	 */
    public void UEvent(ArrayList<ArrayList<Shape>> faces) {
    	int cube = CUBE1;
    	for(int i = 0; i < 3; i++) {
    		Color color = faces.get(FRONT).get(cube).getColor();
        	faces.get(FRONT).get(cube).changeColor(faces.get(RIGHT).get(cube).getColor());
        	faces.get(RIGHT).get(cube).changeColor(faces.get(BACK).get(cube).getColor());
        	faces.get(BACK).get(cube).changeColor(faces.get(LEFT).get(cube).getColor());
        	faces.get(LEFT).get(cube).changeColor(color);
        	cube++; 	
    	} 
    
    	Color color = faces.get(TOP).get(CUBE1).getColor();
    	faces.get(TOP).get(CUBE1).changeColor(faces.get(TOP).get(CUBE7).getColor());
    	faces.get(TOP).get(CUBE7).changeColor(faces.get(TOP).get(CUBE9).getColor());
    	faces.get(TOP).get(CUBE9).changeColor(faces.get(TOP).get(CUBE3).getColor());
    	faces.get(TOP).get(CUBE3).changeColor(color);
    	color = faces.get(TOP).get(CUBE2).getColor();
    	faces.get(TOP).get(CUBE2).changeColor(faces.get(TOP).get(CUBE4).getColor());
    	faces.get(TOP).get(CUBE4).changeColor(faces.get(TOP).get(CUBE8).getColor());
    	faces.get(TOP).get(CUBE8).changeColor(faces.get(TOP).get(CUBE6).getColor());
    	faces.get(TOP).get(CUBE6).changeColor(color);
    }
    
    /*Event for handling a 90 degree, counterclockwise top face turn. This event involves the following movements:
	 * The top row of the front face becomes the top row of the right face
	 * The top row of the right face becomes the top row of the back face
	 * The top row of the back face becomes the top row of the left face
	 * The top row of the left face becomes the top row of the front face
	 * 
	 * On the top face, the following positions are shifted:
	 * 		CUBE1 -> CUBE7
	 * 		CUBE2 -> CUBE4
	 * 		CUBE3 -> CUBE1
	 * 		CUBE4 -> CUBE8
	 * 		CUBE6 -> CUBE2
	 * 		CUBE7 -> CUBE9
	 * 		CUBE8 -> CUBE6
	 * 		CUBE9 -> CUBE3
	 */
    public void UPrimeEvent(ArrayList<ArrayList<Shape>> faces) {
    	int cube = CUBE1;
    	for(int i = 0; i < 3; i++) {
    		Color color = faces.get(FRONT).get(cube).getColor();
        	faces.get(FRONT).get(cube).changeColor(faces.get(LEFT).get(cube).getColor());
        	faces.get(LEFT).get(cube).changeColor(faces.get(BACK).get(cube).getColor());
        	faces.get(BACK).get(cube).changeColor(faces.get(RIGHT).get(cube).getColor());
        	faces.get(RIGHT).get(cube).changeColor(color);
        	cube++;
    	} 
    
    	Color color = faces.get(TOP).get(CUBE1).getColor();
    	faces.get(TOP).get(CUBE1).changeColor(faces.get(TOP).get(CUBE3).getColor());
    	faces.get(TOP).get(CUBE3).changeColor(faces.get(TOP).get(CUBE9).getColor());
    	faces.get(TOP).get(CUBE9).changeColor(faces.get(TOP).get(CUBE7).getColor());
    	faces.get(TOP).get(CUBE7).changeColor(color);
    	color = faces.get(TOP).get(CUBE2).getColor();
    	faces.get(TOP).get(CUBE2).changeColor(faces.get(TOP).get(CUBE6).getColor());
    	faces.get(TOP).get(CUBE6).changeColor(faces.get(TOP).get(CUBE8).getColor());
    	faces.get(TOP).get(CUBE8).changeColor(faces.get(TOP).get(CUBE4).getColor());
    	faces.get(TOP).get(CUBE4).changeColor(color);
    }
    
    /*Event for handling a 90 degree, clockwise back face turn. This event involves the following movements:
	 * The top row of the top face becomes the left column of the left face
	 * The left column of the left face becomes the bottom row of the bottom face
	 * The bottom row of the bottom face becomes the right column of the right face
	 * The right column of the right face becomes the top row of the top face
	 * 
	 * On the back face, the following positions are shifted:
	 * 		CUBE1 -> CUBE3
	 * 		CUBE2 -> CUBE6
	 * 		CUBE3 -> CUBE9
	 * 		CUBE4 -> CUBE2
	 * 		CUBE6 -> CUBE8
	 * 		CUBE7 -> CUBE1
	 * 		CUBE8 -> CUBE4
	 * 		CUBE9 -> CUBE7
	 */
    public void BEvent(ArrayList<ArrayList<Shape>> faces) {
    	int u1 = CUBE1, l1 = CUBE7, b1 = CUBE9, r1 = CUBE3;
    	for(int i = 0; i < 3; i++) {
    		Color color = faces.get(TOP).get(u1).getColor();
        	faces.get(TOP).get(u1).changeColor(faces.get(RIGHT).get(r1).getColor());
        	faces.get(RIGHT).get(r1).changeColor(faces.get(BOTTOM).get(b1).getColor());
        	faces.get(BOTTOM).get(b1).changeColor(faces.get(LEFT).get(l1).getColor());
        	faces.get(LEFT).get(l1).changeColor(color);
        	u1++;
        	l1 -= SHIFT_ROW;
        	b1--;
        	r1 += SHIFT_ROW;
        	
    	} 
    
    	Color color = faces.get(BACK).get(CUBE1).getColor();
    	faces.get(BACK).get(CUBE1).changeColor(faces.get(BACK).get(CUBE7).getColor());
    	faces.get(BACK).get(CUBE7).changeColor(faces.get(BACK).get(CUBE9).getColor());
    	faces.get(BACK).get(CUBE9).changeColor(faces.get(BACK).get(CUBE3).getColor());
    	faces.get(BACK).get(CUBE3).changeColor(color);
    	color = faces.get(BACK).get(CUBE2).getColor();
    	faces.get(BACK).get(CUBE2).changeColor(faces.get(BACK).get(CUBE4).getColor());
    	faces.get(BACK).get(CUBE4).changeColor(faces.get(BACK).get(CUBE8).getColor());
    	faces.get(BACK).get(CUBE8).changeColor(faces.get(BACK).get(CUBE6).getColor());
    	faces.get(BACK).get(CUBE6).changeColor(color);
    }
    
    /*Event for handling a 90 degree, counterclockwise back face turn. This event involves the following movements:
  	 * The top row of the top face becomes the right column of the right face
  	 * The right column of the right face becomes the bottom row of the bottom face
  	 * The bottom row of the bottom face becomes the left column of the left face
  	 * The left column of the left face becomes the top row of the top face
  	 * 
  	 * On the back face, the following positions are shifted:
  	 * 		CUBE1 -> CUBE7
	 * 		CUBE2 -> CUBE4
	 * 		CUBE3 -> CUBE1
	 * 		CUBE4 -> CUBE8
	 * 		CUBE6 -> CUBE2
	 * 		CUBE7 -> CUBE9
	 * 		CUBE8 -> CUBE6
	 * 		CUBE9 -> CUBE3
  	 */
      public void BPrimeEvent(ArrayList<ArrayList<Shape>> faces) {
      	int u1 = CUBE1, l1 = CUBE7, b1 = CUBE9, r1 = CUBE3;
      	for(int i = 0; i < 3; i++) {
      		Color color = faces.get(TOP).get(u1).getColor();
          	faces.get(TOP).get(u1).changeColor(faces.get(LEFT).get(l1).getColor());
          	faces.get(LEFT).get(l1).changeColor(faces.get(BOTTOM).get(b1).getColor());
          	faces.get(BOTTOM).get(b1).changeColor(faces.get(RIGHT).get(r1).getColor());
          	faces.get(RIGHT).get(r1).changeColor(color);
          	u1++;
          	l1 -= SHIFT_ROW;
          	b1--;
          	r1 += SHIFT_ROW;
          	
      	} 
      
      	Color color = faces.get(BACK).get(CUBE1).getColor();
      	faces.get(BACK).get(CUBE1).changeColor(faces.get(BACK).get(CUBE3).getColor());
      	faces.get(BACK).get(CUBE3).changeColor(faces.get(BACK).get(CUBE9).getColor());
      	faces.get(BACK).get(CUBE9).changeColor(faces.get(BACK).get(CUBE7).getColor());
      	faces.get(BACK).get(CUBE7).changeColor(color);
      	color = faces.get(BACK).get(CUBE2).getColor();
      	faces.get(BACK).get(CUBE2).changeColor(faces.get(BACK).get(CUBE6).getColor());
      	faces.get(BACK).get(CUBE6).changeColor(faces.get(BACK).get(CUBE8).getColor());
      	faces.get(BACK).get(CUBE8).changeColor(faces.get(BACK).get(CUBE4).getColor());
      	faces.get(BACK).get(CUBE4).changeColor(color);
      }
      
      
      /*Event for handling a 90 degree, clockwise bottom face turn. This event involves the following movements:
  	 * The bottom row of the front face becomes the bottom row of the right face
  	 * The bottom row of the right face becomes the bottom row of the back face
  	 * The bottom row of the back face becomes the bottom of the left face
  	 * The bottom row of the left becomes the bottom row of the front face
  	 * 
  	 * On the botttom face, the following positions are shifted:
  	 * 		CUBE1 -> CUBE3
  	 * 		CUBE2 -> CUBE6
  	 * 		CUBE3 -> CUBE9
  	 * 		CUBE4 -> CUBE2
  	 * 		CUBE6 -> CUBE8
  	 * 		CUBE7 -> CUBE1
  	 * 		CUBE8 -> CUBE4
  	 * 		CUBE9 -> CUBE7
  	 */
      public void DEvent(ArrayList<ArrayList<Shape>> faces) {
      	int cube = CUBE7;
      	for(int i = 0; i < 3; i++) {
      		Color color = faces.get(FRONT).get(cube).getColor();
          	faces.get(FRONT).get(cube).changeColor(faces.get(LEFT).get(cube).getColor());
          	faces.get(LEFT).get(cube).changeColor(faces.get(BACK).get(cube).getColor());
          	faces.get(BACK).get(cube).changeColor(faces.get(RIGHT).get(cube).getColor());
          	faces.get(RIGHT).get(cube).changeColor(color);
          	cube++;	
      	} 
      
      	Color color = faces.get(BOTTOM).get(CUBE1).getColor();
      	faces.get(BOTTOM).get(CUBE1).changeColor(faces.get(BOTTOM).get(CUBE7).getColor());
      	faces.get(BOTTOM).get(CUBE7).changeColor(faces.get(BOTTOM).get(CUBE9).getColor());
      	faces.get(BOTTOM).get(CUBE9).changeColor(faces.get(BOTTOM).get(CUBE3).getColor());
      	faces.get(BOTTOM).get(CUBE3).changeColor(color);
      	color = faces.get(BOTTOM).get(CUBE2).getColor();
      	faces.get(BOTTOM).get(CUBE2).changeColor(faces.get(BOTTOM).get(CUBE4).getColor());
      	faces.get(BOTTOM).get(CUBE4).changeColor(faces.get(BOTTOM).get(CUBE8).getColor());
      	faces.get(BOTTOM).get(CUBE8).changeColor(faces.get(BOTTOM).get(CUBE6).getColor());
      	faces.get(BOTTOM).get(CUBE6).changeColor(color);
      }
      
      /*Event for handling a 90 degree, counterclockwise bottom face turn. This event involves the following movements:
    	 * The bottom row of the front face becomes the bottom row of the left face
    	 * The bottom row of the left face becomes the bottom row of the back face
    	 * The bottom row of the back face becomes the bottom of the right face
    	 * The bottom row of the right becomes the bottom row of the front face
    	 * 
    	 * On the bottom face, the following positions are shifted:
    	 * 		CUBE1 -> CUBE3
    	 * 		CUBE2 -> CUBE6
    	 * 		CUBE3 -> CUBE9
    	 * 		CUBE4 -> CUBE2
    	 * 		CUBE6 -> CUBE8
    	 * 		CUBE7 -> CUBE1
    	 * 		CUBE8 -> CUBE4
    	 * 		CUBE9 -> CUBE7
    	 */
        public void DPrimeEvent(ArrayList<ArrayList<Shape>> faces) {
        	int cube = CUBE7;
        	for(int i = 0; i < 3; i++) {
        		Color color = faces.get(FRONT).get(cube).getColor();
            	faces.get(FRONT).get(cube).changeColor(faces.get(RIGHT).get(cube).getColor());
            	faces.get(RIGHT).get(cube).changeColor(faces.get(BACK).get(cube).getColor());
            	faces.get(BACK).get(cube).changeColor(faces.get(LEFT).get(cube).getColor());
            	faces.get(LEFT).get(cube).changeColor(color);
            	cube++;
        	} 
        
        	Color color = faces.get(BOTTOM).get(CUBE1).getColor();
        	faces.get(BOTTOM).get(CUBE1).changeColor(faces.get(BOTTOM).get(CUBE3).getColor());
        	faces.get(BOTTOM).get(CUBE3).changeColor(faces.get(BOTTOM).get(CUBE9).getColor());
        	faces.get(BOTTOM).get(CUBE9).changeColor(faces.get(BOTTOM).get(CUBE7).getColor());
        	faces.get(BOTTOM).get(CUBE7).changeColor(color);
        	color = faces.get(BOTTOM).get(CUBE2).getColor();
        	faces.get(BOTTOM).get(CUBE2).changeColor(faces.get(BOTTOM).get(CUBE6).getColor());
        	faces.get(BOTTOM).get(CUBE6).changeColor(faces.get(BOTTOM).get(CUBE8).getColor());
        	faces.get(BOTTOM).get(CUBE8).changeColor(faces.get(BOTTOM).get(CUBE4).getColor());
        	faces.get(BOTTOM).get(CUBE4).changeColor(color);
        }
}
