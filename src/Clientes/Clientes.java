
package Clientes;


public class Clientes {
   private String Rut;
   private String Nombre;
   private String Apellido_Paterno;
   private String Apellido_Materno;
   private String Domicilio;
   private String Comuna;
   private String Telefono;



    public Clientes(String Rut, String Nombre, String Apellido_Paterno, String Apellido_Materno, String Domicilio, String Comuna, String Telefono) {
        validarRut(Rut);
        validarNombre(Nombre);
        validarApellido(Apellido_Paterno);
        validarApellido(Apellido_Materno);
        validarDomicilio(Domicilio);
        validarComuna(Comuna);
        validarTelefono(Telefono);
        
        this.Rut = Rut;
        this.Nombre = Nombre;
        this.Apellido_Paterno = Apellido_Paterno;
        this.Apellido_Materno = Apellido_Materno;
        this.Domicilio = Domicilio;
        this.Comuna = Comuna;
        this.Telefono = Telefono;
        
    }
    public static boolean validarRut(String Rut) {                                    //validador del RUT
         return Rut.matches("\\d{1,2}\\.\\d{3}\\.\\d{3}-[\\dkK]");
    }
       public String getRut() {
        return Rut;
    }
    public void setRut(String Rut) {
       if (validarRut(Rut)) {
       this.Rut = Rut;
       } else {
       throw new IllegalArgumentException("RUT inválido");
        }
    }
    
    
   public static boolean validarNombre(String nombre) {
    return !nombre.isEmpty();
}
   
    public String getNombre() {
        return Nombre;
    }
    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public static boolean validarApellido(String Apellido) {
        return !Apellido.isEmpty();
    }
    public String getApellido_Paterno() {
        return Apellido_Paterno;
    }

    public void setApellido_Paterno(String Apellido_Paterno) {
        this.Apellido_Paterno = Apellido_Paterno;
    }

    public String getApellido_Materno() {
        return Apellido_Materno;
    }

    public void setApellido_Materno(String Apellido_Materno) {
        this.Apellido_Materno = Apellido_Materno;
    }

    
    public static boolean validarDomicilio(String Domicilio) {
       return !Domicilio.isEmpty();
    }
    public String getDomicilio() {
        return Domicilio;
    }

    public void setDomicilio(String Domicilio) {
        this.Domicilio = Domicilio;
    }

     public static boolean validarComuna(String Comuna) {
        return !Comuna.isEmpty();
    }
    public String getComuna() {
        return Comuna;
    }

    public void setComuna(String Comuna) {
        this.Comuna = Comuna;
    }
    
    public static boolean validarTelefono(String telefono) {
    return telefono.matches("\\+\\d{11}");
}
    public String getTelefono() {
        return Telefono;
    }

    public void setTelefono(String Telefono) {
        this.Telefono = Telefono;
    }
    @Override
    public String toString() {
        return "Clientes{" +
                "rut=" + Rut +
                ", nombre='" + Nombre + '\'' +
                ", apellidoPaterno='" + Apellido_Paterno + '\'' +
                ", apellidoMaterno='" + Apellido_Materno + '\'' +
                ", domicilio='" + Domicilio + '\'' +
                ", comuna='" + Comuna + '\'' +
                ", telefono=" + Telefono +
                '}';
    }
}
