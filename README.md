# stackmachine
Stack Machine using Polish Postfix notation


# How to run ?

1. Download the file stack-machine-1.0.1.raj and place it a directory..
2 Change the extension from raj to jar. The extension was changed intentionally as Gmail doesn't allow to attch jar files.
Open Command Prompt and goto the download directory.
Use command "java -jar stack-1.0.1.jar" to run the application.
Initial Stack is empty and commands can be started as soon as the application starts.

# Fineprints

The application is developed to take inputs and display results on command line.

The application logs will be created under logs directory in a file called "app-stack.log".

UNDO: From the requirements, it wasn't clear to me that requirement is to handle only undo of last command or any number of undo as the commands given to the machine. Therefore both the implementaions are provided. StackCommandProcessor: This class handles undo of last command only and subsequent undo commands will be ignored. StackCommandAllUndoProcessor: This class handles unlimited undo of all commands given to the stack machine.

In the jar, single undo command class is used.

Following line in class StackMachine.java can be changed CommandProcessor processor = new StackCommandProcessor(); to CommandProcessor processor = new StackCommandAllUndoProcessor();

for using doing unlimited undos.

# How to build?

Application uses Maven as the build tool, so the code can be built using "mvn clean install".

# Improvements

1. Web based UI can be made to interact with the application.
2. Application can be easily transformed to use spring managed dependencies and a spring boot application.
