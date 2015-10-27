package com.battleboats.data;

import java.util.List;

import javax.persistence.EntityManager;

public class PlayerJPADAO {
	private EntityManager entityManager;
	
	public EntityManager getEntityManager() {
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
