mysql> CREATE DATABASE qadb;
Query OK, 1 row affected (0.00 sec)

mysql> USE qadb;
Database changed
mysql> CREATE TABLE quiz (
    ->     qno VARCHAR(5) PRIMARY KEY,
    ->     question VARCHAR(200),
    ->     op1 VARCHAR(100),
    ->     op2 VARCHAR(100),
    ->     op3 VARCHAR(100),
    ->     op4 VARCHAR(100),
    ->     ans VARCHAR(100)
    -> );
Query OK, 0 rows affected (0.02 sec)

mysql> INSERT INTO quiz VALUES
    -> ('001','Which keyword is used to inherit a class in Java?','implements','extends','inherit','using','extends');
Query OK, 1 row affected (0.00 sec)

mysql> INSERT INTO quiz VALUES
    -> ('002','Which method is the entry point of a Java program?','start()','main()','run()','init()','main()');
Query OK, 1 row affected (0.00 sec)

mysql> INSERT INTO quiz VALUES
    -> ('003','Which package contains Scanner class?','java.io','java.util','java.lang','java.sql','java.util');
Query OK, 1 row affected (0.00 sec)

mysql> INSERT INTO quiz VALUES
    -> ('004','Which is not a primitive data type?','int','float','String','char','String');
Query OK, 1 row affected (0.00 sec)

mysql> INSERT INTO quiz VALUES
    -> ('005','Which exception occurs when a number is divided by zero?','IOException','NullPointerException','ArithmeticException','ClassNotFoundException','ArithmeticException');
Query OK, 1 row affected (0.01 sec)
