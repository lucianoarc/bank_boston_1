
package bank_boston_1;

import java.util.Scanner;
import Clientes.Clientes;
import Cuentas.Cuentas;
import java.util.ArrayList;

public class Bank_Boston_1 {
    static ArrayList<Clientes> Clienteslist = new ArrayList<>();
    static ArrayList<Cuentas> Cuentaslist = new ArrayList<>();
    
    
    public static void Menu(){
    Scanner Teclado=new Scanner(System.in);
    int opciones=0;
        do{
            System.out.println("1.- Registro del cliente");
            System.out.println("2.- Ver datos del cliente");
            System.out.println("3.- Depositar");
            System.out.println("4.- Girar");
            System.out.println("5.- Consultar saldo");
            System.out.println("6.- Salir");
            opciones=Teclado.nextInt();
            switch (opciones){
            case 1:
                Registro_Del_Cliente(Teclado);
                break;
            case 2:
                Ver_Datos_Del_Cliente(Teclado);
                break;
            case 3:
                Depositar(Teclado);
                break;
            case 4:
                Girar(Teclado);
                break;
            case 5:
                Consulta_Saldo(Teclado);
                break;
            case 6:
                System.out.println("!! Hasta luego que tengas un buen dia !!");
                break;
            default:
                System.out.println("Opcion invalida");
                System.out.println("");
                break;
            }
        } while(opciones<1||opciones>6);
        
        }

public static void Registro_Del_Cliente(Scanner Teclado){
boolean registrado = false;
do{    
        String Rut;
        String Nombre;
        String Apellido_paterno;
        String Apellido_materno;
        String Domicilio;
        String Comuna;
        String Telefono;
    
do {
    System.out.println("Ingrese su RUT (EJ: 12.345.678-9)");
    Rut= Teclado.next();
    Teclado.nextLine();

    if (!Clientes.validarRut(Rut)) {
        System.out.println("El RUT ingresado es invalido. Por favor, ingrese un RUT valido.");
        System.out.println("");
    }
} while (!Clientes.validarRut(Rut));

    boolean nombreValido = false;
    do {
    System.out.println("Ingrese su Nombre");
    Nombre = Teclado.nextLine();
    nombreValido = Clientes.validarNombre(Nombre);
    if (!nombreValido) {
        System.out.println("El nombre no puede estar vacio. Por favor, intentelo de nuevo.");
        System.out.println("");
    }
    } while (!nombreValido);

    boolean apellidoValido = false;

    do {
    System.out.println("Ingrese su Apellido paterno");
    Apellido_paterno = Teclado.nextLine();
    apellidoValido = Clientes.validarApellido(Apellido_paterno);
    if (!apellidoValido) {
        System.out.println("El apellido no puede estar vacio. Por favor, intentelo de nuevo.");
        System.out.println("");
    }
} while (!apellidoValido);

    do {
    System.out.println("Ingrese su Apellido materno");
    Apellido_materno = Teclado.nextLine();
    apellidoValido = Clientes.validarApellido(Apellido_materno);
    if (!apellidoValido) {
        System.out.println("El apellido no puede estar vacio. Por favor, intentelo de nuevo.");
        System.out.println("");
    }
} while (!apellidoValido);
    
boolean domicilioValido = false;
do {
    System.out.println("Ingrese su Domicilio (Calle/Numero)");
    Domicilio = Teclado.nextLine();
    domicilioValido = Clientes.validarDomicilio(Domicilio);
    if (!domicilioValido) {
        System.out.println("El domicilio no puede estar vacio. Por favor, intentelo de nuevo.");
        System.out.println("");
    }
} while (!domicilioValido);

boolean ComunaValido = false;
do {
    System.out.println("Ingrese su Comuna");
    Comuna = Teclado.nextLine();
    ComunaValido = Clientes.validarComuna(Comuna);
    if (!ComunaValido) {
        System.out.println("La comuna no puede estar vacio. Por favor, intentelo de nuevo.");
        System.out.println("");
    }
} while (!ComunaValido);

boolean telefonoValido = false;
do {
    System.out.println("Ingrese su telefono (EJ: +56912345678)");
    Telefono = Teclado.nextLine();
    telefonoValido = Clientes.validarTelefono(Telefono);
    if (!telefonoValido) {
        System.out.println("El numero de telefono ingresado es invalido. Por favor, intentelo de nuevo.");
        System.out.println("");
    }
} while (!telefonoValido);

  

    
    Clientes clienteNuevo = new Clientes(Rut, Nombre, Apellido_paterno, Apellido_materno, Domicilio, Comuna, Telefono);
    Clienteslist.add(clienteNuevo);
    Cuentas cuentaNueva = new Cuentas(); 
    cuentaNueva.generarNumeroCuenta(); 
    cuentaNueva.setSaldo(0);                                                //saldo inicial= 0
    Cuentaslist.add(cuentaNueva);
    System.out.println("Numero de cuenta: " + cuentaNueva.getNumero());
    
  System.out.println("Cliente registrado exitosamente");
                registrado = true;
  
    } while (!registrado);
    
    System.out.println("");
    Menu();
}

public static void Ver_Datos_Del_Cliente(Scanner Teclado){
    System.out.println("Ingrese el RUT del cliente:");
    String rutBusqueda = Teclado.next();
    boolean encontrado = false;

    for (int i = 0; i < Clienteslist.size(); i++) {
        Clientes cliente = Clienteslist.get(i);
        if (cliente.getRut().equals(rutBusqueda)) {
            encontrado = true;
            System.out.println("Datos del cliente:");
            System.out.println("RUT: " + cliente.getRut());
            System.out.println("Nombre: " + cliente.getNombre());
            System.out.println("Apellido Paterno: " + cliente.getApellido_Paterno());
            System.out.println("Apellido Materno: " + cliente.getApellido_Materno());
            System.out.println("Domicilio: " + cliente.getDomicilio());
            System.out.println("Comuna: " + cliente.getComuna());
            System.out.println("Telefono: " + cliente.getTelefono());
           if (!Cuentaslist.isEmpty()) {
            Cuentas cuenta = Cuentaslist.get(Cuentaslist.size() - 1);
            System.out.println("Numero de Cuenta: " + cuenta.getNumero());
            System.out.println("Saldo: " + cuenta.getSaldo());
           }
            break;
        }
    }

    if (!encontrado) {
        System.out.println("Cliente no encontrado.");
    }

    System.out.println("");
    Menu(); 

    
    
}
 public static void Consulta_Saldo(Scanner Teclado){
    System.out.println("Ingrese el RUT del cliente:");
    String rutBusqueda = Teclado.next();
    boolean encontrado = false;

        for (int i = 0; i < Clienteslist.size(); i++) {
        Clientes cliente = Clienteslist.get(i);
        if (cliente.getRut().equals(rutBusqueda)) {
        encontrado = true;   
        if (!Cuentaslist.isEmpty()) {
        Cuentas cuenta = Cuentaslist.get(Cuentaslist.size() - 1);
        System.out.println("Saldo: " + cuenta.getSaldo()+" Pesos");
                                                    }
        }
        break;
        }
        if (!encontrado) {
        System.out.println("Cliente no encontrado.");
        }
        System.out.println("");
    Menu(); 
        }
 
 public static void Depositar(Scanner Teclado) {
        System.out.println("Ingrese el RUT del cliente:");
        String rutBusqueda = Teclado.next();
        boolean encontrado = false;

        for (int i = 0; i < Clienteslist.size(); i++) {
            Clientes cliente = Clienteslist.get(i);
            if (cliente.getRut().equals(rutBusqueda)) {
                encontrado = true;
                int monto = 0;
                do {
                    System.out.println("Ingrese el monto a depositar:");
                    monto = Teclado.nextInt();
                    
                    if (monto <= 0) {
                        System.out.println("El monto debe ser mayor a 0. Por favor, intentelo de nuevo.");
                    }
                } while (monto <= 0);
                
                Cuentas cuenta = Cuentaslist.get(i);
                cuenta.setSaldo(cuenta.getSaldo() + monto);
                System.out.println("Deposito exitoso. Nuevo saldo: " + cuenta.getSaldo() + " Pesos");
                System.out.println("");
                break;
            }
        }
        
        if (!encontrado) {
            System.out.println("Cliente no encontrado.");
        }

        System.out.println("");
        Menu();
    }
 
        public static void Girar(Scanner Teclado) {
        System.out.println("Ingrese el RUT del cliente:");
        String rutBusqueda = Teclado.next();
        boolean encontrado = false;

        for (int i = 0; i < Clienteslist.size(); i++) {
            Clientes cliente = Clienteslist.get(i);
            if (cliente.getRut().equals(rutBusqueda)) {
                encontrado = true;
                int monto = 0;
                Cuentas cuenta = Cuentaslist.get(i);
                do {
                    System.out.println("Ingrese el monto a girar:");
                    monto = Teclado.nextInt();
                    
                    if (monto <= 0) {
                        System.out.println("El monto debe ser mayor a 0. Por favor, intentelo de nuevo.");
                    } else if (monto > cuenta.getSaldo()) {
                        System.out.println("El monto no puede ser mayor que el saldo disponible (" + cuenta.getSaldo() + " Pesos). Por favor, intentelo de nuevo.");
                        
                    }
                    
                } while (monto <= 0 || monto > cuenta.getSaldo());

                cuenta.setSaldo(cuenta.getSaldo() - monto);
                System.out.println("Giro exitoso. Nuevo saldo: " + cuenta.getSaldo() + " Pesos");
                break;
            }
        }

        if (!encontrado) {
            System.out.println("Cliente no encontrado.");
        }

        System.out.println("");
            Menu();
    }

 
    public static void main(String[] args) {
        System.out.println("Bienvenido a Bank Boston");
        System.out.println("");
        Menu();
    }
    
}
