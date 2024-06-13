#!/bin/bash

# Install Django if not already installed
pip3 show django || pip3 install django

# Add the directory containing django-admin to PATH
export PATH="$PATH:$(python3 -m site --user-base)/bin"

# Set up backend environment
pip3 install django

# Navigate to the backend directory and initialize a Django project
cd /workspace/messenger-app
django-admin startproject backend

# Set up frontend environment
npx create-react-app frontend

# Set up Android environment (Assuming you have a separate Android project setup)
mkdir android
