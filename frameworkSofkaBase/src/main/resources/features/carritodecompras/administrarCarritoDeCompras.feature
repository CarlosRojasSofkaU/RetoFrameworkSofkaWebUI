# language: es
  @FeatureName:administrarCarritoDeCompras
  Característica: Administrar carrito de compras
    Como cliente en linea
    necesito administrar mi carrito de compras
    para poder realizar la compra de productos de la tienda.

  Antecedentes:
  Dado que el cliente esta en la pagina de inicio

  @ScenarioName:compraDeProductoExitosa
  Escenario: Solicitud de compra de producto exitosa.
    Dado que el cliente se haya registrado o logueado en la plataforma
    Cuando el cliente quiere comprar un producto y realiza todas las funciones de verificacion
    Entonces como resultado el usuario observara un mensaje de solicitud de compra exitosa y un precio de orden.

  @ScenarioName:limpiarProductosDelCarrito
  Escenario: Limpiar productos del carrito de compras.
    Dado que el cliente se haya registrado o logueado en la plataforma
    Cuando el cliente quiere eliminar sus productos del carrito de compras
    Entonces como resultado el usuario observara que el carrito de compras esta vacio.