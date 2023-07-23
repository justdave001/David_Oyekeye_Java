use northwind;

-- categories of products
SELECT category from products;

-- products made by dell
SELECT * FROM products
WHERE product_name
LIKE "Dell%";

-- orders shipped to pennsylvania
SELECT * FROM orders
WHERE ship_state = "Pennsylvania";

-- list the first and last name of employees with last names that start with a W
SELECT * from employees
WHERE last_name
LIKE "W%";

-- list customers with zipcodes that start with 55
SELECT * from customers
WHERE postal_code
LIKE "55%";

-- list customers with zip codes that end in 0
SELECT * FROM customers
WHERE postal_code
LIKE "%0";

-- list fName, lName, email of customers with .org domain
SELECT first_name, last_name, email FROM customers
WHERE email
LIKE "%.org";

-- list fName, lName, phone # of customers with 202 area code
SELECT first_name, last_name, phone FROM customers
WHERE phone
LIKE "%202%";

-- list fName, lName, phone # of all customers with 202 area code ordered by lName, fName
SELECT first_name, last_name, phone FROM customers
WHERE phone
LIKE "%202%"
ORDER BY last_name, first_name;
