#language: es

@TAG-FEATURE
Característica: Consumo básico de un servicio con método DELETE

  @TAG-TES01
  Esquema del escenario: <testId> Consumo der servicio con método DELETE Básico
    Cuando se realiza el consumo del servicios delete con dato
      | user   |
      | <user> |
    Entonces Debe responder de manera correcta eliminando el usuario
      | statusResponse   |
      | <statusResponse> |
    Ejemplos:
      | testId    | user | statusResponse |
      | testId001 | 4    | 204            |
