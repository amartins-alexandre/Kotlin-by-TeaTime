#!/bin/bash

# Absolute path to the current directory
current_dir=$(pwd)

# Absolute path to the directory containing the script
script_dir=$(dirname "$(realpath "$0")")

# Absolute path to the project root directory
project_root=$(dirname "$script_dir")

# Absolute path to the build folder
build_dir="$project_root/build"
generated_dir="$build_dir/generated"

# Check if current directory is the scripts directory
if [ "$script_dir" != "$current_dir" ]; then
  echo "Changing to the scripts directory..."
  cd "$script_dir" || { echo "Error: Failed to change directory."; exit 1; }
fi

# Create the build directory if it does not exist
if [ ! -d "$build_dir" ]; then
  echo "Creating the build directory..."
  mkdir -p "$build_dir" || { echo "Error: Failed to create the build directory."; exit 1; }

  # Check if the generated directory exists
  if [ ! -d "$generated_dir" ]; then
    echo "Creating the generated directory..."
    mkdir -p "$generated_dir" || { echo "Error: Failed to create the generated directory."; exit 1; }
  fi
fi
