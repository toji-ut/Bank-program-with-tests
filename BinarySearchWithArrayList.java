import java.util.ArrayList;

public class BinarySearchWithArrayList {
    public static int binarySearchWithArrayList(ArrayList<Account> anArray, int first, int last, String value) {

// Searches the array items anArray[first] through
// anArray[last] for value by using a binary search.
// Precondition: 0 <= first, last <= SIZE-1, where
// SIZE is the maximum size of the array, and
// anArray[first] <= anArray[first+1] <= ... <= anArray[last].
// Postcondition: If value is in the array, the method
// returns the index of the array item that equals value;
// otherwise the method returns -1.

        int index;

        if (first > last) {

            index = -1;      // value not in original array

        }
        else {

            // Invariant: If value is in anArray,
            // anArray[first] <= value <= anArray[last]

            int mid = (first + last)/2;

            if (value.equals(anArray.get(mid).getId())) {

                index = mid;  // value found at anArray[mid]

            }
            else if (value.compareTo(anArray.get(mid).getId()) < 0) {

                index = binarySearchWithArrayList(anArray, first, mid-1, value);   // point X

            }
            else {

                index = binarySearchWithArrayList(anArray, mid+1, last, value);    // point Y

            }  // end if
        }  // end if

        return index;
    }  // end binarySearch
}
