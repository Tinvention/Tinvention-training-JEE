Tinvention Training J2EE Examples
=======================

Maven based, starting project skeleton for J2EE 7 platform. 

Tested on Glassfish 4.0 .

You can find: a parent Maven POM project and an Ear Maven project.

Ear Maven project have an ejb module and a web module.

ejb module contains:
 
* one stateful session EJB ( a simple counter) exposed by Local interface 
* one Message Driven Bean ( a simple queue listener printing on standard output )

web module contains:
* two servlets, only to demonstrate the counter EJB and the simple MDB


You need to create a JMS Queue destination with jndi name "jms/test" in Glassfish.




