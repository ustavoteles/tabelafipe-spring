package com.teles.tabelafipe.principal;

import com.teles.tabelafipe.service.FetchApi;

import java.util.Scanner;

public class Principal {
    private Scanner read = new Scanner(System.in);
    private final String URL_BASE = "https://parallelum.com.br/fipe/api/v1/";
    private FetchApi fetchApi = new FetchApi();

    public void showMenu() {
        var menu = """
                *** OPÇÕES ***
                CARRO
                MOTO
                CAMINHÃO
                
                Digite uma das opções para consultar:
                """;

        System.out.println(menu);
        var option = read.nextLine();

        String address;

        if (option.toLowerCase().contains("carr")) {
            address = URL_BASE + "carros/marcas";
        } else if (option.toLowerCase().contains("mot")) {
            address = URL_BASE + "motos/marcas";
        } else {
            address = URL_BASE + "caminhoes/marcas";
        }

        var json = fetchApi.getData(address);
        System.out.println(json);
    }
}
