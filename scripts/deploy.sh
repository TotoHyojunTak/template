#!/bin/bash
PROJECT_NAME=template #Study-AWS
CURRENT_PID=$(pgrep -f $PROJECT_NAME)

if [ -z $CURRENT_PID ]; then
  echo "> not running app."
else
  echo "> kill -9 $CURRENT_PID"
  kill -9 $CURRENT_PID sleep 3
fi

echo "> deploy new app"

cd /home/ec2-user/deploy
JAR_NAME=$(ls | grep $PROJECT_NAME | tail -n 1)

nohup java -jar $JAR_NAME 1>nohup/stdout.txt 2>nohup/stdder.txt &
sleep 2