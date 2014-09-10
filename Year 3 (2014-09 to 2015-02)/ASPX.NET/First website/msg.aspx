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

        <script runat="server">
            sub btnSubmit_click(s As Object, e As EventArgs)
                'Ordering a pizza'

                'Check if want cheese'
                Dim wantsCheese as Boolean 
                Dim cheeseMsg as String 
                wantsCheese = cheese.checked
                 
                if (wantsCheese = True)
                    cheeseMsg = "yes"
                else
                    cheeseMsg = "no"
                end if
                
                'Set output to bottom of screen        
                returnMessage.innerHTML = "<hr /><b>" & name.value & "</b><br />" & message.value & "<br /> Cheese: " & cheeseMsg 

                'remove field values'
                name.value = ""
                message.value = ""
            end sub
        </script>
    </head>
    <body>
        <form action="msg.aspx" method="get" runat="server">
        <div>
            <h1>Order Pizza</h1>
            <input type="text" id="name" name="name" class="wide" placeholder ="Your name" runat="server" />
            <br />
            <textarea name="message" id="message" rows="10" class="wide" runat="server">Your message</textarea>
            <br />
            Cheese: <input type="checkbox" id="cheese" name="cheese" runat="server" />
            <br />
            <input type="submit" id="btnSubmit" value="submit" runat="server" OnServerClick="btnSubmit_click"/>
        </div>
        <div id="returnMessage" runat="server">
        </div>
        </form>
    </body>
</html>
