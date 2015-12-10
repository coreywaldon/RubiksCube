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
    //boolean dimension refers to up or down; up: true, down: false
    public void slide(int side, int set, boolean isRow, boolean dimension) {
        switch (side) {
            case 0:
            case 1:
            case 2:
            case 3: {
                if (!isRow) {
                    slideColumn(set, side, dimension);
                }
                else{
                    slideRow(set, side, dimension);
                }
            }
            case 4:
            case 5: {
                if(!isRow){
                    if(dimension){

                    }
                    else{
                        
                    }
                }
                else{
                    if(dimension){
                        if(set==0)
                            permuteFace(0, true);
                        else if(set==2)
                            permuteFace(2, true);
                        int[] sides = {1,3,4,5};
                        int currentSide=5;
                        for(int i=0;i<sides.length;i++) {
                            int temp[] = {cubeArray[i][set][0], cubeArray[i][set][1], cubeArray[i][set][2]};
                            cubeArray[sides[i]][set][0] = cubeArray[currentSide][set][0];
                            cubeArray[sides[i]][set][1] = cubeArray[currentSide][set][1];
                            cubeArray[sides[i]][set][2] = cubeArray[currentSide][set][2];
                            int k=0;
                            for(int t:temp) {
                                cubeArray[sides[i-1]][set][k] = t;
                                k++;
                            }
                            currentSide=sides[i];
                        }
                    }
                    else{
                        if(set==0)
                            permuteFace(0, false);
                        else if(set==2)
                            permuteFace(2, false);
                        int[] sides = {5,4,3,1};
                        int currentSide=1;
                        for(int i=0;i<sides.length;i++) {
                            int temp[] = {cubeArray[i][set][0], cubeArray[i][set][1], cubeArray[i][set][2]};
                            cubeArray[sides[i]][set][0] = cubeArray[currentSide][set][0];
                            cubeArray[sides[i]][set][1] = cubeArray[currentSide][set][1];
                            cubeArray[sides[i]][set][2] = cubeArray[currentSide][set][2];
                            int k=0;
                            for(int t:temp) {
                                cubeArray[sides[i+1]][set][k] = t;
                                k++;
                            }
                            currentSide=sides[i];
                        }
                    }
                }

            }
        }
    }
    public void permuteFace(int side, boolean pos){
        if(pos){
            int temp[]={cubeArray[side][0][0],cubeArray[side][0][1],cubeArray[side][0][2],
                    cubeArray[side][1][0],cubeArray[side][1][1],cubeArray[side][1][2],
                    cubeArray[side][2][0],cubeArray[side][2][1],cubeArray[side][2][2]};
            for(int i=0,c=0;i<3;i++)
                for(int j=0;j<3;j++,c++)
                    cubeArray[side][i][j]=temp[cubeMap.get(c)];
        }else{
            int temp[]={cubeArray[side][0][0],cubeArray[side][0][1],cubeArray[side][0][2],
                    cubeArray[side][1][0],cubeArray[side][1][1],cubeArray[side][1][2],
                    cubeArray[side][2][0],cubeArray[side][2][1],cubeArray[side][2][2]};
            for(int i=0,c=0;i<3;i++)
                for(int j=0;j<3;j++,c++)
                    cubeArray[side][i][j]=temp[cubeMap.get(cubeMap.get(c))];
        }
    }
    public void slideRow(int set, int side, boolean dimension){
        if(dimension){
            if(set==0){
                if(side==0)
                    permuteFace(3, true);
                else
                    permuteFace(side-1, true);
            }
            else if(set==2){
                if(side==3)
                    permuteFace(1,true);
                else
                    permuteFace(side+1,true);
            }
            for(int i=1;i<4;i++,side++) {
                int temp[] = {cubeArray[side][set][0], cubeArray[side][set][1], cubeArray[side][set][2]};
                int currentSide=side-1;
                if (side==0)
                    currentSide = 3;
                cubeArray[side][set][0] = cubeArray[currentSide][set][0];
                cubeArray[side][set][1] = cubeArray[currentSide][set][1];
                cubeArray[side][set][2] = cubeArray[currentSide][set][2];
                int k=0;
                for(int t:temp) {
                    cubeArray[side-1][set][k] = t;
                    k++;
                }
            }
        }
        else{
            if(set==0){
                if(side==0)
                    permuteFace(3, false);
                else
                    permuteFace(side-1, false);
            }
            else if(set==1){
            }
            else if(set==2) {
                if (side == 3)
                    permuteFace(1, false);
                else
                    permuteFace(side + 1, false);
            }
            for(int i=1;i<4;i++,side++) {
                int temp[] = {cubeArray[side][set][0], cubeArray[side][set][1], cubeArray[side][set][2]};
                int currentSide=side+1;
                if (side==3)
                    currentSide = 0;
                cubeArray[side][set][0] = cubeArray[currentSide][set][0];
                cubeArray[side][set][1] = cubeArray[currentSide][set][1];
                cubeArray[side][set][2] = cubeArray[currentSide][set][2];
                int k=0;
                for(int t:temp) {
                    cubeArray[side+1][set][k] = t;
                    k++;
                }
            }
        }
    }
    public void slideColumn(int set, int side, boolean dimension){
        if (dimension) {
            for(int i=1;i<4;i++,side++) {
                int temp[] = {cubeArray[side][0][set], cubeArray[side][1][set], cubeArray[side][2][set]};
                int currentSide=side-1;
                if (side==3)
                    currentSide = 0;
                cubeArray[side][0][set] = cubeArray[currentSide][0][set];
                cubeArray[side][1][set] = cubeArray[currentSide][1][set];
                cubeArray[side][2][set] = cubeArray[currentSide][2][set];
                int k=0;
                for(int t:temp) {
                    cubeArray[side - 1][k][set] = t;
                    k++;
                }
            }
            if(set==0){
                permuteFace(4,true);
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
                permuteFace(5,false);
            }
        } else {
            for(int i=1;i<4;i++,side++) {
                int temp[] = {cubeArray[side][0][set], cubeArray[side][1][set], cubeArray[side][2][set]};
                int currentSide=side-1;
                if (side==0)
                    currentSide = 3;
                cubeArray[side][0][set] = cubeArray[currentSide][0][set];
                cubeArray[side][1][set] = cubeArray[currentSide][1][set];
                cubeArray[side][2][set] = cubeArray[currentSide][2][set];
                int k=0;
                for(int t:temp){
                    cubeArray[side+1][k][set]=t;
                    k++;
                }
            }
            if(set==0){
                permuteFace(4,true);
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
                permuteFace(5, false);
            }
        }
    }
}
