import re

def buscar_por_dni(dni_pattern):
    input_dni = input("Introduce el DNI a buscar: ").strip()
    if re.match(dni_pattern, input_dni):
        try:
            with open("usuarios.txt", "r") as file:
                for line in file:
                    if line.startswith(input_dni):
                        print("DNI encontrado:", line.strip())
                        return
                print("DNI no encontrado.")
        except FileNotFoundError:
            print("Archivo de usuarios no encontrado.")
        except IOError:
            print("Error al leer el archivo.")
    else:
        print("DNI inválido. Introduce un DNI válido.")

def ver_todos_los_dni():
    try:
        with open("usuarios.txt", "r") as file:
            print("Todos los DNI:")
            for line in file:
                print(line.strip())
    except FileNotFoundError:
        print("Archivo de usuarios no encontrado.")
    except IOError:
        print("Error al leer el archivo.")

def main():
    dni_pattern = r'\d{8}[A-HJ-NP-TV-Za-hj-np-tv-z]'

    while True:
        print("\nElija una opción:")
        print("\n1. Buscar por DNI")
        print("2. Ver todos los DNI")
        print("3. Salir")
        opcion = input()
        
        if opcion == "1":
            buscar_por_dni(dni_pattern)
        elif opcion == "2":
            ver_todos_los_dni()
        elif opcion == "3":
            print("Saliendo del programa.")
            break
        else:
            print("Opción inválida. Inténtalo de nuevo.")

if __name__ == "__main__":
    main()
