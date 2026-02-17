# Personal Introduction
**Name:** NDAYISABA KAMARIZA Belie <br>
**ID:** 27174<br>
**Group:** C <br>
**Course:** Web Technology and Internet<br>
**Concentration:** Software Engineering<br>
**--------------------------------------------------------**
# RestFull_API_with_CRUD_Operation_27174
RestFull Api with CRUD Operations on E-Commerce 
##  What is CRUD?

CRUD stands for the four basic operations you can do with data:

| Letter | Operation | Description |
|--------|-----------|----------------|
| **C** | Create | Add a new product to the database |
| **R** | Read | View one or all products |
| **U** | Update | Edit an existing product |
| **D** | Delete | Remove a product from the database |

This project implements all four operations through REST API endpoints.

## Create New Product
**Method:** `POST`  
**URL:** `/api/products`

![](https://github.com/NKBelie/RestFull_API_with_CRUD_Operation_27174/blob/main/Screenshot/insert.png)
## Read/Select All Product
**Method:** `GET`  
**URL:** `/api/getProducts`

![](https://github.com/NKBelie/RestFull_API_with_CRUD_Operation_27174/blob/main/Screenshot/All%20Product.png)
## Read/Select By Id
**Method:** `GET`  
**URL:** `/api/getProductById/{id}`  
**Example:** `/api/products/1002`

![](https://github.com/NKBelie/RestFull_API_with_CRUD_Operation_27174/blob/main/Screenshot/Product%20By%20Id.png)
## Search By Category
**Method:** `GET`  
**URL:** `/api/products/search?category={category}`  
**Example:** `/api/products/search?category=Electronics`

![](https://github.com/NKBelie/RestFull_API_with_CRUD_Operation_27174/blob/main/Screenshot/Search%20By%20Category.png)
## Search By Brand And Price
**Method:** `GET`  
**URL:** `/api/products/searchByPriceAndBrand?price={price}&brand={brand}`  
**Example:** `/api/products/searchByPriceAndBrand?price=89.99&brand=TechSound`

![](https://github.com/NKBelie/RestFull_API_with_CRUD_Operation_27174/blob/main/Screenshot/Search%20By%20Brand%20and%20Price.png)
## Update Product
**Method:** `PUT`  
**URL:** `/api/updateProduct/{id}`  
**Example:** `/api/updateProduct/1002`

![](https://github.com/NKBelie/RestFull_API_with_CRUD_Operation_27174/blob/main/Screenshot/Update.png)
## Delete Product
**Method:** `DELETE`  
**URL:** `/api//deleteProduct/{id}`  
**Example:** `/api//deleteProduct/1001`

![](https://github.com/NKBelie/RestFull_API_with_CRUD_Operation_27174/blob/main/Screenshot/Delete.png)

##  Test with Postman

1. Open **Postman**
2. Choose the request method (GET, POST, PUT, DELETE)
3. Enter the full URL e.g. `http://localhost:8091/api/products`
4. For **POST** and **PUT** requests:
   - Click on **Body** tab → select **raw** → choose **JSON**
   - Paste your JSON data
5. Click **Send** and check the response

---
##  HTTP Status Codes Used

| Code | Meaning | When it happens |
|---|---|---|
| `200 OK` | Success | Product found, updated, or deleted |
| `201 CREATED` | Created | New product added successfully |
| `302 FOUND` | Found | Search results returned |
| `404 NOT FOUND` | Not found | Product with given ID does not exist |
| `409 CONFLICT` | Conflict | Product with same ID already exists |


