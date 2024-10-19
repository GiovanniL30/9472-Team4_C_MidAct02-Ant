# README: Apache Ant Build Commands for Project 9472-Team4_C_MidAct02-Ant

This project uses Apache Ant as a build tool to manage compilation, documentation generation, and execution of Java programs. Below are the available commands you can use with Ant.

## How to Use
To execute any of the above commands, navigate to the project directory in the terminal and run:
```ant
ant <command>
```

## Example
Create doc, jar, compile all classes and run the application:
```ant
ant main
```

## Available Commands

### 1. `clean`
Deletes the build directory and all its contents. Useful for cleaning up before a new build.

### 2. `make`
Creates the necessary build directories (`build`, `build/classes`, and `build/jar`) if they do not already exist.

### 3. `compile-all`
Compiles all Java source files in the `src` directory and places the compiled classes in the `build/classes` directory. This target depends on the `make` target.

### 4. `compile-one`
Compiles a single Java source file specified by user input. Prompts the user for the file path relative to `src/` and the fully qualified main class name. Depends on the `clean` and `make` targets.

### 5. `create-doc`
Generates Javadocs for the specified packages (`AlgoSolving.*`, `Calculators.*`, `Processors.*`) and places them in the `build/doc` directory.

### 6. `create-jar-all`
Creates a JAR file containing all compiled classes from the `build/classes` directory. The JAR file is saved in the `build/jar` directory with the main class defined in the manifest. Depends on the `compile-all` target.

### 7. `create-jar-single`
Creates a JAR file for a single compiled file. This target depends on the `compile-one` target.

### 8. `create-jar-doc`
Creates a JAR file for the generated Javadocs and saves it in the `build/jar` directory. Depends on the `create-doc` and `create-jar-all` targets.

### 9. `run`
Cleans the build directory, compiles all classes, generates documentation, creates JARs, and runs the application. This is the main entry point for executing the project.

### 10. `clean-build`
Cleans the build directory and creates a JAR file for all compiled classes. This is a quick way to refresh the build and create the JAR.

### 11. `main`
The main target that executes a complete build cycle: clean, compile, create JARs, generate docs, and run the application.

### 12. `run-java`
Compiles and runs a specific Java file specified by user input. Prompts the user for the file path and the class name to execute. Depends on the `clean` and `make` targets.

### 13. `run-jar-single`
Runs the JAR file created for a single Java file. This command depends on the `create-jar-single` target.


