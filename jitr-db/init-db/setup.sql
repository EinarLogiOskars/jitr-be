-- Create the initial database and role if they don't exist.
CREATE USER myuser WITH PASSWORD 'mypass';
CREATE DATABASE mydb;
GRANT ALL PRIVILEGES ON DATABASE mydb TO myuser;
