import java.util.*;

public class Game{

	public static void main(String[] args) {
		Game game = new Game("level_1_master.txt");
		game.play();
	}

	// declare instance variable
	private Room currentRoom;
	private HashMap<String, Room> rooms; // allow all rooms to be found by name
	private Item currentWeapon;
	private HashMap<String, Item> items; // allow all items to be found by name
	private Player currentPlayer;

	//private Scanner userInputScanner;
	private String welcomeString;
	private HashMap<String, Monster> monsters; // allow all monsters to be found by name

	// getters and setters for room
	public Room getCurrentRoom()
	{
		return currentRoom;
	}

	public void setCurrentRoom(Room newRoom)
	{
		this.currentRoom = newRoom;
	}

	public Player getPlayer(){
		return currentPlayer;
	}

	// getters and setters for weapon
	public Item getCurrentWeapon()
	{
		return currentWeapon;
	}

	public void setCurrentWeapon(Item newWeapon)
	{
		this.currentWeapon = newWeapon;
	}

	// constructor
	public Game(String level01Txt)
	{
		// welcome 
		Scanner worldDataScanner = ResourceUtil.openFileScanner(level01Txt); // create a scanner object, read txt file in
		welcomeString = FileUtil.readParagraph(worldDataScanner);

		// rooms
		rooms = Room.createRooms(worldDataScanner);
		currentRoom = rooms.get("hallway");

		// player
		currentPlayer = Player.createPlayer(this);

		// initialize command mapper
		CommandMapper.init(this, currentRoom, currentPlayer);
	}

	private boolean processCommand()
	{
		String line = UI.promptLine("> ").trim(); // get user input

		if (line.equals("quit")){
			return true;
		}

		if (line.length() == 0 || !CommandMapper.isCommand(line))
		{
			System.out.println("Pleas enter a command.");
			return false;
		}

		Action action = CommandMapper.getAction(line); // the response here is any "object" implement response interface
		return action.execute();
	}

	private void play()
	{
		System.out.println(welcomeString);
		System.out.println("You are " + currentRoom.getDescription());
		currentPlayer.checkStatus();
		System.out.println("What would you like to do? [INSPECT, GO, QUIT]");

		while (!processCommand()) {
			System.out.println("What would you like to do? [INSPECT, GO, QUIT]");
		}
		System.out.println("Thank you for playing our game. Bye");
	}

	public HashMap<String,Room> getRooms(){
	    return rooms;
	}
}