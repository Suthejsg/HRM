package com.LambdaPractise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class PersonLamdaExcercise7 {
	
	public static void main(String[] args)
	{
		
			List<People> peopleList=Arrays.asList(
					new People("Charels","Lacta",25),
					new People("Lewis","Lastz",33),
					new People("Robert","LastA",21),
					new People("Rebecca","Lastk",27),
					new People("Carol","Lactm",27)
									
					);
					
	
		Collections.sort(peopleList, new Comparator<People>()
				
				{

					@Override
					public int compare(People p1, People p2) {
						
						return p1.getLasttname().compareTo(p2.getLasttname());
					}
					
				}
				
				);
	
		printAllPeople(peopleList);
	
		getPeopleWithlastNamesC(peopleList,new Condition(){

					@Override
					public boolean test(People p) {
						if(p.getLasttname().contains("c"))
						return true;
						else
							return false;
					}
					
				});
		
		
		getPeopleWithlastNamesC(peopleList,new Condition(){

			@Override
			public boolean test(People p) {
				if(p.getFirstname().contains("c"))
				return true;
				else
					return false;
			}
			
		});
	
	
	}
	
	public static void printAllPeople(List<People> plist)
	{
	
		for(People p:plist)
		{
			System.out.println(p.toString());
		}
	
	}

	
	
	public static void getPeopleWithlastNamesC(List<People> plist,Condition c)
	{
		for(People p:plist)
		{
			if(c.test(p)==true)
				System.out.println(p.toString());
		}
	}
	
	public interface Condition
	{
		boolean test(People p);
		
	}


}
