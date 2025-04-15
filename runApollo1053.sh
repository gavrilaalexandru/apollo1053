#!/bin/bash

GREEN='\033[0;32m'
RED='\033[0;31m'
NC='\033[0m'
JAVA_FILES=$(find . -name "*.java")

echo -e "${GREEN}Starting Mission Control for Apollo1053...${NC}"
echo -e "${GREEN}Compiling Java files...${NC}"
javac $JAVA_FILES

if [ $? -eq 0 ]; then
    echo -e "${GREEN}Compilation successful!${NC}"
    echo -e "${GREEN}Launching Apollo1053...${NC}"

    java -cp src csie.ase.ro.main.Main

    if [ $? -eq 0 ]; then
        echo -e "${GREEN}Launch successful!${NC}"
    else
        echo -e "${RED}Launch failed!${NC}"
        exit 1
    fi
else
   echo -e "${RED}Compilation failed!${NC}" 
   exit 1
fi
