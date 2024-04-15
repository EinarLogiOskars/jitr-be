DO $$
BEGIN
    -- Attempt to create the user only if it doesn't already exist
    IF NOT EXISTS (SELECT FROM pg_catalog.pg_user WHERE usename = 'myuser') THEN
        CREATE USER myuser WITH PASSWORD 'mypass';
    END IF;
    
    -- Attempt to create the database only if it doesn't already exist
    IF NOT EXISTS (SELECT FROM pg_database WHERE datname = 'mydb') THEN
        CREATE DATABASE mydb;
    END IF;
    EXCEPTION WHEN DUPLICATE_OBJECT THEN
    -- Handle the duplicate case here, for example:
    RAISE NOTICE 'User or database already exists, not creating';
END
$$;
