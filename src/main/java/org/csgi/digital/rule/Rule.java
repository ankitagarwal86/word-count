package org.csgi.digital.rule;


import java.util.stream.Stream;

/**
 *
 * @author Ankit Agarwal
 * Interface for rules, Logic for Implementing the rule is in implementation class. It follows Chain of responsibility
 * Pattern, For each business rule
 */

public interface Rule {
   /**
    *
    * @param val Input on which business rule will be applied
    */
    Stream<String> onNext(Stream<String> val);
}
