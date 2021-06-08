<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Armament</title>

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-eOJMYsd53ii+scO/bJGFsiCZc+5NDVN2yr8+0RDqr0Ql0h+rP48ckxlpbzKgwra6" crossorigin="anonymous">
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
            <th><a href="/ui/Grenades/get/all">Grenades</a></th>
            <th><a href="/ui/Pistols/get/all">Pistols</a></th>
            <th><a href="/ui/SniperRifles/get/all">SniperRifles</a></th>
            <th><a href="/ui/MachinesGuns/get/all">MachinesGuns</a></th>
            <th><a href="/ui/Automats/get/all">Automats</a></th>
            <th><a href="/ui/MilitaryEquipment/get/all">TotalMilitaryEquipment</a></th>
            <th><a href="/ui/TransportEquip/get/all">TotalTransportEquipment</a></th>
            <th>Created_At</th>
            <th>Modify_At</th>

        </tr>
        <#list armaments as armament>
            <tr>
                <td><a href="/ui/Armament/delete/${armament.id}"><button class="btn btn-outline-dark"><i class="fa fa-trash"></i></button></a></td>
                <td><a href="/ui/Armament/edit/${armament.id}"><button class="btn btn-outline-dark"><i class="fa fa-pencil"></i></button></a></td>
                <td>${armament.id}</td>
                <td>${armament.grenades.model}</td>
                <td>${armament.pistols.model}</td>
                <td>${armament.sniperRifles.model}</td>
                <td>${armament.machinesGuns.model}</td>
                <td>${armament.automats.model}</td>
                <td>${armament.militaryEquipment.totalMilitaryEquipment}</td>
                <td>${armament.transportEquipment.totalTransportEquipment}</td>
                <td>${armament.created_at}</td>
                <td><#if armament.modify_at ?? > ${armament.modify_at}
                    <#else> NULL
                    </#if></td>

            </tr>
        </#list>

    </table>
    <a class="btn btn-access; btn btn-outline-dark" href="/ui/Armament/create">Create</a>

    <br>
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