
# 📦 LZW Compression Program

A Java app to compress and decompress text and files using the **LZW (Lempel-Ziv-Welch)** algorithm.

## 🚀 Features

- **Text Compression & Decompression**: Compress text or decompress encoded data.
- **File Compression & Decompression**: Compress files to save space, decompress to restore content.

## 🛠️ Usage

1. **Clone and Run**:
   ```bash
   git clone https://github.com/yourusername/LZW-Compression
   cd LZW-Compression
   javac src/App.java src/LZW.java
   java -cp src App
   ```

2. **Choose an Option**:
   - `1` ➡ Compress text
   - `2` ➡ Decompress text
   - `3` ➡ Compress file
   - `4` ➡ Decompress file

3. **Input Text or File Path**:
   - For text, type the string to compress or paste encoded data.
   - For files, place them in the `Playground` folder.

## 📂 Folder Structure

```plaintext
LZW-Compression/
├── .vscode/           # VSCode configuration files
├── bin/               # Compiled classes output (if used)
├── lib/               # Libraries
├── Playground/        # Folder for input/output files
├── src/               # Source code folder
│   ├── App.java       # Main interface
│   └── LZW.java       # Compression/decompression logic
├── .gitattributes     # Git configuration
├── .gitignore         # Git ignore file
└── README.md          # Project guide
```

## 📖 About LZW

LZW is a lossless algorithm, compressing repeated data patterns. It's commonly used in formats like **GIF images**.
<br>
Learn more about it [here](https://en.wikipedia.org/wiki/Lempel%E2%80%93Ziv%E2%80%93Welch).

---

Happy compressing and decompressing! 🎉
