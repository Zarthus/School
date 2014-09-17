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

                'initialise the required variables'
                Dim wantsCheese as Boolean = cheese.checked
                Dim wantsOnions as Boolean = onions.checked
                Dim wantsHam as Boolean = ham.checked
                Dim wantsHawaii as Boolean = hawaii.checked
                Dim cost as Double = 5
                Dim tipValue as Double = CDbl(tips.value)

                Dim tipMessage as String
                Dim foodMessage as String = "Ingredients: "

                'TODO: Ternary operators (but I can't get those working in VB)'
                'check which ingredients are checked.'
                if (wantsCheese = True) 
                    foodMessage = foodMessage & "cheese, "
                    cost += 2
                end if
                if (wantsOnions = True) 
                    foodMessage = foodMessage & "onions, "
                    cost += 3.50
                end if
                if (wantsHam = True) 
                    foodMessage = foodMessage & "ham, "
                    cost += 5
                end if
                if (wantsHawaii = True) 
                    foodMessage = foodMessage & "hawaii, "
                    cost += 6
                end if
                
                if (foodMessage.length = 0 OR foodMessage.length = "Ingredients: ".length)
                    foodMessage = "No Ingredients"
                else 
                    foodMessage = foodMessage.SubString(0, foodMessage.length - 2)
                end if
                
                'Check if any tip was given'
                if (tipValue = 0)
                    tipMessage = "No tip given, the server will be sad :("
                else
                    tipMessage = "Thank you for your generous tip of €" & tipValue
                    cost += tipValue
                end if


                'Set output to bottom of screen'
                returnMessage.innerHTML = "<hr /><b>" & name.value & "</b><br />" & message.value & "<br /> "&  _
                                          "<br />" & foodMessage & "<br />Tip: " & tipMessage & "<br />Cost: €" & cost - tipValue & _
                                          "<br />Total: €" & cost

                CalendarLabel.InnerHTML = "<p>Order will be delivered on: " & Calendar.SelectedDate.ToShortDateString() & "</p>"
                'remove field values'
                name.value = ""
                message.value = ""
            end sub
        </script>
    </head>
    <body>
        <form action="msg.aspx" runat="server">
        <div>
            <h1>Order Pizza</h1>
            <input type="text" id="name" name="name" class="wide" placeholder ="Your name" runat="server" />
            <br />
            <textarea name="message" id="message" rows="10" class="wide" runat="server">Your message</textarea>
            <br />
            Cheese: <input type="checkbox" id="cheese" name="cheese" runat="server" /> (+€2.-)
            <br />
            Onions: <input type="checkbox" id="onions" name="onions" runat="server" /> (+€3.50)
            <br />
            Ham: <input type="checkbox" id="ham" name="ham" runat="server" /> (+€5.-)
            <br />
            Hawaii: <input type="checkbox" id="hawaii" name="hawaii" runat="server" /> (+€6.-)
            <br />
            Tip: €<input type="text" maxlength="5" size="3" id="tips" name="tips" value="0" runat="server" />
            <br />
            <asp:Calendar id="Calendar" runat="server"  
                 SelectionMode="Day" 
                 ShowGridLines="True">
            </asp:Calendar>
            <br />
            <input type="submit" id="btnSubmit" value="submit" runat="server" OnServerClick="btnSubmit_click"/>
        </div>
        <div id="returnMessage" runat="server">
            No order has been sent yet.
        </div>
        <div id="CalendarLabel" runat="server">
            Date: No date selected.
        </div>
        </form>
    </body>
</html>
