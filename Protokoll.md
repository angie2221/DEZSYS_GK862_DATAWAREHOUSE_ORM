- **What is ORM and how is JPA used?**

  ORM helps translating Data between Object-Oriented programming Languages and relational Databases. Objects are mapped as entities and imported as for example, tables and so on . JPA in Java is defined as the Java Persistence API onsists of Java specification for accessing, persisting, and
  maintaining data between Java objects and related databases. JPA maps Entities to the corresponding Tables in the relational Database.

- **What is the application.properties used for and where must it be stored?**

  [application.properties](http://application.properties) is located in the resources folder in a spring-boot project and establishes all important URLS or configurations required for the database connection.

- **Which annotations are frequently used for entity types? Which key points must be observed?**

  **@ID** marks the primary Key for the Table

  @**ManyToOne/OnetoMany, etc. establishes the Relationship between two Tables**

- **What methods do you need for CRUD operations?**

  POST, GET, PUT, DELETE


## Aufgabenprotokoll

Für diese Aufgabe habe ich mich für eine POSTGRESSQL-Datenbank entschieden. Zuerst habe ich in PGAdmin eine neue Datenbank angelegt, und danach bin ich den Tutorial was in der Angabe gegeben ist gefolgt. Hier gab es keine großen Probleme.

**Fehler 1: “Syntax Error near user”**

**Lösung**: Da das Wort “user” in postgressql reserviert ist, musste ich also den Tabellennamen ergänzen, dies habe ich über die “@Table” Annotation getan.

![image.png](attachment:c4192bfc-6eb2-4734-a0d1-b6cdf02bec65:image.png)

### [Application.properties](http://Application.properties):

`spring.datasource.url=jdbc:postgresql://localhost:5432/spring_ORM`

`spring.datasource.username=anonym`

`spring.datasource.password=anonym`

`spring.datasource.driver-class-name=org.postgresql.Driver`

`spring.jpa.hibernate.ddl-auto=updates`

`pring.jpa.show-sql=true`

## Entities & Controller

In einer **Entity** werden alle Parameter für eine Tabelle festgelegt. Eine Entity wird in Java Spring-Boot Application mit @Entity gekennzeichnet.

![image.png](attachment:ca09eb5c-3312-4280-a60f-86c1c2fb9678:image.png)

Um eine Relation herzustellen sind die Annotationen **@OneToMany @ManyToOne** verfügbar. Das ist die WarehouseEntity-Klasse. **Jedes Warehouse hat mehrere Produkte/Einkäufe / alle Produkte sind ein Warehouse zugewiesen.**

In Controller werden alle CRUD-Operationen und Rest-Schnittstellen festgelegt. **Bei der GK & bei der Anlegung von Daten gab es keine Probleme!**

# EK

- Extend the Data Warehouse repository with following functionalities:
    - Collect all data of one data warehouse specified by datawarehouseID.

  ![image.png](attachment:c349d41b-2a98-4e66-b4c5-dfde035d189c:image.png)

    - Collect a single product of a data warehouse specified by datawarehouseID and productID.

  ![image.png](attachment:a2584bb1-f601-4ebe-832c-659eb7b97597:image.png)

    - Update a data warehouse using datawarehouseID.

  ![image.png](attachment:cf0566c5-b817-41cd-9f1e-a6bb5f738eb0:image.png)

- Document the parts of your project which have to be extend

  Bei der WarehouseRepository musste ich es um das Element .CrudRepository erweitern, was dann so aussieht:
  `public interface WarehouseRepository extends org.springframework.data.repository.CrudRepository<Warehouse, String>`


**Fehler:** Ein Problem das aufgetreten ist, ist dass ich mir nicht denken konnte wie ich die Crud-Methoden gegeben von CrudRepository effektiv umsetze ohne das es zuviel Code-Aufwand gibt. Dafür hab ich eine neue Klasse ‘WarehouseData’ erstellt.

## Vertiefung

Um so schnell wie möglich viele Daten zu erstellen, habe ich mich entschieden ein Java Seeder zu machen, wo zufällige Kunden und Produkte eingetragen werden.

**Ollama:**

Bei Ollama hatte ich viele Probleme, zb dass ich aufgrund meiner Computer-Performance nur ein kleineres Modell verwenden konnte.

**Ollama Setup:**

ollama pull phi

ollama run phi

**Prompt & Ergebnis:**

![image.png](attachment:96991627-b11b-4de9-944d-02fb1fbda2d8:image.png)

Wie man hier sieht musste ich mein Prompt SEHR einschränken. Mit den ganzen 300 Purchase-Records konnte die AI garnicht arbeiten. Und nur mit fünf Purchase records auch nicht. Also musste ich mich sehr einschränken und musste sogar die Rechnung vorgegeben.

**Lösung:** Besseres, größeres Model. Service/Controller/Spring AI integrieren