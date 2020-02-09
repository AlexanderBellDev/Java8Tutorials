package com.alexanderbelldev;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
    List<Person> people = getPeople();

        //sorting list
        List<Person> sorted = people.stream()
                .sorted(Comparator.comparing(Person::getAge))
                .collect(Collectors.toList());
        System.out.println("sorted declarative list");
        sorted.forEach(System.out::println);

    //filtering Imperative approach OLD
        List<Person> females = new ArrayList<>();
        for (Person person : people) {
            if(person.getGender().equals(Gender.FEMALE)){
                females.add(person);
            }
        }
        System.out.println("using traditional approach");
        females.forEach(System.out::println);

        //filtering declarative approach

        List<Person> collect = people.stream()
                .filter(person -> person.getGender().equals(Gender.FEMALE))
                .collect(Collectors.toList());
        System.out.println("Non sorted declarative approach");
        collect.forEach(System.out::println);

        // matching

        //all match
        // if all age > 5
        boolean allMatch = people.stream()
                .allMatch(person -> person.getAge() > 5);
        System.out.println("printing out if all ages > 5");
        System.out.println(allMatch);

        //any match
        // if all age > 5
        boolean anyMatch = people.stream()
                .anyMatch(person -> person.getAge() > 25);
        System.out.println("printing out if any ages > 25");
        System.out.println(anyMatch);

        //none match
        // if no age > 5
        boolean noneMatch = people.stream()
                .noneMatch(person -> person.getName().equals("bob"));
        System.out.println("printing out if no ones name is bob");
        System.out.println(noneMatch);


        //max
        System.out.println("Printing out person with max age");
       people.stream()
                .max(Comparator.comparing(Person::getAge))
                .ifPresent(System.out::println);
       //min
        System.out.println("Printing out person with min age");
        people.stream()
                .min(Comparator.comparing(Person::getAge))
                .ifPresent(System.out::println);

        //group
        System.out.println("printing out groups of gender and people inside that group");
        Map<Gender, List<Person>> groupByGender = people.stream()
                .collect(Collectors.groupingBy(Person::getGender));

        groupByGender.forEach((gender, people1) -> {
            System.out.println(gender);
            people1.forEach(System.out::println);
        });

        //find every female, find oldest one then find first name
        Optional<String> max = people.stream()
                .filter(person -> person.getGender().equals(Gender.FEMALE))
                .max(Comparator.comparing(Person::getAge))
                .map(Person::getName);
        max.ifPresent(System.out::println);

    }

    public static List<Person> getPeople(){
        return List.of(
                new Person("Antonio", 20, Gender.MALE),
                new Person("Alina Smith", 33, Gender.FEMALE),
                new Person("Helen White", 57, Gender.FEMALE),
                new Person("Alex Boz", 14, Gender.MALE),
                new Person("Jamie Goa", 99, Gender.MALE),
                new Person("Anna Cook", 7, Gender.FEMALE),
                new Person("Zelda Brown", 120, Gender.FEMALE)
        );
    }
}
