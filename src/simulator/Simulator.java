public class Simulator {
	
	public static void main(String args[]) {
		// Flyable[]		flyableObjects;
		// WeatherTower	tower;

		// try {
		// 	flyableObjects = parseFile(args[0]);

		// 	for(Flyable object : flyableObjects) {
		// 		tower.register(object);
		// 	}



		// } catch(Exception e) {
		// 	System.out.println(e.getMessage());
		// }
	}
}

class UsageException extends Exception {
	public String getMessage() {
		return "usage : " + System.getProperty("sun.java.command") + " [scenario file]";
	}
}