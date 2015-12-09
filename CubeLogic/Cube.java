package RubiksCube.CubeLogic;

/**
 * Created by corey on 12/8/2015.
 */
import java.util.*;
public class Cube {
    //cube [side][row][col]
    int cubeArray[][][];
    public Cube(){
        cubeMap.put(0,2);
        cubeMap.put(1,5);
        cubeMap.put(2,8);
        cubeMap.put(3,1);
        cubeMap.put(4,4);
        cubeMap.put(5,7);
        cubeMap.put(6,0);
        cubeMap.put(7,3);
        cubeMap.put(8,6);
        for(int i=0;i<6;i++){
            for(int j=0;j<3;j++){
                for(int k=0;k<3;k++){
                    cubeArray[i][j][k]=i;
                }
            }
        }
    }
    public void Scramble(){

    }
    HashMap<Integer, Integer> cubeMap = new HashMap<Integer, Integer>();
    HashMap<Integer, Integer> midCubeMap = new HashMap<Integer, Integer>();
    //boolean dimension refers to up or down; up: true, down: false
    public void slide(int side, int set, boolean isRow, boolean dimension) {
        switch (side) {
            case 0:
            case 1:
            case 2:
            case 3: {
                if (!isRow) {
                    if (dimension) {
                        for(int i=1;i<4;i++,side++) {
                            int temp[] = {cubeArray[side][0][set], cubeArray[side][1][set], cubeArray[side][2][set]};
                            if (side + 1 == 4)
                                side = 0;
                            cubeArray[side][0][set] = cubeArray[side+1][0][set];
                            cubeArray[side][1][set] = cubeArray[side+1][1][set];
                            cubeArray[side][2][set] = cubeArray[side+1][2][set];
                            int k=0;
                            for(int t:temp) {
                                cubeArray[side - 1][k][set] = t;
                                k++;
                            }
                        }
                        if(set==0){
                            int temp[]={cubeArray[4][0][0],cubeArray[4][0][1],cubeArray[4][0][2],
                                    cubeArray[4][1][0],cubeArray[4][1][1],cubeArray[4][1][2],
                                    cubeArray[4][2][0],cubeArray[4][2][1],cubeArray[4][2][2]};
                            for(int i=0,c=0;i<3;i++)
                                for(int j=0;j<3;j++,c++)
                                    cubeArray[4][i][j]=temp[cubeMap.get(c)];
                        }
                        else if(set==1){
                            int temp[]={cubeArray[0][0][1],cubeArray[0][1][1],cubeArray[0][2][1],
                                        cubeArray[1][0][1],cubeArray[1][1][1],cubeArray[1][2][1],
                                        cubeArray[2][0][1],cubeArray[2][1][1],cubeArray[2][2][1],
                                        cubeArray[3][0][1],cubeArray[3][1][1],cubeArray[3][2][1]};
                            for(int j = 0; j < 4; j++) {
                                for (int i = 0; i < 3; i++) {
                                    if(j==0)
                                        cubeArray[0][i][1]=temp[i+9];
                                    else
                                        cubeArray[0][i][1]=temp[j+i-3];
                                }
                            }
                        }
                        else{
                            int temp[]={cubeArray[5][0][0],cubeArray[5][0][1],cubeArray[5][0][2],
                                    cubeArray[5][1][0],cubeArray[5][1][1],cubeArray[5][1][2],
                                    cubeArray[5][2][0],cubeArray[5][2][1],cubeArray[5][2][2]};
                            for(int i=0,c=0;i<3;i++)
                                for(int j=0;j<3;j++,c++)
                                    cubeArray[5][i][j]=temp[cubeMap.get(c)];
                        }
                    } else {
                        for(int i=1;i<4;i++,side++) {
                            int temp[] = {cubeArray[side][0][set], cubeArray[side][1][set], cubeArray[side][2][set]};
                            if (side + 1 == 4)
                                side = 0;
                            cubeArray[side][0][set] = cubeArray[side-1][0][set];
                            cubeArray[side][1][set] = cubeArray[side-1][1][set];
                            cubeArray[side][2][set] = cubeArray[side-1][2][set];
                            int k=0;
                            for(int t:temp){
                                cubeArray[side+1][k][set]=t;
                                k++;
                            }
                        }
                        if(set==0){
                            int temp[]={cubeArray[4][0][0],cubeArray[4][0][1],cubeArray[4][0][2],
                                    cubeArray[4][1][0],cubeArray[4][1][1],cubeArray[4][1][2],
                                    cubeArray[4][2][0],cubeArray[4][2][1],cubeArray[4][2][2]};
                            for(int i=0,c=0;i<3;i++)
                                for(int j=0;j<3;j++,c++)
                                    cubeArray[4][i][j]=temp[cubeMap.get(cubeMap.get(c))];
                        }
                        else if(set==1){
                            int temp[]={cubeArray[0][0][1],cubeArray[0][1][1],cubeArray[0][2][1],
                                    cubeArray[1][0][1],cubeArray[1][1][1],cubeArray[1][2][1],
                                    cubeArray[2][0][1],cubeArray[2][1][1],cubeArray[2][2][1],
                                    cubeArray[3][0][1],cubeArray[3][1][1],cubeArray[3][2][1]};
                            for(int j = 0; j < 4; j++) {
                                for (int i = 0; i < 3; i++) {
                                    if(j==2)
                                        cubeArray[0][i][1]=temp[j+i-9];
                                    else
                                        cubeArray[0][i][1]=temp[j+i+3];
                                }
                            }
                        }
                        else{
                            int temp[]={cubeArray[5][0][0],cubeArray[5][0][1],cubeArray[5][0][2],
                                    cubeArray[5][1][0],cubeArray[5][1][1],cubeArray[5][1][2],
                                    cubeArray[5][2][0],cubeArray[5][2][1],cubeArray[5][2][2]};
                            for(int i=0,c=0;i<3;i++)
                                for(int j=0;j<3;j++,c++)
                                    cubeArray[5][i][j]=temp[cubeMap.get(cubeMap.get(c))];
                        }
                    }
                }
                else{
                    if(dimension){

                    }
                    else{

                    }
                }

            }
            case 4:
            case 5: {

            }
        }
    }
}
