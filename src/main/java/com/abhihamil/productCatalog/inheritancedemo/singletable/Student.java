package com.abhihamil.productCatalog.inheritancedemo.singletable;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity(name = "st_student")
public class Student extends User {
    private double psp;
    private double attendance;
}
