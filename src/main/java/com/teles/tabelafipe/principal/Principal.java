package com.teles.tabelafipe.principal;

import com.teles.tabelafipe.model.Data;
import com.teles.tabelafipe.service.ConvertData;
import com.teles.tabelafipe.service.FetchApi;

import java.util.Comparator;
import java.util.Scanner;

public class Principal {
    private Scanner read = new Scanner(System.in);
    private FetchApi fetchApi = new FetchApi();
    private ConvertData converter = new ConvertData();

    private final String URL_BASE = "https://parallelum.com.br/fipe/api/v1/";

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

        var brand = converter.getList(json, Data.class);

        brand.stream()
                .sorted(Comparator.comparing(Data::code))
                .forEach(System.out::println);

        System.out.println("Informe o código da marca para consulta: ");
        var brandCode = read.nextLine();
    }
}
