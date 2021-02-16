package ru.sapteh.Controller;

import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ru.sapteh.DAO.DAO;
import ru.sapteh.Model.Manufacture;
import ru.sapteh.Model.Product;
import ru.sapteh.Model.ProductSale;
import ru.sapteh.Service.ManufactureService;
import ru.sapteh.Service.ProductSaleService;
import ru.sapteh.Service.ProductService;


import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Date;
import java.util.List;

public class WindowViewController {
    ObservableList<Manufacture> manufactureObservableList = FXCollections.observableArrayList();
    ObservableList<Product> productObservableList = FXCollections.observableArrayList();
    ObservableList<ProductSale> productSaleObservableList = FXCollections.observableArrayList();
    SessionFactory factory = new Configuration().configure().buildSessionFactory();

    @FXML
    private TableView<Manufacture> ManufactureTableView;

    @FXML
    private TableColumn<Manufacture, Integer> idManufactureColumn;

    @FXML
    private TableColumn<Manufacture, String> nameManufactureColumn;

    @FXML
    private TableColumn<Manufacture, Date> startDateManufactureColumn;

    @FXML
    private TableView<Product> productTableView;

    @FXML
    private TableColumn<Product, Integer> idProductColumn;

    @FXML
    private TableColumn<Product, String> titleProductColumn;

    @FXML
    private TableColumn<Product, Integer> costProductColumn;

    @FXML
    private TableColumn<Product, String> descriptionProductColumn;

    @FXML
    private TableColumn<Product, String> imagePathProductColumn;

    @FXML
    private TableColumn<Product, Integer> isActiveProductColumn;

    @FXML
    private TableColumn<Product, Integer> manufactureProductColumn;

    @FXML
    private TableView<ProductSale> productSaleTableView;

    @FXML
    private TableColumn<ProductSale, Date> saleDateProductSaleColumn;

    @FXML
    private TableColumn<ProductSale, Integer> productIdProductSaleColumn;

    @FXML
    private TableColumn<ProductSale, Integer> qouantityProductSaleColumn;

    @FXML
    private Button createManufactureButton;

    @FXML
    private Button deleteManufactureButton;

    @FXML
    private Button updateManufactureButton;

    @FXML
    private Button createProductButton;

    @FXML
    private Button deleteProductButton;

    @FXML
    private Button updateProductButton;

    @FXML
    private Button createProductSaleButton;

    @FXML
    private Button deleteProductSaleButton;

    @FXML
    private Button updateProductSaleButton;


    @FXML
    public void initialize(){
        createManufactureButton.setOnAction(event -> {
                    createManufactureButton.getScene().getWindow();
                    try {
                        URL url = new File("C:/Users/student/Desktop/work16.02/src/main/java/ru/sapteh/View/CreateManufactureView.fxml").toURI().toURL();
                        Parent root = FXMLLoader.load(url);
                        Stage stage = new Stage();
                        stage.setTitle("Window");
                        stage.setScene(new Scene(root));
                        stage.show();
                    } catch (MalformedURLException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }


            DAO<Manufacture,Integer> manufactureIntegerDAO = new ManufactureService(factory);
      List<Manufacture> manufactureList = manufactureIntegerDAO.readAllBy();
        manufactureObservableList.addAll(manufactureList);

        idManufactureColumn.setCellValueFactory(p->new SimpleObjectProperty<>(p.getValue().getId()));
        nameManufactureColumn.setCellValueFactory(p->new SimpleObjectProperty<>(p.getValue().getName()));
        startDateManufactureColumn.setCellValueFactory(p->new SimpleObjectProperty<>(p.getValue().getStartDate()));
        ManufactureTableView.setItems(manufactureObservableList);

        DAO<Product,Integer> productIntegerDAO = new ProductService(factory);
        List<Product> productList = productIntegerDAO.readAllBy();
        productObservableList.addAll(productList);

        idProductColumn.setCellValueFactory(p->new SimpleObjectProperty<>(p.getValue().getId()));
        titleProductColumn.setCellValueFactory(p->new SimpleObjectProperty<>(p.getValue().getTitle()));
        costProductColumn.setCellValueFactory(p->new SimpleObjectProperty<>(p.getValue().getCost()));
        descriptionProductColumn.setCellValueFactory(p->new SimpleObjectProperty<>(p.getValue().getDescription()));
        imagePathProductColumn.setCellValueFactory(p->new SimpleObjectProperty<>(p.getValue().getMainImagePath()));
        isActiveProductColumn.setCellValueFactory(p->new SimpleObjectProperty<>(p.getValue().getIsActive()));
        manufactureProductColumn.setCellValueFactory(p->new SimpleObjectProperty<>(p.getValue().getIsActive()));
        productTableView.setItems(productObservableList);

        DAO<ProductSale,Integer> productSaleIntegerDAO = new ProductSaleService(factory);
        List<ProductSale> productSalesList = productSaleIntegerDAO.readAllBy();
        productSaleObservableList.addAll(productSalesList);

        saleDateProductSaleColumn.setCellValueFactory(p->new SimpleObjectProperty<>(p.getValue().getDateTime()));
        productIdProductSaleColumn.setCellValueFactory(p->new SimpleObjectProperty<>(p.getValue().getId()));
        qouantityProductSaleColumn.setCellValueFactory(p->new SimpleObjectProperty<>(p.getValue().getQuantity()));

        productSaleTableView.setItems(productSaleObservableList);

    }


}
