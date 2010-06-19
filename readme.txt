Maven
compile: 4s
test: 10s
install: 2m41s
gae:deploy 7min9sec

Nevada
C:\nevada\nevada
persistence setup --provider DATANUCLEUS --database GOOGLE_APP_ENGINE --applicationId nevadademo
mvn gwt:deploy
persistence setup --provider DATANUCLEUS --database HYPERSONIC_IN_MEMORY
http://127.0.0.1:8888/ApplicationScaffold.html?gwt.codesvr=127.0.0.1:9997
http://127.0.0.1:8888/ApplicationScaffold.html
http://nevadademo.appspot.com/

Utdraget
C:\nevada\utdraget
persistence setup --provider DATANUCLEUS --database GOOGLE_APP_ENGINE --applicationId utdraget
mvn gwt:deploy
persistence setup --provider DATANUCLEUS --database HYPERSONIC_IN_MEMORY
http://127.0.0.1:8888/ApplicationScaffold.html?gwt.codesvr=127.0.0.1:9997
http://127.0.0.1:8888/ApplicationScaffold.html
http://utdraget.appspot.com/

----------------------------------------------------------------------------------------------------------------------------------------

SpringSource Tool Suite with Google Integration

Bringing Rapid Spring to the Cloud

Google and VMware are delighted to introduce SpringSource's new STS 2.3.3 and Spring Roo 1.1.0.M1 releases. These technologies deliver new levels of productivity in building Spring applications with next-generation technologies like Google Web Toolkit (GWT) and Google App Engine (GAE). In our latest STS 2.3.3 you'll find everything you need to get started, including:

    * Spring Roo 1.1.0.M1, which is the latest Roo release and features extensive GWT and GAE integration that was delivered in close collaboration with engineers at Google
    * Google Plugin for Eclipse (GPE), carefully optimised to ensure complete compatibility with GWT applications produced by Roo and easy GAE deployment
    * Data Nucleus (DN) Plugin for Eclipse, which will give you the easiest way of persisting data in the GAE cloud and ensuring rapid round-tripping of code changes

After downloading and installing STS 2.3.3, use the "Extensions" tab to install GPE and DN. Then get started in seconds by clicking File > New > Roo Project

Quick setup
persistence setup --provider DATANUCLEUS --database HYPERSONIC_IN_MEMORY
entity --class ~.server.domain.Employee --testAutomatically
field string --fieldName userName --sizeMin 3 --sizeMax 30
field string --fieldName department
gwt setup
