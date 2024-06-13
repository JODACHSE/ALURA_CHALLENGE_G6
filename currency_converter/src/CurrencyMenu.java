public class CurrencyMenu {
    private static ConsoleUtils consoleUtils = new ConsoleUtils();

    public void showPrincipalMenu() {
        String principalMenu = "------------------------ CONVERSOR DE DIVISAS ------------------------\n" +
                "=  1. Convertir divisas                                              =\n" +
                "=  2. Consultar historial de divisas                                 =\n" +
                "=  3. Salir                                                          =\n" +
                "----------------------------------------------------------------------\n";
        System.out.println(principalMenu);
    }

    public void showCurrencies() {
        String currencies = "----------------- EJEMPLOS DE ABREVIATURAS DE DIVISAS ----------------\n" +
                "=  USD --- Dólar Estadounidense (por defecto)                        =\n" +
                "=  EUR --- Euro                                                      =\n" +
                "=  COP --- Peso Colombiano                                           =\n" +
                "=  ARS --- Peso Argentino                                            =\n" +
                "=  BRL --- Real Brasileño                                            =\n" +
                "----------------------------------------------------------------------\n";
        System.out.println(currencies);
    }

    public void thanksAndBye() {
        System.out.println(
                "Gracias por haber usado este programa. ¡Hasta pronto!\nElaborado por JODACHSE con ayuda de OpenAI y BLackBox.");
        consoleUtils.clearConsole(2);
        System.exit(0);
    }
}
