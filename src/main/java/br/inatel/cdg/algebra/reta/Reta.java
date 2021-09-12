package br.inatel.cdg.algebra.reta;

public class Reta {

    private Ponto p1;
    private Ponto p2;

    public Reta(Ponto p1, Ponto p2){
        this.p1 = p1;
        this.p2 = p2;
    }

    //método para calcular o coeficiente angular
    public double calcAngular(){

        return ((p2.getCoordY() - p1.getCoordY()) / (p2.getCoordX() - p1.getCoordX()));

    }

    //método para calcular o coeficiente linear
    public double calLinear(){

        return ((p1.getCoordY() - calcAngular()*p1.getCoordX()));

    }

}
