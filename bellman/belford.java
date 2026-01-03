import java.util.*;
class belford {
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter the number of verte: ");
        int n=sc.nextInt();
        int[][] graph=new int[n][n];
        System.out.print("Enter weight matrix(0 for no edge):\n");
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                graph[i][j]=sc.nextInt();
            }
        }
        System.out.print("Enter the source vertex (1-based): ");
        int src=sc.nextInt()-1;
        bellmanFord(graph,n,src);
        sc.close();
    }
    static void bellmanFord(int[][] graph,int n,int src){
        int[] dist=new int[n];
        for(int i=0;i<n;i++)
            dist[i]=Integer.MAX_VALUE;
        dist[src]=0;
        for(int i=0;i<n-1;i++){
            for(int u=0;u<n;u++){
                for(int v=0;v<n;v++){
                    if(graph[u][v]!=0 && dist[u]!=Integer.MAX_VALUE && dist[u]+graph[u][v]<dist[v])
                        dist[v]=dist[u]+graph[u][v];
                }
            }
        }
        for(int u=0;u<n;u++){
            for(int v=0;v<n;v++){
                if(graph[u][v]!=0 && dist[u]!=Integer.MAX_VALUE && dist[u]+graph[u][v]<dist[v]){
                    System.out.println("Negetive weigth found");
                    return;
                }
            }
        }
        System.out.print("Vertex Distance\n");
        for(int i=0;i<n;i++){
            if(dist[i]==Integer.MAX_VALUE)
                System.out.println((i+1)+"   INF");
            else
                System.out.println((i+1)+"      "+dist[i]);
        }
    }
}
