package com.biblioteca.views;

import com.biblioteca.model.User;
import javafx.fxml.FXML;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.control.Label;

public class MenuController {

   @FXML
   private Label printName; // Label para exibir o nome do usuário

   private User user;

   public void setUser (User user) {
      this.user = user;
      printName.setText("Bem-vindo, " + user.getName() + "!");
   }
}