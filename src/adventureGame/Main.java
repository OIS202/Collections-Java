package adventureGame;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
	
	private static Map<Integer, Location> locations = new HashMap<Integer, Location>();
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Map<String, Integer> tempExit = new HashMap<String, Integer>();
		locations.put(0, new Location(0, "quit", tempExit));

		tempExit = new HashMap<String, Integer>();
		tempExit.put("W", 2);
		tempExit.put("E", 3);
		tempExit.put("S", 4);
		tempExit.put("N", 5);
		locations.put(1, new Location(1, "road", tempExit));
		tempExit = new HashMap<String, Integer>();
		tempExit.put("N", 5);
		locations.put(2, new Location(2, "hill", tempExit));
		tempExit = new HashMap<String, Integer>();
		tempExit.put("W", 1);
		locations.put(3, new Location(3, "building", tempExit));
		tempExit = new HashMap<String, Integer>();
		tempExit.put("N", 1);
		tempExit.put("W", 2);
		locations.put(4, new Location(4, "valley", tempExit));
		tempExit = new HashMap<String, Integer>();
		tempExit.put("S", 1);
		tempExit.put("W", 2);
		locations.put(5, new Location(5, "forest", tempExit));
		
		int loc =1;
		while(true) {
			System.out.println(locations.get(loc).getDescription());
			if(loc == 0) {
				break;
			}
			
			Map<String, Integer> exits = locations.get(loc).getExits();
			System.out.println("Available exits are ");
			for(String exit: exits.keySet()) {
				System.out.print(exit + ",");
			}
			System.out.println();
			String direction = scanner.nextLine().toUpperCase();
			String [] arr = direction.split(" ");
			if(arr.length==1) {
				direction = String.valueOf(arr[0].charAt(0)); 
			}else {
				int index = -1;
				for(int i = 0;i<arr.length;i++) {
					if(arr[i].equals("NORTH")||arr[i].equals("EAST")||arr[i].equals("WEST")||arr[i].equals("SOUTH")) {
						index = i; 
					}
				}
				if(index != -1) {
					System.out.println(arr[index]);
					direction = String.valueOf(arr[index].charAt(0));
				}
			}
			if(exits.containsKey(direction)) {
				loc = exits.get(direction);
			}else
				System.out.println("Cannot go that way.");
			
		}
	}

}
