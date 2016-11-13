
public class VirusDirection {
	public static int GO_RIGHT = 3;
	public static int GO_DOWN = 6;
	public static int GO_LEFT = 9;
	public static int GO_UP = 12;
	public static int GO_UP_RIGHT = 1;
	public static int GO_DOWN_RIGHT = 4;
	public static int GO_DOWN_LEFT = 7;
	public static int GO_UP_LEFT = 10;
	
	public static boolean IS_UP_PRESSED = false; 
	public static boolean IS_DOWN_PRESSED = false; 
	public static boolean IS_RIGHT_PRESSED = false; 
	public static boolean IS_LEFT_PRESSED = false; 
	
	public static int getDirection(){
		
		if(IS_UP_PRESSED){
			if(IS_LEFT_PRESSED)
				return 10;
			
			else if(IS_RIGHT_PRESSED)
				return 1;
			else 
				return 12;
		}
		else if(IS_DOWN_PRESSED){
			
			if(IS_LEFT_PRESSED)
				return 7;
			
			else if(IS_RIGHT_PRESSED)
				return 4;
			else 
				return 6;
		}
		else if(IS_LEFT_PRESSED)
			return 9;
		else if(IS_RIGHT_PRESSED)
			return 3;
		else return 0;
	}
}
