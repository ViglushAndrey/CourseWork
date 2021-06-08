<#import "/spring.ftl" as spring/>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>MilitaryEquipment</title>
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
            <th><a href="/ui/Tanks/get/all">Tanks</a></th>
            <th>NumberOfTanks</th>
            <th><a href="/ui/BMP/get/all">BMP</a></th>
            <th>NumberOfBmp</th>
            <th><a href="/ui/BTR/get/all">BTR</a></th>
            <th>NumberOfBTR</th>
            <th>TotalMilitaryEquipment</th>
            <th>Created_At</th>
            <th>Modify_At</th>


        </tr>
        <#list militaryEquipments as militaryEquipment>
            <tr>
                <td><a href="/ui/MilitaryEquipment/delete/${militaryEquipment.id}"><button class="btn btn-outline-dark"><i class="fa fa-trash"></i></button></a></td>
                <td><a href="/ui/MilitaryEquipment/edit/${militaryEquipment.id}"><button class="btn btn-outline-dark"><i class="fa fa-pencil"></i></button></a></td>
                <td>${militaryEquipment.id}</td>
                <td>${militaryEquipment.tanks.name}</td>
                <td>${militaryEquipment.numberOfTanks}</td>
                <td>${militaryEquipment.bmp.name}</td>
                <td>${militaryEquipment.numberOfBmp}</td>
                <td>${militaryEquipment.btr.name}</td>
                <td>${militaryEquipment.numberOfBtr}</td>
                <td>${militaryEquipment.totalMilitaryEquipment}</td>
                <td>${militaryEquipment.created_at}</td>
                <td><#if militaryEquipment.modify_at ?? > ${militaryEquipment.modify_at}
                    <#else> NULL
                    </#if></td>


            </tr>
        </#list>
    </table>
    <a class="btn btn-access; btn btn-outline-dark" href="/ui/MilitaryEquipment/create">Create</a>
</div>


</body>
</html>