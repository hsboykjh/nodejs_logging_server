# Get the current running server pid and kill them
pid=$(ps -ax | grep "node" | grep "logging_server.js" | grep -v grep | awk '{ print $1 }')

if [ -z "$pid" ]
then
  echo "Server is not running, no need for shutdown."
else
  echo "Terminating process $pid.."
  sudo kill -TERM $pid
  sleep 10
  if ps $pid >/dev/null
  then
    echo "$pid is still running, killing it now.."
    sudo kill -9 $pid
  else
    echo "Terminated $pid"
  fi
fi
