package Java8;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
/*
Level 1 – Basic Transformations

Given a list of integers, return squares.

Filter odd numbers.

Convert list of names to uppercase.

Count items starting with a letter.

Given a list of strings, find the longest string.
 */



public class SteamApiLevel1 {
    public static void main(String[] args) {
        List<Integer> list = List.of(70,40,56,25,48,75,32);
        //Given a list of integers, return squares.

        List<Integer> squareList = list.stream().map(x -> x*x).toList();
        System.out.println(squareList);


        //Filter odd numbers.
        List<Integer> oddList = list.stream().filter(x->x%2!=0).toList();
        System.out.println(oddList);

        //Convert list of names to uppercase.
        List<String> nameList = List.of("divyam","anvunv","ansuvnur","vunfunE");
        List<String> capitalList = nameList.stream().map(String::toUpperCase).toList();
        System.out.println(capitalList);

//        Count items starting with a letter.
        List<String> items = List.of("divyam","anvunv","ansuvnur","vunfunE");
        Long itemsStartD = items.stream().filter(x->x.startsWith("d")).count();
        System.out.println(itemsStartD);

        //Given a list of strings, find the longest string.
        //String longestItem = items.stream().max((a,b)->a.length()-b.length()).get();
        String longestItem = items.stream().max(Comparator.comparing(String::length)).orElse(null);
        System.out.println(longestItem);
    }






}
