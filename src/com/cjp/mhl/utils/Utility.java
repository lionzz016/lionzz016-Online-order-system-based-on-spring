package com.cjp.mhl.utils;

import java.util.Scanner;

/**
 * @author CJP
 * @version 1.0
 */
public class Utility {
    public static int readInt() {
        return new Scanner(System.in).nextInt();
    }

    public static String readString() {
        return new Scanner(System.in).nextLine();
    }
}
