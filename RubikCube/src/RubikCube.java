/*************************************************************************************
 * Rubik's Cube Scrambler
 * 
 * Program that designs and implements a GUI using MVC framework that allows the
 * user to scramble and solve a 2D, unfolded Rubik's Cube. 
 * 
 * @author Hayden Ferencz, November 7, 2018
 *************************************************************************************/
public class RubikCube {
	public static void main(String[] args) {
		RubikCubeView view = new RubikCubeView();
		RubikCubeModel model = new RubikCubeModel();
		RubikCubeController controller = new RubikCubeController(view, model);
		view.registerObserver(controller);
	}
}
