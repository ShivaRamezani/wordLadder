import java.util.*;
import java.io.*;
public class WordLadder {
    private static LinkedList<String> dict;
    private static LinkedList<String> visited;
    private static String start, end;
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		File dictfile = new File("dictionary.txt");
		File infile = new File("infile.txt");
		dict = new LinkedList<>();
		// load the dictionary
		try(
			Scanner in = new Scanner(dictfile);){
			while(in.hasNext()) {
				
				 dict.add(in.next());
			}
		}
		try(Scanner in = new Scanner(infile);) 
		{
			while(in.hasNext()) {
			
				
				start = in.next();
				
				end = in.next();
				
				if(start.length()!=end.length() || !dict.contains(start) || !dict.contains(end) ){
					System.out.println("There is no word ladder between "+start+ " and "+end);
					continue;
				}
		
				findLadder(start,end);
			
			}
		}
		
	
	
	}
	
	public static void findLadder(String start,String end) {
		
		Queue<Stack<String>> queue = new LinkedList<>();
		visited = new LinkedList<>();
		Stack<String> copiedStack = new Stack<>();
      String x="";
 
      for(int i=0; i<dict.size(); i++) {
         if(isAnEdge(start, dict.get(i))) {
         Stack<String> s = new Stack<>();
         s.push(start);
         visited.add(start);
         s.push(dict.get(i));
         visited.add(dict.get(i));
         queue.add(s);
         }
         }
         //System.out.println(queue);  
        
         Stack<String> y;

         while(!queue.isEmpty()){
            y = queue.poll();
            x = y.peek();
              if(x.equals(end)) {
                System.out.println(y);
                break;}
              else {
                 for(String word : dict) {
                    if(!visited.contains(word) && isAnEdge(word, x)) {
                       copiedStack = (Stack<String>)y.clone();
                       copiedStack.add(word);
                       visited.add(word);
                       queue.add(copiedStack);
                       }
                 }
              }
           } 
      
           if(!x.equals(end))
              System.out.print("There is no ladder between " + start + " and " + end);                     
                
        
       }
            
        
   public static boolean isAnEdge (String w1, String w2) {
   int count =0;
       for(int i=0; i<w1.length(); i++) {
           if(w1.charAt(i) != w2.charAt(i))
                count++;
           else
              continue; 
       }
       if(count==1) 
          return true;
       else 
          return false;
              
    }
		
	
}



