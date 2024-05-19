
package Cuentas;
import java.util.Random;
import Clientes.Clientes;

public class Cuentas {
    private int Numero;
    private int Saldo;
    private Clientes cliente;
    
    public Cuentas(int Numero, int Saldo) {
        this.Numero = Numero;
        this.Saldo = Saldo;
    }
    
    public Cuentas() {
    }

    public int getNumero() {
        return Numero;
    }

    public void setNumero(int Numero) {
        this.Numero = Numero;
    }

    public int getSaldo() {
        return Saldo;
    }

    public void setSaldo(int Saldo) {
        this.Saldo = Saldo;
    }

    public void generarNumeroCuenta() {
        Random rand = new Random();
        this.Numero = rand.nextInt(900000000) + 100000000; 
        this.Numero = Numero;
    }
public void setCliente(Clientes cliente) {
        this.cliente = cliente;
    }

    public Clientes getCliente() {
        return cliente;
    }
    

  
    
}
