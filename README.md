# themyscira

## development
### mysql

- install

```
$ brew install mysql@5.6

```

- run 
```
$ mysql.server start
```
 
- Create a themyscira database

```
$ sudo mysql
mysql> create database themyscira; -- Create the new database
mysql> create user 'springuser'@'localhost' identified by 'ThePassword'; -- Creates the user
mysql> grant all on themyscira.* to 'springuser'@'localhost'; -- Gives all the privileges to the new user on the newly created database
```
