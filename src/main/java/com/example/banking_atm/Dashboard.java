package com.example.banking_atm;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.scene.layout.GridPane;

public class Dashboard {

    // Sidebar Elements
    @FXML private VBox sidebar;
    @FXML private HBox brandBox;
    @FXML private Label brandText;
    @FXML private VBox navLinks;
    @FXML private HBox navHome;
    @FXML private HBox navBalance;
    @FXML private HBox navCalculator;
    @FXML private HBox navVaults;
    @FXML private HBox navTransactions;
    @FXML private HBox navDocs;
    @FXML private HBox navSettings;
    @FXML private HBox logoutBox;

    // Top Bar Elements
    @FXML private HBox topBar;
    @FXML private Label priceLabel;
    @FXML private Button connectBtn;

    // Main Content Area Elements
    @FXML private VBox mainContent;
    @FXML private VBox contentArea;
    @FXML private Label pageTitle;

    // Stake Card (Left Card)
    @FXML private VBox stakeCard;
    @FXML private Button authenticateBtn;
    @FXML private GridPane statsGrid;
    @FXML private VBox apyBox;
    @FXML private Label apyLabel;
    @FXML private Label apyValue;
    @FXML private VBox totalDepositedBox;
    @FXML private Label totalDepositedValue;
    @FXML private VBox indexBox;
    @FXML private Label indexValue;
    @FXML private VBox rebaseBox;
    @FXML private Label rebaseValue;

    // Dark Panel (Right Card)
    @FXML private VBox darkPanel;
    @FXML private VBox balanceInfo;
    @FXML private Label balanceAmount;
    @FXML private Label earningsLabel;
    @FXML private HBox actionButtons;
    @FXML private Button depositBtn;
    @FXML private Button withdrawBtn;

    @FXML
    public void initialize() {
        // Called automatically upon FXML load.
        System.out.println("Dashboard controller initialized.");

        sidebar.setOnMouseEntered(event -> {
            sidebar.setPrefWidth(200);
        });

        sidebar.setOnMouseExited(event -> {
            sidebar.setPrefWidth(70);
        });
        // Initialize any UI components or default values if desired
        priceLabel.setText("1 HUMP = $4.3");
        pageTitle.setText("Single Stake (3,3)");

        // Example setup for stats
        apyLabel.setText("APY");
        apyValue.setText("257,900%");

        totalDepositedValue.setText("$571,320");
        indexValue.setText("1.99 HUMP");
        rebaseValue.setText("7 hrs, 7 mins");

        balanceAmount.setText("$0.00");
        earningsLabel.setText("Your Earnings / Day");
    }

    // ========================
    // Button Handlers
    // ========================

    @FXML
    private void handleConnectWallet() {
        System.out.println("Connect Wallet button clicked");
        // TODO: Add wallet connection logic here.
    }

    @FXML
    private void handleAuthenticate() {
        System.out.println("Authenticate button clicked");
        // TODO: Add authentication logic here.
    }

    @FXML
    private void handleDeposit() {
        System.out.println("Deposit button clicked");
        // TODO: Add deposit logic here.
    }

    @FXML
    private void handleWithdraw() {
        System.out.println("Withdraw button clicked");
        // TODO: Add withdraw logic here.
    }

    // ========================
    // Navigation Handlers (Sidebar)
    // ========================

    @FXML
    private void handleNavHome(MouseEvent event) {
        System.out.println("Navigation - Home clicked");
        // TODO: Update the UI for Home.
    }

    @FXML
    private void handleNavBalance(MouseEvent event) {
        System.out.println("Navigation - Balance clicked");
        // TODO: Update the UI for Balance.
    }

    @FXML
    private void handleNavCalculator(MouseEvent event) {
        System.out.println("Navigation - Calculator clicked");
        // TODO: Update the UI for Calculator.
    }

    @FXML
    private void handleNavVaults(MouseEvent event) {
        System.out.println("Navigation - Vaults clicked");
        // TODO: Update the UI for Vaults.
    }

    @FXML
    private void handleNavTransactions(MouseEvent event) {
        System.out.println("Navigation - Transactions clicked");
        // TODO: Update the UI for Transactions.
    }

    @FXML
    private void handleNavDocs(MouseEvent event) {
        System.out.println("Navigation - Docs clicked");
        // TODO: Update the UI for Docs.
    }

    @FXML
    private void handleNavSettings(MouseEvent event) {
        System.out.println("Navigation - Settings clicked");
        // TODO: Update the UI for Settings.
    }

    @FXML
    private void handleLogout(MouseEvent event) {
        System.out.println("Logout clicked");
        // TODO: Implement logout functionality.
    }
}
