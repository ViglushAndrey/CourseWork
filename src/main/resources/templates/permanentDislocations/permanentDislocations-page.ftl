<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>TemporaryDislocation</title>
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
            <th>PermanentDislocation</th>
            <th>City</th>
            <th>Address</th>
            <th>Created_At</th>
            <th>Modify_At</th>


        </tr>
        <#list dislocations as dislocation>
            <tr>
                <td><a href="/ui/PermanentDis/delete/${dislocation.id}"><button class="btn btn-outline-dark"><i class="fa fa-trash"></i></button></a></td>
                <td><a href="/ui/PermanentDis/edit/${dislocation.id}"><button class="btn btn-outline-dark"><i class="fa fa-pencil"></i></button></a></td>
                <td>${dislocation.id}</td>
                <td>${dislocation.permanentDislocation}</td>
                <td>${dislocation.city}</td>
                <td>${dislocation.address}</td>
                <td>${dislocation.created_at}</td>
                <td><#if dislocation.modify_at ?? > ${dislocation.modify_at}
                    <#else> NULL
                    </#if></td>


            </tr>
        </#list>
    </table>
    <a class="btn btn-access; btn btn-outline-dark" href="/ui/PermanentDis/create">Create</a>
</div>


</body>
</html>