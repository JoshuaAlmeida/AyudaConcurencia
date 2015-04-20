package hipermercado;

public class Contabilidad{
    private double saldo;
    
    public Contabilidad(){
        saldo=0;
    }
    
    public synchronized void añadeSaldo(double nuevoSaldo){
        saldo+=nuevoSaldo;
    }
    
    public synchronized double dameSaldo(){
        return saldo;
    }
    
}