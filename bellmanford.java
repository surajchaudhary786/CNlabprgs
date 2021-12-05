package CN_lab;
import java.util.*;

public class bellmanford{
  public static void main(String[] args){
      Scanner sc=new Scanner(System.in);
      int vert;
      System.out.println("Enter the NO. of vertices :");
      vert=sc.nextInt();
      int a[][]=new int[vert+1][vert+1];
      System.out.println("enter the weights;");
      for(int i=1;i<=vert;i++){
          for(int j=1;j<=vert;j++){
              a[i][j]=sc.nextInt();
              if(i!=j && a[i][j]==0){
                  a[i][j]=999;
              }
          }
      }
    //   for(int i=1;i<=vert;i++){
    //       for(int j=1;j<=vert;j++){
    //           System.out.print(a[i][j]+" ");
    //       }
    //       System.out.println("");
    //   }
      int dist[]=new int[vert+1];
      for(int i=1;i<=vert;i++){
          dist[i]=999;
      }
      System.out.println("enter the source :");
      int src;
      src=sc.nextInt();
      dist[src]=0;
      for(int d=1;d<=(vert-1);d++){
          for(int i=1;i<=vert;i++){
              for(int j=1;j<=vert;j++){
                 int u=i;
                 int v=j; 
                 if(a[i][j]!=999){
                 if(dist[v]>dist[u]+a[i][j] && dist[u]!=999){
                     dist[v]=dist[u]+a[i][j];
                 }
              }
            }
          }
      }
      for(int i=1;i<=vert;i++){
          System.out.print(dist[i]+" ");
      }
  }
}