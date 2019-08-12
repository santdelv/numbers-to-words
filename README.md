
### Number to english converter

This is a simple service and rest endpoint to convert numbers to its english word equivalent.

#### Prerequisites

`Maven,
Java 8`

#### How to run this

After downloading the source code execute this from the root

download the repo from https://github.com/santdelv/numbers-to-words.git

then

`cd to where you downloaded the repo`

`mvn clean install`

then execute the following command in a terminal from the root folder of this repo:

`java -jar target/numbers-to-words-1.0-SNAPSHOT.jar`

Now you can open up a browser or your favorite tool to test rest endpoints.
The usage is as follows:

`http://localhost:4567/numbertoword/{someNumber}`

where {someNumber} is the number you want to convert.

The endpoint supports numbers with the following structure:

"numberstring"

"-numberstring"

"- numberstring"

Some concrete examples:
"250000"

"-323985"

"- 128324"

Another option could be using this from the command line using curl, as in the following example:

`curl http://localhost:4567/numbertoword/1233`

#### Running the tests

To run the tests execute

`mvn test`

The project has a coverage tool called jacoco configured, the reports are generated under target/sites/jacoco
