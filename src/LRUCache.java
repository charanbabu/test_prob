

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class LRUCache {
	private Deque<Integer> dequeue;
	private Set<Integer> set;
	private final int max_capacity ;
	private HashSet<Integer> ht = new LinkedHashSet<Integer>();
	static Map<Character,Integer> map = new HashMap<Character,Integer>();
	static Map<Integer,Character> rmap = new HashMap<Integer,Character>();
		
	
	

	public LRUCache(int size) {
		// TODO Auto-generated constructor stub
		dequeue = new LinkedList<>();
		set = new HashSet<>();
		max_capacity = size;
		
	}
	
	public void refer(int page) {
		// TODO Auto-generated constructor stub
		if(!set.contains(page))
		{
			if(dequeue.size()==max_capacity)
			{
				int last = dequeue.removeLast();
				set.remove(last);
			}
		}
		else
		{
			dequeue.remove(page);
		}
		dequeue.push(page);
		set.add(page);
		
	}
	
	 public void display() {
	        Iterator<Integer> itr = dequeue.iterator();
	        while (itr.hasNext()) { 
	            System.out.print(itr.next() + " "); 
	        } 
	 }
	
	// 1, 2, 3, 4, 1, 2, 5, 1, 2, 3, 4, 5


	public static void main(String[] args) {
		
		List<Integer> ls  = new ArrayList<Integer>();
		ls.add(3);
		ls.add(4);
		ls.add(5);
		
		List<Integer> ls1  = new ArrayList<Integer>();
		ls1.add(2);
		ls1.add(4);
		ls1.add(5);
		
		List<Integer> ls2  = new ArrayList<Integer>();
		ls2.add(2);
		ls2.add(4);
		ls2.add(5);
		List<List<Integer>> las = new ArrayList<List<Integer>>(Arrays.asList(ls, 
                ls1, 
                ls2));
		
		
		
	//	las =  las.stream().filter(a->a.stream().reduce(0, Integer::sum)==11).collect(Collectors.toList());
		las =  las.parallelStream().filter(a->a.parallelStream()
				  .mapToInt(Integer::valueOf)
				  .sum()==11).collect(Collectors.toList());
		//ls  = ls.stream().filter(a->a!=4).collect(Collectors.toList());
		System.out.println(las);


	}
	
	private static String sml(String string1) {
		
		Queue<Character> queue = new LinkedList<Character>();
		queue.add('S');
		queue.add('M');
		queue.add('L');
		Map<Character,Integer> mp = new HashMap<Character,Integer>();
		for(int i = 0 ; i < string1.length(); i ++)
		{
			
		
			
		}
		StringBuilder sb = new StringBuilder("");
		while (!queue.isEmpty())
		{
			Character s = queue.poll();
			if(mp.containsKey(s))
			{
			for(int i = 0 ; i < mp.get(s);i++)
			{
				sb.append(s);
			}
			}
		}
		return sb.toString();
	}
	
	public int majorityElement(final int[] nums) {
        final HashMap<Integer, Integer> map = new HashMap<>();
        Arrays.stream(nums).forEach(num -> map.put(num, map.getOrDefault(num, 0) + 1));
        return map.entrySet().stream().sorted(Comparator.comparingInt(entry -> entry.getValue() * -1))
                .findFirst().get().getKey();
    }

	private static String add(String string1, String string2) {
		int len1 = string1.length();
		int len2 = string2.length();
		StringBuilder sb = new StringBuilder("");
		 if(len1<len2)
		 {
			 StringBuilder sb3 = new StringBuilder(string1).reverse();
			 for(int i = 0 ; i < len2-len1 ; i++)
			 sb3.append('0');
			 string1 = sb3.reverse().toString();
		 }
		 else
		 {
			 StringBuilder sb3 = new StringBuilder(string2).reverse();
			 for(int i = 0 ; i < len1-len2 ; i++)
			 sb3.append('0');
			 string2 = sb3.reverse().toString();
		 }
		 int carry = 0 ;
		 for( int i = string2.length()-1; i >=0;i--)
		 {   
			 System.out.println(string1.charAt(i)+string2.charAt(i));
			 
			 int sum  = map.get(string1.charAt(i))+map.get(string2.charAt(i))+carry;
			 if(sum > 10)
			 {
				 carry = 1;
			 }
			 else
			 {
				 carry = 0 ;
			 }
			 sb.append(rmap.get(sum%10));
		 }
		 
			 if(carry > 0 )
			 {
				 sb.append(rmap.get(carry));
				 return sb.reverse().toString();
			 }
			 else
			 {
				 return sb.reverse().toString();
			 }
		 
	  
	}

}
