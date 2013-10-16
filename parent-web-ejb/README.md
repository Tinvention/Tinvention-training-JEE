Tinvention Training J2EE Examples
=======================

Maven based, starting project skeleton for J2EE 7 platform. 

Tested on Glassfish 4.0 

You can find: a parent Maven POM project and an Ear Maven project.

Ear Maven project have an ejb module and a web module.

ejb module contains:
 
* one stateful session EJB ( a simple counter) exposed by Local interface 
* one singleton session EJB ( a simple counter) exposed by Local interface 
* one stateless session EJB ( a simple message producer) without interfaces 
* one Message Driven Bean ( a simple queue listener printing on standard output )

web module contains:
* tree servlets, only to demonstrate the counter EJB and the simple MDB works

You need to create a JMS Queue destination with jndi name "jms/test" in Glassfish ( destination Physical name es. jms_test ).

URLS 
* http://localhost:8080/web/mdbProduce -> create random message, put in queue, mdb read and sysout
* http://localhost:8080/web/counter -> show counters state
* http://localhost:8080/web/counter?inc=true or ?dec=true -> it increments/decrements counters, and show its states
