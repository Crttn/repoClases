package PRO.practica44;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class practica44 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
<<<<<<< HEAD
        String patronDni = "\\d{8}[A-HJ-NP-TV-Za-hj-np-tv-z]";
=======
        String dniPattern = "\\d{8}[A-HJ-NP-TV-Za-hj-np-tv-z]";
>>>>>>> 1fc1af19fff098125c30752dc053f8d5c0b85d9c
        
        while (true) {
            System.out.println("Elija una opción:");
            System.out.println("1. Buscar por DNI");
            System.out.println("2. Ver todos los DNI");
            System.out.println("3. Salir");
            int opcion = sc.nextInt();
            sc.nextLine(); // Limpiar el buffer de entrada después de leer el entero

            switch (opcion) {
                case 1:
<<<<<<< HEAD
                    buscarPorDNI(sc, patronDni);
=======
                    buscarPorDNI(sc, dniPattern);
>>>>>>> 1fc1af19fff098125c30752dc053f8d5c0b85d9c
                    break;
                case 2:
                    verTodosLosDNI();
                    break;
                case 3:
                    System.out.println("Saliendo del programa.");
                    return; // Salir del método main
                default:
                    System.out.println("Opción inválida. Inténtalo de nuevo.");
            }
        }
    }

    private static void buscarPorDNI(Scanner sc, String dniPattern) {
        System.out.print("Introduce el DNI a buscar: ");
        String inputDNI = sc.nextLine().trim();
        if (inputDNI.matches(dniPattern)) {
            try (BufferedReader br = new BufferedReader(new FileReader("usuarios.txt"))) {
                String line;
                while ((line = br.readLine()) != null) {
                    if (line.startsWith(inputDNI)) {
                        System.out.println("DNI encontrado: " + line);
                        return;
                    } else {
                        System.out.println("DNI no encontrado.");
                        return;
                    }
                }
                
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("DNI inválido. Introduce un DNI válido.");
        }
    }

    private static void verTodosLosDNI() {
        try (BufferedReader br = new BufferedReader(new FileReader("usuarios.txt"))) {
<<<<<<< HEAD
            String linea;
            System.out.println("Todos los DNI:");
            while ((linea = br.readLine()) != null) {
                System.out.println(linea);
=======
            String line;
            System.out.println("Todos los DNI:");
            while ((line = br.readLine()) != null) {
                System.out.println(line);
>>>>>>> 1fc1af19fff098125c30752dc053f8d5c0b85d9c
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
