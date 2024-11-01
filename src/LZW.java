import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LZW {
    private static final String currentDir = System.getProperty("user.dir");

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

    // ===========
    public static void compressFile(String inputFile, String outputFile) throws IOException {
        File input = new File(currentDir, inputFile);
        if (!input.exists()) {
            System.out.println("File not found: " + inputFile);
            return;
        }

        String content = new String(java.nio.file.Files.readAllBytes(input.toPath()));
        List<Integer> compressedData = compress(content);

        try (DataOutputStream out = new DataOutputStream(new FileOutputStream(outputFile))) {
            for (int code : compressedData) {
                out.writeInt(code);
            }
        }
        System.out.println("File compressed successfully to: " + outputFile);
    }

    //================================

    public static void decompressFile(String inputFile, String outputFile) throws IOException {
        File input = new File(System.getProperty("user.dir"), inputFile); // Use current directory for relative path
        if (!input.exists()) {
            System.out.println("File not found: " + input.getAbsolutePath());
            return;
        }

        List<Integer> compressedData = new ArrayList<>();
        try (DataInputStream in = new DataInputStream(new FileInputStream(input))) {
            // Reading integers from the compressed file
            while (in.available() > 0) {
                compressedData.add(in.read());// getting error in this line
            }
        }

        // Decompress the list of integers
        String decompressedData = decompress(compressedData);
        
        // Write decompressed data to output file
        File output = new File(currentDir, outputFile); 
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(output))) {
            writer.write(decompressedData);
        }
        System.out.println("File decompressed successfully to: " + output.getAbsolutePath());
    }

}
