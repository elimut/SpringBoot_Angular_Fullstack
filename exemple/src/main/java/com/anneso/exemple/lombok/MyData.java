package com.anneso.exemple.lombok;

import lombok.*;

// @Getter
// @Setter
// Constructeur avec paramètres
@AllArgsConstructor
// @NoArgsConstructor
// @EqualsAndHashCode
// @ToString
// Constructeur avec un seul paramètre
// @RequiredArgsConstructor
@Data
@Builder
public class MyData {

    private int id;

    private final String firstname;

    private String lastname;



}
