<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Tractor</title>
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
            <th>Name</th>
            <th>Weight</th>
            <th>MaximumSpeed</th>
            <th>LiftingCapacity</th>
            <th>BodyType</th>
            <th>Created_At</th>
            <th>Modify_At</th>


        </tr>
        <#list tractors as tractor>
            <tr>
                <td><a href="/ui/Tractor/delete/${tractor.id}"><button class="btn btn-outline-dark"><i class="fa fa-trash"></i></button></a></td>
                <td><a href="/ui/Tractor/edit/${tractor.id}"><button class="btn btn-outline-dark"><i class="fa fa-pencil"></i></button></a></td>
                <td>${tractor.id}</td>
                <td>${tractor.name}</td>
                <td>${tractor.weight}</td>
                <td>${tractor.maximumSpeed}</td>
                <td>${tractor.liftingCapacity}</td>
                <td>${tractor.bodyType}</td>
                <td>${tractor.created_at}</td>
                <td><#if tractor.modify_at ?? > ${tractor.modify_at}
                    <#else> NULL
                    </#if></td>


            </tr>
        </#list>
    </table>
    <a class="btn btn-access; btn btn-outline-dark" href="/ui/Tractor/create">Create</a>
</div>


</body>
</html>