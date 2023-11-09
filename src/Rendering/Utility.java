package Rendering;

public class Utility {
	// used to find the index of an object
	public static int indexOf(Object o, Object[] arr, int limit) {
		for (int i = 0; i < limit; i++) {
			if (arr[i] == o)
				return i;
		}
		return -1;
	}
}
