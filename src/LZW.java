import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LZW {
    private static final String currentDir = System.getProperty("user.dir");

    private static String getOutputFileName(File input, boolean decompress) {
        String fileName = input.getName();
        String outputFileName;

        if (fileName.contains(".")) {
            fileName = fileName.substring(0, fileName.lastIndexOf('.'));
        }

        outputFileName = decompress ? fileName + ".txt" : fileName + ".lzw";
        return outputFileName;
    }

    // Compress Method
    public static List<Integer> compress(String text) {
        List<Integer> result = new ArrayList<>();
        int dicSize = 256;

        // Creating Dictionary
        Map<String, Integer> dictionary = new HashMap<>();
        for (int i = 0; i < dicSize; i++) {
            dictionary.put(String.valueOf((char) i), i);
        }
        // System.out.println("Dic: "+ dictionary);

        String foundChars = "";

        for (char sympol : text.toCharArray()) {

            String charsToAdd = foundChars + sympol;

            if (dictionary.containsKey(charsToAdd)) {
                foundChars = charsToAdd;
            } else {
                // add prev char code
                result.add(dictionary.get(foundChars));
                // add the new char to the dic.
                dictionary.put(charsToAdd, dicSize++);
                // point to the next char.
                foundChars = String.valueOf(sympol);
            }
        }
        // add the code for last one
        if (!foundChars.isEmpty()) {
            result.add(dictionary.get(foundChars));
        }

        return result;
    }

    public static String decompress(List<Integer> data) {

        int dicSize = 256;
        Map<Integer, String> dictionary = new HashMap<>();
        for (int i = 0; i < dicSize; i++) {
            dictionary.put(i, String.valueOf(((char) i)));
        }
        int firstChar = data.remove(0).intValue();
        String chars = String.valueOf((char) firstChar);
        StringBuilder result = new StringBuilder(chars);

        for (int code : data) {
            String decoded = "";

            if (dictionary.containsKey(code)) {
                decoded = dictionary.get(code);
            } else {
                decoded = chars + chars.charAt(0);
            }
            result.append(decoded);
            // add the prev + the first char.
            dictionary.put(dicSize++, chars + decoded.charAt(0));
            chars = decoded;
        }

        return result.toString();
    }

    // ========================[ Files ]=================================

    public static void compressFile(String inputFile) throws IOException {
        File input = new File(currentDir, inputFile);
        if (!input.exists()) {
            System.out.println("File not found: " + inputFile);
            return;
        }
        String outputFileName = getOutputFileName(input, false);

        String content = new String(Files.readAllBytes(input.toPath()));
        List<Integer> compressedData = compress(content);

        Writer fileWriter = new FileWriter(outputFileName);
        try (BufferedWriter writer = new BufferedWriter(fileWriter)) {
            for (int code : compressedData) {
                writer.write(code + ", "); // comma-separated
            }
        }
        System.out.println("File compressed successfully to: " + outputFileName);
    }

    // ================================

    public static void decompressFile(String inputFile) throws IOException {
        File input = new File(currentDir, inputFile);
        if (!input.exists()) {
            System.out.println("File not found: " + input.getAbsolutePath());
            return;
        }

        List<Integer> fileContent = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(input))) {
            String line = reader.readLine();
            if (line != null) {
                String[] values = line.split(", "); // Split by comma
                for (String value : values) {
                    if (!value.trim().isEmpty()) {
                        fileContent.add(Integer.parseInt(value.trim())); // Parse each integer
                    }
                }
            }
        }

        // Decompress fileContent
        String decompressedData = decompress(fileContent);

        // Write to a file
        String outputFileName = getOutputFileName(input, true);
        File outputFile = new File(currentDir, outputFileName);
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {
            writer.write(decompressedData);
        }
        System.out.println("File decompressed successfully to: " + outputFile.getAbsolutePath());
    }

}
