# Product Project
## OOP product line project

This is my first project of OOP (COP 3003), a simple JavaFX window that shows a product log, product line, and products

# Sprint 1
## Week 1 Expectations
- [x] Create JavaFX FXML project using Gradle
- [x] Share to private repository on GitHub
- [x] Create README
## Week 2 Expectations
- [x] Add a tab view with three tabs: Product Line, Produce, and Production Log
- [x] Add a CSS file with some code
## Week 3 Expectations 
* Product Line tab
- [x] In the AnchorPane
- [x] Add a 2x3 GridPane
- [x] Add a Label and text field for Product Name in row 0, columns 0 and 1
- [x] Add a Label and text field for Manufacturer in row 1, columns 0 and 1
- [x] Add a Label and ChoiceBox for Item Type in row 2, columns 0 and 1
- [x] Add a Button that says Add Product
- [x] Add an event handler to the button click event. For now, just have it print to the console (System.out.println)
- [x] Add a Label and a Table View for Existing Products
* Produce tab
- [x] In the AnchorPane
- [x] Add a Label and ListView for Choose Product
- [x] Add a Label and ComboBox (data type String) for Choose Quantity
- [x] Add a Button that says Record Production
* Production Log tab
- [x] In the AnchorPane
- [x] Add a TextArea
## Week 4 Expectations

- [x] Install database software if necessary
- [ ] Connect to database 
* If not using Gradle or Maven, to make your program more portable, copy the H2 driver jar file from its install location (likely Program Files (x86) H2 bin), paste it into your res folder, and set this location in the IntelliJ Project Structure (Modules -> Dependencies).  
 
## Week 5 EXpectations 
- [ ] In the Product Line tab, for the Add Product button event handler, add code to insert a product into the database
* Hard code this statement INSERT INTO Product(type, manufacturer, name) VALUES ( 'AUDIO', 'Apple', 'iPod' );
- [ ] Build the sql statement by getting the values from the user interface.
- [ ] (To avoid a FingBugs error) Use a Prepared Statement.
- [ ] Output the full list of products to the console. 
- [ ] In the Produce tab, for the ComboBox:
* Populate with values 1-10 in an initialize method in the Controller
* To allow the users to enter other values in the combobox, call the method setEditable(true);
* To show a default value, call the method getSelectionModel().selectFirst();
* Prepare for submission
