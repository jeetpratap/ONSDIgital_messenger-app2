FROM gitpod/workspace-full

# Install Java
RUN sudo apt-get update && sudo apt-get install -y openjdk-11-jdk

# Install Python
RUN sudo apt-get install -y python3 python3-pip

# Install Node.js and React
RUN curl -fsSL https://deb.nodesource.com/setup_16.x | sudo -E bash -
RUN sudo apt-get install -y nodejs
RUN npm install -g create-react-app
