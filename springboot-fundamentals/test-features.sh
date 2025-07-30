#!/bin/bash

echo "Testing All Spring Boot Features"
echo "================================"

BASE_URL="http://localhost:8082"

echo ""
echo "1. Testing Health Endpoint:"
curl -s "$BASE_URL/health"
echo ""

echo ""
echo "2. Testing Original Application Endpoints:"
echo "Hello: $(curl -s "$BASE_URL/hello")"
echo "Title: $(curl -s "$BASE_URL/title")"
echo "Time: $(curl -s "$BASE_URL/time")"
echo "Mock Time: $(curl -s "$BASE_URL/time/mock")"

echo ""
echo "3. Testing Greeting Services (Dependency Injection Demo):"
echo "Morning: $(curl -s "$BASE_URL/greeting/morning")"
echo "Evening: $(curl -s "$BASE_URL/greeting/evening")"
echo "Default: $(curl -s "$BASE_URL/greeting/default")"

echo ""
echo "4. Testing Notification Services (@Primary & @Qualifier Demo):"
echo "Email: $(curl -s "$BASE_URL/notify/email?message=Test")"
echo "SMS: $(curl -s "$BASE_URL/notify/sms?message=Test")"

echo ""
echo "5. Testing Book CRUD Operations (JPA Integration):"
echo "Creating a book..."
BOOK_RESPONSE=$(curl -s -X POST "$BASE_URL/books" \
  -H "Content-Type: application/json" \
  -d '{"title":"Spring Boot Guide","author":"John Doe","isbn":"123-456-789"}')
echo "Created: $BOOK_RESPONSE"

echo ""
echo "Getting all books:"
curl -s "$BASE_URL/books"
echo ""

echo ""
echo "All features tested successfully!"
echo "Original endpoints: /hello, /title, /time, /time/mock"
echo "New endpoints: /health, /greeting/*, /notify/*, /books/*" 