
# LZW Compression and Decompression Program

A Java application implementing the **LZW (Lempel-Ziv-Welch)** algorithm to compress and decompress text and files. This program provides an interactive CLI for compressing or decompressing user-inputted text or files.

## Features

- **Text Compression/Decompression**: Compress or decompress user-inputted text.
- **File Compression/Decompression**: Compress or decompress files in the working directory.
- **LZW Algorithm**: Implements the dictionary-based LZW compression algorithm.

## Requirements

- Java JDK 8 or higher

## Usage

### Running the Program

1. Clone this repository.
   ```bash
   git clone https://github.com/ahmedmt3/LZW.git
   cd LZW
   ```

2. Compile the program:
   ```bash
   javac App.java LZW.java
   ```

3. Run the program:
   ```bash
   java App
   ```

### Options

Upon starting the program, you will see the following options:

1. **Compress a text**: Compress a string entered by the user.
2. **Decompress a text**: Decompress a string of comma-separated encoded integers entered by the user.
3. **Compress a file**: Compress a text file by providing its filename.
4. **Decompress a file**: Decompress a previously compressed `.lzw` file by providing its filename.

## LZW Algorithm Overview

The **LZW** (Lempel-Ziv-Welch) algorithm is a dictionary-based compression algorithm that:
1. Builds a dictionary of frequently encountered sequences in the input.
2. Maps these sequences to shorter codes.
3. Efficiently decompresses data by re-mapping codes back to original sequences.

### Compression Logic
- Initializes a dictionary with ASCII characters.
- Scans the input for sequences that are already in the dictionary, adding new sequences as needed.
  
### Decompression Logic
- Initializes a dictionary with ASCII codes.
- Reverses the compression by using codes to retrieve the original sequences.

## File Compression/Decompression

- Files are compressed to `.lzw` files, where each compressed sequence is stored as a comma-separated integer.
- Decompressed `.txt` files are generated from `.lzw` files by reconstructing the original text.

## Example

1. **Compressing a Text File**
    - Place your file in the project directory (e.g., `example.txt`).
    - Select the `3` option in the program and provide the filename `example.txt`.
    - The program will generate a compressed file `example.lzw` in the current directory.

2. **Decompressing a File**
    - Provide the filename of a previously compressed file (e.g., `example.lzw`).
    - The program will generate a decompressed file `example.txt` in the current directory.

## Sample Code Snippets

### Compressing a File
```java
LZW.compressFile("example.txt");
```

### Decompressing a File
```java
LZW.decompressFile("example.lzw");
```

## Notes

- Ensure files are located in the working directory.
- Only text files are supported for compression.

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.
