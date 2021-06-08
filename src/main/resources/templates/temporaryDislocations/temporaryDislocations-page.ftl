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
            <th>TemporaryDislocation</th>
            <th>City</th>
            <th>Address</th>
            <th>Created_At</th>
            <th>Modify_At</th>


        </tr>
        <#list temporaryDislocations as temporaryDislocation>
            <tr>
                <td><a href="/ui/TemporaryDis/delete/${temporaryDislocation.id}"><button class="btn btn-outline-dark"><i class="fa fa-trash"></i></button></a></td>
                <td><a href="/ui/TemporaryDis/edit/${temporaryDislocation.id}"><button class="btn btn-outline-dark"><i class="fa fa-pencil"></i></button></a></td>
                <td>${temporaryDislocation.id}</td>
                <td>${temporaryDislocation.temporaryDislocation}</td>
                <td>${temporaryDislocation.city}</td>
                <td>${temporaryDislocation.address}</td>
                <td>${temporaryDislocation.created_at}</td>
                <td><#if temporaryDislocation.modify_at ?? > ${temporaryDislocation.modify_at}
                    <#else> NULL
                    </#if></td>


            </tr>
        </#list>
    </table>
    <a class="btn btn-access; btn btn-outline-dark" href="/ui/TemporaryDis/create">Create</a>
</div>


<br>
<br>

<div style="margin: 0 auto; width: 100%">
    <table class="table table-dark table-hover">

        <tr>
            <th>ЗАПИТИ</th>
        </tr>

        <tr>
            <td>Всі можливі місця тимчасової дислокації</td>
            <td>
                <a href="/operations7/get/all">
                    <button class="btn btn-light btn-sm">Перейти</button>
                </a>
            </td>
        </tr>





    </table>
</div>

</body>
</html>