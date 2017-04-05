<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->
<html>
    <head>
        <title>Register to Project Antwerp</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>
        <div align="center"><h1>Registration</h1></div>
        <form name="register" action="registerConfirm.jsp" method="POST">
            <table  align="center">
                <tbody>
                    <tr>
                        <td>Username</td>
                        <td><input type="text" name="regusername"  /></td>
                    </tr>
                    <tr>
                        <td>Email</td>
                        <td><input type="text" name="regemail"  /></td>
                    </tr>
                    <tr>
                        <td>Password</td>
                        <td><input type="password" name="regpassword" /></td>
                    </tr>
                    <tr>
                        <td colspan="2" align="center"><input type="submit" value="Register" /></td>                        
                    </tr>    
                </tbody>
            </table>

        </form>
    </body>
</html>
