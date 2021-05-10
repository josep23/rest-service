# spring-api-sample

curl -X POST -d '{"heroe_id":"1", "nombre":"Roadhog","vida":"600","rol":"Tank"}' -H "Content-Type: application/json" http://localhost:8080/api/Heroes

curl http://localhost:8080/api/Heroes

curl -X PUT -H "Content-Type: application/json" -d '{"heroe_id":"1", "nombre":"Roadhog","vida":"600","rol":"Tank"}' http://localhost:8080/Heroes/1

curl -X DELETE http://localhost:8080/Heroes/1



curl -X POST -d '{"id_habilidades":"1", "nombre_habilidad":"Gancho","cooldown":"8","heroe_id":"1"}' -H "Content-Type: application/json" http://localhost:8080/api/habilidades

curl http://localhost:8080/api/habilidades/1

curl -X PUT -H "Content-Type: application/json" -d '{"id_habilidades":"1", "nombre_habilidad":"Gancho","cooldown":"8","heroe_id":"1"}' http://localhost:8080/habilidades/1

curl -X DELETE http://localhost:8080/habilidades/1



curl -X POST -d '{"persona_id":"1", "fullname":"Josep","cooldown":"8","heroe_id":"1"}' -H "Content-Type: application/json" http://localhost:8080/api/persona

curl http://localhost:8080/api/persona/1

curl -X PUT -H "Content-Type: application/json" -d '{"persona_id":"1", "fullname":"Josep","cooldown":"8","heroe_id":"1"}' http://localhost:8080/persona/1

curl -X DELETE http://localhost:8080/persona/1