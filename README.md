# stackmachine
Stack Machine using Polish Postfix notation


# How to run ?

1. Download the file stack-machine-1.0.1.jar and place it a directory.
2. Open Command Prompt and goto the download directory.
3. Use command "java -jar stack-machine-1.0.1.jar" to run the application.
4. Initial Stack is empty and commands can be started to be given as soon as the application starts.

# Fineprints

The application is developed to take inputs and display results on command line.

The application logs will be created under logs directory in a file called "app-stack.log".

UNDO: From the requirements, it wasn't clear to me that requirement is to handle only undo of last command or any number of undo as the commands given to the machine. Therefore both the implementaions are provided. 

StackCommandProcessor: This class handles undo of last command only and subsequent consequent undo commands will be ignored. 
e.g.
PUSH 1
PUSH 2
ADD
UNDO
UNDO
POP
UNDO

2nd UNDO will be ignored whereas 1st and 3rd will work.

StackCommandAllUndoProcessor: This class handles unlimited undo of all commands given to the stack machine.
e.g.
PUSH 1
PUSH 2
ADD
UNDO
UNDO
POP
UNDO

ALL UNDO will work in this implementation.

In the jar, single undo command class (StackCommandProcessor) is used.

Following line in class StackMachine.java can be changed CommandProcessor processor = new StackCommandProcessor(); to CommandProcessor processor = new StackCommandAllUndoProcessor();

for using doing unlimited undos.


# How to build?

Application uses Maven as the build tool, so the code can be built using "mvn clean install".

# Improvements

1. Web based UI can be made to interact with the application.
2. Application can be easily transformed to use spring managed dependencies and a spring boot application.
