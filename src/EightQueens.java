import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EightQueens {
    
    private static class Position {
        
        private final int x, y;
        
        public Position(int x, int y) {
            this.x = x;
            this.y = y;
        }
        
        @Override
        public String toString() {
            return "{" + x + ", " + y + "}";
        }
    
        /**
         * Checks if this point is susceptible to attacks of a queen from a list of other positions.
         *
         * @param positions the positions of other queens.
         * @return {@code true} if this position is susceptible to an attack from another queen in the given positions.
         */
        public boolean isSusceptible(List<Position> positions) {
            for (Position position : positions) {
                //if the difference in x positions is equal to difference in y positions both positions in the same diagonal
                if (Math.abs(x - position.x) == Math.abs(y - position.y)) {
                    return true;
                }
            }
            
            return false;
        }
        
    }
    
    public static void main(String[] args) {
        heapPermutation(new int[]{1, 2, 3, 4, 5, 6, 7, 8}, 8);
    
        for (int[] perm : permutations) {
            List<Position> positions = new ArrayList<>();
            
            for (int index = 1; index <= perm.length; index++) {
                Position position = new Position(index, perm[index - 1]);
                
                if (position.isSusceptible(positions)) {
                    positions = null;
                    break;
                    
                } else {
                    positions.add(position);
                }
            }
    
            if (positions != null) {
                for (Position p : positions) {
                    System.out.print(p + " ");
                }
                System.out.println();
            }
        }
    }
    
    private static List<int[]> permutations = new ArrayList<>();
    
    /**
     * Implementation of <a href="https://en.wikipedia.org/wiki/Heap%27s_algorithm">Heap's algorithm</a>.
     *
     * O(n!)
     *
     * @param a the input to generate permutations of.
     * @param size the size of the unaltered elements.
     */
    private static void heapPermutation(int a[], int size) {
        if (size == 1) {
            permutations.add(Arrays.copyOf(a, a.length));
        }
        
        for (int i = 0; i < size; i++) {
            heapPermutation(a, size - 1);
            
            int swapIndex = size % 2 == 1 ? 0 : i;
            int temp = a[swapIndex];
            
            a[swapIndex] = a[size-1];
            a[size-1] = temp;
        }
    }
    
}