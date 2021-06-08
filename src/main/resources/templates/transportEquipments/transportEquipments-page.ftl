<#import "/spring.ftl" as spring/>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>TransportEquip</title>
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
            <th><a href="/ui/FreightCar/get/all">FreightCar</a></th>
            <th>NumberOfFreightCar</th>
            <th><a href="/ui/Tractor/get/all">Tractor</a></th>
            <th>NumberOfTractor</th>
            <th>TotalTransportEquipment</th>
            <th>Created_At</th>
            <th>Modify_At</th>


        </tr>
        <#list transportEquipments as transportEquipment>
            <tr>
                <td><a href="/ui/TransportEquip/delete/${transportEquipment.id}"><button class="btn btn-outline-dark"><i class="fa fa-trash"></i></button></a></td>
                <td><a href="/ui/TransportEquip/edit/${transportEquipment.id}"><button class="btn btn-outline-dark"><i class="fa fa-pencil"></i></button></a></td>
                <td>${transportEquipment.id}</td>
                <td>${transportEquipment.freightCar.name}</td>
                <td>${transportEquipment.numberOfFreightCar}</td>
                <td>${transportEquipment.tractor.name}</td>
                <td>${transportEquipment.numberOfTractor}</td>
                <td>${transportEquipment.totalTransportEquipment}</td>
                <td>${transportEquipment.created_at}</td>
                <td><#if transportEquipment.modify_at ?? > ${transportEquipment.modify_at}
                    <#else> NULL
                    </#if></td>


            </tr>
        </#list>
    </table>
    <a class="btn btn-access; btn btn-outline-dark" href="/ui/TransportEquip/create">Create</a>
</div>


</body>
</html>