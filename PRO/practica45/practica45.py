usuarios = []

def cargar_usuarios():
    try:
        with open("usuarios.txt", "r") as archivo:
            for linea in archivo:
                userData = linea.strip().split(", ")
                usuarios.append(userData)
    except IOError:
        print("Error al cargar los usuarios.")

def guardar_usuarios():
    try:
        with open("usuarios.txt", "w") as archivo:
            for usuario in usuarios:
                archivo.write(", ".join(usuario) + "\n")
    except IOError:
        print("Error al guardar los usuarios.")

def agregar_usuario():
    dni = input("Ingrese el DNI del nuevo usuario: ")
    nombre = input("Ingrese el nombre del nuevo usuario: ")
    apellidos = input("Ingrese los apellidos del nuevo usuario: ")
    correo = input("Ingrese el correo electrónico del nuevo usuario: ")
    nuevo_usuario = [dni, nombre, apellidos, correo]
    usuarios.append(nuevo_usuario)
    guardar_usuarios()
    print("Usuario agregado correctamente.")

def eliminar_usuario():
    dni = input("Ingrese el DNI del usuario que desea eliminar: ")
    encontrado = False
    for usuario in usuarios:
        if usuario[0] == dni:
            usuarios.remove(usuario)
            guardar_usuarios()
            print("Usuario eliminado correctamente.")
            encontrado = True
            break
    if not encontrado:
        print("Usuario no encontrado.")

def buscar_usuario():
    dni = input("Ingrese el DNI del usuario que desea buscar: ")
    encontrado = False
    for usuario in usuarios:
        if usuario[0] == dni:
            print("Usuario encontrado:")
            print(", ".join(usuario))
            encontrado = True
            break
    if not encontrado:
        print("Usuario no encontrado.")

def mostrar_menu():
    print("1. Agregar usuario")
    print("2. Eliminar usuario")
    print("3. Buscar usuario")
    print("4. Salir")

def main():
    cargar_usuarios()

    while True:
        mostrar_menu()
        opcion = input("Ingrese el número de la opción que desea realizar: ")

        if opcion == "1":
            agregar_usuario()
        elif opcion == "2":
            eliminar_usuario()
        elif opcion == "3":
            buscar_usuario()
        elif opcion == "4":
            print("Saliendo del programa.")
            break
        else:
            print("Opción no válida. Por favor, ingrese un número válido.")

if __name__ == "__main__":
    main()
