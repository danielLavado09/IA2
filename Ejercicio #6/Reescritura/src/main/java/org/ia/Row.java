package org.ia;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

@Data
@AllArgsConstructor
@ToString
public class Row {

    private Integer Day;
    private Integer Month;
    private Integer Year;
    private Float Temperature;
    private Float RH;
    private Float Ws;
    private Float Rain;
    private Float FFMC;
    private Float DMC;
    private Float DC;
    private Float ISI;
    private Float BUI;
    private Float FWI;
    private String Classes;

}
