-- Database Schema for Restaurant/Theater Application

-- Users table
--CREATE TABLE "users" (
--    "ID" INTEGER PRIMARY KEY GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
--    "USERNAME" VARCHAR(50) NOT NULL UNIQUE,
--    "PASSWORD" VARCHAR(255) NOT NULL,
--    "FIRST" VARCHAR(50) NOT NULL,
--    "LAST" VARCHAR(50) NOT NULL,
--    "PHONE" VARCHAR(20),
--    "EMAIL" VARCHAR(100) NOT NULL UNIQUE,
--    "IMAGE_URL" VARCHAR(255),
--    "PAN" VARCHAR(20),
--    "EXPIRY_MONTH" INTEGER,
--    "EXPIRY_YEAR" INTEGER,
--    "ROLES" VARCHAR(50) NOT NULL
--);

-- Menu Items table
CREATE TABLE MENUITEMS (
    ID INTEGER IDENTITY PRIMARY KEY,
    NAME VARCHAR(100) NOT NULL,
    DESCRIPTION VARCHAR(1000),
    CATEGORY VARCHAR(50) NOT NULL,
    PRICE DECIMAL(10,2) NOT NULL,
    IMAGE_URL VARCHAR(255),
    AVAILABLE BOOLEAN DEFAULT TRUE
);

---- Orders table
--CREATE TABLE orders (
--    id INTEGER PRIMARY KEY,
--    userid INTEGER NOT NULL,
--    ordertime VARCHAR(20),
--    pickuptime VARCHAR(20),
--    area VARCHAR(50),
--    location VARCHAR(50),
--    tax DECIMAL(10,2),
--    tip DECIMAL(10,2),
--    pan VARCHAR(20),
--    expiry_month INTEGER,
--    expiry_year INTEGER,
--    status VARCHAR(20) NOT NULL,
--    FOREIGN KEY (userid) REFERENCES users(ID)
--);
--
---- Order Items table
--CREATE TABLE items (
--    id INTEGER PRIMARY KEY,
--    orderid INTEGER NOT NULL,
--    itemid INTEGER NOT NULL,
--    price DECIMAL(10,2) NOT NULL,
--    firstname VARCHAR(50),
--    notes TEXT,
--    FOREIGN KEY (orderid) REFERENCES orders(id),
--    FOREIGN KEY (itemid) REFERENCES menuitems(id)
--);
--
---- Films table
--CREATE TABLE films (
--    id INTEGER PRIMARY KEY,
--    title VARCHAR(100) NOT NULL,
--    homepage VARCHAR(255),
--    overview TEXT,
--    posterpath VARCHAR(255),
--    runtime INTEGER,
--    tagline VARCHAR(255),
--    popularity DECIMAL(10,1),
--    imdbid VARCHAR(20),
--    voteaverage DECIMAL(10,1),
--    votecount INTEGER
--);
--
---- Indexes for better performance
--CREATE INDEX idx_users_username ON users(USERNAME);
--CREATE INDEX idx_users_email ON users(EMAIL);
--CREATE INDEX idx_menuitems_category ON menuitems(category);
--CREATE INDEX idx_orders_userid ON orders(userid);
--CREATE INDEX idx_orders_status ON orders(status);
--CREATE INDEX idx_items_orderid ON items(orderid);
--CREATE INDEX idx_items_itemid ON items(itemid);
--CREATE INDEX idx_films_title ON films(title);