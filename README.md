Tinvention Training J2EE Examples
=======================

Maven based, starting project skeleton for J2EE 7 platform. 

Tested on Glassfish 4.0 .

You can find
* Parent Maven POM project
* Ear Maven project with
** ejb module 
*** one stateful session EJB ( a simple counter) exposed by Local interface 
*** one Message Driven Bean ( a simple queue listener printing on standard output )
** web module, with servlets to demonstrate the counter EJB and the simple MDB

You need to create a JMS Queue destination with jndi name "jms/test" in Glassfish.




