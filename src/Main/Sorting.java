package Main;

import java.util.Comparator;

public class Sorting implements Comparator<Data> {
	

	@Override
	public int compare(Data o1, Data o2) {
		
		return o1.getName().compareToIgnoreCase(o2.getName());
	}

}
