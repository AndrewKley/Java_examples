FILES=Threads.java
NAME=Threads

all: threads

threads:
	javac -d ./classes $(FILES)
	# cd ./classes
	# jar -cvmf manifest.txt App.jar *.class
	# java -jar App.jar

errorThread:
	javac ErrorThread.java
	java ErrorThread

clean:
	rm -rf *.class