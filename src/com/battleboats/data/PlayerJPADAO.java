package com.battleboats.data;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceUnit;

public class PlayerJPADAO {
	// JPA Uses Dependency Injection
	// PersistenceContext uses EntityManagerFactory to push in an instance
	// But ONLY in a "managed" environment like
	// Full JEE: JBoss Wildfly, WebSphere, GlassFish
	// But not in non-managed environments like:
	// Web Profile JEE - Tomcat, Jetty
	// Swing, JavaFX, Java "main" apps, JUnit tests
	@PersistenceContext
	private EntityManager entityManager;
	
	
	// Use EntityManagerFactory in non-managed cases
	@PersistenceUnit(unitName="BattleBoats")
	private static EntityManagerFactory entityManagerFactory;
	
	public static EntityManagerFactory getEntityManagerFactory() {
		if (entityManagerFactory == null) {
			// Painful, 1-time bootstrapping
			// Keep this semi-permanently in memory during application lifetime
			entityManagerFactory = Persistence.createEntityManagerFactory("BattleBoats");
		}
		return entityManagerFactory;
	}
	
	public EntityManager getEntityManager() {
		if (entityManager == null) {
			entityManager = getEntityManagerFactory().createEntityManager();
		}
		return entityManager;
	}

	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	public Player insert(Player player) {
		getEntityManager().persist(player); // INSERT INTO PLAYER, Gen ID
		return player;
	}
	
	public Player update(Player player) {
		// Transient Objects: new or recently DB-deleted
		// Managed: auto-update
		// Detached: EM that found object earlier no longer in memory
		// merge() pushes a detached object back in to "managed" mode
		// forces updates to happen
		return getEntityManager().merge(player);
	}
	
	public Player delete(Player player) {
		getEntityManager().remove(player); // DELETE FROM PLAYER WHERE...
		return player; // no longer valid player in DB
	}
	
	public Player findById(Integer id) {
		return getEntityManager().find(Player.class, id);
	}

	public Player findByUserName(String userName) {
		return null;
	}
	
	public List<Player> findByEmail(String email) {
		return null;
	}
	
	
}
