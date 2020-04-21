SET PATH="C:\Program Files\BlueJ\jdk\bin";%PATH%

javadoc -d progdoc -author -version -private -linksource pkg_* *.java
javadoc -d userdoc -author -version pkg_* *.java