package Testing;

import game.FourInARowGame;
import game.Player;
import general.Config;

public class MDE_FileMonitorTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//FileMonitor my_monitor = new FileMonitor(new File("C:\\Users\\Michi\\Desktop\\test.txt"));
		//FileMonitor my_monitor = new FileMonitor(null);
		
		///Users/apfelbaum24/Desktop
		///Users/apfelbaum24/Dropbox/WI-Projekt INTERN/test
		FourInARowGame testGame = new FourInARowGame(Config.SETCOUNT); //C:\\Users\\Michi\\My Dropbox\\WI-Projekt INTERN\\test\\
		
		testGame.setCommDir("C:\\Users\\Michi\\My Dropbox\\WI-Projekt INTERN\\test\\");
		
		testGame.startNewSet(Player.O);
		//testGame.getCurrentSet().getWinningPlayer();
		//my_monitor.startMonitoring();
		
		//my_monitor.setFilePath(new File("C:\\Users\\Michi\\Desktop\\test.txt"));
	}

}
