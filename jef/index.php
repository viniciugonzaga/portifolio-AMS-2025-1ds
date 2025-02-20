<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>aula20/02</title>
</head>
<body>
    

<?php

$x = 10;
$y = 20;
$z = 2;

echo "<Br> 1)";
if($z == 2){
    $soma = $x + $y;
    echo  "soma:$soma<br>";
}elseif($z == 2){

    $menos = $x - $y;
    echo "menos:$menos<br>";
}elseif($z == 3){

    $divisao = $x / $y;
echo "divisão:$divisao<br>";
}else{
    $multi = $x * $y;
    echo "multiplicação:$multi<br>";

}

$a = 1;
echo "<Br> 2)";
while($a <= 10){
    echo "numeração: $a<br>";
    $a = $a + 1;

}
echo "<Br> 3)";
for($s = 1; $s <=20; $s = $s+1){
echo " <Br>$s";

}
echo"<br>";
echo "<Br> 4)";
echo"<br>";
$b = 0;
do{
echo $y;
$b = $b+1;
}while($b <= 10);

echo "<br> 5)";

$p = 1;
$t= 10;
$n= $p*$t;

for($s = 1; $s <=20; $s = $s+1){
    echo " <Br>$s";
}

?>


</body>
</html>