

import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Set;

public class LRUCacheWithLinkedHSet {
	private Set<Integer> set ;
	private int max_capacity;

	public LRUCacheWithLinkedHSet(int size) {
		set = new LinkedHashSet<Integer>(size);
		max_capacity = size;
	}
	
    public void refer(int page)
    {
    	if(!set.contains(page))
    	{
    		if(set.size()==max_capacity)
    		{
    			int first_key = set.iterator().next();
    			set.remove(first_key);
    		}
    	}
    	else
    	{
    		set.remove(page);
    	}
    	set.add(page);
    }
 
    public void display() {
    	LinkedList<Integer> list = new LinkedList<>(set);
        Iterator<Integer> itr = list.descendingIterator();
        while (itr.hasNext()) { 
            System.out.print(itr.next() + " "); 
        } 
 }
    
    public static void main(String[] args) {
    	LRUCacheWithLinkedHSet cache = new LRUCacheWithLinkedHSet(3);
    	cache.refer(1);
        cache.refer(2);
        cache.refer(3);
        cache.refer(4);
        cache.refer(1);
        cache.refer(5);
        cache.refer(1);
        cache.refer(2);
        cache.refer(3);
        cache.refer(4);
        cache.refer(5);
        cache.display();

    	}

}
