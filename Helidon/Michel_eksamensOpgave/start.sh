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
  echo "Running service ConsultantTemplate on web port 8099, debug port 10099"
  echo "  Server log file is ${logFile}"
  "$JAVA_HOME/bin/java" -jar -agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=10099 build/libs/EksamensOpgave-1.0-SNAPSHOT.jar >> $logFile 2>&1 &
fi
echo $!
#gives PID
exit $status