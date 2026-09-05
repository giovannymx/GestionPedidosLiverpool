db = db.getSiblingDB('liverpool_db');

db.createCollection('users');

db.users.insertMany([
  {
    userId: "usr_001",
    nombre: "Carlos",
    apellidoPaterno: "Gómez",
    apellidoMaterno: "López",
    correoElectronico: "carlos.gomez@example.com",
    direccionEnvio: "Av. Insurgentes Sur 123, CDMX",
    orders: ["ord_101", "ord_102"]
  },
  {
    userId: "usr_002",
    nombre: "María",
    apellidoPaterno: "Hernández",
    apellidoMaterno: "Reyes",
    correoElectronico: "maria.reyes@example.com",
    direccionEnvio: "Calle Liverpool 45, Polanco, CDMX",
    orders: ["ord_103"]
  }
]);