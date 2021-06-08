<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Departament</title>
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
            <th>Personnel</th>
            <th><a href="/ui/Ordinarys/get/all">Ordinarys</a></th>
            <th><a href="/ui/Obj/get/all">Obj</a></th>
            <th><a href="/ui/PermanentDis/get/all">PermanentDislocation</a></th>
            <th><a href="/ui/TemporaryDis/get/all">TemporaryDislocation</a></th>
            <th><a href="/ui/TransportEquip/get/all">TotalTransportEquipment</a></th>
            <th><a href="/ui/MilitaryEquipment/get/all">TotalMilitaryEquipment</a></th>
            <th>Created_At</th>
            <th>Modify_At</th>


        </tr>
        <#list departments as department>
            <tr>
                <td><a href="/ui/Departament/delete/${department.id}"><button class="btn btn-outline-dark"><i class="fa fa-trash"></i></button></a></td>
                <td><a href="/ui/Departament/edit/${department.id}"><button class="btn btn-outline-dark"><i class="fa fa-pencil"></i></button></a></td>
                <td>${department.id}</td>
                <td>${department.personnel}</td>
                <td>${department.ordinarys.name}</td>
                <td>${department.obj.typesOfBuildings}</td>
                <td>${department.permanentDislocation.permanentDislocation}</td>
                <td>${department.temporaryDislocation.temporaryDislocation}</td>
                <td>${department.transportEquipment.totalTransportEquipment}</td>
                <td>${department.militaryEquipment.totalMilitaryEquipment}</td>
                <td>${department.created_at}</td>
                <td><#if department.modify_at ?? > ${department.modify_at}
                    <#else> NULL
                    </#if></td>


            </tr>
        </#list>
    </table>
    <a class="btn btn-access; btn btn-outline-dark" href="/ui/Departament/create">Create</a>
</div>


</body>
</html>