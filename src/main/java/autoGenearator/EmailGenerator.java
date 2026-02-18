package autoGenearator;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DecimalFormat;

public class EmailGenerator {
    private static final String EMAIL_NAME = "SmartEntry_";
    private static final String FILE_PATH = "email_counter.txt"; 
    private static final DecimalFormat format = new DecimalFormat("000");

    public static String getNextEmail() {
        int lastNumber = readLastUsedEmail();
        int nextNumber = lastNumber + 1;

        saveNumberToFile(nextNumber); 

        return EMAIL_NAME + format.format(nextNumber) + "@yopmail.com"; 
    }

    private static int readLastUsedEmail() {
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
