#!/bin/bash

while [ "1" = "1" ]; do
    psql -U jpa -f work.sql
    echo "lock"
    sleep 1
done