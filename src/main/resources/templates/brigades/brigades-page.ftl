<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Brigade</title>
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
            <th><a href="/ui/Rota/get/all">Rota</a></th>
            <th>Created_At</th>
            <th>Modify_At</th>


        </tr>
        <#list brigades as brigade>
            <tr>
                <td><a href="/ui/Brigade/delete/${brigade.id}"><button class="btn btn-outline-dark"><i class="fa fa-trash"></i></button></a></td>
                <td><a href="/ui/Brigade/edit/${brigade.id}"><button class="btn btn-outline-dark"><i class="fa fa-pencil"></i></button></a></td>
                <td>${brigade.id}</td>
                <td>${brigade.name}</td>
                <td>${brigade.personnel}</td>
                <td>${brigade.officers.name}</td>
                <td>${brigade.obj.typesOfBuildings}</td>
                <td>${brigade.permanentDislocation.permanentDislocation}</td>
                <td>${brigade.temporaryDislocation.temporaryDislocation}</td>
                <td>${brigade.armament.id}</td>
                <td>${brigade.rota.name}</td>
                <td>${brigade.created_at}</td>
                <td><#if brigade.modify_at ?? > ${brigade.modify_at}
                    <#else> NULL
                    </#if></td>


            </tr>
        </#list>
    </table>
    <a class="btn btn-access; btn btn-outline-dark" href="/ui/Brigade/create">Create</a>
</div>

<br>
<br>

<div style="margin: 0 auto; width: 100%">
    <table class="table table-dark table-hover">

        <tr>
            <th>ЗАПИТИ</th>
        </tr>

        <tr>
            <td>Бригада повна інформація</td>
            <td>
                <a href="/operations5/get/all">
                    <button class="btn btn-light btn-sm">Перейти</button>
                </a>
            </td>
        </tr>

        <tr>
            <td>Бригада з головною людиною</td>
            <td>
                <a href="/operations5/get/all/Brigade">
                    <button class="btn btn-light btn-sm">Перейти</button>
                </a>
            </td>
        </tr>



    </table>
</div>

</body>
</html>