My assumptions
==============

  * There is no information about the parameters which have to be supported by the service (type, sample values etc). 
    Therefore I just treat them as three strings which are later used to query memcached.
    
Building and running
====================

  * Build with gradle `$ ./gradlew distZip`
  * Run from created distribution: 
  
  ```
    $ unzip build/distributions/ex1.zip
    $ cd bin/
    $ ./ex1
  ```