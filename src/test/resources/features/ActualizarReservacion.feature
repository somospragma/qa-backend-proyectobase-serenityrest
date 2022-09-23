# language: es

  Característica: Actualizar Reserva
    yo como recepcionista necesito poder actualizar las reservas de los usuarios


    Escenario: Actualizacion exitosa
      Dado El recepcionista cuenta con la informacion actualizar y autenticado
      Cuando El recepcionista realiza la actualizacion de la reserva
      Entonces Recibe un codigo de confirmacion y la informacion actualizada