para instalar ejecutar el siguiente comando en la carpeta o importar con algun IDE de java como proyecto maven

mvn install

Para ver los datos se puede consultar las siguientes url con postman o desde la web
http://localhost:8088/securityapp/api/parametros
http://localhost:8088/securityapp/api/parametro/{Nombre del parametro}

http://localhost:8088/securityapp/api/tipousuarios

http://localhost:8088/securityapp/api/usuarios
http://localhost:8088/securityapp/api/usuario/{username}
http://localhost:8088/securityapp/api/usuario/login    --para prueba de logueo
{
	"user": "jc3",
	"password": "123123"
	
}

http://localhost:8088/securityapp/api/usuario     -- POST para crear usuario
{
    "loginUsr": "jc4",
    "namesUsr": "juan carlosa",
    "pwdUsr": "123123",
    "typeusr": "1"
}



http://localhost:8088/securityapp/api/usuario/jc3  --- DELETE para  borrar usuario
