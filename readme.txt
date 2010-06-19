<h1>Maven</h1>
compile: 4s
test: 10s
install: 2m41s
gae:deploy 7min 9sec


Versions

Nevada

persistence setup --provider DATANUCLEUS --database GOOGLE_APP_ENGINE --applicationId nevadademo
mvn gwt:deploy
persistence setup --provider DATANUCLEUS --database HYPERSONIC_IN_MEMORY

http://127.0.0.1:8888/ApplicationScaffold.html?gwt.codesvr=127.0.0.1:9997
http://127.0.0.1:8888/ApplicationScaffold.html
http://nevadademo.appspot.com/



Utdraget

persistence setup --provider DATANUCLEUS --database GOOGLE_APP_ENGINE --applicationId utdraget
mvn gwt:deploy
persistence setup --provider DATANUCLEUS --database HYPERSONIC_IN_MEMORY

http://127.0.0.1:8888/ApplicationScaffold.html?gwt.codesvr=127.0.0.1:9997
http://127.0.0.1:8888/ApplicationScaffold.html
http://utdraget.appspot.com/


Quick setup
persistence setup --provider DATANUCLEUS --database HYPERSONIC_IN_MEMORY
entity --class ~.server.domain.Employee --testAutomatically
field string --fieldName userName --sizeMin 3 --sizeMax 30
field string --fieldName department
gwt setup
