angular.module('app.controllers', [])
  
.controller('clinicInfoCtrl', function($scope, $http) {
    $http.get('http://localhost:8080/jax_Rest1/rest/Hello').then(function(response){
        $scope.clinicAddress = response.data.clinicAddress;
        $scope.clinicPhone = response.data.clinicPhone;
        $scope.clinicName = response.data.clinicName;
        $scope.clinicHours = response.data.clinicHours;
        $scope.clinicEmail = response.data.clinicEmail;
        console.log(response.data);
    
    }, function(error){
    //there was an error fetching from the server
    });

})
   
.controller('submitVitalsCtrl', function($scope, $http) {
    $scope.sd = "tacos";
    
    $scope.giveResponse = function(resp){
        if(resp == 'Yes'){
            return "Loan amount is approved"
        }
        else{
            return "Sorry! Your loan is not approved"
        }
    }  
    var v = this;
    v.submitVitals = function(){
        console.log(v.name);
        console.log(v.amount);
    var link = 'http://localhost:8080/jax_Rest1/rest/Hello?' + "name=" + v.name + "&" + "amount" + v.amount;
        
    $http.get(link).then(function (response){
        $scope.status = $scope.giveResponse(response.data.status);
        });
    }
})
    