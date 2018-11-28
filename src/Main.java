
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {

    Stage window;
    TableView<Product> table;
    TextField labelInput, latInput, longitudeInput, heightInput, typeInput;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        window = primaryStage;
        window.setTitle("UI Interface - JavaFX");
        window.setMaxWidth(700);



        //Name column
        TableColumn<Product, String> labelColumn = new TableColumn<>("Label");
        labelColumn.setMinWidth(100);
        labelColumn.setCellValueFactory(new PropertyValueFactory<>("label"));

        //Price column
        TableColumn<Product, Double> latColumn = new TableColumn<>("Lat");
        latColumn.setMinWidth(100);
        latColumn.setCellValueFactory(new PropertyValueFactory<>("lat"));

        //Quantity column
        TableColumn<Product, String> longitudeColumn = new TableColumn<>("Long");
        longitudeColumn.setMinWidth(100);
        longitudeColumn.setCellValueFactory(new PropertyValueFactory<>("long"));

        //Height column
        TableColumn<Product, String> heightColumn = new TableColumn<>("Height");
        heightColumn.setMinWidth(100);
        heightColumn.setCellValueFactory(new PropertyValueFactory<>("height"));

        //Type clumn
        TableColumn<Product, String> typeColumn = new TableColumn<>("Point Type");
        typeColumn.setMinWidth(100);
        typeColumn.setCellValueFactory(new PropertyValueFactory<>("point type"));

        //Primary column








        //Name input
        labelInput = new TextField();
        labelInput.setPromptText("Label");
        labelInput.setMinWidth(50);

        //Price input
        latInput = new TextField();
        latInput.setPromptText("Lat");
        latInput.setMinWidth(50);


        //Quantity input
        longitudeInput = new TextField();
        longitudeInput.setPromptText("Longitude");
        longitudeInput.setMinWidth(50);

        //Height input
        heightInput = new TextField();
        heightInput.setPromptText("Height");
        heightInput.setMinWidth(50);

        //Point Type input
        typeInput = new TextField();
        typeInput.setPromptText("Point Type");
        typeInput.setMinWidth(50);



        //Button
        Button addButton = new Button("Add");
        addButton.setOnAction(e -> addButtonClicked());
        Button deleteButton = new Button("Delete");
        deleteButton.setOnAction(e -> deleteButtonClicked());

        HBox hBox = new HBox();
        hBox.setPadding(new Insets(10,10,10,10));
        hBox.setSpacing(10);
        hBox.getChildren().addAll(labelInput, latInput, longitudeInput, heightInput, typeInput, addButton, deleteButton);

        table = new TableView<>();
        table.setItems(getProduct());
        table.getColumns().addAll(labelColumn, latColumn, longitudeColumn, heightColumn, typeColumn);

        VBox vBox = new VBox();
        vBox.setPadding(new Insets(10, 10, 10, 10));
        vBox.getChildren().addAll(table, hBox);

        Scene scene = new Scene(vBox);
        window.setScene(scene);
        window.show();
    }

    //Add button clicked
    public void addButtonClicked(){
        Product product = new Product();
        product.setLabel(labelInput.getText());
        product.setLat(Double.parseDouble(latInput.getText()));
        product.setLongitude(Integer.parseInt(longitudeInput.getText()));
        product.setHeight(Integer.parseInt(heightInput.getText()));
        product.setType(typeInput.getText());

        table.getItems().add(product);
        labelInput.clear();
        latInput.clear();
        longitudeInput.clear();
        heightInput.clear();
        typeInput.clear();

    }

    //Delete button clicked
    public void deleteButtonClicked(){
        ObservableList<Product> productSelected, allProducts;
        allProducts = table.getItems();
        productSelected = table.getSelectionModel().getSelectedItems();

        productSelected.forEach(allProducts::remove);
    }


    //Get all of the products
    public ObservableList<Product> getProduct(){
        ObservableList<Product> products = FXCollections.observableArrayList();
        products.add(new Product("Laptop", 859.00, 20));
        products.add(new Product("Bouncy Ball", 2.49, 198));
        products.add(new Product("Toilet", 99.00, 74));
        products.add(new Product("The Notebook DVD", 19.99, 12));
        products.add(new Product("Corn", 1.49, 856));
        return products;
    }




}