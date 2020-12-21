## Login into MySQL database root user
sudo mysql -uroot -proot

## Create a new user with name jeff and password 1234
CREATE USER 'jeff'@'localhost' IDENTIFIED BY '1233';
GRANT ALL PRIVILEGES on *.* to 'jeff'@'localhost';
FLUSH PRIVILEGES;

## Now login to jeff user and run the mysql-db-export.sql script
sudo mysql -ujeff -p1234
