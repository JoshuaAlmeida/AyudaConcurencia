package hipermercado;
import java.util.*;

public class Cola {
    private ArrayList<Cliente> colaClientes;
    private Boolean colaDisponible;
    private int valor;
    public Cola(){
        colaClientes=new ArrayList<>();
        colaDisponible=true;
        valor=0;
    }
    
    public synchronized void añadirPrincipio(Cliente nuevo){
        colaClientes.add(0, nuevo);
        notifyAll();
    }
    
    public synchronized void añadirFinal(Cliente nuevo){
        if(colaDisponible){
            colaClientes.add(nuevo);
        }
        notifyAll();
    }
    
    public synchronized Cliente sacar(){
        long actual=System.currentTimeMillis();
        if(colaDisponible && colaClientes.isEmpty())return null;
        if(colaDisponible)return colaClientes.remove(0);
        try {
            if(!colaClientes.isEmpty()){
                colaClientes.remove(0);
            }
            wait(10000);
            if(System.currentTimeMillis()-actual<10000)return colaClientes.remove(0);
        } catch (InterruptedException ex) {return null;}
        return null;
    }
     public void cerrar(){
         colaDisponible=false;
     }
     
    public int tamañoMaximo(){    
        if(valor<colaClientes.size()&& colaDisponible){
            valor=colaClientes.size();
        }
        return valor;
    }
}