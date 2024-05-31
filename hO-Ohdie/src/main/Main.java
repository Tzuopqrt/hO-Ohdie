package main;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Observable;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Slider;
import javafx.scene.control.Spinner;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea; 
import javafx.scene.control.TextField;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Modality;
import javafx.stage.Popup;
import javafx.stage.Stage;


public class Main extends Application{
	
	Scene loginScene, registerScene, userScene, cartScene, historyScene, adminScene, adminShowScene;
	BorderPane popupBP, loginSceneBP, registerSceneBP, userSceneBP, cartSceneBP, historySceneBP, adminSceneBP, adminShowSceneBP;
	FlowPane popupFP, cartFP1, cartFP2, cartFP3, cartFP4, cartFP5, registerRadioFP, adminNameFP, userHoodieIdFP, userHoodieNameFP, userTotalPriceFP, adminPriceFP, adminPriceFP1, adminButtonFP;
	GridPane popupGP, loginSceneGP, registerSceneGP, userSceneHomeGP1, userSceneHomeGP2, cartSceneGP1, cartSceneGP2, historySceneGP1, historySceneGP2, adminSceneHomeGP1, adminSceneHomeGP2, adminSceneShowGP1, adminSceneShowGP2;
	
	MenuBar loginBar, registerBar, userBar, cartBar, historyBar, adminBar;
	Menu loginBarMenu, registerBarMenu, userAccountBarMenu, userUserBarMenu, cartAccountBarMenu, cartUserBarMenu, historyAccountBarMenu, historyUserBarMenu, adminAccountBarMenu, adminAdminBarMenu;
	MenuItem loginBarItem, registerBarItem, userAccountBarItem, userHomeBarItem, userCartBarItem, cartAccountBarItem, cartHomeBarItem, cartCartBarItem, cartHistoryBarItem, historyAccountBarItem, historyHomeBarItem, historyCartBarItem, historyHistoryBarItem, userHistoryBarItem, adminAccountBarItem, adminEditBarItem;
	
	Label historySelectedlbl, confirmationlbl, cartHoodieIdlbl2, cartHoodieNamelbl2, cartHoodiePricelbl2, cartHoodieQtylbl2, cartHoodieTotallPricelbl2, hoodieIdlbl, hoodieNamelbl, cartlbl, cartHoodieDetaillbl, cartSelectItemlbl, cartContactlbl, cartEmaillbl, cartPhonelbl, cartAddresslbl, cartTotalPricelbl, cartHoodieIdlbl, cartHoodieNamelbl, cartHoodiePricelbl, cartHoodieQtylbl, cartHoodieTotalPricelbl, selectItemHomelbl, loginlbl, usernameLoginlbl, passLoginlbl, registerlbl, emaillbl, usernameRegisterlbl, passRegisterlbl, confirmPasslbl, phoneNumberlbl, genderlbl, addresslbl, hoohdielbl, hoodieDetaillbl, hoodieIdHomelbl, hoodieNameHomelbl, hoodiePriceHomelbl, hoodieQtyHomelbl, hoodieTotalPriceHomelbl, selectItemlbl, selectAdminItemlbl, editProductlbl, updateDeletelbl, insertHoodielbl, adminNamelbl, adminPricelbl, hoodiePricelbl, editProductShowlbl, updateDeleteShowlbl, hoodieIdShowlbl, hoodieNameShowlbl, hoodiePriceShowlbl, insertHoodieShowlbl, adminNameShowlbl, adminPriceShowlbl,
			historyTransactionlbl, historyTransactionDetaillbl, historySelectlbl, historyTotalPricelbl;
	TextField usernameLoginField, emailField, usernameRegisterField, phoneNumberField, hoodiePriceField, hoodiePriceShowField, adminNameField, adminPriceField, adminNameShowField, adminPriceShowField;
	PasswordField passLoginField, passRegisterField, confirmPassRegisterField;
	Button loginButton, registerButton, userAddButton, cartRemoveButton, cartCheckoutButton, paymentButton, cancelButton, adminInsertButton, adminUpdatePriceShowButton, adminDeleteHoodieShowButton, adminShowInsertButton, showtotalpricebutton;
	TextArea addressField;
	
	RadioButton maleRadio, femaleRadio;
	ToggleGroup genderGroup;
	CheckBox checkBox;
	Spinner<Integer> QtySpinner;
	
	Popup paymentConfirmation;
//	Window popup;
	
	private TableView<User> UserTable;
	TableColumn<User, String> userIdColumn;
	TableColumn<User, String> emailColumn;
	TableColumn<User, String> userNameColumn;
	TableColumn<User, String> passwordColumn;
	TableColumn<User, String> phoneNumberColumn;
	TableColumn<User, String> addressColumn;
	TableColumn<User, String> genderColumn;
	TableColumn<User, String> roleColumn;
	
	private TableView<Hoodie> HoodieTable;
	TableColumn<Hoodie, String> hoodieIdHomeColumn;
	TableColumn<Hoodie, String> hoodieNameHomeColumn;
	
	ListView<String> ListViewHome;
	
	private TableView<userCart> userCartTable;
	TableColumn<userCart, String> userCartIdColumn;
	TableColumn<userCart, String> hoodieCartIdColumn;
	TableColumn<userCart, Integer> hoodieCartQty;
	
	private TableView<Cart> CartTable;
	TableColumn<Cart, String> userIDCartColumn; 
	TableColumn<Cart, String> hoodieIDCartColumn;
	TableColumn<Cart, String> hoodieNameCartColumn;
	TableColumn<Cart, Integer> hoodieQtyCartColumn;
	TableColumn<Cart, Double> hoodiePriceCartColumn;
	TableColumn<Cart, Double> hoodieTotalPriceCartColumn;
	
	private TableView<Transaction> HistoryTable1;
	TableColumn<Transaction, String> transactionIdColumn;
	TableColumn<Transaction, String> userIdColum;
	
	private TableView<Detail> HistoryTable2;
	TableColumn<Detail, String> TransactionIDColumn;
	TableColumn<Detail, String> HoodieIDColumn;
	TableColumn<Detail, String> HoodieNameColumn;
	TableColumn<Detail, Integer> QtyColumn;
	TableColumn<Detail, Double> PriceColumn;
	TableColumn<Detail, Double> TotalPriceColumn;
	
	private TableView<HoodieList> HoodieListTableAdmin;
	TableColumn<HoodieList, String> hoodieIdColumn;
	TableColumn<HoodieList, String> hoodieNameColumn;
	TableColumn<HoodieList, Integer> hoodiePriceColumn;
	
	private static Integer transaction = 0;
	public static String generateIdTransaction() {
		String idTransaction;
		idTransaction = "TR";
		transaction++;
		String indexTransaction = String.format("%03d", transaction);
		idTransaction = idTransaction + indexTransaction;
		return idTransaction;
	}
	
	private static Integer hoodie = 0;
	public static String generateIdHoodie() {
		
		String idHoodie;
		
		idHoodie = "HO";
	
		hoodie++;
		String indexHoodie = String.format("%03d", hoodie);
		
		idHoodie = idHoodie + indexHoodie;
		return idHoodie;
	}
	
	private static Integer user= 0;
	public static String generateIdUser() {
		
		String idUser;
		
		idUser = "US";
	
		user++;
		String indexUser = String.format("%03d", user);
		
		idUser = idUser + indexUser;
		return idUser;
	}
	
	private Connect connect = Connect.getInstance();
	
	public void popup() {
		Stage stage = new Stage();
//		popup = new Window("Payment Confirmation");
//		popup.setMinHeight(300);
//		popup.setMinHeight(200);   
		
		popupBP = new BorderPane();
		popupGP = new GridPane();
		popupFP = new FlowPane();
		
		confirmationlbl = new Label("Are you sure, you want to complete the payment?");
		paymentButton = new Button("Make Payment");
		cancelButton = new Button("Cancel");
		
		popupFP.getChildren().addAll(paymentButton, cancelButton);
		
		popupGP.add(confirmationlbl, 0, 0);
		popupGP.add(popupFP, 0, 1);
		
		Font confirmFont = Font.font("Times New Roman", FontWeight.BOLD, FontPosture.REGULAR, 14);
		confirmationlbl.setFont(confirmFont);
		
		popupBP.setPadding(new Insets(50));
		popupGP.setHgap(10);
		popupGP.setVgap(10);
		popupFP.setPadding(new Insets(0, 0 ,0 ,65));
		popupFP.setHgap(5);
		
		popupBP.setCenter(popupGP);
		
		Scene scene = new Scene(popupBP, 400, 200);
		
        stage.setScene(scene);
        stage.show();
        
        paymentButton.setOnMouseClicked(e -> {
        	 String query = "SELECT UserID, Username FROM user";
         	
         	try (ResultSet resultSet = connect.execQuery(query)){
         		
     		    while (resultSet.next()) {
     		        String userCartIDCart = resultSet.getString("UserID");
     		        String username = resultSet.getString("Username");
     		        if (usernameLoginField.getText().equals(username)) {
     		        	String query2 = String.format("DELETE FROM cart WHERE UserID = '" + userCartIDCart + "'");
     		        	connect.execInsert(query2);
     					
//     					CartTable.getItems().removeIf(item -> item.getUserIDCart().equals(userCartIDCart));
     					break;
     					}
     				}
     		        // Debug prints to check values
     		   stage.close();

     		  HistoryTable1.getItems().clear();
     			
     			String query2 = "SELECT TransactionID, th.UserID, Username FROM transactionheader th JOIN user u ON th.userID = u.UserID";
     			connect.execQuery(query2);
     			
     			try {
     				while(connect.rs.next()) {
     					String userId = connect.rs.getString("UserID");
     					String username = connect.rs.getString("Username");
     					String transactionId = connect.rs.getString("TransactionID");
     					
     							HistoryTable1.getItems().add(new Transaction(transactionId, userId, username));
     						}
     					
     				
     			} catch (Exception e1) {
     				// TODO: handle exception
     				e1.printStackTrace();
     			}
     			
     			
         	} catch (SQLException e1) {
         		// Handle SQL Exception
         		e1.printStackTrace();
         	}
         	transaction = HistoryTable1.getItems().size();
         	String headerId = generateIdTransaction();
         	HistoryTable1.getItems().clear();
  			  String userId = "";
  			for (int i = 0; i < UserTable.getItems().size(); i++) {
  				if (usernameLoginField.getText().equals(UserTable.getItems().get(i).getUsername())) {
  					userId = UserTable.getItems().get(i).getUserId();
  					System.out.println(userId);
  				}
  			}
  			   
  			   String query3 = "INSERT INTO transactionheader VALUES ('" + headerId + "','" + userId + "')";
  			  System.out.println(query3);
  			connect.execInsert(query3);
  			insertDetail();
  			getAllDataTransactionHeader();

     		       
     		    
        });
       
        
        cancelButton.setOnMouseClicked(e -> {
        	stage.close();
        });
	}
	
	public void Table() {
		UserTable = new TableView<User>();
		userIdColumn = new TableColumn<User, String>();
		emailColumn = new TableColumn<User, String>();
		userNameColumn = new TableColumn<User, String>();
		passwordColumn = new TableColumn<User, String>();
		phoneNumberColumn = new TableColumn<User, String>();
		addressColumn = new TableColumn<User, String>();
		genderColumn = new TableColumn<User, String>();
		roleColumn = new TableColumn<User, String>();
		
		userIdColumn.setCellValueFactory(new PropertyValueFactory<User, String>("UserId"));
		emailColumn.setCellValueFactory(new PropertyValueFactory<User, String>("Email"));
		userNameColumn.setCellValueFactory(new PropertyValueFactory<User, String>("Username"));
		passwordColumn.setCellValueFactory(new PropertyValueFactory<User, String>("Password"));
		phoneNumberColumn.setCellValueFactory(new PropertyValueFactory<User, String>("PhoneNumber"));
		addressColumn.setCellValueFactory(new PropertyValueFactory<User, String>("Address"));
		genderColumn.setCellValueFactory(new PropertyValueFactory<User, String>("Gender"));
		roleColumn.setCellValueFactory(new PropertyValueFactory<User, String>("Role"));
		
		UserTable.getColumns().addAll(userIdColumn, emailColumn, userNameColumn, passwordColumn, phoneNumberColumn, addressColumn, genderColumn, roleColumn);
		
		
		userCartTable = new TableView<userCart>();
		userCartIdColumn = new TableColumn<userCart, String>();
		hoodieCartIdColumn = new TableColumn<userCart, String>();
		hoodieCartQty = new TableColumn<userCart, Integer>();
		
		userCartIdColumn.setCellValueFactory(new PropertyValueFactory<userCart, String>("userCartID"));
		hoodieCartIdColumn.setCellValueFactory(new PropertyValueFactory<userCart, String>("hoodieCartID"));
		hoodieCartQty.setCellValueFactory(new PropertyValueFactory<userCart, Integer>("hoodieCartQty"));
		
		userCartTable.getColumns().addAll(userCartIdColumn, hoodieCartIdColumn, hoodieCartQty);
	}
	
	public void initializeLogin() {
		loginSceneBP = new BorderPane();
		loginSceneGP = new GridPane();
		loginScene = new Scene(loginSceneBP, 700, 800);
		
		loginBar = new MenuBar();
		loginBarMenu = new Menu("Login");
		loginBarItem = new MenuItem("Register");
		
		loginlbl = new Label("Login");
		usernameLoginlbl = new Label("Username:   ");
		passLoginlbl = new Label("Password:");
		
		usernameLoginField = new TextField();
		passLoginField = new PasswordField();
		
		usernameLoginField.setPromptText("Input username");
		passLoginField.setPromptText("Input password");
		
		loginButton = new Button("Login");
		
		Font loginFont = Font.font("Calibri", FontWeight.BOLD, FontPosture.ITALIC, 100);
		loginlbl.setFont(loginFont);
		
		loginButton.setMinWidth(230);
		loginButton.setMaxHeight(50);
		
		loginSceneGP.setVgap(10);
		loginSceneGP.setHgap(10);
		loginSceneGP.setPadding(new Insets(230));
		
	}
	
	public void initializeRegister() {
		registerSceneBP = new BorderPane();
		registerSceneGP = new GridPane();
		registerRadioFP = new FlowPane();
		registerScene = new Scene(registerSceneBP, 700, 800);
		
		registerBar = new MenuBar();
		registerBarMenu = new Menu("Register");
		registerBarItem = new MenuItem("Login");
		
		registerlbl = new Label("Register");
		emaillbl = new Label("Email:");
		usernameRegisterlbl = new Label("Username:");
		passRegisterlbl = new Label("Password:");
		confirmPasslbl = new Label("Confirm Password:");
		phoneNumberlbl = new Label("Phone Number:");
		genderlbl = new Label("Gender:");
		addresslbl = new Label("Address:");
		registerButton = new Button("Register");
		
		emailField = new TextField();
		usernameRegisterField = new TextField();
		passRegisterField = new PasswordField();
		confirmPassRegisterField = new PasswordField();
		phoneNumberField = new TextField();
		addressField = new TextArea();
		
		emailField.setPromptText("Input email");
		usernameRegisterField.setPromptText("Input an unique username");
		passRegisterField.setPromptText("Input password");
		confirmPassRegisterField.setPromptText("Confirm password");
		phoneNumberField.setPromptText("Example +6212345678901");
		addressField.setPromptText("Input address");
	
		maleRadio = new RadioButton("Male");
		femaleRadio = new RadioButton("Female");
		genderGroup = new ToggleGroup();
		
		checkBox = new CheckBox("I Agree to Term & Conditions");
		
		emailField.setMinWidth(600);
		
		Font registerFont = Font.font("Times New Roman", FontWeight.BOLD, FontPosture.ITALIC, 80);
		registerlbl.setFont(registerFont);
	}
	
	public void initializeLoginLayout() {
		
		loginSceneGP.add(loginlbl, 0, 0, 2, 2);
		loginSceneGP.add(usernameLoginlbl, 0, 2);
		loginSceneGP.add(passLoginlbl, 0, 3);
		loginSceneGP.add(usernameLoginField, 1, 2);
		loginSceneGP.add(passLoginField, 1, 3);
		loginSceneGP.add(loginButton, 0, 4, 2, 2);
		
	}
	
	public void initializeRegisterLayout() {
		registerSceneGP.add(registerlbl, 0, 0);
		registerSceneGP.add(emaillbl, 0, 1);
		registerSceneGP.add(emailField, 0, 2);
		registerSceneGP.add(usernameRegisterlbl, 0, 3);
		registerSceneGP.add(usernameRegisterField, 0, 4);
		registerSceneGP.add(passRegisterlbl, 0, 5);
		registerSceneGP.add(passRegisterField, 0, 6);
		registerSceneGP.add(confirmPasslbl, 0, 7);
		registerSceneGP.add(confirmPassRegisterField, 0, 8);
		registerSceneGP.add(phoneNumberlbl, 0, 9);
		registerSceneGP.add(phoneNumberField, 0, 10);
		registerRadioFP.getChildren().add(maleRadio);
		registerRadioFP.getChildren().add(femaleRadio);
		registerSceneGP.add(genderlbl, 0, 11);
		registerSceneGP.add(registerRadioFP, 0, 12);
		registerSceneGP.add(addresslbl, 0, 13);
		registerSceneGP.add(addressField, 0, 14);
		registerSceneGP.add(checkBox, 0, 15);
		registerSceneGP.add(registerButton, 0, 16);
		
		registerButton.setMinWidth(600);
		
		maleRadio.setToggleGroup(genderGroup);
		femaleRadio.setToggleGroup(genderGroup);
		
		registerSceneGP.setVgap(10);
		registerSceneGP.setHgap(10);
		registerSceneGP.setPadding(new Insets(45));
	}
	
	
	public void initializeAccountUserHome() {
		
		userSceneBP = new BorderPane();
		userScene = new Scene(userSceneBP, 1200, 800);
		userSceneHomeGP1 = new GridPane();
		userSceneHomeGP2 = new GridPane();
		userTotalPriceFP = new FlowPane();
		userHoodieIdFP = new FlowPane();
		userHoodieNameFP = new FlowPane();
		
		hoohdielbl = new Label("hO-Ohdie");
		hoodieDetaillbl = new Label("Hoodie's Detail");
		selectItemHomelbl = new Label("select an item from the list...");
		hoodieIdlbl = new Label("Hoodie ID: ");
		hoodieNamelbl = new Label("Name: ");
		hoodieIdHomelbl = new Label();
		hoodieNameHomelbl = new Label();
		hoodiePriceHomelbl = new Label("Price: ");
		hoodieQtyHomelbl = new Label("Quantity: ");
		hoodieTotalPriceHomelbl = new Label("Total Price: ");
		
		QtySpinner = new Spinner<>(1, 100, 1);
		
		userAddButton = new Button("Add to Cart");
		
		userBar = new MenuBar();
		userAccountBarMenu = new Menu("Account");
		userAccountBarItem = new MenuItem("Logout");
		userUserBarMenu = new Menu("User");
		userHomeBarItem = new MenuItem("Home");
		userCartBarItem = new MenuItem("Cart");
		userHistoryBarItem = new MenuItem("History");
		

	}
	
	public void initializeAccountUserHomeLayout() {
		
		HoodieTable = new TableView<>();
		hoodieIdHomeColumn = new TableColumn<Hoodie, String>("Hoodie ID");
		hoodieNameHomeColumn = new TableColumn<Hoodie, String>("Hoodie Name");
		
		hoodieIdHomeColumn.setCellValueFactory(new PropertyValueFactory<Hoodie, String>("HoodieIdHome"));
		hoodieNameHomeColumn.setCellValueFactory(new PropertyValueFactory<Hoodie, String>("hoodieNameHome"));
		
		HoodieTable.getColumns().addAll(hoodieIdHomeColumn, hoodieNameHomeColumn);
		
		HoodieTable.setMinSize(500, 500);
		
		hoodieIdHomeColumn.setMinWidth(500/4);
		hoodieNameHomeColumn.setMinWidth(500/4);
		
		ListViewHome = new ListView<>();
		ListViewHome.setMinWidth(400);
		
		userSceneHomeGP1.add(hoohdielbl, 0, 0);
		userSceneHomeGP1.add(ListViewHome, 0, 1);
		userSceneHomeGP2.add(hoodieDetaillbl, 0, 1);
		userSceneHomeGP2.add(selectItemHomelbl, 0, 2);
		
		Font hoohdieFont = Font.font("Times New Roman", FontWeight.LIGHT, FontPosture.ITALIC, 60);
		hoohdielbl.setFont(hoohdieFont);
		
		Font hoohdieDetailFont = Font.font("Calibri", FontWeight.BOLD, FontPosture.ITALIC, 60);
		hoodieDetaillbl.setFont(hoohdieDetailFont);
		
		Font selectItemFont = Font.font("Times New Roman", FontWeight.LIGHT, 15);
		selectItemHomelbl.setFont(selectItemFont);
		
		userSceneHomeGP1.setVgap(30);
		userSceneHomeGP1.setHgap(30);
		userSceneHomeGP1.setPadding(new Insets(45));
		userSceneHomeGP2.setVgap(10);
		userSceneHomeGP2.setPadding(new Insets(150, 220, 0, 0));
		
		hoodieIdlbl.setVisible(false);
		hoodieNamelbl.setVisible(false);
		hoodieIdHomelbl.setVisible(false);
		hoodieNameHomelbl.setVisible(false);
		hoodiePriceHomelbl.setVisible(false);
		hoodieQtyHomelbl.setVisible(false);
		QtySpinner.setVisible(false);
		hoodieTotalPriceHomelbl.setVisible(false);
		userAddButton.setVisible(false);
		
		ListViewHome.setOnMouseClicked(e -> {
			for (int i = 0; i <= ListViewHome.getSelectionModel().getSelectedIndex(); i++) {
				hoodieIdHomelbl.setText("" + HoodieListTableAdmin.getItems().get(i).getHoodieId());
				hoodieNameHomelbl.setText("" + HoodieListTableAdmin.getItems().get(i).getHoodieName());
				hoodiePriceHomelbl.setText("Price: " + HoodieListTableAdmin.getItems().get(i).getHoodiePrice());
				hoodieTotalPriceHomelbl.setText("Total Price: " + QtySpinner.getValue() * HoodieListTableAdmin.getItems().get(i).getHoodiePrice());
				
				
				    }
			selectItemHomelbl.setVisible(false);   
			hoodieIdlbl.setVisible(true);
			hoodieNamelbl.setVisible(true);
			hoodieIdHomelbl.setVisible(true);
			hoodieNameHomelbl.setVisible(true);
			hoodiePriceHomelbl.setVisible(true);
			hoodieQtyHomelbl.setVisible(true);
			QtySpinner.setVisible(true);
			hoodieTotalPriceHomelbl.setVisible(true);
			userAddButton.setVisible(true);
				});
		
			QtySpinner.setOnMouseClicked(e -> {
				for (int i = 0; i < HoodieListTableAdmin.getSelectionModel().getSelectedIndex(); i++) {
					hoodieTotalPriceHomelbl.setText("Total Price: " + QtySpinner.getValue() * HoodieListTableAdmin.getItems().get(i).getHoodiePrice());
				};
			
			
		});
		
		userTotalPriceFP.getChildren().add(QtySpinner);
		userTotalPriceFP.getChildren().add(hoodieTotalPriceHomelbl);
		userHoodieIdFP.getChildren().addAll(hoodieIdlbl, hoodieIdHomelbl);
		userHoodieNameFP.getChildren().addAll(hoodieNamelbl, hoodieNameHomelbl);
		
		userSceneHomeGP2.add(userHoodieIdFP, 0, 2);
		userSceneHomeGP2.add(userHoodieNameFP, 0, 3);
		userSceneHomeGP2.add(hoodiePriceHomelbl, 0, 4);
		userSceneHomeGP2.add(userTotalPriceFP, 0, 5);
		userSceneHomeGP2.add(userAddButton, 0, 6);
		
		userTotalPriceFP.setHgap(10);
		
	}
	
	public void initializeCart() {
		
		cartSceneBP = new BorderPane();
		cartScene = new Scene(cartSceneBP, 1200, 800);
		cartSceneGP1 = new GridPane();
		cartSceneGP2 = new GridPane();
		cartFP1 = new FlowPane();
		cartFP2 = new FlowPane();
		cartFP3 = new FlowPane();
		cartFP4 = new FlowPane();
		cartFP5 = new FlowPane();
		
		cartBar = new MenuBar();
		cartAccountBarMenu = new Menu("Account");
		cartAccountBarItem = new MenuItem("Logout");
		cartUserBarMenu = new Menu("User");
		cartHomeBarItem = new MenuItem("Home");
		cartCartBarItem = new MenuItem("Cart");
		cartHistoryBarItem = new MenuItem("History");
		
		cartlbl = new Label();
		cartHoodieDetaillbl = new Label("Hoodie's Detail");
		cartSelectItemlbl = new Label("Select an item from the table");
		cartContactlbl = new Label("Contact Information");
		cartEmaillbl = new Label("Email       : dummy@hoohdie.com");
		cartPhonelbl = new Label("Phone       : +6212345678901");
		cartAddresslbl = new Label("Address     : Jl. Dummy");
		cartTotalPricelbl = new Label();
		
		cartHoodieIdlbl = new Label("Hoodie ID: ");
		cartHoodieIdlbl2 = new Label();
		cartHoodieNamelbl = new Label("Name: ");
		cartHoodieNamelbl2 = new Label();
		cartHoodiePricelbl = new Label("Price: ");
		cartHoodiePricelbl2 = new Label();
		cartHoodieQtylbl = new Label("Quantity: ");
		cartHoodieQtylbl2 = new Label();
		cartHoodieTotalPricelbl = new Label("Total Price");
		cartHoodieTotallPricelbl2 = new Label();
		
		cartRemoveButton = new Button("Remove from Cart");
		cartCheckoutButton = new Button("Checkout");
		
		Font currentCart = Font.font("Times New Roman", FontWeight.LIGHT, FontPosture.ITALIC, 60);
		cartlbl.setFont(currentCart);
		
		Font cartHoodieDetailFont = Font.font("Calibri", FontWeight.BOLD, FontPosture.ITALIC, 40);
		cartHoodieDetaillbl.setFont(cartHoodieDetailFont);
		
		Font contactFont = Font.font("Calibri", FontWeight.BOLD, FontPosture.ITALIC, 40);
		cartContactlbl.setFont(contactFont);
		
		Font cartTotalPriceFont = Font.font("Calibri", FontWeight.BOLD, FontPosture.ITALIC, 40);
		cartTotalPricelbl.setFont(cartTotalPriceFont);
		
		Font cartHoodieTotalPriceFont = Font.font("Times New Roman", FontWeight.BOLD, 20);
		cartHoodieTotalPricelbl.setFont(cartHoodieTotalPriceFont);
		
	}
	
	public void initializeCartLayout() {
		
		CartTable = new TableView<Cart>();
		userIDCartColumn = new TableColumn<Cart, String>("User ID");
		hoodieIDCartColumn = new TableColumn<Cart, String>("Hoodie ID");
		hoodieNameCartColumn = new TableColumn<Cart, String>("Hoodie Name");
		hoodieQtyCartColumn = new TableColumn<Cart, Integer>("Quantity");
		hoodiePriceCartColumn = new TableColumn<Cart, Double>("Price");
		hoodieTotalPriceCartColumn = new TableColumn<Cart, Double>("Total Price");
		
		userIDCartColumn.setCellValueFactory(new PropertyValueFactory<Cart, String>("userIDCart"));
		hoodieIDCartColumn.setCellValueFactory(new PropertyValueFactory<Cart, String>("HoodieIDCart"));
		hoodieNameCartColumn.setCellValueFactory(new PropertyValueFactory<Cart, String>("HoodieNameCart"));
		hoodieQtyCartColumn.setCellValueFactory(new PropertyValueFactory<Cart, Integer>("HoodieQtyCart"));
		hoodiePriceCartColumn.setCellValueFactory(new PropertyValueFactory<Cart, Double>("HoodiePriceCart"));
		hoodieTotalPriceCartColumn.setCellValueFactory(new PropertyValueFactory<Cart, Double>("HoodieTotalPriceCart"));
		
		CartTable.getColumns().addAll(hoodieIDCartColumn, hoodieNameCartColumn, hoodieQtyCartColumn, hoodieTotalPriceCartColumn);
		
		CartTable.setMinSize(500, 600);
		hoodieIDCartColumn.setMinWidth(500/4);
		hoodieNameCartColumn.setMinWidth(500/4);
		hoodieQtyCartColumn.setMinWidth(500/4);
		hoodieTotalPriceCartColumn.setMinWidth(500/4);
		
		cartSceneGP1.add(cartlbl, 0, 0);
		cartSceneGP1.add(CartTable, 0, 1);
		
		showtotalpricebutton = new Button("Show Total Price");
		
		cartSceneGP2.add(cartHoodieDetaillbl, 0, 0);
		cartSceneGP2.add(cartSelectItemlbl, 0, 1);
		cartSceneGP2.add(cartContactlbl, 0, 7);
		cartSceneGP2.add(cartEmaillbl, 0, 8);
		cartSceneGP2.add(cartPhonelbl, 0, 9);
		cartSceneGP2.add(cartAddresslbl, 0, 10);
		cartSceneGP2.add(showtotalpricebutton, 0, 11);
		cartSceneGP2.add(cartHoodieTotalPricelbl, 0, 12);
		cartSceneGP2.add(cartCheckoutButton, 0, 13);
		
		cartSceneGP1.setVgap(30);
		cartSceneGP1.setHgap(30);
		cartSceneGP1.setPadding(new Insets(45));
		cartSceneGP2.setVgap(10);
		cartSceneGP2.setPadding(new Insets(150, 220, 0, 0));
		
		cartContactlbl.setPadding(new Insets(30, 0, 0, 0));
		
		cartSelectItemlbl.setVisible(true);
		cartRemoveButton.setVisible(false);
		cartHoodieIdlbl.setVisible(false);
		cartHoodieNamelbl.setVisible(false);
		cartHoodiePricelbl.setVisible(false);
		cartHoodieQtylbl.setVisible(false);
		cartHoodieTotalPricelbl.setVisible(false);

		CartTable.setOnMouseClicked(e -> {
			for (int i = 0; i <= CartTable.getSelectionModel().getSelectedIndex(); i++) {
				cartHoodieIdlbl.setText("Hoodie ID: " + CartTable.getItems().get(i).getHoodieIDCart());
				cartHoodieNamelbl.setText("Name: " + CartTable.getItems().get(i).getHoodieNameCart());
				cartHoodiePricelbl.setText("Price: " + CartTable.getItems().get(i).getHoodiePriceCart());
				cartHoodieQtylbl.setText("Quantity: " + CartTable.getItems().get(i).getHoodieQtyCart());
				cartHoodieTotalPricelbl.setText("Total Price: " + CartTable.getItems().get(i).getHoodieQtyCart() * CartTable.getItems().get(i).getHoodiePriceCart());
				cartTotalPricelbl.setText("Cart's Total Price: " + CartTable.getItems().get(i).getHoodieTotalPriceCart());
			}
			
			cartSelectItemlbl.setVisible(false);
			cartHoodieIdlbl.setVisible(true);
			cartHoodieNamelbl.setVisible(true);
			cartHoodiePricelbl.setVisible(true);
			cartHoodieQtylbl.setVisible(true);
			cartRemoveButton.setVisible(true);
			cartHoodieTotalPricelbl.setVisible(true);
		});
		
		showtotalpricebutton.setOnMouseClicked(e -> {
			String username2 = usernameLoginField.getText();
			String password2 = passLoginField.getText();
			String userID2 = connect.getUserID(username2, password2);
			String query = "SELECT SUM(hoodie.HoodiePrice * cart.Quantity)FROM cart JOIN hoodie ON cart.HoodieID = hoodie.HoodieID WHERE UserID = " + "'" + userID2 + "'";
			connect.rs = connect.execQuery(query);
			System.out.println(query);
			
			try {
				if (connect.rs.next()) {
					double totalprice = connect.rs.getDouble(1);
					cartHoodieTotalPricelbl.setText(String.format("Cart's Total Price : $%.2f", totalprice));
				} 
			} catch (Exception f) {
				f.printStackTrace();
			}
			cartHoodieTotalPricelbl.setVisible(true);
		});
		
		cartFP1.getChildren().addAll(cartHoodieIdlbl, cartHoodieIdlbl2);
		cartFP2.getChildren().addAll(cartHoodieNamelbl, cartHoodieNamelbl2);
		cartFP3.getChildren().addAll(cartHoodiePricelbl, cartHoodiePricelbl2);
		cartFP4.getChildren().addAll(cartHoodieQtylbl, cartHoodieQtylbl2);
		cartFP5.getChildren().addAll(cartHoodieTotalPricelbl, cartHoodieTotallPricelbl2);
		
		ObservableList<Cart> cartData = FXCollections.observableArrayList();
		
		cartSceneGP2.add(cartFP1, 0, 1);
		cartSceneGP2.add(cartFP2, 0, 2);
		cartSceneGP2.add(cartFP3, 0, 3);
		cartSceneGP2.add(cartFP4, 0, 4);
		cartSceneGP2.add(cartFP5, 0, 5);
		cartSceneGP2.add(cartRemoveButton, 0, 6);

		
	}
	
	public void initializeHistory() {
		
		historySceneBP = new BorderPane();
		historyScene = new Scene(historySceneBP, 1100, 800);
		historySceneGP1 = new GridPane();
		historySceneGP2 = new GridPane();
		
		historyTransactionlbl = new Label();
		historyTransactionDetaillbl = new Label();
		historySelectlbl = new Label("(Select a Transaction)");
		historyTotalPricelbl = new Label("");
		historySelectedlbl = new Label("");
		
		historyBar = new MenuBar();
		historyAccountBarMenu = new Menu("Account");
		historyAccountBarItem = new MenuItem("Logout");
		historyUserBarMenu = new Menu("User");
		historyHomeBarItem = new MenuItem("Home");
		historyCartBarItem = new MenuItem("Cart");
		historyHistoryBarItem = new MenuItem("History");
		
		Font historyTransaction = Font.font("Times New Roman", FontWeight.BOLD, FontPosture.ITALIC, 30);
		historyTransactionlbl.setFont(historyTransaction);
		
		Font historySelect = Font.font("Times New Roman", FontWeight.BOLD, FontPosture.ITALIC, 30);
		historySelectlbl.setFont(historySelect);
		
		Font historyDetail = Font.font("Times New Roman", FontWeight.BOLD, FontPosture.ITALIC, 30);
		historyTransactionDetaillbl.setFont(historyDetail);
		
		Font historyTotal = Font.font("Times New Roman", FontWeight.BOLD, FontPosture.REGULAR, 30);
		historyTotalPricelbl.setFont(historyTotal);
		
		Font historySelected = Font.font("Times New Roman", FontWeight.BOLD, FontPosture.ITALIC, 30);
		historySelectedlbl.setFont(historySelected);
		
		
	}
	
	public void initializeHistoryLayout() {
		
		HistoryTable1 = new TableView<Transaction>();
		transactionIdColumn = new TableColumn<Transaction, String>("Transaction ID");
		userIdColum = new TableColumn<Transaction, String>("User ID");
		
		transactionIdColumn.setCellValueFactory(new PropertyValueFactory<Transaction, String>("TransactionID"));
		userIdColum.setCellValueFactory(new PropertyValueFactory<Transaction, String>("UserID"));
		
		HistoryTable1.getColumns().addAll(transactionIdColumn, userIdColum);
		
		HistoryTable1.setMinSize(400, 600);
		transactionIdColumn.setMinWidth(400/2);
		userIdColumn.setMinWidth(400/2);
		
		HistoryTable2 = new TableView<Detail>();
		TransactionIDColumn = new TableColumn<Detail, String>("Transaction ID");
		HoodieIDColumn = new TableColumn<Detail, String>("Hoodie ID");
		HoodieNameColumn = new TableColumn<Detail, String>("Hoodie Name");
		QtyColumn = new TableColumn<Detail, Integer>("Quantity");
		PriceColumn = new TableColumn<Detail, Double>("Price");
		TotalPriceColumn = new TableColumn<Detail, Double>("Total Price");
		
		TransactionIDColumn.setCellValueFactory(new PropertyValueFactory<Detail, String>("TransactionDetailID"));
		HoodieIDColumn.setCellValueFactory(new PropertyValueFactory<Detail, String>("HoodieID"));
		HoodieNameColumn.setCellValueFactory(new PropertyValueFactory<Detail, String>("HoodieName"));
		QtyColumn.setCellValueFactory(new PropertyValueFactory<Detail, Integer>("HoodieQty"));
		PriceColumn.setCellValueFactory(new PropertyValueFactory<Detail, Double>("Price"));
		TotalPriceColumn.setCellValueFactory(new PropertyValueFactory<Detail, Double>("TotalPrice"));
		
		HistoryTable2.getColumns().addAll(TransactionIDColumn, HoodieIDColumn, HoodieNameColumn, QtyColumn, TotalPriceColumn);
		
		HistoryTable2.setMinSize(500, 600);
		TransactionIDColumn.setMinWidth(500/5);
		HoodieIDColumn.setMinWidth(500/5);
		HoodieNameColumn.setMinWidth(500/5);
		QtyColumn.setMinWidth(500/5);
		TotalPriceColumn.setMinWidth(500/5);
		
		historySceneGP1.add(historyTransactionlbl, 0, 0);
		historySceneGP1.add(HistoryTable1, 0, 1);
		
		historySceneGP2.add(historySelectlbl, 0, 0);
		historySceneGP2.add(HistoryTable2, 0, 1);
		historySceneGP2.add(historyTotalPricelbl, 0, 2);
		historySceneGP2.add(historySelectedlbl, 0, 0);
		historySelectedlbl.setVisible(false);

		
		historySceneGP1.setPadding(new Insets(50));
		historySceneGP2.setPadding(new Insets(50));
		historyTotalPricelbl.setPadding(new Insets(0, 0, 0 ,200));
		
		
	}
	
	public void initializeAccountAdminHome() {
		
		adminSceneBP = new BorderPane();
		adminScene = new Scene(adminSceneBP, 800, 800);
		adminSceneHomeGP1 = new GridPane();
		adminSceneHomeGP2 = new GridPane();
		adminNameFP = new FlowPane();
		adminPriceFP = new FlowPane();
		adminPriceFP1 = new FlowPane();
		adminButtonFP = new FlowPane();
		
		adminBar = new MenuBar();
		adminAccountBarMenu = new Menu("Account");
		adminAccountBarItem = new MenuItem("Logout");
		adminAdminBarMenu = new Menu("Admin");
		adminEditBarItem = new MenuItem("Edit Product");
		
		
		editProductlbl = new Label("Edit Product");
		updateDeletelbl = new Label("Update & Delete Hoodie(s)");
		selectAdminItemlbl = new Label("select an item from the list...");
		insertHoodielbl = new Label("Insert Hoodie");
		adminNamelbl = new Label("Name:");
		adminPricelbl = new Label("Price:");
		
		adminNameField = new TextField();
		adminPriceField = new TextField();
		
		adminNameField.setPromptText("Input Name");
		adminPriceField.setPromptText("Input Price");
		
		adminBar = new MenuBar();
		adminAccountBarMenu = new Menu("Account");
		adminAccountBarItem = new MenuItem("Logout");
		adminAdminBarMenu = new Menu("Admin");
		adminEditBarItem = new MenuItem("Edit Product");
		
		adminInsertButton = new Button("Insert");
		
		
		Font editProductFont = Font.font("Times New Roman", FontWeight.LIGHT, FontPosture.ITALIC, 60);
		editProductlbl.setFont(editProductFont);
		
		Font insertDeleteFont = Font.font("Arial", FontWeight.BOLD, 25);
		updateDeletelbl.setFont(insertDeleteFont);
		
		Font insertHoodieFont = Font.font("Arial", FontWeight.BOLD, 25);
		insertHoodielbl.setFont(insertHoodieFont);
		
	}
	
	public void initializeAccountAdminHomeLayout() {
		HoodieListTableAdmin = new TableView<HoodieList>();
		hoodieIdColumn = new TableColumn<HoodieList, String>("Hoodie ID");
		hoodieNameColumn = new TableColumn<HoodieList, String>("Hoodie Name");
		hoodiePriceColumn = new TableColumn<HoodieList, Integer> ("Hoodie Price");
		
		hoodieIdColumn.setCellValueFactory(new PropertyValueFactory<HoodieList, String>("HoodieId"));
		hoodieNameColumn.setCellValueFactory(new PropertyValueFactory<HoodieList, String>("HoodieName"));
		hoodiePriceColumn.setCellValueFactory(new PropertyValueFactory<HoodieList, Integer>("HoodiePrice"));
		
		HoodieListTableAdmin.getColumns().addAll(hoodieIdColumn, hoodieNameColumn, hoodiePriceColumn);
		
		HoodieListTableAdmin.setMinSize(300, 500);
		hoodieIdColumn.setMinWidth(300/3);
		hoodieNameColumn.setMinWidth(300/3);
		hoodiePriceColumn.setMinWidth(300/3);
		
		adminNameFP.getChildren().add(adminNamelbl);
		adminNameFP.getChildren().add(adminNameField);
		
		adminPriceFP.getChildren().add(adminPricelbl);
		adminPriceFP.getChildren().add(adminPriceField);
		
		adminSceneHomeGP1.add(editProductlbl, 0, 0);
		adminSceneHomeGP1.add(HoodieListTableAdmin, 0, 1);
		
		adminSceneHomeGP2.add(updateDeletelbl, 0, 0);
		adminSceneHomeGP2.add(selectAdminItemlbl, 0, 1);
		adminSceneHomeGP2.add(insertHoodielbl, 0, 6);
		adminSceneHomeGP2.add(adminNameFP, 0, 7);
		adminSceneHomeGP2.add(adminPriceFP, 0, 8);
		adminSceneHomeGP2.add(adminInsertButton, 0, 9);
		
		adminNameFP.setHgap(15);
		adminNameFP.setPadding(new Insets(5, 0, 5, 0));
		adminPriceFP.setHgap(20);
		adminPriceFP.setPadding(new Insets(5, 0, 10, 0));
//		
		adminInsertButton.setMinWidth(200);
		
		adminSceneHomeGP1.setVgap(10);
		adminSceneHomeGP1.setHgap(10);
		adminSceneHomeGP1.setPadding(new Insets(45));
		
		adminSceneHomeGP2.setPadding(new Insets(150, 220, 0, 0));
		
		insertHoodielbl.setPadding(new Insets(100, 0, 0, 0));
		
		hoodieIdShowlbl = new Label();
		hoodieNameShowlbl = new Label();
		hoodiePriceShowlbl = new Label();
		
		hoodiePriceField = new TextField();
		
		adminUpdatePriceShowButton = new Button();
		adminDeleteHoodieShowButton = new Button();

		hoodiePriceField.setVisible(false);
		adminUpdatePriceShowButton.setVisible(false);
		adminDeleteHoodieShowButton.setVisible(false);
		
		HoodieListTableAdmin.setOnMouseClicked(e -> {
			hoodieIdShowlbl.setText("Hoodie ID: " + HoodieListTableAdmin.getSelectionModel().getSelectedItem().getHoodieId());
	        hoodieNameShowlbl.setText("Hoodie Name: " + HoodieListTableAdmin.getSelectionModel().getSelectedItem().getHoodieName());
	        hoodiePriceField.setText("Price: " + HoodieListTableAdmin.getSelectionModel().getSelectedItem().getHoodiePrice().toString());
	        
			hoodiePriceField.setVisible(true);
			adminUpdatePriceShowButton.setVisible(true);
			adminDeleteHoodieShowButton.setVisible(true);
			hoodiePriceShowlbl.setText("Price: ");
			
			selectAdminItemlbl.setVisible(false);
				
	        });
			
		adminUpdatePriceShowButton.setText("Update Price");
		adminDeleteHoodieShowButton.setText("Delete Hoodie");
			
		adminPriceFP1.getChildren().add(hoodiePriceShowlbl);
		adminPriceFP1.getChildren().add(hoodiePriceField);
		
		adminButtonFP.getChildren().add(adminUpdatePriceShowButton);
		adminButtonFP.getChildren().add(adminDeleteHoodieShowButton);
			
		adminSceneHomeGP2.add(hoodieIdShowlbl, 0, 1);
		adminSceneHomeGP2.add(hoodieNameShowlbl, 0, 2);
		adminSceneHomeGP2.add(adminPriceFP1, 0, 3);
		adminSceneHomeGP2.add(adminButtonFP, 0, 4);
		
		adminSceneHomeGP2.setHgap(10);
		adminSceneHomeGP2.setVgap(5);
		adminButtonFP.setHgap(5);

	}
	
	public void initializeMenu() {
		loginBar.getMenus().add(loginBarMenu);
		loginBarMenu.getItems().add(loginBarItem);
		
		registerBar.getMenus().add(registerBarMenu);
		registerBarMenu.getItems().add(registerBarItem);
		
		userBar.getMenus().addAll(userAccountBarMenu, userUserBarMenu);
		userAccountBarMenu.getItems().add(userAccountBarItem);
		userUserBarMenu.getItems().addAll(userHomeBarItem, userCartBarItem, userHistoryBarItem);
		
		cartBar.getMenus().addAll(cartAccountBarMenu, cartUserBarMenu);
		cartAccountBarMenu.getItems().add(cartAccountBarItem);
		cartUserBarMenu.getItems().addAll(cartHomeBarItem, cartCartBarItem, cartHistoryBarItem);
		
		historyBar.getMenus().addAll(historyAccountBarMenu, historyUserBarMenu);
		historyAccountBarMenu.getItems().add(historyAccountBarItem);
		historyUserBarMenu.getItems().addAll(historyHomeBarItem, historyCartBarItem, historyHistoryBarItem);
		
		adminBar.getMenus().addAll(adminAccountBarMenu, adminAdminBarMenu);
		adminAccountBarMenu.getItems().add(adminAccountBarItem);
		adminAdminBarMenu.getItems().add(adminEditBarItem);
	}
	
	public void layout() {
		loginSceneBP.setTop(loginBar);
		loginSceneBP.setCenter(loginSceneGP);
		
		registerSceneBP.setTop(registerBar);
		registerSceneBP.setCenter(registerSceneGP);
		
		userSceneBP.setTop(userBar);
		userSceneBP.setLeft(userSceneHomeGP1);
		userSceneBP.setRight(userSceneHomeGP2);
		
		cartSceneBP.setTop(cartBar);
		cartSceneBP.setLeft(cartSceneGP1);
		cartSceneBP.setRight(cartSceneGP2);
		
		historySceneBP.setTop(historyBar);
		historySceneBP.setLeft(historySceneGP1);
		historySceneBP.setRight(historySceneGP2);
		
		adminSceneBP.setTop(adminBar);
		adminSceneBP.setLeft(adminSceneHomeGP1);
		adminSceneBP.setRight(adminSceneHomeGP2);
		
	}
	
	private void clearInput() {
		adminNameField.clear();
		adminPriceField.clear();
	}
	
	public static void main(String[] args) {
		launch(args);

	}

	
	public void deleteCartData() {
		cartCheckoutButton.setOnMouseClicked(e -> {

			getAllDataCart();
			CartTable.refresh();
			
			 if (CartTable.getItems().isEmpty()) {
			        Alert alert = new Alert(AlertType.ERROR);
			        alert.setTitle("Error");
			        alert.setContentText("Cart is empty");
			        alert.show();
			    } else {
			    	popup();
			    	
			    	
			    }
		});
	}
		
	public void insertDetail() {
//		paymentButton.setOnMouseClicked(e -> {
		 HistoryTable1.getItems().clear();
			
			String query2 = "SELECT TransactionID, th.UserID, Username FROM transactionheader th JOIN user u ON th.userID = u.UserID";
			connect.execQuery(query2);
			
			try {
				while(connect.rs.next()) {
					String userId = connect.rs.getString("UserID");
					String username = connect.rs.getString("Username");
					String transactionId = connect.rs.getString("TransactionID");
					
							HistoryTable1.getItems().add(new Transaction(transactionId, userId, username));
						}
					
				
			} catch (Exception e1) {
				// TODO: handle exception
				e1.printStackTrace();
			}
			
			
		transaction = HistoryTable1.getItems().size() - 1;
		   String transactionId = generateIdTransaction();
		   System.out.println(transactionId);
		 HistoryTable1.getItems().clear();
				
			for (int j = 0; j < CartTable.getItems().size(); j++) {
				String hoodieId = CartTable.getItems().get(j).getHoodieIDCart();
				Integer hoodieQty = CartTable.getItems().get(j).getHoodieQtyCart();
				
				String query = "INSERT INTO transactiondetail VALUES ('" + transactionId + "', '" + hoodieId + "', " + hoodieQty + ")";
				System.out.println(query);
				System.out.println("halo");
				connect.execInsert(query);
				getAllDataTransactionDetail();
				
			}
				
//		});
	}
	
	private void getAllDataTransactionHeader() {
		HistoryTable1.getItems().clear();
		
		String query = "SELECT TransactionID, th.UserID, Username FROM transactionheader th JOIN user u ON th.userID = u.UserID";
		System.out.println(query);
		connect.rs = connect.execQuery(query);
		
		try {
			while(connect.rs.next()) {
				String userId = connect.rs.getString("UserID");
				String username = connect.rs.getString("Username");
				String transactionId = connect.rs.getString("TransactionID");
					
					if (usernameLoginField.getText().equals(username)) {
						HistoryTable1.getItems().add(new Transaction(transactionId, userId, username));
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	
	private void getAllDataTransactionDetail() {
		HistoryTable1.setOnMouseClicked(e -> {
			HistoryTable2.getItems().clear();
			
			String query = "SELECT TransactionID, h.HoodieID, HoodieName, Quantity, HoodiePrice, SUM(HoodiePrice * Quantity) AS HoodieTotalPrice "
					+ "FROM transactiondetail td JOIN hoodie h ON td.HoodieID = h.HoodieID "
					+ "GROUP BY TransactionID, HoodieID, HoodieName, Quantity, HoodiePrice";
			
			System.out.println(query);
			connect.rs = connect.execQuery(query);
			
			try {
				while(connect.rs.next()) {
					String detailId = connect.rs.getString("TransactionID");
					String detailHoodieId = connect.rs.getString("HoodieID");
					String detailHoodieName = connect.rs.getString("HoodieName");
					Integer detailQuantity = connect.rs.getInt("Quantity");
					Double detailTotal = connect.rs.getDouble("HoodieTotalPrice");
					if (HistoryTable1.getSelectionModel().getSelectedItem() != null) {
						String historyTransactionId = HistoryTable1.getSelectionModel().getSelectedItem().getTransactionID();
						if (historyTransactionId.equals(detailId)) {
							HistoryTable2.getItems().add(new Detail(detailId, detailHoodieId, detailHoodieName, detailQuantity, detailTotal));
						}
					}
					
					
				}
			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
			
			
			for (int i = 0; i < HistoryTable1.getItems().size(); i++) {
				historySelectedlbl.setText(HistoryTable1.getSelectionModel().getSelectedItem().getTransactionID() + " 's Transaction Detail(s)");
				historySelectlbl.setVisible(false);
				historySelectedlbl.setVisible(true);
			}
			
		});
		for (int i = 0; i < HistoryTable2.getSelectionModel().getSelectedIndex(); i++) {
			historyTotalPricelbl.setText("Total Price: " + HistoryTable2.getItems().get(i).getTotalPrice());
		}
		
		HistoryTable1.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Transaction>() {

			@Override
			public void changed(ObservableValue<? extends Transaction> arg0, Transaction arg1, Transaction arg2) {
				if (arg2 != null) {
					String transactionid = arg2.getTransactionID();
					getTransactionDetail(transactionid);
					
					try {
						String query = "SELECT SUM(HoodiePrice * Quantity) AS TotalPrice FROM transactiondetail td JOIN hoodie h ON h.HoodieID = td.HoodieID WHERE TransactionID = " + "'" + transactionid + "'";;
						connect.rs = connect.execQuery(query);
						System.out.println(query);
						if (connect.rs.next()) {
							double totalprice = connect.rs.getDouble(1);
							historyTotalPricelbl.setText(String.format("Total Price: $%.2f" , totalprice));								} 
					} catch (Exception f) {
						f.printStackTrace();
					};
				}
				
			}

			private void getTransactionDetail(String transactionID) {
				HistoryTable2.getItems().clear();
				
				String query = "SELECT TransactionID, td.HoodieID, HoodieName, Quantity, HoodiePrice * Quantity AS TotalPrice FROM transactiondetail td JOIN hoodie h "
						+ "ON td.HoodieID = h.HoodieID WHERE TransactionID = " + "'" + transactionID + "'";
				connect.execQuery(query);
				System.out.println(query);
				
				try {
					while(connect.rs.next()) {
						String transid = connect.rs.getString("TransactionID");
						String hoodieid = connect.rs.getString("HoodieID");
						String hoodiename = connect.rs.getString("HoodieName");
						int quantity = connect.rs.getInt("Quantity");
						double totalprice = connect.rs.getDouble("TotalPrice");
						HistoryTable2.getItems().add(new Detail(transid, hoodieid, hoodiename, quantity, totalprice));
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
				
			}
		});
		
		
		
		

	}
	
	private void getAllDataUsername() {
		UserTable.getItems().clear();

		String query = "SELECT * FROM user";  
		
		 
		
		connect.rs = connect.execQuery(query);
		
		// pindahin hasil resultset ke tabel
		try {
			while(connect.rs.next()) {
				String userID = connect.rs.getString("UserID"); // nama sesuai yang ada di database
				String userEmail = connect.rs.getString("Email");
				String userName = connect.rs.getString("Username");
				String userPassword = connect.rs.getString("Password");
				String userPhoneNumber = connect.rs.getString("PhoneNumber");
				String userAddress = connect.rs.getString("Address");
				String userGender = connect.rs.getString("Gender");
				String userRole = connect.rs.getString("Role");
				
				UserTable.getItems().add(new User(userID, userEmail, userName, userPassword, userPhoneNumber, userAddress, userGender, userRole));

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void getAllDataUser() {
		HoodieListTableAdmin.getItems().clear();

		ObservableList<String> hoodieList = FXCollections.observableArrayList();
		
		String query = "SELECT * FROM hoodie";
		
		connect.rs = connect.execQuery(query);
		
		// pindahin hasil resultset ke tabel
		try {
			while(connect.rs.next()) {
				String hoodieIdHome = connect.rs.getString("HoodieID"); // nama sesuai yang ada di database
				String hoodieNameHome = connect.rs.getString("HoodieName");
				
				HoodieTable.getItems().add(new Hoodie(hoodieIdHome, hoodieNameHome));
				hoodieList.add(hoodieIdHome + "                            " + hoodieNameHome);
			}
		ListViewHome.setItems(hoodieList);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}}
	
	private void getAllDataCart() {
		CartTable.getItems().clear();

		String query = "SELECT c.UserID, Username, h.HoodieID, HoodieName, HoodiePrice, Quantity, SUM(Quantity * HoodiePrice) AS HoodieTotalPrice "
				+ "FROM cart as C JOIN hoodie as H ON C.HoodieID = H.HoodieID JOIN user as U ON C.UserID = U.UserID GROUP BY HoodieID, HoodieName, Quantity, HoodiePrice, UserID";
							System.out.println(query);
							connect.rs = connect.execQuery(query);
							

							try {
							    while (connect.rs.next()) {
							        String userCartIDCart = connect.rs.getString("UserID");
							        String username = connect.rs.getString("Username");
							        String HoodieIDCart = connect.rs.getString("HoodieID");
							        String HoodieNameCart = connect.rs.getString("HoodieName");
							        Integer HoodieQuantity = connect.rs.getInt("Quantity");
							        Double HoodiePriceCart = connect.rs.getDouble("HoodiePrice");
							        Double HoodieTotalPrice = connect.rs.getDouble("HoodieTotalPrice");
							        if (usernameLoginField.getText().equals(username)) {
										String cartId = userCartIDCart;
										if (cartId.equals(userCartIDCart)) {
											 CartTable.getItems().add(new Cart(userCartIDCart, HoodieIDCart, HoodieNameCart, HoodieQuantity, HoodiePriceCart, HoodieTotalPrice));
										}
									}
							        // Debug prints to check values


							       
							    }
							} catch (SQLException e1) {
							    // Handle SQL Exception
							    e1.printStackTrace();
							}
		
	}
	
	private void getAllDataAdmin() {
		HoodieListTableAdmin.getItems().clear();
		
		String query = "SELECT * FROM hoodie";
		
		connect.rs = connect.execQuery(query);
		
		// pindahin hasil resultset ke tabel
		try {
			while(connect.rs.next()) {
				String HoodieID = connect.rs.getString("HoodieID"); // nama sesuai yang ada di database
				String HoodieName = connect.rs.getString("HoodieName");
				Double HoodiePrice = connect.rs.getDouble("HoodiePrice");
				
				HoodieListTableAdmin.getItems().add(new HoodieList(HoodieID, HoodieName, HoodiePrice));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}}
		
	public void insertData() {
		adminInsertButton.setOnMouseClicked(e -> {
			hoodie = HoodieListTableAdmin.getItems().size();
			String HoodieID = generateIdHoodie();
			String HoodieName =  adminNameField.getText();
			Double HoodiePrice = Double.parseDouble(adminPriceField.getText());
			
			String query = "INSERT INTO hoodie VALUES ('" + HoodieID + "','" + HoodieName + "'," + "'" + HoodiePrice + "')"; 
			System.out.println(query);

			connect.execInsert(query);
			getAllDataAdmin();
			
			clearInput();
		});
	}
	
	
	
	public void insertCart() {
		userAddButton.setOnMouseClicked(e -> {
			
			hoodie = HoodieTable.getItems().size();
			String HoodieID = hoodieIdHomelbl.getText();
			String HoodieName = hoodieNameHomelbl.getText();
			Integer HoodieQty = QtySpinner.getValue();
			
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Message");
			alert.setContentText(HoodieID + " - " + HoodieName + " - " + HoodieQty +"x added");
			alert.show();		
			
			getAllDataUsername();
			hoodie = CartTable.getItems().size();
			String userId = "";
			for (int i = 0; i < UserTable.getItems().size(); i++) {
				if (usernameLoginField.getText().equals(UserTable.getItems().get(i).getUsername())) {
					userId = UserTable.getItems().get(i).getUserId();
					System.out.println(userId);
				}
			}
		
			String hoodieId = ListViewHome.getSelectionModel().getSelectedItem().substring(0, 6);
//			String hoodieName = ListViewHome.getSelectionModel().getSelectedItem().substring(33);
			
			
			Integer Qty = QtySpinner.getValue();
			
			String query2 = "INSERT INTO cart VALUES ('" + userId + "', '" + hoodieId + "', " + Qty  + ")";
			
			System.out.println(query2);
			connect.execInsert(query2);
			getAllDataCart();
			
			
			
		});
	}
	
	public void updateEditData() {
		adminUpdatePriceShowButton.setOnMouseClicked(e -> {
				String HoodieID = HoodieListTableAdmin.getSelectionModel().getSelectedItem().getHoodieId();
				Double HoodiePrice = Double.parseDouble(hoodiePriceField.getText());
				
				String queryUpdate = "UPDATE hoodie SET HoodiePrice = '" + HoodiePrice + "' WHERE HoodieID = '" + HoodieID + "'";
				System.out.println(queryUpdate);
				connect.execInsert(queryUpdate);
				getAllDataAdmin();	
			
		});
	}
	
	public void DeleteEditData() {
	    adminDeleteHoodieShowButton.setOnMouseClicked(e -> {

	        if (HoodieListTableAdmin.getSelectionModel().getSelectedItem() != null) {
	            String HoodieID = HoodieListTableAdmin.getSelectionModel().getSelectedItem().getHoodieId();

	            try {
	                String queryDelete = "DELETE FROM hoodie WHERE HoodieID = ?";
	                PreparedStatement preparedStatement = connect.prepareStatement(queryDelete);

	                preparedStatement.setString(1, HoodieID);

	                int rowsAffected = preparedStatement.executeUpdate();
	                if (rowsAffected > 0) {
	                    System.out.println("Delete Successful");
	                    getAllDataAdmin();
	                } else {
	                    System.out.println("Data dengan HoodieID " + HoodieID + " tidak ditemukan.");
	                }
	            } catch (SQLException ex) {
	                System.out.println("Error: " + ex.getMessage());
	            }
	        } else {
	            System.out.println("Tidak ada item yang dipilih");
	        }
	    });
	}

	public void DeleteCart() {
		cartRemoveButton.setOnMouseClicked(e -> {
			if (CartTable.getSelectionModel().getSelectedItem() != null) {
	            String HoodieIDcart = CartTable.getSelectionModel().getSelectedItem().getHoodieIDCart();

	            try {
	                String queryDelete = "DELETE FROM cart WHERE HoodieID = ?";
	                PreparedStatement preparedStatement = connect.prepareStatement(queryDelete);

	                preparedStatement.setString(1, HoodieIDcart);

	                int rowsAffected = preparedStatement.executeUpdate();
	                if (rowsAffected > 0) {
	                    System.out.println("Delete Successful");
	                    getAllDataCart();
	                } else {
	                    System.out.println("Data dengan HoodieID " + HoodieIDcart + " tidak ditemukan.");
	                }
	            } catch (SQLException ex) {
	                System.out.println("Error: " + ex.getMessage());
	            }
	        } else {
	            System.out.println("Tidak ada item yang dipilih");
	        }
		});
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		Table();
		popup();
		initializeLogin();
		initializeRegister();
		initializeLoginLayout();
		initializeRegisterLayout();
		initializeAccountUserHome();
		initializeAccountUserHomeLayout();
		initializeCart();
		initializeCartLayout();
		initializeHistory();
		initializeHistoryLayout();
		initializeAccountAdminHome();
		initializeAccountAdminHomeLayout();
		initializeMenu();
		layout();
		getAllDataUsername();
		getAllDataUser();
		getAllDataAdmin();
		getAllDataTransactionHeader();
		getAllDataTransactionDetail();
//		getAllDataCart();
		insertData();
		DeleteCart();
		deleteCartData();
		updateEditData();
		DeleteEditData();
		
		
		
		
		primaryStage.setScene(loginScene);
		primaryStage.setTitle("hO-Ohdie");
		primaryStage.show();
		
		registerBarItem.setOnAction(event -> primaryStage.setScene(loginScene));
		loginBarItem.setOnAction(event -> primaryStage.setScene(registerScene));
		
		userAccountBarItem.setOnAction(event -> primaryStage.setScene(loginScene));
		userHomeBarItem.setOnAction(event -> primaryStage.setScene(userScene));
		userCartBarItem.setOnAction(event -> primaryStage.setScene(cartScene));
		userHistoryBarItem.setOnAction(event -> {
  			getAllDataTransactionHeader();
  			getAllDataTransactionDetail();
		primaryStage.setScene(historyScene);
		});
		
		cartAccountBarItem.setOnAction(event -> primaryStage.setScene(loginScene));
		cartHomeBarItem.setOnAction(event -> primaryStage.setScene(userScene));
		cartCartBarItem.setOnAction(event -> primaryStage.setScene(cartScene));
		cartHistoryBarItem.setOnAction(event -> primaryStage.setScene(historyScene));
		
		historyAccountBarItem.setOnAction(event -> primaryStage.setScene(loginScene));
		historyHomeBarItem.setOnAction(event -> primaryStage.setScene(userScene));
		historyCartBarItem.setOnAction(event -> primaryStage.setScene(cartScene));
		historyHistoryBarItem.setOnAction(event -> primaryStage.setScene(historyScene));
		
		adminAccountBarItem.setOnAction(event -> primaryStage.setScene(loginScene));
		
		
		
		registerButton.setOnMouseClicked(e -> {
			
			Alert alert = new Alert(AlertType.ERROR);
			
			if (!emailField.getText().endsWith("@hoohdie.com")) {
				alert.setHeaderText("Email Error");
				alert.setContentText("Email must ends with '@hoohdie.com'");
				alert.show();
				return;
			}
			
			 String Username = usernameRegisterField.getText();
			 user = UserTable.getItems().size();
			 
			 Connect con = new Connect();
				if (con.usernameExist(Username)) {
					
					alert.setHeaderText("Username Error");
					alert.setContentText("Username already exists");
					alert.show();
					return;
				} 
			
			if (passRegisterField.getText().length() < 5) {
	            alert.setHeaderText("Password Error");
	            alert.setContentText("Password must contain at least 5 characters.");
	            alert.show();
	            return;
	        }
			
			if (!confirmPassRegisterField.getText().equals(passRegisterField.getText())) {
	            alert.setHeaderText("Password Error");
	            alert.setContentText("Password and Confirm Password do not match.");
	            alert.show();
	            return;
	        }
			
			if (phoneNumberField.getText().length() != 14 || !phoneNumberField.getText().startsWith("+62")) {
	            alert.setHeaderText("Phone Number Error");
	            alert.setContentText("Phone Number must be 14 characters long and start with '+62'.");
	            alert.show();
	            return;
	        }
			
			if (genderGroup.getSelectedToggle() == null) {
	            alert.setHeaderText("Gender Error");
	            alert.setContentText("Please select a gender.");
	            alert.show();
	            return;
	        }
			
			if (addressField.getText().isEmpty()) {
	            alert.setHeaderText("Address Error");
	            alert.setContentText("Please enter your address.");
	            alert.show();
	            return;
	        }
			
			 if (!checkBox.isSelected()) {
		            alert.setHeaderText("Checkbox Error");
		            alert.setContentText("Please check the checkbox.");
		            alert.show();
		            return;
		        }

				String UserRole = "User";
				
				String UserID = generateIdUser();
				String UserEmail =  emailField.getText();
				String UserName = usernameRegisterField.getText();
				String UserPassword = passRegisterField.getText();
				String UserPhoneNumber = phoneNumberField.getText();

				Toggle selectedToggle = genderGroup.getSelectedToggle();
				RadioButton selectedRadio = (RadioButton) selectedToggle;
			    String selectedGender = selectedRadio.getText();
				
				String UserAddress = addressField.getText();

					String query = "INSERT INTO user VALUES" + "('" + UserID + "','" + UserEmail + "','" + UserName + "','" + UserPassword + "','" + UserPhoneNumber + "','" + UserAddress + "','" + 
					selectedGender + "','" + UserRole + "')";
					 
					System.out.println(query);

					connect.execInsert(query);
					getAllDataUsername();
					emailField.clear();
					usernameRegisterField.clear();
					passRegisterField.clear();
					confirmPassRegisterField.clear();
					phoneNumberField.clear();
					genderGroup.selectToggle(null);
					addressField.clear();
					checkBox.setSelected(false);
			
			primaryStage.setScene(loginScene);
		});
		
		
		loginButton.setOnMouseClicked(e -> {
			getAllDataCart();
			insertCart();
			
			Alert alert = new Alert(AlertType.ERROR);
			
			if (usernameLoginField.getText().length() < 1) {
				alert.setHeaderText("Error");
				alert.setContentText("Wrong Credential");
				alert.show();
				return;
			}
			
			if (passLoginField.getText().length() < 1) {
				alert.setHeaderText("Error");
				alert.setContentText("Wrong Credential");
				alert.show();
				return;
			}
			
			String username = usernameLoginField.getText();
			String password = passLoginField.getText();
			Connect con = new Connect();
			String role = con.LoginValidation(username, password);
			if (role != null) {
				if (role.equals("User")) {
					primaryStage.setScene(userScene);
				} else if (role.equals("Admin")) {
					primaryStage.setScene(adminScene);
				}
			} else {
				 alert.setAlertType(AlertType.ERROR);
				    alert.setHeaderText("Error");
				    alert.setContentText("Wrong Credential");
				    alert.show();
			}
			
			String usernameName = usernameLoginField.getText();
			cartlbl.setText(usernameName + " 's cart");
			
			String usernameHistory = usernameLoginField.getText();
			historyTransactionlbl.setText(usernameHistory + " ' Transaction(s)");
			
//			getAllDataTransactionDetail();
//			usernameLoginField.clear();
//			passLoginField.clear();
		});
		
		
	}
}
		

