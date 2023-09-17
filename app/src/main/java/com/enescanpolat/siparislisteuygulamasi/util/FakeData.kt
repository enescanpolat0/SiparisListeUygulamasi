package com.enescanpolat.siparislisteuygulamasi.util

import com.enescanpolat.siparislisteuygulamasi.domain.model.Teslimat
import com.enescanpolat.siparislisteuygulamasi.domain.model.Urun

object FakeData {
    val deliverers = listOf(
        Teslimat(
            "1",
            "Paper Factory Ltd",
            listOf(
                Urun("1","Notebook Big",1.45f),
                Urun("2","Notebook Medium",1.25f),
                Urun("3","Notebook Small",1.05f),
                Urun("4","Printer Paper 50x",2.55f),
                Urun("5","Printer Paper 100x",4.55f),
            )
        ),
        Teslimat(
            "2",
            "School Stuff provider",
            listOf(
                Urun("6","Pencil",1.00f),
                Urun("7","Scissor",2.19f),
                Urun("8","Tablet",149.00f),
                Urun("9","School Bag",21.50f),
                Urun("10","Pencil Case",2.69f),
            )
        ),
        Teslimat(
            "3",
            "Computer Hardware Store",
            listOf(
                Urun("11","Keyboard",41.00f),
                Urun("12","Mouse",22.19f),
                Urun("13","Intel Processor i7",249.00f),
                Urun("14","2x 8GB RAM",49.10f),
                Urun("15","2x 16GB RAM",89.00f),
                Urun("16","2x 32GB RAM",129.50f),
                Urun("17","2x 64GB RAM",189.00f),
            )
        )
    )
}