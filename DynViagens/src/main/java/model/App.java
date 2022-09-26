package model;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("!");

        Cliente cliente = new Cliente();
        Cliente cliente2 = new Cliente();
        cliente.setNome("Dayane");

        String nome = cliente.getNome();
       System.out.println(nome);
        
    }
}
