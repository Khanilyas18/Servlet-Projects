package basic;

import java.util.ArrayList;
import java.util.List;

public class User {
	
	public static void main(String[] args) {
	
	
	ArrayList<String> list = new ArrayList<String>();
	
	list.add("abc");
	list.add("abc");
	list.add("abc");
	list.add("abc");
	
	list.remove(3);
	System.out.println(list);
	
	list.remove("");
	
	
	}

}
