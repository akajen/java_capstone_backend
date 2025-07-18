-- Database Schema for Restaurant/Theater Application

-- Users table
CREATE TABLE USERS (
    ID INTEGER IDENTITY PRIMARY KEY,
    USERNAME VARCHAR(50) NOT NULL UNIQUE,
    PASSWORD VARCHAR(255) NOT NULL,
    FIRST_NAME VARCHAR(50) NOT NULL,
    LAST_NAME VARCHAR(50) NOT NULL,
    PHONE VARCHAR(20),
    EMAIL VARCHAR(100) NOT NULL UNIQUE,
    IMAGE_URL VARCHAR(255),
    PAN VARCHAR(20),
    EXPIRY_MONTH INTEGER,
    EXPIRY_YEAR INTEGER,
    ROLES VARCHAR(50) NOT NULL
);

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
CREATE TABLE ORDERS (
    ID INTEGER IDENTITY PRIMARY KEY,
    USERID INTEGER NOT NULL,
    ORDER_TIME VARCHAR(20),
    PICKUP_TIME VARCHAR(20),
    AREA VARCHAR(50),
    LOCATION VARCHAR(50),
    TAX DECIMAL(10,2),
    TIP DECIMAL(10,2),
    PAN VARCHAR(20),
    EXPIRY_MONTH INTEGER,
    EXPIRY_YEAR INTEGER,
    STATUS VARCHAR(20) NOT NULL,
    FOREIGN KEY (USERID) REFERENCES USERS(ID)
);

---- Order Items table
CREATE TABLE ORDER_ITEMS (
    ID INTEGER IDENTITY PRIMARY KEY,
    ORDERID INTEGER NOT NULL,
    ITEMID INTEGER NOT NULL,
    PRICE DECIMAL(10,2) NOT NULL,
    FIRST_NAME VARCHAR(50),
    NOTES VARCHAR(1000),
    FOREIGN KEY (ORDERID) REFERENCES ORDERS(ID),
    FOREIGN KEY (ITEMID) REFERENCES MENUITEMS(ID)
);

---- Films table
CREATE TABLE FILMS (
    ID INTEGER IDENTITY PRIMARY KEY,
    TITLE VARCHAR(100) NOT NULL,
    HOMEPAGE VARCHAR(255),
    OVERVIEW VARCHAR(1500),
    POSTER_PATH VARCHAR(255),
    RUNTIME INTEGER,
    TAGLINE VARCHAR(255),
    POPULARITY DECIMAL(10,1),
    IMDBID VARCHAR(20),
    VOTE_AVERAGE DECIMAL(10,1),
    VOTE_COUNT INTEGER
);

---- Indexes for better performance
--CREATE INDEX idx_users_username ON users(USERNAME);
--CREATE INDEX idx_users_email ON users(EMAIL);
--CREATE INDEX idx_menuitems_category ON menuitems(category);
--CREATE INDEX idx_orders_userid ON orders(userid);
--CREATE INDEX idx_orders_status ON orders(status);
--CREATE INDEX idx_items_orderid ON items(orderid);
--CREATE INDEX idx_items_itemid ON items(itemid);
--CREATE INDEX idx_films_title ON films(title);