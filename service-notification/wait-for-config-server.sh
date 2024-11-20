#!/bin/sh
echo "SPRING_CONFIG_IMPORT is set to: $SPRING_CONFIG_IMPORT"
echo "Waiting for config-server..."
until curl -s http://config-server:8888/service-user/docker; do
  echo "Config Server is unavailable - retrying..."
  sleep 5
done
echo "Config Server is up - executing entrypoint"
exec "$@"