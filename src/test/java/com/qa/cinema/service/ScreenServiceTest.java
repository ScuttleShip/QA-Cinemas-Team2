//package com.qa.cinema.service;
//import static org.junit.Assert.*;
//
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//import javax.inject.Inject;
//import javax.persistence.EntityManager;
//import javax.persistence.Query;
//
//import org.junit.Assert;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.Mockito;
//import org.mockito.runners.MockitoJUnitRunner;
//
//import com.qa.cinema.util.JSONUtil;
//import com.qa.cinema.persistence.Screen;
//
//@RunWith(MockitoJUnitRunner.class)
//
//public class ScreenServiceTest {
//	@InjectMocks
//	ScreenServiceDBImpl testScreenService;
//	
//	@Mock
//	JSONUtil util;
//	
//	@Mock
//	EntityManager em;
//	
//	@Mock
//	Query query;
//	
//	@Test
//	public void getAllScreensTest() {
//		
//		List<Screen> screenList = new ArrayList <Screen> ();
//		
//			
//		Screen testScreen = new Screen(1, 12, 300, 1);
//		
//		screenList.add(testScreen);
//		
//		Mockito.when(em.createQuery(Mockito.anyString())).thenReturn(query);
//		Mockito.when(query.getResultList()).thenReturn(screenList);
//		Mockito.when(util.getJSONForObject(screenList)).thenReturn("test");
//		
//		
//		String jsonForm = util.getJSONForObject(screenList);
//		System.out.println(jsonForm);
//		
//
//		String assertionString = testScreenService.getAllScreens();
//		Assert.assertEquals(assertionString, jsonForm);
//		
//		Mockito.verify(em).createQuery(Mockito.anyString());
//		
//	}
//	
//	@Test
//	public void addNewScreenTest() {
//		String testObject = "7";
//		Screen fakeScreen = new Screen(5, 12, 300, 1);
//		Mockito.when(util.getObjectForJSON(testObject, Screen.class)).thenReturn(fakeScreen);
//		Mockito.doNothing().when(em).persist(fakeScreen);
//		String jsonForm = testObject; 
//		String assertionString = testScreenService.addNewScreen(testObject); 
//		Assert.assertEquals(assertionString, jsonForm); 
//	}
//	
//	@Test
//	public void replaceScreenTest() {
//		String testObject = "6";
//		Screen fakeScreen = new Screen(5, 12, 300, 1);
//		Screen fakeScreen2 = new Screen(4, 1, 200, 1);
//		Mockito.when(util.getObjectForJSON(testObject, Screen.class)).thenReturn(fakeScreen);
//		Mockito.when(findScreen(4L)).thenReturn(fakeScreen2);
//		Mockito.doNothing().when(em).persist(fakeScreen2);
//		String jsonForm = "{\"message\": \"screen successfully updated\"}";
//		String assertionString = testScreenService.replaceScreen(4L ,testObject);
//		Assert.assertEquals(jsonForm, assertionString);
//	}
//
//	@Test
//	public void removeScreenTest() {
//		Screen fakeScreen = new Screen(1L, 1L, 300, 1);
//		Mockito.when(findScreen(1L)).thenReturn(fakeScreen);
//		Mockito.doNothing().when(em).remove(fakeScreen);
//		String jsonForm = "{\"message\": \"screen successfully removed\"}"; 
//		String assertionString = testScreenService.deleteScreen(1L); 
//		Assert.assertEquals(assertionString, jsonForm); 
//	}
//
//	
//	private Screen findScreen(Long screen_ID) {
//		return em.find(Screen.class, screen_ID);
//	}
//}
