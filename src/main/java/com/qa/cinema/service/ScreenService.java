package com.qa.cinema.service;

public interface ScreenService {

		String getAllScreens();

		String addNewScreen(String screenJson);

		String replaceScreen(Long screen_ID, String updatedScreen);

		String deleteScreen(Long screen_ID);
}
