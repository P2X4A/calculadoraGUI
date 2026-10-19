# Calculator with Graphical Interface - calculadoraGUI

## Description

Basic calculator with a **Swing** graphical interface that performs arithmetic operations from buttons on screen. A small, self-contained example of event handling in Swing where the controller receives the button events and keeps the view free of logic.

Academic project developed for the **Java programming** courses - Systems Engineering, Universidad El Bosque.

## Author

- Sergio Alejandro Parra Rivera

## Technologies

- Java 21 (compiled with `maven-compiler-plugin`)
- Swing for the graphical interface
- Maven 3.8+ with `exec-maven-plugin` to run the application
- **MVC** architecture (`controller`, `view`, `util`)

## Requirements

| Requirement | Version | How to check |
| --- | --- | --- |
| JDK | 21 or higher | `javac -version` |
| Maven | 3.8 or higher | `mvn -v` |
| Git | Any recent version | `git --version` |

## Installation

Follow these steps exactly so the application runs on the first try.

### 1. Clone the repository

```bash
git clone https://github.com/P2X4A/calculadoraGUI.git
```

### 2. Enter the project folder

```bash
cd calculadoraGUI
```

> On Windows, if your path contains spaces, always quote it, for example: `cd "C:\Users\Example\Documents\calculadoraGUI"`.

### 3. Verify your environment

```bash
javac -version
mvn -v
```

Expected: JDK 21 (or higher) and Maven 3.8 (or higher). If any command fails, install or update that tool before continuing.

### 4. Compile the project

```bash
mvn clean compile
```

What success looks like:

- The console ends with `BUILD SUCCESS`.
- A `target/classes/` folder is created with the compiled classes.

## Running the application

```bash
mvn exec:java
```

The calculator window opens with a display and the operation buttons.

Troubleshooting:

- `ClassNotFoundException` or missing main class: compile first with `mvn clean compile`.
- `UnsupportedClassVersionError`: your JDK is older than 21; install JDK 21 or higher and check it with `javac -version`.

## Main features

- **Arithmetic operations:** addition, subtraction, multiplication and division from the on-screen buttons.
- **Event handling:** button events are captured by `Controlador`, keeping `VentanaCalculadora` as a pure view.
- **Compact design:** a single window with a display and the keypad, ideal as a starting point for larger Swing applications.

## Project structure

```text
calculadoraGUI/
├── pom.xml
├── README.md
├── LICENSE
└── src/
    └── co/edu/unbosque/
        ├── controller/
        │   ├── AplMain.java               # Entry point (main class)
        │   └── Controlador.java           # Handles button events (MVC)
        ├── util/
        │   └── Constant.java              # Shared constants
        └── view/
            └── VentanaCalculadora.java    # Calculator window (Swing)
```
