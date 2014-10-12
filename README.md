My assumptions
==============

  * There is no information about the parameters which have to be supported by the service (type, sample values etc). 
    Therefore I just treat them as three strings which are later used to query memcached.
  * Dropwizard will complain about not having any health checks created for the application. If this would be 
    implemented as a production service - such functionality should be covered. However because this is just an 
    excercise - I omitted that topic.
    
Building and running
====================

  * Build with gradle `$ ./gradlew distZip`
  * Run from created distribution: 
  
  ```
    $ unzip build/distributions/ex1.zip
    $ cd ex1/bin/
    $ ./ex1 server
  ```