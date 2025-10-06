package autoNameGenearator;

import java.io.*;
import java.text.DecimalFormat;

public class WorkOrderGenerator {
    private static final String BASE_NAME = "Smart Work Order_";
    private static final String FILE_PATH = "form_counter.txt"; 
    private static final DecimalFormat format = new DecimalFormat("000");

    public static String geNexttWorkOrderName() {
        int lastNumber = readLastUsedNumber();
        int nextNumber = lastNumber + 1;

        saveNumberToFile(nextNumber); 

        return BASE_NAME + format.format(nextNumber); 
    }

    private static int readLastUsedNumber() {
        File file = new File(FILE_PATH);

        if (!file.exists()) {
            return 0; 
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line = reader.readLine();
            if (line != null) {
                return Integer.parseInt(line.trim());
            }
        } catch (IOException | NumberFormatException e) {
            e.printStackTrace();
        }

        return 0; 
    }

    private static void saveNumberToFile(int number) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH))) {
            writer.write(String.valueOf(number));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
