package com.yt.arithmetic.solutions;

import com.yt.arithmetic.arithmetic.dynamicProgramming.DynamicProgramming;
import com.yt.arithmetic.leetcode.LeetCode;

/**
 * Created by yantong on 2019/2/27.
 */
public class ScrambleString implements LeetCode, DynamicProgramming {
    @Override
    public String question() {
        return "Given a string s1, we may represent it as a binary tree by partitioning it to two non-empty substrings recursively.\n" +
                "\n" +
                "Below is one possible representation of s1 = \"great\":\n" +
                "\n" +
                "    great\n" +
                "   /    \\\n" +
                "  gr    eat\n" +
                " / \\    /  \\\n" +
                "g   r  e   at\n" +
                "           / \\\n" +
                "          a   t\n" +
                "To scramble the string, we may choose any non-leaf node and swap its two children.\n" +
                "\n" +
                "For example, if we choose the node \"gr\" and swap its two children, it produces a scrambled string \"rgeat\".\n" +
                "\n" +
                "    rgeat\n" +
                "   /    \\\n" +
                "  rg    eat\n" +
                " / \\    /  \\\n" +
                "r   g  e   at\n" +
                "           / \\\n" +
                "          a   t\n" +
                "We say that \"rgeat\" is a scrambled string of \"great\".\n" +
                "\n" +
                "Similarly, if we continue to swap the children of nodes \"eat\" and \"at\", it produces a scrambled string \"rgtae\".\n" +
                "\n" +
                "    rgtae\n" +
                "   /    \\\n" +
                "  rg    tae\n" +
                " / \\    /  \\\n" +
                "r   g  ta  e\n" +
                "       / \\\n" +
                "      t   a\n" +
                "We say that \"rgtae\" is a scrambled string of \"great\".\n" +
                "\n" +
                "Given two strings s1 and s2 of the same length, determine if s2 is a scrambled string of s1.\n" +
                "\n" +
                "Example 1:\n" +
                "\n" +
                "Input: s1 = \"great\", s2 = \"rgeat\"\n" +
                "Output: true\n" +
                "Example 2:\n" +
                "\n" +
                "Input: s1 = \"abcde\", s2 = \"caebd\"\n" +
                "Output: false";
    }

    @Override
    public int getProblemNumber() {
        return 87;
    }

    @Override
    public String performResult() {
        return null;
    }

    @Override
    public long getSoluteTime() {
        return 0;
    }

    @Override
    public void danamicProgrammingSolution() {
        //想了一会 没想出来
        //树：具有的性质：递归（子节点）、分开（多个子树）
        //所以应该能联想起，存在同一个划分，将source 和 target 都分成两个互相可爬的子串


    }
}
