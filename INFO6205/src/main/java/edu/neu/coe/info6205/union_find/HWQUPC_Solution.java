package edu.neu.coe.info6205.union_find;

import java.util.Random;

public class HWQUPC_Solution {

    public static int count(int n){

        int noOfPairs = 0;
        UF unionFind = new UF_HWQUPC(n, true);
        Random random = new Random();

        while(unionFind.components() > 1){
            noOfPairs++;
            int x = random.nextInt(n);
            int y = random.nextInt(n);

            unionFind.connect(x,y);
        }

        return noOfPairs;

    }

    public static void main(String[] args) {

        int n = 512;

        if(args.length>0){
            n = Integer.parseInt(args[0]);
        }

        System.out.println(String.format("Number of random pairs generated for n = %d is: %d",n,count(n)));
    }
}
