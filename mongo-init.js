db = db.getSiblingDB('liverpool_db');

db.createCollection('users');

db.users.insertMany([
  {
    userId: "75c97531-abf5-4524-8107-90aa48d08efc",
    nombre: "Marcela",
    apellidoPaterno: "Méndez",
    apellidoMaterno: "Gallardo",
    correoElectronico: "marce.mendez@example.com",
    direccionEnvio: "Av. Popocatepetl 77, CDMX",
    orders: [
      { orderRef: "3010091676" },
      { orderRef: "30100916760987" },
      { orderRef: "632005897" }
    ]
  },
  {
    userId: "aa2ae8bf-6b32-45dc-bb69-14e899bd8fed",
    nombre: "Carlo",
    apellidoPaterno: "Quevedo",
    apellidoMaterno: "Mendez",
    correoElectronico: "carlo.quevedo@example.com",
    direccionEnvio: "Manuel Navarrete 49, Algarin, CDMX",
    orders: [
      { orderRef: "20251216366900020031" }
    ]
  },
  {
    userId: "b446eb39-84fc-46e2-923b-91771d806c38",
    nombre: "Giovanny",
    apellidoPaterno: "Quevedo",
    apellidoMaterno: "Gómez",
    correoElectronico: "giovanny.quevedo@example.com",
    direccionEnvio: "Manuel Navarrete 49, Algarin, CDMX",
    orders: [
      { orderRef: "20251208711700070401" }
    ]
  },
  {
    userId: "f6ec8262-7017-4532-a382-70c86e7844fc",
    nombre: "Lamine",
    apellidoPaterno: "Yamal",
    apellidoMaterno: "Garcia",
    correoElectronico: "lamine.yamal@example.com",
    direccionEnvio: "Reforma 222, Algarin, CDMX",
    orders: [
      { orderRef: "4550129455" }
    ]
  },
  {
    userId: "12665a1b2c3d4e5f6a7b8c9d0e",
    nombre: "Luis",
    apellidoPaterno: "Diaz",
    apellidoMaterno: "Marulanda",
    correoElectronico: "luis.diaz@example.com",
    direccionEnvio: "Bayern Munchesn 777, Berlin, Alemania",
    orders: [
      { orderRef: "301009163489" }
    ]
  }
]);