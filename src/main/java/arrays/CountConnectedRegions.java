package arrays;

/**
 * Given a boolean 2D matrix, find the number of islands.

 This is an variation of the standard problem: “Counting number of connected
 components in a undirected graph”.

 Before we go to the problem, let us understand what is a connected component
 . A connected component of an undirected graph is a subgraph in which every
 two vertices are connected to each other by a path(s),
 and which is connected to no other vertices outside the subgraph.
 For example, the graph shown below has three connected components.

 A graph where all vertices are connected with each other,
 has exactly one connected component, consisting of the whole graph. Such
 graph with only one connected component is called as Strongly Connected Graph.

 The problem can be easily solved by applying DFS() on each component. In
 each DFS() call, a component or a sub-graph is visited. We will call DFS on
 the next un-visited component. The number of calls to DFS() gives the number
 of connected components. BFS can also be used.

 What is an island?
 A group of connected 1s forms an island. For example,
 the below matrix contains 5 islands

 {1, 1, 0, 0, 0},
 {0, 1, 0, 0, 1},
 {1, 0, 0, 1, 1},
 {0, 0, 0, 0, 0},
 {1, 0, 1, 0, 1}
 A cell in 2D matrix can be connected to 8 neighbors. So,
 unlike standard DFS(), where we recursively call for all adjacent vertices,
 here we can recursive call for 8 neighbors only. We keep track of the
 visited 1s so that they are not visited again.
 */
public class CountConnectedRegions {


    public static void countIslandsByModifyingTheArray(int arr[][], int i, int j)
    {
        if(i < 0 || j < 0 )
            return;
        if(i >= arr.length)
            return;
        if(j >= arr[0].length)
            return;;
        if(arr[i][j] == 1){
            arr[i][j] = 0;
            countIslandsByModifyingTheArray(arr, i-1, j-1);
            countIslandsByModifyingTheArray(arr, i-1, j);
            countIslandsByModifyingTheArray(arr, i-1, j+1);
            countIslandsByModifyingTheArray(arr, i, j-1);
            countIslandsByModifyingTheArray(arr, i, j+1);
            countIslandsByModifyingTheArray(arr, i+1, j-1);
            countIslandsByModifyingTheArray(arr, i+1, j);
            countIslandsByModifyingTheArray(arr, i+1, j+1);
        }

    }

    public static void countIslandsWithoutModifyingTheArray(int arr[][],
                                                            boolean  visited[][],
                                                            int i, int j)
    {
        if(i < 0 || j < 0 )
            return;
        if(i >= arr.length)
            return;
        if(j >= arr[0].length)
            return;
        if(visited[i][j])
            return;
        if(arr[i][j] == 1){
            visited[i][j] = true;
            countIslandsWithoutModifyingTheArray(arr, visited,i-1, j-1);
            countIslandsWithoutModifyingTheArray(arr, visited,i-1, j);
            countIslandsWithoutModifyingTheArray(arr, visited,i-1, j+1);
            countIslandsWithoutModifyingTheArray(arr, visited,i, j-1);
            countIslandsWithoutModifyingTheArray(arr, visited,i, j+1);
            countIslandsWithoutModifyingTheArray(arr, visited,i+1, j-1);
            countIslandsWithoutModifyingTheArray(arr, visited,i+1, j);
            countIslandsWithoutModifyingTheArray(arr, visited,i+1, j+1);
        }

    }

    public static void main(String[] args) {
        int count = 0;
        int arr[][] = { {1, 1, 0, 0, 0},
                        {0, 1, 0, 0, 1},
                        {1, 0, 0, 1, 1},
                        {0, 0, 0, 0, 0},
                        {0, 1, 1, 0, 1}};
        boolean visited [][] = new boolean[5][5];
        for(int i =0; i < 5;i ++)
            for(int j = 0 ; j<5;j++)
                visited[i][j] = false;
        // without modifying the original array
        // uses auxillary boolean array to track which spaces have been visited
        for(int  i =0; i<5;i++){
            for(int j = 0; j<5;j++){
                if(arr[i][j] == 1 && !visited[i][j]){
                    count++;
                    countIslandsWithoutModifyingTheArray(arr,visited,i,j);
                }

            }
        }

        System.out.println("without modifying count = " + count);
        count = 0;
        // modify the original array
        for(int  i =0; i<5;i++){
            for(int j = 0; j<5;j++){
                if(arr[i][j] == 1) {
                    count++;
                    countIslandsByModifyingTheArray(arr,i,j);
                }

            }
        }

        System.out.println("after modifying count = " + count);
    }
}
