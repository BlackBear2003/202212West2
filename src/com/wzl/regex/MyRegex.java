package com.wzl.regex;



public class MyRegex {
    private final String regx = "^\\w+(\\w|[.]\\w+)+@\\w+([.]\\w+){1,3}";
    public Boolean matches(String str){
        return str.matches(regx);
    }
}
