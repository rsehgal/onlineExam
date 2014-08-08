How to create tables from dump file

1) Create database with name "dbRaman"
   
2) Create a mysql user raman with password ramansehgal
   create user 'raman'@'31.10.1.80' identified by 'ramansehgal'
   #Change the corresponding ipaddress of mysql server

   grant all privileges on dbRaman.* to 'raman'@'%' identified by 'ramansehgal'

3) connect to dbRaman

4) source <dumpFileName>.sql
   This will create the two tables user and mcqBackup.


Ask the users to install the setup and then
first create the appropriate user

and then run the required Online exam app.

5) For Web, copy the MySql folder on the Web server directory.


