# 🧵 Parallel Max Finder (OS Project)

This project demonstrates the use of **multithreading in Java** to find the **maximum value** among millions of integers stored across multiple files. It’s a practical example of concurrent programming, file I/O, and performance efficiency in Operating Systems coursework.

---

## 🚀 Overview

The program:

1. **Generates 4 text files**, each containing **1,000,000 random integers** between 1 and 1,000,000,000.
2. Uses **writer threads** (`FileNumWriter`) to write to each file concurrently.
3. Then spawns **reader threads** (`TMax`) to read each file and determine the maximum value inside it.
4. Finally, it **compares the maximum values** from all 4 files and prints the overall maximum with its filename.

---

## 🧱 Project Structure

### `Start.java`
- Entry point of the project.
- Manages thread creation and coordination.
- Displays status messages and the final result.

### `FileNumWriter.java`
- A thread class that creates a file and fills it with 1 million random integers.
- Ensures each file is unique by name and handles overwriting if the file already exists.

### `TMax.java`
- A thread class that scans a file line by line to find the maximum integer.
- Stores and returns the maximum value found in its file.

---

## ⚙️ How It Works

1. Four writer threads start in parallel:
   - `file1.txt`, `file2.txt`, `file3.txt`, `file4.txt`
2. After all files are written, four reader threads begin scanning.
3. Each reader reports the max value found in its file.
4. The main thread compares the four results to determine the final maximum.

---

## 💻 Sample Output

========== OS Project: Parallel Max Finder ==========
Generating files with 1,000,000 random integers each...
File created: file1.txt
File exists: file2.txt -> Overwriting with new numbers
...
All files generated!

========== STEP 2: Finding Maximums in Files ==========
Starting max-finding threads for each file...

Max in file1.txt = 999985432
Max in file2.txt = 999999999
Max in file3.txt = 985234123
Max in file4.txt = 987654321

==================== FINAL RESULT ====================
Maximum value is 999999999 found in file: file2.txt


---

## 📚 Concepts Practiced

- Multithreading with `Thread` class
- File I/O in Java
- Synchronization via `.join()`
- Random number generation
- Performance optimization via parallel execution

---

## 📦 Requirements

- Java 8 or higher
- No external libraries required

---

## 🧪 Run Instructions

Compile all classes:

```bash
javac Start.java FileNumWriter.java TMax.java


