FILES_CLIENT=ChatClient.java
NAME_CLIENT=ChatClient
FILES_SERVER=ChatServer.java
NAME_SERVER=ChatServer

all: chatServer

chatServer:
	javac $(FILES_SERVER)
	java $(NAME_SERVER)

chatClient:
	javac $(FILES_CLIENT)
	java $(NAME_CLIENT)

clean:
	rm -rf *.class