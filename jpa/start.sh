#!/bin/bash

set -e

if [ "$1" = 'start' ]; then
  exec docker-entrypoint.sh postgres & ./runwork.sh
else exec "$@"
fi


