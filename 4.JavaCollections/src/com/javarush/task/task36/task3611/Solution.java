package com.javarush.task.task36.task3611;

import java.util.HashSet;
import java.util.Set;

/* 
Сколько у человека потенциальных друзей?
*/

public class Solution {
    private boolean[][] humanRelationships;

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.humanRelationships = generateRelationships();

        Set<Integer> allFriendsAndPotentialFriends = solution.getAllFriendsAndPotentialFriends(4, 2);
        System.out.println(allFriendsAndPotentialFriends);                              // Expected: [0, 1, 2, 3, 5, 7]
        Set<Integer> potentialFriends = solution.removeFriendsFromSet(allFriendsAndPotentialFriends, 4);
        System.out.println(potentialFriends);                                           // Expected: [2, 5, 7]
    }

    public Set<Integer> getAllFriendsAndPotentialFriends(int index, int deep) {
        int wave = 1;
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();

        for (int i = 0; i < humanRelationships.length; i++) {
            if (index < humanRelationships[i].length) {
                if (humanRelationships[i][index] == true) {
                    set1.add(i);
                    set2.add(i);
            }
                }
            }

        for (int i = 0; i < humanRelationships[index].length; i++) {
                if (humanRelationships[index][i] == true) {
                    set1.add(i);
                    set2.add(i);
                }
            }

        while (wave < deep ) {
                for (Integer in : set2) {
                    for (int i = 0; i < humanRelationships.length; i++) {
                        if (in < humanRelationships[i].length) {
                            if (humanRelationships[i][in] == true) {
                                set1.add(i);
                            }
                        }
                    }

                    for (int i = 0; i < humanRelationships[in].length; i++) {
                        if (humanRelationships[in][i] == true) {
                            set1.add(i);
                        }
                    }
            }

                set2 = new HashSet<>(set1);
                wave++;
            }


        set1.remove(index);

        return set1;
    }

    // Remove from the set the people with whom you already have a relationship
    public Set<Integer> removeFriendsFromSet(Set<Integer> set, int index) {
        for (int i = 0; i < humanRelationships.length; i++) {
            if ((i < index) && (index < humanRelationships.length) && humanRelationships[index][i]) {
                set.remove(i);
            } else if ((i > index) && humanRelationships[i][index]) {
                set.remove(i);
            }
        }
        return set;
    }

    // Return test data
    private static boolean[][] generateRelationships() {
        return new boolean[][]{
                {true},                                                                 //0
                {true, true},                                                           //1
                {false, true, true},                                                    //2
                {false, false, false, true},                                            //3
                {true, true, false, true, true},                                        //4
                {true, false, true, false, false, true},                                //5
                {false, false, false,false, false, true, true},                        //6
                {false, false, false, true, false, false, false, true}                  //7
        };
    }
}