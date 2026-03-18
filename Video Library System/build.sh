#!/bin/bash

# Compile Java files
javac *.java

# Check compilation status
# https://stackoverflow.com/questions/28893341/compile-and-run-program-if-there-are-no-errors-using-linux-shell-script
if [ $? -ne 0 ]; then 
    echo "Compilation failed."
    exit 1
fi

# Run the program
java Main
