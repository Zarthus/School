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
        <form action="HTML2ASPX.aspx" method="get" runat="server">
        <div>
            <h1>Order Pizza</h1>
            <input type="text" id="name" name="name" class="wide" placeholder ="Your name" runat="server" />
            <br />
            <textarea name="message" id="message" rows="10" class="wide" runat="server">Your message</textarea>
            <br />
            Cheese: <input type="checkbox" id="cheese" name="cheese" value="yes" runat="server" />
            <br />
            <input type="submit" id="btnSubmit" value="submit" runat="server" />
        </div>
        </form>
    </body>
</html>
