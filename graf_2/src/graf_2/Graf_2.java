
package graf_2;

class MST{
    //graftaki düğüm sayisi
    private static final int V = 9;
    //MST ye henüz eklenmemiş bir dugümü bulma 
    int minKey (int key[], Boolean mstSet[]){
       int min = Integer.MAX_VALUE, min_index= -1;
       
       for(int v=0; v<V; v++) // parantez açılmamış yani tek satır dahil sonra diğerinde de aynı şekilde 
           if (mstSet[v]== false&& key[v]<min){
               min = key[v];
               min_index = v;
           }
       return min_index;
}
//parant[] dizinde tutulan MST yi cizdiren metot
    void printMST(int parent[], int graph[][]){
        System.out.println("Kenar \tAgirlik");
        for(int i=1; i<V; i++)
            System.out.println(parent[i]+"-"+i+"\t"+graph[i][parent[i]]);
    }

     void primMST(int graph[][]){
    //olusturulacak MST yi tutan dizi
    int parent[] = new int [V];
    
    // minimuum agırlıklı dugumu tutma
    int key[] = new int[V];
    //MST ye dahil edilen dugumleri gösterme
    Boolean mstSet[] = new Boolean[V];
    // butun anahtarlari sonsuz olarak baslat
    for(int i=0; i<V; i++){
        key[i]=Integer.MAX_VALUE;
        mstSet[i] = false; //ziyaret edilmemiş bir yerden buluyoruz
    }
    //daima ilk dugum icerir
    key[0]=0; //ilk duguun anahtarını sıfır yap
    parent[0]=-1; //ilk dugum kök olduğundan atası -1 olur
    
    for(int count=0; count < V -1 ; count++){
        //henuz MSTye dahil olmamıs dugumler kumesinden dugum secin
        int u = minKey(key, mstSet);
        //MST kumesine dugum ekle
        mstSet[u]=true;
        for(int v = 0; v<V; v++)
            if(graph[u][v]!=0 && mstSet[v] ==false && graph[u][v]<key[v]){ // sıfırdan farklıysa ikisi arasında yol var demek
        parent[v]=u; //u sıfırdı yani v 0.düğmden geçmiş diye düşün
        key[v]= graph[u][v];
            }
    }
    printMST(parent,graph);
}
}

public class Graf_2 {

   
    public static void main(String[] args) {
        MST t= new MST();
        int graph[][]= new int [][]{
            {0,4,0,0,0,0,0,8,0},
            {4,0,8,0,0,0,0,11,0},
            {0,8,0,7,0,4,0,0,2},
            {0,0,7,0,9,14,0,0,0},
            {0,0,0,9,0,10,0,0,0},
            {0,0,4,14,10,0,2,0,0},
            {0,0,0,0,0,2,0,1,6},
            {8,11,0,0,0,0,1,0,7},
            {0,0,2,0,0,0,6,7,0}
        };
        t.primMST(graph);
    }
    
}
