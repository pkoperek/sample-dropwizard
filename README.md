Building and running
====================

  * Build with gradle `$ ./gradlew distZip`
  * Remember about starting memcached first and making the connection configuration matching in `default.yml` config file!
  * Run from created distribution: 
  
  ```
    $ unzip build/distributions/ex1.zip
    $ cd ex1/bin/
    $ ./ex1 server default.yml
  ```
  
  * Webservice is available at `http://localhost:8080/paper`
