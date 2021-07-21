package model;

import java.util.Comparator;

public class TodoComparator implements Comparator<Todo> {
	public int compare(Todo t1, Todo t2) {
		return Integer.parseInt(t1.getImportance()) > Integer.parseInt(t2.getImportance()) ? -1 : 1;
	}
}
