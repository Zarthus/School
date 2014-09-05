<!DOCTYPE html>
<html ng-app>
    <head>
        <title>AngularJS with API Example</title>
        <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.2.23/angular.min.js" type="text/javascript"></script>
        <script src="js/api.js" type="text/javascript"></script>
    </head>
    <body>
        <div ng-controller="ApiCallController">
            <button ng-click="callApi(0)">call api</button>
            <br />
            <ul>
                <li>
                    [{{status}}] {{message}}
                </li>
                <ul>
                    <li ng-repeat="mydata in data">
                        {{mydata}}
                    </li>
                </ul>
            </ul>
        </div>
    </body>
</html>