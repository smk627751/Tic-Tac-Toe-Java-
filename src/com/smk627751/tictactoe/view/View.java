package com.smk627751.tictactoe.view;

import java.util.Scanner;
import java.util.Arrays;
import com.smk627751.tictactoe.viewmodel.ViewModel;

public class View {
    private ViewModel viewModel;
    public View()
    {
        this.viewModel = new ViewModel(this);
    }
    public void onPrint(String s)
    {
        System.out.println(s);
    }
    public void init()
    {
        Scanner sc = new Scanner(System.in);
        char[][] grid = new char[3][3];
        for(char[] g : grid)
        {
            Arrays.fill(g,' ');
        }
        int pos = 0;
        int count = 0;
        int i = 0;char[] val = {'x','o'};
        do {
            viewModel.print(grid);
            System.out.print(val[i]+"'s turn: ");
            pos = sc.nextInt();
            boolean turn = viewModel.place(grid,pos,val[i]);
            if(viewModel.isValid(grid))
            {
                viewModel.print(grid);
                this.onPrint(val[i]+" is winner");
                break;
            }
            i = turn ? i == 0 ? 1 : 0 : i;
        }while (count++ < 9);
    }
}
