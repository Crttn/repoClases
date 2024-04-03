package ETS.practica14;

class practica14 {
    public static void main(String[] args) {
        System.out.println("Imprimir un bonito rombo\n");
        int n, i, j, space_0 = 1;
        n = 6;
        space_0 = n - 1;
        for (j = 1; j <= n; j++) {
            for (i = 1; i <= space_0; i++) {
                System.out.print(" ");
            }
            space_0--;
            for (i = 1; i <= 2 * j - 1; i++) {
                System.out.print("*");
            }
            System.out.println("");
        }
        space_0 = 1;
        for (j = 1; j <= n - 1; j++) {
            for (i = 1; i <= space_0; i++) {
                System.out.print(" ");
            }
            space_0++;
            for (i = 1; i <= 2 * (n - j) - 1; i++) {
                System.out.print("*");
            }
            System.out.println("");
        }
    }
}