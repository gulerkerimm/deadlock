public class exp {
}

class Printer{

}
class Scanner {

}

class ThreadA extends Thread {
    private Printer printer;
    private Scanner scanner;

    public ThreadA(Scanner scanner, Printer printer) {
        this.scanner = scanner;
        this.printer = printer;
    }

    @Override
    public void run() {

       synchronized (printer) {
           System.out.println("Thread A: Printer'ı kilitledi.");
           try {
               Thread.sleep(100);
           } catch (InterruptedException e) {
               throw new RuntimeException(e);
           }
           System.out.println("Thread A: Scanner'ı bekliyor...");
           synchronized (scanner){
               System.out.println("Thread A: Printer ve Scanner kilitlendi.");

           }
       }
    }
}

class ThreadB extends Thread{
    private Printer printer;
    private Scanner scanner;

    public ThreadB( Printer printer, Scanner scanner) {

        this.printer = printer;
        this.scanner = scanner;
    }

    @Override
    public void run() {
        synchronized (scanner){
            System.out.println("Thread B: Scanner'ı kilitledi.");
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Thread B: Printer'ı bekliyor...");

            synchronized (printer){
                System.out.println("Thread B: Printer ve Scanner kilitlendi.");
            }
        }
    }
}


