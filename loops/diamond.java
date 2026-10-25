public class diamond {
    public static void main(String[] args) {
        int size = 5;

        for (int row = 1; row <= 2 * size - 1; row++) {
            int stars;
            if (row <= size) {
                stars = 2 * row - 1;
            } else {
                stars = 2 * (2 * size - row) - 1;
            }
            int spaces = (2 * size - 1 - stars) / 2;

            for (int i = 0; i < spaces; i++) {
                System.out.print(" ");
            }
            for (int i = 0; i < stars; i++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}