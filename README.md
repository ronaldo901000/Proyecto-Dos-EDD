# Gestor de Supermercado
Sistema formado por un grafo ponderado, donde cada sucursal es un vertice y las conexiones son aristas. Gestion de productos e inventario independiente para cada sucursal, con trasferencia de productos entre ellas.  



**Autor:**  Ronaldo Hilario

---

#Requerimientos

- Java 21
- Graphviz raphviz version 2.43.0 (Sugerido)

##Estructuras Implementadas desde Cero
- Arbol AVL 
- Arbol B 
- Arbol B+ 
- Tabla Hash 
- Lista enlazada 
- Pila
- Cola 
- Grafo dirigido ponderado 


##Funcionalidades

- Gestión de sucursales (agregar, editar, eliminar)
- Inserción de productos desde archivos CSV
- Transferencia de productos entre sucursales por menor tiempo o menor costo
- Análisis comparativo de rendimiento entre estructuras (en microsegundos)
- Visualización gráfica de árboles y grafo con Graphviz


## Formato de archivos CSV

**Sucursales.csv**
id,nombre,ubicacion,tiempo_ingreso,tiempo_traspaso,intervalo_despacho

**Conexiones.csv**
origen,destino,tiempo,costo

**Inventario.csv**
SucursalID,Nombre,CodigoBarra,Categoria,FechaCaducidad,Marca,Precio,Stock

##Ejecucion

java -jar GestorSupermercado-1.0-SNAPSHOT-jar-with-dependencies.jar

