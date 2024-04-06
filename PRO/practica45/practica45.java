import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class practica45 {
    private static ArrayList<String[]> usuarios = new ArrayList<>();

    private static void cargarUsuarios() {
        try {
            BufferedReader br = new BufferedReader(new FileReader("usuarios.txt"));
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] userData = linea.split(", ");
                usuarios.add(userData);
            }
            br.close();
        } catch (IOException e) {
            System.out.println("Error al cargar los usuarios.");
        }
    }

    private static void guardarUsuarios() {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter("usuarios.txt"));
            for (String[] usuario : usuarios) {
                bw.write(String.join(", ", usuario));
                bw.newLine();
            }
            bw.close();
        } catch (IOException e) {
            System.out.println("Error al guardar los usuarios.");
        }
    }

    private static void agregarUsuario(Scanner sc) {
        System.out.print("Ingrese el DNI del nuevo usuario: ");
        String dni = sc.nextLine();
        System.out.print("Ingrese el nombre del nuevo usuario: ");
        String nombre = sc.nextLine();
        System.out.print("Ingrese los apellidos del nuevo usuario: ");
        String apellidos = sc.nextLine();
        System.out.print("Ingrese el correo electrónico del nuevo usuario: ");
        String correo = sc.nextLine();
        String[] nuevoUsuario = {dni, nombre, apellidos, correo};
        usuarios.add(nuevoUsuario);
        guardarUsuarios();
        System.out.println("Usuario agregado correctamente.");
    }

    private static void eliminarUsuario(Scanner sc) {
        System.out.print("Ingrese el DNI del usuario que desea eliminar: ");
        String dni = sc.nextLine();
        boolean encontrado = false;
        for (String[] usuario : usuarios) {
            if (usuario[0].equals(dni)) {
                usuarios.remove(usuario);
                guardarUsuarios();
                System.out.println("Usuario eliminado correctamente.");
                encontrado = true;
                break;
            }
        }
        if (!encontrado)
            System.out.println("Usuario no encontrado.");
    }

    private static void buscarUsuario(Scanner sc) {
        System.out.print("Ingrese el DNI del usuario que desea buscar: ");
        String dni = sc.nextLine();
        boolean encontrado = false;
        for (String[] usuario : usuarios) {
            if (usuario[0].equals(dni)) {
                System.out.println("Usuario encontrado:");
                System.out.println(String.join(", ", usuario));
                encontrado = true;
                break;
            }
        }
        if (!encontrado)
            System.out.println("Usuario no encontrado.");
    }

    private static void mostrarMenu() {
        System.out.println("1. Agregar usuario");
        System.out.println("2. Eliminar usuario");
        System.out.println("3. Buscar usuario");
        System.out.println("4. Salir");
    }
    public static void main(String[] args) {
        cargarUsuarios();

        Scanner sc = new Scanner(System.in);
        int opcion;

        do {
            mostrarMenu();
            System.out.print("Ingrese el número de la opción que desea realizar: ");
            opcion = sc.nextInt();
            sc.nextLine(); // Limpiar el buffer

            switch (opcion) {
                case 1:
                    agregarUsuario(sc);
                    break;
                case 2:
                    eliminarUsuario(sc);
                    break;
                case 3:
                    buscarUsuario(sc);
                    break;
                case 4:
                    System.out.println("Saliendo del programa.");
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, ingrese un número válido.");
            }
        } while (opcion != 4);
    }
}

