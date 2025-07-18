# Dinner and A Movie - Backend

A Java backend application for the Dinner and A Movie app, providing comprehensive API services for managing users, menu items, orders, and films.

## Features

- RESTful API endpoints for users, menu items, orders, and films
- In-memory HSQLDB database for development and testing
- Built with Gradle for dependency management
- Lightweight and easy to run
- No external database setup required
- API documentation available via Swagger UI

## Prerequisites

- Java 21
- Gradle (for dependency management and build)
- IDE with Java support (IntelliJ IDEA, Eclipse, VS Code, etc.)

## Getting Started

### Running the Application

1. Navigate to the project directory
2. Locate the `DAAMApplication.java` file
3. Run the application by executing the main method in `DAAMApplication.java`

Alternatively, you can use Gradle to run the application:
```bash
./gradlew bootRun
```

The application will start up and:
- Initialize the HSQLDB in-memory database
- Load any initial data
- Start the web server (typically on port 8080)

### Running Swagger UI
- ONce app is running visit `http://localhost:8080/swagger-ui/index.html` to access the Swagger UI for API documentation and testing.

### Database

This application uses HSQLDB as an in-memory database, which means:
- No external database installation required
- Database is automatically created when the application starts
- Data is reset each time the application restarts
- Perfect for development and testing

## API Endpoints

### Users
- **GET** `/api/users` - Retrieve all user details
- **POST** `/api/users` - Add new user (returns 200 OK with new ID in body)
- **GET** `/api/users/{id}` - Retrieve specified user details
- **PUT** `/api/users/{id}` - Update user details
- **DELETE** `/api/users/{id}` - Remove user

### Menu Items
- **GET** `/api/menu_items` - Retrieve all food items details
- **POST** `/api/menu_items` - Add new menu item (returns 200 OK with new ID in body)
- **GET** `/api/menu_items/{id}` - Retrieve specified menu item details
- **PUT** `/api/menu_items/{id}` - Update menu item details
- **DELETE** `/api/menu_items/{id}` - Remove menu item

### Orders
- **GET** `/api/orders` - Retrieve all order details
- **POST** `/api/orders` - Add new order (returns order_id)
- **GET** `/api/orders/{id}` - Retrieve specified order details
- **PUT** `/api/orders/{id}` - Update order details
- **DELETE** `/api/orders/{id}` - Remove order
- **GET** `/api/orders/user/{userid}` - Retrieve all orders for a specific user

### Items
- **GET** `/api/items` - Retrieve all items for all orders
- **GET** `/api/items/{id}` - Retrieve a particular item by ID
- **PUT** `/api/items/{id}` - Update a particular item
- **DELETE** `/api/items/{id}` - Remove a particular item from an order
- **GET** `/api/items/order/{orderid}` - Retrieve all items assigned to a particular order
- **POST** `/api/items/order/{orderid}` - Add a list of items to an order
- **DELETE** `/api/items/order/{orderid}` - Remove all items from an order (note: this does not delete the order itself)

### Films
- **GET** `/api/films` - Retrieve all films
- **POST** `/api/films` - Add a new film
- **GET** `/api/films/{id}` - Retrieve specified movie data
- **PUT** `/api/films/{id}` - Update existing movie details
- **DELETE** `/api/films/{id}` - Remove specified movie

## Configuration

The application uses default configuration suitable for development. Key settings:
- Database: HSQLDB in-memory
- Server port: 8080 (default)
- Context path: / (root)

## Development

### Making Changes

1. Make your code changes
2. Stop the running application
3. Run `DAAMApplication.java` again to restart with changes

### Adding Data

Since the database is in-memory, you can:
- Add initial data via SQL scripts in `src/main/resources/data.sql`
- Use the application APIs to add data (data will persist until restart)
- Add test data through initialization code

## Troubleshooting

**Application won't start:**
- Check that Java is properly installed
- Ensure no other application is using port 8080
- Check console output for specific error messages

**Database issues:**
- The in-memory database resets on each restart - this is expected behavior
- If you need persistent data, consider switching to a file-based database

## Future Enhancements

- Add persistent database configuration
- Implement user authentication
- Include more robust data validation and error handling
