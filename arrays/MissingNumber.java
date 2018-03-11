/**
 * MissingNumber
 */
public class MissingNumber {

    /**
     * Get missing number in a sequential list using binary search
     * Time complexity - log(n)
     */
	static int getMissingNumberInSequentialList(int a[], int l, int r) {

		if (l + 1 == r) {
			return l + 1;
		} else if (l >= r) {
			return -1;
		}

		int middle = (l + r) / 2;

		if (a[middle] - 1 == middle) {
			if (a[middle + 1] != a[middle] + 1) {
				return a[middle] + 1;
			}
			return getMissingNumberInSequentialList(a, middle + 1, r);
		} else {
			if (a[middle - 1] != a[middle] - 1) {
				return a[middle] - 1;
			}
			return getMissingNumberInSequentialList(a, l, middle - 1);
		}
	}

	public static void main(String... strings) {

		int a[] = {1, 2, 4, 5, 6};
		System.out.println(getMissingNumberInSequentialList(a, 0, a.length - 1));

		int b[] = {1, 2, 3, 5, 6};
		System.out.println(getMissingNumberInSequentialList(b, 0, b.length - 1));

		int c[] = {1, 2, 3, 4, 5, 7};
		System.out.println(getMissingNumberInSequentialList(c, 0, c.length - 1));

		int d[] = {2, 3, 4, 5, 6};
		System.out.println(getMissingNumberInSequentialList(d, 0, d.length - 1));

		int e[] = {1, 2, 3, 4, 5, 6};
		System.out.println(getMissingNumberInSequentialList(e, 0, e.length - 1));
	}
    
}