package entities;

import java.util.ArrayList;
import java.util.List;

public class PrintService<T extends Comparable<T>> {
	
	 private List<T> list = new ArrayList<>();
	 
	 public void addValue(T e) {
		 list.add(e); 
	 }
	 
	 public T first() {
		 return list.get(0);
	 }
	 
	 public void print() {
		 list.sort(null);
		 System.out.println(list);
	 }
}
