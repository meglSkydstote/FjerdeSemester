#!/bin/bash

logFile="${1}"; shift # required input argument

# Detach process properly by reading /dev/null as input
# - see more here: https://stackoverflow.com/questions/19955260/what-is-dev-null-in-bash
#echo $@
#echo $?
#echo $!
./gradlew build < /dev/null
#./gradlew build $@ < /dev/null
status=$?

if [[ $status == '0' ]]; then
  echo "Running service TestHelidon on web port 8096, debug port 10096"
  echo "  Server log file is ${logFile}"
  echo "===================================" >> $logFile
  "$JAVA_HOME/bin/java" -jar -agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=10095 build/libs/MicroQuizService-1.0-SNAPSHOT.jar >> $logFile 2>&1 &
fi
echo $!
echo "-----------------------------------------" >> $logFile
echo "PID $!" >> $logFile
echo "-----------------------------------------" >> $logFile
#gives PID
exit $status