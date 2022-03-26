import java.io.*;
import java.util.*;
public class bellmanford {
    private int distance[];
    private int noofvertices;

   public bellmanford(int noofvertices) {
    this.noofvertices=noofvertices;
    distance= new int[noofvertices+1];
    }

public static void main(String args[]){
       int noofvertices=0,source;
       Scanner sc = new Scanner(System.in);
       System.out.println("no of vertices");
       noofvertices=sc.nextInt();
       int adjmatrix[][]=new int[noofvertices+1][noofvertices+1];
       System.out.println("enter the values");
       for(int i=1;i<=noofvertices;i++){
           for(int j=1;j<=noofvertices;j++){
               adjmatrix[i][j]=sc.nextInt();
               if(i==j){
                   adjmatrix[i][j]=0;
               }
               if(adjmatrix[i][j]==0){
                   adjmatrix[i][j]=999;
               }
           }
       }
       System.out.println("Enter the source node");
       source=sc.nextInt();
       bellmanford bf = new bellmanford(noofvertices);
       bf.bmf(source,adjmatrix);
   }

    public void bmf(int source, int[][] adj) {
        for(int node=1 ;node<=noofvertices;node++){
            distance[node]=999;
        }
        distance[source]=0;
        for(int node=1;node<=noofvertices;node++){
            for(int sn=1;sn<=noofvertices;sn++){
                for(int dn=1;dn<=noofvertices;dn++){
                    if(adj[sn][dn]!=999){
                        if(distance[dn]>distance[sn]+adj[sn][dn]){
                            distance[dn]=distance[sn]+adj[sn][dn];
                        }
                    }
                }
            }
        }
      //this is used to chech whether there is a negative edge 
        for(int node=1;node<=noofvertices;node++){
            for(int sn=1;sn<=noofvertices;sn++){
                for(int dn=1;dn<=noofvertices;dn++){
                    if(adj[sn][dn]!=999){
                        if(distance[dn]>distance[sn]+adj[sn][dn]){
                            distance[dn]=distance[sn]+adj[sn][dn];
                            System.out.println("graph contains negative cycle");
                            System.exit(0);//when there is a negative edge this code will exit from the whole program
                        }
                    }
                }
            }
        }
        for(int vertex=1;vertex<=noofvertices;vertex++){
            System.out.println("Distance from source to "+vertex+" is "+distance[vertex]);
        }
    }


 
}
