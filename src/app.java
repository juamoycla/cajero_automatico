import java.util.Scanner;

public class app {
    public static void main(String[] args) {
        Scanner sc =  new Scanner(System.in);
        double saldo = 1000;
        double cantidad = 1;
        int opcion;

        do {
            mostrarMenu();
            opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    consultarSaldo(saldo);
                    System.out.println();
                    break;
                case 2:
                    System.out.println("Introduce el importe que desea ingresar: ");
                    cantidad = sc.nextDouble();
                    saldo = ingresarDinero(saldo, cantidad);
                    System.out.println();
                    break;
                case 3:
                    System.out.println("Introduce el importe que desea retirar: ");
                    cantidad = sc.nextDouble();
                    saldo = retirarDinero(saldo, cantidad);
                    System.out.println();
                    break;
                case 4:
                    while(cantidad != 0) {
                        cantidad = sc.nextDouble();
                        saldo = retirarDinero(saldo, cantidad);
                        if (saldo == 0) { cantidad = 0; }
                    }
                    cantidad = 1;
                    break;
                case 0:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opcion incorrecta. Vuelva a intentarlo.");
            }

        }while (opcion != 0);

    }

    public static void mostrarMenu() {
        System.out.println("===== CAJERO AUTOMÁTICO =====");
        System.out.println("1) Consultar saldo");
        System.out.println("2) Ingresar dinero");
        System.out.println("3) Retirar dinero");
        System.out.println("4) Simular varios retiros");
        System.out.println("0) Salir");
        System.out.println();
    }

    public static void consultarSaldo(double saldo) { System.out.println("Tienes " + saldo + "€"); }

    public static double ingresarDinero(double saldo, double cantidad) {
        if (cantidad < 0) {
            System.out.println("Cantidad inválida");
        } else { saldo += cantidad; }
        return saldo;
    }

    public static double retirarDinero(double saldo, double cantidad) {
        if (saldo < cantidad) {
            System.out.println("Saldo insuficiente");
        } else if (cantidad < 0) {
            System.out.println("Cantidad inválida");
        } else { saldo -= cantidad;}
        return saldo;
    }

}


/* BUGS:
1- Al ingresar, si se introducia num negativo restava dinero (+ x - = -).
2- Al retirar, si se introducia num negativo ingresava dinero (- x - = +).
3- Metodo reciclado retirarDinero para usarlo en las retiradas recursivas (4).
4- Al retirar sin parar (4) si por ejemplo retiramos 2 veces 200 y ponemos 0, si entramos de nuevo
en la misma opcion no deja entrar y se sale porque cantidad vale 0, si entramos en otra
opcion si se puede porque modificamos cantidad, la culpa el while.
 */