<!DOCTYPE html>
<html ng-app>
    <head>
        <title>AngularJS with API Example</title>
        <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.2.23/angular.min.js" type="text/javascript"></script>
        <script src="js/api.js" type="text/javascript"></script>
    </head>
    <body>
        <div ng-controller="ApiCallController">
            <button ng-click="callApi('')">call api - no GET info</button> - 
            <button ng-click="callApi('api_key=0999001&student_id=1&command=account')">call api - account info</button> - 
            <button ng-click="callApi('api_key=0999001&student_id=1&command=teacher')">call api - teacher info</button> - 
            <button ng-click="callApi('api_key=0999001&student_id=1&command=class')">call api - class info</button>
            <br />
            <ul>
                <li>
                    [{{status}}] {{message}}
                </li>
                <ul>
                    <li ng-repeat="(key, value) in data">
                        {{key}}: {{value}}
                    </li>
                </ul>
            </ul>
        </div>
    </body>
</html>