package org.example;

import org.junit.Before;
import org.junit.Test;

public class Test1 extends SourcePage {


    @Test
    public void open() throws InterruptedException {
        ElementsMethodsPage elementsMethodsPage = new ElementsMethodsPage();
        ElementsMethodsPage elementsMethodsPageAs = new ElementsMethodsPage();
        ElementsMethodsPage elementsMethodsPageTo = new ElementsMethodsPage();


        elementsMethodsPage.findBillets("Саратов",
                                          "Москва",
                                             "16.06.2025",
                                                "20.06.2025");
        elementsMethodsPageAs.asertionsFrom();
        elementsMethodsPageTo.asertionsTo();



    }
}