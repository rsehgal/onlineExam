<?php
// Create connection
$con=mysqli_connect("31.10.1.80","raman","ramansehgal","dbraman");

// Check connection
if (mysqli_connect_errno()) {
  echo "Failed to connect to MySQL: " . mysqli_connect_error();
}
else{
//echo "Connection Established  ..  ";
}


echo "<center>";
echo "<table border='2'>";

echo "<tr><th>username</th><th>Marks</th></tr>";
$resultScore = mysqli_query($con,"SELECT * FROM user");
while($rowScore = mysqli_fetch_array($resultScore)) {
echo "<tr>";
echo "<td>".$rowScore[0]."</td>";
//echo $row[0]."<br/>";
$countQuery="select count(*) from mcqBackup where ".$rowScore[0]."Marks=1";
//echo $countQuery."<br/>";
$markSet = mysqli_query($con,$countQuery);
$marksRow = mysqli_fetch_array($markSet);
echo "<td>".$marksRow[0]."</td>";
echo "</tr>";
}

echo "</table>";
echo "</center>";

?>
