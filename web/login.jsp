<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Employee Login Form</title>
<link rel="stylesheet" type="text/css" href="styles.css" />
</head>
<body class="login-page">
    <div class="login-container">
        <h2>Employee Login Form</h2>
        <form action="LoginController" method="post">
            <table>
                <tr>
                    <td>UserName</td>
                    <td><input type="text" name="username" /></td>
                </tr>
                <tr>
                    <td>Password</td>
                    <td><input type="password" name="password" /></td>
                </tr>
            </table>
            <br>
            <input type="submit" value="Submit" />
        </form>
    </div>
</body>
</html>
