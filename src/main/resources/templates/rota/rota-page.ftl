<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Rota</title>
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
            <th><a href="/ui/Officers/get/all">Officers</a></th>
            <th><a href="/ui/Obj/get/all">Obj</a></th>
            <th><a href="/ui/PermanentDis/get/all">PermanentDislocation</a></th>
            <th><a href="/ui/TemporaryDis/get/all">TemporaryDislocation</a></th>
            <th><a href="/ui/Armament/get/all">ArmamentId</a></th>
            <th><a href="/ui/Vzvods/get/all">Vzvods</a></th>
            <th>Created_At</th>
            <th>Modify_At</th>


        </tr>
        <#list rotas as rota>
            <tr>
                <td><a href="/ui/Rota/delete/${rota.id}"><button class="btn btn-outline-dark"><i class="fa fa-trash"></i></button></a></td>
                <td><a href="/ui/Rota/edit/${rota.id}"><button class="btn btn-outline-dark"><i class="fa fa-pencil"></i></button></a></td>
                <td>${rota.id}</td>
                <td>${rota.name}</td>
                <td>${rota.personnel}</td>
                <td>${rota.officers.name}</td>
                <td>${rota.obj.typesOfBuildings}</td>
                <td>${rota.permanentDislocation.permanentDislocation}</td>
                <td>${rota.temporaryDislocation.temporaryDislocation}</td>
                <td>${rota.armament.id}</td>
                <td>${rota.vzvods.name}</td>
                <td>${rota.created_at}</td>
                <td><#if rota.modify_at ?? > ${rota.modify_at}
                    <#else> NULL
                    </#if></td>


            </tr>
        </#list>
    </table>
    <a class="btn btn-access; btn btn-outline-dark" href="/ui/Rota/create">Create</a>
</div>


</body>
</html>