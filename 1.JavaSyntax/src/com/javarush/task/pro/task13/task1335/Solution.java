package com.javarush.task.pro.task13.task1335;

/* 
Дорога к выходу
*/

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public static void main(String[] args) {
        printList(clearBoard());
    }

    public static List<Board.Node> clearBoard() {
        Board board = new Board();
        ArrayList<Board.Node> copy = new ArrayList<>(board.getBoardNodes());
        for (Board.Node node : copy) {
            Board.Node node1 = new Board.Node(node.getData());
            if (node1.getData().equals("snake")) {
                node1.setData("board");
            }
        }
        return null;
    }

    private static void printList(List<?> list) {
        list.forEach(element -> System.out.print(element + " "));
    }
}
