# language: es
  @FeatureName:contactarServicioAlCliente
  Característica: Contactar servicio al cliente
    Como cliente en linea
    necesito contactar con servicio al cliente
    para poder comunicar mis problemas con la pagina o con mis productos.

  Antecedentes: que el cliente esta en la pagina de inicio e ingresa a la seccion de contactanos

  @ScenarioName:contactoExitoso
  Escenario: Contacto exitoso.
    Dado que el cliente esta en la pagina de inicio e ingresa a la seccion de contactanos
    Cuando el cliente registra todos los datos obligatorios para contactarse
    Entonces como resultado el usuario observara un mensaje de contacto exitoso en la pagina web.

  @ScenarioName:contactoFallidoSinMensaje
  Escenario: Contacto fallido sin el campo de mensaje.
    Dado que el cliente esta en la pagina de inicio e ingresa a la seccion de contactanos
    Cuando el cliente registra todos los datos obligatorios para contactarse menos el mensaje
    Entonces como resultado el usuario observara un mensaje de contacto fallido por falta del mensaje en la pagina web.