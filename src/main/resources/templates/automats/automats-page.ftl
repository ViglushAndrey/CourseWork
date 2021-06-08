<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Automats</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-BmbxuPwQa2lc/FVzBcNJ7UAyJxM6wuqIj61tLrc4wSX0szH/Ev+nYRRuWlolflfl" crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <style>
        body{
            background-image: url("https://i.pinimg.com/originals/6c/ca/04/6cca04d07a45e0502ef463bd0e019e5b.jpg");
        }
    </style>
</head>
<body>
<div style="margin-left: auto; margin-right: auto" >
    <table class="table table-dark table-striped">
        <tr>
            <th>Delete</th>
            <th>Edit</th>
            <th>ID</th>
            <th>Model</th>
            <th>Caliber</th>
            <th>NumberOfCartridgesInMagazine</th>
            <th>Created_At</th>
            <th>Modify_At</th>


        </tr>
        <#list automats as automat>
            <tr>
                <td><a href="/ui/Automats/delete/${automat.id}"><button class="btn btn-outline-dark"><i class="fa fa-trash"></i></button></a></td>
                <td><a href="/ui/Automats/edit/${automat.id}"><button class="btn btn-outline-dark"><i class="fa fa-pencil"></i></button></a></td>
                <td>${automat.id}</td>
                <td>${automat.model}</td>
                <td>${automat.caliber}</td>
                <td>${automat.numberOfCartridgesInMagazine}</td>
                <td>${automat.created_at}</td>
                <td><#if automat.modify_at ?? > ${automat.modify_at}
                    <#else> NULL
                    </#if></td>


            </tr>
        </#list>
    </table>
    <a class="btn btn-access; btn btn-outline-dark" href="/ui/Automats/create">Create</a>
</div>


</body>
</html>