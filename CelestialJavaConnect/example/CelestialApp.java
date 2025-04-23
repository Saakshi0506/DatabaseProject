// CelestialApp.java - Main JavaFX application class (UI and event handling)
package example;

import example.celestialDB.dao.*;
import example.celestialDB.model.*;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import java.sql.SQLException;
import java.util.List;
import javafx.beans.property.*;

/**
 * Main application class for the Celestial Exoplanetary System Database.
 * Sets up the JavaFX UI and handles user interactions.
 */
public class CelestialApp extends Application {
    // Data access objects for database operations
    private GalaxyDAO galaxyDAO = new GalaxyDAO();
    private StarDAO starDAO = new StarDAO();
    private ExoplanetDAO exoplanetDAO = new ExoplanetDAO();
    
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Celestial Exoplanetary System Database");
        
        // Create a TabPane for separate sections (Galaxies, Stars, Exoplanets)
        TabPane tabPane = new TabPane();
        
        // ================== Galaxy Tab UI ==================
        Tab galaxyTab = new Tab("Galaxies");
        galaxyTab.setClosable(false);
        
        // TableView for Galaxy entities
        TableView<Galaxies> galaxyTable = new TableView<>();
        galaxyTable.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        TableColumn<Galaxies, Integer> colGalId = new TableColumn<>("ID");
        colGalId.setCellValueFactory(new PropertyValueFactory<>("galaxy_id"));
        TableColumn<Galaxies, String> colGalName = new TableColumn<>("Name");
        colGalName.setCellValueFactory(new PropertyValueFactory<>("name"));
        TableColumn<Galaxies, String> colGalType = new TableColumn<>("Type");
        colGalType.setCellValueFactory(new PropertyValueFactory<>("type"));
        TableColumn<Galaxies, Integer> colGalDist = new TableColumn<>("Distance (ly)");
        colGalDist.setCellValueFactory(new PropertyValueFactory<>("distanceLY"));
        galaxyTable.getColumns().addAll(colGalId, colGalName, colGalType, colGalDist);
        
        // Input fields for Galaxy attributes
        TextField galNameField = new TextField();
        galNameField.setPromptText("Galaxy Name");
        TextField galTypeField = new TextField();
        galTypeField.setPromptText("Galaxy Type");
        TextField galDistanceField = new TextField();
        galDistanceField.setPromptText("Distance (ly)");
        
        // CRUD buttons for Galaxy
        Button addGalaxyBtn = new Button("Add");
        Button updateGalaxyBtn = new Button("Update");
        Button deleteGalaxyBtn = new Button("Delete");
        
        // Search field and button for Galaxy
        TextField galaxySearchField = new TextField();
        galaxySearchField.setPromptText("Search by name...");
        Button galaxySearchBtn = new Button("Search");
        
        // Layout for galaxy input section (fields and buttons)
        VBox galaxyForm = new VBox(5);
        galaxyForm.getChildren().addAll(
            new Label("Name:"), galNameField,
            new Label("Type:"), galTypeField,
            new Label("Distance (ly):"), galDistanceField,
            new HBox(5, addGalaxyBtn, updateGalaxyBtn, deleteGalaxyBtn)
        );
        galaxyForm.setPadding(new Insets(10));
        
        // Assemble the Galaxy tab layout
        BorderPane galaxyPane = new BorderPane();
        galaxyPane.setTop(new HBox(5, new Label("Search:"), galaxySearchField, galaxySearchBtn));
        ((HBox) galaxyPane.getTop()).setPadding(new Insets(5));
        galaxyPane.setLeft(galaxyForm);
        galaxyPane.setCenter(galaxyTable);
        galaxyPane.setPadding(new Insets(5));
        galaxyTab.setContent(galaxyPane);
        // Optionally set an icon for the tab (if image is available)
        try {
            Image galaxyIcon = new Image("file:C:/Users/saakshi/Downloads/Java BlueJ/CelestialJavaConnect/example/celestialDB/assets/galaxy.png");
            galaxyTab.setGraphic(new ImageView(galaxyIcon));
        } catch (Exception e) {
            // Image not found or cannot load, skip setting icon
        }
        
        // ================== Star Tab UI ==================
        Tab starTab = new Tab("Stars");
        starTab.setClosable(false);
        
        TableView<Stars> starTable = new TableView<>();
        starTable.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        TableColumn<Stars, Integer> colStarId = new TableColumn<>("ID");
        colStarId.setCellValueFactory(new PropertyValueFactory<>("star_id"));
        TableColumn<Stars, String> colStarName = new TableColumn<>("Name");
        colStarName.setCellValueFactory(new PropertyValueFactory<>("name"));
        TableColumn<Stars, String> colStarType = new TableColumn<>("Type");
        colStarType.setCellValueFactory(new PropertyValueFactory<>("type"));
        TableColumn<Stars, Double> colStarMass = new TableColumn<>("Mass (solar)");
        colStarMass.setCellValueFactory(new PropertyValueFactory<>("mass"));
        TableColumn<Stars, String> colStarGalaxy = new TableColumn<>("Galaxy");
        // Display galaxy name by looking up Galaxy based on galaxy_id
        colStarGalaxy.setCellValueFactory(cellData -> {
            int galId = cellData.getValue().getGalaxy_id();
            String galName = "";
            try {
                Galaxies gal = galaxyDAO.getGalaxyById(galId);
                if (gal != null) {
                    galName = gal.getName();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return new ReadOnlyStringWrapper(galName);
        });
        starTable.getColumns().addAll(colStarId, colStarName, colStarType, colStarMass, colStarGalaxy);
        
        TextField starNameField = new TextField();
        starNameField.setPromptText("Star Name");
        TextField starTypeField = new TextField();
        starTypeField.setPromptText("Star Type");
        TextField starMassField = new TextField();
        starMassField.setPromptText("Mass (solar)");
        ComboBox<Galaxies> starGalaxyCombo = new ComboBox<>();
        starGalaxyCombo.setPromptText("Galaxy");
        
        Button addStarBtn = new Button("Add");
        Button updateStarBtn = new Button("Update");
        Button deleteStarBtn = new Button("Delete");
        
        TextField starSearchField = new TextField();
        starSearchField.setPromptText("Search by name...");
        Button starSearchBtn = new Button("Search");
        
        VBox starForm = new VBox(5);
        starForm.getChildren().addAll(
            new Label("Name:"), starNameField,
            new Label("Type:"), starTypeField,
            new Label("Mass (solar):"), starMassField,
            new Label("Galaxy:"), starGalaxyCombo,
            new HBox(5, addStarBtn, updateStarBtn, deleteStarBtn)
        );
        starForm.setPadding(new Insets(10));
        
        BorderPane starPane = new BorderPane();
        starPane.setTop(new HBox(5, new Label("Search:"), starSearchField, starSearchBtn));
        ((HBox) starPane.getTop()).setPadding(new Insets(5));
        starPane.setLeft(starForm);
        starPane.setCenter(starTable);
        starPane.setPadding(new Insets(5));
        starTab.setContent(starPane);
        try {
            Image starIcon = new Image("file:C:/Users/saakshi/Downloads/Java BlueJ/CelestialJavaConnect/example/celestialDB/assets/star.png");
            starTab.setGraphic(new ImageView(starIcon));
        } catch (Exception e) {
            // ignore if icon not found
        }
        
        // ================== Exoplanet Tab UI ==================
        Tab exoTab = new Tab("Exoplanets");
        exoTab.setClosable(false);
        
        TableView<Exoplanets> exoTable = new TableView<>();
        exoTable.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        TableColumn<Exoplanets, Integer> colExoId = new TableColumn<>("ID");
        colExoId.setCellValueFactory(new PropertyValueFactory<>("exoplanet_id"));
        TableColumn<Exoplanets, String> colExoName = new TableColumn<>("Name");
        colExoName.setCellValueFactory(new PropertyValueFactory<>("name"));
        TableColumn<Exoplanets, String> colExoType = new TableColumn<>("Type");
        colExoType.setCellValueFactory(new PropertyValueFactory<>("type"));
        TableColumn<Exoplanets, Double> colExoPeriod = new TableColumn<>("Orbital Period (days)");
        colExoPeriod.setCellValueFactory(new PropertyValueFactory<>("orbital_period"));
        TableColumn<Exoplanets, String> colExoStar = new TableColumn<>("Star");
        // Display star name by looking up Star based on star_id
        colExoStar.setCellValueFactory(cellData -> {
            int starId = cellData.getValue().getStar_id();
            String starName = "";
            try {
                Stars s = starDAO.getStarById(starId);
                if (s != null) {
                    starName = s.getName();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return new ReadOnlyStringWrapper(starName);
        });
        exoTable.getColumns().addAll(colExoId, colExoName, colExoType, colExoPeriod, colExoStar);
        
        TextField exoNameField = new TextField();
        exoNameField.setPromptText("Exoplanet Name");
        TextField exoTypeField = new TextField();
        exoTypeField.setPromptText("Exoplanet Type");
        TextField exoPeriodField = new TextField();
        exoPeriodField.setPromptText("Orbital Period (days)");
        ComboBox<Stars> exoStarCombo = new ComboBox<>();
        exoStarCombo.setPromptText("Star");
        
        Button addExoBtn = new Button("Add");
        Button updateExoBtn = new Button("Update");
        Button deleteExoBtn = new Button("Delete");
        
        TextField exoSearchField = new TextField();
        exoSearchField.setPromptText("Search by name...");
        Button exoSearchBtn = new Button("Search");
        
        VBox exoForm = new VBox(5);
        exoForm.getChildren().addAll(
            new Label("Name:"), exoNameField,
            new Label("Type:"), exoTypeField,
            new Label("Orbital Period (days):"), exoPeriodField,
            new Label("Star:"), exoStarCombo,
            new HBox(5, addExoBtn, updateExoBtn, deleteExoBtn)
        );
        exoForm.setPadding(new Insets(10));
        
        BorderPane exoPane = new BorderPane();
        exoPane.setTop(new HBox(5, new Label("Search:"), exoSearchField, exoSearchBtn));
        ((HBox) exoPane.getTop()).setPadding(new Insets(5));
        exoPane.setLeft(exoForm);
        exoPane.setCenter(exoTable);
        exoPane.setPadding(new Insets(5));
        exoTab.setContent(exoPane);
        try {
            Image exoIcon = new Image("file:C:/Users/saakshi/Downloads/Java BlueJ/CelestialJavaConnect/example/celestialDB/assets/exoplanet.png");
            exoTab.setGraphic(new ImageView(exoIcon));
        } catch (Exception e) {
            // ignore if icon not found
        }
        
        // Add all tabs to the tab pane
        tabPane.getTabs().addAll(galaxyTab, starTab, exoTab);
        
        // ========== Initial Data Load ==========
        // Load initial data from the database to populate tables and combo boxes
        try {
            List<Galaxies> galaxies = galaxyDAO.getAllGalaxies();
            galaxyTable.setItems(FXCollections.observableArrayList(galaxies));
            // Populate Galaxy combo box in Star form
            starGalaxyCombo.setItems(FXCollections.observableArrayList(galaxies));
            
            List<Stars> stars = starDAO.getAllStars();
            starTable.setItems(FXCollections.observableArrayList(stars));
            // Populate Star combo box in Exoplanet form
            exoStarCombo.setItems(FXCollections.observableArrayList(starDAO.getAllStars()));
            
            List<Exoplanets> exoplanets = exoplanetDAO.getAllExoplanets();
            exoTable.setItems(FXCollections.observableArrayList(exoplanets));
        } catch (SQLException e) {
            showAlert("Database Connection Error", "Could not load initial data:\n" + e.getMessage(), Alert.AlertType.ERROR);
        }
        
        // ========== Event Handlers ==========
        // Handle table row selection to populate input fields
        galaxyTable.getSelectionModel().selectedItemProperty().addListener((obs, oldSel, newSel) -> {
            if (newSel != null) {
                galNameField.setText(newSel.getName());
                galTypeField.setText(newSel.getType());
                galDistanceField.setText(String.valueOf(newSel.getDistanceLY()));
            }
        });
        starTable.getSelectionModel().selectedItemProperty().addListener((obs, oldSel, newSel) -> {
            if (newSel != null) {
                starNameField.setText(newSel.getName());
                starTypeField.setText(newSel.getType());
                starMassField.setText(String.valueOf(newSel.getMass()));
                // Set Galaxy combo selection based on the star's galaxy_id
                Galaxies gal = null;
                try {
                    gal = galaxyDAO.getGalaxyById(newSel.getGalaxy_id());
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                starGalaxyCombo.setValue(gal);
            }
        });
        exoTable.getSelectionModel().selectedItemProperty().addListener((obs, oldSel, newSel) -> {
            if (newSel != null) {
                exoNameField.setText(newSel.getName());
                exoTypeField.setText(newSel.getType());
                exoPeriodField.setText(String.valueOf(newSel.getOrbital_period()));
                // Set Star combo selection based on the exoplanet's star_id
                Stars star = null;
                try {
                    star = starDAO.getStarById(newSel.getStar_id());
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                exoStarCombo.setValue(star);
            }
        });
        
        // Buttons - Galaxy: Add, Update, Delete, Search
        addGalaxyBtn.setOnAction(event -> {
            String name = galNameField.getText().trim();
            String type = galTypeField.getText().trim();
            String distText = galDistanceField.getText().trim();
            if (name.isEmpty() || distText.isEmpty()) {
                showAlert("Input Error", "Name and Distance are required for Galaxy.", Alert.AlertType.WARNING);
                return;
            }
            int distance;
            try {
                distance = Integer.parseInt(distText);
            } catch (NumberFormatException e) {
                showAlert("Input Error", "Distance must be an integer.", Alert.AlertType.WARNING);
                return;
            }
            Galaxies galaxy = new Galaxies(name, type, distance);
            try {
                galaxyDAO.addGalaxies(galaxy);
                galaxyTable.setItems(FXCollections.observableArrayList(galaxyDAO.getAllGalaxies()));
                // Update galaxy combo in Star tab in case a new galaxy was added
                starGalaxyCombo.setItems(FXCollections.observableArrayList(galaxyDAO.getAllGalaxies()));
                // Clear input fields
                galNameField.clear();
                galTypeField.clear();
                galDistanceField.clear();
            } catch (SQLException e) {
                showAlert("Database Error", "Failed to add galaxy:\n" + e.getMessage(), Alert.AlertType.ERROR);
            }
        });
        updateGalaxyBtn.setOnAction(event -> {
            Galaxies selected = galaxyTable.getSelectionModel().getSelectedItem();
            if (selected == null) {
                showAlert("No Selection", "No galaxy selected to update.", Alert.AlertType.WARNING);
                return;
            }
            String name = galNameField.getText().trim();
            String type = galTypeField.getText().trim();
            String distText = galDistanceField.getText().trim();
            if (name.isEmpty() || distText.isEmpty()) {
                showAlert("Input Error", "Name and Distance are required.", Alert.AlertType.WARNING);
                return;
            }
            int distance;
            try {
                distance = Integer.parseInt(distText);
            } catch (NumberFormatException e) {
                showAlert("Input Error", "Distance must be an integer.", Alert.AlertType.WARNING);
                return;
            }
            // Apply changes to selected object
            selected.setName(name);
            selected.setType(type);
            Galaxies updatedGalaxy = new Galaxies(selected.getGalaxy_id(), name, type, distance);
            try {
                galaxyDAO.updateGalaxy(updatedGalaxy);
                galaxyTable.setItems(FXCollections.observableArrayList(galaxyDAO.getAllGalaxies()));
                starGalaxyCombo.setItems(FXCollections.observableArrayList(galaxyDAO.getAllGalaxies()));
                galNameField.clear();
                galTypeField.clear();
                galDistanceField.clear();
                galaxyTable.getSelectionModel().clearSelection();
            } catch (SQLException e) {
                showAlert("Database Error", "Failed to update galaxy:\n" + e.getMessage(), Alert.AlertType.ERROR);
            }
        });
        deleteGalaxyBtn.setOnAction(event -> {
            Galaxies selected = galaxyTable.getSelectionModel().getSelectedItem();
            if (selected == null) {
                showAlert("No Selection", "No galaxy selected to delete.", Alert.AlertType.WARNING);
                return;
            }
            try {
                galaxyDAO.deleteGalaxy(selected.getGalaxy_id());
                galaxyTable.setItems(FXCollections.observableArrayList(galaxyDAO.getAllGalaxies()));
                starGalaxyCombo.setItems(FXCollections.observableArrayList(galaxyDAO.getAllGalaxies()));
                galNameField.clear();
                galTypeField.clear();
                galDistanceField.clear();
                galaxyTable.getSelectionModel().clearSelection();
            } catch (SQLException e) {
                showAlert("Database Error", "Failed to delete galaxy:\n" + e.getMessage(), Alert.AlertType.ERROR);
            }
        });
        galaxySearchBtn.setOnAction(event -> {
            String query = galaxySearchField.getText().trim();
            try {
                List<Galaxies> results;
                if (query.isEmpty()) {
                    results = galaxyDAO.getAllGalaxies();
                } else {
                    results = galaxyDAO.searchGalaxiesByName(query);
                }
                galaxyTable.setItems(FXCollections.observableArrayList(results));
            } catch (SQLException e) {
                showAlert("Database Error", "Search failed:\n" + e.getMessage(), Alert.AlertType.ERROR);
            }
        });
        
        // Buttons - Star: Add, Update, Delete, Search
        addStarBtn.setOnAction(event -> {
            String name = starNameField.getText().trim();
            String type = starTypeField.getText().trim();
            String massText = starMassField.getText().trim();
            Galaxies gal = starGalaxyCombo.getValue();
            if (name.isEmpty() || massText.isEmpty() || gal == null) {
                showAlert("Input Error", "Name, Mass, and Galaxy are required for Star.", Alert.AlertType.WARNING);
                return;
            }
            double mass;
            try {
                mass = Double.parseDouble(massText);
            } catch (NumberFormatException e) {
                showAlert("Input Error", "Mass must be a number.", Alert.AlertType.WARNING);
                return;
            }
            Stars star = new Stars(name, type, "", 0.0, mass, gal.getGalaxy_id());
            try {
                starDAO.addStar(star);
                starTable.setItems(FXCollections.observableArrayList(starDAO.getAllStars()));
                // Update star combo in Exoplanet tab in case a new star was added
                exoStarCombo.setItems(FXCollections.observableArrayList(starDAO.getAllStars()));
                starNameField.clear();
                starTypeField.clear();
                starMassField.clear();
                starGalaxyCombo.setValue(null);
            } catch (SQLException e) {
                showAlert("Database Error", "Failed to add star:\n" + e.getMessage(), Alert.AlertType.ERROR);
            }
        });
        updateStarBtn.setOnAction(event -> {
            Stars selected = starTable.getSelectionModel().getSelectedItem();
            if (selected == null) {
                showAlert("No Selection", "No star selected to update.", Alert.AlertType.WARNING);
                return;
            }
            String name = starNameField.getText().trim();
            String type = starTypeField.getText().trim();
            String massText = starMassField.getText().trim();
            Galaxies gal = starGalaxyCombo.getValue();
            if (name.isEmpty() || massText.isEmpty() || gal == null) {
                showAlert("Input Error", "Name, Mass, and Galaxy are required.", Alert.AlertType.WARNING);
                return;
            }
            double mass;
            try {
                mass = Double.parseDouble(massText);
            } catch (NumberFormatException e) {
                showAlert("Input Error", "Mass must be a number.", Alert.AlertType.WARNING);
                return;
            }
            selected.setName(name);
            selected.setType(type);
            selected.setMass(mass);
            selected.setGalaxy_id(gal.getGalaxy_id());
            try {
                starDAO.updateStar(selected);
                starTable.setItems(FXCollections.observableArrayList(starDAO.getAllStars()));
                exoStarCombo.setItems(FXCollections.observableArrayList(starDAO.getAllStars()));
                starNameField.clear();
                starTypeField.clear();
                starMassField.clear();
                starGalaxyCombo.setValue(null);
                starTable.getSelectionModel().clearSelection();
            } catch (SQLException e) {
                showAlert("Database Error", "Failed to update star:\n" + e.getMessage(), Alert.AlertType.ERROR);
            }
        });
        deleteStarBtn.setOnAction(event -> {
            Stars selected = starTable.getSelectionModel().getSelectedItem();
            if (selected == null) {
                showAlert("No Selection", "No star selected to delete.", Alert.AlertType.WARNING);
                return;
            }
            try {
                starDAO.deleteStar(selected.getStar_id());
                starTable.setItems(FXCollections.observableArrayList(starDAO.getAllStars()));
                exoStarCombo.setItems(FXCollections.observableArrayList(starDAO.getAllStars()));
                starNameField.clear();
                starTypeField.clear();
                starMassField.clear();
                starGalaxyCombo.setValue(null);
                starTable.getSelectionModel().clearSelection();
            } catch (SQLException e) {
                showAlert("Database Error", "Failed to delete star:\n" + e.getMessage(), Alert.AlertType.ERROR);
            }
        });
        starSearchBtn.setOnAction(event -> {
            String query = starSearchField.getText().trim();
            try {
                List<Stars> results;
                if (query.isEmpty()) {
                    results = starDAO.getAllStars();
                } else {
                    results = starDAO.searchStarsByName(query);
                }
                starTable.setItems(FXCollections.observableArrayList(results));
            } catch (SQLException e) {
                showAlert("Database Error", "Search failed:\n" + e.getMessage(), Alert.AlertType.ERROR);
            }
        });
        
        // Buttons - Exoplanet: Add, Update, Delete, Search
        addExoBtn.setOnAction(event -> {
            String name = exoNameField.getText().trim();
            String type = exoTypeField.getText().trim();
            String periodText = exoPeriodField.getText().trim();
            Stars star = exoStarCombo.getValue();
            if (name.isEmpty() || periodText.isEmpty() || star == null) {
                showAlert("Input Error", "Name, Orbital Period, and Star are required for Exoplanet.", Alert.AlertType.WARNING);
                return;
            }
            double period;
            try {
                period = Double.parseDouble(periodText);
            } catch (NumberFormatException e) {
                showAlert("Input Error", "Orbital Period must be a number.", Alert.AlertType.WARNING);
                return;
            }
            Exoplanets exo = new Exoplanets(name, type, 0.0, 0.0, period, star.getStar_id());
            try {
                exoplanetDAO.addExoplanet(exo);
                exoTable.setItems(FXCollections.observableArrayList(exoplanetDAO.getAllExoplanets()));
                exoNameField.clear();
                exoTypeField.clear();
                exoPeriodField.clear();
                exoStarCombo.setValue(null);
            } catch (SQLException e) {
                showAlert("Database Error", "Failed to add exoplanet:\n" + e.getMessage(), Alert.AlertType.ERROR);
            }
        });
        updateExoBtn.setOnAction(event -> {
            Exoplanets selected = exoTable.getSelectionModel().getSelectedItem();
            if (selected == null) {
                showAlert("No Selection", "No exoplanet selected to update.", Alert.AlertType.WARNING);
                return;
            }
            String name = exoNameField.getText().trim();
            String type = exoTypeField.getText().trim();
            String periodText = exoPeriodField.getText().trim();
            Stars star = exoStarCombo.getValue();
            if (name.isEmpty() || periodText.isEmpty() || star == null) {
                showAlert("Input Error", "Name, Orbital Period, and Star are required.", Alert.AlertType.WARNING);
                return;
            }
            double period;
            try {
                period = Double.parseDouble(periodText);
            } catch (NumberFormatException e) {
                showAlert("Input Error", "Orbital Period must be a number.", Alert.AlertType.WARNING);
                return;
            }
            selected.setName(name);
            selected.setType(type);
            selected.setOrbital_period(period);
            selected.setStar_id(star.getStar_id());
            try {
                exoplanetDAO.updateExoplanet(selected);
                exoTable.setItems(FXCollections.observableArrayList(exoplanetDAO.getAllExoplanets()));
                exoNameField.clear();
                exoTypeField.clear();
                exoPeriodField.clear();
                exoStarCombo.setValue(null);
                exoTable.getSelectionModel().clearSelection();
            } catch (SQLException e) {
                showAlert("Database Error", "Failed to update exoplanet:\n" + e.getMessage(), Alert.AlertType.ERROR);
            }
        });
        deleteExoBtn.setOnAction(event -> {
            Exoplanets selected = exoTable.getSelectionModel().getSelectedItem();
            if (selected == null) {
                showAlert("No Selection", "No exoplanet selected to delete.", Alert.AlertType.WARNING);
                return;
            }
            try {
                exoplanetDAO.deleteExoplanet(selected.getExoplanet_id());
                exoTable.setItems(FXCollections.observableArrayList(exoplanetDAO.getAllExoplanets()));
                exoNameField.clear();
                exoTypeField.clear();
                exoPeriodField.clear();
                exoStarCombo.setValue(null);
                exoTable.getSelectionModel().clearSelection();
            } catch (SQLException e) {
                showAlert("Database Error", "Failed to delete exoplanet:\n" + e.getMessage(), Alert.AlertType.ERROR);
            }
        });
        exoSearchBtn.setOnAction(event -> {
            String query = exoSearchField.getText().trim();
            try {
                List<Exoplanets> results;
                if (query.isEmpty()) {
                    results = exoplanetDAO.getAllExoplanets();
                } else {
                    results = exoplanetDAO.searchExoplanetsByName(query);
                }
                exoTable.setItems(FXCollections.observableArrayList(results));
            } catch (SQLException e) {
                showAlert("Database Error", "Search failed:\n" + e.getMessage(), Alert.AlertType.ERROR);
            }
        });
        
        // Show the main window (scene) containing the tab pane
        Scene scene = new Scene(tabPane, 800, 500);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    /**
     * Utility method to show an alert dialog for errors or warnings.
     */
    private void showAlert(String title, String message, Alert.AlertType type) {
        Alert alert = new Alert(type);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
