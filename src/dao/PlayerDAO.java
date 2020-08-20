package dao;

import java.awt.print.Paper;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Player;
import model.Skill;
import utility.ConnectionManager;

public class PlayerDAO{
	public List<Player> getAllPlayers() throws Exception{
		List<Player> list = new ArrayList<Player>();
		String player = "select ID,NAME,COUNTRY,S.ID,SKILLNAME FROM PERSON INNER JOIN ON SKILLS S WHERE S.ID = P.ID";
		Connection con=null;
		try {
			con=ConnectionManager.getConnection();
			Statement st = con.createStatement();
			ResultSet result =  st.executeQuery(player);
	
			while(result.next()) {
				Long playerld  = result.getLong("PLAYER_ID");
				String name = result.getString("NAME");
				String Country = result.getString("COUNTRY");
				Long Sid =  result.getLong("SKILL_ID");
				String SkillName = result.getString("SKILLNAMES");
				Skill skill = new Skill(Sid,SkillName);
				Player p1 = new Player(playerld,name,Country,skill);
				list.add(p1);	
			}
		} 
		
		catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());	
		}
		return list;
		
	}
}
