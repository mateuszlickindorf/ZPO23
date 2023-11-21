import java.util.HashSet;
import java.util.Set;

/**
 * A class that performs basic operations on sets of integers, including sum, difference, product,
 * symmetric difference, and methods to check if sets are identical or different.
 */
public class IntegerSetArythmetic {

    private Set<Integer> setA;
    private Set<Integer> setB;

    /**
     * Constructs an instance of IntegerSetArythmetic with empty sets.
     */
    public IntegerSetArythmetic() {
        this.setA = new HashSet<>();
        this.setB = new HashSet<>();
    }

    /**
     * Adds an element to set A.
     *
     * @param element The integer element to be added to set A.
     */
    public void addToSetA(int element) {
        setA.add(element);
    }

    /**
     * Adds an element to set B.
     *
     * @param element The integer element to be added to set B.
     */
    public void addToSetB(int element) {
        setB.add(element);
    }

    /**
     * Computes the sum of sets A and B.
     *
     * @return The set containing the elements of both sets A and B (A ∪ B).
     */
    public Set<Integer> sum() {
        Set<Integer> result = new HashSet<>(setA);
        result.addAll(setB);
        return result;
    }

    /**
     * Computes the difference of sets A and B (A - B).
     *
     * @return The set containing the elements present in set A but not in set B.
     */
    public Set<Integer> difference() {
        Set<Integer> result = new HashSet<>(setA);
        result.removeAll(setB);
        return result;
    }

    /**
     * Computes the product (common part) of sets A and B.
     *
     * @return The set containing the common elements of sets A and B (A ∩ B).
     */
    public Set<Integer> product() {
        Set<Integer> result = new HashSet<>(setA);
        result.retainAll(setB);
        return result;
    }

    /**
     * Computes the symmetric difference of sets A and B (A ∪ B - A ∩ B).
     *
     * @return The set containing the elements present in either set A or set B but not in both.
     */
    public Set<Integer> symmetricDifference() {
        Set<Integer> union = new HashSet<>(setA);
        union.addAll(setB);

        Set<Integer> intersection = new HashSet<>(setA);
        intersection.retainAll(setB);

        union.removeAll(intersection);

        return union;
    }

    /**
     * Checks if sets A and B are identical.
     *
     * @return {@code true} if sets A and B are identical, {@code false} otherwise.
     */
    public boolean areIdentical() {
        return setA.equals(setB);
    }

    /**
     * Checks if sets A and B are different.
     *
     * @return {@code true} if sets A and B are different, {@code false} if they are identical.
     */
    public boolean areDifferent() {
        return !areIdentical();
    }

    /**
     * Example usage of the IntegerSetOperations class.
     *
     * @param args The command-line arguments (not used in this example).
     */
    public static void main(String[] args) {
        // Example usage
        IntegerSetArythmetic setOperations = new IntegerSetArythmetic();

        setOperations.addToSetA(1);
        setOperations.addToSetA(2);
        setOperations.addToSetA(3);

        setOperations.addToSetB(2);
        setOperations.addToSetB(3);
        setOperations.addToSetB(4);

        System.out.println("Set A: " + setOperations.setA);
        System.out.println("Set B: " + setOperations.setB);
        System.out.println("Sum: " + setOperations.sum());
        System.out.println("Difference: " + setOperations.difference());
        System.out.println("Product: " + setOperations.product());
        System.out.println("Symmetric Difference: " + setOperations.symmetricDifference());
        System.out.println("Are Identical: " + setOperations.areIdentical());
        System.out.println("Are Different: " + setOperations.areDifferent());
    }
}
