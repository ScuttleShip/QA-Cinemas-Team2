package com.qa.cinema.util;

/*
 * @Author: Colin
 */
public class Print
{
	// This is just so I don't have to type out "System.out.println()" every time 
	// Lazy modo
	public static void print(String input)
	{
		System.out.println(input);
	}
	
	public static void printBlock(String... inputs)
	{
		for(String s : inputs)
		{
			System.out.println(s);
		}
	}
	
	// Fixes the length of a string by adding white space
	// So if you put "Hello" and a length of 10, it'll ad 5 whitespace
	// Very useful for printing out tables with neat columns
	public static String fixedString(String input, int length)
	{
		StringBuilder output = new StringBuilder(input);
		for(int i = 0; i < (length - input.length()); i++)
			output.append(" ");
		return output.toString();
	}
	
	// This prints out the string, but with lots of = on each side, to make a head.
	// ====================EXAMPLE====================
	public static String header(String title, int width)
	{	
		width = ((width - title.length())/2);
		StringBuilder output = new StringBuilder("");
		
		for(int i= 0; i <= width; i++)
			output.append("=");
		
		output.append(title.toUpperCase());
		
		for(int i= 0; i <= width; i++)
			output.append("=");
		return output.toString();
	}
}