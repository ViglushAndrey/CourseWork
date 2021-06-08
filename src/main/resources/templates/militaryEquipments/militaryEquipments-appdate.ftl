<#import "/spring.ftl" as spring/>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>Edit MilitaryEquipment</title>
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
  <style>
    fieldset{
      width: 250px;
      background: linear-gradient(45deg, #EECFBA, #C5DDE8);
      background-size: cover;
      border-radius: 20px;
    }
    body{
      background-image: url("https://w-dog.ru/wallpapers/2/9/446316496294686.jpg");
    }
    select
    {
      display: inline-block;
      width: 233px;
      height: 34px;
      line-height: 30px;
      position: relative;
    }
    /* Это наша стрелочка, показывающая, что селект можно раскрыть */
    select:before
    {
      content: ">";
      display: inline-block;
      background: white;
      position: absolute;
      right: -5px;
      top: 2px;
      z-index: 2;
      width: 50px;
      height: 26px;
      text-align: center;
      line-height: 26px;
      border: 2px solid #ddd;
      transform: rotate(90deg);
      cursor: pointer;
    }
    .stilisation{
      min-width: 220px;
      font-family: inherit;
      appearance: none;
      border: 0;
      border-radius: 5px;
      background: #4676d7;
      color: #fff;
      padding: 8px 16px;
      font-size: 1rem;
      cursor: pointer;
    }
    .stilisation:hover {
      background: #1d49aa;
    }
    .stilisation:focus {
      outline: none;
      box-shadow: 0 0 0 4px #cbd6ee;
    }
    input{
      padding: 5px;
      width: 220px;
    }
    h3{
      color: black;
    }
    .h-color{
      color: #FFFFFF;
      background-color: #FFFFFF;
    }
    a {
      background-color: burlywood;
      box-shadow: 0 5px 0 darkred;
      color: white;
      padding: 1em 1.5em;
      position: relative;
      text-decoration: none;
      text-transform: uppercase;
      display: inline;
      margin-left: auto;
      margin-right: auto;
    }
    a:hover {
      background-color: #ce0606;
      cursor: pointer;
    }
    a:active {
      box-shadow: none;
      top: 5px;
    }
  </style>
</head>
<body>
<header><h1 align="center">Edit MilitaryEquipment</h1></header>
<hr class="h-color">
<div style="margin-top: 100px">
  <fieldset style=" margin-left: auto; margin-right: auto">
    <legend style="text-align: center;"><h3>Add MilitaryEquipment</h3></legend>
    <form name="MilitaryEquipment" action="" method="POST">
      <h3>Tanks:<@spring.formSingleSelect "forms.tanks" tanks "" /></h3>
      <h3>NumberOfTanks:<@spring.formInput "forms.numberOfTanks" "" "text" /></h3>
      <h3>BMP:<@spring.formSingleSelect "forms.bmp" bmp "" /></h3>
      <h3>NumberOfBmp:<@spring.formInput "forms.numberOfBmp" "" "text" /></h3>
      <h3>BTR:<@spring.formSingleSelect "forms.btr" btr "" /></h3>
      <h3>NumberOfBTR:<@spring.formInput "forms.numberOfBtr" "" "text" /></h3>
      <h3>TotalMilitaryEquipment:<@spring.formInput "forms.totalMilitaryEquipment" "" "text" /></h3>


      <input type="submit" value="Edit" class="stilisation">
    </form>
  </fieldset>
</div>
<a href="/ui/MilitaryEquipment/get/all" class="fa fa-reply"></a>
</body>
</html>