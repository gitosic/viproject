<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
<#--Выводим список книг-->
<h1>Books list</h1>
<table>
    <tr>
        <th>Id</th>
        <th>Name</th>
        <th>Isbn</th>
        <th>Author</th>
    </tr>
<#list books as book>
        <tr>
            <td><a href="/book/${book.id}">${book.id}</a></td>
            <td>${book.name}</td>
            <td>${book.isbn}</td>
            <td>${book.author}</td>
            <td><a href="/delete/${book.id}">Delete</a></td>
            <td><a href="/update/${book.id}">Update</a></td>
        </tr>
    </#list>
</table>
<a href="/addBook">Create book</a>
</body>
</html>