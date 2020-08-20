package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Skill;
import utility.ConnectionManager;

public class SkillDAO{
	public List<Skill> getSkillByID(Long id) throws Exception {
		String Skills="select SKILL_ID, SKILLNAMES from skills";
		List<Skill> list = new ArrayList<Skill>();
		 Connection con=null;
			   try {
				Statement statement = con.createStatement();
				con=ConnectionManager.getConnection();
				ResultSet resultSet = statement.executeQuery(Skills);
				
			    while(resultSet.next()) {
				Long skillid = resultSet.getLong("SKILL_ID");
				String skillName = resultSet.getString("SKILLNAMES");
				Skill skill = new Skill(skillid, skillName);
				list.add(skill);
				
			}
			   } catch (Exception e) {
				// TODO Auto-generated catch block
				   System.out.println(e.getMessage());	
			}
			  
			   return list;
	}
}



