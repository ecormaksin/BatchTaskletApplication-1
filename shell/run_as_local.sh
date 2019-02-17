#!/bin/sh
cd `dirname $0`
java -jar ./TaskletTest.jar --spring.profiles.active=default,local

