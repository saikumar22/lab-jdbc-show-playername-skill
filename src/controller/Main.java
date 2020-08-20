package controller;

import java.util.List;
import dao.PlayerDAO;
import model.Player;

public class Main {

	public static void main(String[] args) throws Exception {
		PlayerDAO pd =  new PlayerDAO();
		List<Player> list = pd.getAllPlayers();
		System.out.println(list.toString());
}
}