package hipermercado;

    public class Caja extends Thread{
    private Cola colaClientes;
    private Contabilidad saldo;
    private static int idUnico=-1;

    public Caja(Cola colaClientes, Contabilidad saldo) {
        this.colaClientes = colaClientes;
        this.saldo = saldo;
        idUnico++;
    }
    
    @Override
    public void run(){
        Cliente cliente = colaClientes.sacar();
        try {
            while(cliente!=null){
                Thread.sleep((long)(cliente.damePrecioCarro()/10000));
                saldo.añadeSaldo(cliente.damePrecioCarro());
                Cliente cliente_aux =colaClientes.sacar();
                System.out.println(cliente.toString());
                cliente=cliente_aux;
            }
        } catch (InterruptedException ex) {
            colaClientes.añadirPrincipio(cliente);
        }
        colaClientes.cerrar();
        System.out.println("Cerrada");
        if(cliente!=null){
            colaClientes.añadirPrincipio(cliente);
        }
    }
}