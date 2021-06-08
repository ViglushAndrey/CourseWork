<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Ordinarys</title>
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
            <th>bDay</th>
            <th>Speciality</th>
            <th>DateOfAssignmentOfAnOfficerRank</th>
            <th>Awards</th>
            <th>OrdinaryRanks</th>
            <th>Created_At</th>
            <th>Modify_At</th>


        </tr>
        <#list ordinarys as ordinary>
            <tr>
                <td><a href="/ui/Ordinarys/delete/${ordinary.id}"><button class="btn btn-outline-dark"><i class="fa fa-trash"></i></button></a></td>
                <td><a href="/ui/Ordinarys/edit/${ordinary.id}"><button class="btn btn-outline-dark"><i class="fa fa-pencil"></i></button></a></td>
                <td>${ordinary.id}</td>
                <td>${ordinary.name}</td>
                <td>${ordinary.bDay}</td>
                <td>${ordinary.speciality}</td>
                <td>${ordinary.dateOfAssignmentOfAnOfficerRank}</td>
                <td>${ordinary.awards}</td>
                <td>${ordinary.ordinaryRanks}</td>
                <td>${ordinary.created_at}</td>
                <td><#if ordinary.modify_at ?? > ${ordinary.modify_at}
                    <#else> NULL
                    </#if></td>


            </tr>
        </#list>
    </table>
    <a class="btn btn-access; btn btn-outline-dark" href="/ui/Ordinarys/create">Create</a>
</div>

<br>
<br>

<div style="margin: 0 auto; width: 100%">
    <table class="table table-dark table-hover">

        <tr>
            <th>ЗАПИТИ</th>
        </tr>

        <tr>
            <td>Загальний рядовий склад</td>
            <td>
                <a href="/operations2/get/all">
                    <button class="btn btn-light btn-sm">Перейти</button>
                </a>
            </td>
        </tr>

        <tr>
            <td>Рядовий склад по заданому званню</td>
            <td>
                <a href="/operations2/get/all/ordinaryrank">
                    <button class="btn btn-light btn-sm">Перейти</button>
                </a>
            </td>
        </tr>

    </table>
</div>

</body>
</html>