<%@ Page Language="VB" %>

<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8" />
        <title>HTML 2 ASP</title>
        <style type="text/css">
            .wide {
                width: 175px;
            }
        </style>
    </head>
    <body>
        <form action="" method="get">
        <div>
            <h1>Order Pizza</h1>
            <input type="text" name="name" class="wide" placeholder ="Your name" />
            <br />
            <textarea name="message" rows="10" class="wide">Your message</textarea>
            <br />
            Cheese: <input type="checkbox" name="cheese" value="yes" />
            <br />
            <input type="submit" name="submitted" value="submit" />
        </div>
        </form>
    </body>
</html>
