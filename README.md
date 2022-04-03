# GymRats

## Setup and Execution
- make sure SQL is running on your laptop
- ensure MySQLWorkbench is running and add some data to the database
    - if you have not created the database run the SQL file (found in ./SQL/) in MySQLWorkbench
- double check that mysql-connector is in "Referenced Libraries"
-  there are **three variables** which you will need to check are right 
    - **connectionURL**: idk what jdbc:mysql is (java-db-connector?), but its basically localhost/path_to_db
    - **dbUsername**: your username (most likely "root") which you used to set up SQL
    - **dbPassword**: your password for the user you created when setting up MYSQLWorkbench (I think)
 
## Purpose
I created this repo to get some practice with accessing the database. This also taught me how to view specific user attributes and how to take user input and create a request.

## Issues
There is a lot of repeated code and wih the way the database is set up, I have to execute a search query to check for identical usernames rather than a username being automatically checked and verified. 

## Solutions
**Repeated Code**
- There could be one function (say execute(String command, String/int flag)) which executes the statement and then calls helper functions based on the flag given. This works because each method only prints information at the moment. This would not work for an API because APIs return data after the query. This data is later used by whoever sent the request and is based upon the request (POST, PUT, GET, DELETE, etc.). 
- *NOTE*: I made an attempt to clean the code earlier by having each method call an execute method and have either a PreparedStatement or ResultSet returned but this caused SQL exceptions.

**Database Setup**
- After looking at the SQL code I believe I can change the setup. It currently creates an attribute and then sets it to unique. Instead, I could create the attribute as a unique attribute. 
- I have reached out to the professor for additional help and will post the solution if they can help or I mine works.
