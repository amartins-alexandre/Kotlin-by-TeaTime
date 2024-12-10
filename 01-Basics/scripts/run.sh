#! /bin/bash

# Include the base script
source "$(dirname "$0")/base.sh"

# Path to the source folder
kotlin_dirname="$project_root/src/main/kotlin"

# Get the name of the file without the extension from user input
echo "Enter the name of the Kotlin file (without the extension): "
read -r file_name

# Path to the build file
jar_file="$generated_dir/$file_name.jar"

# Exclude HelloWord.jar files from the build folder after compiling if it exists
if [ -f "$jar_file" ]; then
  echo "Removing the existing build file..."
  rm "$jar_file" || { echo "Error: Failed to remove the existing build file."; exit 1; }
fi

# Compile the source files
kotlinc "$kotlin_dirname/$file_name.kt" -include-runtime -d "$jar_file"

# Set the permission to execute the build file
chmod +x "$jar_file"

# Check if the build file exists
if [ -f "$jar_file" ]; then
  echo "Build successful!"
  echo "Running the build file..."
  echo
  java -jar "$jar_file"
  exit 0
else
  echo "Error: Build failed."
  exit 1
fi
