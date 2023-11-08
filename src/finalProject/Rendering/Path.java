package finalProject;

import java.util.ArrayList;

//used by enemy tanks to track down player tanks
public class Path {
	private ArrayList<String> list;

	public Path() {
		list = new ArrayList<String>();
	}
	
	//finds out if the path is a straight path
	public boolean isStraight() {
		if (list.size() == 0)
			return true;
		String first = list.get(0);
		for (String s : list) {
			if (!(s.equals(first)))
				return false;
		}
		return true;
	}
	
	public String get(int index) {
		return list.get(index);
	}

	public int size() {
		return list.size();
	}

	public void remove(int index) {
		list.remove(index);
	}

	public void add(String string) {
		list.add(0, string);
	}

	public void add(Path p) {
		for (int i = 0; i < p.size(); i++) {
			list.add(0, p.get(i));
		}
	}
	
	public String toString() {
		String end = "";
		for(String s : list) {
			end+= s + " ";
		}
		return end;
	}
	
	//gets a copy of the path
	public Path getCopy() {
		Path end = new Path();
		for(String s : list) {
			end.addToEnd(s);
		}
		return end;
	}
	
	public void addToEnd(String s) {
		list.add(s);
	}
}
