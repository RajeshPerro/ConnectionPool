# ConnectionPool
BasicDataSource Implementation with MYSQL DATABASE.

For use this code just checnge 
These lines.......
bds.setUrl("jdbc:mysql://localhost:3306/DATABASE_NAME?autoReconnect=true&useSSL=false"); //Here write your DATABASE_NAME 
bds.setUsername("USERNAME"); //your DATABASE USERNAME
bds.setPassword("PASSWORD"); //your DATABASE PASSWORD

And again do the same in.....this line.
java.sql.Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/DATABASE_NAME?autoReconnect=true&useSSL=false","USERNAME","PASSWORD");
