public class DeadlockExample{
    public static void  main (String[] args){
        Printer printer =new Printer ();
        Scanner scanner =new Scanner();

        ThreadA threadA=new ThreadA(scanner, printer);
        ThreadB threadB=new ThreadB(printer,scanner);
        threadB.start();
        threadA.start();

    }
}
