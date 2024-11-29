# In-Memory Key-Value Database

## How to Run the Code
1. **Setup**: Ensure you have Java installed on your system. Use `java -version` to confirm the installation (Java 17+ required).
2. **Compilation**: Compile the Java files by running:
   ```bash
   javac -d bin InMemoryDBImpl.java Main.java
   ```
3. **Execution**: Run the program using:
   ```bash
   java -cp bin Main
   ```
4. **Expected Output**: The program will simulate the described key-value database operations, showcasing `get`, `put`, transaction handling, commit, and rollback functionalities.

---

## Suggested Modifications for Future Use
To enhance this assignment as an "official" coursework:
1. **Clarify Instructions**: Specify whether the `get()` method must return `null` using `Integer` or if an exception/special value is acceptable for non-existent keys.
2. **Extend Functionality**: Add methods like `delete(String key)` to remove keys or `size()` to return the number of stored entries.
3. **Interactive Input**: Incorporate a command-line interface where users can input operations dynamically (e.g., `PUT A 5`, `GET A`, `BEGIN`, `COMMIT`).
4. **Grading Suggestions**: Provide sample test cases and expected outputs to assist graders in evaluating correctness efficiently.
5. **Error Handling**: Emphasize implementing robust error handling to prepare students for real-world scenarios.

These additions would clarify the requirements, extend the scope, and make grading more straightforward for instructors.
