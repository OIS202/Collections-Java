package adventureGame;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
	
	private static Map<Integer, Location> locations = new HashMap<Integer, Location>();
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		locations.put(0, new Location(0, "quit"));
		locations.put(1, new Location(1, "road"));
		locations.put(2, new Location(2, "hill"));
		locations.put(3, new Location(3, "building"));
		locations.put(4, new Location(4, "valley"));
		locations.put(5, new Location(5, "forest"));
		
		locations.get(1).addExit("W", 2);
		locations.get(1).addExit("E", 3);
		locations.get(1).addExit("S", 4);
		locations.get(1).addExit("N", 5);
		
		locations.get(2).addExit("N", 5);
		
		locations.get(3).addExit("W", 1);
		
		locations.get(4).addExit("N", 1);
		locations.get(4).addExit("W", 2);
		
		locations.get(5).addExit("S", 1);
		locations.get(5).addExit("w", 2);
		
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
