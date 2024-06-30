CREATE TABLE users (
    id SERIAL PRIMARY KEY,
    username VARCHAR(100) NOT NULL
);
CREATE TABLE profiles (
    id SERIAL PRIMARY KEY,
    email VARCHAR(100) NOT NULL,
    user_id INT REFERENCES users (id) UNIQUE
);

