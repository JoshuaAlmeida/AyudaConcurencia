package hipermercado;

public class Main{
    public static void main(String[] args){
        
        Cola cola = new Cola();
        Contabilidad saldo = new Contabilidad();
        for (int i = 1; i <=2000; i++) {
            cola.añadirFinal(new Cliente());
            System.out.println("La cola tiene: " + cola.tamañoMaximo());
        }
        Caja caja1 = new Caja(cola, saldo);
        Caja caja2 = new Caja(cola,saldo);
        Caja caja3 = new Caja(cola,saldo);
        caja1.start();
        caja2.start();
        caja3.start();
        System.out.println("La cola despues tiene : " + cola.tamañoMaximo());
        System.out.println("La contabilidad es de:"+saldo.dameSaldo());
    }
}