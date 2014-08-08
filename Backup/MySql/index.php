<?php
// Create connection
$con=mysqli_connect("31.10.1.80","raman","ramansehgal","dbraman");

// Check connection
if (mysqli_connect_errno()) {
  echo "Failed to connect to MySQL: " . mysqli_connect_error();
}
else{
echo "Connection Established  ..  ";
}

$result = mysqli_query($con,"SELECT count(*) FROM user");
$row = mysqli_fetch_array($result);
$numOfUsers=$row[0];
echo "Num Of users : ".$numOfUsers."<br/>";

echo "<center>";
echo "<table border='2'>";
echo "<tr>";
echo "<b>Statistics of all the users<hr/></b>";
echo "<td>";
echo "<table border='2'>";
$result = mysqli_query($con,"SELECT * FROM user");
$queryString="select ";
$queryStringEnd=" from mcqBackup";
echo "<tr><th>Ques No</th>";
while($row = mysqli_fetch_array($result)) {
 $queryString.=$row['username']."Marks,";
//echo $row['username']."   ";
 echo "<th>".$row['username']."</th>";
}
echo "</tr>";
$queryString=rtrim($queryString,",");
$queryString.=$queryStringEnd;

//echo $queryString."<br/>";

//$queryString="select ramanMarks,saurabhMarks,aparnaMarks from mcqBackup";
$quesNo=0;
$newResult=mysqli_query($con,$queryString);
while($row = mysqli_fetch_array($newResult)) {
$quesNo++;
echo "<tr><td bgcolor='yellow'> Q ".$quesNo."</td>";
for($i=0 ; $i<$numOfUsers ; $i++)
{
 if($row[$i]==1)
 {
 echo "<td bgcolor='green'>".$row[$i]."</td>";
 }
 elseif($row[$i]==0)echo "<td bgcolor='red'>".$row[$i]."</td>"; 
 else echo "<td>".$row[$i]."</td>";
 }
}

  echo "</tr>";

mysqli_close($con);

echo "</table>";
echo "</td>";

echo "<td>";
include "scores.php";
echo"</td>";

echo "</tr>";
echo "</table>";
echo "</center>";

?>
