
# Práctica de laboratorio 01: Diseño y desarrollo de una aplicación orientada a objetos utilizando Java
## Diagrama UML
![image](https://github.com/user-attachments/assets/5e32f394-8887-410d-914b-ee7413e3f6bd)
![image](https://github.com/user-attachments/assets/2f5551fd-9764-4d76-aa9b-d7add44d209c)


## 📌 Información General

- **Título:** Práctica de laboratorio 01: Diseño y desarrollo de una aplicación orientada a objetos utilizando Java
- **Asignatura:** Programacion Orientada A Objetos
- **Carrera:** Computación
- **Estudiantes:** Mateo Eduardo Molina Chamba y Juan Pablo Ortiz Torres
- **Fecha:** 27-04-2025
- **Profesor:** Ing. Gabriel León

---

## 🛠️ Descripción
### Sistema de Gestión de Compras ERP:
Permite registrar proveedores, productos (artículos, paquetes y servicios) y empleados, así como crear y administrar solicitudes de compra. Cada solicitud puede cambiar su estado (solicitada, en revisión, aprobada o rechazada) y calcular su costo total basado en los productos asociados. La interacción con el usuario se realiza a través de un menú en consola, facilitando la consulta, registro, actualización y búsqueda de la información.

---

## 🚀 Ejecución

Para ejecutar correctamente el proyecto:

1. Compila el código:
    
2. Ejecuta la aplicación:

3. Importante ingresar, los proveedores, empelados y productos,
   antes de hacer las solicitudes de compra, o querer listar.
    
## 🧑‍💻 Ejemplo de Entrada

```plaintext
1. Registrar proveedor
2. Registrar producto
3. Registrar solicitud de compra
4. Listar proveedores
5. Listar productos
6. Listar solicitudes de compra
7. Buscar proveedor por ID
8. Buscar producto por nombre
9. Buscar solicitud por número
10. Aprobar / Rechazar solicitud de compra
11. Calcular total de una solicitud
12. Ingresar un empleado
13. Salir
Seleccione una opción: 1

Registrar proveedor
Ingrese la Empresa:
> Acme Corporation
Ingrese el nombre del proveedor:
> Juan Pérez
Ingrese el correo del proveedor:
> juan.perez@acme.com
Ingrese la cédula del proveedor:
> 1234567890

Proveedor registrado correctamente...

1. Registrar proveedor
2. Registrar producto
3. Registrar solicitud de compra
4. Listar proveedores
5. Listar productos
6. Listar solicitudes de compra
7. Buscar proveedor por ID
8. Buscar producto por nombre
9. Buscar solicitud por número
10. Aprobar / Rechazar solicitud de compra
11. Calcular total de una solicitud
12. Ingresar un empleado
13. Salir
Seleccione una opción: 2

Registrar producto
¿Qué tipo de producto desea registrar?: 
1. Artículos
2. Paquete
3. Servicios
> 1

Ingrese el código del Artículo:
> A001
Ingrese el nombre del Artículo:
> Laptop Dell XPS
Ingrese el precio unitario del Artículo:
> 1500.00
Ingrese el IVA del Producto:
> 0.16

Seleccione el tipo de producto:
1. ELECTRONICA
2. ALIMENTO
3. LIMPIEZA
4. SERVICIO
> 1

Producto registrado correctamente...

1. Registrar proveedor
2. Registrar producto
3. Registrar solicitud de compra
4. Listar proveedores
5. Listar productos
6. Listar solicitudes de compra
7. Buscar proveedor por ID
8. Buscar producto por nombre
9. Buscar solicitud por número
10. Aprobar / Rechazar solicitud de compra
11. Calcular total de una solicitud
12. Ingresar un empleado
13. Salir
Seleccione una opción: 3

Fecha de Solicitud-----
Ingrese el día de la fecha de la solicitud:
> 15
Ingrese el mes de la fecha de la solicitud: (1-12)
> 4
Ingrese el año de la fecha de la solicitud:
> 2025

Detalles de compra
Ingrese el código del producto a agregar:
> A001

Producto encontrado: Laptop Dell XPS
Cantidad:
> 2
Descripción:
> Laptops para el equipo de desarrollo

Producto agregado al detalle de compra.

¿Desea agregar otro producto? (Si/No)
> Si

Ingrese el código del producto a agregar:
> P002

Producto encontrado: Paquete de Oficinas Básico
Cantidad:
> 1
Descripción:
> Paquete de muebles para la nueva sucursal

Producto agregado al detalle de compra.

¿Desea agregar otro producto? (Si/No)
> No

Solicitud de compra registrada correctamente...


1. Registrar proveedor
2. Registrar producto
3. Registrar solicitud de compra
4. Listar proveedores
5. Listar productos
6. Listar solicitudes de compra
7. Buscar proveedor por ID
8. Buscar producto por nombre
9. Buscar solicitud por número
10. Aprobar / Rechazar solicitud de compra
11. Calcular total de una solicitud
12. Ingresar un empleado
13. Salir
Seleccione una opción: 9

Ingrese el número de la solicitud de compra que desea buscar:
> 1001

Solicitud encontrada:
- Número de solicitud: 1001
- Fecha: 15/04/2025
- Productos:
  - Laptop Dell XPS (Cantidad: 2) - Laptops para el equipo de desarrollo
  - Paquete de Oficinas Básico (Cantidad: 1) - Paquete de muebles para la nueva sucursal
- Estado: Pendiente


1. Registrar proveedor
2. Registrar producto
3. Registrar solicitud de compra
4. Listar proveedores
5. Listar productos
6. Listar solicitudes de compra
7. Buscar proveedor por ID
8. Buscar producto por nombre
9. Buscar solicitud por número
10. Aprobar / Rechazar solicitud de compra
11. Calcular total de una solicitud
12. Ingresar un empleado
13. Salir
Seleccione una opción: 10

Ingrese el número de la solicitud de compra que desea aprobar o rechazar:
> 1001

Solicitud encontrada:
- Número de solicitud: 1001
- Estado actual: Pendiente

¿Qué acción desea realizar?
1. Aprobar
2. Rechazar
Seleccione una opción:
> 1

La solicitud de compra ha sido aprobada exitosamente.


1. Registrar proveedor
2. Registrar producto
3. Registrar solicitud de compra
4. Listar proveedores
5. Listar productos
6. Listar solicitudes de compra
7. Buscar proveedor por ID
8. Buscar producto por nombre
9. Buscar solicitud por número
10. Aprobar / Rechazar solicitud de compra
11. Calcular total de una solicitud
12. Ingresar un empleado
13. Salir
Seleccione una opción: 9

Ingrese el número de la solicitud de compra que desea buscar:
> 1001

Solicitud encontrada:
- Número de solicitud: 1001
- Fecha: 15/04/2025
- Productos:
  - Laptop Dell XPS (Cantidad: 2) - Laptops para el equipo de desarrollo
  - Paquete de Oficinas Básico (Cantidad: 1) - Paquete de muebles para la nueva sucursal
- Estado: Aprobada

1. Registrar proveedor
2. Registrar producto
3. Registrar solicitud de compra
4. Listar proveedores
5. Listar productos
6. Listar solicitudes de compra
7. Buscar proveedor por ID
8. Buscar producto por nombre
9. Buscar solicitud por número
10. Aprobar / Rechazar solicitud de compra
11. Calcular total de una solicitud
12. Ingresar un empleado
13. Salir
Seleccione una opción: 9

Ingrese el número de la solicitud de compra que desea buscar:
> 1001

Solicitud encontrada:
- Número de solicitud: 1001
- Fecha: 15/04/2025
- Productos:
  - Laptop Dell XPS (Cantidad: 2) - Laptops para el equipo de desarrollo
  - Paquete de Oficinas Básico (Cantidad: 1) - Paquete de muebles para la nueva sucursal
- Estado: Pendiente








