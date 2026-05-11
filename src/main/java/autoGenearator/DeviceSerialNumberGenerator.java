package autoGenearator;

import java.io.*;
import java.text.DecimalFormat;

public class DeviceSerialNumberGenerator {

    private static final String BASE_SERIAL = "EFL24A156";  
    private static final String FILE_PATH = "serial_counter.txt";
    private static final DecimalFormat FORMAT = new DecimalFormat("000");

    public static String getNextSerialNumber() {

        int lastNumber = readLastUsedNumber();
        int nextNumber = lastNumber + 1;

        saveNumberToFile(nextNumber);

        return BASE_SERIAL + FORMAT.format(nextNumber);
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
        } catch (Exception e) {
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
