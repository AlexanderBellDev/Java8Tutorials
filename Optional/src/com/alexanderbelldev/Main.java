package com.alexanderbelldev;

import java.util.Optional;

public class Main {

    public static void main(String[] args) {
        //If you know a field in a class may be nullable and you want to use the value then something like
        Person person = new Person("james", null);
//        System.out.println(person.getEmail().toLowerCase());
        // wouldn't work as the email would be null and would throw a null ptr exception
        //instead you can map and use orElse to throw a default value in
        String email_not_supplied = person
                .getEmail()
                .map(String::toLowerCase)
                .orElse("Email not supplied");
        System.out.println(email_not_supplied);

        //example with email provided:
        person = new Person("james", "djdjd@djdj.com");
        email_not_supplied = person
                .getEmail()
                .map(String::toLowerCase)
                .orElse("Email not supplied");
        System.out.println(email_not_supplied);


        Optional<String> emptyString = Optional.empty();

        System.out.println(emptyString.isPresent()); // prints out whether there is a value as a boolean

        //conditional example of checking if present
        if(emptyString.isPresent()){
            String value = emptyString.get();
        }else{
            System.out.println("No value provided!");
        }

        Optional<String> optionalO = Optional.of("Hello");
        System.out.println(optionalO.isPresent()); // prints out whether there is a value

        String orElse = optionalO.orElse("world");
        System.out.println(orElse); // Prints out Hello as value isnt null

        optionalO = Optional.ofNullable(null);
        orElse = optionalO.orElse("world");
        System.out.println(orElse); // Prints out world as value is null


        // IF example
        /*
        The ifPresent() method enables us to run some code on the wrapped value if it's found to be non-null. Before Optional, we'd do:
        if(name != null) {
            System.out.println(name.length());
            }
        */
        String hello = null;
        String world;
        if (hello != null) {
            System.out.println("Not null!");
        }


        Optional<String> opt = Optional.ofNullable(hello);
        opt.ifPresent(name -> System.out.println(name.length())); // if its not null then print out the length of the string
        hello = "test";
        opt = Optional.ofNullable(hello);
        opt.ifPresent(name -> System.out.println(name.length())); // will now print out 4


        /*
        The orElse() method is used to retrieve the value wrapped inside an Optional instance.
         It takes one parameter which acts as a default value.
          The orElse() method returns the wrapped value if it's present and its argument otherwise:
         */
        String nullName = null;
        String name = Optional.ofNullable(nullName).orElse("john");
        System.out.println(name); // if name is null then it will print john otherwise it will print nullName



        /*
        The orElseGet() method is similar to orElse(). However, instead of taking a value to return if the Optional value is not present,
         it takes a supplier functional interface which is invoked and returns the value of the invocation:
         */
        nullName = "test";
        name = Optional.ofNullable(nullName).orElseGet(() -> "john");
        System.out.println(name);

        //more orElseGet with method
        String text = null;
        String defaultText = Optional.ofNullable(text).orElseGet(Main::getMyDefault);
        System.out.println(defaultText);
        String defaultText1 = Optional.ofNullable(text).orElseGet(() -> {
            System.out.println("1234 56");
            return "444i";
        });
        System.out.println(defaultText1);

        /*The final approach for retrieving the wrapped value is the get() method:
         */
        opt = Optional.of("baeldung");
        name = opt.get();
        System.out.println(name);


        /*
        However, unlike the above three approaches, get() can only return a value if the wrapped object is not null, otherwise, it throws a no such element exception:
         Optional<String> opt = Optional.ofNullable(null);
         String name = opt.get();
         */


          /*The orElseThrow() method follows from orElse() and orElseGet() and adds a new approach for handling an absent value.
         Instead of returning a default value when the wrapped value is not present, it throws an exception:
         */
        nullName = null;
//        name = Optional.ofNullable(nullName).orElseThrow(
//                IllegalArgumentException::new);

    }

    private static String getMyDefault() {
        return "Stuff";
    }

}
