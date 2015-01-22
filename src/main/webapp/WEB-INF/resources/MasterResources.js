var application = angular.module('application',[]);

application.controller('Clientes',function($scope,$http){

	$scope._id = null;
	$scope.nombre = "";
	$scope.apellido = "";
	$scope.domicilio = "";
	$scope.telefono = "";
	$scope.email = "";
	$scope.clientes = [];

	$scope.cargarClientes = function(){

		$http({
			method: 'GET', url: '/DemoAngular/regitData'
		}).success(function(data){
			if(typeof(data) == 'object'){
				$scope.clientes = data;
			}else{
				alert('ERROR AL RECUPERAR PERSONAS');
			}
		}).error(function(){
			alert('ERROR AL RECUPERAR PERSONAS');
		});
	};

	//Funci�n guardar clientes
	$scope.guardarCliente = function(){

		$http({
			method: 'POST',
			url: '/guardar',
			params:{
				nombre: $scope.nombre,
				apellido: $scope.apellido,
				domicilio: $scope.domicilio,
				telefono: $scope.telefono,
				email: $scope.email,
				_id: $scope._id
			}
		}).success(function(data){
			if(typeof(data) == 'object'){
				$scope.limpiarDatos();
				$scope.cargarClientes();
			}else{
				alert('ERROR AL INTENTAR GUARDAR EL CLIENTE');
			}
		}).error(function(){
			alert('ERROR AL INTENTAR GUARDAR EL CLIENTE');
		});

	};

	//Funcion recuperar cliente
	$scope.recuperarCliente = function(indice){
		$http({
			method: 'GET',
			url: '/recuperar',
			params:{
				_id: indice
			}
		}).success(function(data){
			if(typeof(data) == 'object'){
				$scope._id = data._id;
				$scope.nombre = data.nombre;
				$scope.apellido = data.apellido;
				$scope.domicilio = data.domicilio;
				$scope.telefono = data.telefono;
				$scope.email = data.email;
			}else{
				alert('ERROR AL INTENTAR RECUPERAR CLIENTE');
			}
		}).error(function(){
			alert('ERROR AL INTENTAR RECUPERAR CLIENTE');
		});
	};

	//Funci�n eliminar que recibe por par�metro el �ndice
	$scope.eliminarCliente = function(indice){

		$http({
			method: 'POST',
			url: '/eliminar',
			params: {
				_id: indice
			}
		}).success(function(data){
			if(data == 'Ok'){
				$scope.limpiarDatos();
				$scope.cargarClientes();
			}else{
				alert("ERROR AL ELIMINAR EL CLIENTE");
			}
		}).error(function(){
			alert("ERROR AL ELIMINAR EL CLIENTE");
		});

	};

	//Funci�n que limpia datos
	$scope.limpiarDatos = function(){
		$scope._id = null;
		$scope.nombre = "";
		$scope.apellido = "";
		$scope.domicilio = "";
		$scope.telefono = "";
		$scope.email = "";
	};

})