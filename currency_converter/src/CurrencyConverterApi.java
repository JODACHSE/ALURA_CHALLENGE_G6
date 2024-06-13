import java.util.Scanner;

public class CurrencyConverterApi {
    private static ExchangeRateService exchangeRateService = new ExchangeRateService();
    private static CurrencyMenu currencyMenu = new CurrencyMenu();
    private static CurrencyConverter currencyConverter = new CurrencyConverter();
    private static ConversionHistory conversionHistory = new ConversionHistory();
    private static ConsoleUtils consoleUtils = new ConsoleUtils();
    private static Scanner scanner = new Scanner(System.in);

    // INGRESE AQUI EL API KEY DE EXCHANGERATE-API
    // (https://exchangerate-api.com/)
    static String apiKey = "";

    public static void main(String[] args) {

        while (apiKey.isEmpty()) {
            System.out.println("No se ha proporcionado una clave de API.\nPor favor, proporcione una clave de API.");
            apiKey = scanner.nextLine();
        }

        while (true) {
            consoleUtils.clearConsole(0);
            currencyMenu.showPrincipalMenu();
            int option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1:
                    performConversion(apiKey);
                    break;
                case 2:
                    conversionHistory.printHistory();
                    consoleUtils.regresiveCount(8);
                    consoleUtils.clearConsole(0);
                    break;
                case 3:
                    currencyMenu.thanksAndBye();
                    consoleUtils.clearConsole(3);
                    break;
                default:
                    System.out.println("Opcion no valida, intente de nuevo...");
                    consoleUtils.clearConsole(1);
                    break;
            }
            consoleUtils.clearConsole(1);
        }
    }

    private static void performConversion(String apiKey) {
        currencyMenu.showCurrencies();

        System.out.println("Digite el acrónimo o abreviatura de la divisa a consultar.");
        String fromCurrency = scanner.nextLine().toUpperCase();
        if (fromCurrency.isEmpty()) {
            fromCurrency = "USD";
        }

        System.out.println("Digite el acrónimo o abreviatura de la divisa a convertir.");
        String toCurrency = scanner.nextLine().toUpperCase();

        System.out.println("Digite el monto a convertir.");
        double amount = scanner.nextDouble();
        scanner.nextLine();

        try {
            // Retorna la tasa de cambio(rate) de la divisa de origen (fromCurrency) a la
            // divisa de destino (toCurrency)
            double rate = exchangeRateService.getExchangeRate(apiKey, fromCurrency, toCurrency);
            double convertedAmount = currencyConverter.convert(amount, rate);

            System.out.println(amount + " " + fromCurrency + " es igual a " + convertedAmount + " " + toCurrency);
            conversionHistory.addConversion(fromCurrency, toCurrency, amount, convertedAmount);
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }

        consoleUtils.regresiveCount(5);
        consoleUtils.clearConsole(0);
    }
}
