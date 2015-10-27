package com.battleboats.data;

public class TestPlayerJPADAO {

	public static void main(String[] args) {
		// Should be this simple...
		PlayerJPADAO dao = new PlayerJPADAO();
		
		
		// Create a new "transient" Player called "Harry"
		Player harry = new Player();
		harry.setUsername("hpotter");
		harry.setDisplayName("The Boy Who Lived");
		harry.setEmail("hpotter@hogwarts.ac.uk");
		
		// Insert Harry into the DB (Need EntityManager+TX!!!)
		dao.insert(harry);
		
		System.out.println("Harry Potter Player: " + harry);
		// Verify the DB generated an AUTOINCREMENT PRIMARY KEY for Harry
		System.out.println("ID: " + harry.getId());

		// Make a "setter" change to the object copy of Harry
		harry.setAge(36);
		
		// Verify findById by looking up the same Player
		Player foundHarry = dao.findById(harry.getId());
		System.out.println(foundHarry);
		// Verify that the age was updated in the database
		System.out.println("Age: " + foundHarry.getAge());
	}

}
