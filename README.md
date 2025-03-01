# Run-Length Encoding (RLE) Implementation in Java

## Overview
This project implements **Run-Length Encoding (RLE)**, a basic data compression technique that replaces consecutive occurrences of the same character with a single instance of that character followed by its count. It includes:
- **Encoding**: Compressing a string using RLE.
- **Decoding**: Expanding an RLE-compressed string back to its original form.
- **Equality Checking**: Comparing two strings using RLE.

## Features
- Implements a **Single Linked List** for handling character sequences.
- Supports **encoding, decoding, and equality checking**.
- Reads from an input file (`input.txt`) and writes results to `output.txt`.
- Handles cases where decoding may result in variable-length outputs.

## Files in this Repository
- **`Driver.java`** - Main entry point, handles file I/O and calls encoding/decoding methods.
- **`RLE.java`** - Contains core methods for encoding, decoding, and checking equality.
- **`SingleLinkedList.java`** - A custom linked list implementation for handling characters.
- **`input.txt`** - Example input for encoding/decoding tests.
- **`output.txt`** - Output generated after running the program.
- **`Readme.txt`** - Notes on complexity, advantages, and reflections on the implementation.

## How to Run
1. **Compile the Java Files**  
   ```sh
   javac Driver.java RLE.java SingleLinkedList.java
   ```
2. **Run the Program**  
   ```sh
   java Driver
   ```
3. The program will read `input.txt`, process encoding/decoding, and store results in `output.txt`.

## Time Complexity
- **Encoding:** O(n)
- **Decoding:** O(n)
- **Equality Checking:** O(n)

## Advantages & Limitations
✅ **Advantages:**
- Efficient for compressing repetitive data.
- Useful in image compression (e.g., BMP, TIFF formats).

⚠️ **Limitations:**
- Inefficient for non-repetitive data (may increase size instead of reducing it).
- Decoding must be done sequentially to reconstruct the original data.

## Example

### Encoding
**Input:** `"wwwwaaadexxxxxx"`  
**Encoded Output:** `"4w3a1d1e6x"`  
**Compression Ratio:** `1.5`

### Decoding
**Input:** `"3a1b3c3d2a"`  
**Decoded Output:** `"aaabbbcccddaa"`

### Equality Checking
**Input:** `"3a1b" vs. "2a1a1b"`  
**Result:** `false`


