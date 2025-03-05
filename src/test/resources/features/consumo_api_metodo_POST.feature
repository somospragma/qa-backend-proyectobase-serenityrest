#language: es

@TAG-FEATURE
Característica: Consumo básico de un servicio con método POST

  @TAG-TES01
  Esquema del escenario: <testId> Consumo der servicio con método POST Básico
    Dado que se genera la informacion necesaria para el consumo del servicio post
      | name   | job   |
      | <name> | <job> |
    Cuando se realiza el consumo del servicios con los parametros necesarios
    Entonces Debe responder de manera correcta con datos para ser revisados
      | name   | job   | id   | createdAt   | statusResponse   |
      | <name> | <job> | <id> | <createdAt> | <statusResponse> |
    Ejemplos:
      | name  | job        | id | createdAt | statusResponse |
      | User  | Automation | OK | OK        | 201            |
      #| null  | Automation | NA | NA        | 201            |
      #| empty | Automation | NA | NA        | 201            |
      #| User  | null       | NA | NA        | 201            |
      #| User  | empty      | NA | NA        | 201            |
