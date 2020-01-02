<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Create book page</title>
</head>
<body>
<#--action - важное место в коде-->
<form name="book" action="/index/addBook" method="post">
    <p>Isbn</p>
    <input title="Isbn" type="text" name="isbn">
    <p>Name</p>
    <input title="Name" type="text" name="name">
    <p>Author</p>
    <input title="Author" type="text" name="author">
    <input type="submit" value="OK">
</form>
</body>
</html>