package com.smk627751.tictactoe;

import com.smk627751.tictactoe.view.View;

public class TicTacToe {
    private View view;
    TicTacToe()
    {
        this.view = new View();
    }
    public static void main(String[] args) {
        TicTacToe obj = new TicTacToe();
        obj.view.init();
    }
}