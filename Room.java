import java.util.HashMap;
import java.util.Scanner;
import java.util.Random;

public class Room{
	// declare instance variables
	private String name;
	private Item item;
	private String description;
    private Monster monster;

	// constructor
	public Room(String name, Item item, String description, Monster monster){
		this.name = name;
		this.item = item;
		this.description = description;
        this.monster = monster;
	}


	// create rooms
	public static HashMap<String, Room> createRooms(Scanner in){
		// Random object created to assign monsters and items
	    Random random = new Random();

		// empty rooms hashmap
		HashMap<String, Room> rooms = new HashMap<String, Room>();

		// create HashMap of monsters
		HashMap<String, Monster> monsters = Monster.createMonsters(in);
//		String[] monsterKeys = monsters.keySet().toArray(new String[monsters.size()]);

		// create HashMap of items
		HashMap<String, Item> items = Item.createItems(in);
//        String[] itemKeys = items.keySet().toArray(new String[items.size()]);

		while (true){
			String name = FileUtil.getNonCommentLine(in);
			if(name.equals("****************************************")){
				break;
			}
			String description = FileUtil.readParagraph(in);
			Monster monster;
			Item item;

			if(name.equals("stairway")){
				monster = monsters.get("mummy");
			} else{
				monster = null;
			}

			item = null;

			Room newRoom = new Room(name, item, description, monster);
			rooms.put(name, newRoom);
		}

		in.close();

		return rooms;
	}

	public static void randomMonsters(){

	}


	public void killMonster(){
		monster = null;
	}

	public void killItem()
	{
		item =null;
	}

	// getters 
	public String getName(){
		return name;}

	public Monster getMonster(){
		return monster;}

	public Item getItem(){
		return item;}

	public String getDescription(){
		return description;
	}

	//public int getXCoord(){
	//	return xCoord;}

	//public int getYCoord(){
	//	return yCoord;}

	// maps
	/*
	public static ArrayList<ArrayList<Room>> buildMap(HashMap<String, Room> rooms){
		ArrayList<ArrayList<Room>> map = new ArrayList<>();

		for(int i = 0; i < 5; i++){
			map.add(new ArrayList<>(ArrayList.asList(null, null, null, null, null)));
		}

		for(Map.Entry x: rooms.entrySet()){
			Room newRoom = (Room)x.getValue();
			int row = newRoom.getXCoord();
			int col = newRoom.getYCoord();
			map.get(row).set(col, newRoom);
		}

		return map;
	}

	// generate map view
	public static void viewMap(ArrayList<ArrayList<Room>> map){
		String lineString = "*************************************************";
		String dashString = "|               |               |               |";
		String hallString = "| Hallway                                       | Stairs";

		for(int i = 0; i < 11; i++){
			if(i == 0 || i == 4 || i == 6 || i == 10){;}
			else if (i == 2){
				System.out.println(lineString);}
			else if (i == 5){
				 System.out.println(Room.roomsForMap(map, 1));}
			else if (i == 8){
				System.out.println(hallString);}
			else{
				System.out.println(Room.roomsForMap(map, 3));}}

		System.out.println();
		System.out.println("You are " + currentRoom.getDescription());}

	// rooms for map
	public static String roomsForMap(ArrayList<ArrayList<Room>> map, int row){
		String roomLine = "| ";
		for(int i = 1; i < 4; i++){
			String roomName = map.get(row).get(i).getName();
			while(roomName.length() < 14){
				roomName += " ";}

			roomLine += roomName + "| ";}

		return roomLine;}
	*/
}