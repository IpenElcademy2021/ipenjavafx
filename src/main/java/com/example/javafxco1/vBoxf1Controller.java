package com.example.javafxco1;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class vBoxf1Controller {

    @FXML
    private TreeView treeview_SideMenu;
    @FXML
    ImageView image_Home, image_Office, image_User, image_Office2, image_Exit, image_UserS2 = new ImageView();
    @FXML
    private TextField txtf_Username;
    @FXML
    private PasswordField passwordfield_Password;
    @FXML
    private TableColumn tablecolumn_Caisse, tablecolumn_NAVS, tablecolumn_Nom, tablecolumn_Prenom, tablecolumn_DOB, tablecolumn_Sexe;
    @FXML
    private TableView<TVMembers> tableview_Members;
    //    TableView<TVMembers> tableview_Members = new TableView<tvMembers>();
    @FXML
    private VBox vbox_fragment1;

    @FXML
    protected void initialize() {
        //
        //TABLEVIEW ADD DATA
        //Define data in ObservableList
        final ObservableList<TVMembers> data = FXCollections.observableArrayList();
        try {
            Connection con = DBConnect.getConnection();
            ResultSet rs = con.createStatement().executeQuery("select * from ipensiondb");

            while (rs.next()){
                data.add(new TVMembers(rs.getString("id"),rs.getString("caisse"),rs.getString("nom"),rs.getString("prenom"),rs.getString("dob"),rs.getString("sexe") ));
                System.out.println(data);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }


        //Associate data with columns
        tablecolumn_Caisse.setCellValueFactory(new PropertyValueFactory<TVMembers,String>("id"));
        tablecolumn_NAVS.setCellValueFactory(new PropertyValueFactory<TVMembers,String>("caisse"));
        tablecolumn_Nom.setCellValueFactory(new PropertyValueFactory<TVMembers,String>("nom"));
        tablecolumn_Prenom.setCellValueFactory(new PropertyValueFactory<TVMembers,String>("prenom"));
        tablecolumn_DOB.setCellValueFactory(new PropertyValueFactory<TVMembers,String>("dob"));
        tablecolumn_Sexe.setCellValueFactory(new PropertyValueFactory<TVMembers,String>("sexe"));
        //add data to table
        tableview_Members.setItems(data);


    }
}
