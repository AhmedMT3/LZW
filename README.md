
# 📚 LZW Compression and Decompression Program

### Welcome to the LZW Compression Program! 📦🔍

This project is a Java-based application that uses the **LZW (Lempel-Ziv-Welch)** algorithm for compressing and decompressing text data. With it, you can reduce file sizes and work with encoded data directly.

## 🚀 Features

- **Text Compression**: Easily compress a given text string into encoded format.
- **Text Decompression**: Decode compressed data back to its original text.
- **File Compression**: Compress an entire file using LZW to save space.
- **File Decompression**: Restore a compressed file to its original content.

## 🛠️ How to Use

### 1. **Clone the Repository**:

```bash
git clone https://github.com/AhmedMT3/LZW.git
cd LZW
```

### 2. **Compile and Run**:

```bash
javac src/App.java src/LZW.java
java -cp src App
```

### 3. **Select Options in the App**:
After starting, you’ll see a menu with options:

- `1` ➡ Compress a text
- `2` ➡ Decompress a text
- `3` ➡ Compress a file
- `4` ➡ Decompress a file

Simply enter the number for the action you want to perform! 👇

## 📄 Example Usage

**Compress a Text:**
```text
Enter text to Compress:
This is a simple LZW compression test.
```

**Decompress a Text:**
```text
Enter the Encoded Data (Separated by Comma):
65,97,98,99...
```

## 🗂️ Files and Output

- **Text Input/Output**: Compresses and decompresses a text string directly in the console.
- **File Input/Output**: Uses the `Playground` folder in the project directory for all file processing.
  - **Compressed File**: Saves as `.lzw` file in the `Playground` folder.
  - **Decompressed File**: Restores as `.txt` file.

### ⚙️ Classes and Methods

1. **App**: Main class for user interaction and menu-driven options.
2. **LZW**: Handles core compression/decompression logic.

## 📖 About the LZW Algorithm

LZW is a lossless data compression algorithm, ideal for text compression. It works by encoding repeated sequences in data with short codes. You’ll find LZW used in popular formats like **GIF images**!

## 🤖 Future Improvements

- Add support for additional file formats
- Improve error handling for invalid inputs
- Enhance compression efficiency

## 📜 License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

---

Happy Compressing and Decompressing! 🎉
