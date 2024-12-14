#!/bin/bash

echo "Starting all services..."

docker-compose -f ../docker/docker-compose.yml up --build -d

echo "Waiting for containers to initialize..."
sleep 20

echo "All services are running. Use 'docker ps' to check status."
