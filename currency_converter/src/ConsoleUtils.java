public class ConsoleUtils {
    public void clearConsole(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
            if (System.getProperty("os.name").contains("Windows")) {
                // Sistema operativo Windows
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                // Sistemas operativos Linux o Mac
                System.out.print("\033[H\033[2J");
                System.out.flush();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void regresiveCount(int seconds) {
        System.out.println("Tiempo restante para visuzalizar información: ");
        for (int i = seconds; i >= 1; i--) {
            System.out.println(i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
