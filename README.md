Tinvention Training J2EE Examples
=======================

Maven based, starting project skeleton for J2EE 7 platform. 

Tested on Glassfish 4.0 

You can find: a parent Maven POM project and an Ear Maven project.

Ear Maven project have an ejb module and a web module.

ejb module contains:
* one stateful session EJB ( a simple counter) exposed by a Local interface 
* one singleton session EJB ( a simple counter) exposed by a Local interface 
* one stateless session EJB ( a simple message producer) without interfaces 
* one stateless session EJB ( a simple echo service ) exposed by a Remote interface
* one Message Driven Bean ( a simple queue listener printing on standard output )

web module contains:
* three servlets, only to demonstrate the counter EJB and the simple MDB works

ws module contains:
* an example of JAX-WS service

ws-client module contains:
* an example of JAX-WS client, using client classes create by maven import plugin

rs module contains:
* an example of JAX-RS service

rs-client module contains:
* an example of JAX-RS client, working only for XML based service format

You need to create a JMS Queue destination with jndi name "jms/test" in Glassfish ( destination Physical name es. jms_test ).
In order to run unit tests, you have to set the GLASSFISH_HOME environment variable ( ...glassfish4\glassfish ).

URLS 
* http://localhost:8080/web/mdbProduce -> create random message, put in queue, mdb read and sysout
* http://localhost:8080/web/counter -> show counters state
* http://localhost:8080/web/counter?inc=true or ?dec=true -> it increments/decrements counters, and show its states
