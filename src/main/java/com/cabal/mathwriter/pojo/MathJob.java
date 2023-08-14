package com.cabal.mathwriter.pojo;

import lombok.*;


@ToString
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MathJob {

    private String gradeLevel;
    private String title;
    private String operators;
    private int pages;
    private int maxNumber;
}
