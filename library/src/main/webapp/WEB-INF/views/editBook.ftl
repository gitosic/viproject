<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Create book page</title>
</head>
<body>
<#--action - важное место в коде-->
<form name="book" action="/index/updateBook" method="post">
    <p>Id</p>
    <input title="Id" type="text" name="id" value="${book.id}">
    <p>Isbn</p>
    <input title="Isbn" type="text" name="isbn" value="${book.isbn}">
    <p>Name</p>
    <input title="Name" type="text" name="name" value="${book.name}">
    <p>Author</p>
    <input title="Author" type="text" name="author" value="${book.author}">
    <input type="submit" value="OK">
</form>
</body>
</html>