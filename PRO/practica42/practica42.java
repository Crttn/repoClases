import java.util.Scanner;
import java.util.ArrayList;

public class practica42 {

    class Sala {
        private int id;
        private String pelicula;
        private String[][] sala;

        private Sala(int id, String pelicula) {
            this.id = id;
            this.pelicula = pelicula;
            this.sala = new String[7][8];
            llenarSala();
        }

        private void llenarSala() {
            for (int i = 0; i < sala.length; i++) {
                for (int j = 0; j < sala[0].length; j++) {
                    if (i == 0 && j == 0) {
                        sala[i][j] = " ";
                    } else if (i == 0) {
                        sala[i][j] = String.valueOf(j);
                    } else if (j == 0) {
                        sala[i][j] = String.valueOf(i);
                    } else {
                        sala[i][j] = "\033[32mD\33[0m";
                    }
                }
            }
        }

        private String getPelicula() {
            return pelicula;
        }

        private int getId() {
            return id;
        }

        private void imprimirAsientos() {
            System.out.println("\nPelícula: " + pelicula + "\n");
            for (String[] asientos : sala) {
                for (int j = 0; j < sala[0].length; j++) {
                    System.out.print(asientos[j] + " ");
                }
                System.out.println();
            }
        }

        private void comprarAsientoNormal(int fila, int columna, boolean paseEspecial) {
            if (paseEspecial == true && (fila == 1 && fila == 2)) {
                if (verificarAsiento(fila, columna)) {
                    sala[fila][columna] = "X";
                    System.out.println("\nHas comprado el asiento en la fila " + fila + " y columna " + columna
                            + " de la sala " + this.pelicula);
                } else {
                    System.out.println("El asiento no está disponible, por favor escoja otro");
                }
            } else {
                if (verificarAsiento(fila, columna) && (fila != 1 && fila != 2)) {
                    sala[fila][columna] = "X";
                    System.out.println("\nHas comprado el asiento en la fila " + fila + " y columna " + columna
                            + " de la sala " + this.id);
                } else {
                    System.out.println("El asiento no está disponible, por favor escoja otro");
                }
            }

        }

        private void comprarAsientoEspecial(int fila, int columna) {
            if (verificarAsiento(fila, columna)) {
                sala[fila][columna] = "X";
                System.out.println("\nHas comprado el asiento en la fila " + fila + " y columna " + columna
                        + " de la sala " + this.id);
            } else {
                System.out.println("\nEl asiento no está disponible, por favor escoja otro");
            }
        }

        private void cancelarCompra(int fila, int columna) {
            if (verificarAsiento(fila, columna) == false) {
                sala[fila][columna] = "\033[32mD\33[0m";
                System.out.println("Has cancelado la compra de tu asiento en la " + fila + " y columna " + columna
                        + " de la sala " + this.id);
            } else {
                System.out.println("El asiento no estaba reservado");
            }
        }

        private boolean verificarAsiento(int fila, int columna) {
            if (fila >= 0 && columna >= 0 && fila < sala.length && columna < sala[0].length) {
                if (sala[fila][columna].equals("\033[32mD\33[0m")) {
                    return true;
                } else {
                    System.out.println("Asiento no disponible");
                    return false;
                }
            }
            System.out.println("Asiento no existente");
            return false;
        }

        private boolean verificarSalaPrivada() {
            for (int i = 0; i < sala.length; i++) {
                for (int j = 0; j < sala[0].length; j++) {
                    if (sala[i][j].equalsIgnoreCase("X")) {
                        return false;
                    }
                }
            }
            return true;
        }

        private void reservarSalaPrivada() {
            for (int i = 0; i < sala.length; i++) {
                for (int j = 0; j < sala[0].length; j++) {
                    if (i != 0 && j != 0) {
                        sala[i][j] = "X";
                    }
                }
            }
        }
    }

    class estetica {

        private static void imprimirNombre() {
            System.out.print("\r\n" + //
                    "  /$$$$$$  /$$$$$$ /$$   /$$ /$$$$$$$$  /$$$$$$         /$$$$$$  /$$   /$$ /$$$$$$$  /$$$$$$$$ /$$       /$$$$$$  /$$$$$$ \r\n" + //
                    " /$$__  $$|_  $$_/| $$$ | $$| $$_____/ /$$__  $$       /$$__  $$| $$  | $$| $$__  $$| $$_____/| $$      |_  $$_/ /$$__  $$\r\n" + //
                    "| $$  \\__/  | $$  | $$$$| $$| $$      | $$  \\__/      | $$  \\ $$| $$  | $$| $$  \\ $$| $$      | $$        | $$  | $$  \\ $$\r\n" + //
                    "| $$        | $$  | $$ $$ $$| $$$$$   |  $$$$$$       | $$$$$$$$| $$  | $$| $$$$$$$/| $$$$$   | $$        | $$  | $$  | $$\r\n" + //
                    "| $$        | $$  | $$  $$$$| $$__/    \\____  $$      | $$__  $$| $$  | $$| $$__  $$| $$__/   | $$        | $$  | $$  | $$\r\n" + //
                    "| $$    $$  | $$  | $$\\  $$$| $$       /$$  \\ $$      | $$  | $$| $$  | $$| $$  \\ $$| $$      | $$        | $$  | $$  | $$\r\n" + //
                    "|  $$$$$$/ /$$$$$$| $$ \\  $$| $$$$$$$$|  $$$$$$/      | $$  | $$|  $$$$$$/| $$  | $$| $$$$$$$$| $$$$$$$$ /$$$$$$|  $$$$$$/\r\n" + //
                    " \\______/ |______/|__/  \\__/|________/ \\______/       |__/  |__/ \\______/ |__/  |__/|________/|________/|______/ \\______/ \r\n" + //
                    "                                                                                                                          \r\n" + //
                    "");
        }

        public static void imprimirOpciones() {
            System.out.print("\r\n" + //
                    "╔═╗╔═╗╔═╗╦╔═╗╔╗╔╔═╗╔═╗\r\n" + //
                    "║ ║╠═╝║  ║║ ║║║║║╣ ╚═╗\r\n" + //
                    "╚═╝╩  ╚═╝╩╚═╝╝╚╝╚═╝╚═╝\r\n" + "");
        }

        private static int imprimirTiposOpciones(Scanner sc) {
            System.out.println(
                    "\n1) Ver cartelera     2) Ver asientos disponibles     3) Comprar asientos     4) Cancelar compra     5) Salir");
            System.out.print("\nEscoge una de las opciones anteriores: ");
            int opcion = 0;
            return opcion = sc.nextInt();
        }

        private static void imprimirCartelera() {
            System.out.print("\r\n" + //
                    "╔═╗╔═╗╦═╗╔╦╗╔═╗╦  ╔═╗╦═╗╔═╗\r\n" + //
                    "║  ╠═╣╠╦╝ ║ ║╣ ║  ║╣ ╠╦╝╠═╣\r\n" + //
                    "╚═╝╩ ╩╩╚═ ╩ ╚═╝╩═╝╚═╝╩╚═╩ ╩");
        }

        private static void imprimrAsientos() {
            System.out.print("\r\n" + //
                    "╔═╗╔═╗╦╔═╗╔╗╔╔╦╗╔═╗╔═╗\r\n" + //
                    "╠═╣╚═╗║║╣ ║║║ ║ ║ ║╚═╗\r\n" + //
                    "╩ ╩╚═╝╩╚═╝╝╚╝ ╩ ╚═╝╚═╝");
        }

        private static void imprimirCompra() {
            System.out.print("\r\n" + //
                    "╔═╗╔═╗╔╦╗╔═╗╦═╗╔═╗  ╔╦╗╔═╗  ╔═╗╔═╗╦╔═╗╔╗╔╔╦╗╔═╗╔═╗\r\n" + //
                    "║  ║ ║║║║╠═╝╠╦╝╠═╣   ║║║╣   ╠═╣╚═╗║║╣ ║║║ ║ ║ ║╚═╗\r\n" + //
                    "╚═╝╚═╝╩ ╩╩  ╩╚═╩ ╩  ═╩╝╚═╝  ╩ ╩╚═╝╩╚═╝╝╚╝ ╩ ╚═╝╚═╝");
        }

        private static int imprimirTiposReserva(Scanner sc) {
            System.out.println("\nTipos de reserva: ");
            System.out.println("\n1) Reserva normal     2) Reserva Especial     3) Reserva Privada");
            System.out.print("\nEscoje el tipo de reserva: ");
            int valor = 0;
            return valor = sc.nextInt();
        }

        private static void imprimirReservaNormal() {
            System.out.print("\r\n" + //
                    "╦═╗╔═╗╔═╗╔═╗╦═╗╦  ╦╔═╗  ╔╗╔╔═╗╦═╗╔╦╗╔═╗╦  \r\n" + //
                    "╠╦╝║╣ ╚═╗║╣ ╠╦╝╚╗╔╝╠═╣  ║║║║ ║╠╦╝║║║╠═╣║  \r\n" + //
                    "╩╚═╚═╝╚═╝╚═╝╩╚═ ╚╝ ╩ ╩  ╝╚╝╚═╝╩╚═╩ ╩╩ ╩╩═╝");
        }

        private static void imprimirReservaespecial() {
            System.out.println("\r\n" + //
                    "╦═╗╔═╗╔═╗╔═╗╦═╗╦  ╦╔═╗  ╔═╗╔═╗╔═╗╔═╗╔═╗╦╔═╗╦  \r\n" + //
                    "╠╦╝║╣ ╚═╗║╣ ╠╦╝╚╗╔╝╠═╣  ║╣ ╚═╗╠═╝║╣ ║  ║╠═╣║  \r\n" + //
                    "╩╚═╚═╝╚═╝╚═╝╩╚═ ╚╝ ╩ ╩  ╚═╝╚═╝╩  ╚═╝╚═╝╩╩ ╩╩═╝");
        }

        private static void imprimirReservaPrivada() {
            System.out.print("\r\n" + //
                    "╦═╗╔═╗╔═╗╔═╗╦═╗╦  ╦╔═╗  ╔═╗╦═╗╦╦  ╦╔═╗╔╦╗╔═╗\r\n" + //
                    "╠╦╝║╣ ╚═╗║╣ ╠╦╝╚╗╔╝╠═╣  ╠═╝╠╦╝║╚╗╔╝╠═╣ ║║╠═╣\r\n" + //
                    "╩╚═╚═╝╚═╝╚═╝╩╚═ ╚╝ ╩ ╩  ╩  ╩╚═╩ ╚╝ ╩ ╩═╩╝╩ ╩");
        }

        private static void imprimirCancelarCompra() {
            System.out.println("\r\n" + //
                    "╔═╗╔═╗╔╗╔╔═╗╔═╗╦  ╔═╗╦═╗  ╔═╗╔═╗╔╦╗╔═╗╦═╗╔═╗\r\n" + //
                    "║  ╠═╣║║║║  ║╣ ║  ╠═╣╠╦╝  ║  ║ ║║║║╠═╝╠╦╝╠═╣\r\n" + //
                    "╚═╝╩ ╩╝╚╝╚═╝╚═╝╩═╝╩ ╩╩╚═  ╚═╝╚═╝╩ ╩╩  ╩╚═╩ ╩");
        }

        private static void imprimirSeparador() {
            for (int i = 0; i < 125; i++) {
                System.out.print("-");
            }
            System.out.println("");
        }

        private static int obtenerEleccion(Scanner sc, String mensaje) {
            System.out.println("\n" + mensaje);
            return sc.nextInt();
        }

        private static String obtenerTetxo(Scanner sc, String mensaje) {
            System.out.println("\n" + mensaje);
            return sc.nextLine();
        }
    }

    public static void main(String[] args) {
        practica42 cine = new practica42();
        practica42.Sala sala1 = cine.new Sala(1, "Spiderman");
        practica42.Sala sala2 = cine.new Sala(2, "Avengers");
        practica42.Sala sala3 = cine.new Sala(3, "FNAF");
        practica42.Sala sala4 = cine.new Sala(4, "The Witcher");

        String[] listaReservaEspecial = { "Antonio", "Jose", "Chema" };
        ArrayList<String> listaReservaPrivada = new ArrayList<>();

        Scanner sc = new Scanner(System.in);

        estetica.imprimirSeparador();
        estetica.imprimirNombre();

        while (true) {
            estetica.imprimirSeparador();
            estetica.imprimirOpciones();
            int opcion = estetica.imprimirTiposOpciones(sc);

            switch (opcion) {
                // Ver cartelera
                case 1:
                    estetica.imprimirSeparador();
                    estetica.imprimirCartelera();
                    System.out.println("\nSala número: " + sala1.getId() + " " + sala1.getPelicula());
                    System.out.println("\nSala número: " + sala2.getId() + " " + sala2.getPelicula());
                    System.out.println("\nSala número: " + sala3.getId() + " " + sala3.getPelicula());
                    System.out.println("\nSala número: " + sala4.getId() + " " + sala3.getPelicula() + " ¡¡ESTRENO!!");
                    break;
                // Ver asientos disponibles
                case 2:
                    estetica.imprimirSeparador();
                    estetica.imprimrAsientos();
                    int eleccion = estetica.obtenerEleccion(sc, "Elige la sala para ver sus asientos: ");

                    if (eleccion == 1) {
                        sala1.imprimirAsientos();
                    } else if (eleccion == 2) {
                        sala2.imprimirAsientos();
                    } else if (eleccion == 3) {
                        sala3.imprimirAsientos();
                    } else {
                        sala4.imprimirAsientos();
                    }
                    break;
                // Comprar asientos
                case 3:
                    estetica.imprimirSeparador();
                    estetica.imprimirCompra();
                    int tipoReserva = estetica.imprimirTiposReserva(sc);

                    if (tipoReserva == 1) { // RESERVA NORMAL
                        estetica.imprimirSeparador();
                        estetica.imprimirReservaNormal();

                        int eleccion1 = estetica.obtenerEleccion(sc, "Elige la sala para ver sus asientos: ");
                        int cantidadAsientos = estetica.obtenerEleccion(sc,
                                "Elige la cantidad de asientos a comprar: ");
                        sc.nextLine();
                        System.out.print("\nTienes pase especial? S/N: ");
                        String respuesta = sc.nextLine();
                        boolean paseEspecial = false;
                        if (respuesta.equalsIgnoreCase("S")) {
                            paseEspecial = true;
                        } else {
                            paseEspecial = false;
                        }
                        if (eleccion1 == 1) {
                            sala1.imprimirAsientos();
                            for (int i = 0; i < cantidadAsientos; i++) {
                                int fila = estetica.obtenerEleccion(sc, "Selecciona la fila: ");
                                int columan = estetica.obtenerEleccion(sc, "Selecciona la columna: ");
                                sala1.comprarAsientoNormal(fila, columan, paseEspecial);
                            }
                            sala1.imprimirAsientos();
                        } else if (eleccion1 == 2) {
                            sala2.imprimirAsientos();
                            for (int i = 0; i < cantidadAsientos; i++) {
                                int fila = estetica.obtenerEleccion(sc, "Selecciona la fila: ");
                                int columan = estetica.obtenerEleccion(sc, "Selecciona la columna: ");
                                sala2.comprarAsientoNormal(fila, columan, paseEspecial);
                            }
                            sala2.imprimirAsientos();
                        } else {
                            sala3.imprimirAsientos();
                            for (int i = 0; i < cantidadAsientos; i++) {
                                int fila = estetica.obtenerEleccion(sc, "Selecciona la fila: ");
                                int columan = estetica.obtenerEleccion(sc, "Selecciona la columna: ");
                                sala3.comprarAsientoNormal(fila, columan, paseEspecial);
                            }
                            sala3.imprimirAsientos();
                        }
                    } else if (tipoReserva == 2) { // RESERVA ESPECIAL
                        estetica.imprimirSeparador();
                        estetica.imprimirReservaespecial();
                        int eleccion1 = estetica.obtenerEleccion(sc, "Elige la sala para ver sus asientos: ");
                        sc.nextLine();
                        if (eleccion1 == 4) {
                            System.out.print("\nIntroduzca su nombre: ");
                            String nombreInvitado = sc.nextLine();
                            boolean encontrado = false;
                            for (String nombre : listaReservaEspecial) {
                                if (nombre.equals(nombreInvitado)) {
                                    encontrado = true;
                                    break;
                                }
                            }
                            if (encontrado) {
                                sala4.imprimirAsientos();
                                int fila = estetica.obtenerEleccion(sc, "Selecciona la fila: ");
                                int columan = estetica.obtenerEleccion(sc, "Selecciona la columna: ");
                                sala4.comprarAsientoEspecial(fila, columan);
                                sala4.imprimirAsientos();
                            } else {
                                System.out.println("\nSu nombre no se encuentra en la lista de invitados");

                            }
                        }

                    } else { //RESERVA PRIVADA
                        estetica.imprimirSeparador();
                        estetica.imprimirReservaPrivada();
                        int salaPrivada = estetica.obtenerEleccion(sc, "Selecciona la sala: ");

                        if (salaPrivada == 1) {
                            if (sala1.verificarSalaPrivada() == true) {
                                sala1.reservarSalaPrivada();
                                System.out.println("Has reservado la sala " + sala1.getId());
                                sala1.imprimirAsientos();
                                int numPersonas = estetica.obtenerEleccion(sc, "Introduce el número de personas que van a asistir");
                                sc.nextLine();
                                for (int i = 0; i < numPersonas; i++) {
                                   String invitado = estetica.obtenerTetxo(sc,"Introduce el nombre del invitado");
                                   listaReservaPrivada.add(invitado);
                                }
                            }
                        } else if (salaPrivada == 2) {
                            if (sala2.verificarSalaPrivada() == true) {
                                sala2.reservarSalaPrivada();
                                System.out.println("Has reservado la sala " + sala2.getId());
                                sala2.imprimirAsientos();
                                int numPersonas = estetica.obtenerEleccion(sc, "Introduce el número de personas que van a asistir");
                                sc.nextLine();
                                for (int i = 0; i < numPersonas; i++) {
                                   String invitado = estetica.obtenerTetxo(sc,"Introduce el nombre del invitado");
                                   listaReservaPrivada.add(invitado);
                                }
                            }
                        } else if (salaPrivada == 3) {
                            if (sala3.verificarSalaPrivada() == true) {
                                sala3.reservarSalaPrivada();
                                System.out.println("Has reservado la sala " + sala1.getId());
                                sala3.imprimirAsientos();
                                int numPersonas = estetica.obtenerEleccion(sc, "Introduce el número de personas que van a asistir");
                                sc.nextLine();
                                for (int i = 0; i < numPersonas; i++) {
                                   String invitado = estetica.obtenerTetxo(sc,"Introduce el nombre del invitado");
                                   listaReservaPrivada.add(invitado);
                                }
                            }
                        } else {

                        }
                    }
                    break;
                // Cancelar compra
                case 4:
                    estetica.imprimirSeparador();
                    estetica.imprimirCancelarCompra();
                    int salaCancelar = estetica.obtenerEleccion(sc, "Para cancelar la compra introduce la sala: ");
                    int filaCancelar = estetica.obtenerEleccion(sc, "Introduce la fila: ");
                    int columnaCancelar = estetica.obtenerEleccion(sc, "Introduce la columna: ");

                    if (salaCancelar == 1) {
                        sala1.cancelarCompra(filaCancelar, columnaCancelar);
                        sala1.imprimirAsientos();
                    } else if (salaCancelar == 2) {
                        sala2.cancelarCompra(filaCancelar, columnaCancelar);
                        sala2.imprimirAsientos();
                    } else if (salaCancelar == 3) {
                        sala3.cancelarCompra(filaCancelar, columnaCancelar);
                        sala3.imprimirAsientos();
                    } else {
                        sala4.cancelarCompra(filaCancelar, columnaCancelar);
                        sala4.imprimirAsientos();
                    }
                    break;
                // Salir
                case 5:
                    return;
                // Opcion inexistente
                default:
                    System.out.println("Opción desconocida");
                    break;
            }
        }
    }
}