# SalesTracker

A simple Java console application for tracking product sales and revenue. This beginner-friendly project uses core Java concepts and does not require a database or external libraries.

## Features

- Add a sale with product name, quantity, and unit price
- View all recorded sales
- Calculate total items sold and total revenue
- Search sales by product name
- Basic input validation

## Requirements

- Java JDK 17 or later

## Run the application

1. Download and extract the ZIP file.
2. Open Terminal or Command Prompt inside the `SalesTracker` folder.
3. Compile the Java files:

   ```bash
   javac -d out src/*.java
   ```

4. Run the application:

   ```bash
   java -cp out Main
   ```

## Example

```text
================================
       SALES TRACKER
================================

--- MENU ---
1. Add a sale
2. View all sales
3. View revenue summary
4. Search sales by product
5. Exit
```

## Java concepts used

- Classes and objects
- Variables and data types
- Constructors and methods
- Encapsulation with private fields and getters
- `ArrayList`
- Loops and conditional statements
- `Scanner` for user input
- Exception handling
- Basic calculations

## Project structure

```text
SalesTracker/
├── src/
│   ├── Main.java
│   └── Sale.java
├── .gitignore
└── README.md
```

## Notes

Sales are kept in memory while the program is running. They are cleared when you exit the application. This is an intentionally simple project for Java practice.
