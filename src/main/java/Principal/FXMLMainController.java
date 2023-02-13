package Principal;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javax.swing.JOptionPane;
import javafx.scene.Node;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.scene.image.Image;
import com.github.javafaker.Faker;
import java.io.IOException;
import java.util.Locale;
import java.util.Random;
import javafx.beans.binding.Bindings;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;

/**
 * FXML Controller class
 *
 * @author USUARIO
 */
public class FXMLMainController {

    @FXML
    public Label label;
    @FXML
    public Label teclado;
    @FXML
    public Pane CAJAINTERAC;
    @FXML
    public Button cajaSalida;
    @FXML
    public Button RESOLVER;
    @FXML
    public Button GENERAR;
    @FXML
    public Button INSTRUCCIONES;
    @FXML
    public AnchorPane CajaPrincipal;
    @FXML
    ImageView IMAGPRISI;
    int contadorImagen = 0;
    Image[] arrayImagenes = new Image[7];
    String[] palabrasRamdom = new String[5];
    Faker faker = new Faker(new Locale("es"));
    public Random random = new Random();
    int randomIndex;
    StringBuilder palabraOc1 = new StringBuilder("");
    StringProperty textoPropiedad = new SimpleStringProperty(palabraOc1.toString());
    char letraGuia;
    char letra;
    byte muerto = 0;

    @FXML
    public Button A;
    @FXML
    public Button B;
    @FXML
    public Button C;
    @FXML
    public Button D;
    @FXML
    public Button E;
    @FXML
    public Button F;
    @FXML
    public Button G;
    @FXML
    public Button H;
    @FXML
    public Button I;
    @FXML
    public Button J;
    @FXML
    public Button K;
    @FXML
    public Button L;
    @FXML
    public Button M;
    @FXML
    public Button N;
    @FXML
    public Button Ñ;
    @FXML
    public Button O;
    @FXML
    public Button P;
    @FXML
    public Button Q;
    @FXML
    public Button R;
    @FXML
    public Button S;
    @FXML
    public Button T;
    @FXML
    public Button U;
    @FXML
    public Button V;
    @FXML
    public Button W;
    @FXML
    public Button X;
    @FXML
    public Button Y;
    @FXML
    public Button Z;
    @FXML
    public Pane CAJAINTERAC1;
    @FXML
    public Label PalabraOcul;
    @FXML
    public Pane CAJAINTERAC11;

    public void initialize() throws IOException {
        arrayImagenes[0] = new Image("/imagen/prisionero0.png");
        arrayImagenes[1] = new Image("/imagen/prisionero1.png");
        arrayImagenes[2] = new Image("/imagen/prisionero2.png");
        arrayImagenes[3] = new Image("/imagen/prisionero3.png");
        arrayImagenes[4] = new Image("/imagen/prisionero4.png");
        arrayImagenes[5] = new Image("/imagen/prisionero5.png");
        arrayImagenes[6] = new Image("/imagen/prisionero6.png");

        for (int i = 0; i < 5; i++) {
            palabrasRamdom[i] = faker.address().country().toUpperCase();
        }

        randomIndex = random.nextInt(palabrasRamdom.length);
        for (int i = 0; i < palabrasRamdom[randomIndex].length(); i++) {
            letraGuia = palabrasRamdom[randomIndex].charAt(i);

            if (letraGuia == ' ') {
                palabraOc1.append(" ");
                textoPropiedad.setValue(palabraOc1.toString());
            } else {
                palabraOc1.append("_");
                textoPropiedad.setValue(palabraOc1.toString());
            }

        }
        Bindings.bindBidirectional(PalabraOcul.textProperty(), textoPropiedad);

        RESOLVER.setOnAction(event -> {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Palabra Oculta");
            alert.setHeaderText(null);
            alert.setContentText(palabrasRamdom[randomIndex]);
            alert.show();
        });
    }

    /**
     * Initializes the controller class.
     */
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    public void NUEVO(javafx.event.ActionEvent event) throws IOException {
        Stage currentStage = (Stage) GENERAR.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/Scene.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        currentStage.setScene(scene);
        currentStage.show();
    }

    @FXML
    public void A(javafx.event.ActionEvent event) throws IOException {
        int cont = 0;
        int ganar = 0;
        for (int i = 0; i < palabrasRamdom[randomIndex].length(); i++) {
            letra = palabraOc1.charAt(i);
            if (palabrasRamdom[randomIndex].charAt(i) == 'A') {
                palabraOc1.replace(i, i + 1, "A");
                textoPropiedad.setValue(palabraOc1.toString());
                cont++;
            }
        }
        for (int i = 0; i < palabrasRamdom[randomIndex].length(); i++) {
            if (palabraOc1.charAt(i) == '_') {
                ganar++;

            }
            if (palabrasRamdom[randomIndex].length() - 1 == i) {
                if (ganar == 0) {
                    JOptionPane.showMessageDialog(null, "Has ganado");
                    Stage currentStage = (Stage) GENERAR.getScene().getWindow();
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/Scene.fxml"));
                    Parent root = loader.load();
                    Scene scene = new Scene(root);
                    currentStage.setScene(scene);
                    currentStage.show();
                }
            }
        }
        if (cont == 0) {
            A.setStyle("-fx-background-color: red;");
            contadorImagen++;
            if (contadorImagen < arrayImagenes.length) {
                IMAGPRISI.setImage(arrayImagenes[contadorImagen]);
                muerto++;
                if (muerto == 6) {
                    JOptionPane.showMessageDialog(null, "Lo lamentamos, su suerte se acabo");
                    Stage currentStage = (Stage) GENERAR.getScene().getWindow();
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/Scene.fxml"));
                    Parent root = loader.load();
                    Scene scene = new Scene(root);
                    currentStage.setScene(scene);
                    currentStage.show();
                }
            }
            A.setDisable(true);
        }
    }

    @FXML
    public void B(javafx.event.ActionEvent event) throws IOException {
        int cont = 0;
        int ganar = 0;
        for (int i = 0; i < palabrasRamdom[randomIndex].length(); i++) {
            letra = palabraOc1.charAt(i);
            if (palabrasRamdom[randomIndex].charAt(i) == 'B') {
                palabraOc1.replace(i, i + 1, "B");
                textoPropiedad.setValue(palabraOc1.toString());
                cont++;
            }
        }
        for (int i = 0; i < palabrasRamdom[randomIndex].length(); i++) {
            if (palabraOc1.charAt(i) == '_') {
                ganar++;
            }
            if (palabrasRamdom[randomIndex].length() - 1 == i) {
                if (ganar == 0) {
                    JOptionPane.showMessageDialog(null, "Has ganado");
                    Stage currentStage = (Stage) GENERAR.getScene().getWindow();
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/Scene.fxml"));
                    Parent root = loader.load();
                    Scene scene = new Scene(root);
                    currentStage.setScene(scene);
                    currentStage.show();
                }
            }
        }
        if (cont == 0) {
            B.setStyle("-fx-background-color: red;");
            contadorImagen++;
            if (contadorImagen < arrayImagenes.length) {
                IMAGPRISI.setImage(arrayImagenes[contadorImagen]);
                muerto++;
                if (muerto == 6) {
                    JOptionPane.showMessageDialog(null, "Lo lamentamos, su suerte se acabo");
                    Stage currentStage = (Stage) GENERAR.getScene().getWindow();
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/Scene.fxml"));
                    Parent root = loader.load();
                    Scene scene = new Scene(root);
                    currentStage.setScene(scene);
                    currentStage.show();
                }
            }
            B.setDisable(true);
        }
    }

    @FXML
    public void C(javafx.event.ActionEvent event) throws IOException {
        int cont = 0;
        int ganar = 0;
        for (int i = 0; i < palabrasRamdom[randomIndex].length(); i++) {
            letra = palabraOc1.charAt(i);
            if (palabrasRamdom[randomIndex].charAt(i) == 'C') {
                palabraOc1.replace(i, i + 1, "C");
                textoPropiedad.setValue(palabraOc1.toString());
                cont++;
            }
        }
        for (int i = 0; i < palabrasRamdom[randomIndex].length(); i++) {
            if (palabraOc1.charAt(i) == '_') {
                ganar++;
            }
            if (palabrasRamdom[randomIndex].length() - 1 == i) {
                if (ganar == 0) {
                    JOptionPane.showMessageDialog(null, "Has ganado");
                    Stage currentStage = (Stage) GENERAR.getScene().getWindow();
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/Scene.fxml"));
                    Parent root = loader.load();
                    Scene scene = new Scene(root);
                    currentStage.setScene(scene);
                    currentStage.show();
                }
            }
        }
        if (cont == 0) {
            C.setStyle("-fx-background-color: red;");
            contadorImagen++;
            if (contadorImagen < arrayImagenes.length) {
                IMAGPRISI.setImage(arrayImagenes[contadorImagen]);
                muerto++;
                if (muerto == 6) {
                    JOptionPane.showMessageDialog(null, "Lo lamentamos, su suerte se acabo");
                    Stage currentStage = (Stage) GENERAR.getScene().getWindow();
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/Scene.fxml"));
                    Parent root = loader.load();
                    Scene scene = new Scene(root);
                    currentStage.setScene(scene);
                    currentStage.show();
                }
            }
            C.setDisable(true);
        }
    }

    @FXML
    public void D(javafx.event.ActionEvent event) throws IOException {
        int cont = 0;
        int ganar = 0;
        for (int i = 0; i < palabrasRamdom[randomIndex].length(); i++) {
            letra = palabraOc1.charAt(i);
            if (palabrasRamdom[randomIndex].charAt(i) == 'D') {
                palabraOc1.replace(i, i + 1, "D");
                textoPropiedad.setValue(palabraOc1.toString());
                cont++;
            }

        }
        for (int i = 0; i < palabrasRamdom[randomIndex].length(); i++) {
            if (palabraOc1.charAt(i) == '_') {
                ganar++;
            }
            if (palabrasRamdom[randomIndex].length() - 1 == i) {
                if (ganar == 0) {
                    JOptionPane.showMessageDialog(null, "Has ganado");
                    Stage currentStage = (Stage) GENERAR.getScene().getWindow();
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/Scene.fxml"));
                    Parent root = loader.load();
                    Scene scene = new Scene(root);
                    currentStage.setScene(scene);
                    currentStage.show();
                }
            }
        }
        if (cont == 0) {
            D.setStyle("-fx-background-color: red;");
            contadorImagen++;
            if (contadorImagen < arrayImagenes.length) {
                IMAGPRISI.setImage(arrayImagenes[contadorImagen]);
                muerto++;
                if (muerto == 6) {
                    JOptionPane.showMessageDialog(null, "Lo lamentamos, su suerte se acabo");
                    Stage currentStage = (Stage) GENERAR.getScene().getWindow();
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/Scene.fxml"));
                    Parent root = loader.load();
                    Scene scene = new Scene(root);
                    currentStage.setScene(scene);
                    currentStage.show();
                }
            }
            D.setDisable(true);
        }
    }

    @FXML
    public void E(javafx.event.ActionEvent event) throws IOException {
        int cont = 0;
        int ganar = 0;
        for (int i = 0; i < palabrasRamdom[randomIndex].length(); i++) {
            letra = palabraOc1.charAt(i);
            if (palabrasRamdom[randomIndex].charAt(i) == 'E') {
                palabraOc1.replace(i, i + 1, "E");
                textoPropiedad.setValue(palabraOc1.toString());
                cont++;
            }

        }
        for (int i = 0; i < palabrasRamdom[randomIndex].length(); i++) {
            if (palabraOc1.charAt(i) == '_') {
                ganar++;
            }
            if (palabrasRamdom[randomIndex].length() - 1 == i) {
                if (ganar == 0) {
                    JOptionPane.showMessageDialog(null, "Has ganado");
                    Stage currentStage = (Stage) GENERAR.getScene().getWindow();
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/Scene.fxml"));
                    Parent root = loader.load();
                    Scene scene = new Scene(root);
                    currentStage.setScene(scene);
                    currentStage.show();
                }
            }
        }
        if (cont == 0) {
            E.setStyle("-fx-background-color: red;");
            contadorImagen++;
            if (contadorImagen < arrayImagenes.length) {
                IMAGPRISI.setImage(arrayImagenes[contadorImagen]);
                muerto++;
                if (muerto == 6) {
                    JOptionPane.showMessageDialog(null, "Lo lamentamos, su suerte se acabo");
                    Stage currentStage = (Stage) GENERAR.getScene().getWindow();
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/Scene.fxml"));
                    Parent root = loader.load();
                    Scene scene = new Scene(root);
                    currentStage.setScene(scene);
                    currentStage.show();
                }
            }
            E.setDisable(true);
        }
    }

    @FXML
    public void F(javafx.event.ActionEvent event) throws IOException {
        int cont = 0;
        int ganar = 0;
        for (int i = 0; i < palabrasRamdom[randomIndex].length(); i++) {
            letra = palabraOc1.charAt(i);
            if (palabrasRamdom[randomIndex].charAt(i) == 'F') {
                palabraOc1.replace(i, i + 1, "F");
                textoPropiedad.setValue(palabraOc1.toString());
                cont++;
            }

        }
        for (int i = 0; i < palabrasRamdom[randomIndex].length(); i++) {
            if (palabraOc1.charAt(i) == '_') {
                ganar++;
            }
            if (palabrasRamdom[randomIndex].length() - 1 == i) {
                if (ganar == 0) {
                    JOptionPane.showMessageDialog(null, "Has ganado");
                    Stage currentStage = (Stage) GENERAR.getScene().getWindow();
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/Scene.fxml"));
                    Parent root = loader.load();
                    Scene scene = new Scene(root);
                    currentStage.setScene(scene);
                    currentStage.show();
                }
            }
        }
        if (cont == 0) {
            F.setStyle("-fx-background-color: red;");
            contadorImagen++;
            if (contadorImagen < arrayImagenes.length) {
                IMAGPRISI.setImage(arrayImagenes[contadorImagen]);
                muerto++;
                if (muerto == 6) {
                    JOptionPane.showMessageDialog(null, "Lo lamentamos, su suerte se acabo");
                    Stage currentStage = (Stage) GENERAR.getScene().getWindow();
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/Scene.fxml"));
                    Parent root = loader.load();
                    Scene scene = new Scene(root);
                    currentStage.setScene(scene);
                    currentStage.show();
                }
            }
            F.setDisable(true);
        }
    }

    @FXML
    public void G(javafx.event.ActionEvent event) throws IOException {
        int cont = 0;
        int ganar = 0;
        for (int i = 0; i < palabrasRamdom[randomIndex].length(); i++) {
            letra = palabraOc1.charAt(i);
            if (palabrasRamdom[randomIndex].charAt(i) == 'G') {
                palabraOc1.replace(i, i + 1, "G");
                textoPropiedad.setValue(palabraOc1.toString());
                cont++;
            }

        }
        for (int i = 0; i < palabrasRamdom[randomIndex].length(); i++) {
            if (palabraOc1.charAt(i) == '_') {
                ganar++;
            }
            if (palabrasRamdom[randomIndex].length() - 1 == i) {
                if (ganar == 0) {
                    JOptionPane.showMessageDialog(null, "Has ganado");
                    Stage currentStage = (Stage) GENERAR.getScene().getWindow();
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/Scene.fxml"));
                    Parent root = loader.load();
                    Scene scene = new Scene(root);
                    currentStage.setScene(scene);
                    currentStage.show();
                }
            }
        }
        if (cont == 0) {
            G.setStyle("-fx-background-color: red;");
            contadorImagen++;
            if (contadorImagen < arrayImagenes.length) {
                IMAGPRISI.setImage(arrayImagenes[contadorImagen]);
                muerto++;
                if (muerto == 6) {
                    JOptionPane.showMessageDialog(null, "Lo lamentamos, su suerte se acabo");
                    Stage currentStage = (Stage) GENERAR.getScene().getWindow();
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/Scene.fxml"));
                    Parent root = loader.load();
                    Scene scene = new Scene(root);
                    currentStage.setScene(scene);
                    currentStage.show();
                }
            }
            G.setDisable(true);
        }
    }

    @FXML
    public void H(javafx.event.ActionEvent event) throws IOException {
        int cont = 0;
        int ganar = 0;
        for (int i = 0; i < palabrasRamdom[randomIndex].length(); i++) {
            letra = palabraOc1.charAt(i);
            if (palabrasRamdom[randomIndex].charAt(i) == 'H') {
                palabraOc1.replace(i, i + 1, "H");
                textoPropiedad.setValue(palabraOc1.toString());
                cont++;
            }
        }
        for (int i = 0; i < palabrasRamdom[randomIndex].length(); i++) {
            if (palabraOc1.charAt(i) == '_') {
                ganar++;
            }
            if (palabrasRamdom[randomIndex].length() - 1 == i) {
                if (ganar == 0) {
                    JOptionPane.showMessageDialog(null, "Has ganado");
                    Stage currentStage = (Stage) GENERAR.getScene().getWindow();
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/Scene.fxml"));
                    Parent root = loader.load();
                    Scene scene = new Scene(root);
                    currentStage.setScene(scene);
                    currentStage.show();
                }
            }
        }
        if (cont == 0) {
            H.setStyle("-fx-background-color: red;");
            contadorImagen++;
            if (contadorImagen < arrayImagenes.length) {
                IMAGPRISI.setImage(arrayImagenes[contadorImagen]);
                muerto++;
                if (muerto == 6) {
                    JOptionPane.showMessageDialog(null, "Lo lamentamos, su suerte se acabo");
                    Stage currentStage = (Stage) GENERAR.getScene().getWindow();
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/Scene.fxml"));
                    Parent root = loader.load();
                    Scene scene = new Scene(root);
                    currentStage.setScene(scene);
                    currentStage.show();
                }
            }
            H.setDisable(true);
        }
    }

    @FXML
    public void I(javafx.event.ActionEvent event) throws IOException {
        int cont = 0;
        int ganar = 0;
        for (int i = 0; i < palabrasRamdom[randomIndex].length(); i++) {
            letra = palabraOc1.charAt(i);
            if (palabrasRamdom[randomIndex].charAt(i) == 'I') {
                palabraOc1.replace(i, i + 1, "I");
                textoPropiedad.setValue(palabraOc1.toString());
                cont++;
            }
        }
        for (int i = 0; i < palabrasRamdom[randomIndex].length(); i++) {
            if (palabraOc1.charAt(i) == '_') {
                ganar++;
            }
            if (palabrasRamdom[randomIndex].length() - 1 == i) {
                if (ganar == 0) {
                    JOptionPane.showMessageDialog(null, "Has ganado");
                    Stage currentStage = (Stage) GENERAR.getScene().getWindow();
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/Scene.fxml"));
                    Parent root = loader.load();
                    Scene scene = new Scene(root);
                    currentStage.setScene(scene);
                    currentStage.show();
                }
            }
        }
        if (cont == 0) {
            I.setStyle("-fx-background-color: red;");
            contadorImagen++;
            if (contadorImagen < arrayImagenes.length) {
                IMAGPRISI.setImage(arrayImagenes[contadorImagen]);
                muerto++;
                if (muerto == 6) {
                    JOptionPane.showMessageDialog(null, "Lo lamentamos, su suerte se acabo");
                    Stage currentStage = (Stage) GENERAR.getScene().getWindow();
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/Scene.fxml"));
                    Parent root = loader.load();
                    Scene scene = new Scene(root);
                    currentStage.setScene(scene);
                    currentStage.show();
                }
            }
            I.setDisable(true);
        }
    }

    @FXML
    public void J(javafx.event.ActionEvent event) throws IOException {
        int cont = 0;
        int ganar = 0;
        for (int i = 0; i < palabrasRamdom[randomIndex].length(); i++) {
            letra = palabraOc1.charAt(i);
            if (palabrasRamdom[randomIndex].charAt(i) == 'J') {
                palabraOc1.replace(i, i + 1, "J");
                textoPropiedad.setValue(palabraOc1.toString());
                cont++;
            }
        }
        for (int i = 0; i < palabrasRamdom[randomIndex].length(); i++) {
            if (palabraOc1.charAt(i) == '_') {
                ganar++;
            }
            if (palabrasRamdom[randomIndex].length() - 1 == i) {
                if (ganar == 0) {
                    JOptionPane.showMessageDialog(null, "Has ganado");
                    Stage currentStage = (Stage) GENERAR.getScene().getWindow();
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/Scene.fxml"));
                    Parent root = loader.load();
                    Scene scene = new Scene(root);
                    currentStage.setScene(scene);
                    currentStage.show();
                }
            }
        }
        if (cont == 0) {
            J.setStyle("-fx-background-color: red;");
            contadorImagen++;
            if (contadorImagen < arrayImagenes.length) {
                IMAGPRISI.setImage(arrayImagenes[contadorImagen]);
                muerto++;
                if (muerto == 6) {
                    JOptionPane.showMessageDialog(null, "Lo lamentamos, su suerte se acabo");
                    Stage currentStage = (Stage) GENERAR.getScene().getWindow();
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/Scene.fxml"));
                    Parent root = loader.load();
                    Scene scene = new Scene(root);
                    currentStage.setScene(scene);
                    currentStage.show();
                }
            }
            J.setDisable(true);
        }
    }

    @FXML
    public void K(javafx.event.ActionEvent event) throws IOException {
        int cont = 0;
        int ganar = 0;
        for (int i = 0; i < palabrasRamdom[randomIndex].length(); i++) {
            letra = palabraOc1.charAt(i);
            if (palabrasRamdom[randomIndex].charAt(i) == 'K') {
                palabraOc1.replace(i, i + 1, "K");
                textoPropiedad.setValue(palabraOc1.toString());
                cont++;
            }
        }
        for (int i = 0; i < palabrasRamdom[randomIndex].length(); i++) {
            if (palabraOc1.charAt(i) == '_') {
                ganar++;
            }
            if (palabrasRamdom[randomIndex].length() - 1 == i) {
                if (ganar == 0) {
                    JOptionPane.showMessageDialog(null, "Has ganado");
                    Stage currentStage = (Stage) GENERAR.getScene().getWindow();
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/Scene.fxml"));
                    Parent root = loader.load();
                    Scene scene = new Scene(root);
                    currentStage.setScene(scene);
                    currentStage.show();
                }
            }
        }
        if (cont == 0) {
            K.setStyle("-fx-background-color: red;");
            contadorImagen++;
            if (contadorImagen < arrayImagenes.length) {
                IMAGPRISI.setImage(arrayImagenes[contadorImagen]);
                muerto++;
                if (muerto == 6) {
                    JOptionPane.showMessageDialog(null, "Lo lamentamos, su suerte se acabo");
                    Stage currentStage = (Stage) GENERAR.getScene().getWindow();
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/Scene.fxml"));
                    Parent root = loader.load();
                    Scene scene = new Scene(root);
                    currentStage.setScene(scene);
                    currentStage.show();
                }
            }
            K.setDisable(true);
        }
    }

    @FXML
    public void L(javafx.event.ActionEvent event) throws IOException {
        int cont = 0;
        int ganar = 0;
        for (int i = 0; i < palabrasRamdom[randomIndex].length(); i++) {
            letra = palabraOc1.charAt(i);
            if (palabrasRamdom[randomIndex].charAt(i) == 'L') {
                palabraOc1.replace(i, i + 1, "L");
                textoPropiedad.setValue(palabraOc1.toString());
                cont++;
            }
        }
        for (int i = 0; i < palabrasRamdom[randomIndex].length(); i++) {
            if (palabraOc1.charAt(i) == '_') {
                ganar++;
            }
            if (palabrasRamdom[randomIndex].length() - 1 == i) {
                if (ganar == 0) {
                    JOptionPane.showMessageDialog(null, "Has ganado");
                    Stage currentStage = (Stage) GENERAR.getScene().getWindow();
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/Scene.fxml"));
                    Parent root = loader.load();
                    Scene scene = new Scene(root);
                    currentStage.setScene(scene);
                    currentStage.show();
                }
            }
        }
        if (cont == 0) {
            L.setStyle("-fx-background-color: red;");
            contadorImagen++;
            if (contadorImagen < arrayImagenes.length) {
                IMAGPRISI.setImage(arrayImagenes[contadorImagen]);
                muerto++;
                if (muerto == 6) {
                    JOptionPane.showMessageDialog(null, "Lo lamentamos, su suerte se acabo");
                    Stage currentStage = (Stage) GENERAR.getScene().getWindow();
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/Scene.fxml"));
                    Parent root = loader.load();
                    Scene scene = new Scene(root);
                    currentStage.setScene(scene);
                    currentStage.show();
                }
            }
            L.setDisable(true);
        }
    }

    @FXML
    public void M(javafx.event.ActionEvent event) throws IOException {
        int cont = 0;
        int ganar = 0;
        for (int i = 0; i < palabrasRamdom[randomIndex].length(); i++) {
            letra = palabraOc1.charAt(i);
            if (palabrasRamdom[randomIndex].charAt(i) == 'M') {
                palabraOc1.replace(i, i + 1, "M");
                textoPropiedad.setValue(palabraOc1.toString());
                cont++;
            }
        }
        for (int i = 0; i < palabrasRamdom[randomIndex].length(); i++) {
            if (palabraOc1.charAt(i) == '_') {
                ganar++;
            }
            if (palabrasRamdom[randomIndex].length() - 1 == i) {
                if (ganar == 0) {
                    JOptionPane.showMessageDialog(null, "Has ganado");
                    Stage currentStage = (Stage) GENERAR.getScene().getWindow();
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/Scene.fxml"));
                    Parent root = loader.load();
                    Scene scene = new Scene(root);
                    currentStage.setScene(scene);
                    currentStage.show();
                }
            }
        }
        if (cont == 0) {
            M.setStyle("-fx-background-color: red;");
            contadorImagen++;
            if (contadorImagen < arrayImagenes.length) {
                IMAGPRISI.setImage(arrayImagenes[contadorImagen]);
                muerto++;
                if (muerto == 6) {
                    JOptionPane.showMessageDialog(null, "Lo lamentamos, su suerte se acabo");
                    Stage currentStage = (Stage) GENERAR.getScene().getWindow();
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/Scene.fxml"));
                    Parent root = loader.load();
                    Scene scene = new Scene(root);
                    currentStage.setScene(scene);
                    currentStage.show();
                }
            }
            M.setDisable(true);
        }
    }

    @FXML
    public void N(javafx.event.ActionEvent event) throws IOException {
        int cont = 0;
        int ganar = 0;
        for (int i = 0; i < palabrasRamdom[randomIndex].length(); i++) {
            letra = palabraOc1.charAt(i);
            if (palabrasRamdom[randomIndex].charAt(i) == 'N') {
                palabraOc1.replace(i, i + 1, "N");
                textoPropiedad.setValue(palabraOc1.toString());
                cont++;
            }
        }
        for (int i = 0; i < palabrasRamdom[randomIndex].length(); i++) {
            if (palabraOc1.charAt(i) == '_') {
                ganar++;
            }
            if (palabrasRamdom[randomIndex].length() - 1 == i) {
                if (ganar == 0) {
                    JOptionPane.showMessageDialog(null, "Has ganado");
                    Stage currentStage = (Stage) GENERAR.getScene().getWindow();
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/Scene.fxml"));
                    Parent root = loader.load();
                    Scene scene = new Scene(root);
                    currentStage.setScene(scene);
                    currentStage.show();
                }
            }
        }
        if (cont == 0) {
            N.setStyle("-fx-background-color: red;");
            contadorImagen++;
            if (contadorImagen < arrayImagenes.length) {
                IMAGPRISI.setImage(arrayImagenes[contadorImagen]);
                muerto++;
                if (muerto == 6) {
                    JOptionPane.showMessageDialog(null, "Lo lamentamos, su suerte se acabo");
                    Stage currentStage = (Stage) GENERAR.getScene().getWindow();
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/Scene.fxml"));
                    Parent root = loader.load();
                    Scene scene = new Scene(root);
                    currentStage.setScene(scene);
                    currentStage.show();
                }
            }
            N.setDisable(true);
        }
    }

    @FXML
    public void Ñ(javafx.event.ActionEvent event) throws IOException {
        int cont = 0;
        int ganar = 0;
        for (int i = 0; i < palabrasRamdom[randomIndex].length(); i++) {
            letra = palabraOc1.charAt(i);
            if (palabrasRamdom[randomIndex].charAt(i) == 'Ñ') {
                palabraOc1.replace(i, i + 1, "Ñ");
                textoPropiedad.setValue(palabraOc1.toString());
                cont++;
            }
        }
        for (int i = 0; i < palabrasRamdom[randomIndex].length(); i++) {
            if (palabraOc1.charAt(i) == '_') {
                ganar++;
            }
            if (palabrasRamdom[randomIndex].length() - 1 == i) {
                if (ganar == 0) {
                    JOptionPane.showMessageDialog(null, "Has ganado");
                    Stage currentStage = (Stage) GENERAR.getScene().getWindow();
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/Scene.fxml"));
                    Parent root = loader.load();
                    Scene scene = new Scene(root);
                    currentStage.setScene(scene);
                    currentStage.show();
                }
            }
        }
        if (cont == 0) {
            Ñ.setStyle("-fx-background-color: red;");
            contadorImagen++;
            if (contadorImagen < arrayImagenes.length) {
                IMAGPRISI.setImage(arrayImagenes[contadorImagen]);
                muerto++;
                if (muerto == 6) {
                    JOptionPane.showMessageDialog(null, "Lo lamentamos, su suerte se acabo");
                    Stage currentStage = (Stage) GENERAR.getScene().getWindow();
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/Scene.fxml"));
                    Parent root = loader.load();
                    Scene scene = new Scene(root);
                    currentStage.setScene(scene);
                    currentStage.show();
                }
            }
            Ñ.setDisable(true);
        }
    }

    @FXML
    public void O(javafx.event.ActionEvent event) throws IOException {
        int cont = 0;
        int ganar = 0;
        for (int i = 0; i < palabrasRamdom[randomIndex].length(); i++) {
            letra = palabraOc1.charAt(i);
            if (palabrasRamdom[randomIndex].charAt(i) == 'O') {
                palabraOc1.replace(i, i + 1, "O");
                textoPropiedad.setValue(palabraOc1.toString());
                cont++;
            }
        }
        for (int i = 0; i < palabrasRamdom[randomIndex].length(); i++) {
            if (palabraOc1.charAt(i) == '_') {
                ganar++;
            }
            if (palabrasRamdom[randomIndex].length() - 1 == i) {
                if (ganar == 0) {
                    JOptionPane.showMessageDialog(null, "Has ganado");
                    Stage currentStage = (Stage) GENERAR.getScene().getWindow();
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/Scene.fxml"));
                    Parent root = loader.load();
                    Scene scene = new Scene(root);
                    currentStage.setScene(scene);
                    currentStage.show();
                }
            }
        }
        if (cont == 0) {
            O.setStyle("-fx-background-color: red;");
            contadorImagen++;
            if (contadorImagen < arrayImagenes.length) {
                IMAGPRISI.setImage(arrayImagenes[contadorImagen]);
                muerto++;
                if (muerto == 6) {
                    JOptionPane.showMessageDialog(null, "Lo lamentamos, su suerte se acabo");
                    Stage currentStage = (Stage) GENERAR.getScene().getWindow();
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/Scene.fxml"));
                    Parent root = loader.load();
                    Scene scene = new Scene(root);
                    currentStage.setScene(scene);
                    currentStage.show();
                }
            }
            O.setDisable(true);
        }
    }

    @FXML
    public void P(javafx.event.ActionEvent event) throws IOException {
        int cont = 0;
        int ganar = 0;
        for (int i = 0; i < palabrasRamdom[randomIndex].length(); i++) {
            letra = palabraOc1.charAt(i);
            if (palabrasRamdom[randomIndex].charAt(i) == 'P') {
                palabraOc1.replace(i, i + 1, "P");
                textoPropiedad.setValue(palabraOc1.toString());
                cont++;
            }
        }
        for (int i = 0; i < palabrasRamdom[randomIndex].length(); i++) {
            if (palabraOc1.charAt(i) == '_') {
                ganar++;
            }
            if (palabrasRamdom[randomIndex].length() - 1 == i) {
                if (ganar == 0) {
                    JOptionPane.showMessageDialog(null, "Has ganado");
                    Stage currentStage = (Stage) GENERAR.getScene().getWindow();
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/Scene.fxml"));
                    Parent root = loader.load();
                    Scene scene = new Scene(root);
                    currentStage.setScene(scene);
                    currentStage.show();
                }
            }
        }
        if (cont == 0) {
            P.setStyle("-fx-background-color: red;");
            contadorImagen++;
            if (contadorImagen < arrayImagenes.length) {
                IMAGPRISI.setImage(arrayImagenes[contadorImagen]);
                muerto++;
                if (muerto == 6) {
                    JOptionPane.showMessageDialog(null, "Lo lamentamos, su suerte se acabo");
                    Stage currentStage = (Stage) GENERAR.getScene().getWindow();
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/Scene.fxml"));
                    Parent root = loader.load();
                    Scene scene = new Scene(root);
                    currentStage.setScene(scene);
                    currentStage.show();
                }
            }
            P.setDisable(true);
        }
    }

    @FXML
    public void Q(javafx.event.ActionEvent event) throws IOException {
        int cont = 0;
        int ganar = 0;
        for (int i = 0; i < palabrasRamdom[randomIndex].length(); i++) {
            letra = palabraOc1.charAt(i);
            if (palabrasRamdom[randomIndex].charAt(i) == 'Q') {
                palabraOc1.replace(i, i + 1, "Q");
                textoPropiedad.setValue(palabraOc1.toString());
                cont++;
            }
        }
        for (int i = 0; i < palabrasRamdom[randomIndex].length(); i++) {
            if (palabraOc1.charAt(i) == '_') {
                ganar++;
            }
            if (palabrasRamdom[randomIndex].length() - 1 == i) {
                if (ganar == 0) {
                    JOptionPane.showMessageDialog(null, "Has ganado");
                    Stage currentStage = (Stage) GENERAR.getScene().getWindow();
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/Scene.fxml"));
                    Parent root = loader.load();
                    Scene scene = new Scene(root);
                    currentStage.setScene(scene);
                    currentStage.show();
                }
            }
        }
        if (cont == 0) {
            Q.setStyle("-fx-background-color: red;");
            contadorImagen++;
            if (contadorImagen < arrayImagenes.length) {
                IMAGPRISI.setImage(arrayImagenes[contadorImagen]);
                muerto++;
                if (muerto == 6) {
                    JOptionPane.showMessageDialog(null, "Lo lamentamos, su suerte se acabo");
                    Stage currentStage = (Stage) GENERAR.getScene().getWindow();
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/Scene.fxml"));
                    Parent root = loader.load();
                    Scene scene = new Scene(root);
                    currentStage.setScene(scene);
                    currentStage.show();
                }
            }
            Q.setDisable(true);
        }
    }

    @FXML
    public void R(javafx.event.ActionEvent event) throws IOException {
        int cont = 0;
        int ganar = 0;
        for (int i = 0; i < palabrasRamdom[randomIndex].length(); i++) {
            letra = palabraOc1.charAt(i);
            if (palabrasRamdom[randomIndex].charAt(i) == 'R') {
                palabraOc1.replace(i, i + 1, "R");
                textoPropiedad.setValue(palabraOc1.toString());
                cont++;
            }
        }
        for (int i = 0; i < palabrasRamdom[randomIndex].length(); i++) {
            if (palabraOc1.charAt(i) == '_') {
                ganar++;
            }
            if (palabrasRamdom[randomIndex].length() - 1 == i) {
                if (ganar == 0) {
                    JOptionPane.showMessageDialog(null, "Has ganado");
                    Stage currentStage = (Stage) GENERAR.getScene().getWindow();
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/Scene.fxml"));
                    Parent root = loader.load();
                    Scene scene = new Scene(root);
                    currentStage.setScene(scene);
                    currentStage.show();
                }
            }
        }
        if (cont == 0) {
            R.setStyle("-fx-background-color: red;");
            contadorImagen++;
            if (contadorImagen < arrayImagenes.length) {
                IMAGPRISI.setImage(arrayImagenes[contadorImagen]);
                muerto++;
                if (muerto == 6) {
                    JOptionPane.showMessageDialog(null, "Lo lamentamos, su suerte se acabo");
                    Stage currentStage = (Stage) GENERAR.getScene().getWindow();
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/Scene.fxml"));
                    Parent root = loader.load();
                    Scene scene = new Scene(root);
                    currentStage.setScene(scene);
                    currentStage.show();
                }
            }
            R.setDisable(true);
        }
    }

    @FXML
    public void S(javafx.event.ActionEvent event) throws IOException {
        int cont = 0;
        int ganar = 0;
        for (int i = 0; i < palabrasRamdom[randomIndex].length(); i++) {
            letra = palabraOc1.charAt(i);
            if (palabrasRamdom[randomIndex].charAt(i) == 'S') {
                palabraOc1.replace(i, i + 1, "S");
                textoPropiedad.setValue(palabraOc1.toString());
                cont++;
            }
        }
        for (int i = 0; i < palabrasRamdom[randomIndex].length(); i++) {
            if (palabraOc1.charAt(i) == '_') {
                ganar++;
            }
            if (palabrasRamdom[randomIndex].length() - 1 == i) {
                if (ganar == 0) {
                    JOptionPane.showMessageDialog(null, "Has ganado");
                    Stage currentStage = (Stage) GENERAR.getScene().getWindow();
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/Scene.fxml"));
                    Parent root = loader.load();
                    Scene scene = new Scene(root);
                    currentStage.setScene(scene);
                    currentStage.show();
                }
            }
        }
        if (cont == 0) {
            S.setStyle("-fx-background-color: red;");
            contadorImagen++;
            if (contadorImagen < arrayImagenes.length) {
                IMAGPRISI.setImage(arrayImagenes[contadorImagen]);
                muerto++;
                if (muerto == 6) {
                    JOptionPane.showMessageDialog(null, "Lo lamentamos, su suerte se acabo");
                    Stage currentStage = (Stage) GENERAR.getScene().getWindow();
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/Scene.fxml"));
                    Parent root = loader.load();
                    Scene scene = new Scene(root);
                    currentStage.setScene(scene);
                    currentStage.show();
                }
            }
            S.setDisable(true);
        }
    }

    @FXML
    public void T(javafx.event.ActionEvent event) throws IOException {
        int cont = 0;
        int ganar = 0;
        for (int i = 0; i < palabrasRamdom[randomIndex].length(); i++) {
            letra = palabraOc1.charAt(i);
            if (palabrasRamdom[randomIndex].charAt(i) == 'T') {
                palabraOc1.replace(i, i + 1, "T");
                textoPropiedad.setValue(palabraOc1.toString());
                cont++;
            }
        }
        for (int i = 0; i < palabrasRamdom[randomIndex].length(); i++) {
            if (palabraOc1.charAt(i) == '_') {
                ganar++;
            }
            if (palabrasRamdom[randomIndex].length() - 1 == i) {
                if (ganar == 0) {
                    JOptionPane.showMessageDialog(null, "Has ganado");
                    Stage currentStage = (Stage) GENERAR.getScene().getWindow();
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/Scene.fxml"));
                    Parent root = loader.load();
                    Scene scene = new Scene(root);
                    currentStage.setScene(scene);
                    currentStage.show();
                }
            }
        }
        if (cont == 0) {
            T.setStyle("-fx-background-color: red;");
            contadorImagen++;
            if (contadorImagen < arrayImagenes.length) {
                IMAGPRISI.setImage(arrayImagenes[contadorImagen]);
                muerto++;
                if (muerto == 6) {
                    JOptionPane.showMessageDialog(null, "Lo lamentamos, su suerte se acabo");
                    Stage currentStage = (Stage) GENERAR.getScene().getWindow();
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/Scene.fxml"));
                    Parent root = loader.load();
                    Scene scene = new Scene(root);
                    currentStage.setScene(scene);
                    currentStage.show();
                }
            }
            T.setDisable(true);
        }
    }

    @FXML
    public void U(javafx.event.ActionEvent event) throws IOException {
        int cont = 0;
        int ganar = 0;
        for (int i = 0; i < palabrasRamdom[randomIndex].length(); i++) {
            letra = palabraOc1.charAt(i);
            if (palabrasRamdom[randomIndex].charAt(i) == 'U') {
                palabraOc1.replace(i, i + 1, "U");
                textoPropiedad.setValue(palabraOc1.toString());
                cont++;
            }
        }
        for (int i = 0; i < palabrasRamdom[randomIndex].length(); i++) {
            if (palabraOc1.charAt(i) == '_') {
                ganar++;
            }
            if (palabrasRamdom[randomIndex].length() - 1 == i) {
                if (ganar == 0) {
                    JOptionPane.showMessageDialog(null, "Has ganado");
                    Stage currentStage = (Stage) GENERAR.getScene().getWindow();
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/Scene.fxml"));
                    Parent root = loader.load();
                    Scene scene = new Scene(root);
                    currentStage.setScene(scene);
                    currentStage.show();
                }
            }
        }
        if (cont == 0) {
            U.setStyle("-fx-background-color: red;");
            contadorImagen++;
            if (contadorImagen < arrayImagenes.length) {
                IMAGPRISI.setImage(arrayImagenes[contadorImagen]);
                muerto++;
                if (muerto == 6) {
                    JOptionPane.showMessageDialog(null, "Lo lamentamos, su suerte se acabo");
                    Stage currentStage = (Stage) GENERAR.getScene().getWindow();
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/Scene.fxml"));
                    Parent root = loader.load();
                    Scene scene = new Scene(root);
                    currentStage.setScene(scene);
                    currentStage.show();
                }
            }
            U.setDisable(true);
        }
    }

    @FXML
    public void V(javafx.event.ActionEvent event) throws IOException {
        int cont = 0;
        int ganar = 0;
        for (int i = 0; i < palabrasRamdom[randomIndex].length(); i++) {
            letra = palabraOc1.charAt(i);
            if (palabrasRamdom[randomIndex].charAt(i) == 'V') {
                palabraOc1.replace(i, i + 1, "V");
                textoPropiedad.setValue(palabraOc1.toString());
                cont++;
            }
        }
        for (int i = 0; i < palabrasRamdom[randomIndex].length(); i++) {
            if (palabraOc1.charAt(i) == '_') {
                ganar++;
            }
            if (palabrasRamdom[randomIndex].length() - 1 == i) {
                if (ganar == 0) {
                    JOptionPane.showMessageDialog(null, "Has ganado");
                    Stage currentStage = (Stage) GENERAR.getScene().getWindow();
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/Scene.fxml"));
                    Parent root = loader.load();
                    Scene scene = new Scene(root);
                    currentStage.setScene(scene);
                    currentStage.show();
                }
            }
        }
        if (cont == 0) {
            V.setStyle("-fx-background-color: red;");
            contadorImagen++;
            if (contadorImagen < arrayImagenes.length) {
                IMAGPRISI.setImage(arrayImagenes[contadorImagen]);
                muerto++;
                if (muerto == 6) {
                    JOptionPane.showMessageDialog(null, "Lo lamentamos, su suerte se acabo");
                    Stage currentStage = (Stage) GENERAR.getScene().getWindow();
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/Scene.fxml"));
                    Parent root = loader.load();
                    Scene scene = new Scene(root);
                    currentStage.setScene(scene);
                    currentStage.show();
                }
            }
            V.setDisable(true);
        }
    }

    @FXML
    public void W(javafx.event.ActionEvent event) throws IOException {
        int cont = 0;
        int ganar = 0;
        for (int i = 0; i < palabrasRamdom[randomIndex].length(); i++) {
            letra = palabraOc1.charAt(i);
            if (palabrasRamdom[randomIndex].charAt(i) == 'W') {
                palabraOc1.replace(i, i + 1, "W");
                textoPropiedad.setValue(palabraOc1.toString());
                cont++;
            }
        }
        for (int i = 0; i < palabrasRamdom[randomIndex].length(); i++) {
            if (palabraOc1.charAt(i) == '_') {
                ganar++;
            }
            if (palabrasRamdom[randomIndex].length() - 1 == i) {
                if (ganar == 0) {
                    JOptionPane.showMessageDialog(null, "Has ganado");
                    Stage currentStage = (Stage) GENERAR.getScene().getWindow();
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/Scene.fxml"));
                    Parent root = loader.load();
                    Scene scene = new Scene(root);
                    currentStage.setScene(scene);
                    currentStage.show();
                }
            }
        }
        if (cont == 0) {
            W.setStyle("-fx-background-color: red;");
            contadorImagen++;
            if (contadorImagen < arrayImagenes.length) {
                IMAGPRISI.setImage(arrayImagenes[contadorImagen]);
                muerto++;
                if (muerto == 6) {
                    JOptionPane.showMessageDialog(null, "Lo lamentamos, su suerte se acabo");
                    Stage currentStage = (Stage) GENERAR.getScene().getWindow();
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/Scene.fxml"));
                    Parent root = loader.load();
                    Scene scene = new Scene(root);
                    currentStage.setScene(scene);
                    currentStage.show();
                }
            }
            W.setDisable(true);
        }
    }

    @FXML
    public void X(javafx.event.ActionEvent event) throws IOException {
        int cont = 0;
        int ganar = 0;
        for (int i = 0; i < palabrasRamdom[randomIndex].length(); i++) {
            letra = palabraOc1.charAt(i);
            if (palabrasRamdom[randomIndex].charAt(i) == 'X') {
                palabraOc1.replace(i, i + 1, "X");
                textoPropiedad.setValue(palabraOc1.toString());
                cont++;
            }
        }
        for (int i = 0; i < palabrasRamdom[randomIndex].length(); i++) {
            if (palabraOc1.charAt(i) == '_') {
                ganar++;
            }
            if (palabrasRamdom[randomIndex].length() - 1 == i) {
                if (ganar == 0) {
                    JOptionPane.showMessageDialog(null, "Has ganado");
                    Stage currentStage = (Stage) GENERAR.getScene().getWindow();
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/Scene.fxml"));
                    Parent root = loader.load();
                    Scene scene = new Scene(root);
                    currentStage.setScene(scene);
                    currentStage.show();
                }
            }
        }
        if (cont == 0) {
            X.setStyle("-fx-background-color: red;");
            contadorImagen++;
            if (contadorImagen < arrayImagenes.length) {
                IMAGPRISI.setImage(arrayImagenes[contadorImagen]);
                muerto++;
                if (muerto == 6) {
                    JOptionPane.showMessageDialog(null, "Lo lamentamos, su suerte se acabo");
                    Stage currentStage = (Stage) GENERAR.getScene().getWindow();
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/Scene.fxml"));
                    Parent root = loader.load();
                    Scene scene = new Scene(root);
                    currentStage.setScene(scene);
                    currentStage.show();
                }
            }
            X.setDisable(true);
        }
    }

    @FXML
    public void Y(javafx.event.ActionEvent event) throws IOException {
        int cont = 0;
        int ganar = 0;
        for (int i = 0; i < palabrasRamdom[randomIndex].length(); i++) {
            letra = palabraOc1.charAt(i);
            if (palabrasRamdom[randomIndex].charAt(i) == 'Y') {
                palabraOc1.replace(i, i + 1, "Y");
                textoPropiedad.setValue(palabraOc1.toString());
                cont++;
            }
        }
        for (int i = 0; i < palabrasRamdom[randomIndex].length(); i++) {
            if (palabraOc1.charAt(i) == '_') {
                ganar++;
            }
            if (palabrasRamdom[randomIndex].length() - 1 == i) {
                if (ganar == 0) {
                    JOptionPane.showMessageDialog(null, "Has ganado");
                    Stage currentStage = (Stage) GENERAR.getScene().getWindow();
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/Scene.fxml"));
                    Parent root = loader.load();
                    Scene scene = new Scene(root);
                    currentStage.setScene(scene);
                    currentStage.show();
                }
            }
        }
        if (cont == 0) {
            Y.setStyle("-fx-background-color: red;");
            contadorImagen++;
            if (contadorImagen < arrayImagenes.length) {
                IMAGPRISI.setImage(arrayImagenes[contadorImagen]);
                muerto++;
                if (muerto == 6) {
                    JOptionPane.showMessageDialog(null, "Lo lamentamos, su suerte se acabo");
                    Stage currentStage = (Stage) GENERAR.getScene().getWindow();
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/Scene.fxml"));
                    Parent root = loader.load();
                    Scene scene = new Scene(root);
                    currentStage.setScene(scene);
                    currentStage.show();
                }
            }
            Y.setDisable(true);
        }
    }

    @FXML
    public void Z(javafx.event.ActionEvent event) throws IOException {
        int cont = 0;
        int ganar = 0;
        for (int i = 0; i < palabrasRamdom[randomIndex].length(); i++) {
            letra = palabraOc1.charAt(i);
            if (palabrasRamdom[randomIndex].charAt(i) == 'Z') {
                palabraOc1.replace(i, i + 1, "Z");
                textoPropiedad.setValue(palabraOc1.toString());
                cont++;
            }
        }
        for (int i = 0; i < palabrasRamdom[randomIndex].length(); i++) {
            if (palabraOc1.charAt(i) == '_') {
                ganar++;
            }
            if (palabrasRamdom[randomIndex].length() - 1 == i) {
                if (ganar == 0) {
                    JOptionPane.showMessageDialog(null, "Has ganado");
                    Stage currentStage = (Stage) GENERAR.getScene().getWindow();
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/Scene.fxml"));
                    Parent root = loader.load();
                    Scene scene = new Scene(root);
                    currentStage.setScene(scene);
                    currentStage.show();
                }
            }
        }
        if (cont == 0) {
            Z.setStyle("-fx-background-color: red;");
            contadorImagen++;
            if (contadorImagen < arrayImagenes.length) {
                IMAGPRISI.setImage(arrayImagenes[contadorImagen]);
                muerto++;
                if (muerto == 6) {
                    JOptionPane.showMessageDialog(null, "Lo lamentamos, su suerte se acabo");
                    Stage currentStage = (Stage) GENERAR.getScene().getWindow();
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/Scene.fxml"));
                    Parent root = loader.load();
                    Scene scene = new Scene(root);
                    currentStage.setScene(scene);
                    currentStage.show();
                }
            }
            Z.setDisable(true);
        }
    }

    @FXML
    public void cerrarVentana(javafx.event.ActionEvent event) {
        Node source = (Node) event.getSource(); //Selecciona el elemento en el que estoy
        Stage stage = (Stage) source.getScene().getWindow();  //Me devuelve la ventana donde se encuentra el elemento
        stage.close(); //Cierra
    }

    @FXML
    public void BotonInstruc(javafx.event.ActionEvent event
    ) {
        JOptionPane.showMessageDialog(null, "La dinámica es muy sencilla. El jugador  dice una letra y el programa revisará si la letra se encuentra en la palabra generada.\n"
                + "\n"
                + "Si la letra está la anota en el lugar que corresponda de las rayas que ha puesto previamente.\n"
                + "\n"
                + "Si la letra no está escribe la letra para que el jugador 2 sepa las letras que ha dicho y dibuja una parte del cuerpo del ahorcado.\n"
                + "\n"
                + "El muñeco que se va dibujando tiene 6 partes, cabeza, cuerpo, dos brazos y dos piernas por lo que el jugador tiene 6 opciones de fallar.");
    }

}
