package util;

import java.util.Optional;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

public class AlertUtil {
    
     public static void mostrarAlerta(Alert.AlertType tipo, String titulo, String headerText, String mensagem){
         
        Alert alerta = new Alert(tipo);
        alerta.setTitle(titulo);
        alerta.setHeaderText(headerText);
        alerta.setContentText(mensagem);
        alerta.showAndWait();
    }
     
     public static void mostrarErro(String titulo, String headerText, String mensagem){
         
         mostrarAlerta(Alert.AlertType.ERROR, titulo, headerText, mensagem);
         
     }
     
      public static Optional<ButtonType> mostrarConfirmacao(String titulo, String headerText,
            String mensagem){
        Alert alerta = new Alert(Alert.AlertType.CONFIRMATION);
        alerta.setTitle(titulo);
        alerta.setHeaderText(headerText);
        alerta.setContentText(mensagem);
        return alerta.showAndWait();
    }
      
     public static void mostrarInformacao(String titulo, String headerText, String mensagem){
         
         mostrarAlerta(Alert.AlertType.INFORMATION, titulo, headerText, mensagem);
         
     }
     
     
    
}
