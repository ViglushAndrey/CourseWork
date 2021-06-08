<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Army</title>
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
            <th>Personnel</th>
            <th><a href="/ui/Generals/get/all">Generals</a></th>
            <th><a href="/ui/Obj/get/all">Obj</a></th>
            <th><a href="/ui/PermanentDis/get/all">PermanentDislocation</a></th>
            <th><a href="/ui/TemporaryDis/get/all">TemporaryDislocation</a></th>
            <th><a href="/ui/Armament/get/all">ArmamentId</a></th>
            <th><a href="/ui/Battalion/get/all">Battalion</a></th>
            <th>Created_At</th>
            <th>Modify_At</th>


        </tr>
        <#list armies as army>
            <tr>
                <td><a href="/ui/Army/delete/${army.id}"><button class="btn btn-outline-dark"><i class="fa fa-trash"></i></button></a></td>
                <td><a href="/ui/Army/edit/${army.id}"><button class="btn btn-outline-dark"><i class="fa fa-pencil"></i></button></a></td>
                <td>${army.id}</td>
                <td>${army.name}</td>
                <td>${army.personnel}</td>
                <td>${army.generals.name}</td>
                <td>${army.obj.typesOfBuildings}</td>
                <td>${army.permanentDislocation.permanentDislocation}</td>
                <td>${army.temporaryDislocation.temporaryDislocation}</td>
                <td>${army.armament.id}</td>
                <td>${army.battalion.name}</td>
                <td>${army.created_at}</td>
                <td><#if army.modify_at ?? > ${army.modify_at}
                    <#else> NULL
                    </#if></td>


            </tr>
        </#list>
    </table>
    <a class="btn btn-access; btn btn-outline-dark" href="/ui/Army/create">Create</a>

    <br>
    <br>

    <div style="margin: 0 auto; width: 100%">
        <table class="table table-dark table-hover">

            <tr>
                <th>ЗАПИТИ</th>
            </tr>

        </table>
    </div>
</div>


</body>
</html>