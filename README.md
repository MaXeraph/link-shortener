# link-shortener
- Abusing free resources to shorten links - now with Java
- Works on port 8080

## Endpoints:
- [shorten](http://localhost:8080/shorten?url=maxpham.dev)
- [expand](http://localhost:8080/shorten?surl=000000)

## Design:
- Retrieve link, Hash link, grab 6 char, HashTable.put, return surl
- Retrieve surl, HashTable.get, redirect with link.

## Resources
[RESTful for Java](https://spring.io/guides/gs/rest-service/)

## Stack
Java Spring RESTful Heroku Mongo/postgreSQL

## Goal
- Learn Java SpringBoot + Java technicalities in preperation for Uken Games (PEY)
- Maybe learn how to deploy on AWS 

## Due
April 1st 2020
