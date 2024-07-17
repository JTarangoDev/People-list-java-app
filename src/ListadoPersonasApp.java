import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class ListadoPersonasApp {
    public static void main(String[] args) {
        Scanner consola = new Scanner(System.in);

        List<Persona> personas = new ArrayList<>();

        boolean salir = false;

        while (!salir){
            mostrarMenu();

            try {
                salir = ejecurarOperacion(consola, personas);
            } catch (Exception e){
                System.out.println("Ha ocurrido un error: " + e.getMessage());
            }

            System.out.println();
        }
    }

    private static void mostrarMenu(){
        System.out.print("""
                **** Listado Peronas App ****
                1. Agregar
                2. Listar
                3. Salir
                """);
        System.out.print("Proporciona la opción: ");
    }

    private static boolean ejecurarOperacion(Scanner consola, List<Persona> personas){
        var opcion = Integer.parseInt(consola.nextLine());

        boolean salir = false;

        switch (opcion){
            case 1 -> { //Agregar persona a la lista
                System.out.println("Proporciona el nombre: ");
                var nombre = consola.nextLine();

                System.out.println("Proporciona el telefono: ");
                var tel = consola.nextLine();

                System.out.println("Proporciona el email: ");
                var email = consola.nextLine();

                //Crear objeto Persona
                var persona = new Persona(nombre, tel, email);

                //lo agregamos a la lista
                personas.add(persona);
                System.out.println("La lista tiene: " + personas.size() + " elementos");
            }
            case 2 -> {
                System.out.println("Listado de Personas: ");

                //personas.forEach((persona) -> System.out.println(persona));
                personas.forEach(System.out::println);
            }

            case 3 -> {
                System.out.println("Hasta la proxima...");
                salir = true;
            }

            default -> System.out.println("Opcion erronea: " + opcion);
        }

        return salir;
    }
}