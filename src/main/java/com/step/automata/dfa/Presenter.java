package com.step.automata.dfa;

import com.step.automata.nfa.NFAMachine;

import java.util.HashSet;
import java.util.Iterator;

public class Presenter {
    private final HashSet<String> pass_cases;
    private final HashSet<String> fail_cases;

    public Presenter(HashSet<String> pass_cases, HashSet<String> fail_cases) {

        this.pass_cases = pass_cases;
        this.fail_cases = fail_cases;
    }

    public void presentDfa(DFAMachine machine, String name, String type) {
        System.out.println("==================> "+type + ":-\n");
        System.out.println(name + ":-\n");
        System.out.println("pass_cases: " + pass_cases.size());
        Iterator<String> iterator = pass_cases.iterator();
        while (iterator.hasNext()) {
            String passableString = iterator.next();
            if (machine.isRecognizes(passableString))
                System.out.println("pass : " + passableString);
            else
                System.out.println("fail : " + passableString);
        }

        System.out.println("fail_cases : " + fail_cases.size());
        Iterator<String> iterator1 = fail_cases.iterator();
        while (iterator1.hasNext()) {
            String failueString = iterator1.next();
            if (!machine.isRecognizes(failueString))
                System.out.println("fail : " + failueString);
            else
                System.out.println("pass : " + failueString);

        }

    }

    public void presentNfa(NFAMachine machine, String name, String type) {
        System.out.println("===============> "+type + ":-\n");
        System.out.println(name + ":-\n");
        System.out.println("pass_cases: " + pass_cases.size());
        Iterator<String> iterator = pass_cases.iterator();
//        while (iterator.hasNext()) {
//            String passableString = iterator.next();
//            if (machine.isRecognizes(""))
//                System.out.println("pass : " + passableString);
//            else
//                System.out.println("fail : " + passableString);
//        }

        machine.isRecognizes("0");
//        System.out.println("fail_cases : " + fail_cases.size());
//        Iterator<String> iterator1 = fail_cases.iterator();
//        while (iterator1.hasNext()) {
//            String failueString = iterator1.next();
//            if (!machine.isRecognizes(failueString))
//                System.out.println("fail : " + failueString);
//            else
//                System.out.println("pass : " + failueString);
//
//        }
    }
}
