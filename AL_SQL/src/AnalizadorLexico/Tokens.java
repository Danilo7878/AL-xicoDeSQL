/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AnalizadorLexico;

/**
 *
 * @author danil
 */
public enum Tokens {
    Palabra_Reservada,
    Identificador,
    Bit,
    Int,
    Float,
    FloatError,
    Simbolo,
    ComentarioSimple,
    String,
    StringError,
    ComentarioMultilinea,
    ComentarioMultilineaError,
    ERROR
}
