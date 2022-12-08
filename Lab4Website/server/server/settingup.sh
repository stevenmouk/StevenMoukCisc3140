#!/bin/bash

# Checking to see if you have psql installed: If not then install it
which psql;

if [ $? -ne 0 ]
then
    sudo apt-get install postgresql;
fi

# Checking to see if we have nodejs installed
which node;

if [ $? -ne 0 ]
then
    sudo apt-get install nodejs;
fi

# This will check to see what expressjs version you have
which npm;

if [ $? -ne 0 ]
then
    npm install -g express
fi

# Starting the local server for local hosting
check = $(curl -s -w "%{http_code}\n" -L "${HOST}${PORT}/" -o /dev/null)
if [[ $check == 200 || $check == 400 ]]
then
    # Service is online
    echo "Service is online"
    exit 0
else
    # Service is offline or not working correctly
    echo "Service is offline or not working correctly"
    exit 1
fi