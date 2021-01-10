package alejandrofan2.hundirlaflota.utiles;

public class Transformer {

	public static int letraanum(String letra){
        if("A".equals(letra.substring(0,1))||"a".equals(letra.substring(0,1))){
            return 1;
        }else if("B".equals(letra)||"b".equals(letra)){
            return 2;
        }else if("C".equals(letra)||"c".equals(letra)){
            return 3;
        }else if("D".equals(letra)||"d".equals(letra)){
            return 4;
        }else if("E".equals(letra)||"e".equals(letra)){
            return 5;
        }else if("F".equals(letra)||"f".equals(letra)){
            return 6;
        }else if("G".equals(letra)||"g".equals(letra)){
            return 7;
        }else if("H".equals(letra)||"h".equals(letra)){
            return 8;
        }else if("I".equals(letra)||"i".equals(letra)){
            return 9;
        }else if("J".equals(letra)||"j".equals(letra)){
            return 10;
        }else if("K".equals(letra)||"K".equals(letra)){
            return 11;
        }else if("L".equals(letra)||"L".equals(letra)){
            return 12;
        }else if("M".equals(letra)||"M".equals(letra)){
            return 13;
        }else if("N".equals(letra)||"N".equals(letra)){
            return 14;
        }else if("O".equals(letra)||"o".equals(letra)){
            return 15;
        }else if("P".equals(letra)||"p".equals(letra)){
            return 16;
        }else if("Q".equals(letra)||"q".equals(letra)){
            return 17;
        }else if("R".equals(letra)||"r".equals(letra)){
            return 18;
        }else if("S".equals(letra)||"s".equals(letra)){
            return 19;
        }else if("T".equals(letra)||"t".equals(letra)){
            return 20;
        }else if("U".equals(letra)||"u".equals(letra)){
            return 21;
        }else if("V".equals(letra)||"v".equals(letra)){
            return 22;
        }else if("W".equals(letra)||"w".equals(letra)){
            return 23;
        }else if("X".equals(letra)||"x".equals(letra)){
            return 24;
        }else if("Y".equals(letra)||"y".equals(letra)){
            return 25;
        }else if("Z".equals(letra)||"z".equals(letra)){
            return 26;
        }else{
            return 0;
        }
    }

}
