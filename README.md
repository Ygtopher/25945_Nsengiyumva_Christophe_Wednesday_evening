# 25945_Nsengiyumva_Christophe_Wednesday_evening

---

## Java OOP Exceptions and Scenarios Assignment  

### Objective  
This assignment demonstrates practical examples of exception handling in Java while integrating different systems. The goal is to understand how to simulate, trigger, and handle various checked and unchecked exceptions in Java programming across multiple scenarios.

---

## Structure  
The program is implemented in a single Java file and includes:  
1. Methods that simulate and handle different exceptions (both checked and unchecked).  
2. Implementations for the following scenarios:
   - Online Shopping
   - Online Betting
   - Student Attendance List
   - Traffic Fines System

---

## Scenario Descriptions and Features  

### 1. Online Shopping  
The Online Shopping system includes:  
- Adding items to a cart with item ID, name, and price.  
- Handling invalid input scenarios, such as entering negative prices or invalid item names, through exceptions.  
- Simulating stock checks with potential for exceptions like `IllegalArgumentException` for out-of-stock items.  

### 2. Online Betting  
The Online Betting system covers:  
- Placing bets with a specified amount and betting odds.  
- Handling invalid bet amounts, such as negative numbers, using exception handling.  
- Simulating results and catching potential errors, such as dividing by zero during payout calculations.  

### 3. Student Attendance List  
The Student Attendance List system supports:  
- Recording student attendance with student ID and name.  
- Handling duplicate entries and invalid data input through exception handling.  
- Simulating file-based attendance records, including exceptions like `IOException` and `FileNotFoundException`.  

### 4. Traffic Fines System  
The Traffic Fines system includes:  
- Adding traffic fine entries with vehicle registration number, fine amount, and violation type.  
- Handling incorrect data, such as invalid registration numbers or negative fine amounts, with exceptions.  
- Simulating database operations for fine retrievals and potential exceptions like `SQLException`.  

---

## Exception Handling Demonstration  

### Checked Exceptions:  
1. **IOException**:  
   - Simulates an input/output error by attempting to read a non-existent file.  
2. **FileNotFoundException**:  
   - Specifically triggers when trying to open a file that does not exist.  
3. **EOFException**:  
   - Demonstrates reaching the end of a file unexpectedly while reading data.  
4. **SQLException**:  
   - Simulates a database error by querying a non-existent table.  
5. **ClassNotFoundException**:  
   - Demonstrates a scenario where a specified class file is missing at runtime.  

### Unchecked Exceptions:  
6. **ArithmeticException**:  
   - Simulates a division by zero scenario.  
7. **NullPointerException**:  
   - Accesses a null reference to trigger the exception.  
8. **ArrayIndexOutOfBoundsException**:  
   - Accesses an invalid index in an array.  
9. **ClassCastException**:  
   - Demonstrates an invalid type cast operation.  
10. **IllegalArgumentException**:  
    - Triggers by passing an invalid argument to a method.  
11. **NumberFormatException**:  
    - Simulates converting an invalid string to a number.  

---

## How to Run  
1. Copy the Java file into your preferred Java IDE or text editor.  
2. Compile the program using the command:  
   ```
   javac ExceptionHandlingScenarios.java
   ```  
3. Run the program using the command:  
   ```
   java ExceptionHandlingScenarios
   ```  
4. Use the menu to select different operations (e.g., add entries, simulate exceptions, or exit).  

---

## Key Features  
- **Readability**: The program is well-documented with comments explaining each exception scenario and system operation.  
- **Modularity**: Separate methods are used for exception handling and each system for better organization.  
- **Interactive Design**: A menu-driven approach enhances usability for users.  
- **Real-life Simulation**: Exception scenarios mimic realistic situations for effective learning.  

---

## Sample Output  

### Online Shopping:  
- Valid item addition example:  
   ```
   Item added to cart successfully!
   Item ID: 202
   Item Name: Laptop
   Price: $999.99
   ```
- Out-of-stock exception:  
   ```
   IllegalArgumentException caught: Item is out of stock.
   ```

### Online Betting:  
- Valid bet example:  
   ```
   Bet placed successfully! Potential payout: $150.0
   ```
- Invalid bet amount:  
   ```
   IllegalArgumentException caught: Bet amount cannot be negative.
   ```

### Student Attendance List:  
- Adding a student:  
   ```
   Attendance recorded successfully!
   Student ID: 303
   Student Name: John Doe
   ```
- Duplicate entry exception:  
   ```
   IllegalArgumentException caught: Student ID already exists.
   ```

### Traffic Fines System:  
- Fine entry example:  
   ```
   Fine recorded successfully!
   Vehicle Registration: RAB1234
   Fine Amount: $50.0
   Violation: Speeding
   ```
- Invalid fine amount:  
   ```
   IllegalArgumentException caught: Fine amount cannot be negative.
   ```

---

## Conclusion  
This program combines the demonstration of Java exception handling with multiple real-world scenarios, providing practical examples of handling errors gracefully. It equips learners with the skills needed to anticipate and manage exceptions effectively in software applications.

---
Author: NSENGIYUMVA Christophe  
ID: 25945

