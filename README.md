> **Note: Language Context**
>
> Please note that this project was written in **German** as part of my `Ausbildung` (German vocational training). Therefore, all variable names, comments, and package names are in German.

---

# Javamon Battle v2 (File I/O & Stream API)

## About This Project

This is the **second and advanced version** of my `Javamon` console RPG.

While `v1` was a complete game, its data (all Pokémon and attacks) was hardcoded inside the Java classes. This `v2` is a **complete refactor of the data layer**, moving all game data to external `.csv` files.

This project now demonstrates not only advanced OOP, but also robust File I/O and modern Java `Stream API` usage.

## Key Improvements & New Features (v1 vs. v2)

### 1. External `.csv` Data Management
All game data is now stored in three `.csv` files (e.g., `pokemon.csv`, `attacks.csv`), making the project scalable and easy to modify without changing the Java code.

### 2. New `DataManager` Class
A new `DataManager` class is responsible for all file reading. This class features **two distinct methods** for reading and parsing the CSV data:
* **Classic `BufferedReader`:** A robust, traditional method for reading files line-by-line.
* **Modern `Stream API` (`Files.lines`):** A functional, modern Java 8+ approach for processing the file as a stream.
*(This demonstrates versatility in solving the same problem with different technical approaches.)*

### 3. Refactored `Repository` Layer
The `JavamonRepository` and `PokAttackeRepository` classes no longer contain hardcoded data. They are now "clients" of the `DataManager`, which injects the data into them at runtime.

### 4. All `v1` Features Still Included
This version retains all the advanced features from `v1`:
* Clean, multi-layered OOP architecture (UI, Logic, Data).
* Dynamic ASCII Art and console animations.
* Colored health bars and UI (`ConsoleColors`).
* Sound effects (`SoundManager`).

## Project Evolution (v1 -> v2)

* **v1 (The Original):** A complete, feature-rich OOP game, but all data was static and hardcoded, making it difficult to maintain.
* **v2 (This Version):** Replaced the static data with a dynamic `DataManager` that reads from `.csv` files. This makes the game truly data-driven.

## Future Improvements (v3 Plan)

The next logical step would be to replace the CSV `DataManager` with a `DatabaseManager` that connects to an **SQL database** (like MySQL or PostgreSQL) using **JDBC** or **Spring Data JPA**.

**You can find the original v1 project here: https://github.com/furbgg/Java-Pokemon-Clone-Console
