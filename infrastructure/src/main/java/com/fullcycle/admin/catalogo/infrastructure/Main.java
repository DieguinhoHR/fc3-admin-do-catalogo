package com.fullcycle.admin.catalogo.infrastructure;

import com.fullcycle.admin.catalogo.application.UseCase;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello World!");
        System.out.println(new UseCase().excute());
    }
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
}