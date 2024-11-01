import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("===[ Welcom to LZW Program ]===");

        boolean condition = true;
        Scanner scanner = new Scanner(System.in);
        while (condition) {
            System.out.println("Chose what you wanna do:");
            System.out.println("1 => Compress a text");
            System.out.println("2 => Decompress a text");
            System.out.println("3 => Compress a file");
            System.out.println("4 => Decompress a file");
            int choice = scanner.nextInt();
            scanner.nextLine();
            if (choice == 1) {
                System.out.println("Enter text to Compress");
                String text = scanner.nextLine();

                List<Integer> output = LZW.compress(text);

                System.out.println("Compressed text: ");
                System.out.println(output);
                condition = false;

            } else if (choice == 2) {
                System.out.println("Enter the Encoded Data (Seperate by Comma): ");
                String input = scanner.nextLine();
                String[] arrInput = input.split(", ");

                List<Integer> data = new ArrayList<>();
                // Parsing.
                for (String str : arrInput) {
                    data.add(Integer.parseInt(str.trim()));
                }

                String output = LZW.decompress(data);

                System.out.println("DeCompressed data: ");
                System.out.println(output);
                condition = false;

            } else if (choice == 3) {
                try {
                    System.out.println("Enter the path for the input file:");
                    String inputFile = scanner.nextLine();
                    System.out.println("Enter the path for the output compressed file:");
                    String compressedFile = scanner.nextLine();

                    // Compress the file
                    LZW.compressFile(inputFile, compressedFile);

                } catch (IOException e) {
                    e.printStackTrace();
                }


            } else if (choice == 4) {
                try {
                    System.out.println("Enter the path for the compressed file:");
                    String compressedFile = scanner.nextLine();
                    System.out.println("Enter the path for the output decompressed file:");
                    String decompressedFile = scanner.nextLine();

                    // Decompress the file
                    LZW.decompressFile(compressedFile, decompressedFile);
                    System.out.println("File decompressed successfully!");

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        scanner.close();

    }
}
