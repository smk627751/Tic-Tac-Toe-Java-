package com.smk627751.tictactoe.viewmodel;

import java.util.Set;
import java.util.HashSet;
import com.smk627751.tictactoe.view.View;

public class ViewModel {
    private View view;
    private Set<Integer> placed = new HashSet<>();
    private static  StringBuilder s = new StringBuilder();
    public ViewModel(View view)
    {
        this.view = view;
    }
    public boolean isValid(char[][] grid)
    {
        for (char[] g : grid) {
            if (g[0] != ' ' && g[0] == g[1] && g[1] == g[2]) {
                return true;
            }
        }
        for(int i = 0; i < grid.length;i++)
        {
            if(grid[0][i] != ' ' && grid[0][i] == grid[1][i] && grid[1][i] == grid[2][i])
            {
                return true;
            }
        }
        if(grid[1][1] != ' ' && ((grid[0][0] == grid[1][1] && grid[1][1] == grid[2][2]) ||
                (grid[0][2] == grid[1][1] && grid[1][1] == grid[2][0])))
        {
            return true;
        }

        return false;
    }
    public boolean place(char[][] grid, int pos, char val)
    {
        if(this.placed.contains(pos))
        {
            this.view.onPrint("Occupied");
            return false;
        }
        this.placed.add(pos);
        if(pos <= 3)
        {
            grid[0][pos - 1] = val;
        }
        else if(pos <= 6)
        {
            grid[1][pos - 4] = val;
        }
        else if(pos <= 9)
        {
            grid[2][pos - 7] = val;
        }
        else
        {
            s.append("Invalid choice\n");
            this.view.onPrint(s.toString());
            s.setLength(0);
            return false;
        }

        return true;
    }
    public void print(char[][] grid)
    {
        this.s.append("-------------\n");
        for(char[] g: grid)
        {
            s.append("|\s"+g[0]+"\s|\s"+g[1]+"\s|\s"+g[2]+"\s|\n");
            s.append("-------------\n");
        }
        this.view.onPrint(s.toString());
        s.setLength(0);
    }
}
