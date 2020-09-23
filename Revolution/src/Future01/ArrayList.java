package Future01;

public class ArrayList {
	public final int max = 100;
	public int length;
	public int[] item;

	public ArrayList() {
		item = new int[max];
		length = 0;
	}

	public boolean isEmpty() {
		return length == 0 ? true : false;
	}

	public int getLength() {
		return length;
	}

	public void removeAll() {
		length = 0;
	}

	public int get(int position) {
		return item[position - 1];
	}

	public void add(int position, int element) {
		if (length < max) {
			length++;
			for (int i = length - 1; i > position; i--) {
				item[i] = item[i - 1];
			}
			item[position] = element;
		}
	}

	public void remove(int position) {
		int temp = item[position];

		for (int i = position; i < length - 1; i++)
			item[i] = item[i + 1];
		length--;
	}
}
