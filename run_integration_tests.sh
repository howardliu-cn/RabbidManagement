#!/bin/bash

mvn -Dit.rabbit.hostname="localhost" -Dit.rabbit.port="15672" -Dit.rabbit.username="guest" -Dit.rabbit.password="guest" verify