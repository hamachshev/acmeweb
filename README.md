# acmeweb
Sample web server for MCO152 class exercises on IoC, DIP, DI

This sample shows how to leverage the Spring framework, for simulating a production control server that reports on 
and manages other manufacturing servers, machinery and processes at the Acme Disk Drive company.

**--> What the web server does** once the Spring server has been started:

It accepts HTTP GET requests such as:
    http://localhost:8080/server/status

and will respond to recognized requests with a JSON representation of a response that corresponds to the ServerStatus java class.

A simple request like:
    http://localhost:8080/server/status

Will respond with:

`---- [source, json]
{"id":3,"contentHeader":"Server Status requested by Anonymous","statusDesc":"Server is up"}
----`

You can customize the greeting with an optional `name` parameter in the query string:

http://localhost:8080/server/status?name=Moishe

The `name` parameter value overrides the default value of “Anonymous” and is reflected in the response:

`---- [source, json]
{"id":2,"contentHeader":"Server Status requested by Moishe","statusDesc":"Server is up"}
----`

You can also request custom details about the server by sending a GET request to /server/status/detailed and passing in a
comma separated list of details. For example:

http://localhost:8080/server/status/detailed?name=Yankel&details=availableProcessors,freeJVMMemory,totalJVMMemory,jreVersion,tempLocation

will respond (albeit with different values reflecting your server):

`{"id":8,"contentHeader":"Server Status requested by Yankel","requestCost":72,"statusDesc":"Server is up, and there are 4 processors available, and there are 127268272 bytes of JVM memory free, and there is a total of 159383552 bytes of JVM memory, and the JRE version is 15.0.2+7-27, and the server's temp file location is M:\\AppData\\Local\\Temp"}`

Invalid detail requests will be responded to with a 404 error and a message saying `Invalid details option:` and will provide
the invalid detail.

Details need not be unique and can be repeated. For example:
Sending a GET request such as:

http://localhost:8080/server/status/detailed?name=Yankel&details=availableProcessors,availableProcessors

Will be responded to with something like:

`{"id":12,"contentHeader":"Server Status requested by Yankel","requestCost":7,"statusDesc":"Server is up, and there are 4 processors available, and there are 4 processors available"}`

Each detail request will also be responded to with a total request cost; that is the 
total of all the requests costs associated with the individual detail requests.

For example, in the example above, when a GET request is sent to

http://localhost:8080/server/status/detailed?name=Yankel&details=availableProcessors,availableProcessors

The server will respond with a `{..."requestCost":7}` because the base request cost is one, and each deatil request of
available processors is an additional 3, brining the total to 1 + 3 + 3 = 7.




**--> Syntax for URLS:**
*    All start with /server
*    /status  will give back status of server
*    an optional param of 'name' specifies a requestor name to appear in response
*    a request to /status/detailed must contain a details param
*    details options are availableProcessors, freeJVMMemory, totalJVMMemory, jreVersion, tempLocation
*    you may provide multiple details, as well as repeated details

**--> What you'll need**

* Java_version: JDK 17 or higher
* Gradle: version 7.5 or higher
* Spring Boot Framework, but you don’t have to install this - it will be pulled in by your first “build”, as Spring is listed as a dependency in the build.gradle file - this will take some time, e.g. 15 minutes,
And it will pull in about 500MB of libraries/jars.
  
**--> Building/Starting the web server**

The gradle build task will pull in all spring dependencies, and the java and gradle Spring plug-in will make the following Gradle tasks of interest available to you (usable from command line or from within IntelliJ):
**build** - Full build of project

**test** - this will run the Test class(es) found in the src/test portion of project 

**bootRun** - this will start up the server, at which point it is waiting for requests as described above.

If the server has started properly you should see a number of logging statements, ending with something like this:

`2019-11-04 15:46:11.678 INFO 16793 --- [ main] o.s.b.w.embedded.tomcat.TomcatWebServer : Tomcat started on port(s): 8080 (http) with context path ''`

`2019-11-04 15:46:11.681 INFO 16793 --- [ main] statusmgr.Application : Started Application in 1.86 seconds (JVM running for 2.475)`

You can then make requests via a browser or curl following the above URL syntax.

