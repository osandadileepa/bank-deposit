#!/bin/bash

echo '\033[31m-------------------------------';
echo '-------------------------------';
echo '\33[1;33m Building Back end';
echo '\033[31m-------------------------------';
echo '\33[1;34m-------------------------------';
rm -rf ../resources/static
mkdir ../resources/static
cp -a ./dist/webapp/* ../resources/static

cd ../../../

./mvnw clean install -DskipTests

