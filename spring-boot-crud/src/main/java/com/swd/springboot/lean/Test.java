package com.swd.springboot.lean;

public class Test {

    public static void main(String[] args) {
        int [][] arr = {
                {1,2,3,4,5},
                {6,7,8,9,10},
                {20,30,40,50,60},
                {61,62,63,64,65}
        };
        System.out.println(Find(89, arr));
    }


    /**
     *
     在一个二维数组中（每个一维数组的长度相同），
     每一行都按照从左到右递增的顺序排序，
     每一列都按照从上到下递增的顺序排序。
     请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。

     * @param target
     * @param array
     * @return
     */
    public static boolean Find(int target, int [][] array) {
        /*for(int i=0;i<array.length;++i){
            for(int j=0;j<array[i].length;++j){
                if(target==array[i][j]){
                    return true;
                }
            }
        }*/

        int rows = array.length;
        int cols = array[0].length;

        if(target<array[0][0]||target>array[rows-1][cols-1]){
            return false;
        }

        for (int i =0;i<rows;++i){

            int low = 0;
            int high = rows-1;


            while (low<=high){


                int mid = (low+high)/2;
                if(target<array[i][mid]){

                    high = mid-1;
                }else if (target>array[i][mid]){
                    low = mid+1;

                }else {
                    return true;
                }

            }

        }



        return false;
    }


}
