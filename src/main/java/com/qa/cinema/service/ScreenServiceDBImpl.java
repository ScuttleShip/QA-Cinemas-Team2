package com.qa.cinema.service;

import java.util.Collection;

import javax.ejb.Stateless;
import javax.enterprise.inject.Default;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.qa.cinema.persistence.Screen;
import com.qa.cinema.util.JSONUtil;

@Stateless
@Default
public class ScreenServiceDBImpl implements ScreenService {

	@PersistenceContext(unitName = "primary")
	private EntityManager em;

	@Inject
	private JSONUtil util;

	@Override
	public String getAllScreens() {
		Query query = em.createQuery("SELECT s FROM Screen s");
		Collection<Screen> screens = (Collection<Screen>) query.getResultList();
		return util.getJSONForObject(screens);
	}

	@Override
	public String addNewScreen(String screenJson) {
		Screen newScreen = util.getObjectForJSON(screenJson, Screen.class);
		em.persist(newScreen);
		return screenJson;
	}

	@Override
	public String replaceScreen(Long screen_ID, String updatedScreen) {
		Screen updateScreen = util.getObjectForJSON(updatedScreen, Screen.class);
		Screen screen = findScreen(Long.valueOf(screen_ID));
		if (screen != null) {
			updateScreen.setScreen_ID(screen.getScreen_ID());
			screen = updateScreen;
			em.merge(screen);
		}
		return "{\"message\": \"screen successfully updated\"}";
	}

	@Override
	public String deleteScreen(Long screen_ID) {
		Screen screen = findScreen(Long.valueOf(screen_ID));
		if (screen != null) {
			em.remove(screen);
		}
		return "{\"message\": \"screen successfully removed\"}";
	}

	private Screen findScreen(Long screen_ID) {
		return em.find(Screen.class, screen_ID);
	}

}