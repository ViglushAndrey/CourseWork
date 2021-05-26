<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Armament</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-eOJMYsd53ii+scO/bJGFsiCZc+5NDVN2yr8+0RDqr0Ql0h+rP48ckxlpbzKgwra6" crossorigin="anonymous">
</head>
<body>
<div style="width: 800px; margin-left: auto; margin-right: auto" >
    <table class="table table-dark table-striped">
        <tr>
            <th>Delete</th>
            <th>Edit</th>
            <th>ID</th>
            <th>Grenades</th>
            <th>Pistols</th>
            <th>SniperRifles</th>
            <th>MachinesGuns</th>
            <th>Automats</th>
            <th>MilitaryEquipment</th>
            <th>TransportEquipment</th>


        </tr>
        <#list armaments as armament>
            <tr>
                <td><a href="/ui/Officers/delete/${armament.id}"><button class="btn btn-outline-dark"><i class="fa fa-trash"></i></button></a></td>
                <td><a href="/ui/Officers/edit/${armament.id}"><button class="btn btn-outline-dark"><i class="fa fa-pencil"></i></button></a></td>
                <td>${armament.id}</td>
                <td>${armament.grenades}</td>
                <td>${armament.pistols}</td>
                <td>${armament.sniperRifles}</td>
                <td>${armament.machinesGuns}</td>
                <td>${armament.automats}</td>
                <td>${armament.militaryEquipment}</td>
                <td>${armament.transportEquipment}</td>

            </tr>
        </#list>
        <a class="btn btn-access; btn btn-outline-dark" href="/ui/Armament/create">Create</a>
    </table>
</div>


</body>
</html>