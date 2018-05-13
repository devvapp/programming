import java.util.ArrayList;

/**
 * https://xkcd.com/287/
 * @author aneesh
 *
 */
public class CombinationOfItemsMakeASum {

	public static void menu(int a[], int target, ArrayList ret, int i) {

		if (target <= 0) {
			if (target == 0) {
				System.out.println(ret);
			}
			return;
		}
		if (i == a.length) {
			return;
		}

		ret.add(a[i]);
		menu(a, target - a[i], ret, i + 1);
		ret.remove(ret.size() - 1);
		menu(a, target, ret, i + 1);

	}

	/**
	 * Need to work on this. Still not working.
	 * 
	 * @param a
	 * @param target
	 * @param ret
	 * @param i
	 */
	public static void menu2(int a[], int target, ArrayList ret, int i) {

		if (i == a.length) {
			return;
		}

		if (target - a[i] >= 0) {
			ret.add(a[i]);
			if (target - a[i] == 0) {
				System.out.println(ret);
				ret.remove(ret.size() - 1);
			} else {
				menu2(a, target - a[i], ret, i + 1);
			}
			// return;
		}
		menu2(a, target, ret, i + 1);
	}

	public static void main(String[] args) {

		int a[] = {4, 2, 3, 1};
		int target = 6;

		menu(a, target, new ArrayList(), 0);

	}

}
