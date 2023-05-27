FILES_SERVER=DailyAdviceServer.java
NAME_SERVER=DailyAdviceServer
FILES_CLIENT=Client.java
NAME_CLIENT=Client

all: DailyAdviceServer Client

DailyAdviceServer:
	javac $(FILES_SERVER)
	java $(NAME_SERVER)

Client:
	javac $(FILES_CLIENT)
	java $(NAME_CLIENT)

clean:
	rm -rf *.class