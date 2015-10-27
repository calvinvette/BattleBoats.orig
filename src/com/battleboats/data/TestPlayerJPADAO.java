package com.battleboats.data;

public class TestPlayerJPADAO {

	public static void main(String[] args) {
		PlayerJPADAO dao = new PlayerJPADAO();
		
		Player harry = new Player();
		harry.setUsername("hpotter");
		harry.setDisplayName("The Boy Who Lived");
		harry.setEmail("hpotter@hogwarts.ac.uk");
		
		dao.insert(harry);
		
		System.out.println("Harry Potter Player: " + harry);
		System.out.println("ID: " + harry.getId());
		
		harry.setAge(36);
		
		Player foundHarry = dao.findById(harry.getId());
		System.out.println(foundHarry);
		System.out.println("Age: " + foundHarry.getAge());
	}

}
