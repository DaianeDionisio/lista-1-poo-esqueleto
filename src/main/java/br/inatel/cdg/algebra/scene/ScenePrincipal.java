package br.inatel.cdg.algebra.scene;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import br.inatel.cdg.algebra.reta.Reta;
import br.inatel.cdg.algebra.reta.Ponto;

public class ScenePrincipal {

    private Button calcAngular; //Button para calcular o coeficiente angular
    private Button calcLinear; //Button para calcular o coeficiente linear
    private Label label1; //Label de inicio, mostra "Digite as coordenadas"
    private Label labelX1, labelY1; //Label ponto 1
    private Label labelX2, labelY2; //Label ponto 2
    private TextField textX1, textY1, textX2, textY2; //TextField para as coordenadas
    private TextField resultAngular, resultLinear; //TextField para os resultados

    public void criaScenePrincipal(Stage stage){

        //Criando os labels
        label1 = new Label("Digite as coordenadas: ");
        labelX1 = new Label("P1.X: ");
        labelY1 = new Label("P1.Y: ");
        labelX2 = new Label("P2.X: ");
        labelY2 = new Label("P2.Y: ");
        textX1 = new TextField();
        textY1 = new TextField();
        textX2 = new TextField();
        textY2 = new TextField();


        //Agrupando elementos
        HBox coordPonto1 = new HBox(labelX1, textX1, labelY1, textY1); //Coordenadas do ponto 1
        HBox coordPonto2 = new HBox(labelX2, textX2, labelY2, textY2); //Coordenadas do ponto 2
        VBox coordenadas = new VBox(coordPonto1, coordPonto2);


        //Locais onde aparecerão os resultados
        resultAngular = new TextField();
        resultLinear = new TextField();
        resultAngular.setEditable(false);//apenas mostrar texto
        resultAngular.setText(" ");
        resultLinear.setEditable(false);//apenas mostrar texto
        resultLinear.setText(" ");


        //Botão para calcular o coeficiente angular
        calcAngular = new Button("Calcular coeficiente angular");
        calcAngular.setOnAction(evento -> {
            Reta reta = criarReta();
            resultAngular.setText("Coeficiente angular: " + reta.calcAngular());
        });

        //Botão para calcular o coeficiente linear
        calcLinear = new Button("Calcular coeficiente linear");
        calcLinear.setOnAction(evento -> {
            Reta reta = criarReta();
            resultLinear.setText("Coeficiente angular: " + reta.calLinear());
        });

        //Agrupando elementos
        HBox botoes = new HBox(calcAngular, calcLinear);
        HBox resultados = new HBox(resultAngular, resultLinear);
        VBox layoutFinal = new VBox(label1, coordenadas, botoes, resultados);//Aqui vamos agrupar verticalmente o grupo (Label + Texto) o Botao e A area que aparecer o texto digitado


        //Criamos a Scene
        Scene scene = new Scene(layoutFinal, 400 , 200);

        stage.setTitle("Software Para Calculos de Álgebra Linear");
        stage.setScene(scene);
        stage.show();

    }

    //método para criar uma reta
    private Reta criarReta(){

        //criando os pontos
        Ponto p1 = new Ponto();
        p1.setCoordX(Double.parseDouble(textX1.getText()));
        p1.setCoordY(Double.parseDouble(textY1.getText()));

        Ponto p2 = new Ponto();
        p2.setCoordX(Double.parseDouble(textX2.getText()));
        p2.setCoordY(Double.parseDouble(textY2.getText()));

        Reta reta = new Reta(p1,p2);

        return reta;
    }

}
