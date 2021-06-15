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
  echo "Running service MiniHelidon on web port 8087, debug port 10087"
  echo "  Server log file is ${logFile}"
  "$JAVA_HOME/bin/java" -jar -agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=10087 build/libs/demo_jpa-1.0-SNAPSHOT.jar >> $logFile 2>&1 &
fi
echo $!
#gives PID
exit $status