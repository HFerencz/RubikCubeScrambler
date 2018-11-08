/* RubikCubeController:
 * 	Accepts user input, optionally validates it and converts it to commands for the model or view.
 */

public class RubikCubeController {
	
	//Model and view objects
	private RubikCubeView view;
	private RubikCubeModel model;
	
	//Constructor for the controller
	public RubikCubeController(RubikCubeView view, RubikCubeModel model) {
		
		this.view = view;
		this.model = model;
		
		
	}
	/*With the case of all event handling, the first instruction is to pass the array list holding every cubelet of every
	 * face of the cube to the model such that changes can be made to the display. The last instruction is to tell the view to 
	 * "refresh" the display so that the user sees the changes.
	 */
	
	//Event handling a a 90 degree, clockwise, front face turn
	public void processFEvent() { 
		 model.FEvent(view.getRubikCubeArray());
		 view.repaintScreen();
	}
	
	//Event handling a a 90 degree, counterclockwise, front face turn
	public void processFPrimeEvent() { 
		 model.FPrimeEvent(view.getRubikCubeArray());
		 view.repaintScreen();
	}

	//Event handling a a 90 degree, clockwise, right face turn
	public void processREvent() { 
		 model.REvent(view.getRubikCubeArray());
		 view.repaintScreen();
	}
	
	//Event handling a a 90 degree, counterclockwise, right face turn
	public void processRPrimeEvent() { 
		 model.RPrimeEvent(view.getRubikCubeArray());
		 view.repaintScreen();
		}
	
	//Event handling a a 90 degree, clockwise, left face turn
	public void processLEvent() { 
		 model.LEvent(view.getRubikCubeArray());
		 view.repaintScreen();
		}
	
	//Event handling a a 90 degree, counterclockwise, left face turn
	public void processLPrimeEvent() { 
		 model.LPrimeEvent(view.getRubikCubeArray());
		 view.repaintScreen();
		}
	
	//Event handling a a 90 degree, clockwise, top face turn
	public void processUEvent() { 
		 model.UEvent(view.getRubikCubeArray());
		 view.repaintScreen();
		}
	
	//Event handling a a 90 degree, counterclockwise, top face turn
	public void processUPrimeEvent() { 
		 model.UPrimeEvent(view.getRubikCubeArray());
		 view.repaintScreen();
		}
	
	//Event handling a a 90 degree, clockwise, back face turn
	public void processBEvent() { 
		 model.BEvent(view.getRubikCubeArray());
		 view.repaintScreen();
		}
	
	//Event handling a a 90 degree, counterclockwise, back face turn
	public void processBPrimeEvent() { 
		 model.BPrimeEvent(view.getRubikCubeArray());
		 view.repaintScreen();
		}
	
	//Event handling a a 90 degree, clockwise, bottom face turn
	public void processDEvent() { 
		 model.DEvent(view.getRubikCubeArray());
		 view.repaintScreen();
		}
	
	//Event handling a a 90 degree, counterclockwise, bottom face turn
	public void processDPrimeEvent() { 
		 model.DPrimeEvent(view.getRubikCubeArray());
		 view.repaintScreen();
		}
}
