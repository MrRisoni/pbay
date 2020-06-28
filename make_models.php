<?php

// Create connection
$conn = new mysqli('localhost', 'root', 'p@ssw0rdaL', 'pbay');

// Check connection
if ($conn->connect_error) {
    die("Connection failed: " . $conn->connect_error);
}


$res = mysqli_query($conn, "SHOW TABLES FROM pbay");
while ($row = mysqli_fetch_assoc($res)) {
    $tblName = $row['Tables_in_pbay'];
    echo '-----------------';
    echo $tblName;
    echo PHP_EOL;

    /*
    package entities;
import javax.persistence.*;

@Entity
@Table(name = "buildings")
public class Building {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int id;

    @Column(name="fff")
    private String address;
    }
    */
    $className = ucfirst($tblName);

    $myfile = fopen($className.".java", "w");

    fwrite($myfile, " package entities;".PHP_EOL);
    fwrite($myfile, " import javax.persistence.*;".PHP_EOL);
    fwrite($myfile, PHP_EOL);
    fwrite($myfile, PHP_EOL);
    fwrite($myfile, " @Entity".PHP_EOL);
    fwrite($myfile, ' @Table(name = "'.$tblName.'")'.PHP_EOL);
    fwrite($myfile, " public class ".$className." { ".PHP_EOL);

    fwrite($myfile, PHP_EOL);

    $col = 0;
    $resCols = mysqli_query($conn, "SHOW COLUMNS FROM ".$tblName);
    while ($rowCol  = mysqli_fetch_assoc($resCols)) {
        $col++;

        $isFkey = ($rowCol['Key'] == 'PRI') || empty($rowCol['Key']);

        if ($isFkey) {
            if ($col== 1) {
                fwrite($myfile, " @Id".PHP_EOL);
                fwrite($myfile, " @GeneratedValue(strategy = GenerationType.IDENTITY)".PHP_EOL);
            }
            fwrite($myfile, ' @Column(name="'.$rowCol['Field'].'")'.PHP_EOL);
            $typ = 'int';
            if (strpos($rowCol['Type'], 'char') !== false) {
                $typ = 'String';
            }
              if (strpos($rowCol['Type'], 'text') !== false) {
                $typ = 'String';
            }
			if (strpos($rowCol['Type'], 'datetime') !== false) {
				 fwrite($myfile, "@Temporal(TemporalType.TIMESTAMP)".PHP_EOL);
                $typ = 'java.util.Date';
            }
            if (strpos($rowCol['Type'], 'decimal') !== false) {
                $typ = 'float';
            }

            $noprefix = explode("_", $rowCol['Field']);
            $noprefixName = isset($noprefix[1]) ? $noprefix[1] : $noprefix[0];
            if (isset($noprefix[2])) {
                $noprefixName .= ucfirst($noprefix[2]);
            }

            fwrite($myfile, "private ".$typ." ".$noprefixName.";".PHP_EOL);
            fwrite($myfile, PHP_EOL);
        }
    }

    fwrite($myfile, " } ".PHP_EOL);

    fclose($myfile);

   
}
