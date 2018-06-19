package com.LambdaPractise;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class PeopelLamdaExcercise8 {
	
	
	
	public static void main(String[] args)
	{
		
		int[] num= {3,4,5,7};
		int key=1;
		
		String s="ADE";
		changeString(s,stringWrapper(s1->s1.length()>5,s2->System.out.println(s2)));
		
		/*		
		operationOnArray(num,key,wrapper((v,k)->System.out.println(v/k)));
		
		
		
		List<People> peopleList=Arrays.asList(
					new People("Charels","Lacta",25),
					new People("Lewis","Lastz",33),
					new People("Robert","LastA",21),
					new People("Rebecca","Lastk",27),
					new People("Carol","Lactm",27)
									
					);
					
	
		Collections.sort(peopleList, (p1, p2)-> p1.getLasttname().compareTo(p2.getLasttname()));
	
		printConditionally(peopleList,p->true,p->System.out.println(p));
	
		printConditionally(peopleList,p-> p.getLasttname().contains("c"),p->System.out.println(p));
		printConditionally(peopleList,p->p.getFirstname().contains("c"),p->System.out.println(p.getFirstname()));

		*/
			
	
	
	}
	
	
	private static Consumer<String> stringWrapper(Predicate<String> pd,Consumer<String> consumer) {
	
		return (s)->{
			
			if(pd.test(s))
				consumer.accept(s+s.length()+"m5");
			else
				consumer.accept(s+s.length()+"l5");
		};
		
	}




	public static void changeString(String s,Consumer<String> consumer)
	{
		consumer.accept(s);
	}
	
	private static BiConsumer<Integer, Integer> wrapper(BiConsumer<Integer,Integer> consumner) {
		return (v,k)->{
			try
			{
			System.out.println("Executing from wrapper");
			consumner.accept(v, k);
			}
			catch(Exception e)
			{
				System.out.println("Exception caught in the wrapper lambda");
			}
		};
	}


	public static void operationOnArray(int[] num,int key,BiConsumer<Integer,Integer> consumer)
	{
		for(int i:num) {
			
			consumer.accept(i, key);
			
			}
	}

	
	
	public static void printConditionally(List<People> plist,Predicate<People> c,Consumer<People> pr)
	{
		for(People p:plist)
		{
			if(c.test(p))
				pr.accept(p);
		}
	}
	
	
	@FunctionalInterface
	public interface Condition
	{
		boolean test(People p);
		
	}

	
	interface Prints{
		
		void prints(People p);
	}


}


