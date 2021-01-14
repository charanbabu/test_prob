

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.NavigableMap;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.ConcurrentSkipListMap;

class test {

	public static void main(String[] args) {
		class one 
		{ 
		    public void print_geek() 
		    { 
		        System.out.println("Geeks"); 
		    } 
		} 
		  
		class two extends one 
		{ 
		    public void print_for() 
		    { 
		        System.out.println("for"); 
		    } 
		} 
		  
		class three extends two 
		{ 
		    
		} 
		  
		        three g = new three(); 
		        g.print_geek(); 
		        g.print_for(); 
		        g.print_geek(); 
	}		
	
	  public static int[] arrayRankTransform(int[] arr) {
	        
	        
	    	
	    	TreeSet<Integer> set = new TreeSet<Integer>();
	    	for(int i = 0 ; i < arr.length;i++)
	    	set.add(arr[i]);
	    	
	    	
	    	for(int i = 0 ; i < arr.length;i++)
	    	{
	    		 int res = 0;
	    		for (Object entry:set) {
	    		     if (entry.equals(arr[i])) 
	    		    	 {
	    		    	 arr[i] = res+1;
	    		    	 break;
	    		    	 }
	    		     
	    		     res++;
	    		   }
	    		   
	    	}
	    	
	    	
	    	
	    	
			return arr;
	        
        
    }
	 public static String sortString(String s) {
	        
	       // TreeMap<Character, Integer> tm = new TreeMap<Character,Integer>();
	        NavigableMap<Character, Integer> tm = new ConcurrentSkipListMap<Character, Integer>();

	       // TreeSet<Character> ts = new TreeSet<Character>();
	       
	        for( int i = 0 ; i < s.length() ; i ++)
	        {
	        	char c  = s.charAt(i);
	        	if(tm.containsKey(s.charAt(i)))
	        	{
	        		tm.put(c, tm.get(c)+1);
	        	}
	        	else
	        	{
	        		tm.put(c, 1);
	        	}
	        }
	        StringBuilder sb  = new StringBuilder("");
	        while(!tm.keySet().isEmpty())
	        {
	        for(char c  :tm.keySet())
	        {
	        	if(tm.get(c)==0)
	        	{
	        		tm.remove(c);
	        		continue;
	        	}
	        	sb.append(c);
	        	tm.put(c,tm.get(c)-1);
	        	
	        	
	        }
	        
	        for(char c  :tm.descendingKeySet())
	        {
	        	if(tm.get(c)==0)
	        	{
	        		tm.remove(c);
	        		continue;
	        	}
	        	
	        	sb.append(c);
	        	tm.put(c,tm.get(c)-1);
	        	        	
	        }
	        }
	        return sb.toString();
	    }
	

public static int maximum69Number (int num) {
	StringBuffer str  = new StringBuffer(Integer.toString(num));
	
	 // Creating array of string length 
    char[] ch = new char[str.length()]; 

    // Copy character by character into array 
    for (int i = 0; i < str.length(); i++) { 
        ch[i] = str.charAt(i); 
    } 
    
    for ( int i = 0 ; i < ch.length ; i++)
    {
    	if(ch[i]=='6')
    	{
    		ch[i]='9';
    		break;
    	}
    }
    return Integer.parseInt(new String(ch));
		
}
	
public static int daysBetweenDates(String date1, String date2) {
	Map<Integer, Integer> map =  new HashMap<Integer,Integer>();
	map.put(1, 31);
	map.put(2, 28);
	map.put(3, 31);
	map.put(4, 30);
	map.put(5, 31);
	map.put(6, 30);
	map.put(7, 31);
	map.put(8, 31);
	map.put(9, 30);
	map.put(10, 31);
	map.put(11, 30);
	map.put(12, 31);
	
	
   String[] l1 =  date1.split("-");
   String[] l2 = date2.split("-");
           int m1= Math.abs(Integer.parseInt(l1[1]));
		   int d1=Math.abs(Integer.parseInt(l1[2]));
		   int y1 = Math.abs(Integer.parseInt(l1[0]));
		   int m2=Math.abs(Integer.parseInt(l2[1]));
		   int d2=Math.abs(Integer.parseInt(l2[2]));
		   int y2 = Math.abs(Integer.parseInt(l2[0]));
   if(y1==y2 && m1==m2 && d1==d2)
    return 0;
   else if (y1==y2 && m1==m2 )
	   return (Math.abs(d1-d2));
   else if (y1==y2)
		   {
	   		return diffcalculator(map, m1, d1, y1, m2, d2, y2);
	   		
	   		
		   }
   else  
	   
   {
	   int diffyo = 0;
	    if(y1 < y2)
	    {
	    diffyo  = diffcalculator(map, m1, d1, y1, 12, 31, y1);
	    for (int i  = y1+1 ; i <y2 ; i++)
	    {
	    	if(i%4 == 0 )
	    	diffyo  = diffyo +366 ;
	    	else
	    	diffyo  = diffyo +365 ;
	    }
	    diffyo  = diffyo + diffcalculator(map, m2, d2, y2, 01, 00, y2);
	   
	    }
	    else
	    {
	    	 diffyo  = diffcalculator(map, m2, d2, y2, 12, 31, y2);
	    	 for (int i  = y2+1 ; i <y1 ; i++)
	 	    {
	    		 if(i%4 == 0 )
	    		    	diffyo  = diffyo +366 ;
	    		   else
	    		    	diffyo  = diffyo +365 ;
	 	    }
	    	 
	    	 diffyo  = diffyo + diffcalculator(map, m1, d1, y1, 01, 00, y1);
	    }
	    
	    return diffyo ; 
	   
	   
   }
	   
		   
}

private static int  diffcalculator(Map<Integer, Integer> map, int m1, int d1, int y1, int m2, int d2, int y2) {
	int countdiff =  0 ;
	if(m1 < m2)
	{
	int val1  = map.get(m1);
	if(y1%4 ==0 && m1==2)
	countdiff = val1-d1+1;
	else
	countdiff = val1-d1;
	for( int i = m1+1 ; i <m2 ; i++)
	{
		if(y1%4 ==0 && i==2)
		countdiff = countdiff + map.get(i)+1;
		else
		countdiff = countdiff + map.get(i);
		
	}
	countdiff = countdiff + d2  ;
	
	return countdiff ; 
	}
	 
	else if(m2<m1)
	{
	int val1  = map.get(m2);
	if(y2%4 ==0 && m2==2)
	countdiff = val1-d2+1;
	else
	countdiff = val1-d2;
	for( int i = m2+1 ; i <m1 ; i++)
	{
		if(y2%4 ==0 && i==2)
			countdiff = countdiff + map.get(i)+1;
		else
		countdiff = countdiff + map.get(i);
	}
	countdiff = countdiff + d1  ;
	
	return countdiff ; 
	}
	else
	{
		return Math.abs(d1-d2);
	}
}

	public static int[] searchRange(int[] nums, int target) {
		if (nums == null || nums.length == 0)
			return new int[] { -1, -1 };
		if (nums.length == 1)
			return nums[0] == target ? new int[] { 0, 0 } : new int[] { -1, -1 };

		int start = 0;
		int end = nums.length - 1;
		int mid = start + (end - start) / 2;

		while ((nums[start] != target || nums[end] != target) && start != end) {
			if (nums[mid] > target) {
				end = mid;
				mid = (end - start) / 2 + start;
			} else if (nums[mid] < target) {
				if (start == mid) {
					start++;
				} else {
					start = mid;
				}
				mid = end - (end - start) / 2;
			} else {
				if (nums[start] != target && mid - start == 1) {
					start++;
				}
				if (nums[end] != target && end - mid == 1) {
					end--;
				}
				if (nums[start] != target || nums[end] != target) {
					if (nums[start] == target) {
						mid = (end - mid) / 2 + mid;
					} else if (nums[end] == target) {
						mid = (mid - start) / 2 + start;
					} else {
						mid = (end - mid) / 2 + mid;
					}
				}
			}
		}

		if (start == end && nums[start] != target)
			return new int[] { -1, -1 };
		return new int[] { start, end };
	}

	public static int threeSumClosest(int[] nums, int target) {

		List<List<Integer>> list = new ArrayList<List<Integer>>();
		int globaldiff = 2147483647;
		int result = 0;

		// Mapping string values to int keys

		int numsize = nums.length;

		for (int i = 0; i <= numsize - 3; i++) {

			int low = i + 1;

			while (low <= numsize - 2) {
				int high = low + 1;
				while (high <= numsize - 1) {
					if (globaldiff > target - (nums[low] + nums[high] + nums[i])) {
						globaldiff = target - (nums[low] + nums[high] + nums[i]);
						result = nums[low] + nums[high] + nums[i];
					}

					high++;
				}
				low++;
			}

		}

		return result;
	}

	public static List<List<Integer>> threeSum(int[] nums) {

		List<List<Integer>> list = new ArrayList<List<Integer>>();

		Arrays.sort(nums);
		int numsize = nums.length - 1;

		for (int i = 0; i < nums.length - 2; i++) {
			if (nums[i] > 0) {
				break;
			}
			if (i == 0 || nums[i] != nums[i - 1]) {

				int sum = 0 - nums[i];
				int low = i + 1;
				int high = numsize;
				while (low < high) {
					if (nums[low] + nums[high] < sum) {
						low++;
					} else if (nums[low] + nums[high] > sum) {
						high--;
					} else {
						List<Integer> list1 = new ArrayList<Integer>();
						list1.add(nums[i]);
						list1.add(nums[low]);
						list1.add(nums[high]);
						while (low < high && nums[low] == nums[low + 1]) {
							low++;
						}
						while (low < high && nums[high] == nums[high - 1]) {
							high--;
						}
						low++;
						high--;
						list.add(list1);
					}

				}
			}
		}
		return list;
	}

	public List<String> generateParenthesis(int n) {
		StringBuilder sb = new StringBuilder("(");
		return null;
	}
//	private static String add(String string1, String string2) {
//		int len1 = string1.length();
//		int len2 = string2.length();
//		int big_len =  0;
//		int loop_iterations = 0 ;
//		StringBuilder sb = new StringBuilder("");
//		 if(len1 == len2)
//		 {
//			 loop_iterations=len1;
//			 big_len =len1;
//		 }
//		 else if(len1<len2)
//		 {
//			 loop_iterations = len1;
//			 big_len =len2;
//		 }
//		 else
//		 {
//			 loop_iterations = len2;
//			 big_len =len1;
//		 }
//		 int carry = 0 ;
//		 for( int i = loop_iterations; i >=big_len-loop_iterations;i--)
//		 {
//			 
//			 int sum  = map.get(string1.charAt(i))+map.get(string2.charAt(i))+carry;
//			 if(sum > 10)
//			 {
//				 carry = sum/10;
//			 }
//			 else
//			 {
//				 carry = 0 ;
//			 }
//			 sb.append(rmap.get(sum%10));
//		 }
//		 if(len1==len2)
//		 {
//			 if(carry > 0 )
//			 {
//				 sb.append(rmap.get(carry));
//				 return sb.reverse().toString();
//			 }
//			 
//		 }
//		 else if(len1>len2)
//		 {
//			 for(int i = big_len-loop_iterations-1 ; i >=0 ; i--)
//			 {
//				 int sum  = map.get(string1.charAt(i))+carry;
//				 if(sum > 10)
//				 {
//					 carry = sum/10;
//				 }
//				 else
//				 {
//					 carry = 0 ;
//				 }
//				 sb.append(rmap.get(sum%10));
//			 }
//			 
//		 }
//		 else
//		 {
//			 for(int i = big_len-loop_iterations-1 ; i >=0 ; i--)
//			 {
//				 int sum  = map.get(string2.charAt(i))+carry;
//				 if(sum > 10)
//				 {
//					 carry = sum/10;
//				 }
//				 else
//				 {
//					 carry = 0 ;
//				 }
//				 sb.append(rmap.get(sum%10));
//			 }
//			 
//		 }
//		 if(carry > 0 )
//		 {
//			 sb.append(rmap.get(carry));
//			 return sb.reverse().toString();
//		 }
//		 else
//		 {
//			  return sb.reverse().toString();
//		 }
//		 
//	  
//	}
	
}
