all:
	protoc --java_out=. -I.:/opt/include/ dreps.proto
	javac -cp /opt/var/java/clojure-protobuf.jar Dreps.java
