import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class ConversionHistory {
    private List<Conversion> history;
    private static final String FILE_PATH = "src\\local_storage\\conversion_history.json";
    private Gson gson = new Gson();

    public ConversionHistory() {
        this.history = new ArrayList<>();
        try {
            loadHistory();
        } catch (Exception e) {
            System.err.println("Error al cargar el historial de conversiones: " + e.getMessage());
        }
    }

    public void addConversion(String fromCurrency, String toCurrency, double amount, double convertedAmount) {
        Conversion conversion = new Conversion(fromCurrency, toCurrency, amount, convertedAmount);
        history.add(conversion);
        saveHistory();
    }

    public void printHistory() {
        System.out.println("----------------------- Historial de Conversiones -----------------------");
        if (history.isEmpty()) {
            System.out.println("No hay conversiones en el historial.");
        } else {
            for (Conversion conversion : history) {
                System.out.println(conversion.getAmount() + " " + conversion.getFromCurrency() + " -> " + conversion.getConvertedAmount() + " " + conversion.getToCurrency());
            }
        }
    }

    private void saveHistory() {
        try (FileWriter writer = new FileWriter(FILE_PATH)) {
            gson.toJson(history, writer);
        } catch (IOException e) {
            System.err.println("Error al guardar el historial de conversiones: " + e.getMessage());
        }
    }

    private void loadHistory() {
        try (FileReader reader = new FileReader(FILE_PATH)) {
            history = gson.fromJson(reader, new TypeToken<List<Conversion>>() {}.getType());
            if (history == null) {
                history = new ArrayList<>();
            }
        } catch (IOException e) {
            System.err.println("Error al cargar el historial de conversiones: " + e.getMessage());
            history = new ArrayList<>();
        }
    }
}

class Conversion {
    private String fromCurrency;
    private String toCurrency;
    private double amount;
    private double convertedAmount;

    public Conversion(String fromCurrency, String toCurrency, double amount, double convertedAmount) {
        this.fromCurrency = fromCurrency;
        this.toCurrency = toCurrency;
        this.amount = amount;
        this.convertedAmount = convertedAmount;
    }

    public String getFromCurrency() {
        return fromCurrency;
    }

    public String getToCurrency() {
        return toCurrency;
    }

    public double getAmount() {
        return amount;
    }

    public double getConvertedAmount() {
        return convertedAmount;
    }
}

